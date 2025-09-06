package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;

public class NowplayingInformSongInfoRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class SONGINFO extends SongInfoBase {
            private static final long serialVersionUID = 0x78FBAE0B66E3CFDFL;

        }

        @b("LYRIC")
        public String lyric;
        private static final long serialVersionUID = -8703600590314326853L;
        @b("SONGINFO")
        public SONGINFO songinfo;

        public RESPONSE() {
            this.songinfo = null;
            this.lyric = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 6420306546872079558L;

    public NowplayingInformSongInfoRes() {
        this.response = null;
    }
}

