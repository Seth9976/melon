package com.iloen.melon.net.v3x.comments;

import android.content.Context;

public class InformCmtContsSummReq extends CmtBaseReq {
    public static class Params implements com.iloen.melon.net.v3x.comments.CmtBaseReq.Params {
        public int chnlSeq;
        public String contsRefValue;
        public int latestCmtSeq;

        public Params() {
            this.chnlSeq = -1;
            this.contsRefValue = "";
            this.latestCmtSeq = -1;
        }
    }

    public InformCmtContsSummReq(Context context0, Params informCmtContsSummReq$Params0) {
        super(context0, 0, InformCmtContsSummRes.class, informCmtContsSummReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cmt/api/api_informCmtContsSumm.json";
    }
}

