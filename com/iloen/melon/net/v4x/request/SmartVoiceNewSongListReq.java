package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.NewSongListRes;

public class SmartVoiceNewSongListReq extends RequestV4Req {
    public static class Params {
        public String areaFlg;
        public int pageSize;
        public int startIndex;

    }

    public static final String AREA_FLAG_DOMESTIC = "I";
    public static final String AREA_FLAG_OVERSEAS = "O";

    public SmartVoiceNewSongListReq(Context context0, Params smartVoiceNewSongListReq$Params0) {
        super(context0, 0, NewSongListRes.class);
        this.addParams(smartVoiceNewSongListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/smartvoice/new/song/list.json";
    }
}

