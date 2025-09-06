package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class DjMembersDjPickPlaylistsRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class DJPLAYLISTLIST extends ArtistPlayListInfoBase {
            @b("ISREPPLYLST")
            public boolean isRepPlylst;
            private static final long serialVersionUID = 0xF88D4F78CFD8715L;

            public DJPLAYLISTLIST() {
                this.isRepPlylst = false;
            }
        }

        @b("DJPLAYLISTLIST")
        public ArrayList djPlaylistList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xF6F6958F28FB28FL;
        @b("TOTALCOUNT")
        public String totalCount;

        public RESPONSE() {
            this.hasMore = false;
            this.totalCount = "";
            this.djPlaylistList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x4DFCA3A6D3D5CF66L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE djMembersDjPickPlaylistsRes$RESPONSE0 = this.response;
        return djMembersDjPickPlaylistsRes$RESPONSE0 != null ? djMembersDjPickPlaylistsRes$RESPONSE0.djPlaylistList : null;
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
        return this.response != null && this.response.hasMore;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

