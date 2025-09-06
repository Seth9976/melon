package com.iloen.melon.net.androidauto.response;

import S7.b;
import com.iloen.melon.net.v5x.response.CastDetailRes.STATSELEMENTS;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class DetailListSongRes extends RequestAutoRes {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 2994533576939003475L;
        @b("LIST")
        public ArrayList songList;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;

        public RESPONSE() {
            this.songList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xC6A385AD8B5FA6D8L;

}

