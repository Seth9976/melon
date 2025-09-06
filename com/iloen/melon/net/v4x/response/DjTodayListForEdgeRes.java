package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class DjTodayListForEdgeRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class PLYLSTLIST extends DjPlayListInfoBase {
            @b("CURRANK")
            public String curRank;
            @b("DJMAGREGYN")
            public String djMagRegYN;
            @b("ISLABEL")
            public String isLabel;
            private static final long serialVersionUID = 0xDFF2323A048C2434L;

            public PLYLSTLIST() {
                this.djMagRegYN = "";
                this.curRank = "";
                this.isLabel = "";
            }
        }

        @b("PLYLSTLIST")
        public ArrayList plylstList;
        private static final long serialVersionUID = 636078590401446711L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x8EE15F82C4FD83A5L;

    public DjTodayListForEdgeRes() {
        this.response = null;
    }
}

