package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.Collection;

public class MyMusicTopListSongManyRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            @b("CONTSTYPECODE")
            public String contstypecode;
            @b("RANK")
            public String rank;
            private static final long serialVersionUID = 0xA36FE88D5636F88DL;

            public SONGLIST() {
                this.contstypecode = "";
            }
        }

        @b("GUIDETEXT")
        public String guidetext;
        @b("HASMORE")
        public boolean hasMore;
        @b("MONTHTEXT")
        public String monthText;
        private static final long serialVersionUID = 0x7AC8F265CE077AFBL;
        @b("SONGLIST")
        public ArrayList songlist;

        public RESPONSE() {
            this.songlist = null;
            this.guidetext = "";
            this.monthText = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -4129832001303485806L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE myMusicTopListSongManyRes$RESPONSE0 = this.response;
        return myMusicTopListSongManyRes$RESPONSE0 != null ? myMusicTopListSongManyRes$RESPONSE0.songlist : null;
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

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

