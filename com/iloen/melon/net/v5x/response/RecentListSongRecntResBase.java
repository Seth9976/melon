package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.Collection;

public class RecentListSongRecntResBase extends ResponseV5Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            @b("CONTSTYPECODE")
            public String contstypecode;
            private static final long serialVersionUID = 0x7688C47EBCBAD45CL;

            public SONGLIST() {
                this.contstypecode = "";
            }
        }

        @b("GUIDETEXT")
        public String guidetext;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xCD4F5FBDA4809FF8L;
        @b("SONGLIST")
        public ArrayList songlist;

        public RESPONSE() {
            this.songlist = null;
            this.guidetext = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDE219EE9C0A290F2L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE recentListSongRecntResBase$RESPONSE0 = this.response;
        return recentListSongRecntResBase$RESPONSE0 != null ? recentListSongRecntResBase$RESPONSE0.songlist : null;
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

