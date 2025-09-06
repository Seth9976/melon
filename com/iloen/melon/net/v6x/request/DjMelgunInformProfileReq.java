package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjMelgunInformProfileRes;

public class DjMelgunInformProfileReq extends RequestV6_1Req {
    public DjMelgunInformProfileReq(Context context0) {
        super(context0, 0, DjMelgunInformProfileRes.class);
        this.addMemberKeyAlwaysDeliver();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/melgun/informProfile.json";
    }
}

