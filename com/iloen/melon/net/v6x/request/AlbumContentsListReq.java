package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.AlbumContentsListRes;

public class AlbumContentsListReq extends RequestV6_1Req {
    public AlbumContentsListReq(Context context0, String s) {
        super(context0, 0, AlbumContentsListRes.class);
        this.addParam("albumId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/album/contents/list.json";
    }
}

