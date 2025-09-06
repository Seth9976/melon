package com.iloen.melon.net.v4x.request;

import android.content.Context;

public class UaLogDummyFilterReq extends UaLogDummyReq {
    public static class Params {
        public static final String FILTER_TYPE_OFF = "SET02";
        public static final String FILTER_TYPE_ON = "SET01";
        public static final String FILTER_VALUE_OFF = "02";
        public static final String FILTER_VALUE_ON = "01";
        public String contentsId;
        public String filterType;
        public String filterValue;
        public String orderBy;

    }

    public UaLogDummyFilterReq(Context context0, String s) {
        super(context0, s);
    }

    public UaLogDummyFilterReq(Context context0, String s, Params uaLogDummyFilterReq$Params0) {
        super(context0, s);
        this.addParams(uaLogDummyFilterReq$Params0);
    }
}

