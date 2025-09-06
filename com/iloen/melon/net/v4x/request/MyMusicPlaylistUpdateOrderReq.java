package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistUpdateOrderRes;

public class MyMusicPlaylistUpdateOrderReq extends RequestV4Req {
    public static class Params {
        public String endDsplyOrder;
        public String moveDsplyOrder;
        public String movePlylstSeq;
        public String plylstTypeCode;

    }

    public MyMusicPlaylistUpdateOrderReq(Context context0, Params myMusicPlaylistUpdateOrderReq$Params0) {
        super(context0, 1, MyMusicPlaylistUpdateOrderRes.class);
        this.addMemberKey();
        this.addParams(myMusicPlaylistUpdateOrderReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/playlist/updateOrder.json";
    }
}

