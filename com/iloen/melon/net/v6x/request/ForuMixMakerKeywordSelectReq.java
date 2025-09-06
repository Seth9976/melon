package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ForuMixMakerKeywordSelectRes;
import e1.u;
import va.e0;
import va.o;

public class ForuMixMakerKeywordSelectReq extends RequestV6Req {
    private static final String MIX_MAKER_NORMAL_MODE = "OFF";
    private static final String MIX_MAKER_PERSONAL_MODE = "ON";

    public ForuMixMakerKeywordSelectReq(Context context0, String s) {
        super(context0, 0, ForuMixMakerKeywordSelectRes.class, false);
        this.addParamToValueEncoded("searchKeyword", s);
        this.addParam("personalMode", (((e0)o.a()).m() ? "ON" : "OFF"));
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/mixmaker/keyword/select.json";
    }
}

