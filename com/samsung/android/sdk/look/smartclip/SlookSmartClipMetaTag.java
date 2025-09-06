package com.samsung.android.sdk.look.smartclip;

public class SlookSmartClipMetaTag {
    public static final String TAG_TYPE_APP_DEEP_LINK = "app_deep_link";
    public static final String TAG_TYPE_PLAIN_TEXT = "plain_text";
    public static final String TAG_TYPE_TITLE = "title";
    public static final String TAG_TYPE_URL = "url";
    private String mType;
    private String mValue;

    public SlookSmartClipMetaTag(String s, String s1) {
        this.mType = s;
        this.mValue = s1;
    }

    public String getType() {
        return this.mType;
    }

    public String getValue() {
        return this.mValue;
    }

    public void setType(String s) {
        this.mType = s;
    }

    public void setValue(String s) {
        this.mValue = s;
    }
}

