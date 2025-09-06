package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.ForUSearchAutoComplListForURes;

public class ForUSearchAutoComplListForUReq extends SearchRequestBaseReq {
    public ForUSearchAutoComplListForUReq(Context context0, String s) {
        super(context0, 0, ForUSearchAutoComplListForURes.class);
        this.addMemberKey();
        this.addParamToValueEncoded("searchKeyword", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/foru/searchAutoComplListForU.json";
    }
}

