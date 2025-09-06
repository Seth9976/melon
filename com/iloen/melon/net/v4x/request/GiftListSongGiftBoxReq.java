package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.GiftListSongGiftBoxRes;
import com.iloen.melon.utils.StringUtils;
import java.util.ArrayList;

public class GiftListSongGiftBoxReq extends RequestV4Req {
    public GiftListSongGiftBoxReq(Context context0, ArrayList arrayList0) {
        super(context0, 0, GiftListSongGiftBoxRes.class);
        this.addMemberKey();
        this.addParam("songIds", StringUtils.convertToCommaSeparatedText(arrayList0));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/gift/listSongGiftBox.json";
    }
}

