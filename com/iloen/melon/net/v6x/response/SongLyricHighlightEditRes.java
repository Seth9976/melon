package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class SongLyricHighlightEditRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("HIGHLIGHTLINE")
        public String hightlightLine;
        @b("LYRIC")
        public String lyric;
        @b("PAGEMETAID")
        public String pageMetaId;
        @b("PAGEMETANAME")
        public String pageMetaName;
        private static final long serialVersionUID = 0x6953ABB3C4ACDCA1L;

        public RESPONSE() {
            this.hightlightLine = "";
            this.lyric = "";
            this.pageMetaId = "";
            this.pageMetaName = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x8846D218330B282L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

