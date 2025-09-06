package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistPickWholeListRes;

public class ArtistPickWholeListReq extends RequestV6_1Req {
    public static class Params {
        public String artistId;
        public int pageSize;
        public int startIndex;

    }

    public ArtistPickWholeListReq(Context context0, Params artistPickWholeListReq$Params0) {
        super(context0, 0, ArtistPickWholeListRes.class);
        this.addParams(artistPickWholeListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/contents/artistPickWholeList.json";
    }
}

