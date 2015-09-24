package net.allstack.allenmo.browser1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser=(WebView)findViewById(R.id.webkit);
        browser.setWebViewClient(new Callback());
        loadTime();

        browser.getSettings().setJavaScriptEnabled(true);
        browser.canGoBack();
        browser.canGoForward();
        browser.canGoBackOrForward(20);
        //browser.loadUrl("http://allstack.net");
        //browser.loadUrl("http://192.168.1.4/webel/");
        //browser.loadData("<html><body>Welcom to Geek's web</body></html>","text/html", "UTF-8");
    }

    void loadTime(){
        String page="<html><body><a href=\"clock\">" + new Date().toString() + "</a></body></html>";
        browser.loadDataWithBaseURL("x-data://base",page, "text/html","UTF-8",null);
    }

    private class Callback extends WebViewClient{
        public  boolean shouldOverrideUrlLoading(WebView view, String url){
            loadTime();
            return (true);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
