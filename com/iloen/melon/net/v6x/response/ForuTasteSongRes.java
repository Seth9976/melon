package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.Collection;

public class ForuTasteSongRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            private static final long serialVersionUID = 5154099697075109541L;

        }

        @b("ARTISTIDS")
        public String artistIds;
        private static final long serialVersionUID = 0xACCCA3D21C73A6D9L;
        @b("SONGLIST")
        public ArrayList songList;
        @b("TAGSEQS")
        public String tagSeqs;

        public RESPONSE() {
            this.songList = null;
            this.artistIds = "";
            this.tagSeqs = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 1752848890770331109L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE foruTasteSongRes$RESPONSE0 = this.response;
        return foruTasteSongRes$RESPONSE0 != null ? foruTasteSongRes$RESPONSE0.songList : null;
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
        return false;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

