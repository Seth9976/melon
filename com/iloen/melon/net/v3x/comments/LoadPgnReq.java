package com.iloen.melon.net.v3x.comments;

import android.content.Context;

public class LoadPgnReq extends CmtBaseReq {
    public static class Params implements com.iloen.melon.net.v3x.comments.CmtBaseReq.Params {
        public int chnlSeq;
        public boolean cmtListFlag;
        public String contsRefValue;
        public int filterType;
        public int mypageMemberKey;
        public int pageGroupSize;
        public int pageNo;
        public int pageSize;
        public int sortType;
        public int srchType;
        public String srchWord;

        public Params() {
            this.chnlSeq = -1;
            this.contsRefValue = "";
            this.sortType = -1;
            this.srchType = -1;
            this.srchWord = "";
            this.pageNo = -1;
            this.pageSize = -1;
            this.cmtListFlag = true;
            this.mypageMemberKey = -1;
            this.pageGroupSize = -1;
            this.filterType = 0;
        }
    }

    public LoadPgnReq(Context context0, Params loadPgnReq$Params0) {
        super(context0, 0, LoadPgnRes.class, loadPgnReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cmt/api/api_loadPgn.json";
    }
}

