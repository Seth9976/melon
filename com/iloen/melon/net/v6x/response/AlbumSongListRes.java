package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class AlbumSongListRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class CDLIST implements Serializable {
            @b("CDNO")
            public String cdNo;
            private static final long serialVersionUID = 0x10D4B58A6F52D403L;
            @b("SONGLIST")
            public ArrayList songList;

            public CDLIST() {
                this.cdNo = "";
                this.songList = null;
            }
        }

        @b("CDLIST")
        public ArrayList cdList;
        @b("ISCLASSIC")
        public String isClassic;
        private static final long serialVersionUID = 0x21AB773F62A8C255L;
        @b("TOTPLAYTIME")
        public String totPlayTime;
        @b("TOTSONGCNT")
        public String totSongCnt;

        public RESPONSE() {
            this.cdList = null;
            this.isClassic = "";
            this.totPlayTime = "";
            this.totSongCnt = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x21AB773E33E5BF05L;

    public AlbumSongListRes() {
        this.response = null;
    }
}

