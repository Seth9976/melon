package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.ForUSearchRecommListRes;

public class ForUSearchRecommListReq extends SearchRequestBaseReq {
    public ForUSearchRecommListReq(Context context0, String s) {
        super(context0, 0, ForUSearchRecommListRes.class);
        this.addMemberKey();
        this.addParamToValueEncoded("searchKeyword", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/foru/searchRecommList.json";
    }
}

