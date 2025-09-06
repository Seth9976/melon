package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjPlaylistListV6Res;

public class DjPlaylistListV6Req extends RequestV6_3Req {
    public static class Params {
        public String mode;
        public int pageSize;
        public String plylstTypeCode;
        public String sortBy;
        public int startIndex;
        public String targetMemberKey;

    }

    public static String ALL = "all";
    public static String INFORM = "inform";

    public DjPlaylistListV6Req(Context context0, Params djPlaylistListV6Req$Params0) {
        super(context0, 0, DjPlaylistListV6Res.class);
        this.addMemberKey();
        this.addParams(djPlaylistListV6Req$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/playlist/list.json";
    }
}

