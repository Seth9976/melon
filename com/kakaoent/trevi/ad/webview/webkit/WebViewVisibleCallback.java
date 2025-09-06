package com.kakaoent.trevi.ad.webview.webkit;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000F\u0010\u0007\u001A\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/webkit/WebViewVisibleCallback;", "", "", "isForeground", "()Z", "isDestroyed", "Lie/H;", "destroyWebView", "()V", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface WebViewVisibleCallback {
    void destroyWebView();

    boolean isDestroyed();

    boolean isForeground();
}

