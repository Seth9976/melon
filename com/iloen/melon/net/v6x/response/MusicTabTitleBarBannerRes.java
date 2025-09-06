package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.RedDotInfo;
import com.melon.net.res.common.ResponseBase;
import io.netty.util.internal.StringUtil;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pe.a;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000E2\u00020\u0001:\u0002\r\u000EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001A\u00020\u000BJ\u0006\u0010\f\u001A\u00020\u000BR \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes$RESPONSE;)V", "hasCommerceBanner", "", "hasCashFriendsBanner", "RESPONSE", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicTabTitleBarBannerRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001A\n\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "commerceBanner", "Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes$RESPONSE$CommerceBanner;", "getCommerceBanner", "()Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes$RESPONSE$CommerceBanner;", "setCommerceBanner", "(Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes$RESPONSE$CommerceBanner;)V", "cashFriendsBanner", "getCashFriendsBanner", "setCashFriendsBanner", "expiredRedDotIds", "", "", "getExpiredRedDotIds", "()Ljava/util/List;", "setExpiredRedDotIds", "(Ljava/util/List;)V", "CommerceBanner", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\b\b\u0007\u0018\u0000 \'2\u00020\u0001:\u0002&\'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001A\u0004\u0018\u00010\u001A8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\"\u0010\u001F\u001A\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000E¢\u0006\u0010\n\u0002\u0010%\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes$RESPONSE$CommerceBanner;", "Ljava/io/Serializable;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "imgContent", "getImgContent", "setImgContent", "link", "getLink", "setLink", "linkType", "Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes$RESPONSE$CommerceBanner$LinkType;", "getLinkType", "()Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes$RESPONSE$CommerceBanner$LinkType;", "setLinkType", "(Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes$RESPONSE$CommerceBanner$LinkType;)V", "linkTarget", "getLinkTarget", "setLinkTarget", "redDot", "Lcom/melon/net/res/RedDotInfo;", "getRedDot", "()Lcom/melon/net/res/RedDotInfo;", "setRedDot", "(Lcom/melon/net/res/RedDotInfo;)V", "showRedDot", "", "getShowRedDot", "()Ljava/lang/Boolean;", "setShowRedDot", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "LinkType", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class CommerceBanner implements Serializable {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes$RESPONSE$CommerceBanner$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v6x.response.MusicTabTitleBarBannerRes.RESPONSE.CommerceBanner.Companion {
                private com.iloen.melon.net.v6x.response.MusicTabTitleBarBannerRes.RESPONSE.CommerceBanner.Companion() {
                }

                public com.iloen.melon.net.v6x.response.MusicTabTitleBarBannerRes.RESPONSE.CommerceBanner.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes$RESPONSE$CommerceBanner$LinkType;", "", "<init>", "(Ljava/lang/String;I)V", "SCHEME", "URL", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static enum LinkType {
                @b("SCHEME")
                SCHEME,
                @b("URL")
                URL;

                private static final a $ENTRIES;
                private static final LinkType[] $VALUES;

                private static final LinkType[] $values() [...] // Inlined contents

                static {
                    LinkType.$VALUES = arr_musicTabTitleBarBannerRes$RESPONSE$CommerceBanner$LinkType;
                    q.g(arr_musicTabTitleBarBannerRes$RESPONSE$CommerceBanner$LinkType, "entries");
                    LinkType.$ENTRIES = new pe.b(arr_musicTabTitleBarBannerRes$RESPONSE$CommerceBanner$LinkType);
                }

                @NotNull
                public static a getEntries() {
                    return LinkType.$ENTRIES;
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.v6x.response.MusicTabTitleBarBannerRes.RESPONSE.CommerceBanner.Companion Companion = null;
            @b("id")
            @Nullable
            private String id;
            @b("imgContent")
            @Nullable
            private String imgContent;
            @b("link")
            @Nullable
            private String link;
            @b("linkTarget")
            @Nullable
            private String linkTarget;
            @b("linkType")
            @Nullable
            private LinkType linkType;
            @b("redDot")
            @Nullable
            private RedDotInfo redDot;
            private static final long serialVersionUID = 0x708602C8B939CBC2L;
            @b("showRedDot")
            @Nullable
            private Boolean showRedDot;

            static {
                CommerceBanner.Companion = new com.iloen.melon.net.v6x.response.MusicTabTitleBarBannerRes.RESPONSE.CommerceBanner.Companion(null);
                CommerceBanner.$stable = 8;
            }

            public CommerceBanner() {
                this.id = "";
            }

            @Nullable
            public final String getId() [...] // 潜在的解密器

            @Nullable
            public final String getImgContent() {
                return this.imgContent;
            }

            @Nullable
            public final String getLink() {
                return this.link;
            }

            @Nullable
            public final String getLinkTarget() {
                return this.linkTarget;
            }

            @Nullable
            public final LinkType getLinkType() {
                return this.linkType;
            }

            @Nullable
            public final RedDotInfo getRedDot() {
                return this.redDot;
            }

            @Nullable
            public final Boolean getShowRedDot() {
                return this.showRedDot;
            }

            public final void setId(@Nullable String s) {
                this.id = s;
            }

            public final void setImgContent(@Nullable String s) {
                this.imgContent = s;
            }

            public final void setLink(@Nullable String s) {
                this.link = s;
            }

            public final void setLinkTarget(@Nullable String s) {
                this.linkTarget = s;
            }

            public final void setLinkType(@Nullable LinkType musicTabTitleBarBannerRes$RESPONSE$CommerceBanner$LinkType0) {
                this.linkType = musicTabTitleBarBannerRes$RESPONSE$CommerceBanner$LinkType0;
            }

            public final void setRedDot(@Nullable RedDotInfo redDotInfo0) {
                this.redDot = redDotInfo0;
            }

            public final void setShowRedDot(@Nullable Boolean boolean0) {
                this.showRedDot = boolean0;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicTabTitleBarBannerRes$RESPONSE$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.net.v6x.response.MusicTabTitleBarBannerRes.RESPONSE.Companion {
            private com.iloen.melon.net.v6x.response.MusicTabTitleBarBannerRes.RESPONSE.Companion() {
            }

            public com.iloen.melon.net.v6x.response.MusicTabTitleBarBannerRes.RESPONSE.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.net.v6x.response.MusicTabTitleBarBannerRes.RESPONSE.Companion Companion = null;
        @b("cashFriendsBanner")
        @Nullable
        private CommerceBanner cashFriendsBanner;
        @b("commerceBanner")
        @Nullable
        private CommerceBanner commerceBanner;
        @b("expiredRedDotIds")
        @Nullable
        private List expiredRedDotIds;
        private static final long serialVersionUID = 0x9060F6A28D456440L;

        static {
            RESPONSE.Companion = new com.iloen.melon.net.v6x.response.MusicTabTitleBarBannerRes.RESPONSE.Companion(null);
            RESPONSE.$stable = 8;
        }

        @Nullable
        public final CommerceBanner getCashFriendsBanner() {
            return this.cashFriendsBanner;
        }

        @Nullable
        public final CommerceBanner getCommerceBanner() {
            return this.commerceBanner;
        }

        @Nullable
        public final List getExpiredRedDotIds() {
            return this.expiredRedDotIds;
        }

        public final void setCashFriendsBanner(@Nullable CommerceBanner musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0) {
            this.cashFriendsBanner = musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0;
        }

        public final void setCommerceBanner(@Nullable CommerceBanner musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0) {
            this.commerceBanner = musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0;
        }

        public final void setExpiredRedDotIds(@Nullable List list0) {
            this.expiredRedDotIds = list0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @b("response")
    @Nullable
    private RESPONSE response;
    private static final long serialVersionUID = 0x96C8E080B96DC168L;

    static {
        MusicTabTitleBarBannerRes.Companion = new Companion(null);
        MusicTabTitleBarBannerRes.$stable = 8;
    }

    @Nullable
    public final RESPONSE getResponse() {
        return this.response;
    }

    public final boolean hasCashFriendsBanner() {
        RESPONSE musicTabTitleBarBannerRes$RESPONSE0 = this.response;
        if(musicTabTitleBarBannerRes$RESPONSE0 != null) {
            q.d(musicTabTitleBarBannerRes$RESPONSE0);
            if(musicTabTitleBarBannerRes$RESPONSE0.getCashFriendsBanner() != null) {
                RESPONSE musicTabTitleBarBannerRes$RESPONSE1 = this.response;
                q.d(musicTabTitleBarBannerRes$RESPONSE1);
                CommerceBanner musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0 = musicTabTitleBarBannerRes$RESPONSE1.getCashFriendsBanner();
                q.d(musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0);
                return !StringUtil.isNullOrEmpty(musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0.getImgContent());
            }
        }
        return false;
    }

    public final boolean hasCommerceBanner() {
        RESPONSE musicTabTitleBarBannerRes$RESPONSE0 = this.response;
        if(musicTabTitleBarBannerRes$RESPONSE0 != null) {
            q.d(musicTabTitleBarBannerRes$RESPONSE0);
            if(musicTabTitleBarBannerRes$RESPONSE0.getCommerceBanner() != null) {
                RESPONSE musicTabTitleBarBannerRes$RESPONSE1 = this.response;
                q.d(musicTabTitleBarBannerRes$RESPONSE1);
                CommerceBanner musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0 = musicTabTitleBarBannerRes$RESPONSE1.getCommerceBanner();
                q.d(musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0);
                return !StringUtil.isNullOrEmpty(musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0.getImgContent());
            }
        }
        return false;
    }

    public final void setResponse(@Nullable RESPONSE musicTabTitleBarBannerRes$RESPONSE0) {
        this.response = musicTabTitleBarBannerRes$RESPONSE0;
    }
}

