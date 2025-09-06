package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class FeedLogsNewsCountRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        @b("NEWSCOUNT")
        public int newsCount;
        private static final long serialVersionUID = 0xE933AD9A470C8A1CL;

        public Response() {
            this.newsCount = 0;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x49D04A65130D32C1L;

}

