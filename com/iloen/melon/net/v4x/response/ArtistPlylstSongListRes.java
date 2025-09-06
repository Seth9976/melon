package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.Collection;
import java.util.List;

public class ArtistPlylstSongListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class CONTENTLIST extends SongInfoBase {
            private static final long serialVersionUID = 0xA446833CFF201CBEL;

        }

        public static class STATSELEMENTS extends StatsElementsBase {
            private static final long serialVersionUID = 0x556273E505B83EA1L;

        }

        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x61F88BD8FB7E0C08L;
        @b("CONTENTSLIST")
        public List songList;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;

        public RESPONSE() {
            this.songList = null;
            this.statsElements = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 3939701513531893064L;

    public ArtistPlylstSongListRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE artistPlylstSongListRes$RESPONSE0 = this.response;
        return artistPlylstSongListRes$RESPONSE0 != null ? artistPlylstSongListRes$RESPONSE0.songList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() [...] // 潜在的解密器

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        RESPONSE artistPlylstSongListRes$RESPONSE0 = this.response;
        return artistPlylstSongListRes$RESPONSE0 != null ? artistPlylstSongListRes$RESPONSE0.statsElements : null;
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

