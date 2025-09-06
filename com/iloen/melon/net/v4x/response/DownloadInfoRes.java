package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.SolMetaBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class DownloadInfoRes extends ResponseV4Res {
    public static final class Response extends ResponseBase {
        public static final class ContentsInfo extends SolMetaBase {
            @b("CID")
            public String cId;
            @b("FILENAME")
            public String filename;

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

        public Response() {
            this.result = "";
        }

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

