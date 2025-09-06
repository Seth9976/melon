package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.Collection;

public class ArtistMusicSongListRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            private static final long serialVersionUID = 0x4A26FEC4D2EEAF87L;

        }

        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x28C58CEFE8803B2DL;
        @b("SONGLIST")
        public ArrayList songlist;

        public RESPONSE() {
            this.songlist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xF780E1C90A74E086L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE artistMusicSongListRes$RESPONSE0 = this.response;
        return artistMusicSongListRes$RESPONSE0 != null ? artistMusicSongListRes$RESPONSE0.songlist : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() [...] // 潜在的解密器

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response != null && this.response.hasMore;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

