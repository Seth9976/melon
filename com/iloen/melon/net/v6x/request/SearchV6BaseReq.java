package com.iloen.melon.net.v6x.request;

import A8.M;
import android.content.Context;

public abstract class SearchV6BaseReq extends RequestV6Req {
    public SearchV6BaseReq(int v, Class class0) {
        super(v, class0);
    }

    public SearchV6BaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.d;
    }
}

