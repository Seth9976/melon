package com.iloen.melon.slook.request;

import android.content.Context;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.net.HttpRequest;

public abstract class ReqDelegateBase {
    protected Context context;

    public ReqDelegateBase(Context context0) {
        this.context = context0;
    }

    public abstract HttpRequest createReq();

    public String getCacheKey() {
        return MelonContentUris.l.buildUpon().appendPath(this.getCacheKeySubTag()).build().toString();
    }

    public abstract String getCacheKeySubTag();
}

