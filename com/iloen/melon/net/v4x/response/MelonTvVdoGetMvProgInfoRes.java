package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;

public class MelonTvVdoGetMvProgInfoRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class PROG implements Serializable {
            @b("EPSDYN")
            public String epsdYn;
            @b("PROGNAME")
            public String progName;
            @b("PROGSEQ")
            public String progSeq;

            public PROG() {
                this.progSeq = "";
                this.progName = "";
                this.epsdYn = "";
            }
        }

        @b("BRANDKEY")
        public String brandKey;
        @b("BRANDNAME")
        public String brandName;
        @b("ISBRANDJ")
        public boolean isBrandDj;
        @b("PROG")
        public PROG prog;
        private static final long serialVersionUID = 0xF8855368D4DE6C83L;

        public RESPONSE() {
            this.isBrandDj = false;
            this.brandKey = "";
            this.brandName = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x3B87229618FDD0BCL;

}

