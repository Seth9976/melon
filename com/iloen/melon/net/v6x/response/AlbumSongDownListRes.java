package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class AlbumSongDownListRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class CdInfo implements Serializable {
            @b("CDNO")
            public String cdNo;
            private static final long serialVersionUID = 0x39DB81E952299926L;
            @b("SONGLIST")
            public ArrayList songList;

            public CdInfo() {
                this.cdNo = "";
                this.songList = null;
            }
        }

        public static class SongInfo extends SongInfoBase {
            public boolean bIsLast;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("LYRIC")
            public String lyric;
            private static final long serialVersionUID = 0x9539888EBAA3C8E9L;

            public SongInfo() {
                this.lyric = "";
                this.contsTypeCode = "";
                this.bIsLast = false;
            }
        }

        @b("CDLIST")
        public ArrayList cdList;
        @b("ISCLASSIC")
        public boolean isClassic;
        private static final long serialVersionUID = 0x558D8DC9093FF433L;

        public RESPONSE() {
            this.cdList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x468DC5C2F4796C4L;

    public AlbumSongDownListRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

