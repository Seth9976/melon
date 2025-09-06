package com.iloen.melon.custom;

import android.webkit.ValueCallback;
import android.webkit.WebView;

public interface MelonWebViewListener {
    void addOrPlay(boolean arg1, String arg2, String arg3, String arg4);

    void playMixUp(String arg1, String arg2, String arg3);

    void requestCommand(String arg1, String arg2, String arg3, String arg4);

    void restoreScreenRotation();

    boolean shouldOverrideUrlLoading(WebView arg1, String arg2);

    boolean showFileChooser(WebView arg1, ValueCallback arg2, Object arg3);
}

