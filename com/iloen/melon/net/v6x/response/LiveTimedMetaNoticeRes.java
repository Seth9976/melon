package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;

public class LiveTimedMetaNoticeRes extends ResponseV6Res {
    public static class NOTICE implements Serializable {
        public static class TIARALOG implements Serializable {
            @b("ID")
            public String id;
            private static final long serialVersionUID = 0x551EE66C5DB6FEA8L;
            @b("TEXT")
            public String text;

            public TIARALOG() {
                this.id = "";
                this.text = "";
            }
        }

        @b("LINK")
        public LinkInfoBase link;
        private static final long serialVersionUID = 0x5634791E1B7F011DL;
        @b("TEXT")
        public String text;
        @b("TIARALOG")
        public TIARALOG tiaraLog;

        public NOTICE() {
            this.text = "";
        }
    }

    public static class RESPONSE extends ResponseBase {
        @b("NOTICE")
        public NOTICE notice;
        private static final long serialVersionUID = 0x40F914243827DB11L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x2FDDEC5D10A4D5A1L;

    public LiveTimedMetaNoticeRes() {
        this.response = null;
    }
}

