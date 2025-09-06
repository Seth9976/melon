package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MyMusicLikeListSameDjPlaylistRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class DJPLAYLISTLIST extends ArtistPlayListInfoBase {
            private static final long serialVersionUID = 0x5B67D94286CEBEFL;

        }

        @b("DJPLAYLISTLIST")
        public ArrayList djplaylistlist;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x26B7605C3D9F13A8L;

        public RESPONSE() {
            this.djplaylistlist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xFA06B65FE105B441L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE myMusicLikeListSameDjPlaylistRes$RESPONSE0 = this.response;
        return myMusicLikeListSameDjPlaylistRes$RESPONSE0 != null ? myMusicLikeListSameDjPlaylistRes$RESPONSE0.djplaylistlist : null;
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

