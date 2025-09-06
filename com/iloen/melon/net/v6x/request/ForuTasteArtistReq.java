package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ForuTasteArtistRes;
import e1.u;
import va.e0;
import va.o;

public class ForuTasteArtistReq extends RequestV6Req {
    public ForuTasteArtistReq(Context context0) {
        super(context0, 0, ForuTasteArtistRes.class, false);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/taste/artist.json";
    }
}

