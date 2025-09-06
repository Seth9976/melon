package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;

public class MyInfoTiaraRes extends ResponseV4Res {
    public static final class Data implements Serializable {
        @b("payment_type")
        public String paymentType;
        @b("product_name")
        public String productName;
        @b("product_price")
        public String productPrice;
        @b("restrict_ad")
        public String restrictAd;
        private static final long serialVersionUID = 0xB93F7A59FCFB1F92L;

    }

    public static class Response extends ResponseBase {
        @b("data")
        public Data data;
        @b("request_key")
        public String requestKey;
        private static final long serialVersionUID = 0x752665B45FAD8C68L;

    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0xA8974C241311BE0L;

    public MyInfoTiaraRes() {
        this.response = null;
    }
}

