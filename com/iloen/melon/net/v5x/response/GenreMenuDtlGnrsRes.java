package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class GenreMenuDtlGnrsRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class DTLGNRLIST implements Serializable {
            @b("GNRCODE")
            public String gnrCode;
            @b("GNRNAME")
            public String gnrName;
            @b("GUITYPE")
            public String guiType;
            @b("ISYEARLYGNR")
            public String isYearlyGnr;
            private static final long serialVersionUID = 0x4C142777AE5FABAL;

            public DTLGNRLIST() {
                this.gnrCode = "";
                this.gnrName = "";
                this.guiType = "";
                this.isYearlyGnr = "";
            }
        }

        public static class GNR implements Serializable {
            @b("BGCOLOR")
            public String bgColor;
            @b("BGIMGURL")
            public String bgImgUrl;
            @b("FONTCOLOR")
            public String fontColor;
            @b("GNRCODE")
            public String gnrCode;
            @b("GNRNAME")
            public String gnrName;
            private static final long serialVersionUID = 0x7454C596FD156F22L;

            public GNR() {
                this.gnrCode = "";
                this.gnrName = "";
                this.bgImgUrl = "";
                this.bgColor = "";
                this.fontColor = "";
            }
        }

        public static class GNRLIST extends DTLGNRLIST {
            @b("DTLGNRLIST")
            public ArrayList dtlGnrList;
            private static final long serialVersionUID = 742648127557302074L;

            public GNRLIST() {
                this.dtlGnrList = null;
            }
        }

        public static class STATSELEMENTS extends StatsElementsBase {
            private static final long serialVersionUID = 0xA565C34EC82EE97EL;

        }

        @b("GNRLIST")
        public ArrayList dtlGnrList;
        @b("GNR")
        public GNR gnr;
        private static final long serialVersionUID = -3132561828070540240L;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;

        public RESPONSE() {
            this.statsElements = null;
            this.dtlGnrList = null;
            this.gnr = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x4028DD65805BA7C0L;

    public GenreMenuDtlGnrsRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

