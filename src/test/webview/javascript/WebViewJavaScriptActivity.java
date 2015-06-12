package test.webview.javascript;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class WebViewJavaScriptActivity extends Activity {

	private WebView browser;
	private EditText nameET;
	private Button jsButton;
	private String androidETName;
	private JSTest JSAndroidBindingClass = new JSTest();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		androidETName = "unknown";
		browser = (WebView) findViewById(R.id.webView1);
		nameET = (EditText) findViewById(R.id.editText1);
		jsButton = (Button) findViewById(R.id.button1);
		browser.getSettings().setJavaScriptEnabled(true);
		browser.setWebChromeClient(new WebChromeClient());
		browser.addJavascriptInterface(JSAndroidBindingClass, "locater");
		browser.loadUrl("file:///android_asset/test.html");
		browser.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
				case MotionEvent.ACTION_UP:
					if (!v.hasFocus()) {
						v.requestFocus();
					}
					break;
				}
				return false;
			}

		});
		jsButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				androidETName = nameET.getText().toString();
				if (androidETName == null)
					androidETName = "unknown";
				callJSHelloMethod(androidETName);
				browser.requestFocus(View.FOCUS_DOWN);

			}
		});
	}

	private void callJSHelloMethod(String name) {
		browser.loadUrl("javascript:sayHelloFromJS('" + name + "')");
	}

	public class JSTest {

		public String getNameFromAndroidET() {
			return androidETName;
		}

		public void sayHelloFromAndroid(String actualData) {
			if (actualData == null)
				actualData = "unknown";
			if (actualData.length() < 1)
				actualData = "unknown";

			new AlertDialog.Builder(WebViewJavaScriptActivity.this)
					.setTitle("Android method called from JavaScript !")
					.setMessage(
							"Android Says: Hello " + actualData
									+ " !!! How are you.")
					.setPositiveButton(android.R.string.ok,
							new AlertDialog.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									// do your stuff

								}
							}).setCancelable(false).create().show();
		}
	}
}