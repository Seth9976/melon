package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class GenreDetailGuiType4Res extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class ALBUMLIST extends AlbumInfoBase {
            private static final long serialVersionUID = 0x17FE6138821B8BC4L;

        }

        public static class SONGLIST extends SongInfoBase {
            private static final long serialVersionUID = 0x8513CF29E17BC52L;

        }

        @b("ALBUMLIST")
        public ArrayList albumList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x59A4A7E3C6271443L;
        @b("SONGLIST")
        public ArrayList songList;

        public RESPONSE() {
            this.songList = null;
            this.albumList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 8168052355014667806L;

    public GenreDetailGuiType4Res() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

