package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.GiftListUserByGiftBoxRes;

public class GiftListUserByGiftBoxReq extends RequestV4_1Req {
    public static class Params {
        public String lastIndexKey;
        public String pageSize;

        public Params() {
            this.pageSize = "100";
        }
    }

    public GiftListUserByGiftBoxReq(Context context0, Params giftListUserByGiftBoxReq$Params0) {
        super(context0, 0, GiftListUserByGiftBoxRes.class);
        this.addMemberKey();
        this.addParams(giftListUserByGiftBoxReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/gift/listUserByGiftBox.json";
    }
}

