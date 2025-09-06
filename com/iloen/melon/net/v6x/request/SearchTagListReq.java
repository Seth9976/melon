package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.SearchTagListRes;

public class SearchTagListReq extends SearchV6BaseReq {
    public SearchTagListReq() {
        super(0, SearchTagListRes.class);
        this.addMemberKey();
    }

    public SearchTagListReq(Context context0) {
        super(context0, 0, SearchTagListRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/search/tagList.json";
    }
}

