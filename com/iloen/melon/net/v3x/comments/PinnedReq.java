package com.iloen.melon.net.v3x.comments;

import android.content.Context;

public class PinnedReq extends CmtBaseReq {
    public static class Params implements com.iloen.melon.net.v3x.comments.CmtBaseReq.Params {
        public int chnlSeq;
        public int cmtSeq;
        public String contsRefValue;
        public boolean unpinnedFlag;

        public Params() {
            this.chnlSeq = -1;
            this.contsRefValue = "";
            this.cmtSeq = -1;
            this.unpinnedFlag = false;
        }
    }

    public PinnedReq(Context context0, Params pinnedReq$Params0) {
        super(context0, 1, PinnedRes.class, pinnedReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cmt/api/api_pinned.json";
    }
}

