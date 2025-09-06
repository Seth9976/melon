package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class GenreMoreNewMusicRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            private static final long serialVersionUID = 0x1387E7208B060AEEL;

        }

        @b("ALBUMLIST")
        public ArrayList albumList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x7E2CC9B0603380AFL;
        @b("SONGLIST")
        public ArrayList songList;

        public RESPONSE() {
            this.songList = null;
            this.albumList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 8813885700006687654L;

    public GenreMoreNewMusicRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

