package com.iloen.melon.net.v6x.request;

import android.content.Context;

public abstract class MyMusicLikeListCastBaseReq extends RequestV6Req {
    public static class Params {
        public String orderBy;
        public int pageSize;
        public int startIndex;

    }

    public MyMusicLikeListCastBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0);
    }
}

