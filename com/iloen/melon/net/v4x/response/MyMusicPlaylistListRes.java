package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MyMusicPlaylistListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class PLAYLISTLIST extends ArtistPlayListInfoBase {
            private static final long serialVersionUID = 0x63576E51AAEEE5EAL;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("PLAYLISTLIST")
        public ArrayList playlistlist;
        private static final long serialVersionUID = 0x729C14B29D024F7DL;

        public RESPONSE() {
            this.playlistlist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xEAC94C6623A452D6L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE myMusicPlaylistListRes$RESPONSE0 = this.response;
        return myMusicPlaylistListRes$RESPONSE0 != null ? myMusicPlaylistListRes$RESPONSE0.playlistlist : null;
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

