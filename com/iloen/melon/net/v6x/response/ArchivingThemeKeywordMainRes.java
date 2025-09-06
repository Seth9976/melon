package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class ArchivingThemeKeywordMainRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class SONG extends SongInfoBase {
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            private static final long serialVersionUID = 0xBE90AC17A772C265L;

            @Override  // com.melon.net.res.common.SongInfoBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("ALBUMIMGLIST")
        public ArrayList albumImgList;
        @b("MAINTITLE")
        public String mainTitle;
        private static final long serialVersionUID = -5323708601829130093L;
        @b("SONGLIST")
        public ArrayList songList;
        @b("TOTALPLAYTIME")
        public String totalPlayTime;
        @b("TOTALSONGCOUNT")
        public String totalSongCount;

        public RESPONSE() {
            this.albumImgList = null;
            this.mainTitle = "";
            this.totalPlayTime = "";
            this.totalSongCount = "";
            this.songList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 663225670001219566L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

