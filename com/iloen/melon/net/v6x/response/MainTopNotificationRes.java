package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.LinkInfoBase;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pe.a;
import va.e;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\b\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0007\f\r\u000E\u000F\u0010\u0011\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001A\u00020\u000BH\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$Response;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$Response;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$Response;)V", "toString", "", "Response", "NOTICE", "LISTFEED", "STATSELEMENTS", "ImageDpType", "FeedType", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MainTopNotificationRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$FeedType;", "", "<init>", "(Ljava/lang/String;I)V", "NOTICE", "DNA", "TEMPERATURE", "ARTISTANNIVERSARY", "BADGE", "UNKNOWN", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum FeedType {
        @b("NOTICE")
        NOTICE,
        @b("DNA")
        DNA,
        @b("TEMPERATURE")
        TEMPERATURE,
        @b("ARTISTANNIVERSARY")
        ARTISTANNIVERSARY,
        @b("BADGE")
        BADGE,
        @b("UNKNOWN")
        UNKNOWN;

        private static final a $ENTRIES;
        private static final FeedType[] $VALUES;

        private static final FeedType[] $values() [...] // Inlined contents

        static {
            FeedType.$VALUES = arr_mainTopNotificationRes$FeedType;
            q.g(arr_mainTopNotificationRes$FeedType, "entries");
            FeedType.$ENTRIES = new pe.b(arr_mainTopNotificationRes$FeedType);
        }

        @NotNull
        public static a getEntries() {
            return FeedType.$ENTRIES;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$ImageDpType;", "", "<init>", "(Ljava/lang/String;I)V", "CIRCLE", "SQUARE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum ImageDpType {
        @b("CIRCLE")
        CIRCLE,
        @b("SQUARE")
        SQUARE;

        private static final a $ENTRIES;
        private static final ImageDpType[] $VALUES;

        private static final ImageDpType[] $values() [...] // Inlined contents

        static {
            ImageDpType.$VALUES = arr_mainTopNotificationRes$ImageDpType;
            q.g(arr_mainTopNotificationRes$ImageDpType, "entries");
            ImageDpType.$ENTRIES = new pe.b(arr_mainTopNotificationRes$ImageDpType);
        }

        @NotNull
        public static a getEntries() {
            return ImageDpType.$ENTRIES;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u001E\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010+\u001A\u00020\u00112\u0006\u0010,\u001A\u00020\u0000H\u0002J\u0010\u0010-\u001A\u00020\u00112\u0006\u0010.\u001A\u00020\u0011H\u0002R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR \u0010\u0010\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R \u0010\u0019\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0013\"\u0004\b\u001B\u0010\u0015R \u0010\u001C\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0013\"\u0004\b\u001E\u0010\u0015R \u0010\u001F\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R \u0010\"\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R \u0010%\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u0013\"\u0004\b\'\u0010\u0015R \u0010(\u001A\u0004\u0018\u00010\u00118F@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015¨\u0006/"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$LISTFEED;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "imgDpType", "Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$ImageDpType;", "getImgDpType", "()Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$ImageDpType;", "setImgDpType", "(Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$ImageDpType;)V", "type", "Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$FeedType;", "getType", "()Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$FeedType;", "setType", "(Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$FeedType;)V", "contsId", "", "getContsId", "()Ljava/lang/String;", "setContsId", "(Ljava/lang/String;)V", "imgUrl", "getImgUrl", "setImgUrl", "text", "getText", "setText", "title", "getTitle", "setTitle", "titleReplace", "getTitleReplace", "setTitleReplace", "artistName", "getArtistName", "setArtistName", "schemeUrl", "getSchemeUrl", "setSchemeUrl", "uniqueKey", "getUniqueKey", "setUniqueKey", "getFeedUniqueKey", "feed", "hashString", "input", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class LISTFEED extends LinkInfoBase {
        public static final int $stable = 8;
        @b("ARTISTNAME")
        @Nullable
        private String artistName;
        @b("CONTSID")
        @Nullable
        private String contsId;
        @b("IMGTYPE")
        @Nullable
        private ImageDpType imgDpType;
        @b("IMGURL")
        @Nullable
        private String imgUrl;
        @b("SCHEMEURL")
        @Nullable
        private String schemeUrl;
        @b("TEXT")
        @Nullable
        private String text;
        @b("TITLE")
        @Nullable
        private String title;
        @b("TITLEREPLACE")
        @Nullable
        private String titleReplace;
        @b("TYPE")
        @Nullable
        private FeedType type;
        @b("UNIQUEKEY")
        @Nullable
        private String uniqueKey;

        public LISTFEED() {
            this.schemeUrl = "";
        }

        @Nullable
        public final String getArtistName() {
            return this.artistName;
        }

        @Nullable
        public final String getContsId() {
            return this.contsId;
        }

        private final String getFeedUniqueKey(LISTFEED mainTopNotificationRes$LISTFEED0) {
            return this.hashString(mainTopNotificationRes$LISTFEED0.imgUrl + mainTopNotificationRes$LISTFEED0.title + mainTopNotificationRes$LISTFEED0.text + mainTopNotificationRes$LISTFEED0.schemeUrl);
        }

        @Nullable
        public final ImageDpType getImgDpType() {
            return this.imgDpType;
        }

        @Nullable
        public final String getImgUrl() {
            return this.imgUrl;
        }

        @Nullable
        public final String getSchemeUrl() [...] // 潜在的解密器

        @Nullable
        public final String getText() {
            return this.text;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getTitleReplace() {
            return this.titleReplace;
        }

        @Nullable
        public final FeedType getType() {
            return this.type;
        }

        @Nullable
        public final String getUniqueKey() [...] // 潜在的解密器

        private final String hashString(String s) {
            MessageDigest messageDigest0 = MessageDigest.getInstance("SHA-256");
            byte[] arr_b = s.getBytes(Tf.a.a);
            q.f(arr_b, "getBytes(...)");
            byte[] arr_b1 = messageDigest0.digest(arr_b);
            q.f(arr_b1, "digest(...)");
            String s1 = "";
            for(int v = 0; v < arr_b1.length; ++v) {
                s1 = e.h(s1, String.format("%02x", Arrays.copyOf(new Object[]{((byte)arr_b1[v])}, 1)));
            }
            return s1;
        }

        public final void setArtistName(@Nullable String s) {
            this.artistName = s;
        }

        public final void setContsId(@Nullable String s) {
            this.contsId = s;
        }

        public final void setImgDpType(@Nullable ImageDpType mainTopNotificationRes$ImageDpType0) {
            this.imgDpType = mainTopNotificationRes$ImageDpType0;
        }

        public final void setImgUrl(@Nullable String s) {
            this.imgUrl = s;
        }

        public final void setSchemeUrl(@Nullable String s) {
            this.schemeUrl = s;
        }

        public final void setText(@Nullable String s) {
            this.text = s;
        }

        public final void setTitle(@Nullable String s) {
            this.title = s;
        }

        public final void setTitleReplace(@Nullable String s) {
            this.titleReplace = s;
        }

        public final void setType(@Nullable FeedType mainTopNotificationRes$FeedType0) {
            this.type = mainTopNotificationRes$FeedType0;
        }

        public final void setUniqueKey(@Nullable String s) {
            this.uniqueKey = s;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0015\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$NOTICE;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "offerSeq", "", "getOfferSeq", "()Ljava/lang/String;", "setOfferSeq", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "subTitle", "getSubTitle", "setSubTitle", "iconUrl", "getIconUrl", "setIconUrl", "darkIconUrl", "getDarkIconUrl", "setDarkIconUrl", "titleHeader", "getTitleHeader", "setTitleHeader", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class NOTICE extends LinkInfoBase {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$NOTICE$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.net.v6x.response.MainTopNotificationRes.NOTICE.Companion {
            private com.iloen.melon.net.v6x.response.MainTopNotificationRes.NOTICE.Companion() {
            }

            public com.iloen.melon.net.v6x.response.MainTopNotificationRes.NOTICE.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.net.v6x.response.MainTopNotificationRes.NOTICE.Companion Companion = null;
        @b("DARKICONURL")
        @Nullable
        private String darkIconUrl;
        @b("ICONURL")
        @Nullable
        private String iconUrl;
        @b("OFFERSEQ")
        @Nullable
        private String offerSeq;
        private static final long serialVersionUID = 0xF8764F02BEFD7127L;
        @b("SUBTITLE")
        @Nullable
        private String subTitle;
        @b("TITLE")
        @Nullable
        private String title;
        @b("TITLEHEADER")
        @Nullable
        private String titleHeader;

        static {
            NOTICE.Companion = new com.iloen.melon.net.v6x.response.MainTopNotificationRes.NOTICE.Companion(null);
            NOTICE.$stable = 8;
        }

        @Nullable
        public final String getDarkIconUrl() {
            return this.darkIconUrl;
        }

        @Nullable
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @Nullable
        public final String getOfferSeq() {
            return this.offerSeq;
        }

        @Nullable
        public final String getSubTitle() {
            return this.subTitle;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getTitleHeader() {
            return this.titleHeader;
        }

        public final void setDarkIconUrl(@Nullable String s) {
            this.darkIconUrl = s;
        }

        public final void setIconUrl(@Nullable String s) {
            this.iconUrl = s;
        }

        public final void setOfferSeq(@Nullable String s) {
            this.offerSeq = s;
        }

        public final void setSubTitle(@Nullable String s) {
            this.subTitle = s;
        }

        public final void setTitle(@Nullable String s) {
            this.title = s;
        }

        public final void setTitleHeader(@Nullable String s) {
            this.titleHeader = s;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R \u0010\u0011\u001A\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$Response;", "", "<init>", "()V", "notice", "Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$NOTICE;", "getNotice", "()Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$NOTICE;", "setNotice", "(Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$NOTICE;)V", "feedList", "", "Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$LISTFEED;", "getFeedList", "()Ljava/util/List;", "setFeedList", "(Ljava/util/List;)V", "statsElements", "Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$STATSELEMENTS;", "getStatsElements", "()Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$STATSELEMENTS;", "setStatsElements", "(Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$STATSELEMENTS;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response {
        public static final int $stable = 8;
        @b("LISTFEED")
        @Nullable
        private List feedList;
        @b("NOTICE")
        @Nullable
        private NOTICE notice;
        @b("STATSELEMENTS")
        @Nullable
        private STATSELEMENTS statsElements;

        @Nullable
        public final List getFeedList() {
            return this.feedList;
        }

        @Nullable
        public final NOTICE getNotice() {
            return this.notice;
        }

        @Nullable
        public final STATSELEMENTS getStatsElements() {
            return this.statsElements;
        }

        public final void setFeedList(@Nullable List list0) {
            this.feedList = list0;
        }

        public final void setNotice(@Nullable NOTICE mainTopNotificationRes$NOTICE0) {
            this.notice = mainTopNotificationRes$NOTICE0;
        }

        public final void setStatsElements(@Nullable STATSELEMENTS mainTopNotificationRes$STATSELEMENTS0) {
            this.statsElements = mainTopNotificationRes$STATSELEMENTS0;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MainTopNotificationRes$STATSELEMENTS;", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class STATSELEMENTS extends StatsElementsBase {
        public static final int $stable = 0;
        @NotNull
        public static final STATSELEMENTS INSTANCE = null;
        private static final long serialVersionUID = 0x84BB0F33CD1C1344L;

        static {
            STATSELEMENTS.INSTANCE = new STATSELEMENTS();
            STATSELEMENTS.$stable = 8;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @b("response")
    @Nullable
    private Response response;
    private static final long serialVersionUID = 0xC4F6A564BF0C99FL;

    static {
        MainTopNotificationRes.Companion = new Companion(null);
        MainTopNotificationRes.$stable = 8;
    }

    @Nullable
    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable Response mainTopNotificationRes$Response0) {
        this.response = mainTopNotificationRes$Response0;
    }

    @Override
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

