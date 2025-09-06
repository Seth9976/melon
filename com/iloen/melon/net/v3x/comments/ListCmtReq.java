package com.iloen.melon.net.v3x.comments;

import android.content.Context;

public class ListCmtReq extends CmtBaseReq {
    public static class Params implements com.iloen.melon.net.v3x.comments.CmtBaseReq.Params {
        public int chnlSeq;
        public String contsRefValue;
        public int filterType;
        public int mypageMemberKey;
        public int pageGroupSize;
        public int pageNo;
        public int pageSize;
        public int sortType;
        public int srchType;
        public String srchWord;
        public int startSeq;
        public int totalCnt;
        public int validCnt;

        public Params() {
            this.chnlSeq = -1;
            this.contsRefValue = "";
            this.totalCnt = -1;
            this.validCnt = -1;
            this.startSeq = -1;
            this.sortType = -1;
            this.srchType = -1;
            this.srchWord = "";
            this.pageNo = -1;
            this.pageSize = -1;
            this.mypageMemberKey = -1;
            this.pageGroupSize = -1;
            this.filterType = 0;
        }
    }

    public ListCmtReq(Context context0, Params listCmtReq$Params0) {
        super(context0, 0, ListCmtRes.class, listCmtReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cmt/api/api_listCmt.json";
    }
}

