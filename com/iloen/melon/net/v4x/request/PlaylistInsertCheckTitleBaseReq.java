package com.iloen.melon.net.v4x.request;

import android.content.Context;

public abstract class PlaylistInsertCheckTitleBaseReq extends RequestV4Req {
    public PlaylistInsertCheckTitleBaseReq(Context context0, String s, Class class0) {
        super(context0, 1, class0);
        this.addMemberKey();
        this.addParam("plylstTitle", s);
    }

    public PlaylistInsertCheckTitleBaseReq(Context context0, String s, Class class0, boolean z) {
        super(context0, 1, class0, z);
        this.addMemberKey();
        this.addParam("plylstTitle", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "";
    }
}

