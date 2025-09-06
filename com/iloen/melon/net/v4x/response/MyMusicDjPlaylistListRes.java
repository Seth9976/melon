package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MyMusicDjPlaylistListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class PLAYLISTLIST extends ArtistPlayListInfoBase {
            private static final long serialVersionUID = -8894788660009004309L;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("PLAYLISTLIST")
        public ArrayList playlistlist;
        private static final long serialVersionUID = 0x3204AADE5789B68FL;

        public RESPONSE() {
            this.playlistlist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xBC8FCA4D2997109L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE myMusicDjPlaylistListRes$RESPONSE0 = this.response;
        return myMusicDjPlaylistListRes$RESPONSE0 != null ? myMusicDjPlaylistListRes$RESPONSE0.playlistlist : null;
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

