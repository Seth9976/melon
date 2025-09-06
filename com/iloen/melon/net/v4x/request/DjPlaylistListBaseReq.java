package com.iloen.melon.net.v4x.request;

import android.content.Context;

public abstract class DjPlaylistListBaseReq extends RequestV4Req {
    public static class Params {
        public String mode;
        public String orderBy;
        public int pageSize;
        public String plylstTypeCode;
        public int startIndex;
        public String targetMemberKey;

    }

    public DjPlaylistListBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0);
    }
}

