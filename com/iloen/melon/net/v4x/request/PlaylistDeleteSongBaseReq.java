package com.iloen.melon.net.v4x.request;

import android.content.Context;

public class PlaylistDeleteSongBaseReq extends RequestV4Req {
    public static class Params {
        public String plylstSeq;
        public String plylstTypeCode;
        public String songIds;

    }

    public PlaylistDeleteSongBaseReq(Context context0, Params playlistDeleteSongBaseReq$Params0, Class class0) {
        super(context0, 1, class0);
        this.addMemberKey();
        this.addParams(playlistDeleteSongBaseReq$Params0);
    }

    public PlaylistDeleteSongBaseReq(Params playlistDeleteSongBaseReq$Params0, Class class0) {
        super(1, class0);
        this.addMemberKey();
        this.addParams(playlistDeleteSongBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return null;
    }
}

