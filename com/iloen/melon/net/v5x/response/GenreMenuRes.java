package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class GenreMenuRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class EXPERTSPICK implements Serializable {
            public static class LIST extends LinkInfoBase {
                @b("DPNAME")
                public String dpName;
                @b("MENUID")
                public String menuId;
                private static final long serialVersionUID = 0x2B3224FD288A6B9FL;

                public LIST() {
                    this.dpName = "";
                    this.menuId = "";
                }
            }

            @b("LIST")
            public ArrayList pickList;
            private static final long serialVersionUID = 0x6F044198B1DFEB9FL;
            @b("TITLE")
            public String title;

            public EXPERTSPICK() {
                this.title = "";
                this.pickList = null;
            }
        }

        public static class GNRMENULIST implements Serializable {
            public static class GNRLIST extends GenreBaseRes {
                @b("DISPYN")
                public String dispYn;
                @b("GNRINTROD")
                public String gnrIntrod;
                @b("GNRINTRODTITLE")
                public String gnrIntrodTitle;
                @b("GUITYPE")
                public String guiType;
                @b("HOTTRACKYN")
                public String hotTrackYn;
                @b("KORENGNM")
                public String korEngNm;
                @b("MENUID")
                public String menuId;
                @b("PRNTGNRCODE")
                public String prntGnrCode;
                private static final long serialVersionUID = 0xBAAFA5209FCEDC61L;

                public GNRLIST() {
                    this.dispYn = "";
                    this.gnrIntrod = "";
                    this.gnrIntrodTitle = "";
                    this.guiType = "";
                    this.hotTrackYn = "";
                    this.korEngNm = "";
                    this.menuId = "";
                    this.prntGnrCode = "";
                }
            }

            @b("DISPORDER")
            public String dispOrder;
            @b("DISPYN")
            public String dispYn;
            @b("GNRLIST")
            public ArrayList gnrList;
            @b("GNRMENUSEQ")
            public String gnrMenuSeq;
            @b("MENUNAME")
            public String menuName;
            private static final long serialVersionUID = 0x8C3940C0B15E5C8L;

            public GNRMENULIST() {
                this.gnrMenuSeq = "";
                this.menuName = "";
                this.dispYn = "";
                this.dispOrder = "";
                this.gnrList = null;
            }
        }

        @b("EXPERTSPICK")
        public EXPERTSPICK expertsPick;
        @b("GNRMENULIST")
        public ArrayList gnrMenuList;
        private static final long serialVersionUID = 0x2F1DB557047AD293L;

        public RESPONSE() {
            this.gnrMenuList = null;
            this.expertsPick = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x32E96FFF8F2B69CBL;

    public GenreMenuRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

