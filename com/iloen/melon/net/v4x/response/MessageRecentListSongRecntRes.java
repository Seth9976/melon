package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.Collection;

public class MessageRecentListSongRecntRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            @b("CONTSTYPECODE")
            public String contstypecode;
            private static final long serialVersionUID = 0x886B92B356E8A714L;

            public SONGLIST() {
                this.contstypecode = "";
            }
        }

        @b("GUIDETEXT")
        public String guidetext;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x99C2204926F70A34L;
        @b("SONGLIST")
        public ArrayList songlist;

        public RESPONSE() {
            this.songlist = null;
            this.guidetext = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x3F6CA9018BA38CAFL;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE messageRecentListSongRecntRes$RESPONSE0 = this.response;
        return messageRecentListSongRecntRes$RESPONSE0 != null ? messageRecentListSongRecntRes$RESPONSE0.songlist : null;
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

