package com.kakao.tiara;

public class TiaraConfiguration {
    public static class Builder {
        private String[] cookieDomains;
        private boolean isAppLogBlocked;
        private boolean isCookieEnabled;
        private boolean isCookieSyncAtInstanceEnabled;
        private String serverUrl;
        private int sessionTimeout;

        public Builder() {
            this.sessionTimeout = -1;
            this.isCookieEnabled = false;
            this.isCookieSyncAtInstanceEnabled = true;
            this.isAppLogBlocked = false;
        }

        public static boolean access$000(Builder tiaraConfiguration$Builder0) {
            return tiaraConfiguration$Builder0.isCookieEnabled;
        }

        public static boolean access$100(Builder tiaraConfiguration$Builder0) {
            return tiaraConfiguration$Builder0.isCookieSyncAtInstanceEnabled;
        }

        public static boolean access$200(Builder tiaraConfiguration$Builder0) {
            return tiaraConfiguration$Builder0.isAppLogBlocked;
        }

        public static String access$300(Builder tiaraConfiguration$Builder0) {
            return tiaraConfiguration$Builder0.serverUrl;
        }

        public static String[] access$400(Builder tiaraConfiguration$Builder0) {
            return tiaraConfiguration$Builder0.cookieDomains;
        }

        public static int access$500(Builder tiaraConfiguration$Builder0) {
            return tiaraConfiguration$Builder0.sessionTimeout;
        }

        public Builder blockAppLog() {
            this.isAppLogBlocked = true;
            return this;
        }

        public TiaraConfiguration build() {
            return new TiaraConfiguration(this, null);
        }

        public Builder cookieDomains(String[] arr_s) {
            this.cookieDomains = arr_s;
            return this;
        }

        public Builder serverUrl(String s) {
            this.serverUrl = s;
            return this;
        }

        public Builder sessionTimeout(int v) {
            this.sessionTimeout = v;
            return this;
        }

        public Builder setCookieSyncAtInstanceEnabled(boolean z) {
            this.isCookieSyncAtInstanceEnabled = z;
            return this;
        }

        public Builder syncTiaraUserToWebview(boolean z) {
            this.isCookieEnabled = z;
            return this;
        }
    }

    static final int DEFAULT_SESSION_TIMEOUT_SECONDS = 300;
    private String[] cookieDomains;
    private boolean isAppLogBlocked;
    private boolean isCookieEnabled;
    private boolean isCookieSyncAtInstanceEnabled;
    private String serverUrl;
    private int sessionTimeout;

    private TiaraConfiguration(Builder tiaraConfiguration$Builder0) {
        this.sessionTimeout = 300;
        this.isCookieEnabled = Builder.access$000(tiaraConfiguration$Builder0);
        this.isCookieSyncAtInstanceEnabled = Builder.access$100(tiaraConfiguration$Builder0);
        this.isAppLogBlocked = Builder.access$200(tiaraConfiguration$Builder0);
        this.serverUrl = Builder.access$300(tiaraConfiguration$Builder0);
        this.cookieDomains = Builder.access$400(tiaraConfiguration$Builder0);
        if(Builder.access$500(tiaraConfiguration$Builder0) < 0) {
            return;
        }
        this.sessionTimeout = Builder.access$500(tiaraConfiguration$Builder0);
    }

    public TiaraConfiguration(Builder tiaraConfiguration$Builder0, com.kakao.tiara.TiaraConfiguration.1 tiaraConfiguration$10) {
        this(tiaraConfiguration$Builder0);
    }

    public String[] getCookieDomains() {
        return this.cookieDomains;
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

    public int getSessionTimeout() {
        return this.sessionTimeout;
    }

    public boolean isAppLogBlocked() {
        return this.isAppLogBlocked;
    }

    public boolean isCookieEnabled() {
        return this.isCookieEnabled;
    }

    public boolean isCookieSyncAtInstanceEnabled() {
        return this.isCookieSyncAtInstanceEnabled;
    }

    class com.kakao.tiara.TiaraConfiguration.1 {
    }

}

