package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MelonTvProgramCnpckListMvRes;

public class MelonTvProgramCnpckListMvReq extends RequestV4Req {
    public static class Params {
        public String cnpckSeq;
        public String orderBy;
        public int pageSize;
        public String progSeq;
        public int startIndex;

        public Params() {
            this.orderBy = "";
            this.startIndex = 1;
            this.pageSize = 20;
            this.progSeq = "";
            this.cnpckSeq = "";
        }
    }

    public MelonTvProgramCnpckListMvReq(Context context0, Params melonTvProgramCnpckListMvReq$Params0) {
        super(context0, 0, MelonTvProgramCnpckListMvRes.class);
        this.addParams(melonTvProgramCnpckListMvReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/program/cnpck/listMv.json";
    }
}

