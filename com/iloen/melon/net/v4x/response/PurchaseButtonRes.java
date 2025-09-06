package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import io.netty.util.internal.StringUtil;
import java.io.Serializable;

public class PurchaseButtonRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        public static final class Banner implements Serializable {
            @b("id")
            public String id;
            @b("imgContent")
            public String imgContent;
            @b("link")
            public String link;
            @b("linkTarget")
            public String linkTarget;
            @b("linkType")
            public LinkType linkType;
            private static final long serialVersionUID = 0x708602C8B939CBC2L;

        }

        public static enum LinkType {
            @b("SCHEME")
            SCHEME,
            @b("URL")
            URL;

            private static LinkType[] $values() [...] // Inlined contents
        }

        @b("banner")
        public Banner banner;
        private static final long serialVersionUID = 0x57F5CA39EAF214D9L;

        // 去混淆评级： 低(20)
        public boolean isExposurable() {
            return this.banner != null && !StringUtil.isNullOrEmpty(this.banner.imgContent) && !StringUtil.isNullOrEmpty(this.banner.link);
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x8D7EC748DF7CB1F6L;

    public PurchaseButtonRes() {
        this.response = null;
    }
}

