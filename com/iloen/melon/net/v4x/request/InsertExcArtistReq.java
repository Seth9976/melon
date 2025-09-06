package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.InsertExcArtistRes;

public class InsertExcArtistReq extends RequestV4Req {
    public InsertExcArtistReq(Context context0, String s) {
        super(context0, 0, InsertExcArtistRes.class, false);
        this.addMemberKey();
        this.addParam("artistId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/setting/insertExcArtist.json";
    }
}

