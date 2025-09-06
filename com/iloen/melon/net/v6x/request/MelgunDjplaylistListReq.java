package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MelgunDjplaylistListRes;

public class MelgunDjplaylistListReq extends RequestV6_1Req {
    public static class Params {
        public int pageSize;
        public String sortBy;
        public int startIndex;

    }

    public MelgunDjplaylistListReq(Context context0, Params melgunDjplaylistListReq$Params0) {
        super(context0, 0, MelgunDjplaylistListRes.class, true);
        this.addParams(melgunDjplaylistListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/melgun/djplaylist/list.json";
    }
}

