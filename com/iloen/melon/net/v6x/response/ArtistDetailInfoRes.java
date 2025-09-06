package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ArtistDetailInfoRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class AWARDLIST implements Serializable {
            @b("DATE")
            public String date;
            @b("NAME")
            public String name;
            @b("PRIOT")
            public String priot;
            private static final long serialVersionUID = 0x7F00BFA6D5DB5F53L;

        }

        public static class COMPARTISTLIST extends RelatedArtistsInfoBase {
            private static final long serialVersionUID = 0x5F0E1AD7BB6F34B9L;

        }

        public static class CREDITINFO implements Serializable {
            @b("FEATSONGCOUNT")
            public int featSongCount;
            @b("LYRICCOMPOSONGCOUNT")
            public int lyricCompoSongCount;
            @b("RELEASESONGCOUNT")
            public int releaseSongCount;
            private static final long serialVersionUID = 0x6071DF8F4B3AA70BL;

        }

        public static class DEBUTSONG extends SongInfoBase {
            private static final long serialVersionUID = 0xF7BFC58DE337B98FL;

        }

        public static class GROUPLIST extends RelatedArtistsInfoBase {
            private static final long serialVersionUID = 0xD8C2165DCB073012L;

        }

        public static class MEMBERLIST extends RelatedArtistsInfoBase {
            private static final long serialVersionUID = 0x758558DFDCF3CE67L;

        }

        public static class SIMARTISTLIST extends RelatedArtistsInfoBase {
            private static final long serialVersionUID = 0x311A52C24C9BCF29L;

        }

        public static class SNSLIST implements Serializable {
            private static final long serialVersionUID = 0x47E722DC4E95FEDCL;
            @b("TYPE")
            public String type;
            @b("URL")
            public String url;

        }

        public static class WEEKAWARDLIST implements Serializable {
            @b("ALBUMIMG")
            public String albumimg;
            @b("ARTISTNAME")
            public String artistname;
            @b("AWARDMONTH")
            public String awardmonth;
            @b("AWARDRANK")
            public String awardrank;
            @b("AWARDWEEK")
            public String awardweek;
            private static final long serialVersionUID = 4085593798270808982L;
            @b("SONGID")
            public String songid;
            @b("SONGNAME")
            public String songname;

        }

        public static class WIKIINFO extends LinkInfoBase {
            @b("LICENSE")
            public String license;
            private static final long serialVersionUID = 0xE9D19C4F06A31C96L;

            public WIKIINFO() {
                this.license = "";
            }
        }

        @b("ACTGENRE")
        public String actGenre;
        @b("ACTTYPE")
        public String actType;
        @b("ARTISTNAME")
        public String artistName;
        @b("ARTISTId")
        public String artistid;
        @b("AWARDLIST")
        public ArrayList awardList;
        @b("COMPARTISTLIST")
        public ArrayList compArtistList;
        @b("COMPNAME")
        public String compName;
        @b("CREDITINFO")
        public CREDITINFO creditInfo;
        @b("DEBUTDATE")
        public String debutDate;
        @b("DEBUTSONG")
        public DEBUTSONG debutSong;
        @b("GENDER")
        public String gender;
        @b("GROUPLIST")
        public ArrayList groupList;
        @b("INTRO")
        public String intro;
        @b("MEMBERLIST")
        public ArrayList memberList;
        @b("NATIONALITY")
        public String nationality;
        private static final long serialVersionUID = 0x5BCA2DEC74A0090EL;
        @b("SIMARTISTLIST")
        public ArrayList simArtistList;
        @b("SNSLIST")
        public ArrayList snsList;
        @b("WEEKAWARDLIST")
        public ArrayList weekAwardList;
        @b("WIKIBUTTONYN")
        public String wikiButtonYn;
        @b("WIKIINFO")
        public WIKIINFO wikiInfo;

        public RESPONSE() {
            this.creditInfo = null;
            this.debutSong = null;
            this.wikiButtonYn = "N";
            this.awardList = null;
            this.snsList = null;
            this.memberList = null;
            this.groupList = null;
            this.compArtistList = null;
            this.simArtistList = null;
            this.weekAwardList = null;
        }
    }

    public static class RelatedArtistsInfoBase extends ArtistsInfoBase {
        @b("ACTGENRE")
        public String actgenre;
        public int ordNum;
        private static final long serialVersionUID = 0x470F14129787F83L;
        public int shownItemCount;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x83B70A40015A39F7L;

}

