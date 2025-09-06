package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArchivingThemeKeywordMainRes;

public class ArchivingThemeKeywordMainReq extends RequestV6Req {
    public ArchivingThemeKeywordMainReq(Context context0, String s, String s1) {
        super(context0, 0, ArchivingThemeKeywordMainRes.class, false);
        this.addParam("title", s);
        this.addParam("songIds", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/archiving/theme/keyword/main.json";
    }
}

