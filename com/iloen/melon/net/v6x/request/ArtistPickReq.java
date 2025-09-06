package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistPickRes;

public class ArtistPickReq extends RequestV6_1Req {
    public static class Params {
        public String artistId;
        public String artistPickSeq;
        public String viewType;

    }

    public static class ViewType {
        public static String ROLLING = "R";
        public static String SINGLE = "S";

    }

    public ArtistPickReq(Context context0, Params artistPickReq$Params0) {
        super(context0, 0, ArtistPickRes.class);
        this.addParams(artistPickReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/contents/artistPickList.json";
    }
}

