package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.CleanIsBlackRes;
import e1.u;
import va.e0;
import va.o;

public class CleanIsBlackReq extends RequestV6Req {
    public static String SERVICE_CODE_DJPLAYLIST = "DJPLAYLIST";
    public static String SERVICE_CODE_MUSIC_MESSAGE = "MUSIC_MESSAGE";
    public static String SERVICE_CODE_PLAYLIST = "PLAYLIST";
    public static String SERVICE_CODE_PROFILE = "PROFILE";

    public CleanIsBlackReq(Context context0, String s, String s1) {
        super(context0, 0, CleanIsBlackRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParam("serviceCode", s);
        this.addParam("contentId", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/clean/isblack.json";
    }

    @Override  // com.iloen.melon.net.v6x.request.RequestV6Req
    public String getApiVersionPath() {
        return "";
    }
}

