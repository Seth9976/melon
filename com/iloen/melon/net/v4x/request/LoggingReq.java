package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.HttpResponse;

public class LoggingReq extends HttpRequest {
    private String mLoggingUrl;

    public LoggingReq(Context context0, String s) {
        super(context0, 0, HttpResponse.class, false);
        this.mLoggingUrl = s;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String url() {
        return this.mLoggingUrl;
    }
}

