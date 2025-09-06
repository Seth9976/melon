package com.iloen.melon.net.v6x.response;

import S7.b;
import com.google.gson.t;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pe.a;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000F2\u00020\u0001:\u0003\u000E\u000F\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForuTabRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/ForuTabRes$Response;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/ForuTabRes$Response;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/ForuTabRes$Response;)V", "menuId", "", "getMenuId", "()Ljava/lang/String;", "Response", "Companion", "ForuSlotType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ForuTabRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForuTabRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForuTabRes$ForuSlotType;", "", "<init>", "(Ljava/lang/String;I)V", "DJ_MALRANG", "USER_TASTE", "QUICK_PICK", "PERSONAL_MIX", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum ForuSlotType {
        @b("SIMPLEDJ")
        DJ_MALRANG,
        @b("TASTESET")
        USER_TASTE,
        @b("QUICKPICK")
        QUICK_PICK,
        @b("PERSONALMIX")
        PERSONAL_MIX;

        private static final a $ENTRIES;
        private static final ForuSlotType[] $VALUES;

        private static final ForuSlotType[] $values() [...] // Inlined contents

        static {
            ForuSlotType.$VALUES = arr_foruTabRes$ForuSlotType;
            q.g(arr_foruTabRes$ForuSlotType, "entries");
            ForuSlotType.$ENTRIES = new pe.b(arr_foruTabRes$ForuSlotType);
        }

        @NotNull
        public static a getEntries() {
            return ForuSlotType.$ENTRIES;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0006\r\u000E\u000F\u0010\u0011\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000B\u001A\u00020\fH\u0016R(\u0010\u0004\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForuTabRes$Response;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "list", "", "Lcom/iloen/melon/net/v6x/response/ForuTabRes$Response$ForuTabCardBase;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "toString", "", "ForuTabCardBase", "DjMalrang", "QuickPick", "PersonalMix", "UserTaste", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response extends ResponseBase {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForuTabRes$Response$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.net.v6x.response.ForuTabRes.Response.Companion {
            private com.iloen.melon.net.v6x.response.ForuTabRes.Response.Companion() {
            }

            public com.iloen.melon.net.v6x.response.ForuTabRes.Response.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000ER\u0018\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0018\u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R \u0010\u0005\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0007\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0010R\u0018\u0010\b\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0010R\u0018\u0010\n\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0010R \u0010\u000B\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForuTabRes$Response$DjMalrang;", "", "contsTypeCode", "", "upperTitle", "insideImgUrls", "", "preText", "upperText1", "upperBgColor", "upperText2", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "getContsTypeCode", "()Ljava/lang/String;", "getUpperTitle", "getInsideImgUrls", "()Ljava/util/List;", "getPreText", "getUpperText1", "getUpperBgColor", "getUpperText2", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class DjMalrang {
            public static final int $stable = 8;
            @b("CONTSTYPECODE")
            @Nullable
            private final String contsTypeCode;
            @b("INSIDEIMGURLS")
            @Nullable
            private final List insideImgUrls;
            @b("PRETEXT")
            @Nullable
            private final String preText;
            @b("STATSELEMENTS")
            @Nullable
            private StatsElementsBase statsElements;
            @b("UPPERBGCOLOR")
            @Nullable
            private final String upperBgColor;
            @b("UPPERTEXT1")
            @Nullable
            private final String upperText1;
            @b("UPPERTEXT2")
            @Nullable
            private final String upperText2;
            @b("UPPERTITLE")
            @Nullable
            private final String upperTitle;

            public DjMalrang() {
                this(null, null, null, null, null, null, null, null, 0xFF, null);
            }

            public DjMalrang(@Nullable String s, @Nullable String s1, @Nullable List list0, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable StatsElementsBase statsElementsBase0) {
                this.contsTypeCode = s;
                this.upperTitle = s1;
                this.insideImgUrls = list0;
                this.preText = s2;
                this.upperText1 = s3;
                this.upperBgColor = s4;
                this.upperText2 = s5;
                this.statsElements = statsElementsBase0;
            }

            public DjMalrang(String s, String s1, List list0, String s2, String s3, String s4, String s5, StatsElementsBase statsElementsBase0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
                if((v & 1) != 0) {
                    s = null;
                }
                if((v & 2) != 0) {
                    s1 = null;
                }
                if((v & 4) != 0) {
                    list0 = null;
                }
                if((v & 8) != 0) {
                    s2 = null;
                }
                if((v & 16) != 0) {
                    s3 = null;
                }
                if((v & 0x20) != 0) {
                    s4 = null;
                }
                if((v & 0x40) != 0) {
                    s5 = null;
                }
                this(s, s1, list0, s2, s3, s4, s5, ((v & 0x80) == 0 ? statsElementsBase0 : null));
            }

            @Nullable
            public final String getContsTypeCode() {
                return this.contsTypeCode;
            }

            @Nullable
            public final List getInsideImgUrls() {
                return this.insideImgUrls;
            }

            @Nullable
            public final String getPreText() {
                return this.preText;
            }

            @Nullable
            public final StatsElementsBase getStatsElements() {
                return this.statsElements;
            }

            @Nullable
            public final String getUpperBgColor() {
                return this.upperBgColor;
            }

            @Nullable
            public final String getUpperText1() {
                return this.upperText1;
            }

            @Nullable
            public final String getUpperText2() {
                return this.upperText2;
            }

            @Nullable
            public final String getUpperTitle() {
                return this.upperTitle;
            }

            public final void setStatsElements(@Nullable StatsElementsBase statsElementsBase0) {
                this.statsElements = statsElementsBase0;
            }
        }

        @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0017\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR\u001C\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\n\u001A\u0004\b\u000B\u0010\fR\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\r\u001A\u0004\b\u000E\u0010\u000FR$\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0007\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForuTabRes$Response$ForuTabCardBase;", "", "Lcom/iloen/melon/net/v6x/response/ForuTabRes$ForuSlotType;", "type", "Lcom/google/gson/t;", "data", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElements", "<init>", "(Lcom/iloen/melon/net/v6x/response/ForuTabRes$ForuSlotType;Lcom/google/gson/t;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "Lcom/iloen/melon/net/v6x/response/ForuTabRes$ForuSlotType;", "getType", "()Lcom/iloen/melon/net/v6x/response/ForuTabRes$ForuSlotType;", "Lcom/google/gson/t;", "getData", "()Lcom/google/gson/t;", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static class ForuTabCardBase {
            public static final int $stable = 8;
            @b("DATA")
            @Nullable
            private final t data;
            @b("STATSELEMENTS")
            @Nullable
            private StatsElementsBase statsElements;
            @b("TYPE")
            @Nullable
            private final ForuSlotType type;

            public ForuTabCardBase() {
                this(null, null, null, 7, null);
            }

            public ForuTabCardBase(@Nullable ForuSlotType foruTabRes$ForuSlotType0, @Nullable t t0, @Nullable StatsElementsBase statsElementsBase0) {
                this.type = foruTabRes$ForuSlotType0;
                this.data = t0;
                this.statsElements = statsElementsBase0;
            }

            public ForuTabCardBase(ForuSlotType foruTabRes$ForuSlotType0, t t0, StatsElementsBase statsElementsBase0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
                if((v & 1) != 0) {
                    foruTabRes$ForuSlotType0 = null;
                }
                if((v & 2) != 0) {
                    t0 = null;
                }
                if((v & 4) != 0) {
                    statsElementsBase0 = null;
                }
                this(foruTabRes$ForuSlotType0, t0, statsElementsBase0);
            }

            @Nullable
            public final t getData() {
                return this.data;
            }

            @Nullable
            public final StatsElementsBase getStatsElements() {
                return this.statsElements;
            }

            @Nullable
            public final ForuSlotType getType() {
                return this.type;
            }

            public final void setStatsElements(@Nullable StatsElementsBase statsElementsBase0) {
                this.statsElements = statsElementsBase0;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001F\b\u0007\u0018\u00002\u00020\u0001:\u0001:B\u00F9\u0001\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001A\u0004\u0018\u00010\u0003\u0012\u000E\u0010\u0011\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012\u0012\b\u0010\u0013\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001A\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0016\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0012\u0012\b\u0010\u0018\u001A\u0004\u0018\u00010\u0003\u0012\u000E\u0010\u0019\u001A\n\u0012\u0004\u0012\u00020\u001A\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001C\u00A2\u0006\u0004\b\u001D\u0010\u001ER\u0018\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u0018\u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b!\u0010 R\u0018\u0010\u0005\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\"\u0010 R\u0018\u0010\u0006\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b#\u0010 R\u0018\u0010\u0007\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b$\u0010 R\u0018\u0010\b\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b%\u0010 R\u0018\u0010\t\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b&\u0010 R\u0018\u0010\n\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\'\u0010 R\u0018\u0010\u000B\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b(\u0010 R\u0018\u0010\f\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b)\u0010 R\u0018\u0010\r\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b*\u0010 R\u0018\u0010\u000E\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b+\u0010 R\u0018\u0010\u000F\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b,\u0010 R\u0018\u0010\u0010\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b-\u0010 R\u001E\u0010\u0011\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00128\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b.\u0010/R\u0018\u0010\u0013\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b0\u0010 R\u0018\u0010\u0014\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b1\u0010 R\u0018\u0010\u0015\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b2\u0010 R \u0010\u0016\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u00128\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b3\u0010/R\u0018\u0010\u0018\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b4\u0010 R\u001E\u0010\u0019\u001A\n\u0012\u0004\u0012\u00020\u001A\u0018\u00010\u00128\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b5\u0010/R \u0010\u001B\u001A\u0004\u0018\u00010\u001C8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b6\u00107\"\u0004\b8\u00109\u00A8\u0006;"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForuTabRes$Response$PersonalMix;", "", "contsId", "", "seedContsId", "upperText", "mainTitle", "mainReplace", "contsTypeCode", "detailTitle", "detailText", "detailImgText1", "detailImgText2", "detailTextShadowColor", "detailReplace", "detailUpdateDate", "detailUpdateText", "detailImgUrls", "", "detailSubImgUrl", "detailMaker", "detailMakerImgUrl", "previewList", "Lcom/iloen/melon/net/v6x/response/ForuTabRes$Response$PersonalMix$PreviewItem;", "songIds", "tags", "Lcom/iloen/melon/net/v6x/response/ForUMixInfoBase$TAGS;", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "getContsId", "()Ljava/lang/String;", "getSeedContsId", "getUpperText", "getMainTitle", "getMainReplace", "getContsTypeCode", "getDetailTitle", "getDetailText", "getDetailImgText1", "getDetailImgText2", "getDetailTextShadowColor", "getDetailReplace", "getDetailUpdateDate", "getDetailUpdateText", "getDetailImgUrls", "()Ljava/util/List;", "getDetailSubImgUrl", "getDetailMaker", "getDetailMakerImgUrl", "getPreviewList", "getSongIds", "getTags", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "PreviewItem", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class PersonalMix {
            @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B_\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000ER\u0018\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0018\u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0010R\u0018\u0010\b\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0010R\u0018\u0010\n\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0010R\u0016\u0010\u000B\u001A\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForuTabRes$Response$PersonalMix$PreviewItem;", "", "songId", "", "songName", "albumId", "albumName", "albumImg", "artistId", "artistName", "artistImage", "isTitleSong", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getSongId", "()Ljava/lang/String;", "getSongName", "getAlbumId", "getAlbumName", "getAlbumImg", "getArtistId", "getArtistName", "getArtistImage", "()Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class PreviewItem {
                public static final int $stable;
                @b("ALBUMID")
                @Nullable
                private final String albumId;
                @b("ALBUMIMG")
                @Nullable
                private final String albumImg;
                @b("ALBUMNAME")
                @Nullable
                private final String albumName;
                @b("ARTISTID")
                @Nullable
                private final String artistId;
                @b("ARTISTIMAGE")
                @Nullable
                private final String artistImage;
                @b("ARTISTNAME")
                @Nullable
                private final String artistName;
                @b("ISTITLESONG")
                private final boolean isTitleSong;
                @b("SONGID")
                @Nullable
                private final String songId;
                @b("SONGNAME")
                @Nullable
                private final String songName;

                public PreviewItem(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, boolean z) {
                    this.songId = s;
                    this.songName = s1;
                    this.albumId = s2;
                    this.albumName = s3;
                    this.albumImg = s4;
                    this.artistId = s5;
                    this.artistName = s6;
                    this.artistImage = s7;
                    this.isTitleSong = z;
                }

                @Nullable
                public final String getAlbumId() {
                    return this.albumId;
                }

                @Nullable
                public final String getAlbumImg() {
                    return this.albumImg;
                }

                @Nullable
                public final String getAlbumName() {
                    return this.albumName;
                }

                @Nullable
                public final String getArtistId() {
                    return this.artistId;
                }

                @Nullable
                public final String getArtistImage() {
                    return this.artistImage;
                }

                @Nullable
                public final String getArtistName() {
                    return this.artistName;
                }

                @Nullable
                public final String getSongId() {
                    return this.songId;
                }

                @Nullable
                public final String getSongName() {
                    return this.songName;
                }

                public final boolean isTitleSong() {
                    return this.isTitleSong;
                }
            }

            public static final int $stable = 8;
            @b("CONTSID")
            @Nullable
            private final String contsId;
            @b("CONTSTYPECODE")
            @Nullable
            private final String contsTypeCode;
            @b("DETAILIMGTEXT1")
            @Nullable
            private final String detailImgText1;
            @b("DETAILIMGTEXT2")
            @Nullable
            private final String detailImgText2;
            @b("DETAILIMGURLS")
            @Nullable
            private final List detailImgUrls;
            @b("DETAILMAKER")
            @Nullable
            private final String detailMaker;
            @b("DETAILMAKERIMGURL")
            @Nullable
            private final String detailMakerImgUrl;
            @b("DETAILREPLACE")
            @Nullable
            private final String detailReplace;
            @b("DETAILSUBIMGURL")
            @Nullable
            private final String detailSubImgUrl;
            @b("DETAILTEXT")
            @Nullable
            private final String detailText;
            @b("DETAILTEXTSHADOWCOLOR")
            @Nullable
            private final String detailTextShadowColor;
            @b("DETAILTITLE")
            @Nullable
            private final String detailTitle;
            @b("DETAILUPDATEDATE")
            @Nullable
            private final String detailUpdateDate;
            @b("DETAILUPDATETEXT")
            @Nullable
            private final String detailUpdateText;
            @b("MAINREPLACE")
            @Nullable
            private final String mainReplace;
            @b("MAINTITLE")
            @Nullable
            private final String mainTitle;
            @b("PREVIEWLIST")
            @Nullable
            private final List previewList;
            @b("SEEDCONTSID")
            @Nullable
            private final String seedContsId;
            @b("SONGIDS")
            @Nullable
            private final String songIds;
            @b("STATSELEMENTS")
            @Nullable
            private StatsElementsBase statsElements;
            @b("TAGS")
            @Nullable
            private final List tags;
            @b("UPPERTEXT")
            @Nullable
            private final String upperText;

            public PersonalMix(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10, @Nullable String s11, @Nullable String s12, @Nullable String s13, @Nullable List list0, @Nullable String s14, @Nullable String s15, @Nullable String s16, @Nullable List list1, @Nullable String s17, @Nullable List list2, @Nullable StatsElementsBase statsElementsBase0) {
                this.contsId = s;
                this.seedContsId = s1;
                this.upperText = s2;
                this.mainTitle = s3;
                this.mainReplace = s4;
                this.contsTypeCode = s5;
                this.detailTitle = s6;
                this.detailText = s7;
                this.detailImgText1 = s8;
                this.detailImgText2 = s9;
                this.detailTextShadowColor = s10;
                this.detailReplace = s11;
                this.detailUpdateDate = s12;
                this.detailUpdateText = s13;
                this.detailImgUrls = list0;
                this.detailSubImgUrl = s14;
                this.detailMaker = s15;
                this.detailMakerImgUrl = s16;
                this.previewList = list1;
                this.songIds = s17;
                this.tags = list2;
                this.statsElements = statsElementsBase0;
            }

            public PersonalMix(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, List list0, String s14, String s15, String s16, List list1, String s17, List list2, StatsElementsBase statsElementsBase0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
                this(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, list0, s14, s15, s16, list1, s17, list2, ((v & 0x200000) == 0 ? statsElementsBase0 : null));
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
            public final String getDetailImgText1() {
                return this.detailImgText1;
            }

            @Nullable
            public final String getDetailImgText2() {
                return this.detailImgText2;
            }

            @Nullable
            public final List getDetailImgUrls() {
                return this.detailImgUrls;
            }

            @Nullable
            public final String getDetailMaker() {
                return this.detailMaker;
            }

            @Nullable
            public final String getDetailMakerImgUrl() {
                return this.detailMakerImgUrl;
            }

            @Nullable
            public final String getDetailReplace() {
                return this.detailReplace;
            }

            @Nullable
            public final String getDetailSubImgUrl() {
                return this.detailSubImgUrl;
            }

            @Nullable
            public final String getDetailText() {
                return this.detailText;
            }

            @Nullable
            public final String getDetailTextShadowColor() {
                return this.detailTextShadowColor;
            }

            @Nullable
            public final String getDetailTitle() {
                return this.detailTitle;
            }

            @Nullable
            public final String getDetailUpdateDate() {
                return this.detailUpdateDate;
            }

            @Nullable
            public final String getDetailUpdateText() {
                return this.detailUpdateText;
            }

            @Nullable
            public final String getMainReplace() {
                return this.mainReplace;
            }

            @Nullable
            public final String getMainTitle() {
                return this.mainTitle;
            }

            @Nullable
            public final List getPreviewList() {
                return this.previewList;
            }

            @Nullable
            public final String getSeedContsId() {
                return this.seedContsId;
            }

            @Nullable
            public final String getSongIds() {
                return this.songIds;
            }

            @Nullable
            public final StatsElementsBase getStatsElements() {
                return this.statsElements;
            }

            @Nullable
            public final List getTags() {
                return this.tags;
            }

            @Nullable
            public final String getUpperText() {
                return this.upperText;
            }

            public final void setStatsElements(@Nullable StatsElementsBase statsElementsBase0) {
                this.statsElements = statsElementsBase0;
            }
        }

        @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000FB\'\u0012\u0012\b\u0002\u0010\u0002\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR \u0010\u0002\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR \u0010\u0005\u001A\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForuTabRes$Response$QuickPick;", "", "list", "", "Lcom/iloen/melon/net/v6x/response/ForuTabRes$Response$QuickPick$QuickPickItem;", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "<init>", "(Ljava/util/List;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "getList", "()Ljava/util/List;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "QuickPickItem", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class QuickPick {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000F\b\u0007\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0018\u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0018\u0010\u0006\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\fR\u0018\u0010\u0007\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForuTabRes$Response$QuickPick$QuickPickItem;", "Lcom/melon/net/res/common/LinkInfoBase;", "upperText1", "", "contsName", "upperText2", "contsTypeCode", "contsIds", "imgUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUpperText1", "()Ljava/lang/String;", "getContsName", "getUpperText2", "getContsTypeCode", "getContsIds", "getImgUrl", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class QuickPickItem extends LinkInfoBase {
                public static final int $stable = 8;
                @b("CONTSIDS")
                @Nullable
                private final String contsIds;
                @b("CONTSNAME")
                @Nullable
                private final String contsName;
                @b("CONTSTYPECODE")
                @Nullable
                private final String contsTypeCode;
                @b("IMGURL")
                @Nullable
                private final String imgUrl;
                @b("UPPERTEXT1")
                @Nullable
                private final String upperText1;
                @b("UPPERTEXT2")
                @Nullable
                private final String upperText2;

                public QuickPickItem() {
                    this(null, null, null, null, null, null, 0x3F, null);
                }

                public QuickPickItem(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5) {
                    this.upperText1 = s;
                    this.contsName = s1;
                    this.upperText2 = s2;
                    this.contsTypeCode = s3;
                    this.contsIds = s4;
                    this.imgUrl = s5;
                }

                public QuickPickItem(String s, String s1, String s2, String s3, String s4, String s5, int v, DefaultConstructorMarker defaultConstructorMarker0) {
                    if((v & 1) != 0) {
                        s = null;
                    }
                    if((v & 2) != 0) {
                        s1 = null;
                    }
                    if((v & 4) != 0) {
                        s2 = null;
                    }
                    if((v & 8) != 0) {
                        s3 = null;
                    }
                    if((v & 16) != 0) {
                        s4 = null;
                    }
                    this(s, s1, s2, s3, s4, ((v & 0x20) == 0 ? s5 : null));
                }

                @Nullable
                public final String getContsIds() {
                    return this.contsIds;
                }

                @Nullable
                public final String getContsName() {
                    return this.contsName;
                }

                @Nullable
                public final String getContsTypeCode() {
                    return this.contsTypeCode;
                }

                @Nullable
                public final String getImgUrl() {
                    return this.imgUrl;
                }

                @Nullable
                public final String getUpperText1() {
                    return this.upperText1;
                }

                @Nullable
                public final String getUpperText2() {
                    return this.upperText2;
                }
            }

            public static final int $stable = 8;
            @b("LIST")
            @Nullable
            private final List list;
            @b("STATSELEMENTS")
            @Nullable
            private StatsElementsBase statsElements;

            public QuickPick() {
                this(null, null, 3, null);
            }

            public QuickPick(@Nullable List list0, @Nullable StatsElementsBase statsElementsBase0) {
                this.list = list0;
                this.statsElements = statsElementsBase0;
            }

            public QuickPick(List list0, StatsElementsBase statsElementsBase0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
                if((v & 1) != 0) {
                    list0 = null;
                }
                if((v & 2) != 0) {
                    statsElementsBase0 = null;
                }
                this(list0, statsElementsBase0);
            }

            @Nullable
            public final List getList() {
                return this.list;
            }

            @Nullable
            public final StatsElementsBase getStatsElements() {
                return this.statsElements;
            }

            public final void setStatsElements(@Nullable StatsElementsBase statsElementsBase0) {
                this.statsElements = statsElementsBase0;
            }
        }

        @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR \u0010\u0004\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR \u0010\u0006\u001A\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForuTabRes$Response$UserTaste;", "", "schemeUrl", "", "imgUrls", "", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "getSchemeUrl", "()Ljava/lang/String;", "getImgUrls", "()Ljava/util/List;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class UserTaste {
            public static final int $stable = 8;
            @b("IMGURLS")
            @Nullable
            private final List imgUrls;
            @b("SCHEMEURL")
            @Nullable
            private final String schemeUrl;
            @b("STATSELEMENTS")
            @Nullable
            private StatsElementsBase statsElements;

            public UserTaste() {
                this(null, null, null, 7, null);
            }

            public UserTaste(@Nullable String s, @Nullable List list0, @Nullable StatsElementsBase statsElementsBase0) {
                this.schemeUrl = s;
                this.imgUrls = list0;
                this.statsElements = statsElementsBase0;
            }

            public UserTaste(String s, List list0, StatsElementsBase statsElementsBase0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
                if((v & 1) != 0) {
                    s = null;
                }
                if((v & 2) != 0) {
                    list0 = null;
                }
                if((v & 4) != 0) {
                    statsElementsBase0 = null;
                }
                this(s, list0, statsElementsBase0);
            }

            @Nullable
            public final List getImgUrls() {
                return this.imgUrls;
            }

            @Nullable
            public final String getSchemeUrl() {
                return this.schemeUrl;
            }

            @Nullable
            public final StatsElementsBase getStatsElements() {
                return this.statsElements;
            }

            public final void setStatsElements(@Nullable StatsElementsBase statsElementsBase0) {
                this.statsElements = statsElementsBase0;
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.net.v6x.response.ForuTabRes.Response.Companion Companion = null;
        @b("LIST")
        @Nullable
        private List list;
        private static final long serialVersionUID = 0xB6C7D328E5DD1151L;

        static {
            Response.Companion = new com.iloen.melon.net.v6x.response.ForuTabRes.Response.Companion(null);
            Response.$stable = 8;
        }

        @Nullable
        public final List getList() {
            return this.list;
        }

        public final void setList(@Nullable List list0) {
            this.list = list0;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        @NotNull
        public String toString() {
            String s = ToStringUtil.toStringFields(this);
            q.f(s, "toStringFields(...)");
            return s;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @b("response")
    @Nullable
    private Response response;
    private static final long serialVersionUID = 0x3C15A20E35AB218BL;

    static {
        ForuTabRes.Companion = new Companion(null);
        ForuTabRes.$stable = 8;
    }

    @Override  // com.iloen.melon.net.HttpResponse
    @NotNull
    public String getMenuId() {
        String s = this.response == null ? null : this.response.menuId;
        return s == null ? "" : s;
    }

    @Nullable
    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable Response foruTabRes$Response0) {
        this.response = foruTabRes$Response0;
    }
}

