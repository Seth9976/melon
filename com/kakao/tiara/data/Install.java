package com.kakao.tiara.data;

import U4.x;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class Install {
    public static class Builder {
        Map properties;

        public Builder() {
            this.properties = new HashMap();
        }

        public Install build() {
            if(this.properties.isEmpty()) {
                return null;
            }
            Install install0 = new Install(null);
            install0.referrer = (String)this.properties.get("referrer");
            install0.utm_campaign = (String)this.properties.get("utm_campaign");
            install0.utm_source = (String)this.properties.get("utm_source");
            install0.utm_medium = (String)this.properties.get("utm_medium");
            install0.utm_term = (String)this.properties.get("utm_term");
            install0.utm_content = (String)this.properties.get("utm_content");
            install0.referrer_click_timestamp_seconds = (String)this.properties.get("referrer_click_timestamp_seconds");
            install0.begin_timestamp_seconds = (String)this.properties.get("begin_timestamp_seconds");
            install0.first_launch_timestamp_seconds = (String)this.properties.get("first_launch_timestamp_seconds");
            return install0;
        }

        public Builder campaign(String s) {
            this.put("utm_campaign", s);
            return this;
        }

        public Builder content(String s) {
            this.put("utm_content", s);
            return this;
        }

        public Builder firstLaunchTime(String s) {
            this.put("first_launch_timestamp_seconds", s);
            return this;
        }

        public Builder installBeginTime(String s) {
            this.put("begin_timestamp_seconds", s);
            return this;
        }

        public Builder medium(String s) {
            this.put("utm_medium", s);
            return this;
        }

        private void put(String s, String s1) {
            if(TextUtils.isEmpty(s1)) {
                return;
            }
            this.properties.put(s, s1);
        }

        public Builder referrer(String s) {
            this.put("referrer", s);
            return this;
        }

        public Builder referrerClickTime(String s) {
            this.put("referrer_click_timestamp_seconds", s);
            return this;
        }

        public Builder source(String s) {
            this.put("utm_source", s);
            return this;
        }

        public Builder term(String s) {
            this.put("utm_term", s);
            return this;
        }
    }

    private static final String KEY_CAMPAIGN = "utm_campaign";
    private static final String KEY_CONTENT = "utm_content";
    private static final String KEY_FIRST_LAUNCH_TIME = "first_launch_timestamp_seconds";
    private static final String KEY_INSTALL_BEGIN_TIME = "begin_timestamp_seconds";
    private static final String KEY_MEDIUM = "utm_medium";
    private static final String KEY_REFERRER = "referrer";
    private static final String KEY_REFERRER_CLICK_TIME = "referrer_click_timestamp_seconds";
    private static final String KEY_SOURCE = "utm_source";
    private static final String KEY_TERM = "utm_term";
    private String begin_timestamp_seconds;
    private String first_launch_timestamp_seconds;
    private String referrer;
    private String referrer_click_timestamp_seconds;
    private String utm_campaign;
    private String utm_content;
    private String utm_medium;
    private String utm_source;
    private String utm_term;

    private Install() {
    }

    public Install(com.kakao.tiara.data.Install.1 install$10) {
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Install{referrer=\'");
        stringBuilder0.append(this.referrer);
        stringBuilder0.append("\', utm_campaign=\'");
        stringBuilder0.append(this.utm_campaign);
        stringBuilder0.append("\', utm_source=\'");
        stringBuilder0.append(this.utm_source);
        stringBuilder0.append("\', utm_medium=\'");
        stringBuilder0.append(this.utm_medium);
        stringBuilder0.append("\', utm_term=\'");
        stringBuilder0.append(this.utm_term);
        stringBuilder0.append("\', utm_content=\'");
        stringBuilder0.append(this.utm_content);
        stringBuilder0.append("\', referrer_click_timestamp_seconds=\'");
        stringBuilder0.append(this.referrer_click_timestamp_seconds);
        stringBuilder0.append("\', begin_timestamp_seconds=\'");
        stringBuilder0.append(this.begin_timestamp_seconds);
        stringBuilder0.append("\', first_launch_timestamp_seconds=\'");
        return x.m(stringBuilder0, this.first_launch_timestamp_seconds, "\'}");
    }

    class com.kakao.tiara.data.Install.1 {
    }

}

