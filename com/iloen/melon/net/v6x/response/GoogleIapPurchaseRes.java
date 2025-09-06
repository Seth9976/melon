package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.HttpResponse;
import java.io.Serializable;

public class GoogleIapPurchaseRes extends HttpResponse {
    public static class RESPONSE implements Serializable {
        public static class Link {
            @b("returnUrl")
            public String returnUrl;

            public Link() {
                this.returnUrl = null;
            }
        }

        @b("_link")
        public Link link;
        @b("needConsumption")
        public boolean needConsumption;
        private static final long serialVersionUID = 0x633F60D00B9ABC08L;

        public RESPONSE() {
            this.needConsumption = false;
            this.link = null;
        }
    }

    @b("response")
    public RESPONSE response;

    public GoogleIapPurchaseRes() {
        this.response = null;
    }
}

