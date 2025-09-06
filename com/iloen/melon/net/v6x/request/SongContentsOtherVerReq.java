package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.SongContentsOtherVerRes;

public class SongContentsOtherVerReq extends RequestV6_1Req {
    public static class Params {
        public int pageSize;
        public String songId;
        public int startIndex;

    }

    public SongContentsOtherVerReq(Context context0, Params songContentsOtherVerReq$Params0) {
        super(context0, 0, SongContentsOtherVerRes.class);
        this.addParams(songContentsOtherVerReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/song/contents/otherVer.json";
    }
}

