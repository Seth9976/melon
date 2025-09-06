package com.iloen.melon.eventbus;

import android.net.Uri;

public class EventWebViewClose {
    public static class CloseAllView extends EventWebViewClose {
        public Uri openUri;

        public CloseAllView() {
        }

        public CloseAllView(Uri uri0) {
            this.openUri = uri0;
        }
    }

    public static class CloseView extends EventWebViewClose {
        public Uri openUri;

        public CloseView() {
        }

        public CloseView(Uri uri0) {
            this.openUri = uri0;
        }
    }

    public static final String A = "A";
    public static final String B = "B";
    public static final String N = "N";
    public static final String Y = "Y";

}

