package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.Collection;

public class BanListBannedSongRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class LISTSONG extends SongInfoBase {
            @b("EXCEPTDATE")
            public String exceptDate;
            private static final long serialVersionUID = 0x628976993942700DL;

            @Override  // com.melon.net.res.common.SongInfoBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("HASMORE")
        public boolean hasMore;
        @b("LISTSONG")
        public ArrayList listSong;
        @b("MSG")
        public String msg;
        private static final long serialVersionUID = 0x6703BE69F3DCFB26L;
        @b("TOTALCOUNT")
        public String totalCount;

        public RESPONSE() {
            this.listSong = null;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1014D290C2DA18C1L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE banListBannedSongRes$RESPONSE0 = this.response;
        return banListBannedSongRes$RESPONSE0 != null ? banListBannedSongRes$RESPONSE0.listSong : null;
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

