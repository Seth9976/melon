package com.iloen.melon.net.v3x.comments;

import android.content.Context;

public class InsertRecmReq extends CmtBaseReq {
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

    public InsertRecmReq(Context context0, Params insertRecmReq$Params0) {
        super(context0, 1, InsertRecmRes.class, insertRecmReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cmt/api/v2/api_insertRecm.json";
    }
}

