package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.HttpResponse;
import java.io.Serializable;

public class OneStoreIapPurchaseRestoreRes extends HttpResponse {
    public static class RESPONSE implements Serializable {
        @b("restoreResult")
        public String restoreResult;
        private static final long serialVersionUID = 0x1B85FA447C2B945DL;

        public RESPONSE() {
            this.restoreResult = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xABF4010D431464DL;

    public OneStoreIapPurchaseRestoreRes() {
        this.response = null;
    }
}

