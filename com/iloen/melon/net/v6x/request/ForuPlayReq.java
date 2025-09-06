package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ForuPlayRes;

public class ForuPlayReq extends RequestV6Req {
    public ForuPlayReq(Context context0, String s, String s1) {
        super(context0, 0, ForuPlayRes.class, false);
        this.addMemberKey();
        this.addParam("contsId", s);
        this.addParam("songIds", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/play.json";
    }
}

