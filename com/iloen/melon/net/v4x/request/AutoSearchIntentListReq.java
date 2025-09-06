package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.AutoSearchIntentListRes;
import e1.u;
import va.e0;
import va.o;

public class AutoSearchIntentListReq extends SearchRequestBaseReq {
    public static class Params {
        public String query;
        public String searchAlbumKwd;
        public String searchArtistKwd;
        public String searchGnrKwd;
        public String searchPlystKwd;
        public String searchSongKwd;

    }

    public AutoSearchIntentListReq(Context context0, Params autoSearchIntentListReq$Params0) {
        super(context0, 0, AutoSearchIntentListRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParamToValueEncoded("query", autoSearchIntentListReq$Params0.query);
        this.addParamToValueEncoded("searchSongKwd", autoSearchIntentListReq$Params0.searchSongKwd);
        this.addParamToValueEncoded("searchArtistKwd", autoSearchIntentListReq$Params0.searchArtistKwd);
        this.addParamToValueEncoded("searchAlbumKwd", autoSearchIntentListReq$Params0.searchAlbumKwd);
        this.addParamToValueEncoded("searchPlystKwd", autoSearchIntentListReq$Params0.searchPlystKwd);
        this.addParamToValueEncoded("searchGnrKwd", autoSearchIntentListReq$Params0.searchGnrKwd);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/auto/search/searchIntentList.json";
    }
}

