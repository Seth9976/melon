package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.PlaylistSongInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.response.DetailBaseRes.DetailResponseBase;
import com.iloen.melon.net.v5x.response.DetailBaseRes;
import java.util.ArrayList;
import java.util.Collection;

public class MelonDjPlaylistListSongRes extends DetailBaseRes implements ResponseAdapter {
    public static class RESPONSE extends DetailResponseBase {
        public static class SONGLIST extends PlaylistSongInfoBase {
            private static final long serialVersionUID = 0x31F6A830F2234DD7L;

        }

        public static class STATSELEMENTS extends StatsElementsBase {
            private static final long serialVersionUID = 0x556273E505B83EA1L;

        }

        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xAD443C8E1A84EB88L;
        @b("SONGLIST")
        public ArrayList songList;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;
        @b("TOTALCOUNT")
        public String totalCount;

        public RESPONSE() {
            this.songList = null;
            this.statsElements = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -5087981000932484272L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE melonDjPlaylistListSongRes$RESPONSE0 = this.response;
        return melonDjPlaylistListSongRes$RESPONSE0 != null ? melonDjPlaylistListSongRes$RESPONSE0.songList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() [...] // 潜在的解密器

    @Override  // com.iloen.melon.net.v5x.response.DetailBaseRes
    public DetailResponseBase getResponseBase() {
        return this.response;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        RESPONSE melonDjPlaylistListSongRes$RESPONSE0 = this.response;
        return melonDjPlaylistListSongRes$RESPONSE0 != null ? melonDjPlaylistListSongRes$RESPONSE0.statsElements : null;
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

