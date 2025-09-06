package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MyMusicLikeUpdateListArtistPlaylistRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class ARTISTPLAYLISTLIST extends ArtistPlayListInfoBase {
            private static final long serialVersionUID = 0x981536BC5383EE10L;

        }

        @b("ARTISTPLAYLISTLIST")
        public ArrayList artistplaylistlist;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = -2944068736168856709L;

        public RESPONSE() {
            this.artistplaylistlist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x433079ADCA6C1409L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE myMusicLikeUpdateListArtistPlaylistRes$RESPONSE0 = this.response;
        return myMusicLikeUpdateListArtistPlaylistRes$RESPONSE0 != null ? myMusicLikeUpdateListArtistPlaylistRes$RESPONSE0.artistplaylistlist : null;
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

