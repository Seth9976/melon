package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.DjPlaylistInformCntCheckRes;
import e1.u;
import va.e0;
import va.o;

public class DjPlaylistInformCntCheckReq extends RequestV5Req {
    public DjPlaylistInformCntCheckReq(Context context0) {
        super(context0, 0, DjPlaylistInformCntCheckRes.class);
        this.addParam("plylstTypeCode", "M20002");
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/djplaylist/informCntCheck.json";
    }
}

