package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.ArtistRecomContsRes;

public class ArtistRecomContsReq extends SuggestedContentsV4_1Req {
    public static final String MENU_TYPE_ARTIST = "A";
    public static final String MENU_TYPE_CHART = "C";
    public static final String MENU_TYPE_FEED = "F";
    public static final String MENU_TYPE_PHOTO = "P";

    public ArtistRecomContsReq(Context context0, String s, String s1) {
        super(context0, 0, ArtistRecomContsRes.class, true);
        this.addParam("artistId", s);
        this.addParam("menuType", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/recmConts.json";
    }
}

