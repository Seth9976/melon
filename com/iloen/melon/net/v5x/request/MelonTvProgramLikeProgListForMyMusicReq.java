package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.MelonTvProgramLikeProgListForMyMusicRes;
import e1.u;
import va.e0;
import va.o;

public class MelonTvProgramLikeProgListForMyMusicReq extends RequestV5Req {
    public MelonTvProgramLikeProgListForMyMusicReq(Context context0) {
        super(context0, 0, MelonTvProgramLikeProgListForMyMusicRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/program/likeProgList/formymusic.json";
    }
}

