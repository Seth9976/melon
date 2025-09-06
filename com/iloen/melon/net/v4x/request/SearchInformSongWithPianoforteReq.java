package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SearchInformSongWithPianoforteRes;

public class SearchInformSongWithPianoforteReq extends SearchRequestBaseReq {
    public SearchInformSongWithPianoforteReq(Context context0, String s) {
        super(context0, 0, SearchInformSongWithPianoforteRes.class);
        this.addParam("songIds", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/search/informSongWithPianoforte.json";
    }
}

