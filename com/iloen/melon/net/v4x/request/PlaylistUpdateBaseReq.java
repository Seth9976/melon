package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.request.RequestV6_1Req;
import e1.u;
import va.e0;
import va.o;

public class PlaylistUpdateBaseReq extends RequestV6_1Req {
    public static class Params {
        public String introdCont;
        public String openYn;
        public String plylstSeq;
        public String plylstTitle;
        public String plylstTypeCode;
        public String repntImg;
        public String songIds;

    }

    public PlaylistUpdateBaseReq(Context context0, Params playlistUpdateBaseReq$Params0, Class class0) {
        super(context0, 1, class0);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParams(playlistUpdateBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return null;
    }
}

