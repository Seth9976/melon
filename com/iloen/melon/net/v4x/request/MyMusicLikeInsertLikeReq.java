package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeInsertLikeRes;
import com.iloen.melon.net.v5x.request.RequestV5Req;

public class MyMusicLikeInsertLikeReq extends RequestV5Req {
    public static class Params {
        public String actTypeCode;
        public String contsId;
        public String contsTypeCode;
        public String menuId;
        public String notificationType;

    }

    public static final String NOTIFICATION_APNS = "apns";
    public static final String NOTIFICATION_MSG = "msg";
    public static final String NOTIFICATION_POPUP = "popup";

    public MyMusicLikeInsertLikeReq(Context context0, Params myMusicLikeInsertLikeReq$Params0) {
        super(context0, 1, MyMusicLikeInsertLikeRes.class);
        this.addMemberKey();
        this.addParams(myMusicLikeInsertLikeReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/insertLike.json";
    }
}

