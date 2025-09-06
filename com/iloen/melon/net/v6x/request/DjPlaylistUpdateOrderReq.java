package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistUpdateOrderRes;

public class DjPlaylistUpdateOrderReq extends RequestV6_1Req {
    public static class Params {
        public String endDsplyOrder;
        public String moveDsplyOrder;
        public String movePlylstSeq;

    }

    public DjPlaylistUpdateOrderReq(Context context0, Params djPlaylistUpdateOrderReq$Params0) {
        super(context0, 1, MyMusicPlaylistUpdateOrderRes.class);
        this.addMemberKey();
        this.addParams(djPlaylistUpdateOrderReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/playlist/updateOrder.json";
    }
}

