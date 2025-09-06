package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class MixMakerCreateRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class SONG extends SongInfoBase {
            @b("CONTSTYPECODE")
            public String contsTypeCode;

            @Override  // com.melon.net.res.common.SongInfoBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("ALBUMIMGLIST")
        public ArrayList albumImgList;
        @b("DETAILREPLACE")
        public String detailReplace;
        @b("MAINTITLE")
        public String mainTitle;
        @b("PERSONALCOMMENT")
        public String personalComment;
        private static final long serialVersionUID = -704280170263793250L;
        @b("SONGLIST")
        public ArrayList songList;
        @b("TOTALPLAYTIME")
        public String totalPlayTime;
        @b("TOTALSONGCOUNT")
        public String totalSongCount;

        public RESPONSE() {
            this.albumImgList = null;
            this.mainTitle = "";
            this.personalComment = "";
            this.detailReplace = "";
            this.totalPlayTime = "";
            this.totalSongCount = "";
            this.songList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDF01DD5FC3B5FB8BL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

