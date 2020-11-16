package technology.innovation.aadharqrscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class TransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        WebView browser = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.clearCache(true);
        browser.clearHistory();
        browser.computeScroll();
        browser.loadUrl("about:blank");
        browser.loadUrl("http://resident.uidai.gov.in/notification-aadhaar");

        // Load an ad into the AdMob banner view.
//        AdView adView = (AdView) findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder()
//                .setRequestAgent("android_studio:ad_template").build();
//        adView.loadAd(adRequest);

        // Toasts the test ad message on the screen. Remove this after defining your own ad unit ID.
 //      Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_LONG).show();
    }
}
