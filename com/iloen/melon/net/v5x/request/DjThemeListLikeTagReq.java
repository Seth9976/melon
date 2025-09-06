package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.DjThemeListLikeTagRes;

public class DjThemeListLikeTagReq extends RequestV5Req {
    public DjThemeListLikeTagReq(Context context0) {
        super(context0, 0, DjThemeListLikeTagRes.class, false);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/theme/listLikeTag.json";
    }
}

