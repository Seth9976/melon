package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.HttpResponse;
import java.io.Serializable;

public class GoogleIapPurchaseRestoreRes extends HttpResponse {
    public static class RESPONSE implements Serializable {
        @b("restoreResult")
        public String restoreResult;
        private static final long serialVersionUID = 0x41930FE018C31207L;

        public RESPONSE() {
            this.restoreResult = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -6680084236434466267L;

    public GoogleIapPurchaseRestoreRes() {
        this.response = null;
    }
}

