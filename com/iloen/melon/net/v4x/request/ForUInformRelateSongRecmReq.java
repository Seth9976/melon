package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.ForUInformRelateSongRecmRes;

public class ForUInformRelateSongRecmReq extends RequestV4Req {
    public ForUInformRelateSongRecmReq(Context context0) {
        super(context0, 1, ForUInformRelateSongRecmRes.class, false);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/foru/informRelateSongRecm.json";
    }
}

