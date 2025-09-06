package com.facebook.messenger;

import android.net.Uri;

public class ShareToMessengerParamsBuilder {
    private Uri mExternalUri;
    private String mMetaData;
    private final String mMimeType;
    private final Uri mUri;

    public ShareToMessengerParamsBuilder(Uri uri0, String s) {
        this.mUri = uri0;
        this.mMimeType = s;
    }

    public ShareToMessengerParams build() {
        return new ShareToMessengerParams(this);
    }

    public Uri getExternalUri() {
        return this.mExternalUri;
    }

    public String getMetaData() {
        return this.mMetaData;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public ShareToMessengerParamsBuilder setExternalUri(Uri uri0) {
        this.mExternalUri = uri0;
        return this;
    }

    public ShareToMessengerParamsBuilder setMetaData(String s) {
        this.mMetaData = s;
        return this;
    }
}

