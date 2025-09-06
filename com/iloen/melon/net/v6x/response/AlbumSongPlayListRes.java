package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class AlbumSongPlayListRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class CdInfo implements Serializable {
            @b("CDNO")
            public String cdNo;
            private static final long serialVersionUID = 0x2BA35AF03FA8680EL;
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
            private static final long serialVersionUID = -2942859666038050417L;

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
        private static final long serialVersionUID = 0xF59FC9D801BF9C49L;

        public RESPONSE() {
            this.cdList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1EB2434C59FFE79EL;

    public AlbumSongPlayListRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

