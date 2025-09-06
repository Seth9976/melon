package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SearchSettingSongWithPianoforteRes;

public class SearchSettingSongWithPianoforteReq extends SearchRequestBaseReq {
    public SearchSettingSongWithPianoforteReq(Context context0) {
        super(context0, 0, SearchSettingSongWithPianoforteRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/search/settingSongWithPianoforte.json";
    }
}

