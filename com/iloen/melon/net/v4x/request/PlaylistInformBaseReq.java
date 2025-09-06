package com.iloen.melon.net.v4x.request;

import android.content.Context;

public class PlaylistInformBaseReq extends RequestV4Req {
    public static class Params {
        public String mode;
        public String plylstSeq;
        public String plylstTypeCode;

    }

    public PlaylistInformBaseReq(Context context0, Class class0) {
        super(context0, 0, class0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return null;
    }
}

