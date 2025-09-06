package com.iloen.melon.net.v4x.request;

import android.content.Context;

public abstract class LikeListPlaylistBaseReq extends RequestV4Req {
    public static class Params {
        public String orderBy;
        public int pageSize;
        public int startIndex;
        public String targetMemberKey;

    }

    public LikeListPlaylistBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0);
    }
}

