package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class DjPlaylistListV6Res extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class PLAYLIST extends ArtistPlayListInfoBase {
            @b("PLYLSTTYPECODE")
            public String playlistTypeCode;
            @b("PLYLSTCNT")
            public String plyLstCnt;
            private static final long serialVersionUID = -8894788660009004309L;

            public PLAYLIST() {
                this.playlistTypeCode = null;
                this.plyLstCnt = "";
            }
        }

        @b("DJPLAYLISTLIST")
        public ArrayList djPlaylists;
        @b("HASMORE")
        public boolean hasMore;
        @b("MULTIDELMAXCNT")
        public int multiDelMaxCnt;
        private static final long serialVersionUID = 0x3204AADE5789B68FL;

        public RESPONSE() {
            this.djPlaylists = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x4E6844BF8912CB66L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE djPlaylistListV6Res$RESPONSE0 = this.response;
        return djPlaylistListV6Res$RESPONSE0 != null ? djPlaylistListV6Res$RESPONSE0.djPlaylists : null;
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

