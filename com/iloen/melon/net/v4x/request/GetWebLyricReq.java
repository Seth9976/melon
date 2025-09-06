package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.v4x.response.GetWebLyricRes;

public class GetWebLyricReq extends HttpRequest {
    private String mUrl;

    public GetWebLyricReq(Context context0, String s) {
        super(context0, 0, GetWebLyricRes.class, false);
        this.mUrl = s;
    }

    public GetWebLyricReq(Context context0, String s, String s1) {
        super(context0, 0, GetWebLyricRes.class);
        this.mUrl = null;
        this.addParam("cId", s);
        this.addParam("cType", s1);
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return TextUtils.isEmpty(this.mUrl) ? M.f : "";
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return TextUtils.isEmpty(this.mUrl) ? "/cds/delivery/android/weblyric.json" : "";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.net.HttpRequest
    public String url() {
        return TextUtils.isEmpty(this.mUrl) ? super.url() : this.mUrl;
    }
}

