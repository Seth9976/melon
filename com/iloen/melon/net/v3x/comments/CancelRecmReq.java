package com.iloen.melon.net.v3x.comments;

import android.content.Context;

public class CancelRecmReq extends CmtBaseReq {
    public static class Params implements com.iloen.melon.net.v3x.comments.CmtBaseReq.Params {
        public int chnlSeq;
        public int cmtSeq;
        public String contsRefValue;
        public boolean nonRecmFlag;

        public Params() {
            this.chnlSeq = -1;
            this.contsRefValue = "";
            this.cmtSeq = -1;
            this.nonRecmFlag = false;
        }
    }

    public CancelRecmReq(Context context0, Params cancelRecmReq$Params0) {
        super(context0, 1, CancelRecmRes.class, cancelRecmReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cmt/api/api_cancelRecm.json";
    }
}

