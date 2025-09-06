package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.SolMetaBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class StreamGetPathRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class GetPathInfo extends SolMetaBase {
            @b("BITRATE")
            public String bitrate;
            @b("C")
            public String c;
            @b("CID")
            public String cid;
            @b("FILESIZE")
            public String filesize;
            @b("FILEUPDTDATE")
            public String fileupdate;
            @b("ISHTTPS")
            public boolean ishttps;
            public String ldbpath;
            @b("LOGGINGTOKEN")
            public String loggingtoken;
            @b("METATYPE")
            public String metatype;
            @b("PINTERVAL")
            public int pInterval;
            @b("PATH")
            public String path;
            @b("PLAYTOKEN")
            public String playToken;
            @b("PLAYTIME")
            public String playtime;
            @b("PROTOCOLTYPE")
            public String protocoltype;
            @b("RTCNT")
            public String rtCnt;
            @b("SKIPCNT")
            public String skipCnt;

            public GetPathInfo() {
                this.playtime = "";
                this.cid = "";
                this.path = "";
                this.loggingtoken = "";
                this.protocoltype = "";
                this.ldbpath = "";
                this.bitrate = "";
                this.metatype = "";
                this.c = "";
                this.fileupdate = "";
                this.filesize = "";
                this.ishttps = false;
                this.rtCnt = "";
                this.skipCnt = "";
                this.pInterval = -1;
                this.playToken = "";
            }
        }

        @b("CONTENTSINFO")
        public ArrayList contentsInfo;
        @b("GETPATHINFO")
        public GetPathInfo getpathinfo;
        @b("ISFLAC16STALLOK")
        public boolean isflac16stallok;
        @b("ISFLACSTOK")
        public boolean isflacstok;
        @b("PRODUCTINFO")
        public String productInfo;
        private static final long serialVersionUID = 0xC489DB18D18F3D51L;

        public RESPONSE() {
            this.isflacstok = false;
            this.isflac16stallok = false;
            this.productInfo = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x7C99B0D573363C66L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

