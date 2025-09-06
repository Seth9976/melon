package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000B2\u00020\u0001:\u0002\n\u000BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/iloen/melon/net/v6x/response/FloatingBannerRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/FloatingBannerRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/FloatingBannerRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/FloatingBannerRes$RESPONSE;)V", "RESPONSE", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FloatingBannerRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/FloatingBannerRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R2\u0010\u0004\u001A\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR2\u0010\f\u001A\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\t\"\u0004\b\u000F\u0010\u000B¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/net/v6x/response/FloatingBannerRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "banners", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v6x/response/FloatingBannerRes$RESPONSE$BANNER;", "Lkotlin/collections/ArrayList;", "getBanners", "()Ljava/util/ArrayList;", "setBanners", "(Ljava/util/ArrayList;)V", "expiredBans", "", "getExpiredBans", "setExpiredBans", "BANNER", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\n\b\u0007\u0018\u0000 D2\u00020\u0001:\u0002CDB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\tR \u0010\u001C\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0007\"\u0004\b\u001E\u0010\tR \u0010\u001F\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR \u0010\"\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR \u0010%\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u0007\"\u0004\b\'\u0010\tR \u0010(\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR \u0010+\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR \u0010.\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR \u00101\u001A\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b3\u00104\"\u0004\b5\u00106R \u00107\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR\"\u0010:\u001A\u0004\u0018\u00010;8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0002\u0010?\u001A\u0004\b:\u0010<\"\u0004\b=\u0010>R \u0010@\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bA\u0010\u0007\"\u0004\bB\u0010\t\u00A8\u0006E"}, d2 = {"Lcom/iloen/melon/net/v6x/response/FloatingBannerRes$RESPONSE$BANNER;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "bannerSeq", "", "getBannerSeq", "()Ljava/lang/String;", "setBannerSeq", "(Ljava/lang/String;)V", "adminTitle", "getAdminTitle", "setAdminTitle", "targetId", "getTargetId", "setTargetId", "floatingDetailType", "getFloatingDetailType", "setFloatingDetailType", "imgUrl", "getImgUrl", "setImgUrl", "bgColor", "getBgColor", "setBgColor", "text1", "getText1", "setText1", "text1PointColor", "getText1PointColor", "setText1PointColor", "text2", "getText2", "setText2", "text2PointColor", "getText2PointColor", "setText2PointColor", "contsTypeCode", "getContsTypeCode", "setContsTypeCode", "contsId", "getContsId", "setContsId", "dpType", "getDpType", "setDpType", "dpTitle", "getDpTitle", "setDpTitle", "banOn", "Lcom/iloen/melon/net/v6x/response/FloatingBannerRes$RESPONSE$BANNER$BANON;", "getBanOn", "()Lcom/iloen/melon/net/v6x/response/FloatingBannerRes$RESPONSE$BANNER$BANON;", "setBanOn", "(Lcom/iloen/melon/net/v6x/response/FloatingBannerRes$RESPONSE$BANNER$BANON;)V", "bannerAreaCode", "getBannerAreaCode", "setBannerAreaCode", "isInduceLogin", "", "()Ljava/lang/Boolean;", "setInduceLogin", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "imgAltText", "getImgAltText", "setImgAltText", "BANON", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class BANNER extends LinkInfoBase {
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/net/v6x/response/FloatingBannerRes$RESPONSE$BANNER$BANON;", "Ljava/io/Serializable;", "<init>", "()V", "seq", "", "getSeq", "()Ljava/lang/String;", "setSeq", "(Ljava/lang/String;)V", "expiration", "getExpiration", "setExpiration", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class BANON implements Serializable {
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/FloatingBannerRes$RESPONSE$BANNER$BANON$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public static final class com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER.BANON.Companion {
                    private com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER.BANON.Companion() {
                    }

                    public com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER.BANON.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                    }
                }

                public static final int $stable = 0;
                @NotNull
                public static final com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER.BANON.Companion Companion = null;
                @b("expiration")
                @Nullable
                private String expiration;
                @b("seq")
                @Nullable
                private String seq;
                private static final long serialVersionUID = 5901755089699061225L;

                static {
                    BANON.Companion = new com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER.BANON.Companion(null);
                    BANON.$stable = 8;
                }

                @Nullable
                public final String getExpiration() {
                    return this.expiration;
                }

                @Nullable
                public final String getSeq() {
                    return this.seq;
                }

                public final void setExpiration(@Nullable String s) {
                    this.expiration = s;
                }

                public final void setSeq(@Nullable String s) {
                    this.seq = s;
                }
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/FloatingBannerRes$RESPONSE$BANNER$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER.Companion {
                private com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER.Companion() {
                }

                public com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER.Companion Companion = null;
            @b("adminTitle")
            @Nullable
            private String adminTitle;
            @b("banOn")
            @Nullable
            private BANON banOn;
            @b("bannerAreaCode")
            @Nullable
            private String bannerAreaCode;
            @b("bannerSeq")
            @Nullable
            private String bannerSeq;
            @b("bgColor")
            @Nullable
            private String bgColor;
            @b("contsId")
            @Nullable
            private String contsId;
            @b("contsTypeCode")
            @Nullable
            private String contsTypeCode;
            @b("dpTitle")
            @Nullable
            private String dpTitle;
            @b("dpType")
            @Nullable
            private String dpType;
            @b("floatingDetailType")
            @Nullable
            private String floatingDetailType;
            @b("imgAltText")
            @Nullable
            private String imgAltText;
            @b("imgUrl")
            @Nullable
            private String imgUrl;
            @b("isInduceLogin")
            @Nullable
            private Boolean isInduceLogin;
            private static final long serialVersionUID = 0x521EE820729BF29BL;
            @b("targetId")
            @Nullable
            private String targetId;
            @b("text1")
            @Nullable
            private String text1;
            @b("text1PointColor")
            @Nullable
            private String text1PointColor;
            @b("text2")
            @Nullable
            private String text2;
            @b("text2PointColor")
            @Nullable
            private String text2PointColor;

            static {
                BANNER.Companion = new com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER.Companion(null);
                BANNER.$stable = 8;
            }

            public BANNER() {
                this.text1 = "";
                this.text2 = "";
                this.isInduceLogin = Boolean.FALSE;
                this.imgAltText = "";
            }

            @Nullable
            public final String getAdminTitle() {
                return this.adminTitle;
            }

            @Nullable
            public final BANON getBanOn() {
                return this.banOn;
            }

            @Nullable
            public final String getBannerAreaCode() {
                return this.bannerAreaCode;
            }

            @Nullable
            public final String getBannerSeq() {
                return this.bannerSeq;
            }

            @Nullable
            public final String getBgColor() {
                return this.bgColor;
            }

            @Nullable
            public final String getContsId() {
                return this.contsId;
            }

            @Nullable
            public final String getContsTypeCode() {
                return this.contsTypeCode;
            }

            @Nullable
            public final String getDpTitle() {
                return this.dpTitle;
            }

            @Nullable
            public final String getDpType() {
                return this.dpType;
            }

            @Nullable
            public final String getFloatingDetailType() {
                return this.floatingDetailType;
            }

            @Nullable
            public final String getImgAltText() {
                return this.imgAltText;
            }

            @Nullable
            public final String getImgUrl() {
                return this.imgUrl;
            }

            @Nullable
            public final String getTargetId() {
                return this.targetId;
            }

            @Nullable
            public final String getText1() [...] // 潜在的解密器

            @Nullable
            public final String getText1PointColor() {
                return this.text1PointColor;
            }

            @Nullable
            public final String getText2() [...] // 潜在的解密器

            @Nullable
            public final String getText2PointColor() {
                return this.text2PointColor;
            }

            @Nullable
            public final Boolean isInduceLogin() {
                return this.isInduceLogin;
            }

            public final void setAdminTitle(@Nullable String s) {
                this.adminTitle = s;
            }

            public final void setBanOn(@Nullable BANON floatingBannerRes$RESPONSE$BANNER$BANON0) {
                this.banOn = floatingBannerRes$RESPONSE$BANNER$BANON0;
            }

            public final void setBannerAreaCode(@Nullable String s) {
                this.bannerAreaCode = s;
            }

            public final void setBannerSeq(@Nullable String s) {
                this.bannerSeq = s;
            }

            public final void setBgColor(@Nullable String s) {
                this.bgColor = s;
            }

            public final void setContsId(@Nullable String s) {
                this.contsId = s;
            }

            public final void setContsTypeCode(@Nullable String s) {
                this.contsTypeCode = s;
            }

            public final void setDpTitle(@Nullable String s) {
                this.dpTitle = s;
            }

            public final void setDpType(@Nullable String s) {
                this.dpType = s;
            }

            public final void setFloatingDetailType(@Nullable String s) {
                this.floatingDetailType = s;
            }

            public final void setImgAltText(@Nullable String s) {
                this.imgAltText = s;
            }

            public final void setImgUrl(@Nullable String s) {
                this.imgUrl = s;
            }

            public final void setInduceLogin(@Nullable Boolean boolean0) {
                this.isInduceLogin = boolean0;
            }

            public final void setTargetId(@Nullable String s) {
                this.targetId = s;
            }

            public final void setText1(@Nullable String s) {
                this.text1 = s;
            }

            public final void setText1PointColor(@Nullable String s) {
                this.text1PointColor = s;
            }

            public final void setText2(@Nullable String s) {
                this.text2 = s;
            }

            public final void setText2PointColor(@Nullable String s) {
                this.text2PointColor = s;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/FloatingBannerRes$RESPONSE$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.Companion {
            private com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.Companion() {
            }

            public com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.Companion Companion = null;
        @b("banners")
        @Nullable
        private ArrayList banners;
        @b("expiredBans")
        @Nullable
        private ArrayList expiredBans;
        private static final long serialVersionUID = 0x420EB853668B4A2AL;

        static {
            RESPONSE.Companion = new com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.Companion(null);
            RESPONSE.$stable = 8;
        }

        @Nullable
        public final ArrayList getBanners() {
            return this.banners;
        }

        @Nullable
        public final ArrayList getExpiredBans() {
            return this.expiredBans;
        }

        public final void setBanners(@Nullable ArrayList arrayList0) {
            this.banners = arrayList0;
        }

        public final void setExpiredBans(@Nullable ArrayList arrayList0) {
            this.expiredBans = arrayList0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @b("response")
    @Nullable
    private RESPONSE response;
    private static final long serialVersionUID = 0xF076F183C2AF94EBL;

    static {
        FloatingBannerRes.Companion = new Companion(null);
        FloatingBannerRes.$stable = 8;
    }

    @Nullable
    public final RESPONSE getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable RESPONSE floatingBannerRes$RESPONSE0) {
        this.response = floatingBannerRes$RESPONSE0;
    }
}

