package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.Collection;
import java.util.List;

public class ForUDetailRes extends ArtistMusicBaseResV6 implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class LIST extends SongInfoBase {
            private static final long serialVersionUID = 0xB9CB3F4F93A17532L;

        }

        public static class MIX extends ForUMixInfoBase {
            private static final long serialVersionUID = 0x69FA501650EEAD36L;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("ISPOSSIBLEBANNED")
        public boolean isPossibleBanned;
        @b("LIST")
        public List list;
        @b("LISTARTISTFORU")
        public List listArtistForU;
        private static final long serialVersionUID = 0xE21A19219AF92C1EL;
        public List tagList;

        public RESPONSE() {
            this.list = null;
            this.listArtistForU = null;
            this.tagList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x4A4613A963C60CB0L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE forUDetailRes$RESPONSE0 = this.response;
        return forUDetailRes$RESPONSE0 != null ? forUDetailRes$RESPONSE0.list : null;
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

    @Override  // com.iloen.melon.net.v6x.response.ArtistMusicBaseResV6
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

