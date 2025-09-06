package com.iloen.melon.net.v5x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class CastCmtExistRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        @b("ISNEWCMT")
        public boolean isNewCmt;
        private static final long serialVersionUID = 6548346780075600172L;

        public RESPONSE() {
            this.isNewCmt = false;
        }
    }

    public RESPONSE response;

}

