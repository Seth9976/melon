package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ChartMyHitsSongsIdRes;

public class ChartMyHitsSongsIdReq extends RequestV6Req {
    public ChartMyHitsSongsIdReq(Context context0) {
        super(context0, 0, ChartMyHitsSongsIdRes.class, true);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/my/hits/songs/id.json";
    }
}

