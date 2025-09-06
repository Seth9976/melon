package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.NewMovieListRes;

public class NewMovieListReq extends RequestV4Req {
    public static class Params {
        public int pageSize;
        public int startIndex;

    }

    public NewMovieListReq(Context context0, Params newMovieListReq$Params0) {
        super(context0, 0, NewMovieListRes.class, false);
        this.addParams(newMovieListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/new/mv/list.json";
    }
}

