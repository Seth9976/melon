package com.iloen.melon.net.v4x.request;

import android.content.Context;

public class CmtPvLogDummyReq extends PvLogDummyReq {
    public static class CmtViewType {
        public static final String LIST = "list";
        public static final String VIEW = "view";
        public static final String WRITE = "write";

    }

    public static final class Params {
        public String chnlSeq;
        public String cmtSeq;
        public String contsRefValue;
        public String type;

    }

    public CmtPvLogDummyReq(Context context0, Params cmtPvLogDummyReq$Params0) {
        super(context0, "reply");
        this.addParams(cmtPvLogDummyReq$Params0);
    }
}

