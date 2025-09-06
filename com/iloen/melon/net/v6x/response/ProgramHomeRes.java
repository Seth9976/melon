package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.TvProgramBase;
import com.iloen.melon.sns.model.ShareLinkData;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ProgramHomeRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class ALBUMINFO implements Serializable {
            @b("ISMORE")
            public boolean isMore;
            @b("ALBUMLIST")
            public ArrayList list;
            @b("TITLE")
            public String title;

        }

        public static class BUTTONINFO implements Serializable {
            @b("MENUSEQ")
            public String menuSeq;
            @b("TITLE")
            public String title;

        }

        public static class MVINFO implements Serializable {
            public static class MVLIST extends MvInfoBase {
                @b("EPSDNO")
                public String epsdNo;
                @b("EPSDNONAME")
                public String epsdNoName;

            }

            @b("ISMORE")
            public boolean isMore;
            @b("MVLIST")
            public ArrayList list;
            @b("TITLE")
            public String title;

        }

        public static class NEWMVINFO implements Serializable {
            @b("MVLIST")
            public ArrayList list;
            @b("TITLE")
            public String title;

        }

        public static class PLAYLISTINFO implements Serializable {
            public static class PLAYLIST extends DjPlayListInfoBase {
            }

            @b("PLYLSTLIST")
            public ArrayList list;
            @b("TITLE")
            public String title;

        }

        public static class POPULARMVINFO implements Serializable {
            @b("MVLIST")
            public ArrayList list;
            @b("TITLE")
            public String title;

        }

        public static class PROGINFO extends TvProgramBase implements Serializable {
            @b("LIKECNT")
            public String likedCnt;
            @b("PROGIMAGEURL")
            public String progImagUrl;
            @b("SHARELINK")
            public ShareLinkData sharedLink;

        }

        public static class SONGINFO implements Serializable {
            @b("ISMORE")
            public boolean isMore;
            @b("SONGLIST")
            public ArrayList list;
            @b("TITLE")
            public String title;

        }

        @b("ALBUMINFO")
        public ALBUMINFO albumInfo;
        @b("BUTTONINFO")
        public BUTTONINFO buttonInfo;
        @b("MVINFO")
        public MVINFO mvInfo;
        @b("NEWMVINFO")
        public NEWMVINFO newMvInfo;
        @b("NOTICE")
        public String notice;
        @b("PLYLSTINFO")
        public PLAYLISTINFO playlistInfo;
        @b("POPMVINFO")
        public POPULARMVINFO popularMvInfo;
        @b("PROGINFO")
        public PROGINFO programInfo;
        @b("SONGINFO")
        public SONGINFO songInfo;

    }

    @b("response")
    public RESPONSE response;

}

