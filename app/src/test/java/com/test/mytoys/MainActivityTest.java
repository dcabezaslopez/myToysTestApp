package com.test.mytoys;

import android.test.ActivityInstrumentationTestCase2;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.test.mytoys.utils.Constants;
import com.test.mytoys.view.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by david on 8/9/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private static final String VALID_URL = Constants.BASE_URL;
    private static final String INVALID_URL = "http://invalid.url.doesnotexist987.com";
    private static final long TIMEOUT = 5000;

    @Mock
    private WebView mWeb;
    @Mock
    private WebViewClient mMockWebViewClient;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Test
    public final void testLoadValidUrl() {

        assertLoadUrl(VALID_URL);

    }

    private void assertLoadUrl(String url) {
        mWeb.loadUrl(url);
        sleep();

        //Added to hopefully let webview load all the way
        getInstrumentation().waitForIdleSync();

        assertTrue(!(mWeb.getProgress() < 100));
    }

    private void sleep() {
        try {
            Thread.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            fail("Unexpected timeout");
        }
    }

}
