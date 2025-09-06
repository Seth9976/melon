package com.iloen.melon.net.v3x.comments;

import android.content.Context;

public class DeleteCmtReq extends CmtBaseReq {
    public static class Params implements com.iloen.melon.net.v3x.comments.CmtBaseReq.Params {
        public int chnlSeq;
        public int cmtSeq;
        public String contsRefValue;

        public Params() {
            this.chnlSeq = -1;
            this.contsRefValue = "";
            this.cmtSeq = -1;
        }
    }

    public DeleteCmtReq(Context context0, Params deleteCmtReq$Params0) {
        super(context0, 1, DeleteCmtRes.class, deleteCmtReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cmt/api/api_deleteCmt.json";
    }
}

