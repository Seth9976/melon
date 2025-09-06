package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistplaylistConnectedSongRes;
import e1.u;
import va.e0;
import va.o;

public class ArtistPlaylistConnectedSongReq extends RequestV6_1Req {
    public ArtistPlaylistConnectedSongReq(Context context0, String s) {
        super(context0, 0, ArtistplaylistConnectedSongRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParam("plylstSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artistplaylist/connected/song.json";
    }
}

