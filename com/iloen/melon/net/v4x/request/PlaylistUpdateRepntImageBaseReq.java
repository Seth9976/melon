package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.MultipartHttpRequest;

public class PlaylistUpdateRepntImageBaseReq extends MultipartHttpRequest {
    public static class Params {
        public String plylstSeq;
        public String plylstTypeCode;
        public String repntImg;

    }

    public PlaylistUpdateRepntImageBaseReq(Context context0, Params playlistUpdateRepntImageBaseReq$Params0, Class class0) {
        super(context0, class0);
        this.addMemberKey();
        this.addParams(playlistUpdateRepntImageBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return null;
    }
}

