package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DeleteExcArtistRes;

public class DeleteExcArtistReq extends RequestV4Req {
    public DeleteExcArtistReq(Context context0, String s, String s1) {
        super(context0, 0, DeleteExcArtistRes.class, false);
        this.addMemberKey();
        this.addParam("artistId", s);
        this.addParam("excArtistSeq", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/setting/deleteExcArtist.json";
    }
}

