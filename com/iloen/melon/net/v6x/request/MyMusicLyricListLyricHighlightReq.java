package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicLyricListLyricHighlightRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicLyricListLyricHighlightReq extends RequestV6Req {
    public static class Params {
        public String orderBy;
        public int pageSize;
        public int startIndex;

    }

    public MyMusicLyricListLyricHighlightReq(Context context0, Params myMusicLyricListLyricHighlightReq$Params0) {
        super(context0, 0, MyMusicLyricListLyricHighlightRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParams(myMusicLyricListLyricHighlightReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/lyric/listLyricHighlight.json";
    }
}

