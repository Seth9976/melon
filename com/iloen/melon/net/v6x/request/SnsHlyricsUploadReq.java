package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.MultipartHttpRequest;
import com.iloen.melon.net.v6x.response.SnsHlyricsUploadRes;

public class SnsHlyricsUploadReq extends MultipartHttpRequest {
    public static class Params {
        public String sId;
        public String type;

    }

    public SnsHlyricsUploadReq(Context context0, Params snsHlyricsUploadReq$Params0) {
        super(context0, SnsHlyricsUploadRes.class);
        this.addMemberKey();
        this.addParams(snsHlyricsUploadReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/sns/hlyrics/upload.json";
    }
}

