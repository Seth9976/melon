package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class InsertExcArtistRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        @b("EXCARTISTSEQ")
        public String excArtistSeq;
        @b("MESSAGE")
        public String message;
        private static final long serialVersionUID = 0x4F85F0604D6CBF96L;

        public Response() {
            this.message = "";
            this.excArtistSeq = "";
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x290A0F3C65379AD1L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

