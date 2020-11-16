package technology.innovation.aadharqrscanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;


public class AadharDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhar_details);

        Intent intent=getIntent();
//        intent.getStringExtra("category");
        String data = intent.getStringExtra("data");
        //
        String[] split = data.split("=");

        if (split.length > 1){


            EditText uniqueIdText = (EditText) findViewById(R.id.uniqueIdText);
            EditText nameText = (EditText) findViewById(R.id.nameText);
            EditText genderText = (EditText) findViewById(R.id.genderText);
            EditText coText = (EditText) findViewById(R.id.coText);
            EditText streetText = (EditText) findViewById(R.id.streetText);
            EditText lmText = (EditText) findViewById(R.id.lmText);
            EditText vtcText = (EditText) findViewById(R.id.vtcText);
            EditText poText = (EditText) findViewById(R.id.poText);
            EditText districtText = (EditText) findViewById(R.id.districtText);
            EditText stateText = (EditText) findViewById(R.id.stateText);
            EditText pincodeText = (EditText) findViewById(R.id.pincodeText);
            EditText dobText = (EditText) findViewById(R.id.dobText);


            Log.d("Tag", split[0]);
            String uid = split[3].replace(" name", "").replace("\"","");
            String name = split[4].replace(" gender", "").replace("\"","");
            String gender = split[5].replace(" yob", "").replace("\"","");
            String co = split[8].replace(" house", "").replace("\"","");
            String house = split[9].replace(" street", "").replace("\"","");
            String street = split[10].replace(" loc", "").replace("\"","");
            String loc = split[11].replace(" vtc", "").replace("\"","");
            String vtc = split[12].replace(" po", "").replace("\"","");
            String po = split[13].replace(" dist", "").replace("\"","");

            String dist = "";
            String state = "";
            String pc = "";
            String dob = "";

            if(split[14].toString().contains("subdist")){
                dist = split[15].replace(" state", "").replace("\"","");
                state = split[16].replace(" pc", "").replace("\"","");
                pc = split[17].replace(" dob", "").replace("\"","");
                dob = split[18].replace("/>", "").replace("\"","");
            }else{
                dist = split[14].replace(" state", "").replace("\"","");
                state = split[15].replace(" pc", "").replace("\"","");
                pc = split[16].replace(" dob", "").replace("\"","");
                dob = split[17].replace("/>", "").replace("\"","");

            }


            uniqueIdText.setFocusable(false);
            nameText.setFocusable(false);
            genderText.setFocusable(false);
            coText.setFocusable(false);
            streetText.setFocusable(false);
            lmText.setFocusable(false);
            vtcText.setFocusable(false);
            poText.setFocusable(false);
            districtText.setFocusable(false);
            stateText.setFocusable(false);
            pincodeText.setFocusable(false);
            dobText.setFocusable(false);

            uniqueIdText.setText(uid);
            nameText.setText(name);
            genderText.setText(gender);
            coText.setText(co);
            streetText.setText(house + "," + street);
            lmText.setText(loc);
            vtcText.setText(vtc);
            poText.setText(po);

            districtText.setText(dist);
            stateText.setText(state);
            pincodeText.setText(pc);
            dobText.setText(dob);


        }
    }
}
