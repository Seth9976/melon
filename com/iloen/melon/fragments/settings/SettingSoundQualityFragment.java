package com.iloen.melon.fragments.settings;

import com.iloen.melon.net.v4x.request.UaLogDummyFilterReq.Params;
import com.iloen.melon.net.v4x.request.UaLogDummyFilterReq;
import p8.O;

public abstract class SettingSoundQualityFragment extends SettingBaseFragment {
    protected static final String FILTER_AAC = "SQ01";
    protected static final String FILTER_AAC_128 = "SQ02";
    protected static final String FILTER_AAC_320 = "SQ05";
    protected static final String FILTER_MP3_192 = "SQ03";
    protected static final String FILTER_MP3_320 = "SQ04";
    protected static final String FILTER_WIFI = "SQ06";
    protected static final String FILTER_WIFI_LTE = "SQ07";

    public void sendUALog(String s, String s1) {
        Params uaLogDummyFilterReq$Params0 = new Params();
        uaLogDummyFilterReq$Params0.filterType = s1;
        O.a(new UaLogDummyFilterReq(this.getContext(), s, uaLogDummyFilterReq$Params0));
    }
}

