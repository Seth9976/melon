package com.iloen.melon.net.v5x.request;

import android.content.Context;

public abstract class RecentListSongRecntBaseReq extends RequestV5Req {
    public static class Params {
        public String targetMemberKey;

    }

    public RecentListSongRecntBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0);
    }
}

