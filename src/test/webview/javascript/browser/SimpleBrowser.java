package test.webview.javascript.browser;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import test.webview.javascript.R;

/**
 * Created by Administrator on 2015/6/12.
 */
public class SimpleBrowser extends Activity {

    private TextView mPageTitle;

    private ProgressBar mLoadingProgress;

    private WebView mBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_simple_browser);

        mPageTitle = (TextView) findViewById(R.id.pageTitle);
        mLoadingProgress = (ProgressBar) findViewById(R.id.loadingProgress);
        mBrowser = (WebView) findViewById(R.id.browser);


    }
}
