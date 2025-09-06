package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;

public class ChartStreamingCardUploadRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class INFO implements Serializable {
            @b("ext")
            public String ext;
            @b("filename")
            public String filename;
            @b("orgname")
            public String orgname;
            private static final long serialVersionUID = 0x402E500046F6F57FL;
            @b("size")
            public String size;

        }

        @b("ACCESS_KEY")
        public String accessKey;
        @b("IMGURL")
        public String imgUrl;
        @b("INFO")
        public INFO info;
        @b("SHORTENURL")
        public String shortenUrl;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 1960986605573882995L;

    public ChartStreamingCardUploadRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

