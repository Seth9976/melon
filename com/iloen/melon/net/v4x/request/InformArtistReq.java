package com.iloen.melon.net.v4x.request;

import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.net.v4x.response.InformArtistRes;

public class InformArtistReq extends RequestV4Req {
    public InformArtistReq(Context context0, String s) {
        super(context0, 0, InformArtistRes.class);
        this.addMemberKey();
        if(!TextUtils.isEmpty(s)) {
            this.addParam("artistId", s);
        }
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/main/mymusic/informArtist.json";
    }
}

