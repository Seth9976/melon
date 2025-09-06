package com.iloen.melon.net.v6x.request;

import android.content.Context;

public abstract class ListFollowerAlphabetBaseReq extends RequestV6_1Req {
    public static class Params {
        public String originCode;
        public int pageSize;
        public int startIndex;

    }

    public ListFollowerAlphabetBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0);
    }
}

