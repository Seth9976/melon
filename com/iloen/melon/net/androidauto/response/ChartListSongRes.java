package com.iloen.melon.net.androidauto.response;

import S7.b;
import com.iloen.melon.net.v5x.response.CastDetailRes.STATSELEMENTS;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class ChartListSongRes extends RequestAutoRes {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 0x142C4ACCCFD34393L;
        @b("SONGLIST")
        public ArrayList songList;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;

        public RESPONSE() {
            this.songList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x6151B265D60E5A41L;

}

