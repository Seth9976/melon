package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.SolMetaBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class DownloadPathRes extends ResponseV4Res {
    public static final class Response extends ResponseBase {
        public static final class ContentsInfo extends SolMetaBase {
            @b("BITRATE")
            public String bitrate;
            @b("CID")
            public String cId;
            @b("CDNO")
            public String cdNo;
            @b("CONTENTIMGPATH")
            public String contentImgPath;
            @b("CONTENTIMGPATHLARGE")
            public String contentImgPathLarge;
            @b("FILESIZE")
            public String fileSize;
            @b("FILENAME")
            public String filename;
            @b("LYRICFILEUPDTDATE")
            public String lyricFileUpdtDate;
            @b("LYRICPATH")
            public String lyricPath;
            @b("PATH")
            public String path;
            @b("PRODEXPIREDATE")
            public String prodExpireDate;
            @b("TRACKNO")
            public String trackNo;

            @Override  // com.iloen.melon.net.v4x.common.SolMetaBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("CONTENTSINFO")
        public ArrayList contentsInfo;
        @b("CONTENTSSIZE")
        public int contentsSize;
        @b("RESULT")
        public String result;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

