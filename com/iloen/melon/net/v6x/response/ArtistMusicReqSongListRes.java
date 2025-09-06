package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

public class ArtistMusicReqSongListRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 0x310DA36CA0463B08L;
        @b("SONGLIST")
        public ArrayList songList;

        public RESPONSE() {
            this.songList = null;
        }
    }

    public static class SONGLIST extends SongInfoBase {
        private static final long serialVersionUID = 0x1C47E02823AEE61L;

    }

    public RESPONSE response;
    private static final long serialVersionUID = 0xF8859CFFB0B667E8L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE artistMusicReqSongListRes$RESPONSE0 = this.response;
        return artistMusicReqSongListRes$RESPONSE0 != null ? artistMusicReqSongListRes$RESPONSE0.songList : null;
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
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

