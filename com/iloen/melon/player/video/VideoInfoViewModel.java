package com.iloen.melon.player.video;

import Ac.O1;
import Ac.R3;
import Ac.T3;
import Ac.U3;
import Ac.V3;
import Ce.e;
import androidx.lifecycle.K;
import androidx.lifecycle.L;
import androidx.lifecycle.f0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.comments.CmtHelper;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.CMTINFO;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes;
import com.iloen.melon.net.v3x.comments.ListCmtRes.result.CMTLIST;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnReq.Params;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.CHNLINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.PAGEINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result.PAGINGINFO;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes.RESPONSE;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Artist;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Cmt;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Concert.Ticket;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Concert;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Dj;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Magazine.MagazineList;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Magazine;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.RecmMv.Mv;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.RecmMv;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Song;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response;
import com.iloen.melon.net.v6x.response.VodDetailRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.SongInfoBase;
import d5.n;
import e.k;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.p;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u8.d;
import v8.f;
import v8.h;
import v9.i;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005@ABCDB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\b\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\b\u0010\u0007J\u001A\u0010\f\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0096@\u00A2\u0006\u0004\b\f\u0010\rJ\r\u0010\u000E\u001A\u00020\u000B\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\"\u0010\u0014\u001A\u00020\u00132\b\u0010\u0010\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001A\u00020\u0011H\u0086@\u00A2\u0006\u0004\b\u0014\u0010\u0015R.\u0010\u001E\u001A\u0004\u0018\u00010\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u00168\u0006@FX\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\"\u0010$\u001A\u00020\u00058\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\u0007\"\u0004\b\"\u0010#R#\u0010,\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\'0&0%8\u0006\u00A2\u0006\f\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+R\u001D\u0010/\u001A\b\u0012\u0004\u0012\u00020\'0%8\u0006\u00A2\u0006\f\n\u0004\b-\u0010)\u001A\u0004\b.\u0010+R\u001F\u00103\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001000%8\u0006\u00A2\u0006\f\n\u0004\b1\u0010)\u001A\u0004\b2\u0010+R\u001D\u00107\u001A\b\u0012\u0004\u0012\u0002040%8\u0006\u00A2\u0006\f\n\u0004\b5\u0010)\u001A\u0004\b6\u0010+R\"\u0010?\u001A\u0002088\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b9\u0010:\u001A\u0004\b;\u0010<\"\u0004\b=\u0010>\u00A8\u0006E"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoViewModel;", "Lv8/f;", "Lcom/iloen/melon/net/v6x/response/VodDetailRes;", "<init>", "()V", "", "getTag", "()Ljava/lang/String;", "getCacheKey", "Lv9/i;", "fetchType", "", "fetchRequest", "(Lv9/i;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isLoginUser", "()Z", "progSeq", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lie/H;", "requestLike", "(Ljava/lang/String;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/playback/Playable;", "value", "a", "Lcom/iloen/melon/playback/Playable;", "getCurrentPlayable", "()Lcom/iloen/melon/playback/Playable;", "setCurrentPlayable", "(Lcom/iloen/melon/playback/Playable;)V", "currentPlayable", "b", "Ljava/lang/String;", "getMvId", "setMvId", "(Ljava/lang/String;)V", "mvId", "Landroidx/lifecycle/K;", "", "Lcom/iloen/melon/player/video/VideoInfoViewModel$WrappedData;", "d", "Landroidx/lifecycle/K;", "getList", "()Landroidx/lifecycle/K;", "list", "f", "getCommentList", "commentList", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result;", "h", "getInformCmtContsSumm", "informCmtContsSumm", "Lcom/iloen/melon/player/video/VideoInfoViewModel$LikeData;", "j", "getLike", "like", "", "k", "I", "getBbsChannelSeq", "()I", "setBbsChannelSeq", "(I)V", "bbsChannelSeq", "Companion", "LikeData", "WrappedData", "CommentData", "ArtistSource", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoInfoViewModel extends f {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoViewModel$ArtistSource;", "", "", "FROM_INFO", "Ljava/lang/String;", "FROM_RELATIVE_ARTIST", "FROM_RELATIVE_VIDEO", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ArtistSource {
        public static final int $stable = 0;
        @NotNull
        public static final String FROM_INFO = "FROM_INFO";
        @NotNull
        public static final String FROM_RELATIVE_ARTIST = "FROM_RELATIVE_ARTIST";
        @NotNull
        public static final String FROM_RELATIVE_VIDEO = "FROM_RELATIVE_VIDEO";
        @NotNull
        public static final ArtistSource INSTANCE;

        static {
            ArtistSource.INSTANCE = new ArtistSource();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001A\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ(\u0010\f\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0012\u001A\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001A\u0010\u0016\u001A\u00020\u00152\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\tR\u0019\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u000B¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoViewModel$CommentData;", "", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "loadPgnRes", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "listCmtRes", "<init>", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)V", "component1", "()Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "component2", "()Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "copy", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)Lcom/iloen/melon/player/video/VideoInfoViewModel$CommentData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "getLoadPgnRes", "b", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "getListCmtRes", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class CommentData {
        public static final int $stable = 8;
        public final LoadPgnRes a;
        public final ListCmtRes b;

        public CommentData() {
            this(null, null, 3, null);
        }

        public CommentData(@Nullable LoadPgnRes loadPgnRes0, @Nullable ListCmtRes listCmtRes0) {
            this.a = loadPgnRes0;
            this.b = listCmtRes0;
        }

        public CommentData(LoadPgnRes loadPgnRes0, ListCmtRes listCmtRes0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                loadPgnRes0 = null;
            }
            if((v & 2) != 0) {
                listCmtRes0 = null;
            }
            this(loadPgnRes0, listCmtRes0);
        }

        @Nullable
        public final LoadPgnRes component1() {
            return this.a;
        }

        @Nullable
        public final ListCmtRes component2() {
            return this.b;
        }

        @NotNull
        public final CommentData copy(@Nullable LoadPgnRes loadPgnRes0, @Nullable ListCmtRes listCmtRes0) {
            return new CommentData(loadPgnRes0, listCmtRes0);
        }

        public static CommentData copy$default(CommentData videoInfoViewModel$CommentData0, LoadPgnRes loadPgnRes0, ListCmtRes listCmtRes0, int v, Object object0) {
            if((v & 1) != 0) {
                loadPgnRes0 = videoInfoViewModel$CommentData0.a;
            }
            if((v & 2) != 0) {
                listCmtRes0 = videoInfoViewModel$CommentData0.b;
            }
            return videoInfoViewModel$CommentData0.copy(loadPgnRes0, listCmtRes0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof CommentData)) {
                return false;
            }
            return q.b(this.a, ((CommentData)object0).a) ? q.b(this.b, ((CommentData)object0).b) : false;
        }

        @Nullable
        public final ListCmtRes getListCmtRes() {
            return this.b;
        }

        @Nullable
        public final LoadPgnRes getLoadPgnRes() {
            return this.a;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.a == null ? 0 : this.a.hashCode();
            ListCmtRes listCmtRes0 = this.b;
            if(listCmtRes0 != null) {
                v = listCmtRes0.hashCode();
            }
            return v1 * 0x1F + v;
        }

        @Override
        @NotNull
        public String toString() {
            return "CommentData(loadPgnRes=" + this.a + ", listCmtRes=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoViewModel$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000B\b\u0087\b\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000BJ\u0010\u0010\u0010\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0013\u001A\u00020\u00022\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0003\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u000B¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoViewModel$LikeData;", "", "", "isLike", "", "likeCnt", "<init>", "(ZLjava/lang/String;)V", "component1", "()Z", "component2", "()Ljava/lang/String;", "copy", "(ZLjava/lang/String;)Lcom/iloen/melon/player/video/VideoInfoViewModel$LikeData;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "b", "Ljava/lang/String;", "getLikeCnt", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class LikeData {
        public static final int $stable;
        public final boolean a;
        public final String b;

        public LikeData() {
            this(false, null, 3, null);
        }

        public LikeData(boolean z, @NotNull String s) {
            q.g(s, "likeCnt");
            super();
            this.a = z;
            this.b = s;
        }

        public LikeData(boolean z, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                z = false;
            }
            if((v & 2) != 0) {
                s = "0";
            }
            this(z, s);
        }

        public final boolean component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final LikeData copy(boolean z, @NotNull String s) {
            q.g(s, "likeCnt");
            return new LikeData(z, s);
        }

        public static LikeData copy$default(LikeData videoInfoViewModel$LikeData0, boolean z, String s, int v, Object object0) {
            if((v & 1) != 0) {
                z = videoInfoViewModel$LikeData0.a;
            }
            if((v & 2) != 0) {
                s = videoInfoViewModel$LikeData0.b;
            }
            return videoInfoViewModel$LikeData0.copy(z, s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof LikeData)) {
                return false;
            }
            return this.a == ((LikeData)object0).a ? q.b(this.b, ((LikeData)object0).b) : false;
        }

        @NotNull
        public final String getLikeCnt() [...] // 潜在的解密器

        @Override
        public int hashCode() {
            return this.b.hashCode() + Boolean.hashCode(this.a) * 0x1F;
        }

        public final boolean isLike() {
            return this.a;
        }

        @Override
        @NotNull
        public String toString() {
            return "LikeData(isLike=" + this.a + ", likeCnt=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u001C\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B\u001D\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0001\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001A\u0004\u0018\u00010\u0001H\u00C6\u0003\u00A2\u0006\u0004\b\t\u0010\nJ&\u0010\u000B\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0001H\u00C6\u0001\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rH\u00D6\u0001\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0010\u0010\u0010\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u0010\u0010\bJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\bR\u0019\u0010\u0004\u001A\u0004\u0018\u00010\u00018\u0006\u00A2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\nR\"\u0010\u001D\u001A\u00020\u00128\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 R\"\u0010&\u001A\u00020\r8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010\u000F\"\u0004\b$\u0010%R\"\u0010(\u001A\u00020\u00128\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\'\u0010\u001C\u001A\u0004\b(\u0010\u001E\"\u0004\b)\u0010 R\"\u0010.\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b*\u0010\u0016\u001A\u0004\b+\u0010\b\"\u0004\b,\u0010-R$\u00106\u001A\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b0\u00101\u001A\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010:\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b7\u0010\u0016\u001A\u0004\b8\u0010\b\"\u0004\b9\u0010-R*\u0010C\u001A\n\u0012\u0004\u0012\u00020<\u0018\u00010;8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b=\u0010>\u001A\u0004\b?\u0010@\"\u0004\bA\u0010BR*\u0010H\u001A\n\u0012\u0004\u0012\u00020D\u0018\u00010;8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bE\u0010>\u001A\u0004\bF\u0010@\"\u0004\bG\u0010BR$\u0010P\u001A\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bJ\u0010K\u001A\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010T\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bQ\u0010\u0016\u001A\u0004\bR\u0010\b\"\u0004\bS\u0010-\u00A8\u0006U"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoViewModel$WrappedData;", "", "", "viewType", "data", "<init>", "(ILjava/lang/Object;)V", "component1", "()I", "component2", "()Ljava/lang/Object;", "copy", "(ILjava/lang/Object;)Lcom/iloen/melon/player/video/VideoInfoViewModel$WrappedData;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getViewType", "b", "Ljava/lang/Object;", "getData", "c", "Z", "isLike", "()Z", "setLike", "(Z)V", "d", "Ljava/lang/String;", "getSumCount", "setSumCount", "(Ljava/lang/String;)V", "sumCount", "e", "isFirstItem", "setFirstItem", "f", "getMoreType", "setMoreType", "(I)V", "moreType", "Lcom/iloen/melon/playback/Playable;", "g", "Lcom/iloen/melon/playback/Playable;", "getPlayable", "()Lcom/iloen/melon/playback/Playable;", "setPlayable", "(Lcom/iloen/melon/playback/Playable;)V", "playable", "h", "getBbsChannelSeq", "setBbsChannelSeq", "bbsChannelSeq", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel;", "i", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "getCmtRes", "()Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "setCmtRes", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "cmtRes", "Lie/H;", "j", "getCmtEmptyRes", "setCmtEmptyRes", "cmtEmptyRes", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result;", "k", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result;", "getInformCmtResult", "()Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result;", "setInformCmtResult", "(Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result;)V", "informCmtResult", "l", "getIndex", "setIndex", "index", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class WrappedData {
        public static final int $stable = 8;
        public final int a;
        public final Object b;
        public boolean c;
        public String d;
        public boolean e;
        public int f;
        public Playable g;
        public int h;
        public AdapterInViewHolder.Row i;
        public AdapterInViewHolder.Row j;
        public result k;
        public int l;

        public WrappedData() {
            this(0, null, 3, null);
        }

        public WrappedData(int v, @Nullable Object object0) {
            this.a = v;
            this.b = object0;
            this.d = "0";
            this.f = 2;
            this.h = -1;
        }

        public WrappedData(int v, Object object0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v1 & 1) != 0) {
                v = -1;
            }
            if((v1 & 2) != 0) {
                object0 = null;
            }
            this(v, object0);
        }

        public final int component1() {
            return this.a;
        }

        @Nullable
        public final Object component2() {
            return this.b;
        }

        @NotNull
        public final WrappedData copy(int v, @Nullable Object object0) {
            return new WrappedData(v, object0);
        }

        public static WrappedData copy$default(WrappedData videoInfoViewModel$WrappedData0, int v, Object object0, int v1, Object object1) {
            if((v1 & 1) != 0) {
                v = videoInfoViewModel$WrappedData0.a;
            }
            if((v1 & 2) != 0) {
                object0 = videoInfoViewModel$WrappedData0.b;
            }
            return videoInfoViewModel$WrappedData0.copy(v, object0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof WrappedData)) {
                return false;
            }
            return this.a == ((WrappedData)object0).a ? q.b(this.b, ((WrappedData)object0).b) : false;
        }

        public final int getBbsChannelSeq() {
            return this.h;
        }

        @Nullable
        public final AdapterInViewHolder.Row getCmtEmptyRes() {
            return this.j;
        }

        @Nullable
        public final AdapterInViewHolder.Row getCmtRes() {
            return this.i;
        }

        @Nullable
        public final Object getData() {
            return this.b;
        }

        public final int getIndex() {
            return this.l;
        }

        @Nullable
        public final result getInformCmtResult() {
            return this.k;
        }

        public final int getMoreType() {
            return this.f;
        }

        @Nullable
        public final Playable getPlayable() {
            return this.g;
        }

        @NotNull
        public final String getSumCount() [...] // 潜在的解密器

        public final int getViewType() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.b == null ? this.a * 0x1F : this.a * 0x1F + this.b.hashCode();
        }

        public final boolean isFirstItem() {
            return this.e;
        }

        public final boolean isLike() {
            return this.c;
        }

        public final void setBbsChannelSeq(int v) {
            this.h = v;
        }

        public final void setCmtEmptyRes(@Nullable AdapterInViewHolder.Row adapterInViewHolder$Row0) {
            this.j = adapterInViewHolder$Row0;
        }

        public final void setCmtRes(@Nullable AdapterInViewHolder.Row adapterInViewHolder$Row0) {
            this.i = adapterInViewHolder$Row0;
        }

        public final void setFirstItem(boolean z) {
            this.e = z;
        }

        public final void setIndex(int v) {
            this.l = v;
        }

        public final void setInformCmtResult(@Nullable result informCmtContsSummRes$result0) {
            this.k = informCmtContsSummRes$result0;
        }

        public final void setLike(boolean z) {
            this.c = z;
        }

        public final void setMoreType(int v) {
            this.f = v;
        }

        public final void setPlayable(@Nullable Playable playable0) {
            this.g = playable0;
        }

        public final void setSumCount(@NotNull String s) {
            q.g(s, "<set-?>");
            this.d = s;
        }

        @Override
        @NotNull
        public String toString() {
            return "WrappedData(viewType=" + this.a + ", data=" + this.b + ")";
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public Playable a;
    public String b;
    public final L c;
    public final L d;
    public final L e;
    public final L f;
    public final L g;
    public final L h;
    public final L i;
    public final L j;
    public int k;

    static {
        VideoInfoViewModel.Companion = new Companion(null);
        VideoInfoViewModel.$stable = 8;
    }

    public VideoInfoViewModel() {
        this.b = "";
        L l0 = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.c = l0;
        this.d = l0;
        L l1 = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.e = l1;
        this.f = l1;
        L l2 = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.g = l2;
        this.h = l2;
        L l3 = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.i = l3;
        this.j = l3;
        this.k = -1;
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new VideoInfoViewModel.subscribeCommentUpdates.1(null, this), 3, null);
    }

    public static final Object access$processCommentUpdateAction(VideoInfoViewModel videoInfoViewModel0, V3 v30, Continuation continuation0) {
        VideoInfoViewModel.processCommentUpdateAction.1 videoInfoViewModel$processCommentUpdateAction$10;
        L l0 = videoInfoViewModel0.e;
        if(continuation0 instanceof VideoInfoViewModel.processCommentUpdateAction.1) {
            videoInfoViewModel$processCommentUpdateAction$10 = (VideoInfoViewModel.processCommentUpdateAction.1)continuation0;
            int v = videoInfoViewModel$processCommentUpdateAction$10.B;
            if((v & 0x80000000) == 0) {
                videoInfoViewModel$processCommentUpdateAction$10 = new VideoInfoViewModel.processCommentUpdateAction.1(continuation0, videoInfoViewModel0);
            }
            else {
                videoInfoViewModel$processCommentUpdateAction$10.B = v ^ 0x80000000;
            }
        }
        else {
            videoInfoViewModel$processCommentUpdateAction$10 = new VideoInfoViewModel.processCommentUpdateAction.1(continuation0, videoInfoViewModel0);
        }
        Object object0 = videoInfoViewModel$processCommentUpdateAction$10.r;
        a a0 = a.a;
        int v1 = 1;
        H h0 = H.a;
        switch(videoInfoViewModel$processCommentUpdateAction$10.B) {
            case 0: {
                Object object1 = null;
                n.D(object0);
                if(v30 instanceof R3) {
                    int v2 = videoInfoViewModel0.k;
                    T2.a a1 = f0.h(videoInfoViewModel0);
                    videoInfoViewModel$processCommentUpdateAction$10.B = 1;
                    if(videoInfoViewModel0.b(v2, i.b, a1, videoInfoViewModel$processCommentUpdateAction$10) == a0) {
                        return a0;
                    }
                    goto label_83;
                }
                else if(v30 instanceof T3) {
                    WrappedData videoInfoViewModel$WrappedData0 = (WrappedData)l0.getValue();
                    if(videoInfoViewModel$WrappedData0 != null) {
                        Object object2 = videoInfoViewModel$WrappedData0.getData();
                        CommentData videoInfoViewModel$CommentData0 = object2 instanceof CommentData ? ((CommentData)object2) : null;
                        if(videoInfoViewModel$CommentData0 != null) {
                            ListCmtRes listCmtRes0 = videoInfoViewModel$CommentData0.getListCmtRes();
                            if(listCmtRes0 != null) {
                                com.iloen.melon.net.v3x.comments.ListCmtRes.result listCmtRes$result0 = listCmtRes0.result;
                                if(listCmtRes$result0 != null) {
                                    ArrayList arrayList0 = listCmtRes$result0.cmtlist;
                                    if(arrayList0 != null) {
                                        for(Object object3: arrayList0) {
                                            if(((CMTLIST)object3).cmtinfo.cmtseq == ((T3)v30).c) {
                                                object1 = object3;
                                                break;
                                            }
                                            if(false) {
                                                break;
                                            }
                                        }
                                        if(((CMTLIST)object1) != null) {
                                            CMTINFO cmtSharedTypeRes$CmtListBase$CMTINFO0 = ((CMTLIST)object1).cmtinfo;
                                            cmtSharedTypeRes$CmtListBase$CMTINFO0.recmcnt = ((T3)v30).d;
                                            cmtSharedTypeRes$CmtListBase$CMTINFO0.nonrecmcnt = ((T3)v30).e;
                                            cmtSharedTypeRes$CmtListBase$CMTINFO0.memberrecmflag = ((T3)v30).a == O1.a && ((T3)v30).b;
                                            if(((T3)v30).a != O1.b || !((T3)v30).b) {
                                                v1 = 0;
                                            }
                                            cmtSharedTypeRes$CmtListBase$CMTINFO0.membernonrecmflag = v1;
                                            l0.postValue(videoInfoViewModel$WrappedData0);
                                            return h0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                else if(v30 instanceof U3) {
                    WrappedData videoInfoViewModel$WrappedData1 = (WrappedData)l0.getValue();
                    if(videoInfoViewModel$WrappedData1 != null) {
                        Object object4 = videoInfoViewModel$WrappedData1.getData();
                        CommentData videoInfoViewModel$CommentData1 = object4 instanceof CommentData ? ((CommentData)object4) : null;
                        if(videoInfoViewModel$CommentData1 != null) {
                            ListCmtRes listCmtRes1 = videoInfoViewModel$CommentData1.getListCmtRes();
                            if(listCmtRes1 != null) {
                                com.iloen.melon.net.v3x.comments.ListCmtRes.result listCmtRes$result1 = listCmtRes1.result;
                                if(listCmtRes$result1 != null) {
                                    ArrayList arrayList1 = listCmtRes$result1.cmtlist;
                                    if(arrayList1 != null) {
                                        for(Object object5: arrayList1) {
                                            if(((CMTLIST)object5).cmtinfo.cmtseq == ((U3)v30).a) {
                                                object1 = object5;
                                                break;
                                            }
                                            if(false) {
                                                break;
                                            }
                                        }
                                        if(((CMTLIST)object1) != null) {
                                            CMTINFO cmtSharedTypeRes$CmtListBase$CMTINFO1 = ((CMTLIST)object1).cmtinfo;
                                            int v3 = cmtSharedTypeRes$CmtListBase$CMTINFO1.validadcmtcnt;
                                            if(!((U3)v30).d) {
                                                v1 = -1;
                                            }
                                            cmtSharedTypeRes$CmtListBase$CMTINFO1.validadcmtcnt = v3 + v1;
                                            l0.postValue(videoInfoViewModel$WrappedData1);
                                            return h0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                n.D(object0);
            label_83:
                int v4 = videoInfoViewModel0.k;
                String s = videoInfoViewModel0.b;
                T2.a a2 = f0.h(videoInfoViewModel0);
                videoInfoViewModel$processCommentUpdateAction$10.B = 2;
                if(videoInfoViewModel0.c(v4, s, a2, videoInfoViewModel$processCommentUpdateAction$10) == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }

    public static final Deferred access$requestBannerAsync(VideoInfoViewModel videoInfoViewModel0, CoroutineScope coroutineScope0) {
        videoInfoViewModel0.getClass();
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new VideoInfoViewModel.requestBannerAsync.1(null, videoInfoViewModel0), 3, null);
    }

    public static final Deferred access$requestMainAsync(VideoInfoViewModel videoInfoViewModel0, CoroutineScope coroutineScope0) {
        videoInfoViewModel0.getClass();
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new VideoInfoViewModel.requestMainAsync.1(null, videoInfoViewModel0), 3, null);
    }

    public final Object b(int v, i i0, CoroutineScope coroutineScope0, Continuation continuation0) {
        i i5;
        v8.i i4;
        int v3;
        String s;
        int v2;
        i i1;
        CoroutineScope coroutineScope1;
        VideoInfoViewModel.requestComment.1 videoInfoViewModel$requestComment$10;
        if(continuation0 instanceof VideoInfoViewModel.requestComment.1) {
            videoInfoViewModel$requestComment$10 = (VideoInfoViewModel.requestComment.1)continuation0;
            int v1 = videoInfoViewModel$requestComment$10.I;
            if((v1 & 0x80000000) == 0) {
                videoInfoViewModel$requestComment$10 = new VideoInfoViewModel.requestComment.1(continuation0, this);
            }
            else {
                videoInfoViewModel$requestComment$10.I = v1 ^ 0x80000000;
            }
        }
        else {
            videoInfoViewModel$requestComment$10 = new VideoInfoViewModel.requestComment.1(continuation0, this);
        }
        Object object0 = videoInfoViewModel$requestComment$10.E;
        a a0 = a.a;
        switch(videoInfoViewModel$requestComment$10.I) {
            case 0: {
                n.D(object0);
                LogU.Companion.d("VideoInfoViewModel", "requestComment");
                Params loadPgnReq$Params0 = new Params();
                loadPgnReq$Params0.chnlSeq = v;
                loadPgnReq$Params0.contsRefValue = this.b;
                coroutineScope1 = coroutineScope0;
                Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(coroutineScope1, null, null, new VideoInfoViewModel.requestLoadPgnAsync.1(loadPgnReq$Params0, this, null), 3, null);
                i1 = i0;
                videoInfoViewModel$requestComment$10.w = i1;
                videoInfoViewModel$requestComment$10.B = coroutineScope1;
                videoInfoViewModel$requestComment$10.r = v;
                videoInfoViewModel$requestComment$10.I = 1;
                object0 = deferred0.await(videoInfoViewModel$requestComment$10);
                if(object0 == a0) {
                    return a0;
                }
                goto label_34;
            }
            case 1: {
                v = videoInfoViewModel$requestComment$10.r;
                CoroutineScope coroutineScope2 = videoInfoViewModel$requestComment$10.B;
                i i2 = videoInfoViewModel$requestComment$10.w;
                n.D(object0);
                coroutineScope1 = coroutineScope2;
                i1 = i2;
            label_34:
                v8.i i3 = e1.n.g(((d)object0), i1);
                if(i3.a == h.a) {
                    LoadPgnRes loadPgnRes0 = (LoadPgnRes)i3.c;
                    com.iloen.melon.net.v3x.comments.LoadPgnRes.result loadPgnRes$result0 = loadPgnRes0 == null ? null : loadPgnRes0.result;
                    com.iloen.melon.net.v3x.comments.ListCmtReq.Params listCmtReq$Params0 = new com.iloen.melon.net.v3x.comments.ListCmtReq.Params();
                    if(loadPgnRes$result0 == null) {
                        v2 = -1;
                    }
                    else {
                        CHNLINFO loadPgnRes$result$CHNLINFO0 = loadPgnRes$result0.chnlinfo;
                        v2 = loadPgnRes$result$CHNLINFO0 == null ? -1 : loadPgnRes$result$CHNLINFO0.chnlseq;
                    }
                    listCmtReq$Params0.chnlSeq = v2;
                    if(loadPgnRes$result0 == null) {
                        s = null;
                    }
                    else {
                        PAGEINFO loadPgnRes$result$PAGEINFO0 = loadPgnRes$result0.pageinfo;
                        s = loadPgnRes$result$PAGEINFO0 == null ? null : loadPgnRes$result$PAGEINFO0.contsrefvalue;
                    }
                    listCmtReq$Params0.contsRefValue = s;
                    if(loadPgnRes$result0 == null) {
                        v3 = -1;
                    }
                    else {
                        PAGINGINFO loadPgnRes$result$PAGINGINFO0 = loadPgnRes$result0.paginginfo;
                        v3 = loadPgnRes$result$PAGINGINFO0 == null ? -1 : loadPgnRes$result$PAGINGINFO0.firstpageno;
                    }
                    listCmtReq$Params0.pageNo = v3;
                    listCmtReq$Params0.pageSize = 3;
                    listCmtReq$Params0.sortType = 0;
                    listCmtReq$Params0.srchType = -1;
                    Deferred deferred1 = BuildersKt__Builders_commonKt.async$default(coroutineScope1, null, null, new VideoInfoViewModel.requestCmtListAsync.1(listCmtReq$Params0, this, null), 3, null);
                    videoInfoViewModel$requestComment$10.w = i1;
                    videoInfoViewModel$requestComment$10.B = null;
                    videoInfoViewModel$requestComment$10.D = i3;
                    videoInfoViewModel$requestComment$10.r = v;
                    videoInfoViewModel$requestComment$10.I = 2;
                    Object object1 = deferred1.await(videoInfoViewModel$requestComment$10);
                    if(object1 == a0) {
                        return a0;
                    }
                    object0 = object1;
                    i4 = i3;
                    i5 = i1;
                    goto label_85;
                }
                break;
            }
            case 2: {
                i4 = videoInfoViewModel$requestComment$10.D;
                i5 = videoInfoViewModel$requestComment$10.w;
                n.D(object0);
            label_85:
                v8.i i6 = e1.n.g(((d)object0), i5);
                if(i6.a == h.a) {
                    WrappedData videoInfoViewModel$WrappedData0 = new WrappedData(-1, new CommentData(((LoadPgnRes)i4.c), ((ListCmtRes)i6.c)));
                    this.e.postValue(videoInfoViewModel$WrappedData0);
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }

    public final Object c(int v, String s, CoroutineScope coroutineScope0, Continuation continuation0) {
        VideoInfoViewModel.requestInformCmt.1 videoInfoViewModel$requestInformCmt$10;
        if(continuation0 instanceof VideoInfoViewModel.requestInformCmt.1) {
            videoInfoViewModel$requestInformCmt$10 = (VideoInfoViewModel.requestInformCmt.1)continuation0;
            int v1 = videoInfoViewModel$requestInformCmt$10.B;
            if((v1 & 0x80000000) == 0) {
                videoInfoViewModel$requestInformCmt$10 = new VideoInfoViewModel.requestInformCmt.1(continuation0, this);
            }
            else {
                videoInfoViewModel$requestInformCmt$10.B = v1 ^ 0x80000000;
            }
        }
        else {
            videoInfoViewModel$requestInformCmt$10 = new VideoInfoViewModel.requestInformCmt.1(continuation0, this);
        }
        Object object0 = videoInfoViewModel$requestInformCmt$10.r;
        a a0 = a.a;
        result informCmtContsSummRes$result0 = null;
        switch(videoInfoViewModel$requestInformCmt$10.B) {
            case 0: {
                n.D(object0);
                com.iloen.melon.net.v3x.comments.InformCmtContsSummReq.Params informCmtContsSummReq$Params0 = new com.iloen.melon.net.v3x.comments.InformCmtContsSummReq.Params();
                informCmtContsSummReq$Params0.chnlSeq = v;
                informCmtContsSummReq$Params0.contsRefValue = s;
                Integer integer0 = CmtHelper.getLatestComment(v, s);
                informCmtContsSummReq$Params0.latestCmtSeq = integer0 == null ? -1 : ((int)integer0);
                Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new VideoInfoViewModel.requestInformCmtAsync.1(informCmtContsSummReq$Params0, this, null), 3, null);
                videoInfoViewModel$requestInformCmt$10.B = 1;
                object0 = deferred0.await(videoInfoViewModel$requestInformCmt$10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        v8.i i0 = e1.n.g(((d)object0), i.b);
        if(i0.a == h.a) {
            InformCmtContsSummRes informCmtContsSummRes0 = (InformCmtContsSummRes)i0.c;
            if(informCmtContsSummRes0 != null) {
                informCmtContsSummRes$result0 = informCmtContsSummRes0.result;
            }
            this.g.postValue(informCmtContsSummRes$result0);
        }
        return H.a;
    }

    @Override  // v8.f
    @Nullable
    public Object fetchRequest(@Nullable i i0, @NotNull Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getMain(), new we.n(i0, null) {
            public int B;
            public int D;
            public Object E;
            public final VideoInfoViewModel G;
            public final i I;
            public v8.i r;
            public v8.i w;

            {
                this.G = videoInfoViewModel0;
                this.I = i0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.player.video.VideoInfoViewModel.fetchRequest.2(this.G, this.I, continuation0);
                continuation1.E = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoInfoViewModel.fetchRequest.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                v8.i i1;
                v8.i i2;
                int v;
                Object object1;
                v8.i i3;
                Object object2;
                Ticket vodDetailRes$Response$Concert$Ticket0;
                String s6;
                ArrayList arrayList7;
                String s5;
                ArrayList arrayList6;
                String s4;
                ArrayList arrayList5;
                String s3;
                ArrayList arrayList4;
                Mv vodDetailRes$Response$RecmMv$Mv0;
                int v7;
                List list0;
                ArrayList arrayList1;
                int v1;
                String s;
                CoroutineScope coroutineScope0 = (CoroutineScope)this.E;
                a a0 = a.a;
                i i0 = this.I;
                VideoInfoViewModel videoInfoViewModel0 = this.G;
                switch(this.D) {
                    case 0: {
                        n.D(object0);
                        videoInfoViewModel0.setBbsChannelSeq(-1);
                        Deferred deferred0 = VideoInfoViewModel.access$requestBannerAsync(videoInfoViewModel0, coroutineScope0);
                        this.E = coroutineScope0;
                        this.D = 1;
                        object2 = deferred0.await(this);
                        if(object2 != a0) {
                        label_27:
                            i3 = e1.n.g(((d)object2), i0);
                            Deferred deferred1 = VideoInfoViewModel.access$requestMainAsync(videoInfoViewModel0, coroutineScope0);
                            this.E = coroutineScope0;
                            this.r = i3;
                            this.D = 2;
                            object1 = deferred1.await(this);
                            if(object1 != a0) {
                            label_34:
                                i2 = e1.n.g(((d)object1), i0);
                                if(i2.a != h.a) {
                                    videoInfoViewModel0.get_response().setValue(i2);
                                    return i2.a == h.a;
                                }
                                VodDetailRes vodDetailRes0 = (VodDetailRes)i2.c;
                                Response vodDetailRes$Response0 = vodDetailRes0 == null ? null : vodDetailRes0.response;
                                ArrayList arrayList0 = new ArrayList();
                                com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv vodDetailRes$Response$Mv0 = vodDetailRes$Response0 == null ? null : vodDetailRes$Response0.mv;
                                if(vodDetailRes$Response$Mv0 != null) {
                                    WrappedData videoInfoViewModel$WrappedData0 = new WrappedData(1, vodDetailRes$Response$Mv0);
                                    videoInfoViewModel$WrappedData0.setPlayable(videoInfoViewModel0.getCurrentPlayable());
                                    Cmt vodDetailRes$Response$Cmt0 = vodDetailRes$Response0.cmt;
                                    if(vodDetailRes$Response$Cmt0 == null) {
                                        s = "-1";
                                    }
                                    else {
                                        s = vodDetailRes$Response$Cmt0.bbsChannelSeq;
                                        if(s == null) {
                                            s = "-1";
                                        }
                                    }
                                    videoInfoViewModel$WrappedData0.setBbsChannelSeq(Integer.parseInt(s));
                                    String s1 = vodDetailRes$Response$Mv0.getLikeCnt();
                                    if(s1 == null) {
                                        s1 = "";
                                    }
                                    videoInfoViewModel$WrappedData0.setSumCount(s1);
                                    arrayList0.add(videoInfoViewModel$WrappedData0);
                                    Cmt vodDetailRes$Response$Cmt1 = vodDetailRes$Response0.cmt;
                                    if(vodDetailRes$Response$Cmt1 == null) {
                                        v1 = -1;
                                    }
                                    else {
                                        String s2 = vodDetailRes$Response$Cmt1.bbsChannelSeq;
                                        v1 = s2 == null ? -1 : Integer.parseInt(s2);
                                    }
                                    videoInfoViewModel0.setBbsChannelSeq(v1);
                                }
                                PromotionContentsBannerRes promotionContentsBannerRes0 = (PromotionContentsBannerRes)i3.c;
                                if(promotionContentsBannerRes0 == null) {
                                    arrayList1 = null;
                                }
                                else {
                                    RESPONSE promotionContentsBannerRes$RESPONSE0 = promotionContentsBannerRes0.response;
                                    arrayList1 = promotionContentsBannerRes$RESPONSE0 == null ? null : promotionContentsBannerRes$RESPONSE0.banners;
                                }
                                if(arrayList1 != null && !arrayList1.isEmpty()) {
                                    arrayList0.add(new WrappedData(2, arrayList1.get(0)));
                                }
                                if(vodDetailRes$Response0 == null) {
                                    list0 = null;
                                }
                                else {
                                    RecmMv vodDetailRes$Response$RecmMv0 = vodDetailRes$Response0.recmMv;
                                    if(vodDetailRes$Response$RecmMv0 == null) {
                                        list0 = null;
                                    }
                                    else {
                                        ArrayList arrayList2 = vodDetailRes$Response$RecmMv0.list5;
                                        list0 = arrayList2 == null ? null : p.K0(20, arrayList2);
                                    }
                                }
                                if(list0 == null || list0.isEmpty()) {
                                    v = 0;
                                }
                                else {
                                    q.d(list0);
                                    int v2 = list0.size();
                                    List list1 = p.K0(4, list0);
                                    int v3 = list1.size();
                                    e e0 = P4.a.C(P4.a.K(0, v3), 2);
                                    int v4 = e0.a;
                                    int v5 = e0.b;
                                    int v6 = e0.c;
                                    if(v6 > 0 && v4 <= v5 || v6 < 0 && v5 <= v4) {
                                        while(true) {
                                            ArrayList arrayList3 = new ArrayList();
                                            Object object3 = list1.get(v4);
                                            if(v4 + 1 < v3) {
                                                v7 = v3;
                                                vodDetailRes$Response$RecmMv$Mv0 = (Mv)list1.get(v4 + 1);
                                            }
                                            else {
                                                v7 = v3;
                                                vodDetailRes$Response$RecmMv$Mv0 = null;
                                            }
                                            ((Mv)object3).index = v4 + 1;
                                            arrayList3.add(((Mv)object3));
                                            if(vodDetailRes$Response$RecmMv$Mv0 != null) {
                                                vodDetailRes$Response$RecmMv$Mv0.index = v4 + 2;
                                                arrayList3.add(vodDetailRes$Response$RecmMv$Mv0);
                                            }
                                            WrappedData videoInfoViewModel$WrappedData1 = new WrappedData(3, arrayList3);
                                            videoInfoViewModel$WrappedData1.setFirstItem(v4 < 2);
                                            arrayList0.add(videoInfoViewModel$WrappedData1);
                                            if(v4 == v5) {
                                                break;
                                            }
                                            v4 += v6;
                                            v3 = v7;
                                        }
                                    }
                                    MelonAppBase.Companion.getClass();
                                    if(!ScreenUtils.isTablet(t.a().getContext())) {
                                        if(v2 > 3) {
                                            WrappedData videoInfoViewModel$WrappedData3 = new WrappedData(6, list0);
                                            videoInfoViewModel$WrappedData3.setMoreType(1);
                                            arrayList0.add(videoInfoViewModel$WrappedData3);
                                        }
                                    }
                                    else if(v2 > 4) {
                                        WrappedData videoInfoViewModel$WrappedData2 = new WrappedData(6, list0);
                                        videoInfoViewModel$WrappedData2.setMoreType(1);
                                        arrayList0.add(videoInfoViewModel$WrappedData2);
                                    }
                                    v = 1;
                                }
                                if(vodDetailRes$Response0 == null) {
                                    arrayList4 = null;
                                }
                                else {
                                    Artist vodDetailRes$Response$Artist0 = vodDetailRes$Response0.artist;
                                    arrayList4 = vodDetailRes$Response$Artist0 == null ? null : vodDetailRes$Response$Artist0.artistList;
                                }
                                if(arrayList4 != null && !arrayList4.isEmpty()) {
                                    if(vodDetailRes$Response0 == null) {
                                        s3 = null;
                                    }
                                    else {
                                        Artist vodDetailRes$Response$Artist1 = vodDetailRes$Response0.artist;
                                        s3 = vodDetailRes$Response$Artist1 == null ? null : vodDetailRes$Response$Artist1.title;
                                    }
                                    arrayList0.add(new WrappedData(4, s3));
                                    int v8 = 0;
                                    for(Object object4: p.K0(3, arrayList4)) {
                                        if(v8 >= 0) {
                                            WrappedData videoInfoViewModel$WrappedData4 = new WrappedData(5, ((ArtistsInfoBase)object4));
                                            videoInfoViewModel$WrappedData4.setIndex(v8 + 1);
                                            arrayList0.add(videoInfoViewModel$WrappedData4);
                                            ++v8;
                                            continue;
                                        }
                                        k.O();
                                        throw null;
                                    }
                                    if(arrayList4.size() > 3) {
                                        WrappedData videoInfoViewModel$WrappedData5 = new WrappedData(6, arrayList4);
                                        videoInfoViewModel$WrappedData5.setMoreType(2);
                                        arrayList0.add(videoInfoViewModel$WrappedData5);
                                    }
                                    v = 1;
                                }
                                if(vodDetailRes$Response0 == null) {
                                    arrayList5 = null;
                                }
                                else {
                                    Song vodDetailRes$Response$Song0 = vodDetailRes$Response0.song;
                                    arrayList5 = vodDetailRes$Response$Song0 == null ? null : vodDetailRes$Response$Song0.songList;
                                }
                                if(arrayList5 != null && !arrayList5.isEmpty()) {
                                    if(vodDetailRes$Response0 == null) {
                                        s4 = null;
                                    }
                                    else {
                                        Song vodDetailRes$Response$Song1 = vodDetailRes$Response0.song;
                                        s4 = vodDetailRes$Response$Song1 == null ? null : vodDetailRes$Response$Song1.title;
                                    }
                                    arrayList0.add(new WrappedData(4, s4));
                                    int v9 = 0;
                                    for(Object object5: p.K0(3, arrayList5)) {
                                        if(v9 >= 0) {
                                            WrappedData videoInfoViewModel$WrappedData6 = new WrappedData(7, ((SongInfoBase)object5));
                                            videoInfoViewModel$WrappedData6.setIndex(v9 + 1);
                                            arrayList0.add(videoInfoViewModel$WrappedData6);
                                            ++v9;
                                            continue;
                                        }
                                        k.O();
                                        throw null;
                                    }
                                    if(arrayList5.size() > 3) {
                                        WrappedData videoInfoViewModel$WrappedData7 = new WrappedData(6, arrayList5);
                                        videoInfoViewModel$WrappedData7.setMoreType(3);
                                        arrayList0.add(videoInfoViewModel$WrappedData7);
                                    }
                                    v = 1;
                                }
                                if(vodDetailRes$Response0 == null) {
                                    arrayList6 = null;
                                }
                                else {
                                    Dj vodDetailRes$Response$Dj0 = vodDetailRes$Response0.dj;
                                    arrayList6 = vodDetailRes$Response$Dj0 == null ? null : vodDetailRes$Response$Dj0.djPlaylistList;
                                }
                                if(arrayList6 != null && !arrayList6.isEmpty()) {
                                    if(vodDetailRes$Response0 == null) {
                                        s5 = null;
                                    }
                                    else {
                                        Dj vodDetailRes$Response$Dj1 = vodDetailRes$Response0.dj;
                                        s5 = vodDetailRes$Response$Dj1 == null ? null : vodDetailRes$Response$Dj1.title;
                                    }
                                    arrayList0.add(new WrappedData(4, s5));
                                    if(arrayList6 != null) {
                                        int v10 = 0;
                                        for(Object object6: p.K0(3, arrayList6)) {
                                            if(v10 >= 0) {
                                                WrappedData videoInfoViewModel$WrappedData8 = new WrappedData(8, ((DjPlayListInfoBase)object6));
                                                videoInfoViewModel$WrappedData8.setIndex(v10 + 1);
                                                arrayList0.add(videoInfoViewModel$WrappedData8);
                                                ++v10;
                                                continue;
                                            }
                                            k.O();
                                            throw null;
                                        }
                                    }
                                    v = 1;
                                }
                                if(vodDetailRes$Response0 == null) {
                                    arrayList7 = null;
                                }
                                else {
                                    Magazine vodDetailRes$Response$Magazine0 = vodDetailRes$Response0.magazine;
                                    arrayList7 = vodDetailRes$Response$Magazine0 == null ? null : vodDetailRes$Response$Magazine0.magazineList;
                                }
                                if(arrayList7 != null && !arrayList7.isEmpty()) {
                                    if(vodDetailRes$Response0 == null) {
                                        s6 = null;
                                    }
                                    else {
                                        Magazine vodDetailRes$Response$Magazine1 = vodDetailRes$Response0.magazine;
                                        s6 = vodDetailRes$Response$Magazine1 == null ? null : vodDetailRes$Response$Magazine1.title;
                                    }
                                    arrayList0.add(new WrappedData(4, s6));
                                    if(arrayList7 != null) {
                                        int v11 = 0;
                                        for(Object object7: p.K0(3, arrayList7)) {
                                            if(v11 >= 0) {
                                                WrappedData videoInfoViewModel$WrappedData9 = new WrappedData(9, ((MagazineList)object7));
                                                videoInfoViewModel$WrappedData9.setIndex(v11 + 1);
                                                arrayList0.add(videoInfoViewModel$WrappedData9);
                                                ++v11;
                                                continue;
                                            }
                                            k.O();
                                            throw null;
                                        }
                                    }
                                    v = 1;
                                }
                                if(vodDetailRes$Response0 == null) {
                                    vodDetailRes$Response$Concert$Ticket0 = null;
                                }
                                else {
                                    Concert vodDetailRes$Response$Concert0 = vodDetailRes$Response0.concert;
                                    vodDetailRes$Response$Concert$Ticket0 = vodDetailRes$Response$Concert0 == null ? null : vodDetailRes$Response$Concert0.ticket;
                                }
                                if(vodDetailRes$Response$Concert$Ticket0 != null) {
                                    arrayList0.add(new WrappedData(4, (vodDetailRes$Response0.concert == null ? null : vodDetailRes$Response0.concert.title)));
                                    arrayList0.add(new WrappedData(10, vodDetailRes$Response$Concert$Ticket0));
                                    v = 1;
                                }
                                if(v == 0) {
                                    arrayList0.add(new WrappedData(13, null));
                                }
                                arrayList0.add(new WrappedData(14, null));
                                videoInfoViewModel0.c.postValue(arrayList0);
                                this.E = coroutineScope0;
                                this.r = null;
                                this.w = i2;
                                this.B = v;
                                this.D = 3;
                                if(videoInfoViewModel0.b(videoInfoViewModel0.getBbsChannelSeq(), i.b, coroutineScope0, this) != a0) {
                                label_287:
                                    this.E = null;
                                    this.r = null;
                                    this.w = i2;
                                    this.B = v;
                                    this.D = 4;
                                    if(videoInfoViewModel0.c(videoInfoViewModel0.getBbsChannelSeq(), videoInfoViewModel0.getMvId(), coroutineScope0, this) != a0) {
                                        i1 = i2;
                                        i2 = i1;
                                        videoInfoViewModel0.get_response().setValue(i2);
                                        return i2.a == h.a;
                                    }
                                }
                            }
                        }
                        break;
                    }
                    case 1: {
                        n.D(object0);
                        object2 = object0;
                        goto label_27;
                    }
                    case 2: {
                        i3 = this.r;
                        n.D(object0);
                        object1 = object0;
                        goto label_34;
                    }
                    case 3: {
                        v = this.B;
                        i2 = this.w;
                        n.D(object0);
                        goto label_287;
                    }
                    case 4: {
                        i1 = this.w;
                        n.D(object0);
                        i2 = i1;
                        videoInfoViewModel0.get_response().setValue(i2);
                        return i2.a == h.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return a0;
            }
        }, continuation0);
    }

    public final int getBbsChannelSeq() {
        return this.k;
    }

    @Override  // v8.f
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.b1.buildUpon(), "mvId", this.b, "toString(...)");
    }

    @NotNull
    public final K getCommentList() {
        return this.f;
    }

    @Nullable
    public final Playable getCurrentPlayable() {
        return this.a;
    }

    @NotNull
    public final K getInformCmtContsSumm() {
        return this.h;
    }

    @NotNull
    public final K getLike() {
        return this.j;
    }

    @NotNull
    public final K getList() {
        return this.d;
    }

    @NotNull
    public final String getMvId() {
        return this.b;
    }

    @Override  // v8.a
    @NotNull
    public String getTag() {
        String s = MelonContentUris.b1.toString();
        q.f(s, "toString(...)");
        return s;
    }

    public final boolean isLoginUser() {
        return ((e0)o.a()).m();
    }

    @Nullable
    public final Object requestLike(@Nullable String s, @NotNull CoroutineScope coroutineScope0, @NotNull Continuation continuation0) {
        String s2;
        com.iloen.melon.player.video.VideoInfoViewModel.requestLike.1 videoInfoViewModel$requestLike$10;
        if(continuation0 instanceof com.iloen.melon.player.video.VideoInfoViewModel.requestLike.1) {
            videoInfoViewModel$requestLike$10 = (com.iloen.melon.player.video.VideoInfoViewModel.requestLike.1)continuation0;
            int v = videoInfoViewModel$requestLike$10.B;
            if((v & 0x80000000) == 0) {
                videoInfoViewModel$requestLike$10 = new c(this) {
                    public int B;
                    public Object r;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.r = object0;
                        this.B |= 0x80000000;
                        return this.w.requestLike(null, null, this);
                    }
                };
            }
            else {
                videoInfoViewModel$requestLike$10.B = v ^ 0x80000000;
            }
        }
        else {
            videoInfoViewModel$requestLike$10 = new c(this) {
                public int B;
                public Object r;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.r = object0;
                    this.B |= 0x80000000;
                    return this.w.requestLike(null, null, this);
                }
            };
        }
        Object object0 = videoInfoViewModel$requestLike$10.r;
        a a0 = a.a;
        H h0 = H.a;
        String s1 = null;
        switch(videoInfoViewModel$requestLike$10.B) {
            case 0: {
                n.D(object0);
                if(s == null || s.length() == 0) {
                    LogU.Companion.d("VideoInfoViewModel", "progSeq is invalid");
                    return h0;
                }
                if(!this.isLoginUser()) {
                    LogU.Companion.d("VideoInfoViewModel", "not login");
                    return h0;
                }
                com.iloen.melon.net.v4x.request.MyMusicLikeInformContentsLikeReq.Params myMusicLikeInformContentsLikeReq$Params0 = new com.iloen.melon.net.v4x.request.MyMusicLikeInformContentsLikeReq.Params();
                myMusicLikeInformContentsLikeReq$Params0.contsId = this.b;
                myMusicLikeInformContentsLikeReq$Params0.contsTypeCode = "N10003";
                myMusicLikeInformContentsLikeReq$Params0.actTypeCode = "N20001";
                Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new VideoInfoViewModel.requestLikeAsync.1(myMusicLikeInformContentsLikeReq$Params0, this, null), 3, null);
                videoInfoViewModel$requestLike$10.B = 1;
                object0 = deferred0.await(videoInfoViewModel$requestLike$10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        v8.i i0 = e1.n.g(((d)object0), i.b);
        if(i0.a == h.a) {
            MyMusicLikeInformContentsLikeRes myMusicLikeInformContentsLikeRes0 = (MyMusicLikeInformContentsLikeRes)i0.c;
            com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes.RESPONSE myMusicLikeInformContentsLikeRes$RESPONSE0 = myMusicLikeInformContentsLikeRes0 == null ? null : myMusicLikeInformContentsLikeRes0.response;
            if(myMusicLikeInformContentsLikeRes$RESPONSE0 != null) {
                s1 = myMusicLikeInformContentsLikeRes$RESPONSE0.likeyn;
            }
            boolean z = q.b(s1, "Y");
            if(myMusicLikeInformContentsLikeRes$RESPONSE0 == null) {
                s2 = "0";
            }
            else {
                s2 = myMusicLikeInformContentsLikeRes$RESPONSE0.summcnt;
                if(s2 == null) {
                    s2 = "0";
                }
            }
            LikeData videoInfoViewModel$LikeData0 = new LikeData(z, s2);
            this.i.postValue(videoInfoViewModel$LikeData0);
        }
        return h0;
    }

    public final void setBbsChannelSeq(int v) {
        this.k = v;
    }

    public final void setCurrentPlayable(@Nullable Playable playable0) {
        String s;
        if(playable0 == null) {
            s = "";
        }
        else {
            s = playable0.getMvid();
            if(s == null) {
                s = "";
            }
        }
        this.b = s;
        this.a = playable0;
    }

    public final void setMvId(@NotNull String s) {
        q.g(s, "<set-?>");
        this.b = s;
    }
}

