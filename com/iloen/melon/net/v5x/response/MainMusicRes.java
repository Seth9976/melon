package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContentListInfo;
import com.iloen.melon.net.v4x.common.HeaderBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0003\u000E\u000F\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE;)V", "menuId", "", "getMenuId", "()Ljava/lang/String;", "RESPONSE", "NOTICE", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MainMusicRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\f\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$NOTICE;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "offerSeq", "", "getOfferSeq", "()Ljava/lang/String;", "setOfferSeq", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "titleHeader", "getTitleHeader", "setTitleHeader", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class NOTICE extends LinkInfoBase {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$NOTICE$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.net.v5x.response.MainMusicRes.NOTICE.Companion {
            private com.iloen.melon.net.v5x.response.MainMusicRes.NOTICE.Companion() {
            }

            public com.iloen.melon.net.v5x.response.MainMusicRes.NOTICE.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.net.v5x.response.MainMusicRes.NOTICE.Companion Companion = null;
        @b("OFFERSEQ")
        @Nullable
        private String offerSeq;
        private static final long serialVersionUID = 0x4FD8949F3565E62L;
        @b("TITLE")
        @Nullable
        private String title;
        @b("TITLEHEADER")
        @Nullable
        private String titleHeader;

        static {
            NOTICE.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.NOTICE.Companion(null);
            NOTICE.$stable = 8;
        }

        @Nullable
        public final String getOfferSeq() {
            return this.offerSeq;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getTitleHeader() {
            return this.titleHeader;
        }

        public final void setOfferSeq(@Nullable String s) {
            this.offerSeq = s;
        }

        public final void setTitle(@Nullable String s) {
            this.title = s;
        }

        public final void setTitleHeader(@Nullable String s) {
            this.titleHeader = s;
        }
    }

    @Metadata(d1 = {"\u0000\u00A8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001D\b\u0007\u0018\u0000 \u009D\u00012\u00020\u0001:.\u0087\u0001\u0088\u0001\u0089\u0001\u008A\u0001\u008B\u0001\u008C\u0001\u008D\u0001\u008E\u0001\u008F\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001\u0099\u0001\u009A\u0001\u009B\u0001\u009C\u0001\u009D\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0086\u0001\u001A\u00020\fH\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R \u0010\u0011\u001A\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001A\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR \u0010\u001D\u001A\u0004\u0018\u00010\u001E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R \u0010#\u001A\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(R \u0010)\u001A\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010/\u001A\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b0\u0010,\"\u0004\b1\u0010.R \u00102\u001A\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b3\u0010,\"\u0004\b4\u0010.R \u00105\u001A\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b6\u0010,\"\u0004\b7\u0010.R \u00108\u001A\u0004\u0018\u0001098\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b:\u0010;\"\u0004\b<\u0010=R \u0010>\u001A\u0004\u0018\u00010?8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b@\u0010A\"\u0004\bB\u0010CR \u0010D\u001A\u0004\u0018\u00010E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bF\u0010G\"\u0004\bH\u0010IR \u0010J\u001A\u0004\u0018\u00010K8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bL\u0010M\"\u0004\bN\u0010OR \u0010P\u001A\u0004\u0018\u00010Q8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bR\u0010S\"\u0004\bT\u0010UR \u0010V\u001A\u0004\u0018\u00010W8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bX\u0010Y\"\u0004\bZ\u0010[R \u0010\\\u001A\u0004\u0018\u00010]8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b^\u0010_\"\u0004\b`\u0010aR \u0010b\u001A\u0004\u0018\u00010c8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bd\u0010e\"\u0004\bf\u0010gR \u0010h\u001A\u0004\u0018\u00010c8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bi\u0010e\"\u0004\bj\u0010gR \u0010k\u001A\u0004\u0018\u00010c8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bl\u0010e\"\u0004\bm\u0010gR \u0010n\u001A\u0004\u0018\u00010o8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bp\u0010q\"\u0004\br\u0010sR \u0010t\u001A\u0004\u0018\u00010u8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bv\u0010w\"\u0004\bx\u0010yR \u0010z\u001A\u0004\u0018\u00010{8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b|\u0010}\"\u0004\b~\u0010\u007FR&\u0010\u0080\u0001\u001A\u0005\u0018\u00010\u0081\u00018\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0000\u001A\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001\u00A8\u0006\u009E\u0001"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "tabTitle", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$TABTITLE;", "getTabTitle", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$TABTITLE;", "setTabTitle", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$TABTITLE;)V", "slotDpList", "", "", "getSlotDpList", "()Ljava/util/List;", "setSlotDpList", "(Ljava/util/List;)V", "dj", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$DJ;", "getDj", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$DJ;", "setDj", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$DJ;)V", "newAlbums", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$NEWALBUM;", "getNewAlbums", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$NEWALBUM;", "setNewAlbums", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$NEWALBUM;)V", "cheerboard", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$CHEERBOARD;", "getCheerboard", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$CHEERBOARD;", "setCheerboard", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$CHEERBOARD;)V", "strategy", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STRATEGY;", "getStrategy", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STRATEGY;", "setStrategy", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STRATEGY;)V", "theme", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$THEME;", "getTheme", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$THEME;", "setTheme", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$THEME;)V", "themesub1", "getThemesub1", "setThemesub1", "themesub2", "getThemesub2", "setThemesub2", "daily", "getDaily", "setDaily", "footer", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$FOOTER;", "getFooter", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$FOOTER;", "setFooter", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$FOOTER;)V", "my24Hits", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$SONGLIST;", "getMy24Hits", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$SONGLIST;", "setMy24Hits", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$SONGLIST;)V", "melonChart", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART;", "getMelonChart", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART;", "setMelonChart", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART;)V", "statsElements", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;)V", "logo", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$LOGO;", "getLogo", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$LOGO;", "setLogo", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$LOGO;)V", "vipMembership", "Lcom/melon/net/res/common/LinkInfoBase;", "getVipMembership", "()Lcom/melon/net/res/common/LinkInfoBase;", "setVipMembership", "(Lcom/melon/net/res/common/LinkInfoBase;)V", "tag", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$TAG;", "getTag", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$TAG;", "setTag", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$TAG;)V", "video_1", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$VIDEO;", "getVideo_1", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$VIDEO;", "setVideo_1", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$VIDEO;)V", "video_2", "getVideo_2", "setVideo_2", "video_3", "getVideo_3", "setVideo_3", "weeklyDj", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$WEEKLYDJ;", "getWeeklyDj", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$WEEKLYDJ;", "setWeeklyDj", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$WEEKLYDJ;)V", "chartShortcut", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$CHARTSHORTCUT;", "getChartShortcut", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$CHARTSHORTCUT;", "setChartShortcut", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$CHARTSHORTCUT;)V", "magazine", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MAGAZINE;", "getMagazine", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MAGAZINE;", "setMagazine", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MAGAZINE;)V", "popularSong", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$POPULARSONG;", "getPopularSong", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$POPULARSONG;", "setPopularSong", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$POPULARSONG;)V", "toString", "TABTITLE", "DJ", "NEWALBUM", "STRATEGY", "THEME", "SONGLIST", "MELONCHART", "FOOTER", "BasicSlot", "CHEERBOARD", "HEADER", "DJCONTENT", "STATSELEMENTS", "LOGO", "TAG", "TAGCONTENTS", "VIDEO", "CHARTSHORTCUT", "WEEKLYDJ", "MAGAZINE", "MAGAZINECONTENT", "POPULARSONG", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001D\u001A\u00020\u0018H\u0016R \u0010\u0005\u001A\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000B\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R \u0010\u0011\u001A\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0017\u001A\u00020\u0018X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$BasicSlot;", "T", "Ljava/io/Serializable;", "<init>", "()V", "header", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$HEADER;", "getHeader", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$HEADER;", "setHeader", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$HEADER;)V", "contents", "", "getContents", "()Ljava/util/List;", "setContents", "(Ljava/util/List;)V", "statsElements", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;)V", "slotName", "", "getSlotName", "()Ljava/lang/String;", "setSlotName", "(Ljava/lang/String;)V", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static class BasicSlot implements Serializable {
            public static final int $stable = 8;
            @b("CONTENTS")
            @Nullable
            private List contents;
            @b("HEADER")
            @Nullable
            private HEADER header;
            @NotNull
            private String slotName;
            @b("STATSELEMENTS")
            @Nullable
            private STATSELEMENTS statsElements;

            public BasicSlot() {
                this.slotName = "";
            }

            @Nullable
            public final List getContents() {
                return this.contents;
            }

            @Nullable
            public final HEADER getHeader() {
                return this.header;
            }

            @NotNull
            public final String getSlotName() [...] // 潜在的解密器

            @Nullable
            public final STATSELEMENTS getStatsElements() {
                return this.statsElements;
            }

            public final void setContents(@Nullable List list0) {
                this.contents = list0;
            }

            public final void setHeader(@Nullable HEADER mainMusicRes$RESPONSE$HEADER0) {
                this.header = mainMusicRes$RESPONSE$HEADER0;
            }

            public final void setSlotName(@NotNull String s) {
                q.g(s, "<set-?>");
                this.slotName = s;
            }

            public final void setStatsElements(@Nullable STATSELEMENTS mainMusicRes$RESPONSE$STATSELEMENTS0) {
                this.statsElements = mainMusicRes$RESPONSE$STATSELEMENTS0;
            }

            @Override
            @NotNull
            public String toString() {
                String s = ToStringUtil.toStringFields(this);
                q.f(s, "toStringFields(...)");
                return s;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$CHARTSHORTCUT;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$BasicSlot;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$CHARTSHORTCUT$CONTENTS;", "<init>", "()V", "serialVersionUID", "", "CONTENTS", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class CHARTSHORTCUT extends BasicSlot {
            @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$CHARTSHORTCUT$CONTENTS;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "bgImgUrl", "getBgImgUrl", "setBgImgUrl", "albumImgList", "", "getAlbumImgList", "()Ljava/util/List;", "setAlbumImgList", "(Ljava/util/List;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class CONTENTS extends LinkInfoBase {
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$CHARTSHORTCUT$CONTENTS$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.CHARTSHORTCUT.CONTENTS.Companion {
                    private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.CHARTSHORTCUT.CONTENTS.Companion() {
                    }

                    public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.CHARTSHORTCUT.CONTENTS.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                    }
                }

                public static final int $stable = 0;
                @NotNull
                public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.CHARTSHORTCUT.CONTENTS.Companion Companion = null;
                @b("ALBUMIMGLIST")
                @Nullable
                private List albumImgList;
                @b("BGIMGURL")
                @Nullable
                private String bgImgUrl;
                private static final long serialVersionUID = 0x4E0658B81AC9F9F3L;
                @b("TITLE")
                @Nullable
                private String title;

                static {
                    CONTENTS.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.CHARTSHORTCUT.CONTENTS.Companion(null);
                    CONTENTS.$stable = 8;
                }

                @Nullable
                public final List getAlbumImgList() {
                    return this.albumImgList;
                }

                @Nullable
                public final String getBgImgUrl() {
                    return this.bgImgUrl;
                }

                @Nullable
                public final String getTitle() {
                    return this.title;
                }

                public final void setAlbumImgList(@Nullable List list0) {
                    this.albumImgList = list0;
                }

                public final void setBgImgUrl(@Nullable String s) {
                    this.bgImgUrl = s;
                }

                public final void setTitle(@Nullable String s) {
                    this.title = s;
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final CHARTSHORTCUT INSTANCE = null;
            private static final long serialVersionUID = 0x4710BEA4E878BF0L;

            static {
                CHARTSHORTCUT.INSTANCE = new CHARTSHORTCUT();
                CHARTSHORTCUT.$stable = 8;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$CHEERBOARD;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "imgUrl", "getImgUrl", "setImgUrl", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class CHEERBOARD extends LinkInfoBase {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$CHEERBOARD$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.CHEERBOARD.Companion {
                private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.CHEERBOARD.Companion() {
                }

                public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.CHEERBOARD.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.CHEERBOARD.Companion Companion = null;
            @b("ID")
            @Nullable
            private String id;
            @b("IMGURL")
            @Nullable
            private String imgUrl;
            private static final long serialVersionUID = 0x7101AF0A2813970CL;

            static {
                CHEERBOARD.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.CHEERBOARD.Companion(null);
                CHEERBOARD.$stable = 8;
            }

            @Nullable
            public final String getId() {
                return this.id;
            }

            @Nullable
            public final String getImgUrl() {
                return this.imgUrl;
            }

            public final void setId(@Nullable String s) {
                this.id = s;
            }

            public final void setImgUrl(@Nullable String s) {
                this.imgUrl = s;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.Companion {
            private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.Companion() {
            }

            public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001A\u00020\u0018H\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R \u0010\u0011\u001A\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$DJ;", "Ljava/io/Serializable;", "<init>", "()V", "header", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$HEADER;", "getHeader", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$HEADER;", "setHeader", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$HEADER;)V", "contents", "", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$DJCONTENT;", "getContents", "()Ljava/util/List;", "setContents", "(Ljava/util/List;)V", "statsElements", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;)V", "toString", "", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class DJ implements Serializable {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$DJ$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.DJ.Companion {
                private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.DJ.Companion() {
                }

                public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.DJ.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.DJ.Companion Companion = null;
            @b("CONTENTS")
            @Nullable
            private List contents;
            @b("HEADER")
            @Nullable
            private HEADER header;
            private static final long serialVersionUID = 0x380DCBA14566FB0CL;
            @b("STATSELEMENTS")
            @Nullable
            private STATSELEMENTS statsElements;

            static {
                DJ.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.DJ.Companion(null);
                DJ.$stable = 8;
            }

            @Nullable
            public final List getContents() {
                return this.contents;
            }

            @Nullable
            public final HEADER getHeader() {
                return this.header;
            }

            @Nullable
            public final STATSELEMENTS getStatsElements() {
                return this.statsElements;
            }

            public final void setContents(@Nullable List list0) {
                this.contents = list0;
            }

            public final void setHeader(@Nullable HEADER mainMusicRes$RESPONSE$HEADER0) {
                this.header = mainMusicRes$RESPONSE$HEADER0;
            }

            public final void setStatsElements(@Nullable STATSELEMENTS mainMusicRes$RESPONSE$STATSELEMENTS0) {
                this.statsElements = mainMusicRes$RESPONSE$STATSELEMENTS0;
            }

            @Override
            @NotNull
            public String toString() {
                String s = ToStringUtil.toStringFields(this);
                q.f(s, "toStringFields(...)");
                return s;
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 42\u00020\u0001:\u0003234B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\b\u00101\u001A\u00020\u0005H\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR2\u0010\n\u001A\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000Bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR \u0010\u0015\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR \u0010\u0018\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u0007\"\u0004\b\u001A\u0010\tR \u0010\u001B\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u0007\"\u0004\b\u001D\u0010\tR \u0010\u001E\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010\u0007\"\u0004\b \u0010\tR \u0010!\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR \u0010$\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\"\u0010\'\u001A\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0002\u0010,\u001A\u0004\b\'\u0010)\"\u0004\b*\u0010+R2\u0010-\u001A\u0016\u0012\u0004\u0012\u00020.\u0018\u00010\u000Bj\n\u0012\u0004\u0012\u00020.\u0018\u0001`\r8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b/\u0010\u000F\"\u0004\b0\u0010\u0011\u00A8\u00065"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$DJCONTENT;", "Lcom/melon/net/res/common/DjPlayListInfoBase;", "<init>", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "songlist", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$DJCONTENT$SONGLIST;", "Lkotlin/collections/ArrayList;", "getSonglist", "()Ljava/util/ArrayList;", "setSonglist", "(Ljava/util/ArrayList;)V", "linkType", "getLinkType", "setLinkType", "linkUrl", "getLinkUrl", "setLinkUrl", "scheme", "getScheme", "setScheme", "chnllseq", "getChnllseq", "setChnllseq", "chnlsseq", "getChnlsseq", "setChnlsseq", "chnltitle", "getChnltitle", "setChnltitle", "playlistType", "getPlaylistType", "setPlaylistType", "isOfficial", "", "()Ljava/lang/Boolean;", "setOfficial", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "artistList", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$DJCONTENT$ArtistInfo;", "getArtistList", "setArtistList", "toString", "SONGLIST", "ArtistInfo", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class DJCONTENT extends DjPlayListInfoBase {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$DJCONTENT$ArtistInfo;", "Lcom/melon/net/res/common/ArtistInfoBase;", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class ArtistInfo extends ArtistInfoBase {
                public static final int $stable = 0;
                @NotNull
                public static final ArtistInfo INSTANCE = null;
                private static final long serialVersionUID = 0x61CB014A6019C172L;

                static {
                    ArtistInfo.INSTANCE = new ArtistInfo();
                    ArtistInfo.$stable = 8;
                }
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$DJCONTENT$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.DJCONTENT.Companion {
                private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.DJCONTENT.Companion() {
                }

                public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.DJCONTENT.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$DJCONTENT$SONGLIST;", "Lcom/melon/net/res/common/SongInfoBase;", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class SONGLIST extends SongInfoBase {
                public static final int $stable = 0;
                @NotNull
                public static final SONGLIST INSTANCE = null;
                private static final long serialVersionUID = 0x1EF803F13395ECC5L;

                static {
                    SONGLIST.INSTANCE = new SONGLIST();
                    SONGLIST.$stable = 8;
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.DJCONTENT.Companion Companion = null;
            @b("ARTISTLIST")
            @Nullable
            private ArrayList artistList;
            @b("CHNLLSEQ")
            @Nullable
            private String chnllseq;
            @b("CHNLSSEQ")
            @Nullable
            private String chnlsseq;
            @b("CHNLTITLE")
            @Nullable
            private String chnltitle;
            @b("ISOFFICIAL")
            @Nullable
            private Boolean isOfficial;
            @b("LINKTYPE")
            @Nullable
            private String linkType;
            @b("LINKURL")
            @Nullable
            private String linkUrl;
            @b("PLAYLISTTYPE")
            @Nullable
            private String playlistType;
            @b("SCHEME")
            @Nullable
            private String scheme;
            private static final long serialVersionUID = 0xEF4299991A4C845EL;
            @b("SONGLIST")
            @Nullable
            private ArrayList songlist;
            @b("TEXT")
            @Nullable
            private String text;

            static {
                DJCONTENT.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.DJCONTENT.Companion(null);
                DJCONTENT.$stable = 8;
            }

            public DJCONTENT() {
                this.linkType = "";
                this.linkUrl = "";
                this.scheme = "";
                this.chnllseq = "";
                this.chnlsseq = "";
                this.chnltitle = "";
                this.playlistType = "";
                this.isOfficial = Boolean.FALSE;
            }

            @Nullable
            public final ArrayList getArtistList() {
                return this.artistList;
            }

            @Nullable
            public final String getChnllseq() [...] // 潜在的解密器

            @Nullable
            public final String getChnlsseq() {
                return this.chnlsseq;
            }

            @Nullable
            public final String getChnltitle() {
                return this.chnltitle;
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
            public final String getPlaylistType() {
                return this.playlistType;
            }

            @Nullable
            public final String getScheme() [...] // 潜在的解密器

            @Nullable
            public final ArrayList getSonglist() {
                return this.songlist;
            }

            @Nullable
            public final String getText() {
                return this.text;
            }

            @Nullable
            public final Boolean isOfficial() {
                return this.isOfficial;
            }

            public final void setArtistList(@Nullable ArrayList arrayList0) {
                this.artistList = arrayList0;
            }

            public final void setChnllseq(@Nullable String s) {
                this.chnllseq = s;
            }

            public final void setChnlsseq(@Nullable String s) {
                this.chnlsseq = s;
            }

            public final void setChnltitle(@Nullable String s) {
                this.chnltitle = s;
            }

            public final void setLinkType(@Nullable String s) {
                this.linkType = s;
            }

            public final void setLinkUrl(@Nullable String s) {
                this.linkUrl = s;
            }

            public final void setOfficial(@Nullable Boolean boolean0) {
                this.isOfficial = boolean0;
            }

            public final void setPlaylistType(@Nullable String s) {
                this.playlistType = s;
            }

            public final void setScheme(@Nullable String s) {
                this.scheme = s;
            }

            public final void setSonglist(@Nullable ArrayList arrayList0) {
                this.songlist = arrayList0;
            }

            public final void setText(@Nullable String s) {
                this.text = s;
            }

            @Override  // com.melon.net.res.common.DjPlayListInfoBase
            @NotNull
            public String toString() {
                String s = ToStringUtil.toStringFields(this);
                q.f(s, "toStringFields(...)");
                return s;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$FOOTER;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "text1", "", "getText1", "()Ljava/lang/String;", "setText1", "(Ljava/lang/String;)V", "text2", "getText2", "setText2", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class FOOTER extends LinkInfoBase {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$FOOTER$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.FOOTER.Companion {
                private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.FOOTER.Companion() {
                }

                public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.FOOTER.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.FOOTER.Companion Companion = null;
            private static final long serialVersionUID = 2082043515649155970L;
            @b("TEXT1")
            @Nullable
            private String text1;
            @b("TEXT2")
            @Nullable
            private String text2;

            static {
                FOOTER.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.FOOTER.Companion(null);
                FOOTER.$stable = 8;
            }

            @Nullable
            public final String getText1() {
                return this.text1;
            }

            @Nullable
            public final String getText2() {
                return this.text2;
            }

            public final void setText1(@Nullable String s) {
                this.text1 = s;
            }

            public final void setText2(@Nullable String s) {
                this.text2 = s;
            }
        }

        @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0010\t\n\u0002\b\b\b\u0017\u0018\u0000 \u001B2\u00020\u0001:\u0001\u001BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001A\u001A\u00020\u0005H\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\"\u0010\u0013\u001A\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000E¢\u0006\u0010\n\u0002\u0010\u0019\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$HEADER;", "Lcom/iloen/melon/net/v4x/common/HeaderBase;", "<init>", "()V", "bgColor", "", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "contsId", "getContsId", "setContsId", "contsTypeCode", "getContsTypeCode", "setContsTypeCode", "offerSeq", "getOfferSeq", "setOfferSeq", "voteEndTime", "", "getVoteEndTime", "()Ljava/lang/Long;", "setVoteEndTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "toString", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static class HEADER extends HeaderBase {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$HEADER$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.HEADER.Companion {
                private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.HEADER.Companion() {
                }

                public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.HEADER.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.HEADER.Companion Companion = null;
            @b("BGCOLOR")
            @Nullable
            private String bgColor;
            @b("CONTSID")
            @Nullable
            private String contsId;
            @b("CONTSTYPECODE")
            @Nullable
            private String contsTypeCode;
            @b("OFFERSEQ")
            @Nullable
            private String offerSeq;
            private static final long serialVersionUID = 7016094457021779689L;
            @b("VOTEENDTIME")
            @Nullable
            private Long voteEndTime;

            static {
                HEADER.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.HEADER.Companion(null);
                HEADER.$stable = 8;
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
            public final String getOfferSeq() {
                return this.offerSeq;
            }

            @Nullable
            public final Long getVoteEndTime() {
                return this.voteEndTime;
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

            public final void setOfferSeq(@Nullable String s) {
                this.offerSeq = s;
            }

            public final void setVoteEndTime(@Nullable Long long0) {
                this.voteEndTime = long0;
            }

            @Override  // com.melon.net.res.common.LinkInfoBase
            @NotNull
            public String toString() {
                String s = ToStringUtil.toStringFields(this);
                q.f(s, "toStringFields(...)");
                return s;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000E\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR\u0013\u0010\u0010\u001A\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$LOGO;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "darkImgUrl", "", "getDarkImgUrl", "()Ljava/lang/String;", "setDarkImgUrl", "(Ljava/lang/String;)V", "imgUrl", "getImgUrl", "setImgUrl", "iconText", "getIconText", "setIconText", "whiteOrDarkImageUrl", "getWhiteOrDarkImageUrl", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class LOGO extends LinkInfoBase {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$LOGO$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.LOGO.Companion {
                private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.LOGO.Companion() {
                }

                public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.LOGO.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.LOGO.Companion Companion = null;
            @b("DARKIMGURL")
            @Nullable
            private String darkImgUrl;
            @b("ICONTEXT")
            @Nullable
            private String iconText;
            @b("IMGURL")
            @Nullable
            private String imgUrl;
            private static final long serialVersionUID = 0xBF9877585E9F60D1L;

            static {
                LOGO.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.LOGO.Companion(null);
                LOGO.$stable = 8;
            }

            @Nullable
            public final String getDarkImgUrl() {
                return this.darkImgUrl;
            }

            @Nullable
            public final String getIconText() {
                return this.iconText;
            }

            @Nullable
            public final String getImgUrl() {
                return this.imgUrl;
            }

            @Nullable
            public final String getWhiteOrDarkImageUrl() {
                MelonAppBase.Companion.getClass();
                return ScreenUtils.isDarkMode(t.a().getContext()) ? this.darkImgUrl : this.imgUrl;
            }

            public final void setDarkImgUrl(@Nullable String s) {
                this.darkImgUrl = s;
            }

            public final void setIconText(@Nullable String s) {
                this.iconText = s;
            }

            public final void setImgUrl(@Nullable String s) {
                this.imgUrl = s;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MAGAZINE;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$BasicSlot;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MAGAZINE$CONTENTS;", "<init>", "()V", "serialVersionUID", "", "CONTENTS", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class MAGAZINE extends BasicSlot {
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MAGAZINE$CONTENTS;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "magazineList", "", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MAGAZINECONTENT;", "getMagazineList", "()Ljava/util/List;", "setMagazineList", "(Ljava/util/List;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINE.CONTENTS extends LinkInfoBase {
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MAGAZINE$CONTENTS$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINE.CONTENTS.Companion {
                    private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINE.CONTENTS.Companion() {
                    }

                    public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINE.CONTENTS.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                    }
                }

                public static final int $stable = 0;
                @NotNull
                public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINE.CONTENTS.Companion Companion = null;
                @b("MAGAZINELIST")
                @Nullable
                private List magazineList;
                private static final long serialVersionUID = 0xD5CD967C6F070224L;
                @b("TITLE")
                @Nullable
                private String title;

                static {
                    com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINE.CONTENTS.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINE.CONTENTS.Companion(null);
                    com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINE.CONTENTS.$stable = 8;
                }

                @Nullable
                public final List getMagazineList() {
                    return this.magazineList;
                }

                @Nullable
                public final String getTitle() {
                    return this.title;
                }

                public final void setMagazineList(@Nullable List list0) {
                    this.magazineList = list0;
                }

                public final void setTitle(@Nullable String s) {
                    this.title = s;
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final MAGAZINE INSTANCE = null;
            private static final long serialVersionUID = 0xB8272027C7ABA489L;

            static {
                MAGAZINE.INSTANCE = new MAGAZINE();
                MAGAZINE.$stable = 8;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0012\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MAGAZINECONTENT;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "subTitle", "getSubTitle", "setSubTitle", "contsId", "getContsId", "setContsId", "contsTypeCode", "getContsTypeCode", "setContsTypeCode", "imgUrl", "getImgUrl", "setImgUrl", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class MAGAZINECONTENT extends LinkInfoBase {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MAGAZINECONTENT$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINECONTENT.Companion {
                private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINECONTENT.Companion() {
                }

                public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINECONTENT.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINECONTENT.Companion Companion = null;
            @b("CONTSID")
            @Nullable
            private String contsId;
            @b("CONTSTYPECODE")
            @Nullable
            private String contsTypeCode;
            @b("IMGURL")
            @Nullable
            private String imgUrl;
            private static final long serialVersionUID = 0xDA432642E274834DL;
            @b("SUBTITLE")
            @Nullable
            private String subTitle;
            @b("TITLE")
            @Nullable
            private String title;

            static {
                MAGAZINECONTENT.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINECONTENT.Companion(null);
                MAGAZINECONTENT.$stable = 8;
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
            public final String getImgUrl() {
                return this.imgUrl;
            }

            @Nullable
            public final String getSubTitle() {
                return this.subTitle;
            }

            @Nullable
            public final String getTitle() {
                return this.title;
            }

            public final void setContsId(@Nullable String s) {
                this.contsId = s;
            }

            public final void setContsTypeCode(@Nullable String s) {
                this.contsTypeCode = s;
            }

            public final void setImgUrl(@Nullable String s) {
                this.imgUrl = s;
            }

            public final void setSubTitle(@Nullable String s) {
                this.subTitle = s;
            }

            public final void setTitle(@Nullable String s) {
                this.title = s;
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 .2\u00020\u0001:\u0003,-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR&\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001A\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u001E\u0010\u001D\u001A\u00020\u001E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R \u0010#\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b$\u0010\r\"\u0004\b%\u0010\u000FR \u0010&\u001A\u0004\u0018\u00010\'8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART;", "Ljava/io/Serializable;", "<init>", "()V", "toolTip", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$NOTICE;", "getToolTip", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$NOTICE;", "setToolTip", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$NOTICE;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "charts", "", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart;", "getCharts", "()Ljava/util/List;", "setCharts", "(Ljava/util/List;)V", "statsElements", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;)V", "useHighlightIcon", "", "getUseHighlightIcon", "()Z", "setUseHighlightIcon", "(Z)V", "highLightIconImg", "getHighLightIconImg", "setHighLightIconImg", "moreLanding", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$MoreLanding;", "getMoreLanding", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$MoreLanding;", "setMoreLanding", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$MoreLanding;)V", "Chart", "MoreLanding", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class MELONCHART implements Serializable {
            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R \u0010\u0011\u001A\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart;", "", "<init>", "()V", "header", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader;", "getHeader", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader;", "setHeader", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader;)V", "contents", "", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS;", "getContents", "()Ljava/util/List;", "setContents", "(Ljava/util/List;)V", "rankHour", "", "getRankHour", "()Ljava/lang/String;", "setRankHour", "(Ljava/lang/String;)V", "ChartHeader", "CONTENTS", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class Chart {
                @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000  2\u00020\u0001:\u0002\u001F B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001A\u0004\u0018\u00010\u001A8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001E¨\u0006!"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS;", "Lcom/melon/net/res/common/SongInfoBase;", "<init>", "()V", "contsTypeCode", "", "getContsTypeCode", "()Ljava/lang/String;", "setContsTypeCode", "(Ljava/lang/String;)V", "thumbImg", "getThumbImg", "setThumbImg", "currentRank", "getCurrentRank", "setCurrentRank", "pastRank", "getPastRank", "setPastRank", "rankGap", "getRankGap", "setRankGap", "rankType", "getRankType", "setRankType", "statsElements", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;)V", "ADDINFO", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS extends SongInfoBase {
                    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS$ADDINFO;", "Ljava/io/Serializable;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "texts", "", "getTexts", "()Ljava/util/List;", "setTexts", "(Ljava/util/List;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                    public static final class ADDINFO implements Serializable {
                        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS$ADDINFO$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                        public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS.ADDINFO.Companion {
                            private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS.ADDINFO.Companion() {
                            }

                            public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS.ADDINFO.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                            }
                        }

                        public static final int $stable = 0;
                        @NotNull
                        public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS.ADDINFO.Companion Companion = null;
                        private static final long serialVersionUID = 0x795E735C48AC8691L;
                        @b("TEXTS")
                        @Nullable
                        private List texts;
                        @b("TYPE")
                        @Nullable
                        private String type;

                        static {
                            ADDINFO.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS.ADDINFO.Companion(null);
                            ADDINFO.$stable = 8;
                        }

                        @Nullable
                        public final List getTexts() {
                            return this.texts;
                        }

                        @Nullable
                        public final String getType() {
                            return this.type;
                        }

                        public final void setTexts(@Nullable List list0) {
                            this.texts = list0;
                        }

                        public final void setType(@Nullable String s) {
                            this.type = s;
                        }
                    }

                    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                    public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS.Companion {
                        private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS.Companion() {
                        }

                        public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                        }
                    }

                    public static final int $stable = 0;
                    @NotNull
                    public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS.Companion Companion = null;
                    @b("CONTSTYPECODE")
                    @Nullable
                    private String contsTypeCode;
                    @b("CURRANK")
                    @Nullable
                    private String currentRank;
                    @b("PASTRANK")
                    @Nullable
                    private String pastRank;
                    @b("RANKGAP")
                    @Nullable
                    private String rankGap;
                    @b("RANKTYPE")
                    @Nullable
                    private String rankType;
                    private static final long serialVersionUID = 0x6E6817B70A74A271L;
                    @b("STATSELEMENTS")
                    @Nullable
                    private STATSELEMENTS statsElements;
                    @b("THUMBIMG")
                    @Nullable
                    private String thumbImg;

                    static {
                        com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS.Companion(null);
                        com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS.$stable = 8;
                    }

                    @Nullable
                    public final String getContsTypeCode() {
                        return this.contsTypeCode;
                    }

                    @Nullable
                    public final String getCurrentRank() {
                        return this.currentRank;
                    }

                    @Nullable
                    public final String getPastRank() {
                        return this.pastRank;
                    }

                    @Nullable
                    public final String getRankGap() {
                        return this.rankGap;
                    }

                    @Nullable
                    public final String getRankType() {
                        return this.rankType;
                    }

                    @Nullable
                    public final STATSELEMENTS getStatsElements() {
                        return this.statsElements;
                    }

                    @Nullable
                    public final String getThumbImg() {
                        return this.thumbImg;
                    }

                    public final void setContsTypeCode(@Nullable String s) {
                        this.contsTypeCode = s;
                    }

                    public final void setCurrentRank(@Nullable String s) {
                        this.currentRank = s;
                    }

                    public final void setPastRank(@Nullable String s) {
                        this.pastRank = s;
                    }

                    public final void setRankGap(@Nullable String s) {
                        this.rankGap = s;
                    }

                    public final void setRankType(@Nullable String s) {
                        this.rankType = s;
                    }

                    public final void setStatsElements(@Nullable STATSELEMENTS mainMusicRes$RESPONSE$STATSELEMENTS0) {
                        this.statsElements = mainMusicRes$RESPONSE$STATSELEMENTS0;
                    }

                    public final void setThumbImg(@Nullable String s) {
                        this.thumbImg = s;
                    }
                }

                @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR\u001E\u0010\r\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001A\u0004\u0018\u00010\u001A8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001E¨\u0006 "}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$HEADER;", "<init>", "()V", "chartId", "", "getChartId", "()Ljava/lang/String;", "setChartId", "(Ljava/lang/String;)V", "chartTypeName", "getChartTypeName", "setChartTypeName", "useHighLight", "", "getUseHighLight", "()Z", "setUseHighLight", "(Z)V", "chartBtnType", "getChartBtnType", "setChartBtnType", "playScheme", "getPlayScheme", "setPlayScheme", "filter", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader$FILTER;", "getFilter", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader$FILTER;", "setFilter", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader$FILTER;)V", "FILTER", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public static final class ChartHeader extends HEADER {
                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0012\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader$FILTER;", "Ljava/io/Serializable;", "<init>", "()V", "chartType", "", "getChartType", "()Ljava/lang/String;", "setChartType", "(Ljava/lang/String;)V", "gnrcode", "getGnrcode", "setGnrcode", "type", "getType", "setType", "genre", "getGenre", "setGenre", "year", "getYear", "setYear", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                    public static final class FILTER implements Serializable {
                        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader$FILTER$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                        public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.ChartHeader.FILTER.Companion {
                            private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.ChartHeader.FILTER.Companion() {
                            }

                            public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.ChartHeader.FILTER.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                            }
                        }

                        public static final int $stable = 0;
                        @NotNull
                        public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.ChartHeader.FILTER.Companion Companion = null;
                        @b("CHARTTYPE")
                        @Nullable
                        private String chartType;
                        @b("GENRE")
                        @Nullable
                        private String genre;
                        @b("GNRCODE")
                        @Nullable
                        private String gnrcode;
                        private static final long serialVersionUID = 0xD6E00EEC8B0C3167L;
                        @b("TYPE")
                        @Nullable
                        private String type;
                        @b("YEAR")
                        @Nullable
                        private String year;

                        static {
                            FILTER.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.ChartHeader.FILTER.Companion(null);
                            FILTER.$stable = 8;
                        }

                        @Nullable
                        public final String getChartType() {
                            return this.chartType;
                        }

                        @Nullable
                        public final String getGenre() {
                            return this.genre;
                        }

                        @Nullable
                        public final String getGnrcode() {
                            return this.gnrcode;
                        }

                        @Nullable
                        public final String getType() {
                            return this.type;
                        }

                        @Nullable
                        public final String getYear() {
                            return this.year;
                        }

                        public final void setChartType(@Nullable String s) {
                            this.chartType = s;
                        }

                        public final void setGenre(@Nullable String s) {
                            this.genre = s;
                        }

                        public final void setGnrcode(@Nullable String s) {
                            this.gnrcode = s;
                        }

                        public final void setType(@Nullable String s) {
                            this.type = s;
                        }

                        public final void setYear(@Nullable String s) {
                            this.year = s;
                        }
                    }

                    public static final int $stable = 8;
                    @b("CHARTBTNTYPE")
                    @Nullable
                    private String chartBtnType;
                    @b("CHARTID")
                    @Nullable
                    private String chartId;
                    @b("CHARTTYPENAME")
                    @Nullable
                    private String chartTypeName;
                    @b("FILTER")
                    @Nullable
                    private FILTER filter;
                    @b("PLAYSCHEME")
                    @Nullable
                    private String playScheme;
                    @b("USEHIGHLIGHT")
                    private boolean useHighLight;

                    @Nullable
                    public final String getChartBtnType() {
                        return this.chartBtnType;
                    }

                    @Nullable
                    public final String getChartId() {
                        return this.chartId;
                    }

                    @Nullable
                    public final String getChartTypeName() {
                        return this.chartTypeName;
                    }

                    @Nullable
                    public final FILTER getFilter() {
                        return this.filter;
                    }

                    @Nullable
                    public final String getPlayScheme() {
                        return this.playScheme;
                    }

                    public final boolean getUseHighLight() {
                        return this.useHighLight;
                    }

                    public final void setChartBtnType(@Nullable String s) {
                        this.chartBtnType = s;
                    }

                    public final void setChartId(@Nullable String s) {
                        this.chartId = s;
                    }

                    public final void setChartTypeName(@Nullable String s) {
                        this.chartTypeName = s;
                    }

                    public final void setFilter(@Nullable FILTER mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader$FILTER0) {
                        this.filter = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader$FILTER0;
                    }

                    public final void setPlayScheme(@Nullable String s) {
                        this.playScheme = s;
                    }

                    public final void setUseHighLight(boolean z) {
                        this.useHighLight = z;
                    }
                }

                public static final int $stable = 8;
                @b("CONTENTS")
                @Nullable
                private List contents;
                @b("HEADER")
                @Nullable
                private ChartHeader header;
                @b("RANKHOUR")
                @Nullable
                private String rankHour;

                @Nullable
                public final List getContents() {
                    return this.contents;
                }

                @Nullable
                public final ChartHeader getHeader() {
                    return this.header;
                }

                @Nullable
                public final String getRankHour() {
                    return this.rankHour;
                }

                public final void setContents(@Nullable List list0) {
                    this.contents = list0;
                }

                public final void setHeader(@Nullable ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0) {
                    this.header = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0;
                }

                public final void setRankHour(@Nullable String s) {
                    this.rankHour = s;
                }
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Companion {
                private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Companion() {
                }

                public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$MELONCHART$MoreLanding;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class MoreLanding extends LinkInfoBase {
                public static final int $stable = 8;
                @b("TITLE")
                @Nullable
                private String title;

                @Nullable
                public final String getTitle() {
                    return this.title;
                }

                public final void setTitle(@Nullable String s) {
                    this.title = s;
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Companion Companion = null;
            @b("CHARTS")
            @Nullable
            private List charts;
            @b("HIGHLIGHTICONIMG")
            @Nullable
            private String highLightIconImg;
            @b("MORELANDING")
            @Nullable
            private MoreLanding moreLanding;
            private static final long serialVersionUID = 0xD6DE448A5D4A4567L;
            @b("STATSELEMENTS")
            @Nullable
            private STATSELEMENTS statsElements;
            @b("TITLE")
            @Nullable
            private String title;
            @b("TOOLTIP")
            @Nullable
            private NOTICE toolTip;
            @b("USEHIGHLIGHTICON")
            private boolean useHighlightIcon;

            static {
                MELONCHART.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Companion(null);
                MELONCHART.$stable = 8;
            }

            @Nullable
            public final List getCharts() {
                return this.charts;
            }

            @Nullable
            public final String getHighLightIconImg() {
                return this.highLightIconImg;
            }

            @Nullable
            public final MoreLanding getMoreLanding() {
                return this.moreLanding;
            }

            @Nullable
            public final STATSELEMENTS getStatsElements() {
                return this.statsElements;
            }

            @Nullable
            public final String getTitle() {
                return this.title;
            }

            @Nullable
            public final NOTICE getToolTip() {
                return this.toolTip;
            }

            public final boolean getUseHighlightIcon() {
                return this.useHighlightIcon;
            }

            public final void setCharts(@Nullable List list0) {
                this.charts = list0;
            }

            public final void setHighLightIconImg(@Nullable String s) {
                this.highLightIconImg = s;
            }

            public final void setMoreLanding(@Nullable MoreLanding mainMusicRes$RESPONSE$MELONCHART$MoreLanding0) {
                this.moreLanding = mainMusicRes$RESPONSE$MELONCHART$MoreLanding0;
            }

            public final void setStatsElements(@Nullable STATSELEMENTS mainMusicRes$RESPONSE$STATSELEMENTS0) {
                this.statsElements = mainMusicRes$RESPONSE$STATSELEMENTS0;
            }

            public final void setTitle(@Nullable String s) {
                this.title = s;
            }

            public final void setToolTip(@Nullable NOTICE mainMusicRes$NOTICE0) {
                this.toolTip = mainMusicRes$NOTICE0;
            }

            public final void setUseHighlightIcon(boolean z) {
                this.useHighlightIcon = z;
            }
        }

        @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$NEWALBUM;", "Ljava/io/Serializable;", "<init>", "()V", "all", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS;", "getAll", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS;", "setAll", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS;)V", "domestic", "getDomestic", "setDomestic", "overseas", "getOverseas", "setOverseas", "statsElements", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;)V", "NEWALBUMS", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class NEWALBUM implements Serializable {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$NEWALBUM$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.Companion {
                private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.Companion() {
                }

                public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0002\u000B\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS;", "Ljava/io/Serializable;", "<init>", "()V", "newAlbumList", "", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS$ALBUM;", "getNewAlbumList", "()Ljava/util/List;", "setNewAlbumList", "(Ljava/util/List;)V", "ALBUM", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class NEWALBUMS implements Serializable {
                @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001A\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS$ALBUM;", "Lcom/melon/net/res/common/AlbumInfoBase;", "<init>", "()V", "isMyAlbum", "", "()Z", "setMyAlbum", "(Z)V", "statsElements", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public static final class ALBUM extends AlbumInfoBase {
                    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS$ALBUM$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                    public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.NEWALBUMS.ALBUM.Companion {
                        private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.NEWALBUMS.ALBUM.Companion() {
                        }

                        public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.NEWALBUMS.ALBUM.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                        }
                    }

                    public static final int $stable = 0;
                    @NotNull
                    public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.NEWALBUMS.ALBUM.Companion Companion = null;
                    @b("ISMYALBUM")
                    private boolean isMyAlbum;
                    private static final long serialVersionUID = 0x98D86F031EA77964L;
                    @b("STATSELEMENTS")
                    @Nullable
                    private STATSELEMENTS statsElements;

                    static {
                        ALBUM.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.NEWALBUMS.ALBUM.Companion(null);
                        ALBUM.$stable = 8;
                    }

                    @Nullable
                    public final STATSELEMENTS getStatsElements() {
                        return this.statsElements;
                    }

                    public final boolean isMyAlbum() {
                        return this.isMyAlbum;
                    }

                    public final void setMyAlbum(boolean z) {
                        this.isMyAlbum = z;
                    }

                    public final void setStatsElements(@Nullable STATSELEMENTS mainMusicRes$RESPONSE$STATSELEMENTS0) {
                        this.statsElements = mainMusicRes$RESPONSE$STATSELEMENTS0;
                    }
                }

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.NEWALBUMS.Companion {
                    private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.NEWALBUMS.Companion() {
                    }

                    public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.NEWALBUMS.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                    }
                }

                public static final int $stable = 0;
                @NotNull
                public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.NEWALBUMS.Companion Companion = null;
                @b("NEWALBUMLIST")
                @Nullable
                private List newAlbumList;
                private static final long serialVersionUID = 0x757DAB330B32FAD8L;

                static {
                    NEWALBUMS.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.NEWALBUMS.Companion(null);
                    NEWALBUMS.$stable = 8;
                }

                @Nullable
                public final List getNewAlbumList() {
                    return this.newAlbumList;
                }

                public final void setNewAlbumList(@Nullable List list0) {
                    this.newAlbumList = list0;
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.Companion Companion = null;
            @b("ALL")
            @Nullable
            private NEWALBUMS all;
            @b("DOMESTIC")
            @Nullable
            private NEWALBUMS domestic;
            @b("OVERSEAS")
            @Nullable
            private NEWALBUMS overseas;
            private static final long serialVersionUID = 0x85F06AA21B3737E9L;
            @b("STATSELEMENTS")
            @Nullable
            private STATSELEMENTS statsElements;

            static {
                NEWALBUM.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.Companion(null);
                NEWALBUM.$stable = 8;
            }

            @Nullable
            public final NEWALBUMS getAll() {
                return this.all;
            }

            @Nullable
            public final NEWALBUMS getDomestic() {
                return this.domestic;
            }

            @Nullable
            public final NEWALBUMS getOverseas() {
                return this.overseas;
            }

            @Nullable
            public final STATSELEMENTS getStatsElements() {
                return this.statsElements;
            }

            public final void setAll(@Nullable NEWALBUMS mainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS0) {
                this.all = mainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS0;
            }

            public final void setDomestic(@Nullable NEWALBUMS mainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS0) {
                this.domestic = mainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS0;
            }

            public final void setOverseas(@Nullable NEWALBUMS mainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS0) {
                this.overseas = mainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS0;
            }

            public final void setStatsElements(@Nullable STATSELEMENTS mainMusicRes$RESPONSE$STATSELEMENTS0) {
                this.statsElements = mainMusicRes$RESPONSE$STATSELEMENTS0;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$POPULARSONG;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$BasicSlot;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$POPULARSONG$CONTENTS;", "<init>", "()V", "serialVersionUID", "", "CONTENTS", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class POPULARSONG extends BasicSlot {
            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0017\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\tR\u001E\u0010\u001C\u001A\u00020\u001D8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001E\"\u0004\b\u001F\u0010 R2\u0010!\u001A\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\"j\n\u0012\u0004\u0012\u00020#\u0018\u0001`$8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(¨\u0006*"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$POPULARSONG$CONTENTS;", "Ljava/io/Serializable;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "typeTitle", "getTypeTitle", "setTypeTitle", "contsTypeCode", "getContsTypeCode", "setContsTypeCode", "contsId", "getContsId", "setContsId", "songId", "getSongId", "setSongId", "songName", "getSongName", "setSongName", "albumImgLarge", "getAlbumImgLarge", "setAlbumImgLarge", "isAdult", "", "()Z", "setAdult", "(Z)V", "artistList", "Ljava/util/ArrayList;", "Lcom/melon/net/res/common/ArtistInfoBase;", "Lkotlin/collections/ArrayList;", "getArtistList", "()Ljava/util/ArrayList;", "setArtistList", "(Ljava/util/ArrayList;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.POPULARSONG.CONTENTS implements Serializable {
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$POPULARSONG$CONTENTS$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.POPULARSONG.CONTENTS.Companion {
                    private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.POPULARSONG.CONTENTS.Companion() {
                    }

                    public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.POPULARSONG.CONTENTS.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                    }
                }

                public static final int $stable = 0;
                @NotNull
                public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.POPULARSONG.CONTENTS.Companion Companion = null;
                @b("ALBUMIMGLARGE")
                @Nullable
                private String albumImgLarge;
                @b("ARTISTLIST")
                @Nullable
                private ArrayList artistList;
                @b("CONTSID")
                @Nullable
                private String contsId;
                @b("CONTSTYPECODE")
                @Nullable
                private String contsTypeCode;
                @b("ISADULT")
                private boolean isAdult;
                private static final long serialVersionUID = 0x289FF22100EF1958L;
                @b("SONGID")
                @Nullable
                private String songId;
                @b("SONGNAME")
                @Nullable
                private String songName;
                @b("TYPE")
                @Nullable
                private String type;
                @b("TYPETITLE")
                @Nullable
                private String typeTitle;

                static {
                    com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.POPULARSONG.CONTENTS.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.POPULARSONG.CONTENTS.Companion(null);
                    com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.POPULARSONG.CONTENTS.$stable = 8;
                }

                @Nullable
                public final String getAlbumImgLarge() {
                    return this.albumImgLarge;
                }

                @Nullable
                public final ArrayList getArtistList() {
                    return this.artistList;
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
                public final String getSongId() {
                    return this.songId;
                }

                @Nullable
                public final String getSongName() {
                    return this.songName;
                }

                @Nullable
                public final String getType() {
                    return this.type;
                }

                @Nullable
                public final String getTypeTitle() {
                    return this.typeTitle;
                }

                public final boolean isAdult() {
                    return this.isAdult;
                }

                public final void setAdult(boolean z) {
                    this.isAdult = z;
                }

                public final void setAlbumImgLarge(@Nullable String s) {
                    this.albumImgLarge = s;
                }

                public final void setArtistList(@Nullable ArrayList arrayList0) {
                    this.artistList = arrayList0;
                }

                public final void setContsId(@Nullable String s) {
                    this.contsId = s;
                }

                public final void setContsTypeCode(@Nullable String s) {
                    this.contsTypeCode = s;
                }

                public final void setSongId(@Nullable String s) {
                    this.songId = s;
                }

                public final void setSongName(@Nullable String s) {
                    this.songName = s;
                }

                public final void setType(@Nullable String s) {
                    this.type = s;
                }

                public final void setTypeTitle(@Nullable String s) {
                    this.typeTitle = s;
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final POPULARSONG INSTANCE = null;
            private static final long serialVersionUID = 0xD1A781FDDFAB874DL;

            static {
                POPULARSONG.INSTANCE = new POPULARSONG();
                POPULARSONG.$stable = 8;
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R \u0010\u0011\u001A\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$SONGLIST;", "Ljava/io/Serializable;", "<init>", "()V", "header", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$HEADER;", "getHeader", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$HEADER;", "setHeader", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$HEADER;)V", "contents", "", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$SONGLIST$CONTENTS;", "getContents", "()Ljava/util/List;", "setContents", "(Ljava/util/List;)V", "statsElements", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;)V", "CONTENTS", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST implements Serializable {
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 &2\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\tR \u0010\u001C\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0007\"\u0004\b\u001E\u0010\tR \u0010\u001F\u001A\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006\'"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$SONGLIST$CONTENTS;", "Lcom/melon/net/res/common/SongInfoBase;", "<init>", "()V", "contsTypeCode", "", "getContsTypeCode", "()Ljava/lang/String;", "setContsTypeCode", "(Ljava/lang/String;)V", "thumbImg", "getThumbImg", "setThumbImg", "addInfo", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$SONGLIST$CONTENTS$ADDINFO;", "getAddInfo", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$SONGLIST$CONTENTS$ADDINFO;", "setAddInfo", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$SONGLIST$CONTENTS$ADDINFO;)V", "currentRank", "getCurrentRank", "setCurrentRank", "pastRank", "getPastRank", "setPastRank", "rankGap", "getRankGap", "setRankGap", "rankType", "getRankType", "setRankType", "statsElements", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;)V", "ADDINFO", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS extends SongInfoBase {
                @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$SONGLIST$CONTENTS$ADDINFO;", "Ljava/io/Serializable;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "texts", "", "getTexts", "()Ljava/util/List;", "setTexts", "(Ljava/util/List;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.ADDINFO implements Serializable {
                    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$SONGLIST$CONTENTS$ADDINFO$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                    public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.ADDINFO.Companion {
                        private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.ADDINFO.Companion() {
                        }

                        public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.ADDINFO.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                        }
                    }

                    public static final int $stable = 0;
                    @NotNull
                    public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.ADDINFO.Companion Companion = null;
                    private static final long serialVersionUID = 0x795E735C48AC8691L;
                    @b("TEXTS")
                    @Nullable
                    private List texts;
                    @b("TYPE")
                    @Nullable
                    private String type;

                    static {
                        com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.ADDINFO.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.ADDINFO.Companion(null);
                        com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.ADDINFO.$stable = 8;
                    }

                    @Nullable
                    public final List getTexts() {
                        return this.texts;
                    }

                    @Nullable
                    public final String getType() {
                        return this.type;
                    }

                    public final void setTexts(@Nullable List list0) {
                        this.texts = list0;
                    }

                    public final void setType(@Nullable String s) {
                        this.type = s;
                    }
                }

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$SONGLIST$CONTENTS$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.Companion {
                    private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.Companion() {
                    }

                    public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                    }
                }

                public static final int $stable = 0;
                @NotNull
                public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.Companion Companion = null;
                @b("ADDINFO")
                @Nullable
                private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.ADDINFO addInfo;
                @b("CONTSTYPECODE")
                @Nullable
                private String contsTypeCode;
                @b("CURRANK")
                @Nullable
                private String currentRank;
                @b("PASTRANK")
                @Nullable
                private String pastRank;
                @b("RANKGAP")
                @Nullable
                private String rankGap;
                @b("RANKTYPE")
                @Nullable
                private String rankType;
                private static final long serialVersionUID = 0x6E6817B70A74A271L;
                @b("STATSELEMENTS")
                @Nullable
                private STATSELEMENTS statsElements;
                @b("THUMBIMG")
                @Nullable
                private String thumbImg;

                static {
                    com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.Companion(null);
                    com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.$stable = 8;
                }

                @Nullable
                public final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.ADDINFO getAddInfo() {
                    return this.addInfo;
                }

                @Nullable
                public final String getContsTypeCode() {
                    return this.contsTypeCode;
                }

                @Nullable
                public final String getCurrentRank() {
                    return this.currentRank;
                }

                @Nullable
                public final String getPastRank() {
                    return this.pastRank;
                }

                @Nullable
                public final String getRankGap() {
                    return this.rankGap;
                }

                @Nullable
                public final String getRankType() {
                    return this.rankType;
                }

                @Nullable
                public final STATSELEMENTS getStatsElements() {
                    return this.statsElements;
                }

                @Nullable
                public final String getThumbImg() {
                    return this.thumbImg;
                }

                public final void setAddInfo(@Nullable com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.CONTENTS.ADDINFO mainMusicRes$RESPONSE$SONGLIST$CONTENTS$ADDINFO0) {
                    this.addInfo = mainMusicRes$RESPONSE$SONGLIST$CONTENTS$ADDINFO0;
                }

                public final void setContsTypeCode(@Nullable String s) {
                    this.contsTypeCode = s;
                }

                public final void setCurrentRank(@Nullable String s) {
                    this.currentRank = s;
                }

                public final void setPastRank(@Nullable String s) {
                    this.pastRank = s;
                }

                public final void setRankGap(@Nullable String s) {
                    this.rankGap = s;
                }

                public final void setRankType(@Nullable String s) {
                    this.rankType = s;
                }

                public final void setStatsElements(@Nullable STATSELEMENTS mainMusicRes$RESPONSE$STATSELEMENTS0) {
                    this.statsElements = mainMusicRes$RESPONSE$STATSELEMENTS0;
                }

                public final void setThumbImg(@Nullable String s) {
                    this.thumbImg = s;
                }
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$SONGLIST$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.Companion {
                private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.Companion() {
                }

                public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.Companion Companion = null;
            @b("CONTENTS")
            @Nullable
            private List contents;
            @b("HEADER")
            @Nullable
            private HEADER header;
            private static final long serialVersionUID = 0x289F3C971239E458L;
            @b("STATSELEMENTS")
            @Nullable
            private STATSELEMENTS statsElements;

            static {
                com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.Companion(null);
                com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST.$stable = 8;
            }

            @Nullable
            public final List getContents() {
                return this.contents;
            }

            @Nullable
            public final HEADER getHeader() {
                return this.header;
            }

            @Nullable
            public final STATSELEMENTS getStatsElements() {
                return this.statsElements;
            }

            public final void setContents(@Nullable List list0) {
                this.contents = list0;
            }

            public final void setHeader(@Nullable HEADER mainMusicRes$RESPONSE$HEADER0) {
                this.header = mainMusicRes$RESPONSE$HEADER0;
            }

            public final void setStatsElements(@Nullable STATSELEMENTS mainMusicRes$RESPONSE$STATSELEMENTS0) {
                this.statsElements = mainMusicRes$RESPONSE$STATSELEMENTS0;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class STATSELEMENTS extends StatsElementsBase {
            public static final int $stable = 0;
            @NotNull
            public static final STATSELEMENTS INSTANCE = null;
            private static final long serialVersionUID = 0x7595E4BEA223C290L;

            static {
                STATSELEMENTS.INSTANCE = new STATSELEMENTS();
                STATSELEMENTS.$stable = 8;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000B\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STRATEGY;", "Lcom/melon/net/res/common/ArtistInfoBase;", "<init>", "()V", "offeringList", "", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STRATEGY$OFFERING;", "getOfferingList", "()Ljava/util/List;", "setOfferingList", "(Ljava/util/List;)V", "statsElements", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STATSELEMENTS;)V", "OFFERING", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class STRATEGY extends ArtistInfoBase {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STRATEGY$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.STRATEGY.Companion {
                private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.STRATEGY.Companion() {
                }

                public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.STRATEGY.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b/\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\tR \u0010\u001C\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0007\"\u0004\b\u001E\u0010\tR \u0010\u001F\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR \u0010\"\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR \u0010%\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u0007\"\u0004\b\'\u0010\tR \u0010(\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR \u0010+\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR \u0010.\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR \u00101\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR\u001E\u00104\u001A\u0002058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b6\u00107\"\u0004\b8\u00109\u00A8\u0006;"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STRATEGY$OFFERING;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "contsTypeCode", "", "getContsTypeCode", "()Ljava/lang/String;", "setContsTypeCode", "(Ljava/lang/String;)V", "contsId", "getContsId", "setContsId", "imgUrl", "getImgUrl", "setImgUrl", "offerSeq", "getOfferSeq", "setOfferSeq", "targetId", "getTargetId", "setTargetId", "title", "getTitle", "setTitle", "offerTitle", "getOfferTitle", "setOfferTitle", "playTime", "getPlayTime", "setPlayTime", "bgColor", "getBgColor", "setBgColor", "imgAltText", "getImgAltText", "setImgAltText", "logoType", "getLogoType", "setLogoType", "capsuleText", "getCapsuleText", "setCapsuleText", "logoImgUrl", "getLogoImgUrl", "setLogoImgUrl", "text1", "getText1", "setText1", "text2", "getText2", "setText2", "iSad", "", "getISad", "()Z", "setISad", "(Z)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class OFFERING extends LinkInfoBase {
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$STRATEGY$OFFERING$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.STRATEGY.OFFERING.Companion {
                    private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.STRATEGY.OFFERING.Companion() {
                    }

                    public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.STRATEGY.OFFERING.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                    }
                }

                public static final int $stable = 0;
                @NotNull
                public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.STRATEGY.OFFERING.Companion Companion = null;
                @b("BGCOLOR")
                @Nullable
                private String bgColor;
                @b("CAPSULETEXT")
                @Nullable
                private String capsuleText;
                @b("CONTSID")
                @Nullable
                private String contsId;
                @b("CONTSTYPECODE")
                @Nullable
                private String contsTypeCode;
                @b("ISAD")
                private boolean iSad;
                @b("IMGALTTEXT")
                @Nullable
                private String imgAltText;
                @b("IMGURL")
                @Nullable
                private String imgUrl;
                @b("LOGOIMGURL")
                @Nullable
                private String logoImgUrl;
                @b("LOGOTYPE")
                @Nullable
                private String logoType;
                @b("OFFERSEQ")
                @Nullable
                private String offerSeq;
                @b("OFFERTITLE")
                @Nullable
                private String offerTitle;
                @b("PLAYTIME")
                @Nullable
                private String playTime;
                private static final long serialVersionUID = 0xCBFBFE380D9EA81BL;
                @b("TARGETID")
                @Nullable
                private String targetId;
                @b("TEXT1")
                @Nullable
                private String text1;
                @b("TEXT2")
                @Nullable
                private String text2;
                @b("TITLE")
                @Nullable
                private String title;

                static {
                    OFFERING.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.STRATEGY.OFFERING.Companion(null);
                    OFFERING.$stable = 8;
                }

                @Nullable
                public final String getBgColor() {
                    return this.bgColor;
                }

                @Nullable
                public final String getCapsuleText() {
                    return this.capsuleText;
                }

                @Nullable
                public final String getContsId() {
                    return this.contsId;
                }

                @Nullable
                public final String getContsTypeCode() {
                    return this.contsTypeCode;
                }

                public final boolean getISad() {
                    return this.iSad;
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
                public final String getLogoImgUrl() {
                    return this.logoImgUrl;
                }

                @Nullable
                public final String getLogoType() {
                    return this.logoType;
                }

                @Nullable
                public final String getOfferSeq() {
                    return this.offerSeq;
                }

                @Nullable
                public final String getOfferTitle() {
                    return this.offerTitle;
                }

                @Nullable
                public final String getPlayTime() {
                    return this.playTime;
                }

                @Nullable
                public final String getTargetId() {
                    return this.targetId;
                }

                @Nullable
                public final String getText1() {
                    return this.text1;
                }

                @Nullable
                public final String getText2() {
                    return this.text2;
                }

                @Nullable
                public final String getTitle() {
                    return this.title;
                }

                public final void setBgColor(@Nullable String s) {
                    this.bgColor = s;
                }

                public final void setCapsuleText(@Nullable String s) {
                    this.capsuleText = s;
                }

                public final void setContsId(@Nullable String s) {
                    this.contsId = s;
                }

                public final void setContsTypeCode(@Nullable String s) {
                    this.contsTypeCode = s;
                }

                public final void setISad(boolean z) {
                    this.iSad = z;
                }

                public final void setImgAltText(@Nullable String s) {
                    this.imgAltText = s;
                }

                public final void setImgUrl(@Nullable String s) {
                    this.imgUrl = s;
                }

                public final void setLogoImgUrl(@Nullable String s) {
                    this.logoImgUrl = s;
                }

                public final void setLogoType(@Nullable String s) {
                    this.logoType = s;
                }

                public final void setOfferSeq(@Nullable String s) {
                    this.offerSeq = s;
                }

                public final void setOfferTitle(@Nullable String s) {
                    this.offerTitle = s;
                }

                public final void setPlayTime(@Nullable String s) {
                    this.playTime = s;
                }

                public final void setTargetId(@Nullable String s) {
                    this.targetId = s;
                }

                public final void setText1(@Nullable String s) {
                    this.text1 = s;
                }

                public final void setText2(@Nullable String s) {
                    this.text2 = s;
                }

                public final void setTitle(@Nullable String s) {
                    this.title = s;
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.STRATEGY.Companion Companion = null;
            @b("OFFERINGLIST")
            @Nullable
            private List offeringList;
            private static final long serialVersionUID = 0xAE5422D1BFB97A03L;
            @b("STATSELEMENTS")
            @Nullable
            private STATSELEMENTS statsElements;

            static {
                STRATEGY.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.STRATEGY.Companion(null);
                STRATEGY.$stable = 8;
            }

            @Nullable
            public final List getOfferingList() {
                return this.offeringList;
            }

            @Nullable
            public final STATSELEMENTS getStatsElements() {
                return this.statsElements;
            }

            public final void setOfferingList(@Nullable List list0) {
                this.offeringList = list0;
            }

            public final void setStatsElements(@Nullable STATSELEMENTS mainMusicRes$RESPONSE$STATSELEMENTS0) {
                this.statsElements = mainMusicRes$RESPONSE$STATSELEMENTS0;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\n\b\u0007\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001A\u00020\u0005H\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$TABTITLE;", "Ljava/io/Serializable;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "replaceText", "getReplaceText", "setReplaceText", "toString", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class TABTITLE implements Serializable {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$TABTITLE$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TABTITLE.Companion {
                private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TABTITLE.Companion() {
                }

                public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TABTITLE.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TABTITLE.Companion Companion = null;
            @b("REPLACETEXT")
            @Nullable
            private String replaceText;
            private static final long serialVersionUID = 0xDD1561D4AE7B3658L;
            @b("TITLE")
            @Nullable
            private String title;

            static {
                TABTITLE.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TABTITLE.Companion(null);
                TABTITLE.$stable = 8;
            }

            @Nullable
            public final String getReplaceText() {
                return this.replaceText;
            }

            @Nullable
            public final String getTitle() {
                return this.title;
            }

            public final void setReplaceText(@Nullable String s) {
                this.replaceText = s;
            }

            public final void setTitle(@Nullable String s) {
                this.title = s;
            }

            @Override
            @NotNull
            public String toString() {
                String s = ToStringUtil.toStringFields(this);
                q.f(s, "toStringFields(...)");
                return s;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$TAG;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$BasicSlot;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$TAG$CONTENTS;", "<init>", "()V", "serialVersionUID", "", "CONTENTS", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class TAG extends BasicSlot {
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR&\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$TAG$CONTENTS;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "tagName", "", "getTagName", "()Ljava/lang/String;", "setTagName", "(Ljava/lang/String;)V", "tagSeq", "getTagSeq", "setTagSeq", "contsTypeCode", "getContsTypeCode", "setContsTypeCode", "imgUrl", "getImgUrl", "setImgUrl", "playLists", "", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$TAGCONTENTS;", "getPlayLists", "()Ljava/util/List;", "setPlayLists", "(Ljava/util/List;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS extends LinkInfoBase {
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$TAG$CONTENTS$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS.Companion {
                    private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS.Companion() {
                    }

                    public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                    }
                }

                public static final int $stable = 0;
                @NotNull
                public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS.Companion Companion = null;
                @b("CONTSTYPECODE")
                @Nullable
                private String contsTypeCode;
                @b("IMGURL")
                @Nullable
                private String imgUrl;
                @b("PLAYLISTS")
                @Nullable
                private List playLists;
                private static final long serialVersionUID = 0x90D2C0FB6F6FC663L;
                @b("TAGNAME")
                @Nullable
                private String tagName;
                @b("TAGSEQ")
                @Nullable
                private String tagSeq;

                static {
                    com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS.Companion(null);
                    com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS.$stable = 8;
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
                public final List getPlayLists() {
                    return this.playLists;
                }

                @Nullable
                public final String getTagName() {
                    return this.tagName;
                }

                @Nullable
                public final String getTagSeq() {
                    return this.tagSeq;
                }

                public final void setContsTypeCode(@Nullable String s) {
                    this.contsTypeCode = s;
                }

                public final void setImgUrl(@Nullable String s) {
                    this.imgUrl = s;
                }

                public final void setPlayLists(@Nullable List list0) {
                    this.playLists = list0;
                }

                public final void setTagName(@Nullable String s) {
                    this.tagName = s;
                }

                public final void setTagSeq(@Nullable String s) {
                    this.tagSeq = s;
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final TAG INSTANCE = null;
            private static final long serialVersionUID = 2070271002516640287L;

            static {
                TAG.INSTANCE = new TAG();
                TAG.$stable = 8;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$TAGCONTENTS;", "Lcom/iloen/melon/net/v4x/common/ContentListInfo;", "<init>", "()V", "linkType", "", "getLinkType", "()Ljava/lang/String;", "setLinkType", "(Ljava/lang/String;)V", "linkUrl", "getLinkUrl", "setLinkUrl", "scheme", "getScheme", "setScheme", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class TAGCONTENTS extends ContentListInfo {
            public static final int $stable = 8;
            @b("LINKTYPE")
            @Nullable
            private String linkType;
            @b("LINKURL")
            @Nullable
            private String linkUrl;
            @b("SCHEME")
            @Nullable
            private String scheme;

            public TAGCONTENTS() {
                this.linkType = "";
                this.linkUrl = "";
                this.scheme = "";
            }

            @Nullable
            public final String getLinkType() [...] // 潜在的解密器

            @Nullable
            public final String getLinkUrl() [...] // 潜在的解密器

            @Nullable
            public final String getScheme() [...] // 潜在的解密器

            public final void setLinkType(@Nullable String s) {
                this.linkType = s;
            }

            public final void setLinkUrl(@Nullable String s) {
                this.linkUrl = s;
            }

            public final void setScheme(@Nullable String s) {
                this.scheme = s;
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$THEME;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$BasicSlot;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$DJCONTENT;", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class THEME extends BasicSlot {
            public static final int $stable = 0;
            @NotNull
            public static final THEME INSTANCE = null;
            private static final long serialVersionUID = 0xDCC3DB59F800CD2BL;

            static {
                THEME.INSTANCE = new THEME();
                THEME.$stable = 8;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$VIDEO;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$BasicSlot;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$VIDEO$CONTENTS;", "<init>", "()V", "serialVersionUID", "", "CONTENTS", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class VIDEO extends BasicSlot {
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$VIDEO$CONTENTS;", "Lcom/melon/net/res/common/MvInfoBase;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "subTitle", "getSubTitle", "setSubTitle", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS extends MvInfoBase {
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$VIDEO$CONTENTS$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS.Companion {
                    private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS.Companion() {
                    }

                    public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                    }
                }

                public static final int $stable = 0;
                @NotNull
                public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS.Companion Companion = null;
                private static final long serialVersionUID = 0x56F118B8BF93B2CCL;
                @b("SUBTITLE")
                @Nullable
                private String subTitle;
                @b("TITLE")
                @Nullable
                private String title;

                static {
                    com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS.Companion(null);
                    com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS.$stable = 8;
                }

                @Nullable
                public final String getSubTitle() {
                    return this.subTitle;
                }

                @Nullable
                public final String getTitle() {
                    return this.title;
                }

                public final void setSubTitle(@Nullable String s) {
                    this.subTitle = s;
                }

                public final void setTitle(@Nullable String s) {
                    this.title = s;
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final VIDEO INSTANCE = null;
            private static final long serialVersionUID = 2070271002516640287L;

            static {
                VIDEO.INSTANCE = new VIDEO();
                VIDEO.$stable = 8;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$WEEKLYDJ;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$BasicSlot;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$WEEKLYDJ$CONTENTS;", "<init>", "()V", "serialVersionUID", "", "CONTENTS", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class WEEKLYDJ extends BasicSlot {
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR\u001E\u0010\r\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001E\u0010\u0012\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u000F\"\u0004\b\u0013\u0010\u0011R \u0010\u0014\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR \u0010\u0017\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR \u0010\u001A\u001A\u0004\u0018\u00010\u001B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001F¨\u0006!"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$WEEKLYDJ$CONTENTS;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "djTitle", "", "getDjTitle", "()Ljava/lang/String;", "setDjTitle", "(Ljava/lang/String;)V", "followerCnt", "getFollowerCnt", "setFollowerCnt", "isOfficial", "", "()Z", "setOfficial", "(Z)V", "isPowerDj", "setPowerDj", "myPageImg", "getMyPageImg", "setMyPageImg", "memberNickName", "getMemberNickName", "setMemberNickName", "playlist", "Lcom/melon/net/res/common/DjPlayListInfoBase;", "getPlaylist", "()Lcom/melon/net/res/common/DjPlayListInfoBase;", "setPlaylist", "(Lcom/melon/net/res/common/DjPlayListInfoBase;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.WEEKLYDJ.CONTENTS extends LinkInfoBase {
                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$WEEKLYDJ$CONTENTS$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public static final class com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.WEEKLYDJ.CONTENTS.Companion {
                    private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.WEEKLYDJ.CONTENTS.Companion() {
                    }

                    public com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.WEEKLYDJ.CONTENTS.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                    }
                }

                public static final int $stable = 0;
                @NotNull
                public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.WEEKLYDJ.CONTENTS.Companion Companion = null;
                @b("DJTITLE")
                @Nullable
                private String djTitle;
                @b("FOLLOWERCNT")
                @Nullable
                private String followerCnt;
                @b("ISOFFICIAL")
                private boolean isOfficial;
                @b("ISPOWERDJ")
                private boolean isPowerDj;
                @b("MEMBERNICKNAME")
                @Nullable
                private String memberNickName;
                @b("MYPAGEIMG")
                @Nullable
                private String myPageImg;
                @b("PLAYLIST")
                @Nullable
                private DjPlayListInfoBase playlist;
                private static final long serialVersionUID = 0x4E0658B81AC9F9F3L;

                static {
                    com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.WEEKLYDJ.CONTENTS.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.WEEKLYDJ.CONTENTS.Companion(null);
                    com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.WEEKLYDJ.CONTENTS.$stable = 8;
                }

                @Nullable
                public final String getDjTitle() {
                    return this.djTitle;
                }

                @Nullable
                public final String getFollowerCnt() {
                    return this.followerCnt;
                }

                @Nullable
                public final String getMemberNickName() {
                    return this.memberNickName;
                }

                @Nullable
                public final String getMyPageImg() {
                    return this.myPageImg;
                }

                @Nullable
                public final DjPlayListInfoBase getPlaylist() {
                    return this.playlist;
                }

                public final boolean isOfficial() {
                    return this.isOfficial;
                }

                public final boolean isPowerDj() {
                    return this.isPowerDj;
                }

                public final void setDjTitle(@Nullable String s) {
                    this.djTitle = s;
                }

                public final void setFollowerCnt(@Nullable String s) {
                    this.followerCnt = s;
                }

                public final void setMemberNickName(@Nullable String s) {
                    this.memberNickName = s;
                }

                public final void setMyPageImg(@Nullable String s) {
                    this.myPageImg = s;
                }

                public final void setOfficial(boolean z) {
                    this.isOfficial = z;
                }

                public final void setPlaylist(@Nullable DjPlayListInfoBase djPlayListInfoBase0) {
                    this.playlist = djPlayListInfoBase0;
                }

                public final void setPowerDj(boolean z) {
                    this.isPowerDj = z;
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final WEEKLYDJ INSTANCE = null;
            private static final long serialVersionUID = 0x4710BEA4E878BF0L;

            static {
                WEEKLYDJ.INSTANCE = new WEEKLYDJ();
                WEEKLYDJ.$stable = 8;
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.Companion Companion = null;
        @b("CHARTSHORTCUT")
        @Nullable
        private CHARTSHORTCUT chartShortcut;
        @b("CHEERBOARD")
        @Nullable
        private CHEERBOARD cheerboard;
        @b("DAILY")
        @Nullable
        private THEME daily;
        @b("DJ")
        @Nullable
        private DJ dj;
        @b("FOOTER")
        @Nullable
        private FOOTER footer;
        @b("LOGO")
        @Nullable
        private LOGO logo;
        @b("MAGAZINE")
        @Nullable
        private MAGAZINE magazine;
        @b("MELONCHART")
        @Nullable
        private MELONCHART melonChart;
        @b("MY24HITS")
        @Nullable
        private com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST my24Hits;
        @b("NEWALBUM")
        @Nullable
        private NEWALBUM newAlbums;
        @b("POPULARSONG")
        @Nullable
        private POPULARSONG popularSong;
        private static final long serialVersionUID = 0x2AF70C8A0B517CAFL;
        @b("SLOTDPLIST")
        @Nullable
        private List slotDpList;
        @b("STATSELEMENTS")
        @Nullable
        private STATSELEMENTS statsElements;
        @b("STRATEGY")
        @Nullable
        private STRATEGY strategy;
        @b("TABTITLE")
        @Nullable
        private TABTITLE tabTitle;
        @b("TAG")
        @Nullable
        private TAG tag;
        @b("THEME")
        @Nullable
        private THEME theme;
        @b("THEMESUB1")
        @Nullable
        private THEME themesub1;
        @b("THEMESUB2")
        @Nullable
        private THEME themesub2;
        @b("VIDEO1")
        @Nullable
        private VIDEO video_1;
        @b("VIDEO2")
        @Nullable
        private VIDEO video_2;
        @b("VIDEO3")
        @Nullable
        private VIDEO video_3;
        @b("VIPMEMBERSHIP")
        @Nullable
        private LinkInfoBase vipMembership;
        @b("WEEKLYDJ")
        @Nullable
        private WEEKLYDJ weeklyDj;

        static {
            RESPONSE.Companion = new com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.Companion(null);
            RESPONSE.$stable = 8;
        }

        @Nullable
        public final CHARTSHORTCUT getChartShortcut() {
            return this.chartShortcut;
        }

        @Nullable
        public final CHEERBOARD getCheerboard() {
            return this.cheerboard;
        }

        @Nullable
        public final THEME getDaily() {
            return this.daily;
        }

        @Nullable
        public final DJ getDj() {
            return this.dj;
        }

        @Nullable
        public final FOOTER getFooter() {
            return this.footer;
        }

        @Nullable
        public final LOGO getLogo() {
            return this.logo;
        }

        @Nullable
        public final MAGAZINE getMagazine() {
            return this.magazine;
        }

        @Nullable
        public final MELONCHART getMelonChart() {
            return this.melonChart;
        }

        @Nullable
        public final com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST getMy24Hits() {
            return this.my24Hits;
        }

        @Nullable
        public final NEWALBUM getNewAlbums() {
            return this.newAlbums;
        }

        @Nullable
        public final POPULARSONG getPopularSong() {
            return this.popularSong;
        }

        @Nullable
        public final List getSlotDpList() {
            return this.slotDpList;
        }

        @Nullable
        public final STATSELEMENTS getStatsElements() {
            return this.statsElements;
        }

        @Nullable
        public final STRATEGY getStrategy() {
            return this.strategy;
        }

        @Nullable
        public final TABTITLE getTabTitle() {
            return this.tabTitle;
        }

        @Nullable
        public final TAG getTag() {
            return this.tag;
        }

        @Nullable
        public final THEME getTheme() {
            return this.theme;
        }

        @Nullable
        public final THEME getThemesub1() {
            return this.themesub1;
        }

        @Nullable
        public final THEME getThemesub2() {
            return this.themesub2;
        }

        @Nullable
        public final VIDEO getVideo_1() {
            return this.video_1;
        }

        @Nullable
        public final VIDEO getVideo_2() {
            return this.video_2;
        }

        @Nullable
        public final VIDEO getVideo_3() {
            return this.video_3;
        }

        @Nullable
        public final LinkInfoBase getVipMembership() {
            return this.vipMembership;
        }

        @Nullable
        public final WEEKLYDJ getWeeklyDj() {
            return this.weeklyDj;
        }

        public final void setChartShortcut(@Nullable CHARTSHORTCUT mainMusicRes$RESPONSE$CHARTSHORTCUT0) {
            this.chartShortcut = mainMusicRes$RESPONSE$CHARTSHORTCUT0;
        }

        public final void setCheerboard(@Nullable CHEERBOARD mainMusicRes$RESPONSE$CHEERBOARD0) {
            this.cheerboard = mainMusicRes$RESPONSE$CHEERBOARD0;
        }

        public final void setDaily(@Nullable THEME mainMusicRes$RESPONSE$THEME0) {
            this.daily = mainMusicRes$RESPONSE$THEME0;
        }

        public final void setDj(@Nullable DJ mainMusicRes$RESPONSE$DJ0) {
            this.dj = mainMusicRes$RESPONSE$DJ0;
        }

        public final void setFooter(@Nullable FOOTER mainMusicRes$RESPONSE$FOOTER0) {
            this.footer = mainMusicRes$RESPONSE$FOOTER0;
        }

        public final void setLogo(@Nullable LOGO mainMusicRes$RESPONSE$LOGO0) {
            this.logo = mainMusicRes$RESPONSE$LOGO0;
        }

        public final void setMagazine(@Nullable MAGAZINE mainMusicRes$RESPONSE$MAGAZINE0) {
            this.magazine = mainMusicRes$RESPONSE$MAGAZINE0;
        }

        public final void setMelonChart(@Nullable MELONCHART mainMusicRes$RESPONSE$MELONCHART0) {
            this.melonChart = mainMusicRes$RESPONSE$MELONCHART0;
        }

        public final void setMy24Hits(@Nullable com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.SONGLIST mainMusicRes$RESPONSE$SONGLIST0) {
            this.my24Hits = mainMusicRes$RESPONSE$SONGLIST0;
        }

        public final void setNewAlbums(@Nullable NEWALBUM mainMusicRes$RESPONSE$NEWALBUM0) {
            this.newAlbums = mainMusicRes$RESPONSE$NEWALBUM0;
        }

        public final void setPopularSong(@Nullable POPULARSONG mainMusicRes$RESPONSE$POPULARSONG0) {
            this.popularSong = mainMusicRes$RESPONSE$POPULARSONG0;
        }

        public final void setSlotDpList(@Nullable List list0) {
            this.slotDpList = list0;
        }

        public final void setStatsElements(@Nullable STATSELEMENTS mainMusicRes$RESPONSE$STATSELEMENTS0) {
            this.statsElements = mainMusicRes$RESPONSE$STATSELEMENTS0;
        }

        public final void setStrategy(@Nullable STRATEGY mainMusicRes$RESPONSE$STRATEGY0) {
            this.strategy = mainMusicRes$RESPONSE$STRATEGY0;
        }

        public final void setTabTitle(@Nullable TABTITLE mainMusicRes$RESPONSE$TABTITLE0) {
            this.tabTitle = mainMusicRes$RESPONSE$TABTITLE0;
        }

        public final void setTag(@Nullable TAG mainMusicRes$RESPONSE$TAG0) {
            this.tag = mainMusicRes$RESPONSE$TAG0;
        }

        public final void setTheme(@Nullable THEME mainMusicRes$RESPONSE$THEME0) {
            this.theme = mainMusicRes$RESPONSE$THEME0;
        }

        public final void setThemesub1(@Nullable THEME mainMusicRes$RESPONSE$THEME0) {
            this.themesub1 = mainMusicRes$RESPONSE$THEME0;
        }

        public final void setThemesub2(@Nullable THEME mainMusicRes$RESPONSE$THEME0) {
            this.themesub2 = mainMusicRes$RESPONSE$THEME0;
        }

        public final void setVideo_1(@Nullable VIDEO mainMusicRes$RESPONSE$VIDEO0) {
            this.video_1 = mainMusicRes$RESPONSE$VIDEO0;
        }

        public final void setVideo_2(@Nullable VIDEO mainMusicRes$RESPONSE$VIDEO0) {
            this.video_2 = mainMusicRes$RESPONSE$VIDEO0;
        }

        public final void setVideo_3(@Nullable VIDEO mainMusicRes$RESPONSE$VIDEO0) {
            this.video_3 = mainMusicRes$RESPONSE$VIDEO0;
        }

        public final void setVipMembership(@Nullable LinkInfoBase linkInfoBase0) {
            this.vipMembership = linkInfoBase0;
        }

        public final void setWeeklyDj(@Nullable WEEKLYDJ mainMusicRes$RESPONSE$WEEKLYDJ0) {
            this.weeklyDj = mainMusicRes$RESPONSE$WEEKLYDJ0;
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
    private RESPONSE response;
    private static final long serialVersionUID = 7391410000421085937L;

    static {
        MainMusicRes.Companion = new Companion(null);
        MainMusicRes.$stable = 8;
    }

    @Override  // com.iloen.melon.net.HttpResponse
    @NotNull
    public String getMenuId() {
        RESPONSE mainMusicRes$RESPONSE0 = this.response;
        if(mainMusicRes$RESPONSE0 != null) {
            return mainMusicRes$RESPONSE0.menuId == null ? "" : mainMusicRes$RESPONSE0.menuId;
        }
        return "";
    }

    @Nullable
    public final RESPONSE getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable RESPONSE mainMusicRes$RESPONSE0) {
        this.response = mainMusicRes$RESPONSE0;
    }
}

