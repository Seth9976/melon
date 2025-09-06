package com.iloen.melon.eventbus;

import android.net.Uri;

public class EventWebView {
    public static class CloseAndGoAppHome extends EventWebView {
        public String targetUrl;

    }

    public static class DialogClose extends EventWebView {
    }

    public static class Error extends EventWebView {
    }

    public static class HistoryClear extends EventWebView {
    }

    public static class InputMethodVisible extends EventWebView {
        private final boolean mVisible;

        public InputMethodVisible(boolean z) {
            this.mVisible = z;
        }

        public boolean isVisible() {
            return this.mVisible;
        }
    }

    public static class KakaoEmoticonPopup extends EventWebView {
    }

    public static class Load extends EventWebView {
    }

    public static class OpenUri extends EventWebView {
        private Uri uri;

        public OpenUri(Uri uri0) {
            this.uri = uri0;
        }

        public Uri getUri() {
            return this.uri;
        }
    }

    public static class OpenUrl extends EventWebView {
        public static final int LOAD_ON_DIALOG = 1;
        public static final int LOAD_ON_FRAGMENT;
        public String screenMode;
        public String url;
        public int webMode;

    }

    public static class PagerPagingEnabled extends EventWebView {
        public boolean isEnabled;

    }

    @Deprecated(since = "24.02.07 - 미사용 이벤트로 확인됨.")
    public static class Reload extends EventWebView {
    }

    public static class ShowPayAppInstall extends EventWebView {
        public static final int TYPE_BANK_PAY = 1;
        public static final int TYPE_ISP;
        public int type;

    }

    public static class UncheckAll extends EventWebView {
    }

    public static class WebViewChromeSslCertIssueAlert extends EventWebView {
    }

}

