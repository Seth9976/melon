package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MyMusicRecentListPlylstRecntRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class RECNTPLYLSTLIST extends ArtistPlayListInfoBase {
            @b("CONTSID")
            public String contsId;
            @b("ISMELONLOGO")
            public Boolean isMelonLogo;
            @b("MAINIMGURLS")
            public ArrayList mainImgUrls;
            @b("MAINREPLACE")
            public String mainReplace;
            @b("MAINSUBIMGURL")
            public String mainSubImgUrl;
            @b("MAINTEXT")
            public String mainText;
            @b("MAINTITLE")
            public String mainTitle;
            @b("RANK")
            public String rank;
            @b("SEEDCONTSID")
            public String seedContsId;
            @b("SEEDCONTSTYPECODE")
            public String seedContsTypeCode;
            private static final long serialVersionUID = 1882617040408790483L;
            @b("WRITER")
            public String writer;

            public RECNTPLYLSTLIST() {
                this.contsId = "";
                this.seedContsTypeCode = "";
                this.seedContsId = "";
                this.mainTitle = "";
                this.mainReplace = "";
                this.mainText = "";
                this.mainImgUrls = null;
                this.mainSubImgUrl = "";
                this.rank = "";
                this.writer = "";
                this.isMelonLogo = Boolean.FALSE;
            }
        }

        @b("GUIDETEXT")
        public String guideText;
        @b("HASMORE")
        public boolean hasMore;
        @b("RECNTPLYLSTLIST")
        public ArrayList recntPlylstList;
        private static final long serialVersionUID = 0x952D8A4D04D3B995L;

        public RESPONSE() {
            this.hasMore = false;
            this.guideText = "";
            this.recntPlylstList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x25DF30026F59587EL;

    public MyMusicRecentListPlylstRecntRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE myMusicRecentListPlylstRecntRes$RESPONSE0 = this.response;
        return myMusicRecentListPlylstRecntRes$RESPONSE0 != null ? myMusicRecentListPlylstRecntRes$RESPONSE0.recntPlylstList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response == null ? false : this.response.hasMore;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

