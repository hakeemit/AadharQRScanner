package technology.innovation.aadharqrscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    String value ="<br/> Abul Hakeem holds an Engineering degree in Information Technology from Anna University and has " +
            "previously worked at DXC Technology (Computer Sciences Corporation) for client like Fiat Chrysler Automobiles. " +
            "Totally he has 7+ years of work experience in IT industry as Software Engineer " +
            "and now he is working as Freelancer to create his own products which can be distributed to the global market.<br/>" +
            "<br/><br/><b><u> Experience </u></b><br/>" +
            "<br/><br/><b> Presently</b><br/>" +
            "Blogger, Android, iOS & Windows App Developer as Freelancer <br/>" +
            "HIT - Hakeem Innovation Technology <br/><br/>" +
            "<b> Experience 5 - 6.10 Years</b><br/>" +
            " Professional I - Application Delivery <br/>" +
            " Computer Sciences Corporation at Chennai, India<br/>" +
            " Skills - Sybase ASE 12.5 & 15.5,  Java, Unix, Db2, Cron tab <br/>" +
            "<br/><br/>" +
            "<b> Experience 3.3 - 5 Years</b><br/>" +
            " Technical Lead <br/>" +
            " Sama Sar at Riyadh, Kingdom of Saudi Arabia<br/>" +
            " Skills - Google Web Toolkit, Sencha GXT, Jboss AS 7, MySQL, Java, J2EE, Linux, AWS, HTML and CSS<br/>" +
            "<br/><br/>" +
            "<b> Experience Fresher - 3.3 Years</b><br/>" +
            " Software Developer <br/>" +
            " Ethical Intelligent Technology at Chennai, India  <br/>" +
            " Skills - Google Web Toolkit, Sencha GXT, Jboss AS 7, MySQL, Java and J2EE</i>" +
            "<br/><br/>" +
            "<br/>" +
            "<br/><br/>" +
            "Thanks with Regards,<br/>" +
            "Abdul Hakeem. H., B.Tech<br/><br/>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        TextView textView = (TextView) findViewById(R.id.about_us_text);

        Spanned text = Html.fromHtml(value);

        textView.setText(text);

    }
}
