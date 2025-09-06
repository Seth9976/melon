package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class AppBanerListRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class CONTENTSLIST extends BannerBase {
            public static final String GUIDE_TYPE_EVENT = "E";
            public static final String GUIDE_TYPE_NOTIFICATION = "A";
            @b("ARROWIMGURL")
            public String arrowImgUrl;
            @b("ARTISTID")
            public String artistId;
            @b("ARTISTIMG")
            public String artistImg;
            @b("ARTISTNAME")
            public String artistName;
            @b("GUIDETYPE")
            public String guideType;
            @b("REJECTID")
            public String rejectId;
            @b("REJECTTYPE")
            public String rejectType;
            private static final long serialVersionUID = 0x21E23E830CBD833CL;
            @b("SUBARTISTNAME")
            public String subArtistName;
            @b("SUBCONTENTIMG")
            public String subContentImg;
            @b("SUBCONTENTNAME")
            public String subContentName;
            @b("SUBJECTTEXT")
            public String subjectText;
            @b("TEXTCOLOR")
            public String textColor;
            @b("TITLECOLOR")
            public String titleColor;

        }

        @b("CONTENTSLIST")
        public ArrayList contentsList;
        private static final long serialVersionUID = 0x837C1D355B61F981L;

        public RESPONSE() {
            this.contentsList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xA28F62E06C01676CL;

    public AppBanerListRes() {
        this.response = null;
    }
}

