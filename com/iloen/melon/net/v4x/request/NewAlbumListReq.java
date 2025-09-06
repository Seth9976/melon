package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.NewAlbumListRes;

public class NewAlbumListReq extends RequestV4Req {
    public static class Params {
        public String areaFlg;
        public String exAlbumIds;
        public int pageSize;
        public int startIndex;

    }

    public static final String AREA_FLAG_ALL = "A";
    public static final String AREA_FLAG_DOMESTIC = "I";
    public static final String AREA_FLAG_OVERSEAS = "O";

    public NewAlbumListReq(Context context0, Params newAlbumListReq$Params0) {
        super(context0, 0, NewAlbumListRes.class, false);
        this.addParams(newAlbumListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/new/album/list.json";
    }
}

