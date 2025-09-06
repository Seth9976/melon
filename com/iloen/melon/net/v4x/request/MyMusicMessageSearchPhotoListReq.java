package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SearchPhotoListRes;

public class MyMusicMessageSearchPhotoListReq extends SearchPhotoListBaseReq {
    public MyMusicMessageSearchPhotoListReq(Context context0, String s, Params searchPhotoListBaseReq$Params0) {
        super(context0, 0, SearchPhotoListRes.class);
        this.addMemberKey();
        this.addParamToValueEncoded("searchKeyword", s);
        this.addParams(searchPhotoListBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/searchPhotoList.json";
    }
}

