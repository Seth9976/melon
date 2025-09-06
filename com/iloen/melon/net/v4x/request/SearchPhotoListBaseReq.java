package com.iloen.melon.net.v4x.request;

import android.content.Context;

public abstract class SearchPhotoListBaseReq extends SearchRequestBaseReq {
    public static class Params {
        public int orderBy;
        public int pageSize;
        public int startIndex;

    }

    public SearchPhotoListBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0);
    }
}

