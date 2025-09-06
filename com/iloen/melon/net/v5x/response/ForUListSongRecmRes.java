package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.Collection;

public class ForUListSongRecmRes extends ResponseV5Res implements ResponseAdapter {
    public static class Response extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            private static final long serialVersionUID = 0x2D7829A92C06BAA3L;

        }

        public static class STATSELEMENTS extends StatsElementsBase {
            private static final long serialVersionUID = 7671173760985518008L;

        }

        private static final long serialVersionUID = 0x786D2327CEF16890L;
        @b("SONGLIST")
        public ArrayList songList;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;
        @b("TITLE")
        public String title;

        public Response() {
            this.title = "";
            this.songList = null;
            this.statsElements = null;
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0xACFB9DA9573A5066L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        Response forUListSongRecmRes$Response0 = this.response;
        return forUListSongRecmRes$Response0 != null ? forUListSongRecmRes$Response0.songList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        Response forUListSongRecmRes$Response0 = this.response;
        return forUListSongRecmRes$Response0 != null ? forUListSongRecmRes$Response0.statsElements : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return false;
    }
}

