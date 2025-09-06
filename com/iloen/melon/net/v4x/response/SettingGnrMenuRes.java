package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.response.GenreBaseRes;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class SettingGnrMenuRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
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
                private static final long serialVersionUID = 0xEF070D400134934AL;

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
            private static final long serialVersionUID = 0x189D17E3D0960BB3L;

            public GNRMENULIST() {
                this.gnrMenuSeq = "";
                this.menuName = "";
                this.dispYn = "";
                this.dispOrder = "";
                this.gnrList = null;
            }
        }

        @b("GNRMENULIST")
        public ArrayList gnrMenuList;
        private static final long serialVersionUID = 0xDBAD4D93445D8AF0L;

        public RESPONSE() {
            this.gnrMenuList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 6329750509760388767L;

    public SettingGnrMenuRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE settingGnrMenuRes$RESPONSE0 = this.response;
        return settingGnrMenuRes$RESPONSE0 != null ? settingGnrMenuRes$RESPONSE0.gnrMenuList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return false;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

