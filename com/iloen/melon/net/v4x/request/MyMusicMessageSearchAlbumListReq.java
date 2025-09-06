package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SearchAlbumListRes;

public class MyMusicMessageSearchAlbumListReq extends SearchAlbumListBaseReq {
    public MyMusicMessageSearchAlbumListReq(Context context0, String s, Params searchAlbumListBaseReq$Params0) {
        super(context0, 0, SearchAlbumListRes.class);
        this.addMemberKey();
        this.addParamToValueEncoded("searchKeyword", s);
        this.addParams(searchAlbumListBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/searchAlbumList.json";
    }
}

