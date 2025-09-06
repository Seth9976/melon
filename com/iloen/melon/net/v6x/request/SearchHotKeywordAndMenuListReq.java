package com.iloen.melon.net.v6x.request;

import com.iloen.melon.net.v6x.response.SearchHotKeywordAndMenuListRes;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.player.MediaCodecInfoCompat;

public class SearchHotKeywordAndMenuListReq extends SearchV6BaseReq {
    public SearchHotKeywordAndMenuListReq() {
        super(0, SearchHotKeywordAndMenuListRes.class);
        String s = "N";
        this.addParam("dolbyYN", (MelonSettingInfo.isUseSpatialStreaming() ? "Y" : "N"));
        if(MediaCodecInfoCompat.isAc4Supported()) {
            s = "Y";
        }
        this.addParam("dolbyEmbedYN", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/search/hotKeywordAndMenuList.json";
    }
}

