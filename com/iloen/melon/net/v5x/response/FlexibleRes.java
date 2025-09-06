package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.HeaderBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v6x.response.ForUMixInfoBase;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pe.a;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u000F\b\u0007\u0018\u0000 \u00192\u00020\u0001:\f\u000E\u000F\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v5x/response/FlexibleRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v5x/response/FlexibleRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v5x/response/FlexibleRes$RESPONSE;)V", "menuId", "", "getMenuId", "()Ljava/lang/String;", "RESPONSE", "Chat", "LiveStatusCode", "ButtonType", "LogoType", "BadgeType", "OfferType", "ImageType", "ImageDpType", "ContentDpType", "TrendUiType", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FlexibleRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$BadgeType;", "", "<init>", "(Ljava/lang/String;I)V", "EVENT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum BadgeType {
        @b("EVENT")
        EVENT;

        private static final a $ENTRIES;
        private static final BadgeType[] $VALUES;

        private static final BadgeType[] $values() [...] // Inlined contents

        static {
            BadgeType.$VALUES = arr_flexibleRes$BadgeType;
            q.g(arr_flexibleRes$BadgeType, "entries");
            BadgeType.$ENTRIES = new pe.b(arr_flexibleRes$BadgeType);
        }

        @NotNull
        public static a getEntries() {
            return BadgeType.$ENTRIES;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$ButtonType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "LOGO", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum ButtonType {
        @b("T")
        TEXT,
        @b("L")
        LOGO;

        private static final a $ENTRIES;
        private static final ButtonType[] $VALUES;

        private static final ButtonType[] $values() [...] // Inlined contents

        static {
            ButtonType.$VALUES = arr_flexibleRes$ButtonType;
            q.g(arr_flexibleRes$ButtonType, "entries");
            ButtonType.$ENTRIES = new pe.b(arr_flexibleRes$ButtonType);
        }

        @NotNull
        public static a getEntries() {
            return ButtonType.$ENTRIES;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$Chat;", "", "<init>", "()V", "profileImgUrl", "", "getProfileImgUrl", "()Ljava/lang/String;", "setProfileImgUrl", "(Ljava/lang/String;)V", "text", "getText", "setText", "name", "getName", "setName", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Chat {
        public static final int $stable = 8;
        @b("NAME")
        @Nullable
        private String name;
        @b("PROFILEIMGURL")
        @Nullable
        private String profileImgUrl;
        @b("TEXT")
        @Nullable
        private String text;

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getProfileImgUrl() {
            return this.profileImgUrl;
        }

        @Nullable
        public final String getText() {
            return this.text;
        }

        public final void setName(@Nullable String s) {
            this.name = s;
        }

        public final void setProfileImgUrl(@Nullable String s) {
            this.profileImgUrl = s;
        }

        public final void setText(@Nullable String s) {
            this.text = s;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$ContentDpType;", "", "<init>", "(Ljava/lang/String;I)V", "BEFOREHAND", "THE_DAY", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum ContentDpType {
        @b("P")
        BEFOREHAND,
        @b("D")
        THE_DAY;

        private static final a $ENTRIES;
        private static final ContentDpType[] $VALUES;

        private static final ContentDpType[] $values() [...] // Inlined contents

        static {
            ContentDpType.$VALUES = arr_flexibleRes$ContentDpType;
            q.g(arr_flexibleRes$ContentDpType, "entries");
            ContentDpType.$ENTRIES = new pe.b(arr_flexibleRes$ContentDpType);
        }

        @NotNull
        public static a getEntries() {
            return ContentDpType.$ENTRIES;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$ImageDpType;", "", "<init>", "(Ljava/lang/String;I)V", "MULTIPLE", "NORMAL", "DESIGN", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum ImageDpType {
        @b("M")
        MULTIPLE,
        @b("N")
        NORMAL,
        @b("D")
        DESIGN;

        private static final a $ENTRIES;
        private static final ImageDpType[] $VALUES;

        private static final ImageDpType[] $values() [...] // Inlined contents

        static {
            ImageDpType.$VALUES = arr_flexibleRes$ImageDpType;
            q.g(arr_flexibleRes$ImageDpType, "entries");
            ImageDpType.$ENTRIES = new pe.b(arr_flexibleRes$ImageDpType);
        }

        @NotNull
        public static a getEntries() {
            return ImageDpType.$ENTRIES;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$ImageType;", "", "<init>", "(Ljava/lang/String;I)V", "ARTIST", "ALBUM", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum ImageType {
        @b("ARTIST")
        ARTIST,
        @b("ALBUM")
        ALBUM;

        private static final a $ENTRIES;
        private static final ImageType[] $VALUES;

        private static final ImageType[] $values() [...] // Inlined contents

        static {
            ImageType.$VALUES = arr_flexibleRes$ImageType;
            q.g(arr_flexibleRes$ImageType, "entries");
            ImageType.$ENTRIES = new pe.b(arr_flexibleRes$ImageType);
        }

        @NotNull
        public static a getEntries() {
            return ImageType.$ENTRIES;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$LiveStatusCode;", "", "<init>", "(Ljava/lang/String;I)V", "BEFORE_LIVE", "LIVE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum LiveStatusCode {
        @b("BS02")
        BEFORE_LIVE,
        @b("BS03")
        LIVE;

        private static final a $ENTRIES;
        private static final LiveStatusCode[] $VALUES;

        private static final LiveStatusCode[] $values() [...] // Inlined contents

        static {
            LiveStatusCode.$VALUES = arr_flexibleRes$LiveStatusCode;
            q.g(arr_flexibleRes$LiveStatusCode, "entries");
            LiveStatusCode.$ENTRIES = new pe.b(arr_flexibleRes$LiveStatusCode);
        }

        @NotNull
        public static a getEntries() {
            return LiveStatusCode.$ENTRIES;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$LogoType;", "", "<init>", "(Ljava/lang/String;I)V", "MELON_ONLY", "STATION", "MAGAZINE", "MELON", "MUSIC_WAVE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum LogoType {
        @b("MELONONLY")
        MELON_ONLY,
        @b("STATION")
        STATION,
        @b("MAGAZINE")
        MAGAZINE,
        @b("MELON")
        MELON,
        @b("MUSICWAVE")
        MUSIC_WAVE;

        private static final a $ENTRIES;
        private static final LogoType[] $VALUES;

        private static final LogoType[] $values() [...] // Inlined contents

        static {
            LogoType.$VALUES = arr_flexibleRes$LogoType;
            q.g(arr_flexibleRes$LogoType, "entries");
            LogoType.$ENTRIES = new pe.b(arr_flexibleRes$LogoType);
        }

        @NotNull
        public static a getEntries() {
            return LogoType.$ENTRIES;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000F\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$OfferType;", "", "setNum", "", "<init>", "(Ljava/lang/String;II)V", "getSetNum", "()I", "SPECIAL_1", "SPECIAL_2", "THEME_FULL", "THEME_LIGHT", "THEME_FULL_ZERO", "BASIC", "LIVE", "TREND_SHORT_FORM", "MUSIC_WAVE", "MUSIC_WAVE_SINGLE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum OfferType {
        @b("S1")
        SPECIAL_1(2),
        @b("S2")
        SPECIAL_2(2),
        @b("TF")
        THEME_FULL(3),
        @b("TL")
        THEME_LIGHT(3),
        @b("TM")
        THEME_FULL_ZERO(3),
        @b("N")
        BASIC(1),
        @b("L")
        LIVE(4),
        @b("TS")
        TREND_SHORT_FORM(5),
        @b("MW")
        MUSIC_WAVE(6),
        @b("WS")
        MUSIC_WAVE_SINGLE(7);

        private static final a $ENTRIES;
        private static final OfferType[] $VALUES;
        private final int setNum;

        private static final OfferType[] $values() [...] // Inlined contents

        static {
            OfferType.$VALUES = arr_flexibleRes$OfferType;
            q.g(arr_flexibleRes$OfferType, "entries");
            OfferType.$ENTRIES = new pe.b(arr_flexibleRes$OfferType);
        }

        private OfferType(int v1) {
            this.setNum = v1;
        }

        @NotNull
        public static a getEntries() {
            return OfferType.$ENTRIES;
        }

        public final int getSetNum() {
            return this.setNum;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000E2\u00020\u0001:\u0002\r\u000EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000B\u001A\u00020\fH\u0016R&\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "flexibleList", "", "Lcom/iloen/melon/net/v5x/response/FlexibleRes$RESPONSE$Flexible;", "getFlexibleList", "()Ljava/util/List;", "setFlexibleList", "(Ljava/util/List;)V", "toString", "", "Flexible", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$RESPONSE$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Companion {
            private com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Companion() {
            }

            public com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0002\'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010&\u001A\u00020\u0005H\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR \u0010\u0010\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR&\u0010\u001D\u001A\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u001A\"\u0004\b\u001F\u0010\u001CR \u0010 \u001A\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$RESPONSE$Flexible;", "Ljava/io/Serializable;", "<init>", "()V", "slotId", "", "getSlotId", "()Ljava/lang/String;", "setSlotId", "(Ljava/lang/String;)V", "offerType", "Lcom/iloen/melon/net/v5x/response/FlexibleRes$OfferType;", "getOfferType", "()Lcom/iloen/melon/net/v5x/response/FlexibleRes$OfferType;", "setOfferType", "(Lcom/iloen/melon/net/v5x/response/FlexibleRes$OfferType;)V", "header", "Lcom/iloen/melon/net/v5x/response/FlexibleRes$RESPONSE$Flexible$Header;", "getHeader", "()Lcom/iloen/melon/net/v5x/response/FlexibleRes$RESPONSE$Flexible$Header;", "setHeader", "(Lcom/iloen/melon/net/v5x/response/FlexibleRes$RESPONSE$Flexible$Header;)V", "contents", "", "Lcom/iloen/melon/net/v5x/response/FlexibleRes$RESPONSE$Flexible$Content;", "getContents", "()Ljava/util/List;", "setContents", "(Ljava/util/List;)V", "subContents", "getSubContents", "setSubContents", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "toString", "Header", "Content", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Flexible implements Serializable {
            @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\tR \u0010\u001C\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0007\"\u0004\b\u001E\u0010\tR \u0010\u001F\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR \u0010\"\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR \u0010%\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u0007\"\u0004\b\'\u0010\tR \u0010(\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR \u0010+\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR \u0010.\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR \u00101\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR \u00104\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR \u00107\u001A\u0004\u0018\u0001088\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b9\u0010:\"\u0004\b;\u0010<R \u0010=\u001A\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b?\u0010@\"\u0004\bA\u0010BR \u0010C\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bD\u0010\u0007\"\u0004\bE\u0010\tR \u0010F\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bG\u0010\u0007\"\u0004\bH\u0010\tR \u0010I\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bJ\u0010\u0007\"\u0004\bK\u0010\tR \u0010L\u001A\u0004\u0018\u00010M8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bN\u0010O\"\u0004\bP\u0010QR \u0010R\u001A\u0004\u0018\u00010S8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bT\u0010U\"\u0004\bV\u0010WR \u0010X\u001A\u0004\u0018\u00010Y8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bZ\u0010[\"\u0004\b\\\u0010]R \u0010^\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b_\u0010\u0007\"\u0004\b`\u0010\tR \u0010a\u001A\u0004\u0018\u00010b8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bc\u0010d\"\u0004\be\u0010fR \u0010g\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bh\u0010\u0007\"\u0004\bi\u0010\tR \u0010j\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bk\u0010\u0007\"\u0004\bl\u0010\tR \u0010m\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bn\u0010\u0007\"\u0004\bo\u0010\tR \u0010p\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bq\u0010\u0007\"\u0004\br\u0010\tR\u001A\u0010s\u001A\u00020tX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bu\u0010v\"\u0004\bw\u0010xR \u0010y\u001A\u0004\u0018\u00010z8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b{\u0010|\"\u0004\b}\u0010~R\"\u0010\u007F\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0080\u0001\u0010\u0007\"\u0005\b\u0081\u0001\u0010\tR#\u0010\u0082\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0083\u0001\u0010\u0007\"\u0005\b\u0084\u0001\u0010\tR)\u0010\u0085\u0001\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0086\u0001\u0010\r\"\u0005\b\u0087\u0001\u0010\u000FR#\u0010\u0088\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0089\u0001\u0010\u0007\"\u0005\b\u008A\u0001\u0010\tR#\u0010\u008B\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u008C\u0001\u0010\u0007\"\u0005\b\u008D\u0001\u0010\tR*\u0010\u008E\u0001\u001A\u000B\u0012\u0005\u0012\u00030\u008F\u0001\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0090\u0001\u0010\r\"\u0005\b\u0091\u0001\u0010\u000FR#\u0010\u0092\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0093\u0001\u0010\u0007\"\u0005\b\u0094\u0001\u0010\tR*\u0010\u0095\u0001\u001A\u000B\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0097\u0001\u0010\r\"\u0005\b\u0098\u0001\u0010\u000FR(\u0010\u0099\u0001\u001A\u0004\u0018\u00010t8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0015\n\u0003\u0010\u009E\u0001\u001A\u0006\b\u009A\u0001\u0010\u009B\u0001\"\u0006\b\u009C\u0001\u0010\u009D\u0001R$\u0010\u009F\u0001\u001A\u00030\u00A0\u00018\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0000\u001A\u0006\b\u009F\u0001\u0010\u00A1\u0001\"\u0006\b\u00A2\u0001\u0010\u00A3\u0001R#\u0010\u00A4\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00A5\u0001\u0010\u0007\"\u0005\b\u00A6\u0001\u0010\tR#\u0010\u00A7\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00A8\u0001\u0010\u0007\"\u0005\b\u00A9\u0001\u0010\tR#\u0010\u00AA\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00AB\u0001\u0010\u0007\"\u0005\b\u00AC\u0001\u0010\tR#\u0010\u00AD\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00AE\u0001\u0010\u0007\"\u0005\b\u00AF\u0001\u0010\tR#\u0010\u00B0\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00B1\u0001\u0010\u0007\"\u0005\b\u00B2\u0001\u0010\tR#\u0010\u00B3\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00B4\u0001\u0010\u0007\"\u0005\b\u00B5\u0001\u0010\t\u00A8\u0006\u00B6\u0001"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$RESPONSE$Flexible$Content;", "Lcom/iloen/melon/net/v6x/response/ForUMixInfoBase;", "<init>", "()V", "imgUrl", "", "getImgUrl", "()Ljava/lang/String;", "setImgUrl", "(Ljava/lang/String;)V", "imgList", "", "getImgList", "()Ljava/util/List;", "setImgList", "(Ljava/util/List;)V", "effectImgUrl", "getEffectImgUrl", "setEffectImgUrl", "buttonType", "Lcom/iloen/melon/net/v5x/response/FlexibleRes$ButtonType;", "getButtonType", "()Lcom/iloen/melon/net/v5x/response/FlexibleRes$ButtonType;", "setButtonType", "(Lcom/iloen/melon/net/v5x/response/FlexibleRes$ButtonType;)V", "buttonText", "getButtonText", "setButtonText", "buttonBgColor", "getButtonBgColor", "setButtonBgColor", "buttonFontColor", "getButtonFontColor", "setButtonFontColor", "buttonLogoImgUrl", "getButtonLogoImgUrl", "setButtonLogoImgUrl", "linkType", "getLinkType", "setLinkType", "linkUrl", "getLinkUrl", "setLinkUrl", "scheme", "getScheme", "setScheme", "title", "getTitle", "setTitle", "subTitle", "getSubTitle", "setSubTitle", "topicTitle", "getTopicTitle", "setTopicTitle", "logoType", "Lcom/iloen/melon/net/v5x/response/FlexibleRes$LogoType;", "getLogoType", "()Lcom/iloen/melon/net/v5x/response/FlexibleRes$LogoType;", "setLogoType", "(Lcom/iloen/melon/net/v5x/response/FlexibleRes$LogoType;)V", "badgeType", "Lcom/iloen/melon/net/v5x/response/FlexibleRes$BadgeType;", "getBadgeType", "()Lcom/iloen/melon/net/v5x/response/FlexibleRes$BadgeType;", "setBadgeType", "(Lcom/iloen/melon/net/v5x/response/FlexibleRes$BadgeType;)V", "adultGrade", "getAdultGrade", "setAdultGrade", "artistId", "getArtistId", "setArtistId", "bgColor", "getBgColor", "setBgColor", "imageType", "Lcom/iloen/melon/net/v5x/response/FlexibleRes$ImageType;", "getImageType", "()Lcom/iloen/melon/net/v5x/response/FlexibleRes$ImageType;", "setImageType", "(Lcom/iloen/melon/net/v5x/response/FlexibleRes$ImageType;)V", "imageDpType", "Lcom/iloen/melon/net/v5x/response/FlexibleRes$ImageDpType;", "getImageDpType", "()Lcom/iloen/melon/net/v5x/response/FlexibleRes$ImageDpType;", "setImageDpType", "(Lcom/iloen/melon/net/v5x/response/FlexibleRes$ImageDpType;)V", "contentDpType", "Lcom/iloen/melon/net/v5x/response/FlexibleRes$ContentDpType;", "getContentDpType", "()Lcom/iloen/melon/net/v5x/response/FlexibleRes$ContentDpType;", "setContentDpType", "(Lcom/iloen/melon/net/v5x/response/FlexibleRes$ContentDpType;)V", "liveSeq", "getLiveSeq", "setLiveSeq", "liveStatusCode", "Lcom/iloen/melon/net/v5x/response/FlexibleRes$LiveStatusCode;", "getLiveStatusCode", "()Lcom/iloen/melon/net/v5x/response/FlexibleRes$LiveStatusCode;", "setLiveStatusCode", "(Lcom/iloen/melon/net/v5x/response/FlexibleRes$LiveStatusCode;)V", "liveTitle", "getLiveTitle", "setLiveTitle", "previewMvid", "getPreviewMvid", "setPreviewMvid", "previewUrl", "getPreviewUrl", "setPreviewUrl", "fileUpdateDate", "getFileUpdateDate", "setFileUpdateDate", "currentPosition", "", "getCurrentPosition", "()J", "setCurrentPosition", "(J)V", "trendUiType", "Lcom/iloen/melon/net/v5x/response/FlexibleRes$TrendUiType;", "getTrendUiType", "()Lcom/iloen/melon/net/v5x/response/FlexibleRes$TrendUiType;", "setTrendUiType", "(Lcom/iloen/melon/net/v5x/response/FlexibleRes$TrendUiType;)V", "shapeImgUrl", "getShapeImgUrl", "setShapeImgUrl", "bgImgUrl", "getBgImgUrl", "setBgImgUrl", "lyricsList", "getLyricsList", "setLyricsList", "magazineBadgeImgUrl", "getMagazineBadgeImgUrl", "setMagazineBadgeImgUrl", "songName", "getSongName", "setSongName", "artistList", "Lcom/melon/net/res/common/ArtistInfoBase;", "getArtistList", "setArtistList", "viewCountText", "getViewCountText", "setViewCountText", "chatList", "Lcom/iloen/melon/net/v5x/response/FlexibleRes$Chat;", "getChatList", "setChatList", "liveStartDate", "getLiveStartDate", "()Ljava/lang/Long;", "setLiveStartDate", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isArtistType", "", "()Z", "setArtistType", "(Z)V", "pattImgType", "getPattImgType", "setPattImgType", "pattColorType", "getPattColorType", "setPattColorType", "channelTitle", "getChannelTitle", "setChannelTitle", "logoImgUrl", "getLogoImgUrl", "setLogoImgUrl", "bgType", "getBgType", "setBgType", "bgVideoUrl", "getBgVideoUrl", "setBgVideoUrl", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class Content extends ForUMixInfoBase {
                public static final int $stable = 8;
                @b("ADULTGRADE")
                @Nullable
                private String adultGrade;
                @b("ARTISTID")
                @Nullable
                private String artistId;
                @b("ARTISTLIST")
                @Nullable
                private List artistList;
                @b("BADGETYPE")
                @Nullable
                private BadgeType badgeType;
                @b("BGCOLOR")
                @Nullable
                private String bgColor;
                @b("BGIMGURL")
                @Nullable
                private String bgImgUrl;
                @b("BGTYPE")
                @Nullable
                private String bgType;
                @b("BGVIDEOURL")
                @Nullable
                private String bgVideoUrl;
                @b("BUTTONBGCOLOR")
                @Nullable
                private String buttonBgColor;
                @b("BUTTONFONTCOLOR")
                @Nullable
                private String buttonFontColor;
                @b("BUTTONLOGOIMGURL")
                @Nullable
                private String buttonLogoImgUrl;
                @b("BUTTONTEXT")
                @Nullable
                private String buttonText;
                @b("BUTTONTYPE")
                @Nullable
                private ButtonType buttonType;
                @b("CHANNELTITLE")
                @Nullable
                private String channelTitle;
                @b("CHATLIST")
                @Nullable
                private List chatList;
                @b("CONTSDPTYPE")
                @Nullable
                private ContentDpType contentDpType;
                private long currentPosition;
                @b("EFFECTIMGURL")
                @Nullable
                private String effectImgUrl;
                @b("FILEUPDTDATE")
                @Nullable
                private String fileUpdateDate;
                @b("IMGDPTYPE")
                @Nullable
                private ImageDpType imageDpType;
                @b("IMGTYPE")
                @Nullable
                private ImageType imageType;
                @b("IMGLIST")
                @Nullable
                private List imgList;
                @b("IMGURL")
                @Nullable
                private String imgUrl;
                @b("ISARTISTTYPE")
                private boolean isArtistType;
                @b("LINKTYPE")
                @Nullable
                private String linkType;
                @b("LINKURL")
                @Nullable
                private String linkUrl;
                @b("LIVESEQ")
                @Nullable
                private String liveSeq;
                @b("LIVESTARTDATE")
                @Nullable
                private Long liveStartDate;
                @b("LIVESTATUSCODE")
                @Nullable
                private LiveStatusCode liveStatusCode;
                @b("LIVETITLE")
                @Nullable
                private String liveTitle;
                @b("LOGOIMGURL")
                @Nullable
                private String logoImgUrl;
                @b("LOGOTYPE")
                @Nullable
                private LogoType logoType;
                @b("LYRICSLIST")
                @Nullable
                private List lyricsList;
                @b("MAGAZINEBADGEIMGURL")
                @Nullable
                private String magazineBadgeImgUrl;
                @b("PATTCOLORTYPE")
                @Nullable
                private String pattColorType;
                @b("PATTIMGTYPE")
                @Nullable
                private String pattImgType;
                @b("PREVIEWMVID")
                @Nullable
                private String previewMvid;
                @b("PREVIEWURL")
                @Nullable
                private String previewUrl;
                @b("SCHEME")
                @Nullable
                private String scheme;
                @b("SHAPEIMGURL")
                @Nullable
                private String shapeImgUrl;
                @b("SONGNAME")
                @Nullable
                private String songName;
                @b("SUBTITLE")
                @Nullable
                private String subTitle;
                @b("TITLE")
                @Nullable
                private String title;
                @b("TOPICTITLE")
                @Nullable
                private String topicTitle;
                @b("TRENDUITYPE")
                @Nullable
                private TrendUiType trendUiType;
                @b("VIEWCOUNTTEXT")
                @Nullable
                private String viewCountText;

                @Nullable
                public final String getAdultGrade() {
                    return this.adultGrade;
                }

                @Nullable
                public final String getArtistId() {
                    return this.artistId;
                }

                @Nullable
                public final List getArtistList() {
                    return this.artistList;
                }

                @Nullable
                public final BadgeType getBadgeType() {
                    return this.badgeType;
                }

                @Nullable
                public final String getBgColor() {
                    return this.bgColor;
                }

                @Nullable
                public final String getBgImgUrl() {
                    return this.bgImgUrl;
                }

                @Nullable
                public final String getBgType() {
                    return this.bgType;
                }

                @Nullable
                public final String getBgVideoUrl() {
                    return this.bgVideoUrl;
                }

                @Nullable
                public final String getButtonBgColor() {
                    return this.buttonBgColor;
                }

                @Nullable
                public final String getButtonFontColor() {
                    return this.buttonFontColor;
                }

                @Nullable
                public final String getButtonLogoImgUrl() {
                    return this.buttonLogoImgUrl;
                }

                @Nullable
                public final String getButtonText() {
                    return this.buttonText;
                }

                @Nullable
                public final ButtonType getButtonType() {
                    return this.buttonType;
                }

                @Nullable
                public final String getChannelTitle() {
                    return this.channelTitle;
                }

                @Nullable
                public final List getChatList() {
                    return this.chatList;
                }

                @Nullable
                public final ContentDpType getContentDpType() {
                    return this.contentDpType;
                }

                public final long getCurrentPosition() {
                    return this.currentPosition;
                }

                @Nullable
                public final String getEffectImgUrl() {
                    return this.effectImgUrl;
                }

                @Nullable
                public final String getFileUpdateDate() {
                    return this.fileUpdateDate;
                }

                @Nullable
                public final ImageDpType getImageDpType() {
                    return this.imageDpType;
                }

                @Nullable
                public final ImageType getImageType() {
                    return this.imageType;
                }

                @Nullable
                public final List getImgList() {
                    return this.imgList;
                }

                @Nullable
                public final String getImgUrl() {
                    return this.imgUrl;
                }

                @Nullable
                public final String getLinkType() {
                    return this.linkType;
                }

                @Nullable
                public final String getLinkUrl() {
                    return this.linkUrl;
                }

                @Nullable
                public final String getLiveSeq() {
                    return this.liveSeq;
                }

                @Nullable
                public final Long getLiveStartDate() {
                    return this.liveStartDate;
                }

                @Nullable
                public final LiveStatusCode getLiveStatusCode() {
                    return this.liveStatusCode;
                }

                @Nullable
                public final String getLiveTitle() {
                    return this.liveTitle;
                }

                @Nullable
                public final String getLogoImgUrl() {
                    return this.logoImgUrl;
                }

                @Nullable
                public final LogoType getLogoType() {
                    return this.logoType;
                }

                @Nullable
                public final List getLyricsList() {
                    return this.lyricsList;
                }

                @Nullable
                public final String getMagazineBadgeImgUrl() {
                    return this.magazineBadgeImgUrl;
                }

                @Nullable
                public final String getPattColorType() {
                    return this.pattColorType;
                }

                @Nullable
                public final String getPattImgType() {
                    return this.pattImgType;
                }

                @Nullable
                public final String getPreviewMvid() {
                    return this.previewMvid;
                }

                @Nullable
                public final String getPreviewUrl() {
                    return this.previewUrl;
                }

                @Nullable
                public final String getScheme() {
                    return this.scheme;
                }

                @Nullable
                public final String getShapeImgUrl() {
                    return this.shapeImgUrl;
                }

                @Nullable
                public final String getSongName() {
                    return this.songName;
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
                public final String getTopicTitle() {
                    return this.topicTitle;
                }

                @Nullable
                public final TrendUiType getTrendUiType() {
                    return this.trendUiType;
                }

                @Nullable
                public final String getViewCountText() {
                    return this.viewCountText;
                }

                public final boolean isArtistType() {
                    return this.isArtistType;
                }

                public final void setAdultGrade(@Nullable String s) {
                    this.adultGrade = s;
                }

                public final void setArtistId(@Nullable String s) {
                    this.artistId = s;
                }

                public final void setArtistList(@Nullable List list0) {
                    this.artistList = list0;
                }

                public final void setArtistType(boolean z) {
                    this.isArtistType = z;
                }

                public final void setBadgeType(@Nullable BadgeType flexibleRes$BadgeType0) {
                    this.badgeType = flexibleRes$BadgeType0;
                }

                public final void setBgColor(@Nullable String s) {
                    this.bgColor = s;
                }

                public final void setBgImgUrl(@Nullable String s) {
                    this.bgImgUrl = s;
                }

                public final void setBgType(@Nullable String s) {
                    this.bgType = s;
                }

                public final void setBgVideoUrl(@Nullable String s) {
                    this.bgVideoUrl = s;
                }

                public final void setButtonBgColor(@Nullable String s) {
                    this.buttonBgColor = s;
                }

                public final void setButtonFontColor(@Nullable String s) {
                    this.buttonFontColor = s;
                }

                public final void setButtonLogoImgUrl(@Nullable String s) {
                    this.buttonLogoImgUrl = s;
                }

                public final void setButtonText(@Nullable String s) {
                    this.buttonText = s;
                }

                public final void setButtonType(@Nullable ButtonType flexibleRes$ButtonType0) {
                    this.buttonType = flexibleRes$ButtonType0;
                }

                public final void setChannelTitle(@Nullable String s) {
                    this.channelTitle = s;
                }

                public final void setChatList(@Nullable List list0) {
                    this.chatList = list0;
                }

                public final void setContentDpType(@Nullable ContentDpType flexibleRes$ContentDpType0) {
                    this.contentDpType = flexibleRes$ContentDpType0;
                }

                public final void setCurrentPosition(long v) {
                    this.currentPosition = v;
                }

                public final void setEffectImgUrl(@Nullable String s) {
                    this.effectImgUrl = s;
                }

                public final void setFileUpdateDate(@Nullable String s) {
                    this.fileUpdateDate = s;
                }

                public final void setImageDpType(@Nullable ImageDpType flexibleRes$ImageDpType0) {
                    this.imageDpType = flexibleRes$ImageDpType0;
                }

                public final void setImageType(@Nullable ImageType flexibleRes$ImageType0) {
                    this.imageType = flexibleRes$ImageType0;
                }

                public final void setImgList(@Nullable List list0) {
                    this.imgList = list0;
                }

                public final void setImgUrl(@Nullable String s) {
                    this.imgUrl = s;
                }

                public final void setLinkType(@Nullable String s) {
                    this.linkType = s;
                }

                public final void setLinkUrl(@Nullable String s) {
                    this.linkUrl = s;
                }

                public final void setLiveSeq(@Nullable String s) {
                    this.liveSeq = s;
                }

                public final void setLiveStartDate(@Nullable Long long0) {
                    this.liveStartDate = long0;
                }

                public final void setLiveStatusCode(@Nullable LiveStatusCode flexibleRes$LiveStatusCode0) {
                    this.liveStatusCode = flexibleRes$LiveStatusCode0;
                }

                public final void setLiveTitle(@Nullable String s) {
                    this.liveTitle = s;
                }

                public final void setLogoImgUrl(@Nullable String s) {
                    this.logoImgUrl = s;
                }

                public final void setLogoType(@Nullable LogoType flexibleRes$LogoType0) {
                    this.logoType = flexibleRes$LogoType0;
                }

                public final void setLyricsList(@Nullable List list0) {
                    this.lyricsList = list0;
                }

                public final void setMagazineBadgeImgUrl(@Nullable String s) {
                    this.magazineBadgeImgUrl = s;
                }

                public final void setPattColorType(@Nullable String s) {
                    this.pattColorType = s;
                }

                public final void setPattImgType(@Nullable String s) {
                    this.pattImgType = s;
                }

                public final void setPreviewMvid(@Nullable String s) {
                    this.previewMvid = s;
                }

                public final void setPreviewUrl(@Nullable String s) {
                    this.previewUrl = s;
                }

                public final void setScheme(@Nullable String s) {
                    this.scheme = s;
                }

                public final void setShapeImgUrl(@Nullable String s) {
                    this.shapeImgUrl = s;
                }

                public final void setSongName(@Nullable String s) {
                    this.songName = s;
                }

                public final void setSubTitle(@Nullable String s) {
                    this.subTitle = s;
                }

                public final void setTitle(@Nullable String s) {
                    this.title = s;
                }

                public final void setTopicTitle(@Nullable String s) {
                    this.topicTitle = s;
                }

                public final void setTrendUiType(@Nullable TrendUiType flexibleRes$TrendUiType0) {
                    this.trendUiType = flexibleRes$TrendUiType0;
                }

                public final void setViewCountText(@Nullable String s) {
                    this.viewCountText = s;
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000E\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$RESPONSE$Flexible$Header;", "Lcom/iloen/melon/net/v4x/common/HeaderBase;", "<init>", "()V", "offerSeq", "", "getOfferSeq", "()Ljava/lang/String;", "setOfferSeq", "(Ljava/lang/String;)V", "contsId", "getContsId", "setContsId", "contsTypeCode", "getContsTypeCode", "setContsTypeCode", "targetId", "getTargetId", "setTargetId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class Header extends HeaderBase {
                public static final int $stable = 8;
                @b("CONTSID")
                @Nullable
                private String contsId;
                @b("CONTSTYPECODE")
                @Nullable
                private String contsTypeCode;
                @b("OFFERSEQ")
                @Nullable
                private String offerSeq;
                @b("TARGETID")
                @Nullable
                private String targetId;

                @Nullable
                public final String getContsId() {
                    return this.contsId;
                }

                @Nullable
                public final String getContsTypeCode() {
                    return this.contsTypeCode;
                }

                @Nullable
                public final String getOfferSeq() {
                    return this.offerSeq;
                }

                @Nullable
                public final String getTargetId() {
                    return this.targetId;
                }

                public final void setContsId(@Nullable String s) {
                    this.contsId = s;
                }

                public final void setContsTypeCode(@Nullable String s) {
                    this.contsTypeCode = s;
                }

                public final void setOfferSeq(@Nullable String s) {
                    this.offerSeq = s;
                }

                public final void setTargetId(@Nullable String s) {
                    this.targetId = s;
                }
            }

            public static final int $stable = 8;
            @b("CONTENTS")
            @Nullable
            private List contents;
            @b("HEADER")
            @Nullable
            private Header header;
            @b("OFFERTYPE")
            @Nullable
            private OfferType offerType;
            @b("SLOTID")
            @Nullable
            private String slotId;
            @b("STATSELEMENTS")
            @Nullable
            private StatsElementsBase statsElements;
            @b("SUBCONTENTS")
            @Nullable
            private List subContents;

            @Nullable
            public final List getContents() {
                return this.contents;
            }

            @Nullable
            public final Header getHeader() {
                return this.header;
            }

            @Nullable
            public final OfferType getOfferType() {
                return this.offerType;
            }

            @Nullable
            public final String getSlotId() {
                return this.slotId;
            }

            @Nullable
            public final StatsElementsBase getStatsElements() {
                return this.statsElements;
            }

            @Nullable
            public final List getSubContents() {
                return this.subContents;
            }

            public final void setContents(@Nullable List list0) {
                this.contents = list0;
            }

            public final void setHeader(@Nullable Header flexibleRes$RESPONSE$Flexible$Header0) {
                this.header = flexibleRes$RESPONSE$Flexible$Header0;
            }

            public final void setOfferType(@Nullable OfferType flexibleRes$OfferType0) {
                this.offerType = flexibleRes$OfferType0;
            }

            public final void setSlotId(@Nullable String s) {
                this.slotId = s;
            }

            public final void setStatsElements(@Nullable StatsElementsBase statsElementsBase0) {
                this.statsElements = statsElementsBase0;
            }

            public final void setSubContents(@Nullable List list0) {
                this.subContents = list0;
            }

            @Override
            @NotNull
            public String toString() {
                String s = ToStringUtil.toStringFields(this);
                q.f(s, "toStringFields(...)");
                return s;
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Companion Companion = null;
        @b("FLEXIBLELIST")
        @Nullable
        private List flexibleList;
        private static final long serialVersionUID = 0xFC95ED93215467F5L;

        static {
            RESPONSE.Companion = new com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Companion(null);
            RESPONSE.$stable = 8;
        }

        @Nullable
        public final List getFlexibleList() {
            return this.flexibleList;
        }

        public final void setFlexibleList(@Nullable List list0) {
            this.flexibleList = list0;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        @NotNull
        public String toString() {
            String s = ToStringUtil.toStringFields(this);
            q.f(s, "toStringFields(...)");
            return s;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/net/v5x/response/FlexibleRes$TrendUiType;", "", "<init>", "(Ljava/lang/String;I)V", "Song", "Text_LYRICS", "Text_MAGAZINE", "VIDEO_VERTICAL", "VIDEO_HORIZONTAL", "MUSIC_WAVE_CHANNEL_ARTIST", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum TrendUiType {
        @b("S01")
        Song,
        @b("T01")
        Text_LYRICS,
        @b("T02")
        Text_MAGAZINE,
        @b("V01")
        VIDEO_VERTICAL,
        @b("V02")
        VIDEO_HORIZONTAL,
        @b("M01")
        MUSIC_WAVE_CHANNEL_ARTIST;

        private static final a $ENTRIES;
        private static final TrendUiType[] $VALUES;

        private static final TrendUiType[] $values() [...] // Inlined contents

        static {
            TrendUiType.$VALUES = arr_flexibleRes$TrendUiType;
            q.g(arr_flexibleRes$TrendUiType, "entries");
            TrendUiType.$ENTRIES = new pe.b(arr_flexibleRes$TrendUiType);
        }

        @NotNull
        public static a getEntries() {
            return TrendUiType.$ENTRIES;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @b("response")
    @Nullable
    private RESPONSE response;
    private static final long serialVersionUID = 4404124881743063800L;

    static {
        FlexibleRes.Companion = new Companion(null);
        FlexibleRes.$stable = 8;
    }

    @Override  // com.iloen.melon.net.HttpResponse
    @NotNull
    public String getMenuId() {
        RESPONSE flexibleRes$RESPONSE0 = this.response;
        if(flexibleRes$RESPONSE0 != null) {
            return flexibleRes$RESPONSE0.menuId == null ? "" : flexibleRes$RESPONSE0.menuId;
        }
        return "";
    }

    @Nullable
    public final RESPONSE getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable RESPONSE flexibleRes$RESPONSE0) {
        this.response = flexibleRes$RESPONSE0;
    }
}

