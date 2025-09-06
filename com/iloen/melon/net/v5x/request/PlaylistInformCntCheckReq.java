package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.PlaylistInformCntCheckRes;
import e1.u;
import va.e0;
import va.o;

public class PlaylistInformCntCheckReq extends RequestV5Req {
    public PlaylistInformCntCheckReq(Context context0) {
        super(context0, 0, PlaylistInformCntCheckRes.class);
        this.addParam("plylstTypeCode", "M20001");
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/playlist/informCntCheck.json";
    }
}

