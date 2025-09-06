package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SearchIntentListRes;

public class SearchIntentListReq extends SearchRequestBaseReq {
    public static class Params {
        public String query;
        public String searchAlbumKwd;
        public String searchArtistKwd;
        public String searchGnrKwd;
        public String searchPlystKwd;
        public String searchSongKwd;

    }

    public SearchIntentListReq(Context context0, Params searchIntentListReq$Params0) {
        super(context0, 0, SearchIntentListRes.class);
        this.addMemberKey();
        this.addParamToValueEncoded("query", searchIntentListReq$Params0.query);
        this.addParamToValueEncoded("searchSongKwd", searchIntentListReq$Params0.searchSongKwd);
        this.addParamToValueEncoded("searchArtistKwd", searchIntentListReq$Params0.searchArtistKwd);
        this.addParamToValueEncoded("searchAlbumKwd", searchIntentListReq$Params0.searchAlbumKwd);
        this.addParamToValueEncoded("searchPlystKwd", searchIntentListReq$Params0.searchPlystKwd);
        this.addParamToValueEncoded("searchGnrKwd", searchIntentListReq$Params0.searchGnrKwd);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/search/searchIntentList.json";
    }
}

