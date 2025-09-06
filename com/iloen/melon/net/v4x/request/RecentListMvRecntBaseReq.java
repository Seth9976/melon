package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.request.RequestV5_1Req;

public abstract class RecentListMvRecntBaseReq extends RequestV5_1Req {
    public static class Params {
        public String targetMemberKey;

    }

    public RecentListMvRecntBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0);
    }
}

