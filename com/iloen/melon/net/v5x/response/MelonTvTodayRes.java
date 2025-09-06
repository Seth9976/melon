package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.TvProgramBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MelonTvTodayRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class BANNERLIST extends BannerBase {
            @b("BGCOLOREND")
            public String bgColorEnd;
            @b("BGCOLORSTART")
            public String bgColorStart;
            @b("BULLETTITLE")
            public String bulletTitle;
            @b("CONTENTID")
            public String contentId;
            @b("CONTENTTYPECODE")
            public String contentTypeCode;
            private static final long serialVersionUID = 0x60AA319EE4A00B15L;

            public BANNERLIST() {
                this.contentId = "";
                this.contentTypeCode = "";
                this.bulletTitle = "";
                this.bgColorStart = "";
                this.bgColorEnd = "";
            }
        }

        public static class MENUPROGINFO implements Serializable {
            public static class PROGLIST extends TvProgramBase {
                public static class MV extends MvInfoBase {
                    private static final long serialVersionUID = 0xD05ECB985B8EF85L;

                }

                @b("MENUNAME")
                public String menuName;
                @b("MV")
                public MV mv;
                private static final long serialVersionUID = 0xD06432334457685L;

                public PROGLIST() {
                    this.menuName = "";
                }
            }

            @b("PROGLIST")
            public ArrayList progList;
            private static final long serialVersionUID = 0xD0643158F7087DDL;
            @b("TITLE")
            public String title;

            public MENUPROGINFO() {
                this.title = "";
                this.progList = null;
            }
        }

        public static class NEWMV extends TodayMvBase {
            private static final long serialVersionUID = 0x4B1F139E1CC9D85L;

        }

        public static class POPMV extends TodayMvBase {
            private static final long serialVersionUID = 0x4B1F2F101FA2E25L;

        }

        public static class RECMMV extends TodayMvBase {
            private static final long serialVersionUID = 0x57EBA1025F928D15L;

        }

        public static class THEMEMV extends TodayMvBase {
            private static final long serialVersionUID = 0x49C9FCD9B1F60C5L;

        }

        public static class TodayMvBase implements Serializable {
            @b("MVLIST")
            public ArrayList mvList;
            private static final long serialVersionUID = 0x18EAE297E1F4225L;
            @b("TITLE")
            public String title;

            public TodayMvBase() {
                this.title = "";
                this.mvList = null;
            }
        }

        @b("BANNERLIST")
        public ArrayList bannerList;
        @b("MENUPROGINFO")
        public MENUPROGINFO menuProgInfo;
        @b("NEWMV")
        public NEWMV newMv;
        @b("POPMV")
        public POPMV popMv;
        @b("RECMMV")
        public RECMMV recmMv;
        private static final long serialVersionUID = 0x60AA5F1A0E1D5C8DL;
        @b("THEMEMV")
        public THEMEMV themeMv;

        public RESPONSE() {
            this.bannerList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x3E3753F611B43043L;

}

