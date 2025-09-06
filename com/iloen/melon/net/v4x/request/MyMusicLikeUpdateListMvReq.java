package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListMvRes;
import com.iloen.melon.net.v5x.request.RequestV5_1Req;

public class MyMusicLikeUpdateListMvReq extends RequestV5_1Req {
    public static class Params {
        public String menuSeq;
        public String orderBy;
        public int pageSize;
        public int startIndex;
        public String targetMemberKey;

    }

    public MyMusicLikeUpdateListMvReq(Context context0, Params myMusicLikeUpdateListMvReq$Params0) {
        super(context0, 0, MyMusicLikeUpdateListMvRes.class);
        this.addMemberKey();
        this.addParams(myMusicLikeUpdateListMvReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/update/listMv.json";
    }
}

