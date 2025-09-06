package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.InformExcArtistRes;
import e1.u;
import va.e0;
import va.o;

public class InformExcArtistReq extends RequestV4Req {
    public InformExcArtistReq(Context context0, String s) {
        super(context0, 0, InformExcArtistRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
        this.addParam("syncDateTime", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/setting/informExcArtist.json";
    }
}

