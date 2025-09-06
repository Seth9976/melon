package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class SearchSettingSongWithPianoforteRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("KAKAOSERVERHOST")
        public String kakaoServerHost;
        @b("KAKAOSERVERPORT")
        public String kakaoServerPort;
        @b("KAKAOSERVERQUERYSTRING")
        public String kakaoServerQueryString;
        @b("KAKAOSERVERTRYCNT")
        public String kakaoServerTryCnt;
        @b("KAKAOSERVERURL")
        public String kakaoServerUrl;
        private static final long serialVersionUID = 0x3A3D0064ECF04679L;

        public RESPONSE() {
            this.kakaoServerHost = "";
            this.kakaoServerPort = "";
            this.kakaoServerQueryString = "";
            this.kakaoServerTryCnt = "";
            this.kakaoServerUrl = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -1227685442541700250L;

    public SearchSettingSongWithPianoforteRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

