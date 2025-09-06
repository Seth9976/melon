package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class ArtistMusicRecmtrackSongListRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            private static final long serialVersionUID = 0xC6E6138688D4FE0DL;

        }

        private static final long serialVersionUID = 1459469918200487060L;
        @b("SONGLIST")
        public ArrayList songList;
        @b("TOTALCNT")
        public String totalCnt;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x2069A8D95D0F2945L;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

