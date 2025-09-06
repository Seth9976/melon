package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;

public abstract class BannerBaseReq extends RequestV4Req {
    protected static final String BNRORD = "bnrOrd";
    private static final int BNRORD_MAX = 10;
    protected static final String BNRSGMT = "bnrSgmt";

    public BannerBaseReq(int v, Class class0) {
        super(v, class0, true);
    }

    public BannerBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.e;
    }

    public static int generateBnrOrd() [...] // 潜在的解密器
}

