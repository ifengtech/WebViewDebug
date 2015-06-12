package test.webview.javascript;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

public class WebViewJavaScriptActivity1 extends Activity {

	private WebView browser;
	private TextView titlebar;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webviewclient);
		titlebar = (TextView) findViewById(R.id.titlebar);
		browser = (WebView) findViewById(R.id.mywebView);
		browser.getSettings().setJavaScriptEnabled(true);
		browser.getSettings().setBuiltInZoomControls(true);
		browser.setWebChromeClient(new MyWebChromeClient());
		browser.loadUrl("file:///android_asset/testjavascript.html");
	}

	private class MyWebChromeClient extends WebChromeClient {
		@Override
		public boolean onJsAlert(WebView view, String url, String message,
				final JsResult result) {
			new AlertDialog.Builder(WebViewJavaScriptActivity1.this)
					.setTitle("JavaScript Alert !")
					.setMessage(message)
					.setPositiveButton(android.R.string.ok,
							new AlertDialog.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									// do your stuff
									result.confirm();
								}
							}).setCancelable(false).create().show();
			return true;
		}

		@Override
		public boolean onJsConfirm(WebView view, String url, String message,
				final JsResult result) {
			new AlertDialog.Builder(WebViewJavaScriptActivity1.this)
					.setTitle("JavaScript Confirm Alert !")
					.setMessage(message)
					.setPositiveButton(android.R.string.ok,
							new AlertDialog.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									// do your stuff
									result.confirm();
								}
							}).setCancelable(false).create().show();
			return true;
		}

		@Override
		public boolean onJsPrompt(WebView view, String url, String message,
				String defaultValue, final JsPromptResult result) {
			new AlertDialog.Builder(WebViewJavaScriptActivity1.this)
					.setTitle("JavaScript Prompt Alert !")
					.setMessage(message)
					.setPositiveButton(android.R.string.ok,
							new AlertDialog.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									// do your stuff
									result.confirm();
								}
							}).setCancelable(false).create().show();
			return true;
		}
	}

}
