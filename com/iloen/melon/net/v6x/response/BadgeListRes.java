package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/BadgeListRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/BadgeListRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/BadgeListRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/BadgeListRes$RESPONSE;)V", "RESPONSE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BadgeListRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u000F\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\b\"\u0004\b\u000E\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/net/v6x/response/BadgeListRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "badgeList", "", "Lcom/iloen/melon/net/v6x/response/BadgeListRes$RESPONSE$BADGELIST;", "getBadgeList", "()Ljava/util/List;", "setBadgeList", "(Ljava/util/List;)V", "iconList", "Lcom/iloen/melon/net/v6x/response/BadgeListRes$RESPONSE$ICONLIST;", "getIconList", "setIconList", "BADGELIST", "ICONLIST", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/net/v6x/response/BadgeListRes$RESPONSE$BADGELIST;", "Ljava/io/Serializable;", "<init>", "()V", "badgeSeq", "", "getBadgeSeq", "()Ljava/lang/String;", "setBadgeSeq", "(Ljava/lang/String;)V", "areaCode", "getAreaCode", "setAreaCode", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class BADGELIST implements Serializable {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/BadgeListRes$RESPONSE$BADGELIST$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class Companion {
                private Companion() {
                }

                public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final Companion Companion = null;
            @b("AREACODE")
            @Nullable
            private String areaCode;
            @b("BADGESEQ")
            @Nullable
            private String badgeSeq;
            private static final long serialVersionUID = 0xDD1598642E2421D8L;

            static {
                BADGELIST.Companion = new Companion(null);
                BADGELIST.$stable = 8;
            }

            @Nullable
            public final String getAreaCode() {
                return this.areaCode;
            }

            @Nullable
            public final String getBadgeSeq() {
                return this.badgeSeq;
            }

            public final void setAreaCode(@Nullable String s) {
                this.areaCode = s;
            }

            public final void setBadgeSeq(@Nullable String s) {
                this.badgeSeq = s;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\f\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/net/v6x/response/BadgeListRes$RESPONSE$ICONLIST;", "Ljava/io/Serializable;", "<init>", "()V", "areaCode", "", "getAreaCode", "()Ljava/lang/String;", "setAreaCode", "(Ljava/lang/String;)V", "visible", "getVisible", "setVisible", "iconUrl", "getIconUrl", "setIconUrl", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class ICONLIST implements Serializable {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/BadgeListRes$RESPONSE$ICONLIST$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v6x.response.BadgeListRes.RESPONSE.ICONLIST.Companion {
                private com.iloen.melon.net.v6x.response.BadgeListRes.RESPONSE.ICONLIST.Companion() {
                }

                public com.iloen.melon.net.v6x.response.BadgeListRes.RESPONSE.ICONLIST.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.v6x.response.BadgeListRes.RESPONSE.ICONLIST.Companion Companion = null;
            @b("AREACODE")
            @Nullable
            private String areaCode;
            @b("ICONURL")
            @Nullable
            private String iconUrl;
            private static final long serialVersionUID = 0x49C3292D8921DE28L;
            @b("VISIBLE")
            @Nullable
            private String visible;

            static {
                ICONLIST.Companion = new com.iloen.melon.net.v6x.response.BadgeListRes.RESPONSE.ICONLIST.Companion(null);
                ICONLIST.$stable = 8;
            }

            @Nullable
            public final String getAreaCode() {
                return this.areaCode;
            }

            @Nullable
            public final String getIconUrl() {
                return this.iconUrl;
            }

            @Nullable
            public final String getVisible() {
                return this.visible;
            }

            public final void setAreaCode(@Nullable String s) {
                this.areaCode = s;
            }

            public final void setIconUrl(@Nullable String s) {
                this.iconUrl = s;
            }

            public final void setVisible(@Nullable String s) {
                this.visible = s;
            }
        }

        public static final int $stable = 8;
        @b("BADGELIST")
        @Nullable
        private List badgeList;
        @b("ICONLIST")
        @Nullable
        private List iconList;

        @Nullable
        public final List getBadgeList() {
            return this.badgeList;
        }

        @Nullable
        public final List getIconList() {
            return this.iconList;
        }

        public final void setBadgeList(@Nullable List list0) {
            this.badgeList = list0;
        }

        public final void setIconList(@Nullable List list0) {
            this.iconList = list0;
        }
    }

    public static final int $stable = 8;
    @b("response")
    @Nullable
    private RESPONSE response;

    @Nullable
    public final RESPONSE getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable RESPONSE badgeListRes$RESPONSE0) {
        this.response = badgeListRes$RESPONSE0;
    }
}

