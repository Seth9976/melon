package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SearchSongListRes;
import e1.u;
import va.e0;
import va.o;

public class DjPlaylistAddSearchSongListReq extends SearchSongListBaseReq {
    public DjPlaylistAddSearchSongListReq(Context context0, String s, Params searchSongListBaseReq$Params0) {
        super(context0, 0, SearchSongListRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParamToValueEncoded("searchKeyword", s);
        this.addParams(searchSongListBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/djplaylist/addSearchSongList.json";
    }
}

