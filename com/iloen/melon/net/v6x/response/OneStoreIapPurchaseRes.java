package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.HttpResponse;
import java.io.Serializable;

public class OneStoreIapPurchaseRes extends HttpResponse {
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
        private static final long serialVersionUID = 0x34DF53CEC5A6FE4AL;

        public RESPONSE() {
            this.link = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 5015366619019580724L;

    public OneStoreIapPurchaseRes() {
        this.response = null;
    }
}

