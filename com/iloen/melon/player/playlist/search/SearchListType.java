package com.iloen.melon.player.playlist.search;

import A7.d;
import U4.x;
import android.net.Uri;
import androidx.appcompat.app.o;
import com.iloen.melon.playback.Playable;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pb.b;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/player/playlist/search/SearchListType;", "", "SearchWrapperPlayable", "EmptyViewType", "FooterType", "Lcom/iloen/melon/player/playlist/search/SearchListType$EmptyViewType;", "Lcom/iloen/melon/player/playlist/search/SearchListType$FooterType;", "Lcom/iloen/melon/player/playlist/search/SearchListType$SearchWrapperPlayable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class SearchListType {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\fJ.\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0011\u001A\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001A\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001A\u0010\u0018\u001A\u00020\u00042\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\nR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u0005\u0010\fR\u0017\u0010\u0006\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001F\u0010\u001E\u001A\u0004\b\u0006\u0010\f¨\u0006 "}, d2 = {"Lcom/iloen/melon/player/playlist/search/SearchListType$EmptyViewType;", "Lcom/iloen/melon/player/playlist/search/SearchListType;", "Lcom/iloen/melon/player/playlist/search/SearchEmptyViewTextType;", "textType", "", "isPlaylistEmpty", "isDone", "<init>", "(Lcom/iloen/melon/player/playlist/search/SearchEmptyViewTextType;ZZ)V", "component1", "()Lcom/iloen/melon/player/playlist/search/SearchEmptyViewTextType;", "component2", "()Z", "component3", "copy", "(Lcom/iloen/melon/player/playlist/search/SearchEmptyViewTextType;ZZ)Lcom/iloen/melon/player/playlist/search/SearchListType$EmptyViewType;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/player/playlist/search/SearchEmptyViewTextType;", "getTextType", "b", "Z", "c", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class EmptyViewType extends SearchListType {
        public static final int $stable;
        public final SearchEmptyViewTextType a;
        public final boolean b;
        public final boolean c;

        public EmptyViewType(@NotNull SearchEmptyViewTextType searchEmptyViewTextType0, boolean z, boolean z1) {
            q.g(searchEmptyViewTextType0, "textType");
            super(null);
            this.a = searchEmptyViewTextType0;
            this.b = z;
            this.c = z1;
        }

        @NotNull
        public final SearchEmptyViewTextType component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        @NotNull
        public final EmptyViewType copy(@NotNull SearchEmptyViewTextType searchEmptyViewTextType0, boolean z, boolean z1) {
            q.g(searchEmptyViewTextType0, "textType");
            return new EmptyViewType(searchEmptyViewTextType0, z, z1);
        }

        public static EmptyViewType copy$default(EmptyViewType searchListType$EmptyViewType0, SearchEmptyViewTextType searchEmptyViewTextType0, boolean z, boolean z1, int v, Object object0) {
            if((v & 1) != 0) {
                searchEmptyViewTextType0 = searchListType$EmptyViewType0.a;
            }
            if((v & 2) != 0) {
                z = searchListType$EmptyViewType0.b;
            }
            if((v & 4) != 0) {
                z1 = searchListType$EmptyViewType0.c;
            }
            return searchListType$EmptyViewType0.copy(searchEmptyViewTextType0, z, z1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof EmptyViewType)) {
                return false;
            }
            if(this.a != ((EmptyViewType)object0).a) {
                return false;
            }
            return this.b == ((EmptyViewType)object0).b ? this.c == ((EmptyViewType)object0).c : false;
        }

        @NotNull
        public final SearchEmptyViewTextType getTextType() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.c) + d.e(this.a.hashCode() * 0x1F, 0x1F, this.b);
        }

        public final boolean isDone() {
            return this.c;
        }

        public final boolean isPlaylistEmpty() {
            return this.b;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("EmptyViewType(textType=");
            stringBuilder0.append(this.a);
            stringBuilder0.append(", isPlaylistEmpty=");
            stringBuilder0.append(this.b);
            stringBuilder0.append(", isDone=");
            return o.s(stringBuilder0, this.c, ")");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/search/SearchListType$FooterType;", "Lcom/iloen/melon/player/playlist/search/SearchListType;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class FooterType extends SearchListType {
        public static final int $stable;
        @NotNull
        public static final FooterType INSTANCE;

        static {
            FooterType.INSTANCE = new FooterType(null);  // 初始化器: Lcom/iloen/melon/player/playlist/search/SearchListType;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof FooterType;
        }

        @Override
        public int hashCode() {
            return 0x908A204D;
        }

        @Override
        @NotNull
        public String toString() {
            return "FooterType";
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001C\n\u0002\u0010\u0000\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\b\u0010\t\u001A\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001A\u00020\u0006\u0012\u0006\u0010\u000B\u001A\u00020\u0006\u0012\u0006\u0010\f\u001A\u00020\u0006\u0012\u0006\u0010\r\u001A\u00020\u0006\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0014\u001A\u00020\u0013\u0012\u0006\u0010\u0016\u001A\u00020\u0015\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001AJ\u0010\u0010\u001C\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001AJ\u0010\u0010\u001D\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0012\u0010\u001F\u001A\u0004\u0018\u00010\bH\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010 J\u0010\u0010!\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\u001EJ\u0010\u0010\"\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\"\u0010\u001EJ\u0010\u0010#\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b#\u0010\u001EJ\u0010\u0010$\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b$\u0010\u001EJ\u0012\u0010%\u001A\u0004\u0018\u00010\u000EH\u00C6\u0003\u00A2\u0006\u0004\b%\u0010&J\u0012\u0010\'\u001A\u0004\u0018\u00010\u0010H\u00C6\u0003\u00A2\u0006\u0004\b\'\u0010(J\u0012\u0010)\u001A\u0004\u0018\u00010\u0010H\u00C6\u0003\u00A2\u0006\u0004\b)\u0010(J\u0010\u0010*\u001A\u00020\u0013H\u00C6\u0003\u00A2\u0006\u0004\b*\u0010+J\u0010\u0010,\u001A\u00020\u0015H\u00C6\u0003\u00A2\u0006\u0004\b,\u0010-J\u00A4\u0001\u0010.\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00022\b\b\u0002\u0010\u0007\u001A\u00020\u00062\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001A\u00020\u00062\b\b\u0002\u0010\u000B\u001A\u00020\u00062\b\b\u0002\u0010\f\u001A\u00020\u00062\b\b\u0002\u0010\r\u001A\u00020\u00062\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0014\u001A\u00020\u00132\b\b\u0002\u0010\u0016\u001A\u00020\u0015H\u00C6\u0001\u00A2\u0006\u0004\b.\u0010/J\u0010\u00100\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b0\u0010\u001AJ\u0010\u00101\u001A\u00020\u0015H\u00D6\u0001\u00A2\u0006\u0004\b1\u0010-J\u001A\u00104\u001A\u00020\u00062\b\u00103\u001A\u0004\u0018\u000102H\u00D6\u0003\u00A2\u0006\u0004\b4\u00105R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b6\u00107\u001A\u0004\b8\u0010\u001AR\u0017\u0010\u0004\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b9\u00107\u001A\u0004\b:\u0010\u001AR\u0017\u0010\u0005\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b;\u00107\u001A\u0004\b<\u0010\u001AR\u0017\u0010\u0007\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b=\u0010>\u001A\u0004\b\u0007\u0010\u001ER\u0019\u0010\t\u001A\u0004\u0018\u00010\b8\u0006\u00A2\u0006\f\n\u0004\b?\u0010@\u001A\u0004\bA\u0010 R\u0017\u0010\n\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\bB\u0010>\u001A\u0004\b\n\u0010\u001ER\u0017\u0010\u000B\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\bC\u0010>\u001A\u0004\b\u000B\u0010\u001ER\u0017\u0010\f\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\bD\u0010>\u001A\u0004\b\f\u0010\u001ER\u0017\u0010\r\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\bE\u0010>\u001A\u0004\bF\u0010\u001ER\u0019\u0010\u000F\u001A\u0004\u0018\u00010\u000E8\u0006\u00A2\u0006\f\n\u0004\bG\u0010H\u001A\u0004\bI\u0010&R\u0019\u0010\u0011\u001A\u0004\u0018\u00010\u00108\u0006\u00A2\u0006\f\n\u0004\bJ\u0010K\u001A\u0004\bL\u0010(R\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00108\u0006\u00A2\u0006\f\n\u0004\bM\u0010K\u001A\u0004\bN\u0010(R\u0017\u0010\u0014\u001A\u00020\u00138\u0006\u00A2\u0006\f\n\u0004\bO\u0010P\u001A\u0004\bQ\u0010+R\u0017\u0010\u0016\u001A\u00020\u00158\u0006\u00A2\u0006\f\n\u0004\bR\u0010S\u001A\u0004\bT\u0010-\u00A8\u0006U"}, d2 = {"Lcom/iloen/melon/player/playlist/search/SearchListType$SearchWrapperPlayable;", "Lcom/iloen/melon/player/playlist/search/SearchListType;", "", "trackId", "songName", "artists", "", "isSelectedForSelectRepeat", "Landroid/net/Uri;", "thumbnailUrl", "isShowAnimation", "isPlayingAnimation", "isAdult", "showOfflineIcon", "Lpb/b;", "fileType", "Lcom/iloen/melon/player/playlist/search/IndexInfo;", "songNameMatchingIndexInfo", "artistsMatchingIndexInfo", "Lcom/iloen/melon/playback/Playable;", "playable", "", "indexInPlaylist", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/net/Uri;ZZZZLpb/b;Lcom/iloen/melon/player/playlist/search/IndexInfo;Lcom/iloen/melon/player/playlist/search/IndexInfo;Lcom/iloen/melon/playback/Playable;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Z", "component5", "()Landroid/net/Uri;", "component6", "component7", "component8", "component9", "component10", "()Lpb/b;", "component11", "()Lcom/iloen/melon/player/playlist/search/IndexInfo;", "component12", "component13", "()Lcom/iloen/melon/playback/Playable;", "component14", "()I", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/net/Uri;ZZZZLpb/b;Lcom/iloen/melon/player/playlist/search/IndexInfo;Lcom/iloen/melon/player/playlist/search/IndexInfo;Lcom/iloen/melon/playback/Playable;I)Lcom/iloen/melon/player/playlist/search/SearchListType$SearchWrapperPlayable;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getTrackId", "b", "getSongName", "c", "getArtists", "d", "Z", "e", "Landroid/net/Uri;", "getThumbnailUrl", "f", "g", "h", "i", "getShowOfflineIcon", "j", "Lpb/b;", "getFileType", "k", "Lcom/iloen/melon/player/playlist/search/IndexInfo;", "getSongNameMatchingIndexInfo", "l", "getArtistsMatchingIndexInfo", "m", "Lcom/iloen/melon/playback/Playable;", "getPlayable", "n", "I", "getIndexInPlaylist", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SearchWrapperPlayable extends SearchListType {
        public static final int $stable = 8;
        public final String a;
        public final String b;
        public final String c;
        public final boolean d;
        public final Uri e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        public final boolean i;
        public final b j;
        public final IndexInfo k;
        public final IndexInfo l;
        public final Playable m;
        public final int n;

        public SearchWrapperPlayable(@NotNull String s, @NotNull String s1, @NotNull String s2, boolean z, @Nullable Uri uri0, boolean z1, boolean z2, boolean z3, boolean z4, @Nullable b b0, @Nullable IndexInfo indexInfo0, @Nullable IndexInfo indexInfo1, @NotNull Playable playable0, int v) {
            q.g(s, "trackId");
            q.g(s1, "songName");
            q.g(s2, "artists");
            q.g(playable0, "playable");
            super(null);
            this.a = s;
            this.b = s1;
            this.c = s2;
            this.d = z;
            this.e = uri0;
            this.f = z1;
            this.g = z2;
            this.h = z3;
            this.i = z4;
            this.j = b0;
            this.k = indexInfo0;
            this.l = indexInfo1;
            this.m = playable0;
            this.n = v;
        }

        public SearchWrapperPlayable(String s, String s1, String s2, boolean z, Uri uri0, boolean z1, boolean z2, boolean z3, boolean z4, b b0, IndexInfo indexInfo0, IndexInfo indexInfo1, Playable playable0, int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
            this(s, s1, s2, z, uri0, z1, z2, z3, z4, b0, ((v1 & 0x400) == 0 ? indexInfo0 : null), ((v1 & 0x800) == 0 ? indexInfo1 : null), playable0, v);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final b component10() {
            return this.j;
        }

        @Nullable
        public final IndexInfo component11() {
            return this.k;
        }

        @Nullable
        public final IndexInfo component12() {
            return this.l;
        }

        @NotNull
        public final Playable component13() {
            return this.m;
        }

        public final int component14() {
            return this.n;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        @Nullable
        public final Uri component5() {
            return this.e;
        }

        public final boolean component6() {
            return this.f;
        }

        public final boolean component7() {
            return this.g;
        }

        public final boolean component8() {
            return this.h;
        }

        public final boolean component9() {
            return this.i;
        }

        @NotNull
        public final SearchWrapperPlayable copy(@NotNull String s, @NotNull String s1, @NotNull String s2, boolean z, @Nullable Uri uri0, boolean z1, boolean z2, boolean z3, boolean z4, @Nullable b b0, @Nullable IndexInfo indexInfo0, @Nullable IndexInfo indexInfo1, @NotNull Playable playable0, int v) {
            q.g(s, "trackId");
            q.g(s1, "songName");
            q.g(s2, "artists");
            q.g(playable0, "playable");
            return new SearchWrapperPlayable(s, s1, s2, z, uri0, z1, z2, z3, z4, b0, indexInfo0, indexInfo1, playable0, v);
        }

        public static SearchWrapperPlayable copy$default(SearchWrapperPlayable searchListType$SearchWrapperPlayable0, String s, String s1, String s2, boolean z, Uri uri0, boolean z1, boolean z2, boolean z3, boolean z4, b b0, IndexInfo indexInfo0, IndexInfo indexInfo1, Playable playable0, int v, int v1, Object object0) {
            String s3 = (v1 & 1) == 0 ? s : searchListType$SearchWrapperPlayable0.a;
            String s4 = (v1 & 2) == 0 ? s1 : searchListType$SearchWrapperPlayable0.b;
            String s5 = (v1 & 4) == 0 ? s2 : searchListType$SearchWrapperPlayable0.c;
            boolean z5 = (v1 & 8) == 0 ? z : searchListType$SearchWrapperPlayable0.d;
            Uri uri1 = (v1 & 16) == 0 ? uri0 : searchListType$SearchWrapperPlayable0.e;
            boolean z6 = (v1 & 0x20) == 0 ? z1 : searchListType$SearchWrapperPlayable0.f;
            boolean z7 = (v1 & 0x40) == 0 ? z2 : searchListType$SearchWrapperPlayable0.g;
            boolean z8 = (v1 & 0x80) == 0 ? z3 : searchListType$SearchWrapperPlayable0.h;
            boolean z9 = (v1 & 0x100) == 0 ? z4 : searchListType$SearchWrapperPlayable0.i;
            b b1 = (v1 & 0x200) == 0 ? b0 : searchListType$SearchWrapperPlayable0.j;
            IndexInfo indexInfo2 = (v1 & 0x400) == 0 ? indexInfo0 : searchListType$SearchWrapperPlayable0.k;
            IndexInfo indexInfo3 = (v1 & 0x800) == 0 ? indexInfo1 : searchListType$SearchWrapperPlayable0.l;
            Playable playable1 = (v1 & 0x1000) == 0 ? playable0 : searchListType$SearchWrapperPlayable0.m;
            return (v1 & 0x2000) == 0 ? searchListType$SearchWrapperPlayable0.copy(s3, s4, s5, z5, uri1, z6, z7, z8, z9, b1, indexInfo2, indexInfo3, playable1, v) : searchListType$SearchWrapperPlayable0.copy(s3, s4, s5, z5, uri1, z6, z7, z8, z9, b1, indexInfo2, indexInfo3, playable1, searchListType$SearchWrapperPlayable0.n);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof SearchWrapperPlayable)) {
                return false;
            }
            if(!q.b(this.a, ((SearchWrapperPlayable)object0).a)) {
                return false;
            }
            if(!q.b(this.b, ((SearchWrapperPlayable)object0).b)) {
                return false;
            }
            if(!q.b(this.c, ((SearchWrapperPlayable)object0).c)) {
                return false;
            }
            if(this.d != ((SearchWrapperPlayable)object0).d) {
                return false;
            }
            if(!q.b(this.e, ((SearchWrapperPlayable)object0).e)) {
                return false;
            }
            if(this.f != ((SearchWrapperPlayable)object0).f) {
                return false;
            }
            if(this.g != ((SearchWrapperPlayable)object0).g) {
                return false;
            }
            if(this.h != ((SearchWrapperPlayable)object0).h) {
                return false;
            }
            if(this.i != ((SearchWrapperPlayable)object0).i) {
                return false;
            }
            if(this.j != ((SearchWrapperPlayable)object0).j) {
                return false;
            }
            if(!q.b(this.k, ((SearchWrapperPlayable)object0).k)) {
                return false;
            }
            if(!q.b(this.l, ((SearchWrapperPlayable)object0).l)) {
                return false;
            }
            return q.b(this.m, ((SearchWrapperPlayable)object0).m) ? this.n == ((SearchWrapperPlayable)object0).n : false;
        }

        @NotNull
        public final String getArtists() {
            return this.c;
        }

        @Nullable
        public final IndexInfo getArtistsMatchingIndexInfo() {
            return this.l;
        }

        @Nullable
        public final b getFileType() {
            return this.j;
        }

        public final int getIndexInPlaylist() {
            return this.n;
        }

        @NotNull
        public final Playable getPlayable() {
            return this.m;
        }

        public final boolean getShowOfflineIcon() {
            return this.i;
        }

        @NotNull
        public final String getSongName() {
            return this.b;
        }

        @Nullable
        public final IndexInfo getSongNameMatchingIndexInfo() {
            return this.k;
        }

        @Nullable
        public final Uri getThumbnailUrl() {
            return this.e;
        }

        @NotNull
        public final String getTrackId() {
            return this.a;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = d.e(d.e(d.e(d.e((d.e(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d) + (this.e == null ? 0 : this.e.hashCode())) * 0x1F, 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F, this.i);
            int v2 = this.j == null ? 0 : this.j.hashCode();
            int v3 = this.k == null ? 0 : this.k.hashCode();
            IndexInfo indexInfo0 = this.l;
            if(indexInfo0 != null) {
                v = indexInfo0.hashCode();
            }
            return this.n + (this.m.hashCode() + (((v1 + v2) * 0x1F + v3) * 0x1F + v) * 0x1F) * 0x1F;
        }

        public final boolean isAdult() {
            return this.h;
        }

        public final boolean isPlayingAnimation() {
            return this.g;
        }

        public final boolean isSelectedForSelectRepeat() {
            return this.d;
        }

        public final boolean isShowAnimation() {
            return this.f;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("SearchWrapperPlayable(trackId=", this.a, ", songName=", this.b, ", artists=");
            Y.x(stringBuilder0, this.c, ", isSelectedForSelectRepeat=", this.d, ", thumbnailUrl=");
            stringBuilder0.append(this.e);
            stringBuilder0.append(", isShowAnimation=");
            stringBuilder0.append(this.f);
            stringBuilder0.append(", isPlayingAnimation=");
            x.y(stringBuilder0, this.g, ", isAdult=", this.h, ", showOfflineIcon=");
            stringBuilder0.append(this.i);
            stringBuilder0.append(", fileType=");
            stringBuilder0.append(this.j);
            stringBuilder0.append(", songNameMatchingIndexInfo=");
            stringBuilder0.append(this.k);
            stringBuilder0.append(", artistsMatchingIndexInfo=");
            stringBuilder0.append(this.l);
            stringBuilder0.append(", playable=");
            stringBuilder0.append(this.m);
            stringBuilder0.append(", indexInPlaylist=");
            stringBuilder0.append(this.n);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    public static final int $stable;

    public SearchListType(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

