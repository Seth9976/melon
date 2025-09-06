package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.MultipartHttpRequestV6;
import com.iloen.melon.net.v6x.response.ArtistTemperatureShareImgRes;

public class ArtistTemperatureShareImgReq extends MultipartHttpRequestV6 {
    public static String TYPE_MEMORIAL_CARD = "MEMORIAL_CARD";
    public static String TYPE_TEMPERATURE_CARD = "TEMPERATURE_CARD";

    public ArtistTemperatureShareImgReq(Context context0, String s) {
        super(context0, ArtistTemperatureShareImgRes.class);
        this.addMemberKey();
        this.addParam("shareType", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/temperature/shareImg.json";
    }
}

