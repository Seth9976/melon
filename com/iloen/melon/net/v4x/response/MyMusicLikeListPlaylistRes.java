package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MyMusicLikeListPlaylistRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class PLAYLISTLIST extends ArtistPlayListInfoBase {
            private static final long serialVersionUID = 0xB957A30F23AB8645L;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("PLAYLISTLIST")
        public ArrayList playlistlist;
        private static final long serialVersionUID = -6189955638520091035L;

        public RESPONSE() {
            this.playlistlist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -6535228609707609101L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE myMusicLikeListPlaylistRes$RESPONSE0 = this.response;
        return myMusicLikeListPlaylistRes$RESPONSE0 != null ? myMusicLikeListPlaylistRes$RESPONSE0.playlistlist : null;
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

