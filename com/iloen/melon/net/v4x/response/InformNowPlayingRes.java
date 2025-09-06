package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class InformNowPlayingRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("ALBUMIMG")
        public String albumImg;
        @b("ALBUMIMGLARGE")
        public String albumImgLarge;
        @b("ARTISTID")
        public String artistId;
        @b("ARTISTIMG")
        public String artistImg;
        @b("ARTISTLIST")
        public ArrayList artistList;
        @b("ARTISTNAME")
        public String artistName;
        @b("BBSCHANNELSEQ")
        public String bbsChannelSeq;
        @b("ISSERVICE")
        public String canService;
        @b("INTROCONT")
        public String introCont;
        @b("ISADULT")
        public String isAdult;
        @b("LIKECNT")
        public String likeCnt;
        @b("NOWPLAYSEQ")
        public String nowPlaySeq;
        @b("SELLYRICSFIRST")
        public String selLyricsFirst;
        @b("SELLYRICSSECOND")
        public String selLyricsSecond;
        private static final long serialVersionUID = 0x5B65CFAB69B9901BL;
        @b("SONGID")
        public String songId;
        @b("SONGNAME")
        public String songName;
        @b("VALIDCMTCNT")
        public String validCmtCnt;
        @b("VALIDCNT")
        public String validCnt;

        public RESPONSE() {
            this.artistId = "";
            this.artistName = "";
            this.artistImg = "";
            this.songId = "";
            this.songName = null;
            this.introCont = "";
            this.selLyricsFirst = "";
            this.selLyricsSecond = "";
            this.artistList = null;
            this.albumImg = "";
            this.albumImgLarge = "";
            this.isAdult = "";
            this.canService = "";
            this.likeCnt = "";
            this.validCnt = "";
            this.validCmtCnt = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 2096036038965937175L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

