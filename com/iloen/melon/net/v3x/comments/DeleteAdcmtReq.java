package com.iloen.melon.net.v3x.comments;

import android.content.Context;

public class DeleteAdcmtReq extends CmtBaseReq {
    public static class Params implements com.iloen.melon.net.v3x.comments.CmtBaseReq.Params {
        public int chnlSeq;
        public int cmtSeq;
        public String contsRefValue;
        public int parntCmtSeq;

        public Params() {
            this.chnlSeq = -1;
            this.contsRefValue = "";
            this.parntCmtSeq = -1;
            this.cmtSeq = -1;
        }
    }

    public DeleteAdcmtReq(Context context0, Params deleteAdcmtReq$Params0) {
        super(context0, 1, DeleteAdcmtRes.class, deleteAdcmtReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cmt/api/api_deleteAdcmt.json";
    }
}

