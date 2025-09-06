package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.ArtistListArtistInfoRes;

public class ArtistListArtistInfoReq extends RequestV4Req {
    public ArtistListArtistInfoReq(Context context0, String s) {
        super(context0, 0, ArtistListArtistInfoRes.class, false);
        this.addMemberKey();
        this.addParam("artistIds", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/listArtistInfo.json";
    }
}

