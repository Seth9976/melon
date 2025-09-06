package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MyMusicPlaylistListV6Res extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class PLAYLISTLIST extends ArtistPlayListInfoBase {
            private static final long serialVersionUID = 0x63576E51AAEEE5EAL;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("MULTIDELMAXCNT")
        public int multiDelMaxCnt;
        @b("PLAYLISTLIST")
        public ArrayList playlistList;
        private static final long serialVersionUID = 0xD0F0209F6400240AL;

        public RESPONSE() {
            this.playlistList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x310529280E459303L;

    public MyMusicPlaylistListV6Res() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE myMusicPlaylistListV6Res$RESPONSE0 = this.response;
        return myMusicPlaylistListV6Res$RESPONSE0 != null ? myMusicPlaylistListV6Res$RESPONSE0.playlistList : null;
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

