package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.RedDotInfo;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import io.netty.util.internal.StringUtil;
import java.io.Serializable;
import java.util.List;

public class MusicTopBannerRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static final class CommerceBanner implements Serializable {
            public static enum LinkType {
                @b("SCHEME")
                SCHEME,
                @b("URL")
                URL;

                private static LinkType[] $values() [...] // Inlined contents
            }

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
            @b("redDot")
            public RedDotInfo redDot;
            private static final long serialVersionUID = 0x708602C8B939CBC2L;
            @b("showRedDot")
            public Boolean showRedDot;

            // 去混淆评级： 低(20)
            public boolean isExposurable() {
                return !StringUtil.isNullOrEmpty(this.imgContent) && !StringUtil.isNullOrEmpty(this.link);
            }
        }

        public static class SpecialGiftBanner extends LinkInfoBase {
            public static final class ExposeGift {
                @b("clicked")
                public boolean clicked;
                @b("expiration")
                public String expiration;
                @b("giftId")
                public String giftId;

            }

            @b("campaignSeq")
            public String campaignSeq;
            @b("exposeGift")
            public ExposeGift exposeGift;
            @b("giftId")
            public String giftId;
            @b("iconUrl")
            public String iconUrl;
            private static final long serialVersionUID = 0x72275888D0FFAD6CL;

        }

        @b("cashFriendsBanner")
        public CommerceBanner cashFriendsBanner;
        @b("commerceBanner")
        public CommerceBanner commerceBanner;
        @b("expiredRedDotIds")
        public List expiredRedDotIds;
        @b("expiredSpecialGiftIds")
        public List expiredSpecialGiftIds;
        @b("hasProducts")
        public boolean hasProducts;
        private static final long serialVersionUID = 0x9060F6A28D456440L;
        @b("specialGiftBanner")
        public SpecialGiftBanner specialGiftBanner;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x96C8E080B96DC168L;

    public MusicTopBannerRes() {
        this.response = null;
    }

    public boolean hasCashFriendsBanner() {
        return this.response != null && (this.response.cashFriendsBanner != null && !StringUtil.isNullOrEmpty(this.response.cashFriendsBanner.imgContent));
    }

    public boolean hasCommerceBanner() {
        return this.response != null && (this.response.commerceBanner != null && !StringUtil.isNullOrEmpty(this.response.commerceBanner.imgContent));
    }
}

