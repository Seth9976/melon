package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class GenreMoreMasterpieceRes extends ResponseV5Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class ALBUMLIST extends AlbumInfoBase {
            @b("MASTERPIECEDESC")
            public String masterpieceDesc;
            @b("MASTERPIECETITLE")
            public String masterpieceTitle;
            private static final long serialVersionUID = 0xE01677FCCE01C59AL;

        }

        public static class GNRMENULIST implements Serializable {
            public static class GNRLIST implements Serializable {
                public static class DTLGNRLIST implements Serializable {
                    @b("GNRCODE")
                    public String gnrCode;
                    @b("GNRNAME")
                    public String gnrName;
                    @b("GNRNAMEFULL")
                    public String gnrNameFull;
                    private static final long serialVersionUID = 0xCB7CAA9B3BF1DF46L;

                    public DTLGNRLIST() {
                        this.gnrCode = "";
                        this.gnrName = "";
                        this.gnrNameFull = "";
                    }
                }

                @b("DTLGNRLIST")
                public ArrayList dtlGnrList;
                @b("GNRCODE")
                public String gnrCode;
                @b("GNRMENUSEQ")
                public String gnrMenuSeq;
                @b("GNRNAME")
                public String gnrName;
                @b("GNRNAMEFULL")
                public String gnrNameFull;
                @b("GNRNAMESIMPLE")
                public String gnrNameSimple;
                @b("MENUID")
                public String menuId;
                private static final long serialVersionUID = 3568959307028068613L;

                public GNRLIST() {
                    this.gnrCode = "";
                    this.gnrMenuSeq = "";
                    this.gnrName = "";
                    this.gnrNameSimple = "";
                    this.gnrNameFull = "";
                    this.menuId = "";
                    this.dtlGnrList = null;
                }
            }

            @b("DISPORDER")
            public Integer dispOrder;
            @b("DISPYN")
            public String dispYn;
            @b("GNRLIST")
            public ArrayList gnrList;
            @b("GNRMENUSEQ")
            public String gnrMenuSeq;
            @b("MENUNAME")
            public String menuName;
            private static final long serialVersionUID = 0x373368C0D021B1C9L;

            public GNRMENULIST() {
                this.gnrMenuSeq = "";
                this.menuName = "";
                this.dispYn = "";
                this.dispOrder = -1;
                this.gnrList = null;
            }
        }

        @b("ALBUMLIST")
        public ArrayList albumList;
        @b("GNRMENULIST")
        public ArrayList gnrMenuList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 8604345967500951746L;

        public RESPONSE() {
            this.gnrMenuList = null;
            this.albumList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1100EADB67855E6L;

    public GenreMoreMasterpieceRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE genreMoreMasterpieceRes$RESPONSE0 = this.response;
        return genreMoreMasterpieceRes$RESPONSE0 != null ? genreMoreMasterpieceRes$RESPONSE0.albumList : null;
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

