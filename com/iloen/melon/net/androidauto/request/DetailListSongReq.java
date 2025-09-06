package com.iloen.melon.net.androidauto.request;

import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.net.androidauto.response.DetailListSongRes;

public class DetailListSongReq extends RequestAutoV1Req {
    private String url;

    public DetailListSongReq(Context context0, String s) {
        super(context0, 0, DetailListSongRes.class);
        this.url = s;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "";
    }

    @Override  // com.iloen.melon.net.androidauto.request.RequestAutoV1Req
    public String getApiVersionPath() {
        return "";
    }

    @Override  // com.iloen.melon.net.androidauto.request.RequestAutoV1Req
    public String getServerVersionPath() {
        return "";
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.net.HttpRequest
    public String url() {
        return TextUtils.isEmpty(this.url) ? super.url() : this.url;
    }
}

