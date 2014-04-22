package it.androidworld.devcorner.webviewsample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends ActionBarActivity implements OnClickListener{

	ImageButton awButton;
	ImageButton customButton;
	Context ctx;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		awButton = (ImageButton) findViewById(R.id.aw);
		customButton = (ImageButton) findViewById(R.id.dc);
		awButton.setOnClickListener(this);
		customButton.setOnClickListener(this);
		ctx = this;
		
	}

	@Override
	public void onClick(View v) {
		Intent webIntent = new Intent(ctx,WebViewActivity.class);
		if(v.getId()==awButton.getId())
		{
			webIntent.putExtra("sito", "http://www.androidworld.it");
		}else if(v.getId()==customButton.getId())
		{
			webIntent.putExtra("customHtml", "<html><p>Ciao mondo, sono una scritta random!<p></html>");
		}
		startActivity(webIntent);
		
	};
	
	

}
