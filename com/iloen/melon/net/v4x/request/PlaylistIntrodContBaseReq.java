package com.iloen.melon.net.v4x.request;

import android.content.Context;

public class PlaylistIntrodContBaseReq extends RequestV4Req {
    public static class Params {
        public String mode;
        public String plylstSeq;
        public String plylstTypeCode;

    }

    public PlaylistIntrodContBaseReq(Context context0, int v, Params playlistIntrodContBaseReq$Params0, Class class0) {
        super(context0, v, class0);
        this.addMemberKey();
        this.addParams(playlistIntrodContBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/playlist/introdCont.json";
    }
}

