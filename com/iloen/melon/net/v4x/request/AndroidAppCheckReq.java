package com.iloen.melon.net.v4x.request;

import A8.b;
import android.content.Context;
import android.os.Build;
import com.iloen.melon.net.v4x.response.AndroidAppCheckRes;
import com.iloen.melon.utils.system.AppUtils;

public class AndroidAppCheckReq extends RequestV4Req {
    public AndroidAppCheckReq(Context context0) {
        super(context0, 0, AndroidAppCheckRes.class, true);
        this.addParam("version", String.valueOf(AppUtils.getVersionCode(context0)));
        this.addParam("deployType", "1");
        this.addParam("platform", Build.MODEL);
        this.addOsVersionParam();
        if(!b.d()) {
            this.addParam("reg", "Y");
        }
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/setting/androidAppCheck.json";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

