package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.utils.system.AppUtils;

public abstract class RequestV6_2Req extends HttpRequest {
    public RequestV6_2Req(Context context0, int v, Class class0) {
        super(context0, v, class0);
        this.setInitParam(context0, true);
    }

    public RequestV6_2Req(Context context0, int v, Class class0, boolean z) {
        super(context0, v, class0);
        this.setInitParam(context0, z);
    }

    public RequestV6_2Req(Context context0, String s, String s1, int v, Class class0) {
        super(context0, s, s1, v, class0);
        this.setInitParam(context0, true);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiVersionPath() {
        return "/m6";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getServerVersionPath() {
        return "/v2";
    }

    private void setInitParam(Context context0, boolean z) {
        if(z) {
            this.addParam("appVer", AppUtils.getVersionName(context0));
        }
    }
}

