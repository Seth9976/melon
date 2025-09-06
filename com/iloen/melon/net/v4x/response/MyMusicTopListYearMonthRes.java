package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MyMusicTopListYearMonthRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class YEARLIST implements Serializable {
            public static class MONTHLIST implements Serializable {
                @b("MONTH")
                public String month;
                @b("NAME")
                public String name;
                private static final long serialVersionUID = 0x69B0F548D4084A34L;

                public MONTHLIST() {
                    this.month = "";
                    this.name = "";
                }
            }

            @b("MONTHLIST")
            public ArrayList monthlist;
            @b("NAME")
            public String name;
            private static final long serialVersionUID = 0xE5D1E1F4011FAFA5L;
            @b("YEAR")
            public String year;

            public YEARLIST() {
                this.year = "";
                this.name = "";
                this.monthlist = null;
            }
        }

        private static final long serialVersionUID = 0x454EA4A593FF34DEL;
        @b("YEARLIST")
        public ArrayList yearlist;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xD3642A6FEEA89E03L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

