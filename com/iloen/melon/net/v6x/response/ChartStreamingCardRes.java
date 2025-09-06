package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class ChartStreamingCardRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        @b("ALBUMIMG")
        public String albumImg;
        @b("ARTISTNAME")
        public String artistName;
        @b("MYSTREAMCOUNT")
        public String myStreamCount;
        private static final long serialVersionUID = 0xBDDB0E80BA4B7D89L;
        @b("SONGID")
        public String songId;
        @b("SONGNAME")
        public String songName;
        @b("STREAMCOUNT")
        public String streamCount;
        @b("STREAMCOUNTEMOJI")
        public String streamCountEmoji;
        @b("STREAMUSER")
        public String streamUser;
        @b("STREAMUSEREMOJI")
        public String streamUserEmoji;
        @b("UPDTDATE")
        public String updtDate;

    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x848A1C379F1C1496L;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() [...] // 潜在的解密器

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

