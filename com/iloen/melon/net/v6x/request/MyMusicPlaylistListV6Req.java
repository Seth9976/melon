package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistListV6Res;
import e1.u;
import va.e0;
import va.o;

public class MyMusicPlaylistListV6Req extends RequestV6_2Req {
    public static class Params {
        public String mode;
        public String orderBy;
        public int pageSize;
        public String plylstTypeCode;
        public int startIndex;
        public String targetMemberKey;

    }

    public static final String MODE_ALL = "all";
    public static final String MODE_SEARCH = "search";

    public MyMusicPlaylistListV6Req(Context context0, Params myMusicPlaylistListV6Req$Params0) {
        super(context0, 0, MyMusicPlaylistListV6Res.class, false);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParams(myMusicPlaylistListV6Req$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/playlist/list.json";
    }
}

