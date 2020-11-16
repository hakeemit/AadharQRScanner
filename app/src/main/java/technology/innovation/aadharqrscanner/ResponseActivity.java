package technology.innovation.aadharqrscanner;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResponseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        TextView textView = (TextView) findViewById(R.id.textView);
        final TextView qr_responseCode = (TextView) findViewById(R.id.qr_responseCode);
        //ImageView imageView= (ImageView) findViewById(R.id.imagePreview);

        Button btn_save = (Button) findViewById(R.id.save);
        Button btn_copy = (Button) findViewById(R.id.copy);
        //Button btn_app = (Button) findViewById(R.id.openApp);
        Button btn_share = (Button) findViewById(R.id.share);

        Intent intent=getIntent();

        final String value = intent.getStringExtra("category");
        textView.setText("QR Detected :"+value );
        qr_responseCode.setText(intent.getStringExtra("data"));
        qr_responseCode.setAutoLinkMask(0);
        Linkify.addLinks(qr_responseCode,Linkify.ALL);


        btn_share.setEnabled(true);

        if(value !=null && value.equalsIgnoreCase("Google Maps")){
            //imageView.setImageResource(R.drawable.google_maps);
            //btn_app.setEnabled(true);
            //btn_save.setEnabled(true);
            btn_copy.setEnabled(true);
        }else if(value !=null && value.equalsIgnoreCase("Website Link")){
            //imageView.setImageResource(R.drawable.www);
            //btn_app.setEnabled(true);
            //btn_save.setEnabled(true);
            btn_copy.setEnabled(true);
        }else if(value !=null && value.equalsIgnoreCase("Email Id")){
            //imageView.setImageResource(R.drawable.mail);
            //btn_app.setEnabled(false);
            //btn_save.setEnabled(true);
            btn_copy.setEnabled(true);
        }else if(value !=null && value.equalsIgnoreCase("Unknown")){
            textView.setText("QR Detected : Text");
            //imageView.setImageResource(R.drawable.note);
            //btn_app.setEnabled(false);
            //btn_save.setEnabled(true);
            btn_copy.setEnabled(true);
        }else if(value !=null && value.equalsIgnoreCase("No Barcode")){
            textView.setText("No Barcode Detected");
            //btn_app.setEnabled(false);
            //btn_save.setEnabled(false);
            btn_copy.setEnabled(false);
            btn_share.setEnabled(false);
        }







        btn_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Info", qr_responseCode.getText().toString());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(ResponseActivity.this, "Text copied", Toast.LENGTH_LONG).show();
            }
        });

       /* btn_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(value !=null && value.equalsIgnoreCase("Google Maps")){
                    Intent intent=new Intent(ResponseActivity.this, GoogleMapsActivity.class);
                    intent.putExtra("weburl",value);
                    startActivity(intent);
                    //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(value));
                    //intent.setClassName("com.google.android.apps.maps","com.google.android.maps.MapsActivity");
                    //startActivity(intent);
                }else if(value !=null && value.equalsIgnoreCase("Website Link")){
                    Intent intent=new Intent(ResponseActivity.this, WebURLActivity.class);
                    intent.putExtra("weburl",value);
                    startActivity(intent);
                }
            }
        });*/


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //try {
               //   OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
               //   outputStreamWriter.write(data);
               //   outputStreamWriter.close();
               // }
               // catch (IOException e) {
               //     Log.e("Exception", "File write failed: " + e.toString());
               // }
            }
        });


        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Smart QR Scanner");
                String sAux = "\nScan All Types of QR & Barcode\n\n";
                sAux = sAux + qr_responseCode.getText().toString();
                //sAux = sAux + "https://play.google.com/store/apps/details?id=technology.innovation.expensesmanagement \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "Select App"));
            }
        });


    }
}
