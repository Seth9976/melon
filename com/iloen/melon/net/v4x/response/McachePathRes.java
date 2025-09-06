package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.SolMetaBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class McachePathRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class ContentsInfo extends com.iloen.melon.net.v4x.response.StreamGetSongInfoRes.RESPONSE.ContentsInfo {
        }

        public static class GetPathInfo extends SolMetaBase {
            @b("BINFO")
            public String binfo;
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
            @b("METATYPE")
            public String metatype;
            @b("PATH")
            public String path;

            public GetPathInfo() {
                this.cid = "";
                this.path = "";
                this.metatype = "";
                this.bitrate = "";
                this.ishttps = false;
                this.c = "";
                this.binfo = "";
                this.fileupdate = "";
                this.filesize = "";
            }
        }

        @b("CONTENTSINFO")
        public ArrayList contentsInfo;
        @b("GETPATHINFO")
        public GetPathInfo getpathinfo;
        @b("PRODUCTINFO")
        public String productInfo;
        @b("RESULT")
        public int result;
        private static final long serialVersionUID = 0xA7C63EFE3454F2A1L;

        public RESPONSE() {
            this.productInfo = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x5062AF41578CEA54L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

