package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.ScreenUtils;

public abstract class RequestV4_2Req extends HttpRequest {
    public RequestV4_2Req(Context context0, int v, Class class0) {
        super(context0, v, class0);
        this.setInitParam(context0, true);
    }

    public RequestV4_2Req(Context context0, int v, Class class0, boolean z) {
        super(context0, v, class0);
        this.setInitParam(context0, z);
    }

    private void setInitParam(Context context0, boolean z) {
        this.addParam("v", "4.2");
        this.addParam("resolution", ScreenUtils.getResolution(context0));
        if(z) {
            this.addParam("appVer", AppUtils.getVersionName(context0));
        }
    }
}

