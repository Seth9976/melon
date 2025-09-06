package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.MelonTvTodayPersonalContsRes;

public class MelonTvTodayPersonalContsReq extends RequestV5Req {
    public MelonTvTodayPersonalContsReq(Context context0) {
        super(context0, 0, MelonTvTodayPersonalContsRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/today/personalconts.json";
    }
}

