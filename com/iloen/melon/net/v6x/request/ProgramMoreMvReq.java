package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ProgramMoreMvRes;

public class ProgramMoreMvReq extends RequestV6Req {
    public static class Params {
        public String cnpckSeq;
        public String mvTypeCode;
        public String orderBy;
        public int pageSize;
        public String progSeq;
        public int startIndex;

        public Params() {
            this.pageSize = 100;
        }
    }

    public ProgramMoreMvReq(Context context0, Params programMoreMvReq$Params0) {
        super(context0, 0, ProgramMoreMvRes.class);
        this.addParams(programMoreMvReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/program/more/mv.json";
    }
}

