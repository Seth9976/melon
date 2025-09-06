package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class SongPersonalInfoRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("FIRSTLISTENDATE")
        public String firstListenDate;
        @b("HIGHLIGHTLINE")
        public String highlightLine;
        @b("ISLYRICUPDATE")
        public boolean isLyricUpdate;
        @b("LYRICUPDATEMSG")
        public String lyricUpdateMsg;
        private static final long serialVersionUID = 0x1D775C57FD63FB8DL;
        @b("TOTALLISTENCNT")
        public String totalListenCnt;

        public RESPONSE() {
            this.highlightLine = "";
            this.isLyricUpdate = false;
            this.lyricUpdateMsg = "";
            this.firstListenDate = "";
            this.totalListenCnt = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1D70415AB3D61105L;

    public SongPersonalInfoRes() {
        this.response = null;
    }
}

