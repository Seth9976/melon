package com.iloen.melon.net.v5x.request;

import android.content.Context;

public abstract class LikeListTagBaseReq extends RequestV5Req {
    public static class Params {
        public String orderBy;
        public int pageSize;
        public int startIndex;
        public String targetMemberKey;

    }

    public LikeListTagBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0, false);
    }
}

