package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.AlbumDetailContentsOtherVerRes;

public class AlbumContentsOtherVerReq extends RequestV6_1Req {
    public static class Params {
        public String albumId;
        public int pageSize;
        public int startIndex;

    }

    public AlbumContentsOtherVerReq(Context context0, Params albumContentsOtherVerReq$Params0) {
        super(context0, 0, AlbumDetailContentsOtherVerRes.class);
        this.addParams(albumContentsOtherVerReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/album/contents/otherVer.json";
    }
}

