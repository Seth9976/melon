package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.AlbumSetGradeRes;
import com.iloen.melon.net.v6x.request.RequestV6_1Req;

public class AlbumSetGradeReq extends RequestV6_1Req {
    public AlbumSetGradeReq(Context context0, String s, float f) {
        super(context0, 0, AlbumSetGradeRes.class);
        this.addMemberKey();
        this.addParam("albumId", s);
        if(f >= 0.0f && f <= 5.0f) {
            this.addParam("value", (f % 0.5f == 0.0f ? String.valueOf(f) : String.valueOf(Math.round(f))));
        }
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/album/setGrade.json";
    }
}

