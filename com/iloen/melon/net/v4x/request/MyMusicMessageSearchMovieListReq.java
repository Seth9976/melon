package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SearchMovieListRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicMessageSearchMovieListReq extends SearchMovieListBaseReq {
    public MyMusicMessageSearchMovieListReq(Context context0, String s, Params searchMovieListBaseReq$Params0) {
        super(context0, 0, SearchMovieListRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParamToValueEncoded("searchKeyword", s);
        this.addParams(searchMovieListBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/searchMovieList.json";
    }
}

