package com.iloen.melon.net.v5x.request;

import A8.M;
import android.content.Context;

public abstract class PlayBaseReq extends RequestV5Req {
    public PlayBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0);
    }

    public PlayBaseReq(Context context0, int v, Class class0, boolean z) {
        super(context0, v, class0, z);
    }

    public PlayBaseReq(Context context0, String s, String s1, int v, Class class0) {
        super(context0, s, s1, v, class0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.f;
    }

    @Override  // com.iloen.melon.net.v5x.request.RequestV5Req
    public String getApiVersionPath() {
        return "";
    }
}

