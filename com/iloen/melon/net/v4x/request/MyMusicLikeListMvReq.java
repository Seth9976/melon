package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeListMvRes;
import com.iloen.melon.net.v5x.request.RequestV5_1Req;
import e1.u;
import va.e0;
import va.o;

public class MyMusicLikeListMvReq extends RequestV5_1Req {
    public static class Params {
        public String menuSeq;
        public String orderBy;
        public int pageSize;
        public int startIndex;
        public String targetMemberKey;

    }

    public static String MENU_SEQ_ALL = "";
    public static String MENU_SEQ_M = "M";
    public static String MENU_SEQ_OB = "OB";
    public static String MENU_SEQ_PROG = "PROG";

    public MyMusicLikeListMvReq(Context context0, Params myMusicLikeListMvReq$Params0) {
        super(context0, 0, MyMusicLikeListMvRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
        this.addParams(myMusicLikeListMvReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/listMv.json";
    }
}

