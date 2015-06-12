package test.webview.javascript;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

public class WebChromeActivity extends Activity {
	private WebView browser;	
	private TextView titlebar;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.webviewclient);
		titlebar = (TextView)findViewById(R.id.titlebar);	
		titlebar.setVisibility(View.GONE);
		browser = (WebView) findViewById(R.id.mywebView);
		browser.getSettings().setJavaScriptEnabled(true);
		browser.getSettings().setBuiltInZoomControls(true);
		browser.setWebChromeClient(new MyWebChromeClient());
		browser.loadUrl("http://developer.samsung.com/resources.do");

	}

	private class MyWebChromeClient extends WebChromeClient {
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			// TODO Auto-generated method stub
			super.onProgressChanged(view, newProgress);
			setProgress(newProgress * 100);
		}
	}

}
