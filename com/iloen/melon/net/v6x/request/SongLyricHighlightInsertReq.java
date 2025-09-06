package com.iloen.melon.net.v6x.request;

import U4.x;
import android.content.Context;
import com.iloen.melon.net.v6x.response.SongLyricHighlightInsertRes;

public class SongLyricHighlightInsertReq extends RequestV6_1Req {
    public static class Param {
        public String adultFlg;
        public String choiceLine;
        public String songId;

    }

    private String endpointUrl;

    public SongLyricHighlightInsertReq(Context context0, Param songLyricHighlightInsertReq$Param0, String s) {
        super(context0, 0, SongLyricHighlightInsertRes.class);
        this.endpointUrl = s;
        this.addMemberKey();
        this.addParam("songId", songLyricHighlightInsertReq$Param0.songId);
        this.addParam("adultFlg", songLyricHighlightInsertReq$Param0.adultFlg);
        this.addParam("choiceLine", songLyricHighlightInsertReq$Param0.choiceLine);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return x.m(new StringBuilder("/"), this.endpointUrl, "/lyric/highlight/insert.json");
    }
}

