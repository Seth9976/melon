package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;

public abstract class CommerceBaseReq extends RequestV4Req {
    public CommerceBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.k;
    }
}

