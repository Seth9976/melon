package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ForuMixMakerMainRes;
import e1.u;
import va.e0;
import va.o;

public class ForuMixMakerMainReq extends RequestV6Req {
    public ForuMixMakerMainReq(Context context0) {
        super(context0, 0, ForuMixMakerMainRes.class, false);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/mixmaker/main.json";
    }
}

