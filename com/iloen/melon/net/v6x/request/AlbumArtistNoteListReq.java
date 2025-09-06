package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.AlbumArtistNoteListRes;

public class AlbumArtistNoteListReq extends RequestV6_1Req {
    public AlbumArtistNoteListReq(Context context0, String s) {
        super(context0, 0, AlbumArtistNoteListRes.class);
        this.addParam("albumId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/album/artistNote/list.json";
    }
}

