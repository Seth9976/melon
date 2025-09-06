package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class ForUInformRelateSongRecmRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        public static class FANARTISTLIST extends ArtistInfoBase {
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            private static final long serialVersionUID = 0x72DD240BD2C6A902L;

        }

        public static class LIKESONGLIST extends SongInfoBase {
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            private static final long serialVersionUID = 0x629B091262E980ADL;

        }

        public static class RECENTSONGLIST extends SongInfoBase {
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            private static final long serialVersionUID = 7105282812680620717L;

        }

        @b("FANARTISTLIST")
        public ArrayList fanArtistList;
        @b("FANARTISTTITLE")
        public String fanArtistTitle;
        @b("LIKESONGLIST")
        public ArrayList likeSongList;
        @b("LIKESONGTITLE")
        public String likeSongTitle;
        @b("RECENTSONGLIST")
        public ArrayList recentSongList;
        @b("RECENTSONG")
        public String recentSongTitle;
        private static final long serialVersionUID = 0x39563C80FA74A0D8L;

    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x6F8F4E356797C47EL;

    public ForUInformRelateSongRecmRes() {
        this.response = null;
    }
}

