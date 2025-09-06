package com.iloen.melon.net.androidauto.request;

import android.content.Context;
import com.iloen.melon.net.HttpRequest;

public abstract class RequestAutoV1Req extends HttpRequest {
    public RequestAutoV1Req(int v, Class class0) {
        super(v, class0);
    }

    public RequestAutoV1Req(Context context0, int v, Class class0) {
        super(context0, v, class0);
    }

    public RequestAutoV1Req(Context context0, String s, String s1, int v, Class class0) {
        super(context0, s, s1, v, class0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiVersionPath() {
        return "/androidauto";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getServerVersionPath() {
        return "/v1";
    }
}

