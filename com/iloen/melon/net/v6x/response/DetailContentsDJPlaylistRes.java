package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.Collection;
import java.util.List;

public class DetailContentsDJPlaylistRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        @b("DJPLAYLISTLIST")
        public List PLAYLISTS;
        @b("HASMORE")
        public boolean hasMore;
        @b("PAGEMETANAME")
        public String pageMetaName;
        private static final long serialVersionUID = 0x244550BC2D3A0CD0L;

        public RESPONSE() {
            this.hasMore = false;
            this.pageMetaName = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xE84D231FCF764131L;

    public DetailContentsDJPlaylistRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE detailContentsDJPlaylistRes$RESPONSE0 = this.response;
        return detailContentsDJPlaylistRes$RESPONSE0 != null ? detailContentsDJPlaylistRes$RESPONSE0.PLAYLISTS : null;
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

