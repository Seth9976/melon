package com.iloen.melon.net.v6x.request;

import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.net.v6x.response.MixMakerCreateRes;
import e1.u;
import va.e0;
import va.o;

public class MixMakerCreateReq extends RequestV6Req {
    public static final String MIX_MAKER_NORMAL_MODE = "OFF";
    public static final String MIX_MAKER_PERSONAL_MODE = "ON";

    public MixMakerCreateReq(Context context0, String s, String s1) {
        super(context0, 0, MixMakerCreateRes.class, false);
        if(TextUtils.equals(s1, "ON")) {
            this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        }
        this.addParamToValueEncoded("searchKeyword", s);
        this.addParam("personalMode", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/mixmaker/create.json";
    }
}

