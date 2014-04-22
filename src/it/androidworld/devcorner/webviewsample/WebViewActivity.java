package it.androidworld.devcorner.webviewsample;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.os.Build;

public class WebViewActivity extends ActionBarActivity {

	WebView webView;
	Bundle extra;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);

		webView = (WebView) findViewById(R.id.webView1);
		extra = getIntent().getExtras();
		if (null != extra.getString("sito")) {
			webView.getSettings().setJavaScriptEnabled(true);
			webView.loadUrl(extra.getString("sito"));

		} else if (null != extra.getString("customHtml")) {
			String customHtml = extra.getString("customHtml");
			webView.loadData(customHtml, "text/html", "UTF-8");
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
