package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjThemeListBoardRes;

public class DjThemeListBoardReq extends RequestV5Req {
    public DjThemeListBoardReq(Context context0) {
        super(context0, 0, DjThemeListBoardRes.class, false);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/theme/listBoard.json";
    }
}

