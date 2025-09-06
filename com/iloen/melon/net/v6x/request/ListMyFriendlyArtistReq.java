package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ListMyFriendlyArtistRes;
import e1.u;
import va.e0;
import va.o;

public class ListMyFriendlyArtistReq extends RequestV6Req {
    public ListMyFriendlyArtistReq(Context context0) {
        super(context0, 0, ListMyFriendlyArtistRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/artistfan/listMyFriendlyArtist.json";
    }
}

