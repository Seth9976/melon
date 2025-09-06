package com.iloen.melon.net.v4x.request;

import android.content.Context;
import e1.u;
import va.e0;
import va.o;

public class PlaylistUploadRepntImgBaseReq extends RequestV4Req {
    public static class Params {
        public String v;

        public Params() {
            this.v = "4.0";
        }
    }

    public PlaylistUploadRepntImgBaseReq(Context context0, Params playlistUploadRepntImgBaseReq$Params0, Class class0) {
        super(context0, 1, class0);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParams(playlistUploadRepntImgBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return null;
    }
}

