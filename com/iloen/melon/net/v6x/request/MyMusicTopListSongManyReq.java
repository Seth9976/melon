package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicTopListSongManyRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicTopListSongManyReq extends RequestV6Req {
    public static class Params {
        public String dateType;
        public String targetMemberKey;
        public String term;

    }

    public static final String ONE_MONTH = "1M";
    public static final String ONE_WEEK = "W";
    public static final String TERM = "TERM";
    public static final String THREE_MONTH = "3M";

    public MyMusicTopListSongManyReq(Context context0, Params myMusicTopListSongManyReq$Params0) {
        super(context0, 0, MyMusicTopListSongManyRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
        this.addParams(myMusicTopListSongManyReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/top/listSongMany.json";
    }
}

