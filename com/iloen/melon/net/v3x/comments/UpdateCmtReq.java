package com.iloen.melon.net.v3x.comments;

import android.content.Context;
import java.util.ArrayList;

public class UpdateCmtReq extends CmtBaseReq {
    public static class Params implements com.iloen.melon.net.v3x.comments.CmtBaseReq.Params {
        public static class AtachList implements InnerParams {
            public int atachDsplyOrder;
            public int atachSeq;
            public String atachThumbUrl;
            public String atachType;
            public String atachValue;
            public int atachVideoHeight;
            public String atachVideoTitle;
            public int atachVideoWidth;

            public AtachList() {
                this.atachSeq = -1;
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
        public int cmtSeq;
        public String contsRefValue;
        public String stickerSeq;

        public Params() {
            this.chnlSeq = -1;
            this.contsRefValue = "";
            this.cmtSeq = -1;
            this.stickerSeq = "";
        }
    }

    public UpdateCmtReq(Context context0, Params updateCmtReq$Params0) {
        super(context0, 1, UpdateCmtRes.class, updateCmtReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cmt/api/api_updateCmt.json";
    }
}

