package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MelonTvThemeInformRes;

public class MelonTvThemeInformReq extends RequestV4Req {
    public static class Params {
        public String orderBy;
        public int pageSize;
        public String progSeq;
        public int startIndex;

        public Params() {
            this.orderBy = "";
            this.startIndex = 1;
            this.pageSize = 20;
            this.progSeq = "";
        }
    }

    public MelonTvThemeInformReq(Context context0, Params melonTvThemeInformReq$Params0) {
        super(context0, 0, MelonTvThemeInformRes.class);
        this.addParams(melonTvThemeInformReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/theme/inform.json";
    }
}

