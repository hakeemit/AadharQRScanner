package technology.innovation.aadharqrscanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // use a compound button so either checkbox or switch widgets work.
    private CompoundButton autoFocus;
    private CompoundButton useFlash;
  //  private TextView statusMessage;
 //   private TextView barcodeValue;

    private static final int RC_BARCODE_CAPTURE = 9001;
    private static final String TAG = "BarcodeMain";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   statusMessage = (TextView)findViewById(R.id.status_message);
     //   barcodeValue = (TextView)findViewById(R.id.barcode_value);

        autoFocus = (CompoundButton) findViewById(R.id.auto_focus);
        useFlash = (CompoundButton) findViewById(R.id.use_flash);

        ImageButton btn_barscan = (ImageButton) findViewById(R.id.read_barcode);


        btn_barscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BarcodeCaptureActivity.class);
                intent.putExtra(BarcodeCaptureActivity.AutoFocus, autoFocus.isChecked());
                intent.putExtra(BarcodeCaptureActivity.UseFlash, useFlash.isChecked());

                startActivityForResult(intent, RC_BARCODE_CAPTURE);
            }
        });



    }

    /**
     * Called when an activity you launched exits, giving you the requestCode
     * you started it with, the resultCode it returned, and any additional
     * data from it.  The <var>resultCode</var> will be
     * {@link #RESULT_CANCELED} if the activity explicitly returned that,
     * didn't return any result, or crashed during its operation.
     * <p/>
     * <p>You will receive this call immediately before onResume() when your
     * activity is re-starting.
     * <p/>
     *
     * @param requestCode The integer request code originally supplied to
     *                    startActivityForResult(), allowing you to identify who this
     *                    result came from.
     * @param resultCode  The integer result code returned by the child activity
     *                    through its setResult().
     * @param data        An Intent, which can return result data to the caller
     *                    (various data can be attached to Intent "extras").
     * @see #startActivityForResult
     * @see #createPendingResult
     * @see #setResult(int)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == RC_BARCODE_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                Intent intent = new Intent(MainActivity.this, AadharDetails.class);
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);

          //          statusMessage.setText(R.string.barcode_success);
            //        barcodeValue.setText(barcode.displayValue);
                    intent.putExtra("category",R.string.barcode_success);
                    intent.putExtra("data",barcode.displayValue);
                    if (barcode.displayValue.length() > 0){
                        String value =barcode.displayValue.toString();

                    }
                    startActivity(intent);
                    Log.d(TAG, "Barcode read: " + barcode.displayValue);
                } else {
                   // statusMessage.setText("No Barcode");
                    intent.putExtra("category","No Aadhar Barcode");
                    Log.d(TAG, "No Aadhar barcode captured, intent data is null");
                }
            } else {
               // statusMessage.setText(String.format(getString(R.string.barcode_error),
                //        CommonStatusCodes.getStatusCodeString(resultCode)));
                Toast.makeText(MainActivity.this, "\"No Aadhar barcode captured, intent data is null\"", Toast.LENGTH_LONG).show();
            }


        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about_us_menu) {
            Intent intent=new Intent(MainActivity.this, AboutUs.class);
            startActivity(intent);

            return true;
        }

        else if (id == R.id.contact_us_menu) {
            Intent intent=new Intent(MainActivity.this, ContactUs.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.share_app_menu) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Aadhaar QR Scanner");
            String sAux = "\nYou can extract your Aadhaar informaiton from Aadhaar QR Code.\n Highly recommended application.\n\n";
            sAux = sAux + "https://play.google.com/store/apps/details?id=technology.innovation.aadharqrscanner \n\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "Select App"));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        item.setChecked(true);

        if (id == R.id.contact_us) {
            Intent intent=new Intent(MainActivity.this, ContactUs.class);
            startActivity(intent);

        } else if (id == R.id.about_us) {
            Intent intent=new Intent(MainActivity.this, AboutUs.class);
            startActivity(intent);
        }   else if (id == R.id.share_app) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Aadhaar QR Scanner");
            String sAux = "\nYou can extract your Aadhaar informaiton from Aadhaar QR Code.\n Highly recommended application.\n\n";
            sAux = sAux + "https://play.google.com/store/apps/details?id=technology.innovation.aadharqrscanner \n\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "Select App"));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
