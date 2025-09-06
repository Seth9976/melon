package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ForuTasteSongRes;
import e1.u;
import va.e0;
import va.o;

public class ForuTasteSongReq extends RequestV6Req {
    public ForuTasteSongReq(Context context0, String s) {
        super(context0, 0, ForuTasteSongRes.class, false);
        this.addParam("artistIds", s);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/taste/song.json";
    }
}

