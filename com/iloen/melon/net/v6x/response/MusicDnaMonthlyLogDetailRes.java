package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.GenreInfoBase;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MusicDnaMonthlyLogDetailRes extends ResponseV6Res {
    public static class ARTISTTOP implements Serializable {
        @b("ARTISTINFO")
        public ArtistInfoBase artistInfo;
        @b("ARTISTTITLE")
        public String artistTitle;
        private static final long serialVersionUID = 0xD8AA99F3F3F1368L;

    }

    public static class GNRTOP extends GenreInfoBase {
        public static class LIKEGNRTOP3 extends SongInfoBase {
            private static final long serialVersionUID = 4307178770705126248L;

        }

        @b("GENREBTN")
        public boolean genreBtn;
        @b("GNRTITLE")
        public String gnrTitle;
        @b("LIKEGNRTOP3")
        public ArrayList likeGnrTop3;
        private static final long serialVersionUID = 0xECE8407F4A98EC98L;

    }

    public static class RESPONSE extends ResponseBase {
        @b("ARTISTTOP")
        public ARTISTTOP artistTop;
        @b("GNRTOP")
        public GNRTOP grnTop;
        private static final long serialVersionUID = 5214530912466094094L;
        @b("SONGTOP")
        public SONGTOP songTop;
        @b("TAGTOP")
        public TAGSTOP tagTop;

        public RESPONSE() {
            this.songTop = null;
            this.artistTop = null;
            this.tagTop = null;
            this.grnTop = null;
        }
    }

    public static class SONGTOP implements Serializable {
        public static class SONGTOP3 extends SongInfoBase {
            private static final long serialVersionUID = 0x8F2290CC1F486C98L;

        }

        private static final long serialVersionUID = 0x2B5656BF2C029368L;
        @b("SONGSUBTITLE")
        public String songSubTitle;
        @b("SONGTITLE")
        public String songTitle;
        @b("SONGTOP3")
        public ArrayList songTop3;

    }

    public static class TAGSTOP implements Serializable {
        public static class TAGS extends TagInfoBase {
            private static final long serialVersionUID = 4928778770705126248L;

        }

        private static final long serialVersionUID = 0x8B3525CBF7D8EC98L;
        @b("TAGTITLE")
        public String tagTitle;
        @b("TAGS")
        public ArrayList tags;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 1450530912466094094L;

    public MusicDnaMonthlyLogDetailRes() {
        this.response = null;
    }
}

