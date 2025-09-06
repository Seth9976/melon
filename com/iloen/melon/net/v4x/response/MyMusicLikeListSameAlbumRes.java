package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MyMusicLikeListSameAlbumRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class ALBUMLIST extends AlbumInfoBase {
            @b("CONTSTYPECODE")
            public String contstypecode;
            private static final long serialVersionUID = 4293403568764528077L;

            public ALBUMLIST() {
                this.contstypecode = "";
            }
        }

        @b("ALBUMLIST")
        public ArrayList albumlist;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x8B2799B5448032AEL;

        public RESPONSE() {
            this.albumlist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xA432EB5B7D3C9BF2L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE myMusicLikeListSameAlbumRes$RESPONSE0 = this.response;
        return myMusicLikeListSameAlbumRes$RESPONSE0 != null ? myMusicLikeListSameAlbumRes$RESPONSE0.albumlist : null;
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

