package com.iloen.melon.utils.tab;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/iloen/melon/utils/tab/MainTabConstants;", "", "<init>", "()V", "MenuCode", "StrategyIconType", "StrategyLogoType", "ThemeFullBgType", "MainBottomTabIconVisibleMode", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MainTabConstants {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/utils/tab/MainTabConstants$MainBottomTabIconVisibleMode;", "", "Companion", "ALWAYS", "TEMPORARY", "NONE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum MainBottomTabIconVisibleMode {
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/utils/tab/MainTabConstants$MainBottomTabIconVisibleMode$Companion;", "", "", "visibleMode", "", "getRepeatCount", "(Ljava/lang/String;)I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            public final int getRepeatCount(@NotNull String s) {
                q.g(s, "visibleMode");
                for(Object object0: MainBottomTabIconVisibleMode.getEntries()) {
                    if(q.b(((MainBottomTabIconVisibleMode)object0).name(), s)) {
                        return ((MainBottomTabIconVisibleMode)object0) == null ? 0 : ((MainBottomTabIconVisibleMode)object0).a;
                    }
                    if(false) {
                        break;
                    }
                }
                return 0;
            }
        }

        ALWAYS(0x7FFFFFFF),
        TEMPORARY(1),
        NONE(0);

        @NotNull
        public static final Companion Companion;
        public final int a;
        public static final MainBottomTabIconVisibleMode[] b;
        public static final b c;

        static {
            MainBottomTabIconVisibleMode.b = arr_mainTabConstants$MainBottomTabIconVisibleMode;
            q.g(arr_mainTabConstants$MainBottomTabIconVisibleMode, "entries");
            MainBottomTabIconVisibleMode.c = new b(arr_mainTabConstants$MainBottomTabIconVisibleMode);
            MainBottomTabIconVisibleMode.Companion = new Companion(null);
        }

        public MainBottomTabIconVisibleMode(int v1) {
            this.a = v1;
        }

        @NotNull
        public static a getEntries() {
            return MainBottomTabIconVisibleMode.c;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\bH\b\u00C7\u0002\u0018\u00002\u00020\u0001R\"\u0010\t\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001A\u0004\b\u000B\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u000E\u0010\u0004\u001A\u0004\b\u000F\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0015\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001A\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0019\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001A\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001D\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u001A\u0010\u0004\u001A\u0004\b\u001B\u0010\u0006\"\u0004\b\u001C\u0010\bR\"\u0010!\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u001E\u0010\u0004\u001A\u0004\b\u001F\u0010\u0006\"\u0004\b \u0010\bR\"\u0010%\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\"\u0010\u0004\u001A\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010)\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b&\u0010\u0004\u001A\u0004\b\'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010-\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b*\u0010\u0004\u001A\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u00101\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b.\u0010\u0004\u001A\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\"\u00105\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b2\u0010\u0004\u001A\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\"\u00109\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b6\u0010\u0004\u001A\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\"\u0010=\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b:\u0010\u0004\u001A\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\"\u0010A\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b>\u0010\u0004\u001A\u0004\b?\u0010\u0006\"\u0004\b@\u0010\bR\"\u0010E\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bB\u0010\u0004\u001A\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\"\u0010I\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bF\u0010\u0004\u001A\u0004\bG\u0010\u0006\"\u0004\bH\u0010\b\u00A8\u0006J"}, d2 = {"Lcom/iloen/melon/utils/tab/MainTabConstants$MenuCode;", "", "", "a", "Ljava/lang/String;", "getOFFERING", "()Ljava/lang/String;", "setOFFERING", "(Ljava/lang/String;)V", "OFFERING", "b", "getMUSIC", "setMUSIC", "MUSIC", "c", "getSTATION", "setSTATION", "STATION", "d", "getSERACH", "setSERACH", "SERACH", "e", "getLIBRARY", "setLIBRARY", "LIBRARY", "f", "getMENU", "setMENU", "MENU", "g", "getFOR_U", "setFOR_U", "FOR_U", "h", "getMY", "setMY", "MY", "i", "getFEED", "setFEED", "FEED", "j", "getCONCERT", "setCONCERT", "CONCERT", "k", "getMELON_TV", "setMELON_TV", "MELON_TV", "l", "getDJ", "setDJ", "DJ", "m", "getCHART", "setCHART", "CHART", "n", "getKIDS", "setKIDS", "KIDS", "o", "getJUST_MUSIC", "setJUST_MUSIC", "JUST_MUSIC", "p", "getHIFI", "setHIFI", "HIFI", "q", "getMAGAZINE", "setMAGAZINE", "MAGAZINE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MenuCode {
        public static final int $stable = 8;
        @NotNull
        public static final MenuCode INSTANCE = null;
        public static String a = "WA";
        public static String b = "1000002436";
        public static String c = "1000002394";
        public static String d = "1000002471";
        public static String e = "1000002392";
        public static String f = "1000003080";
        public static String g = "1000003238";
        public static String h = "1000000013";
        public static String i = "1000000010";
        public static String j = "1000000012";
        public static String k = "1000002009";
        public static String l = "1000002010";
        public static String m = "1000002011";
        public static String n = "1000002012";
        public static String o = "1000002013";
        public static String p = "1000002014";
        public static String q = "1000002015";

        static {
            MenuCode.INSTANCE = new MenuCode();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getCHART() {
            return "1000002011";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getCONCERT() {
            return "1000000012";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getDJ() {
            return "1000002010";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getFEED() {
            return "1000000010";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getFOR_U() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        @NotNull
        public final String getHIFI() {
            return "1000002014";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getJUST_MUSIC() {
            return "1000002013";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getKIDS() {
            return "1000002012";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getLIBRARY() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        @NotNull
        public final String getMAGAZINE() {
            return "1000002015";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getMELON_TV() {
            return "1000002009";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getMENU() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        @NotNull
        public final String getMUSIC() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        @NotNull
        public final String getMY() {
            return "1000000013";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getOFFERING() {
            return "WA";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getSERACH() [...] // 潜在的解密器

        // 去混淆评级： 低(20)
        @NotNull
        public final String getSTATION() [...] // 潜在的解密器

        public final void setCHART(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.m = s;
        }

        public final void setCONCERT(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.j = s;
        }

        public final void setDJ(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.l = s;
        }

        public final void setFEED(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.i = s;
        }

        public final void setFOR_U(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.g = s;
        }

        public final void setHIFI(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.p = s;
        }

        public final void setJUST_MUSIC(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.o = s;
        }

        public final void setKIDS(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.n = s;
        }

        public final void setLIBRARY(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.e = s;
        }

        public final void setMAGAZINE(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.q = s;
        }

        public final void setMELON_TV(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.k = s;
        }

        public final void setMENU(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.f = s;
        }

        public final void setMUSIC(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.b = s;
        }

        public final void setMY(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.h = s;
        }

        public final void setOFFERING(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.a = s;
        }

        public final void setSERACH(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.d = s;
        }

        public final void setSTATION(@NotNull String s) {
            q.g(s, "<set-?>");
            MenuCode.c = s;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/utils/tab/MainTabConstants$StrategyIconType;", "", "Companion", "NONE", "PLAY", "AD", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum StrategyIconType {
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/utils/tab/MainTabConstants$StrategyIconType$Companion;", "", "", "contsTypeCode", "Lcom/iloen/melon/utils/tab/MainTabConstants$StrategyIconType;", "getIconType", "(Ljava/lang/String;)Lcom/iloen/melon/utils/tab/MainTabConstants$StrategyIconType;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.utils.tab.MainTabConstants.StrategyIconType.Companion {
            public com.iloen.melon.utils.tab.MainTabConstants.StrategyIconType.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            // 去混淆评级： 中等(75)
            @NotNull
            public final StrategyIconType getIconType(@NotNull String s) {
                q.g(s, "contsTypeCode");
                return s.equals("N10002") || s.equals("N10001") || s.equals("N10003") || s.equals("N10009") || s.equals("N10082") ? StrategyIconType.PLAY : StrategyIconType.NONE;
            }
        }

        NONE,
        PLAY,
        AD;

        @NotNull
        public static final com.iloen.melon.utils.tab.MainTabConstants.StrategyIconType.Companion Companion;
        public static final StrategyIconType[] a;
        public static final b b;

        static {
            StrategyIconType.a = arr_mainTabConstants$StrategyIconType;
            q.g(arr_mainTabConstants$StrategyIconType, "entries");
            StrategyIconType.b = new b(arr_mainTabConstants$StrategyIconType);
            StrategyIconType.Companion = new com.iloen.melon.utils.tab.MainTabConstants.StrategyIconType.Companion(null);
        }

        @NotNull
        public static a getEntries() {
            return StrategyIconType.b;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/utils/tab/MainTabConstants$StrategyLogoType;", "", "T", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum StrategyLogoType {
        T,
        I;

        public static final StrategyLogoType[] a;
        public static final b b;

        static {
            StrategyLogoType.a = arr_mainTabConstants$StrategyLogoType;
            q.g(arr_mainTabConstants$StrategyLogoType, "entries");
            StrategyLogoType.b = new b(arr_mainTabConstants$StrategyLogoType);
        }

        @NotNull
        public static a getEntries() {
            return StrategyLogoType.b;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/utils/tab/MainTabConstants$ThemeFullBgType;", "", "V", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum ThemeFullBgType {
        V,
        I;

        public static final ThemeFullBgType[] a;
        public static final b b;

        static {
            ThemeFullBgType.a = arr_mainTabConstants$ThemeFullBgType;
            q.g(arr_mainTabConstants$ThemeFullBgType, "entries");
            ThemeFullBgType.b = new b(arr_mainTabConstants$ThemeFullBgType);
        }

        @NotNull
        public static a getEntries() {
            return ThemeFullBgType.b;
        }
    }

    public static final int $stable;

}

