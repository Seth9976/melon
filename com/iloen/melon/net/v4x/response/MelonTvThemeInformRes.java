package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class MelonTvThemeInformRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class MVLIST extends MvInfoBase {
            private static final long serialVersionUID = 0xF704CB1667DED6A4L;

        }

        public static class PROG implements Serializable {
            @b("PROGDESC")
            public String progDesc;
            @b("PROGIMAGEURL")
            public String progImageUrl;
            @b("PROGNAME")
            public String progName;
            @b("PROGSEQ")
            public String progSeq;
            private static final long serialVersionUID = 0x8DF4A6ABD14D6BA8L;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("LISTTITLE")
        public String listTitle;
        @b("MVCNT")
        public String mvCnt;
        @b("MVLIST")
        public ArrayList mvList;
        @b("PROG")
        public PROG prog;
        private static final long serialVersionUID = 0xA574AD7F8F70D6D8L;

        public RESPONSE() {
            this.hasMore = false;
            this.mvCnt = "";
            this.listTitle = "";
            this.prog = null;
            this.mvList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xEDBCDD8DE936A973L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE melonTvThemeInformRes$RESPONSE0 = this.response;
        return melonTvThemeInformRes$RESPONSE0 != null ? melonTvThemeInformRes$RESPONSE0.mvList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response == null ? false : this.response.hasMore;
    }
}

