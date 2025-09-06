package com.iloen.melon.net.v3x.comments;

import android.content.Context;

public class InformCmtReq extends CmtBaseReq {
    public static class Params implements com.iloen.melon.net.v3x.comments.CmtBaseReq.Params {
        public boolean adcmtListFlag;
        public int chnlSeq;
        public boolean cmtContFlag;
        public int cmtSeq;
        public String contsRefValue;
        public int mypageMemberKey;

        public Params() {
            this.chnlSeq = -1;
            this.contsRefValue = "";
            this.cmtSeq = -1;
            this.adcmtListFlag = false;
            this.cmtContFlag = false;
            this.mypageMemberKey = -1;
        }
    }

    public InformCmtReq(Context context0, Params informCmtReq$Params0) {
        super(context0, 0, InformCmtRes.class, informCmtReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cmt/api/api_informCmt.json";
    }
}

