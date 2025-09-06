package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.google.gson.n;
import com.iloen.melon.net.v6x.response.MusicTabTitleBarBannerRes;
import java.util.List;

public class MusicTopBannerReq extends RequestV6_1Req {
    private final String KEY_EXCLUDE_RED_DOT;

    public MusicTopBannerReq(Context context0, List list0) {
        super(context0, 0, MusicTabTitleBarBannerRes.class);
        this.KEY_EXCLUDE_RED_DOT = "excludeRedDots";
        this.addMemberKey();
        if(list0 != null) {
            this.addParam("excludeRedDots", new n().k(list0));
        }
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/specialgift/banner.json";
    }
}

