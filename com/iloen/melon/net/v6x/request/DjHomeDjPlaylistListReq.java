package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjPlaylistListV6Res;

public class DjHomeDjPlaylistListReq extends RequestV6_1Req {
    public static class Params {
        public String mode;
        public int pageSize;
        public String sortBy;
        public int startIndex;

    }

    public static int PAGE_SIZE = 100;

    public DjHomeDjPlaylistListReq(Context context0, Params djHomeDjPlaylistListReq$Params0) {
        super(context0, 0, DjPlaylistListV6Res.class);
        this.addParams(djHomeDjPlaylistListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/home/djplaylist/list.json";
    }
}

