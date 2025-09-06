package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.PlaylistSongInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class DjConnectedPlaylistSongsRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends PlaylistSongInfoBase {
            private static final long serialVersionUID = 0x7B06249351338D9FL;

        }

        public static class STATSELEMENTS extends StatsElementsBase {
            private static final long serialVersionUID = 0x556273E505B83EA1L;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("PLAYLISTTITLE")
        public String playlistTitle;
        private static final long serialVersionUID = 0x2CC479CAB2590816L;
        @b("SONGLIST")
        public ArrayList songList;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;

        public RESPONSE() {
            this.hasMore = false;
            this.playlistTitle = null;
            this.songList = null;
            this.statsElements = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x79B255E5E90836ADL;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        Collection collection0 = new ArrayList();
        RESPONSE djConnectedPlaylistSongsRes$RESPONSE0 = this.response;
        if(djConnectedPlaylistSongsRes$RESPONSE0 != null) {
            ArrayList arrayList0 = djConnectedPlaylistSongsRes$RESPONSE0.songList;
            if(arrayList0 != null) {
                ((ArrayList)collection0).addAll(arrayList0);
            }
        }
        return collection0;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        RESPONSE djConnectedPlaylistSongsRes$RESPONSE0 = this.response;
        return djConnectedPlaylistSongsRes$RESPONSE0 != null ? djConnectedPlaylistSongsRes$RESPONSE0.statsElements : null;
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

