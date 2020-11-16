package technology.innovation.aadharqrscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity {

    String value ="<br/>" +
            " <br/><br/><br/><u>Contact Us</u><br/><br/>" +
            " <b>Email Id</b> : hakeemit@gmail.com<br/><br/>" +
            " <b>Phone</b>    : +91 - 9789255335<br/><br/>" +
            " <b>Blog</b>     : <a href='http://hakeemit.blogspot.com'>hakeemit.blogspot.com</a><br/><br/>"+
            " <b>Twitter</b>  : <a href='http://twitter.com/hakeemit'>twitter.com/hakeemit</a><br/><br/><br/>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        TextView textView = (TextView) findViewById(R.id.contact_us_text);

        Spanned text = Html.fromHtml(value);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(text);

    }
}
