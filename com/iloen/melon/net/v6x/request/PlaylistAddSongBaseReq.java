package com.iloen.melon.net.v6x.request;

import android.content.Context;

public abstract class PlaylistAddSongBaseReq extends RequestV6_1Req {
    public static class Params {
        public String plylstSeq;
        public String plylstTypeCode;
        public String songIds;
        public String type;

    }

    public static final String MOVE_TYPE_BOTTOM = "BOTTOM";
    public static final String MOVE_TYPE_TOP = "TOP";

    public PlaylistAddSongBaseReq(Context context0, Params playlistAddSongBaseReq$Params0, Class class0) {
        super(context0, 1, class0);
        this.addMemberKey();
        this.addParams(playlistAddSongBaseReq$Params0);
        this.addParam("moveType", this.getMoveType());
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return null;
    }

    public abstract String getMoveType();
}

