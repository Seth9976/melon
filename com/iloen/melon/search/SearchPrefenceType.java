package com.iloen.melon.search;

import A7.d;
import U4.x;
import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/search/SearchPrefenceType;", "", "<init>", "()V", "SearchHistoryForWebView", "SearchVisitHistoryForWebView", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SearchPrefenceType {
    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\u0004\u0012\b\b\u0002\u0010\n\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001A\u00020\bHÆ\u0003J\t\u0010\u001A\u001A\u00020\u0004HÆ\u0003J\t\u0010\u001B\u001A\u00020\bHÆ\u0003JK\u0010\u001C\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\u00042\b\b\u0002\u0010\n\u001A\u00020\bHÆ\u0001J\u0013\u0010\u001D\u001A\u00020\u001E2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001A\u00020\bHÖ\u0001J\t\u0010!\u001A\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0005\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0006\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0013¨\u0006\""}, d2 = {"Lcom/iloen/melon/search/SearchPrefenceType$SearchHistoryForWebView;", "", "searchWordList", "", "", "searchLastWord", "snsGate", "searchMenuIndexNav", "", "searchMenuIndexSort", "searchStartMenuIndex", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "getSearchWordList", "()Ljava/util/List;", "getSearchLastWord", "()Ljava/lang/String;", "getSnsGate", "getSearchMenuIndexNav", "()I", "getSearchMenuIndexSort", "getSearchStartMenuIndex", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SearchHistoryForWebView {
        public static final int $stable = 8;
        @NotNull
        private final String searchLastWord;
        private final int searchMenuIndexNav;
        @NotNull
        private final String searchMenuIndexSort;
        private final int searchStartMenuIndex;
        @NotNull
        private final List searchWordList;
        @NotNull
        private final String snsGate;

        public SearchHistoryForWebView(@NotNull List list0, @NotNull String s, @NotNull String s1, int v, @NotNull String s2, int v1) {
            q.g(list0, "searchWordList");
            q.g(s, "searchLastWord");
            q.g(s1, "snsGate");
            q.g(s2, "searchMenuIndexSort");
            super();
            this.searchWordList = list0;
            this.searchLastWord = s;
            this.snsGate = s1;
            this.searchMenuIndexNav = v;
            this.searchMenuIndexSort = s2;
            this.searchStartMenuIndex = v1;
        }

        public SearchHistoryForWebView(List list0, String s, String s1, int v, String s2, int v1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v2 & 2) != 0) {
                s = "";
            }
            if((v2 & 4) != 0) {
                s1 = "";
            }
            if((v2 & 8) != 0) {
                v = 0;
            }
            if((v2 & 16) != 0) {
                s2 = "";
            }
            this(list0, s, s1, v, s2, ((v2 & 0x20) == 0 ? v1 : 0));
        }

        @NotNull
        public final List component1() {
            return this.searchWordList;
        }

        @NotNull
        public final String component2() {
            return this.searchLastWord;
        }

        @NotNull
        public final String component3() {
            return this.snsGate;
        }

        public final int component4() {
            return this.searchMenuIndexNav;
        }

        @NotNull
        public final String component5() {
            return this.searchMenuIndexSort;
        }

        public final int component6() {
            return this.searchStartMenuIndex;
        }

        @NotNull
        public final SearchHistoryForWebView copy(@NotNull List list0, @NotNull String s, @NotNull String s1, int v, @NotNull String s2, int v1) {
            q.g(list0, "searchWordList");
            q.g(s, "searchLastWord");
            q.g(s1, "snsGate");
            q.g(s2, "searchMenuIndexSort");
            return new SearchHistoryForWebView(list0, s, s1, v, s2, v1);
        }

        public static SearchHistoryForWebView copy$default(SearchHistoryForWebView searchPrefenceType$SearchHistoryForWebView0, List list0, String s, String s1, int v, String s2, int v1, int v2, Object object0) {
            if((v2 & 1) != 0) {
                list0 = searchPrefenceType$SearchHistoryForWebView0.searchWordList;
            }
            if((v2 & 2) != 0) {
                s = searchPrefenceType$SearchHistoryForWebView0.searchLastWord;
            }
            if((v2 & 4) != 0) {
                s1 = searchPrefenceType$SearchHistoryForWebView0.snsGate;
            }
            if((v2 & 8) != 0) {
                v = searchPrefenceType$SearchHistoryForWebView0.searchMenuIndexNav;
            }
            if((v2 & 16) != 0) {
                s2 = searchPrefenceType$SearchHistoryForWebView0.searchMenuIndexSort;
            }
            if((v2 & 0x20) != 0) {
                v1 = searchPrefenceType$SearchHistoryForWebView0.searchStartMenuIndex;
            }
            return searchPrefenceType$SearchHistoryForWebView0.copy(list0, s, s1, v, s2, v1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof SearchHistoryForWebView)) {
                return false;
            }
            if(!q.b(this.searchWordList, ((SearchHistoryForWebView)object0).searchWordList)) {
                return false;
            }
            if(!q.b(this.searchLastWord, ((SearchHistoryForWebView)object0).searchLastWord)) {
                return false;
            }
            if(!q.b(this.snsGate, ((SearchHistoryForWebView)object0).snsGate)) {
                return false;
            }
            if(this.searchMenuIndexNav != ((SearchHistoryForWebView)object0).searchMenuIndexNav) {
                return false;
            }
            return q.b(this.searchMenuIndexSort, ((SearchHistoryForWebView)object0).searchMenuIndexSort) ? this.searchStartMenuIndex == ((SearchHistoryForWebView)object0).searchStartMenuIndex : false;
        }

        @NotNull
        public final String getSearchLastWord() {
            return this.searchLastWord;
        }

        public final int getSearchMenuIndexNav() {
            return this.searchMenuIndexNav;
        }

        @NotNull
        public final String getSearchMenuIndexSort() {
            return this.searchMenuIndexSort;
        }

        public final int getSearchStartMenuIndex() {
            return this.searchStartMenuIndex;
        }

        @NotNull
        public final List getSearchWordList() {
            return this.searchWordList;
        }

        @NotNull
        public final String getSnsGate() {
            return this.snsGate;
        }

        @Override
        public int hashCode() {
            return this.searchStartMenuIndex + x.b(d.b(this.searchMenuIndexNav, x.b(x.b(this.searchWordList.hashCode() * 0x1F, 0x1F, this.searchLastWord), 0x1F, this.snsGate), 0x1F), 0x1F, this.searchMenuIndexSort);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("SearchHistoryForWebView(searchWordList=");
            stringBuilder0.append(this.searchWordList);
            stringBuilder0.append(", searchLastWord=");
            stringBuilder0.append(this.searchLastWord);
            stringBuilder0.append(", snsGate=");
            d.t(stringBuilder0, this.snsGate, ", searchMenuIndexNav=", this.searchMenuIndexNav, ", searchMenuIndexSort=");
            stringBuilder0.append(this.searchMenuIndexSort);
            stringBuilder0.append(", searchStartMenuIndex=");
            stringBuilder0.append(this.searchStartMenuIndex);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u000F\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0012\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u0001;B\u0089\u0001\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0002\u0012\b\b\u0002\u0010\b\u001A\u00020\u0002\u0012\b\b\u0002\u0010\t\u001A\u00020\u0002\u0012\b\b\u0002\u0010\n\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0002\u0012\b\b\u0002\u0010\f\u001A\u00020\u0002\u0012\b\b\u0002\u0010\r\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001A\u00020\u0012\u00A2\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u0019\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u0017J\u0010\u0010\u001A\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u0017J\u0010\u0010\u001B\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u0017J\u0010\u0010\u001C\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u0017J\u0010\u0010\u001D\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u0017J\u0010\u0010\u001E\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u0017J\u0010\u0010\u001F\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010\u0017J\u0010\u0010 \u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b \u0010\u0017J\u0010\u0010!\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\u0017J\u0010\u0010\"\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\"\u0010\u0017J\u0010\u0010#\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b#\u0010\u0017J\u0092\u0001\u0010$\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00022\b\b\u0002\u0010\u0007\u001A\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\u00022\b\b\u0002\u0010\n\u001A\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\u00022\b\b\u0002\u0010\f\u001A\u00020\u00022\b\b\u0002\u0010\r\u001A\u00020\u00022\b\b\u0002\u0010\u000E\u001A\u00020\u00022\b\b\u0002\u0010\u000F\u001A\u00020\u0002H\u00C6\u0001\u00A2\u0006\u0004\b$\u0010%J\u0010\u0010&\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b&\u0010\u0017J\u0010\u0010\'\u001A\u00020\u0012H\u00D6\u0001\u00A2\u0006\u0004\b\'\u0010\u0014J\u001A\u0010+\u001A\u00020*2\b\u0010)\u001A\u0004\u0018\u00010(H\u00D6\u0003\u00A2\u0006\u0004\b+\u0010,R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010-\u001A\u0004\b\u0013\u0010\u0017R\u0017\u0010\u0004\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010-\u001A\u0004\b.\u0010\u0017R\u0017\u0010\u0005\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010-\u001A\u0004\b/\u0010\u0017R\u0017\u0010\u0006\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010-\u001A\u0004\b0\u0010\u0017R\u0017\u0010\u0007\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010-\u001A\u0004\b1\u0010\u0017R\u0017\u0010\b\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\b\u0010-\u001A\u0004\b2\u0010\u0017R\u0017\u0010\t\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\t\u0010-\u001A\u0004\b3\u0010\u0017R\u0017\u0010\n\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\n\u0010-\u001A\u0004\b4\u0010\u0017R\u0017\u0010\u000B\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010-\u001A\u0004\b5\u0010\u0017R\u0017\u0010\f\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\f\u0010-\u001A\u0004\b6\u0010\u0017R\u0017\u0010\r\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\r\u0010-\u001A\u0004\b7\u0010\u0017R\u0017\u0010\u000E\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u000E\u0010-\u001A\u0004\b8\u0010\u0017R\u0017\u0010\u000F\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u000F\u0010-\u001A\u0004\b9\u0010\u0017\u00A8\u0006<"}, d2 = {"Lcom/iloen/melon/search/SearchPrefenceType$SearchVisitHistoryForWebView;", "Ls9/a;", "", "contentType", "albumId", "albumName", "albumImage", "songId", "songName", "artistId", "artistName", "artistImage", "playlistSeq", "playlistTitle", "playlistRepresentImage", "likeCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "getContentType", "()I", "getVisitHistoryType", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/iloen/melon/search/SearchPrefenceType$SearchVisitHistoryForWebView;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAlbumId", "getAlbumName", "getAlbumImage", "getSongId", "getSongName", "getArtistId", "getArtistName", "getArtistImage", "getPlaylistSeq", "getPlaylistTitle", "getPlaylistRepresentImage", "getLikeCount", "Companion", "com/iloen/melon/search/a", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SearchVisitHistoryForWebView implements a {
        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.search.a Companion = null;
        public static final int TYPE_ALBUM = 1;
        public static final int TYPE_ARTIST = 2;
        public static final int TYPE_ERROR = -1;
        public static final int TYPE_PLAYLIST = 3;
        public static final int TYPE_SONG;
        @NotNull
        private final String albumId;
        @NotNull
        private final String albumImage;
        @NotNull
        private final String albumName;
        @NotNull
        private final String artistId;
        @NotNull
        private final String artistImage;
        @NotNull
        private final String artistName;
        @NotNull
        private final String contentType;
        @NotNull
        private final String likeCount;
        @NotNull
        private final String playlistRepresentImage;
        @NotNull
        private final String playlistSeq;
        @NotNull
        private final String playlistTitle;
        @NotNull
        private final String songId;
        @NotNull
        private final String songName;

        static {
            SearchVisitHistoryForWebView.Companion = new com.iloen.melon.search.a();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SearchVisitHistoryForWebView() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, 0x1FFF, null);
        }

        public SearchVisitHistoryForWebView(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, @NotNull String s8, @NotNull String s9, @NotNull String s10, @NotNull String s11, @NotNull String s12) {
            q.g(s, "contentType");
            q.g(s1, "albumId");
            q.g(s2, "albumName");
            q.g(s3, "albumImage");
            q.g(s4, "songId");
            q.g(s5, "songName");
            q.g(s6, "artistId");
            q.g(s7, "artistName");
            q.g(s8, "artistImage");
            q.g(s9, "playlistSeq");
            q.g(s10, "playlistTitle");
            q.g(s11, "playlistRepresentImage");
            q.g(s12, "likeCount");
            super();
            this.contentType = s;
            this.albumId = s1;
            this.albumName = s2;
            this.albumImage = s3;
            this.songId = s4;
            this.songName = s5;
            this.artistId = s6;
            this.artistName = s7;
            this.artistImage = s8;
            this.playlistSeq = s9;
            this.playlistTitle = s10;
            this.playlistRepresentImage = s11;
            this.likeCount = s12;
        }

        public SearchVisitHistoryForWebView(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = "";
            }
            this(s, ((v & 2) == 0 ? s1 : ""), ((v & 4) == 0 ? s2 : ""), ((v & 8) == 0 ? s3 : ""), ((v & 16) == 0 ? s4 : ""), ((v & 0x20) == 0 ? s5 : ""), ((v & 0x40) == 0 ? s6 : ""), ((v & 0x80) == 0 ? s7 : ""), ((v & 0x100) == 0 ? s8 : ""), ((v & 0x200) == 0 ? s9 : ""), ((v & 0x400) == 0 ? s10 : ""), ((v & 0x800) == 0 ? s11 : ""), ((v & 0x1000) == 0 ? s12 : ""));
        }

        @NotNull
        public final String component1() {
            return this.contentType;
        }

        @NotNull
        public final String component10() {
            return this.playlistSeq;
        }

        @NotNull
        public final String component11() {
            return this.playlistTitle;
        }

        @NotNull
        public final String component12() {
            return this.playlistRepresentImage;
        }

        @NotNull
        public final String component13() {
            return this.likeCount;
        }

        @NotNull
        public final String component2() {
            return this.albumId;
        }

        @NotNull
        public final String component3() {
            return this.albumName;
        }

        @NotNull
        public final String component4() {
            return this.albumImage;
        }

        @NotNull
        public final String component5() {
            return this.songId;
        }

        @NotNull
        public final String component6() {
            return this.songName;
        }

        @NotNull
        public final String component7() {
            return this.artistId;
        }

        @NotNull
        public final String component8() {
            return this.artistName;
        }

        @NotNull
        public final String component9() {
            return this.artistImage;
        }

        @NotNull
        public final SearchVisitHistoryForWebView copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, @NotNull String s8, @NotNull String s9, @NotNull String s10, @NotNull String s11, @NotNull String s12) {
            q.g(s, "contentType");
            q.g(s1, "albumId");
            q.g(s2, "albumName");
            q.g(s3, "albumImage");
            q.g(s4, "songId");
            q.g(s5, "songName");
            q.g(s6, "artistId");
            q.g(s7, "artistName");
            q.g(s8, "artistImage");
            q.g(s9, "playlistSeq");
            q.g(s10, "playlistTitle");
            q.g(s11, "playlistRepresentImage");
            q.g(s12, "likeCount");
            return new SearchVisitHistoryForWebView(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12);
        }

        public static SearchVisitHistoryForWebView copy$default(SearchVisitHistoryForWebView searchPrefenceType$SearchVisitHistoryForWebView0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, int v, Object object0) {
            if((v & 1) != 0) {
                s = searchPrefenceType$SearchVisitHistoryForWebView0.contentType;
            }
            String s13 = (v & 2) == 0 ? s1 : searchPrefenceType$SearchVisitHistoryForWebView0.albumId;
            String s14 = (v & 4) == 0 ? s2 : searchPrefenceType$SearchVisitHistoryForWebView0.albumName;
            String s15 = (v & 8) == 0 ? s3 : searchPrefenceType$SearchVisitHistoryForWebView0.albumImage;
            String s16 = (v & 16) == 0 ? s4 : searchPrefenceType$SearchVisitHistoryForWebView0.songId;
            String s17 = (v & 0x20) == 0 ? s5 : searchPrefenceType$SearchVisitHistoryForWebView0.songName;
            String s18 = (v & 0x40) == 0 ? s6 : searchPrefenceType$SearchVisitHistoryForWebView0.artistId;
            String s19 = (v & 0x80) == 0 ? s7 : searchPrefenceType$SearchVisitHistoryForWebView0.artistName;
            String s20 = (v & 0x100) == 0 ? s8 : searchPrefenceType$SearchVisitHistoryForWebView0.artistImage;
            String s21 = (v & 0x200) == 0 ? s9 : searchPrefenceType$SearchVisitHistoryForWebView0.playlistSeq;
            String s22 = (v & 0x400) == 0 ? s10 : searchPrefenceType$SearchVisitHistoryForWebView0.playlistTitle;
            String s23 = (v & 0x800) == 0 ? s11 : searchPrefenceType$SearchVisitHistoryForWebView0.playlistRepresentImage;
            return (v & 0x1000) == 0 ? searchPrefenceType$SearchVisitHistoryForWebView0.copy(s, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s12) : searchPrefenceType$SearchVisitHistoryForWebView0.copy(s, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, searchPrefenceType$SearchVisitHistoryForWebView0.likeCount);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof SearchVisitHistoryForWebView)) {
                return false;
            }
            if(!q.b(this.contentType, ((SearchVisitHistoryForWebView)object0).contentType)) {
                return false;
            }
            if(!q.b(this.albumId, ((SearchVisitHistoryForWebView)object0).albumId)) {
                return false;
            }
            if(!q.b(this.albumName, ((SearchVisitHistoryForWebView)object0).albumName)) {
                return false;
            }
            if(!q.b(this.albumImage, ((SearchVisitHistoryForWebView)object0).albumImage)) {
                return false;
            }
            if(!q.b(this.songId, ((SearchVisitHistoryForWebView)object0).songId)) {
                return false;
            }
            if(!q.b(this.songName, ((SearchVisitHistoryForWebView)object0).songName)) {
                return false;
            }
            if(!q.b(this.artistId, ((SearchVisitHistoryForWebView)object0).artistId)) {
                return false;
            }
            if(!q.b(this.artistName, ((SearchVisitHistoryForWebView)object0).artistName)) {
                return false;
            }
            if(!q.b(this.artistImage, ((SearchVisitHistoryForWebView)object0).artistImage)) {
                return false;
            }
            if(!q.b(this.playlistSeq, ((SearchVisitHistoryForWebView)object0).playlistSeq)) {
                return false;
            }
            if(!q.b(this.playlistTitle, ((SearchVisitHistoryForWebView)object0).playlistTitle)) {
                return false;
            }
            return q.b(this.playlistRepresentImage, ((SearchVisitHistoryForWebView)object0).playlistRepresentImage) ? q.b(this.likeCount, ((SearchVisitHistoryForWebView)object0).likeCount) : false;
        }

        @NotNull
        public final String getAlbumId() {
            return this.albumId;
        }

        @NotNull
        public final String getAlbumImage() {
            return this.albumImage;
        }

        @NotNull
        public final String getAlbumName() {
            return this.albumName;
        }

        @NotNull
        public final String getArtistId() {
            return this.artistId;
        }

        @NotNull
        public final String getArtistImage() {
            return this.artistImage;
        }

        @NotNull
        public final String getArtistName() {
            return this.artistName;
        }

        @Override  // s9.a
        public int getContentType() {
            return 1;
        }

        @NotNull
        public final String getContentType() {
            return this.contentType;
        }

        @NotNull
        public final String getLikeCount() {
            return this.likeCount;
        }

        @NotNull
        public final String getPlaylistRepresentImage() {
            return this.playlistRepresentImage;
        }

        @NotNull
        public final String getPlaylistSeq() {
            return this.playlistSeq;
        }

        @NotNull
        public final String getPlaylistTitle() {
            return this.playlistTitle;
        }

        @NotNull
        public final String getSongId() {
            return this.songId;
        }

        @NotNull
        public final String getSongName() {
            return this.songName;
        }

        public final int getVisitHistoryType() {
            if(this.songId.length() > 0) {
                return 0;
            }
            if(this.albumId.length() > 0) {
                return 1;
            }
            if(this.artistId.length() > 0) {
                return 2;
            }
            return this.playlistSeq.length() <= 0 ? -1 : 3;
        }

        @Override
        public int hashCode() {
            return this.likeCount.hashCode() + x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(this.contentType.hashCode() * 0x1F, 0x1F, this.albumId), 0x1F, this.albumName), 0x1F, this.albumImage), 0x1F, this.songId), 0x1F, this.songName), 0x1F, this.artistId), 0x1F, this.artistName), 0x1F, this.artistImage), 0x1F, this.playlistSeq), 0x1F, this.playlistTitle), 0x1F, this.playlistRepresentImage);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("SearchVisitHistoryForWebView(contentType=", this.contentType, ", albumId=", this.albumId, ", albumName=");
            d.u(stringBuilder0, this.albumName, ", albumImage=", this.albumImage, ", songId=");
            d.u(stringBuilder0, this.songId, ", songName=", this.songName, ", artistId=");
            d.u(stringBuilder0, this.artistId, ", artistName=", this.artistName, ", artistImage=");
            d.u(stringBuilder0, this.artistImage, ", playlistSeq=", this.playlistSeq, ", playlistTitle=");
            d.u(stringBuilder0, this.playlistTitle, ", playlistRepresentImage=", this.playlistRepresentImage, ", likeCount=");
            return x.m(stringBuilder0, this.likeCount, ")");
        }
    }

    static {
    }
}

