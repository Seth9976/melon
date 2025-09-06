package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.AlbumContentsPhotoRes;

public class AlbumContentsPhotoReq extends RequestV6_1Req {
    public static class Params {
        public String albumId;
        public String orderBy;
        public int pageSize;
        public int startIndex;

    }

    public AlbumContentsPhotoReq(Context context0, Params albumContentsPhotoReq$Params0) {
        super(context0, 0, AlbumContentsPhotoRes.class);
        this.addParams(albumContentsPhotoReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/album/contents/photo.json";
    }
}

