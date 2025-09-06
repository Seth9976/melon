package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SearchSongListRes;

public class ForUSearchSongListReq extends SearchSongListBaseReq {
    public ForUSearchSongListReq(Context context0, String s, Params searchSongListBaseReq$Params0) {
        super(context0, 0, SearchSongListRes.class);
        this.addMemberKey();
        this.addParamToValueEncoded("searchKeyword", s);
        this.addParams(searchSongListBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/foru/searchSongList.json";
    }
}

