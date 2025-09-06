package com.iloen.melon.net.v4x.request;

import android.content.Context;

public class ContsPvLogDummyReq extends PvLogDummyReq {
    public static final class Params {
        public String contsId;
        public String contsType;

    }

    public ContsPvLogDummyReq(Context context0, String s, Params contsPvLogDummyReq$Params0) {
        super(context0, s);
        this.addParams(contsPvLogDummyReq$Params0);
    }
}

