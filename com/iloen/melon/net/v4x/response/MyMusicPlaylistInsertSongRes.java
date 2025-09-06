package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MyMusicPlaylistInsertSongRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("INSERTSONGCNT")
        public String insertSongCnt;
        private static final long serialVersionUID = 0x30C28C6681C7B1DL;

        public RESPONSE() {
            this.insertSongCnt = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xA3A6679DE50C6AEBL;

    public MyMusicPlaylistInsertSongRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

