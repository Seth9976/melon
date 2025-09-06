package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.PlaylistSongInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class MyMusicPlaylistRecentListSongRecntRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends PlaylistSongInfoBase {
            private static final long serialVersionUID = 0xA26954D0B2086FD4L;

        }

        public static class STATSELEMENTS extends StatsElementsBase {
            private static final long serialVersionUID = -8672203563448095087L;

        }

        @b("GUIDETEXT")
        public String guideText;
        @b("PLAYLISTTITLE")
        public String playlistTitle;
        private static final long serialVersionUID = 0xEEBF85178D174493L;
        @b("SONGLIST")
        public ArrayList songList;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;

        public RESPONSE() {
            this.songList = null;
            this.guideText = "";
            this.statsElements = null;
            this.playlistTitle = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x176CD79705A3E798L;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

