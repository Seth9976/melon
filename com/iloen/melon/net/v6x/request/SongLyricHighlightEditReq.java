package com.iloen.melon.net.v6x.request;

import U4.x;
import android.content.Context;
import com.iloen.melon.net.v6x.response.SongLyricHighlightEditRes;

public class SongLyricHighlightEditReq extends RequestV6_1Req {
    public static class Param {
        public String adultFlg;
        public String songId;

    }

    private String endpointUrl;

    public SongLyricHighlightEditReq(Context context0, Param songLyricHighlightEditReq$Param0, String s) {
        super(context0, 0, SongLyricHighlightEditRes.class);
        this.endpointUrl = s;
        this.addMemberKey();
        this.addParam("songId", songLyricHighlightEditReq$Param0.songId);
        this.addParam("adultFlg", songLyricHighlightEditReq$Param0.adultFlg);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return x.m(new StringBuilder("/"), this.endpointUrl, "/lyric/highlight/edit.json");
    }
}

