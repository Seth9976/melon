package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.Collection;

public class LikeListSongBaseRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            @b("CONTSTYPECODE")
            public String contstypecode;
            private static final long serialVersionUID = 0x11174D3D8D5FE2F5L;

        }

        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xE3746FCF364C5A52L;
        @b("SONGLIST")
        public ArrayList songlist;
        @b("TOTALLIKESONG")
        public String totalLikeSong;
        @b("TOTALPLAYTIME")
        public String totalPlayTime;

        public RESPONSE() {
            this.songlist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xB05B9387BF06443BL;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE likeListSongBaseRes$RESPONSE0 = this.response;
        return likeListSongBaseRes$RESPONSE0 != null ? likeListSongBaseRes$RESPONSE0.songlist : null;
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

