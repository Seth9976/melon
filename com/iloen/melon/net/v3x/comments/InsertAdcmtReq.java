package com.iloen.melon.net.v3x.comments;

import android.content.Context;

public class InsertAdcmtReq extends CmtBaseReq {
    public static class Params implements com.iloen.melon.net.v3x.comments.CmtBaseReq.Params {
        public int chnlSeq;
        public String cmtCont;
        public String contsRefUrl;
        public String contsRefValue;
        public int parntCmtSeq;
        public boolean secrtFlag;
        public String stickerSeq;

        public Params() {
            this.chnlSeq = -1;
            this.contsRefValue = "";
            this.parntCmtSeq = -1;
            this.cmtCont = "";
            this.secrtFlag = false;
            this.stickerSeq = "";
            this.contsRefUrl = "";
        }
    }

    public InsertAdcmtReq(Context context0, Params insertAdcmtReq$Params0) {
        super(context0, 1, InsertAdcmtRes.class, insertAdcmtReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cmt/api/api_insertAdcmt.json";
    }
}

