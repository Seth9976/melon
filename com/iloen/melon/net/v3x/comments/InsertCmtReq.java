package com.iloen.melon.net.v3x.comments;

import android.content.Context;
import java.util.ArrayList;

public class InsertCmtReq extends CmtBaseReq {
    public static class Params implements com.iloen.melon.net.v3x.comments.CmtBaseReq.Params {
        public static class AtachList implements InnerParams {
            public int atachDsplyOrder;
            public String atachThumbUrl;
            public String atachType;
            public String atachValue;
            public int atachVideoHeight;
            public String atachVideoTitle;
            public int atachVideoWidth;

            public AtachList() {
                this.atachType = "";
                this.atachDsplyOrder = -1;
                this.atachValue = "";
                this.atachThumbUrl = "";
                this.atachVideoTitle = "";
                this.atachVideoWidth = -1;
                this.atachVideoHeight = -1;
            }
        }

        public ArrayList atachList;
        public int chnlSeq;
        public String contsRefUrl;
        public String contsRefValue;
        public String cpId;
        public String cpKey;
        public boolean secrtFlag;
        public String stickerSeq;
        public ArrayList syncpstList;

        public Params() {
            this.chnlSeq = -1;
            this.contsRefValue = "";
            this.contsRefUrl = "";
            this.secrtFlag = false;
            this.stickerSeq = "";
            this.cpId = "AS40";
            this.cpKey = "14LNC3";
        }
    }

    public InsertCmtReq(Context context0, Params insertCmtReq$Params0) {
        super(context0, 1, InsertCmtRes.class, insertCmtReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cmt/api/api_insertCmt.json";
    }
}

