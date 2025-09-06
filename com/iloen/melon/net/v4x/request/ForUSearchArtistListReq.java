package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SearchArtistListRes;

public class ForUSearchArtistListReq extends SearchArtistListBaseReq {
    public ForUSearchArtistListReq(Context context0, String s, Params searchArtistListBaseReq$Params0) {
        super(context0, 0, SearchArtistListRes.class);
        this.addMemberKey();
        this.addParamToValueEncoded("searchKeyword", s);
        this.addParams(searchArtistListBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/foru/searchArtistList.json";
    }
}

