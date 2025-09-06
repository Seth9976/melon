package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class DjThemeListBoardRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class BOARDLIST implements Serializable {
            public static class BANNER extends BannerBase {
                @b("BANERTYPE")
                public String bannerType;
                private static final long serialVersionUID = 0xEF88999ABC642F12L;
                @b("TAGNAME")
                public String tagName;
                @b("TAGSEQ")
                public String tagSeq;

            }

            public static class TAGLIST extends TagInfoBase {
                public String boardTitle;
                @b("IMGPATH")
                public String imgPath;
                @b("IMGURL")
                public String imgUrl;
                public int index;
                @b("PLYLSTCNT")
                public String plylstCnt;
                public int remain;
                private static final long serialVersionUID = 0xB0400D6CA0A5DAC8L;

                public TAGLIST() {
                    this.remain = 0;
                    this.index = 0;
                }
            }

            @b("BANNER")
            public BANNER banner;
            @b("BOARDSEQ")
            public String boardSeq;
            @b("BOARDTITLE")
            public String boardTitle;
            private static final long serialVersionUID = 0xD143F38BD40DA906L;
            @b("SETNO")
            public String setNo;
            @b("TAGLIST")
            public ArrayList taglistList;

        }

        public static class TODAYTAGLIST extends TagInfoBase {
            public static class PLYLSTLIST extends DjPlayListInfoBase {
                private static final long serialVersionUID = 0xB0400D6CA0A5DAC8L;

            }

            @b("IMGPATH")
            public String imgPath;
            @b("IMGURL")
            public String imgUrl;
            @b("PLYLSTCNT")
            public String playlistCount;
            @b("PLYLSTLIST")
            public ArrayList playlistList;
            private static final long serialVersionUID = 0xD143F38BD40DA906L;

        }

        @b("BOARDLIST")
        public ArrayList boardlistList;
        private static final long serialVersionUID = 0x327ACFF26F5419D2L;
        @b("TODAYTAGLIST")
        public ArrayList todayTaglistList;

        public RESPONSE() {
            this.todayTaglistList = null;
            this.boardlistList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x3C3702A7D8EA2E41L;

    public DjThemeListBoardRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }
}

