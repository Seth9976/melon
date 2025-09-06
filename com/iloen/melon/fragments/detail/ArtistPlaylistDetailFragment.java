package com.iloen.melon.fragments.detail;

import F8.I;
import F8.o;
import J8.E2;
import J8.m0;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.comments.CommentLatestList;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.ArtistPlylstMainInfoReq.Params;
import com.iloen.melon.net.v4x.request.ArtistPlylstMainInfoReq;
import com.iloen.melon.net.v4x.request.ArtistPlylstSongListReq;
import com.iloen.melon.net.v4x.response.ArtistPlylstMainInfoRes.RESPONSE;
import com.iloen.melon.net.v4x.response.ArtistPlylstMainInfoRes;
import com.iloen.melon.net.v4x.response.ArtistPlylstSongListRes;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableArtistPlaylist;
import com.iloen.melon.sns.model.b;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.ui.F1;
import com.melon.ui.V1;
import com.melon.ui.k2;
import com.melon.ui.x1;
import e1.u;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.p;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import me.i;
import ne.a;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.s;
import va.e0;
import we.n;
import zd.M;

@Metadata(d1 = {"\u0000\u00A2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 _2\u00020\u0001:\u0001_B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u000E\u0010\fJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0014\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u001D\u001A\u00020\u001C2\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\b\u0010\u001A\u001A\u0004\u0018\u00010\u00192\b\u0010\u001B\u001A\u0004\u0018\u00010\u0004H\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u001F\u0010\u0003J\u000F\u0010!\u001A\u0004\u0018\u00010 \u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b#\u0010\u0003J\u001A\u0010%\u001A\u00020\n2\b\u0010$\u001A\u0004\u0018\u00010 H\u0086@\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010\'\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\'\u0010\u0006J\u0017\u0010)\u001A\n (*\u0004\u0018\u00010\u00040\u0004H\u0016\u00A2\u0006\u0004\b)\u0010\u0006J\u000F\u0010*\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b*\u0010\u0006J\u0011\u0010,\u001A\u0004\u0018\u00010+H\u0014\u00A2\u0006\u0004\b,\u0010-J\u000F\u0010.\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b.\u0010\u0003J\u001F\u00103\u001A\u00020\n2\u0006\u00100\u001A\u00020/2\u0006\u00102\u001A\u000201H\u0016\u00A2\u0006\u0004\b3\u00104J\u0017\u00107\u001A\n\u0012\u0004\u0012\u000206\u0018\u000105H\u0016\u00A2\u0006\u0004\b7\u00108J}\u0010F\u001A\u00020\n2\b\u0010:\u001A\u0004\u0018\u0001092\b\u0010;\u001A\u0004\u0018\u00010\u00042\b\u0010<\u001A\u0004\u0018\u00010\u00042\b\u0010=\u001A\u0004\u0018\u00010\u00042\b\u0010?\u001A\u0004\u0018\u00010>2\b\u0010@\u001A\u0004\u0018\u00010\u00042\b\u0010A\u001A\u0004\u0018\u00010\u00042\b\u0010B\u001A\u0004\u0018\u00010\u00042\b\u0010C\u001A\u0004\u0018\u00010\u00042\b\u0010D\u001A\u0004\u0018\u00010\u00042\b\u0010E\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\bF\u0010GJ\u0011\u0010I\u001A\u0004\u0018\u00010HH\u0016\u00A2\u0006\u0004\bI\u0010JJ\u0019\u0010L\u001A\u0004\u0018\u00010 2\u0006\u0010K\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bL\u0010MJ\u0019\u0010O\u001A\u0004\u0018\u00010N2\u0006\u0010K\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bO\u0010PR\u0016\u0010Q\u001A\u00020\u00128\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010S\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010U\u001A\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001A\u00020W8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010Z\u001A\u00020W8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bZ\u0010YR\u0014\u0010^\u001A\u00020[8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\\\u0010]\u00A8\u0006`"}, d2 = {"Lcom/iloen/melon/fragments/detail/ArtistPlaylistDetailFragment;", "Lcom/iloen/melon/fragments/detail/PlaylistDetailBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "getDetailCacheKey", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "LQ4/a;", "onCreateHeaderLayout", "()LQ4/a;", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "updateHeaderView", "Lcom/iloen/melon/net/v4x/response/ArtistPlylstMainInfoRes;", "fetchDetailCacheData", "()Lcom/iloen/melon/net/v4x/response/ArtistPlylstMainInfoRes;", "showContextPopupPlaylistDetail", "response", "drawHeaderView", "(Lcom/iloen/melon/net/v4x/response/ArtistPlylstMainInfoRes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContsId", "kotlin.jvm.PlatformType", "getContsTypeCode", "getPageMetaType", "Lcom/iloen/melon/sns/model/Sharable;", "getSNSSharable", "()Lcom/iloen/melon/sns/model/Sharable;", "openProfile", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "loadPgnRes", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "listCmtRes", "updateCommentListView", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)V", "", "Lcom/melon/net/res/common/SongInfoBase;", "getAllSongList", "()Ljava/util/List;", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "actionName", "clickLayer1", "clickCopy", "", "ordNum", "image", "eventMetaId", "eventMetaType", "eventMetaName", "eventMetaAuthor", "propsLikeType", "itemClickLog", "(Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "playlistSeq", "requestPlaylistInfo", "(Ljava/lang/String;)Lcom/iloen/melon/net/v4x/response/ArtistPlylstMainInfoRes;", "Lcom/iloen/melon/net/v4x/response/ArtistPlylstSongListRes;", "requestSongList", "(Ljava/lang/String;)Lcom/iloen/melon/net/v4x/response/ArtistPlylstSongListRes;", "bottomDivider", "Landroid/view/View;", "playlistInfoRes", "Lcom/iloen/melon/net/v4x/response/ArtistPlylstMainInfoRes;", "songRes", "Lcom/iloen/melon/net/v4x/response/ArtistPlylstSongListRes;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "mainExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "subExceptionHandler", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistPlaylistDetailFragment extends Hilt_ArtistPlaylistDetailFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005H\u0007J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\nH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/detail/ArtistPlaylistDetailFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/ArtistPlaylistDetailFragment;", "playlistSeq", "showSnsPopup", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistPlaylistDetailFragment newInstance(@NotNull String s) {
            q.g(s, "playlistSeq");
            ArtistPlaylistDetailFragment artistPlaylistDetailFragment0 = new ArtistPlaylistDetailFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argItemId", s);
            artistPlaylistDetailFragment0.setArguments(bundle0);
            return artistPlaylistDetailFragment0;
        }

        @NotNull
        public final ArtistPlaylistDetailFragment newInstance(@NotNull String s, boolean z) {
            q.g(s, "playlistSeq");
            ArtistPlaylistDetailFragment artistPlaylistDetailFragment0 = new ArtistPlaylistDetailFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argItemId", s);
            bundle0.putBoolean("argVisibleSnsPopup", z);
            artistPlaylistDetailFragment0.setArguments(bundle0);
            return artistPlaylistDetailFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "ArtistPlaylistDetailFragment";
    private View bottomDivider;
    @NotNull
    private final CoroutineExceptionHandler mainExceptionHandler;
    @Nullable
    private ArtistPlylstMainInfoRes playlistInfoRes;
    @Nullable
    private ArtistPlylstSongListRes songRes;
    @NotNull
    private final CoroutineExceptionHandler subExceptionHandler;

    static {
        ArtistPlaylistDetailFragment.Companion = new Companion(null);
        ArtistPlaylistDetailFragment.$stable = 8;
    }

    public ArtistPlaylistDetailFragment() {
        this.mainExceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(i i0, Throwable throwable0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.mainExceptionHandler.1.1(throwable0, ArtistPlaylistDetailFragment.this, null), 3, null);
            }
        };
        this.subExceptionHandler = new CoroutineExceptionHandler(/*ERROR_MISSING_ARG_0/*) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(i i0, Throwable throwable0) {
                Y.w("subExceptionHandler message = ", throwable0.getMessage(), LogU.Companion, "ArtistPlaylistDetailFragment");
            }
        };

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment$mainExceptionHandler$1$1", f = "ArtistPlaylistDetailFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.mainExceptionHandler.1.1 extends oe.i implements n {
            final Throwable $throwable;
            int label;

            public com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.mainExceptionHandler.1.1(Throwable throwable0, ArtistPlaylistDetailFragment artistPlaylistDetailFragment0, Continuation continuation0) {
                this.$throwable = throwable0;
                ArtistPlaylistDetailFragment.this = artistPlaylistDetailFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.mainExceptionHandler.1.1(this.$throwable, ArtistPlaylistDetailFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.mainExceptionHandler.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                if(this.$throwable instanceof VolleyError) {
                    ArtistPlaylistDetailFragment.this.showNetworkErrorHeaderView(true);
                    ArtistPlaylistDetailFragment.access$getMResponseErrorListener$p$s1345721466(ArtistPlaylistDetailFragment.this).onErrorResponse(((VolleyError)this.$throwable));
                }
                return H.a;
            }
        }

    }

    public static final ErrorListener access$getMResponseErrorListener$p$s1345721466(ArtistPlaylistDetailFragment artistPlaylistDetailFragment0) {
        return artistPlaylistDetailFragment0.mResponseErrorListener;
    }

    @Nullable
    public final Object drawHeaderView(@Nullable ArtistPlylstMainInfoRes artistPlylstMainInfoRes0, @NotNull Continuation continuation0) {
        com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.drawHeaderView.1 artistPlaylistDetailFragment$drawHeaderView$10;
        if(continuation0 instanceof com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.drawHeaderView.1) {
            artistPlaylistDetailFragment$drawHeaderView$10 = (com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.drawHeaderView.1)continuation0;
            int v = artistPlaylistDetailFragment$drawHeaderView$10.label;
            if((v & 0x80000000) == 0) {
                artistPlaylistDetailFragment$drawHeaderView$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.drawHeaderView(null, this);
                    }
                };
            }
            else {
                artistPlaylistDetailFragment$drawHeaderView$10.label = v ^ 0x80000000;
            }
        }
        else {
            artistPlaylistDetailFragment$drawHeaderView$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.drawHeaderView(null, this);
                }
            };
        }
        Object object0 = artistPlaylistDetailFragment$drawHeaderView$10.result;
        a a0 = a.a;
        H h0 = H.a;
        switch(artistPlaylistDetailFragment$drawHeaderView$10.label) {
            case 0: {
                d5.n.D(object0);
                if(this.isFragmentValid() && artistPlylstMainInfoRes0 != null) {
                    RESPONSE artistPlylstMainInfoRes$RESPONSE0 = artistPlylstMainInfoRes0.response;
                    if(artistPlylstMainInfoRes$RESPONSE0 != null) {
                        E2 e20 = this.getPlaylistDetailHeaderBinding();
                        if(e20 != null) {
                            MelonImageView melonImageView0 = e20.J.b;
                            String s = artistPlylstMainInfoRes$RESPONSE0.playTime;
                            q.f(s, "playTime");
                            this.setTotalPlayTime(s);
                            String s1 = artistPlylstMainInfoRes$RESPONSE0.songCnt;
                            q.f(s1, "songCnt");
                            this.setTotalSongCount(s1);
                            Glide.with(melonImageView0).load(artistPlylstMainInfoRes$RESPONSE0.thumbImg).into(melonImageView0);
                            int v1 = ScreenUtils.dipToPixel(this.getContext(), 32.0f);
                            ViewUtils.setDefaultImage(e20.M.c, v1, true);
                            Glide.with(e20.M.b).load(ProtocolUtils.getFirstArtistImg(artistPlylstMainInfoRes$RESPONSE0.artistList)).apply(RequestOptions.circleCropTransform()).into(e20.M.b);
                            if(artistPlylstMainInfoRes$RESPONSE0.thumbImg != null && artistPlylstMainInfoRes$RESPONSE0.thumbImg.length() > 0) {
                                melonImageView0.setOnClickListener(new T(artistPlylstMainInfoRes$RESPONSE0, 2));
                            }
                            String s2 = artistPlylstMainInfoRes$RESPONSE0.plylstTitle;
                            q.f(s2, "plylstTitle");
                            this.setTitleText(s2);
                            e20.I.setText(this.getTitleText());
                            String s3 = ProtocolUtils.getArtistNames(artistPlylstMainInfoRes$RESPONSE0.artistList);
                            e20.H.setText(s3);
                            e20.x.setText(artistPlylstMainInfoRes$RESPONSE0.updtDateStr);
                            e20.o.setVisibility(8);
                            e20.f.setVisibility(8);
                            ViewUtils.showWhen(e20.p, true);
                            if(this.getLikeCount() < 0) {
                                this.setLikeCount(this.likeCountToInt(artistPlylstMainInfoRes$RESPONSE0.likeCnt));
                                this.setLike(q.b(artistPlylstMainInfoRes$RESPONSE0.likeYN, "Y"));
                            }
                            this.updateLikeView();
                            if(artistPlylstMainInfoRes$RESPONSE0.plylstDesc != null && artistPlylstMainInfoRes$RESPONSE0.plylstDesc.length() > 0) {
                                String s4 = artistPlylstMainInfoRes$RESPONSE0.plylstDesc;
                                q.f(s4, "plylstDesc");
                                this.setDescText(s4, e20);
                            }
                            h h1 = new h(0, this, artistPlylstMainInfoRes$RESPONSE0);
                            e20.G.setOnClickListener(h1);
                            g g0 = new g(this, 1);
                            ViewUtils.setOnClickListener(e20.E, g0);
                            g g1 = new g(this, 2);
                            e20.d.setOnClickListener(g1);
                            e20.g.setText(String.valueOf(this.getCommentCount()));
                        }
                        if(this.isLoginUser()) {
                            artistPlaylistDetailFragment$drawHeaderView$10.L$0 = null;
                            artistPlaylistDetailFragment$drawHeaderView$10.L$1 = null;
                            artistPlaylistDetailFragment$drawHeaderView$10.label = 1;
                            if(this.getUserActionsFromServerAndUpdateUi(artistPlaylistDetailFragment$drawHeaderView$10) == a0) {
                                return a0;
                            }
                        }
                        this.setSongListHeader();
                        return h0;
                    }
                }
                break;
            }
            case 1: {
                RESPONSE artistPlylstMainInfoRes$RESPONSE1 = (RESPONSE)artistPlaylistDetailFragment$drawHeaderView$10.L$1;
                ArtistPlylstMainInfoRes artistPlylstMainInfoRes1 = (ArtistPlylstMainInfoRes)artistPlaylistDetailFragment$drawHeaderView$10.L$0;
                d5.n.D(object0);
                this.setSongListHeader();
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }

    private static final void drawHeaderView$lambda$11$lambda$10(ArtistPlaylistDetailFragment artistPlaylistDetailFragment0, View view0) {
        artistPlaylistDetailFragment0.getOnViewHolderActionListener().onOpenCommentListView();
        artistPlaylistDetailFragment0.itemClickLog(null, artistPlaylistDetailFragment0.getString(0x7F130DC9), artistPlaylistDetailFragment0.getString(0x7F130DF5), artistPlaylistDetailFragment0.getString(0x7F130D14));  // string:tiara_common_action_name_move_page "페이지이동"
    }

    private static final void drawHeaderView$lambda$11$lambda$7(RESPONSE artistPlylstMainInfoRes$RESPONSE0, View view0) {
        Navigator.openPhotoUrl(artistPlylstMainInfoRes$RESPONSE0.thumbImg);
    }

    private static final void drawHeaderView$lambda$11$lambda$8(ArtistPlaylistDetailFragment artistPlaylistDetailFragment0, RESPONSE artistPlylstMainInfoRes$RESPONSE0, View view0) {
        artistPlaylistDetailFragment0.showArtistInfoPage(artistPlylstMainInfoRes$RESPONSE0.artistList);
        String s = null;
        ArtistInfoBase artistInfoBase0 = artistPlylstMainInfoRes$RESPONSE0.artistList == null ? null : ((ArtistInfoBase)p.m0(artistPlylstMainInfoRes$RESPONSE0.artistList));
        String s1 = artistPlaylistDetailFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        String s2 = artistPlaylistDetailFragment0.getString(0x7F130DF5);  // string:tiara_common_layer1_introduce "소개"
        String s3 = artistPlaylistDetailFragment0.getString(0x7F130E61);  // string:tiara_djplaylist_copy_move_profile "DJ프로필이동"
        String s4 = artistInfoBase0 == null ? null : artistInfoBase0.getArtistId();
        String s5 = artistPlaylistDetailFragment0.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
        if(artistInfoBase0 != null) {
            s = artistInfoBase0.getArtistName();
        }
        PlaylistDetailBaseFragment.itemClickLog$default(artistPlaylistDetailFragment0, null, s1, s2, s3, null, null, s4, s5, s, null, null, 0x400, null);
    }

    private static final void drawHeaderView$lambda$11$lambda$9(ArtistPlaylistDetailFragment artistPlaylistDetailFragment0, View view0) {
        View view1 = view0.findViewById(0x7F0A076B);  // id:liked_cnt
        q.f(view1, "findViewById(...)");
        artistPlaylistDetailFragment0.updateLikeInfo(view1);
        String s = artistPlaylistDetailFragment0.getString(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
        String s1 = artistPlaylistDetailFragment0.getString(0x7F130DF5);  // string:tiara_common_layer1_introduce "소개"
        String s2 = artistPlaylistDetailFragment0.getString(0x7F130D41);  // string:tiara_click_copy_like "좋아요"
        artistPlaylistDetailFragment0.itemClickLog(ActionKind.Like, s, s1, s2);
    }

    @Nullable
    public final ArtistPlylstMainInfoRes fetchDetailCacheData() {
        Cursor cursor0 = com.iloen.melon.responsecache.a.f(this.getContext(), this.getDetailCacheKey());
        if(cursor0 == null) {
            return null;
        }
        ArtistPlylstMainInfoRes artistPlylstMainInfoRes0 = (ArtistPlylstMainInfoRes)com.iloen.melon.responsecache.a.d(cursor0, ArtistPlylstMainInfoRes.class);
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        return artistPlylstMainInfoRes0 == null ? null : artistPlylstMainInfoRes0;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @Nullable
    public List getAllSongList() {
        ArtistPlylstSongListRes artistPlylstSongListRes0 = this.songRes;
        if(artistPlylstSongListRes0 != null) {
            return artistPlylstSongListRes0.response == null ? null : artistPlylstSongListRes0.response.songList;
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.K0.buildUpon().appendPath(this.getPlaylistSeq()).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @NotNull
    public String getContsId() {
        return this.getPlaylistSeq();
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public String getContsTypeCode() {
        return "N10016";
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @NotNull
    public i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getDetailCacheKey() {
        String s = MelonContentUris.L0.buildUpon().appendPath(this.getPlaylistSeq()).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @NotNull
    public String getPageMetaType() {
        String s = this.getString(0x7F130CE6);  // string:tiara_artistplaylist_meta_type "아티스트플레이리스트"
        q.f(s, "getString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @Nullable
    public Sharable getSNSSharable() {
        if(!TextUtils.isEmpty(this.getPlaylistSeq()) && (this.playlistInfoRes == null ? null : this.playlistInfoRes.response) != null) {
            String s = this.getPlaylistSeq();
            RESPONSE artistPlylstMainInfoRes$RESPONSE0 = this.playlistInfoRes == null ? null : this.playlistInfoRes.response;
            if(artistPlylstMainInfoRes$RESPONSE0 != null && artistPlylstMainInfoRes$RESPONSE0.artistList.size() != 0) {
                String s1 = ((ArtistInfoBase)artistPlylstMainInfoRes$RESPONSE0.artistList.get(0)).getArtistId();
                String s2 = ((ArtistInfoBase)artistPlylstMainInfoRes$RESPONSE0.artistList.get(0)).getArtistName();
                String s3 = artistPlylstMainInfoRes$RESPONSE0.plylstTitle;
                String s4 = artistPlylstMainInfoRes$RESPONSE0.songCnt;
                String s5 = artistPlylstMainInfoRes$RESPONSE0.postImg;
                String s6 = artistPlylstMainInfoRes$RESPONSE0.postEditImg;
                String s7 = artistPlylstMainInfoRes$RESPONSE0.updtDateTime;
                b b0 = new b();  // 初始化器: Lcom/iloen/melon/sns/model/c;-><init>()V
                b0.j = s1;
                b0.k = s2;
                b0.a = s;
                b0.e = s3;
                b0.h = s4;
                b0.b = s5;
                b0.c = s6;
                b0.g = s7;
                return new SharableArtistPlaylist(b0);
            }
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @Nullable
    public f getTiaraEventBuilder() {
        String s = null;
        if(this.mMelonTiaraProperty == null) {
            return null;
        }
        f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        s s1 = this.mMelonTiaraProperty;
        f0.b = s1 == null ? null : s1.a;
        if(s1 != null) {
            s = s1.b;
        }
        f0.c = s;
        f0.o = this.getContsId();
        f0.p = this.getString(0x7F130E6B);  // string:tiara_djplaylist_meta_type "DJ플레이리스트"
        f0.q = this.getTitleText();
        f0.I = this.getMenuId();
        return f0;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void itemClickLog(@Nullable ActionKind actionKind0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable Integer integer0, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8) {
        p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        g0.d = actionKind0;
        g0.a = s;
        s s9 = this.mMelonTiaraProperty;
        String s10 = null;
        g0.b = s9 == null ? null : s9.a;
        if(s9 != null) {
            s10 = s9.b;
        }
        g0.c = s10;
        g0.y = s1;
        g0.F = s2;
        g0.o = this.getContsId();
        g0.p = this.getString(0x7F130CE6);  // string:tiara_artistplaylist_meta_type "아티스트플레이리스트"
        g0.q = this.getTitleText();
        g0.e = s4;
        g0.f = s5;
        g0.g = s6;
        g0.I = this.getMenuId();
        if(integer0 != null) {
            g0.c(((int)integer0));
        }
        g0.a().track();
    }

    @NotNull
    public static final ArtistPlaylistDetailFragment newInstance(@NotNull String s) {
        return ArtistPlaylistDetailFragment.Companion.newInstance(s);
    }

    @NotNull
    public static final ArtistPlaylistDetailFragment newInstance(@NotNull String s, boolean z) {
        return ArtistPlaylistDetailFragment.Companion.newInstance(s, z);
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @NotNull
    public Q4.a onCreateHeaderLayout() {
        return E2.a(LayoutInflater.from(this.getContext()));
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable v9.h h0, @Nullable String s) {
        this.setFetchStart(true);
        BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO().plus(this.mainExceptionHandler), null, new n(i0, null) {
            final v9.i $type;
            int label;

            {
                ArtistPlaylistDetailFragment.this = artistPlaylistDetailFragment0;
                this.$type = i0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.onFetchStart.1(ArtistPlaylistDetailFragment.this, this.$type, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.onFetchStart.1.1 artistPlaylistDetailFragment$onFetchStart$1$10 = new n(this.$type, null) {
                            final v9.i $type;
                            private Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            int label;

                            {
                                ArtistPlaylistDetailFragment.this = artistPlaylistDetailFragment0;
                                this.$type = i0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.onFetchStart.1.1(ArtistPlaylistDetailFragment.this, this.$type, continuation0);
                                continuation1.L$0 = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.onFetchStart.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                kotlin.jvm.internal.H h1;
                                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                                a a0 = a.a;
                                switch(this.label) {
                                    case 0: {
                                        kotlin.jvm.internal.H h0 = H0.b.p(object0);
                                        Job[] arr_job = {BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(null) {
                                            int label;

                                            {
                                                ArtistPlaylistDetailFragment.this = artistPlaylistDetailFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.onFetchStart.1.1.playlistInfoJob.1(ArtistPlaylistDetailFragment.this, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.onFetchStart.1.1.playlistInfoJob.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                if(this.label != 0) {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                                d5.n.D(object0);
                                                ArtistPlylstMainInfoRes artistPlylstMainInfoRes0 = ArtistPlaylistDetailFragment.this.requestPlaylistInfo(ArtistPlaylistDetailFragment.this.getPlaylistSeq());
                                                ArtistPlaylistDetailFragment.this.playlistInfoRes = artistPlylstMainInfoRes0;
                                                return H.a;
                                            }
                                        }, 3, null), BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(ArtistPlaylistDetailFragment.this, null) {
                                            final kotlin.jvm.internal.H $playlistSongRes;
                                            int label;

                                            {
                                                this.$playlistSongRes = h0;
                                                ArtistPlaylistDetailFragment.this = artistPlaylistDetailFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.onFetchStart.1.1.playlistSongJob.1(this.$playlistSongRes, ArtistPlaylistDetailFragment.this, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.onFetchStart.1.1.playlistSongJob.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                if(this.label != 0) {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                                d5.n.D(object0);
                                                this.$playlistSongRes.a = ArtistPlaylistDetailFragment.this.requestSongList(ArtistPlaylistDetailFragment.this.getPlaylistSeq());
                                                return H.a;
                                            }
                                        }, 3, null)};
                                        this.L$0 = null;
                                        this.L$1 = h0;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.label = 1;
                                        if(AwaitKt.joinAll(arr_job, this) == a0) {
                                            return a0;
                                        }
                                        h1 = h0;
                                        goto label_18;
                                    }
                                    case 1: {
                                        Job job0 = (Job)this.L$3;
                                        Job job1 = (Job)this.L$2;
                                        h1 = (kotlin.jvm.internal.H)this.L$1;
                                        d5.n.D(object0);
                                    label_18:
                                        ArtistPlylstMainInfoRes artistPlylstMainInfoRes0 = ArtistPlaylistDetailFragment.this.playlistInfoRes;
                                        if(artistPlylstMainInfoRes0 != null && artistPlylstMainInfoRes0.isSuccessful()) {
                                            i i0 = Dispatchers.getMain().plus(ArtistPlaylistDetailFragment.this.mainExceptionHandler);
                                            com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.onFetchStart.1.1.1 artistPlaylistDetailFragment$onFetchStart$1$1$10 = new n(h1, this.$type, null) {
                                                final kotlin.jvm.internal.H $playlistSongRes;
                                                final v9.i $type;
                                                int label;

                                                {
                                                    ArtistPlaylistDetailFragment.this = artistPlaylistDetailFragment0;
                                                    this.$playlistSongRes = h0;
                                                    this.$type = i0;
                                                    super(2, continuation0);
                                                }

                                                @Override  // oe.a
                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                    return new com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.onFetchStart.1.1.1(ArtistPlaylistDetailFragment.this, this.$playlistSongRes, this.$type, continuation0);
                                                }

                                                @Override  // we.n
                                                public Object invoke(Object object0, Object object1) {
                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                }

                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                    return ((com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.onFetchStart.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                }

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    String s4;
                                                    String s2;
                                                    String s1;
                                                    String s;
                                                    a a0 = a.a;
                                                    switch(this.label) {
                                                        case 0: {
                                                            d5.n.D(object0);
                                                            ArtistPlaylistDetailFragment.this.songRes = (ArtistPlylstSongListRes)this.$playlistSongRes.a;
                                                            ArtistPlaylistDetailFragment artistPlaylistDetailFragment0 = ArtistPlaylistDetailFragment.this;
                                                            ArtistPlylstMainInfoRes artistPlylstMainInfoRes0 = artistPlaylistDetailFragment0.playlistInfoRes;
                                                            if(artistPlylstMainInfoRes0 == null) {
                                                                s = null;
                                                            }
                                                            else {
                                                                RESPONSE artistPlylstMainInfoRes$RESPONSE0 = artistPlylstMainInfoRes0.response;
                                                                s = artistPlylstMainInfoRes$RESPONSE0 == null ? null : artistPlylstMainInfoRes$RESPONSE0.section;
                                                            }
                                                            ArtistPlylstMainInfoRes artistPlylstMainInfoRes1 = ArtistPlaylistDetailFragment.this.playlistInfoRes;
                                                            if(artistPlylstMainInfoRes1 == null) {
                                                                s1 = null;
                                                            }
                                                            else {
                                                                RESPONSE artistPlylstMainInfoRes$RESPONSE1 = artistPlylstMainInfoRes1.response;
                                                                s1 = artistPlylstMainInfoRes$RESPONSE1 == null ? null : artistPlylstMainInfoRes$RESPONSE1.page;
                                                            }
                                                            ArtistPlylstMainInfoRes artistPlylstMainInfoRes2 = ArtistPlaylistDetailFragment.this.playlistInfoRes;
                                                            if(artistPlylstMainInfoRes2 == null) {
                                                                s2 = null;
                                                            }
                                                            else {
                                                                RESPONSE artistPlylstMainInfoRes$RESPONSE2 = artistPlylstMainInfoRes2.response;
                                                                s2 = artistPlylstMainInfoRes$RESPONSE2 == null ? null : artistPlylstMainInfoRes$RESPONSE2.menuId;
                                                            }
                                                            artistPlaylistDetailFragment0.mMelonTiaraProperty = new s(s, s1, s2, null);
                                                            Context context0 = ArtistPlaylistDetailFragment.this.getContext();
                                                            String s3 = ArtistPlaylistDetailFragment.this.getDetailCacheKey();
                                                            com.iloen.melon.responsecache.a.a(context0, ArtistPlaylistDetailFragment.this.playlistInfoRes, s3);
                                                            this.label = 1;
                                                            if(ArtistPlaylistDetailFragment.this.drawHeaderView(ArtistPlaylistDetailFragment.this.playlistInfoRes, this) == a0) {
                                                                return a0;
                                                            }
                                                            break;
                                                        }
                                                        case 1: {
                                                            d5.n.D(object0);
                                                            break;
                                                        }
                                                        default: {
                                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                        }
                                                    }
                                                    ArtistPlaylistDetailFragment artistPlaylistDetailFragment1 = ArtistPlaylistDetailFragment.this;
                                                    ArtistPlylstMainInfoRes artistPlylstMainInfoRes3 = artistPlaylistDetailFragment1.playlistInfoRes;
                                                    if(artistPlylstMainInfoRes3 == null) {
                                                        s4 = "";
                                                    }
                                                    else {
                                                        RESPONSE artistPlylstMainInfoRes$RESPONSE3 = artistPlylstMainInfoRes3.response;
                                                        if(artistPlylstMainInfoRes$RESPONSE3 == null) {
                                                            s4 = "";
                                                        }
                                                        else {
                                                            s4 = artistPlylstMainInfoRes$RESPONSE3.bbsChannelSeq;
                                                            if(s4 == null) {
                                                                s4 = "";
                                                            }
                                                        }
                                                    }
                                                    artistPlaylistDetailFragment1.setBbsChannelSeq(s4);
                                                    boolean z = ArtistPlaylistDetailFragment.this.prepareFetchComplete(((HttpResponse)this.$playlistSongRes.a));
                                                    H h0 = H.a;
                                                    if(!z) {
                                                        return h0;
                                                    }
                                                    ArtistPlaylistDetailFragment.this.performFetchComplete(this.$type, ((HttpResponse)this.$playlistSongRes.a));
                                                    return h0;
                                                }
                                            };
                                            this.L$0 = null;
                                            this.L$1 = null;
                                            this.L$2 = null;
                                            this.L$3 = null;
                                            this.label = 2;
                                            if(BuildersKt.withContext(i0, artistPlaylistDetailFragment$onFetchStart$1$1$10, this) == a0) {
                                                return a0;
                                            }
                                            goto label_33;
                                        }
                                        break;
                                    }
                                    case 2: {
                                        Job job2 = (Job)this.L$3;
                                        Job job3 = (Job)this.L$2;
                                        kotlin.jvm.internal.H h2 = (kotlin.jvm.internal.H)this.L$1;
                                        d5.n.D(object0);
                                    label_33:
                                        i i1 = Dispatchers.getMain().plus(ArtistPlaylistDetailFragment.this.subExceptionHandler);
                                        com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.onFetchStart.1.1.2 artistPlaylistDetailFragment$onFetchStart$1$1$20 = new n(null) {
                                            int label;

                                            {
                                                ArtistPlaylistDetailFragment.this = artistPlaylistDetailFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.onFetchStart.1.1.2(ArtistPlaylistDetailFragment.this, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.onFetchStart.1.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                if(this.label != 0) {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                                d5.n.D(object0);
                                                String s = ArtistPlaylistDetailFragment.this.getContsId();
                                                CommentLatestList.requestCommentApis$default(ArtistPlaylistDetailFragment.this, ArtistPlaylistDetailFragment.this.getBbsChannelSeq(), s, false, 4, null);
                                                return H.a;
                                            }
                                        };
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.L$4 = null;
                                        this.label = 3;
                                        if(BuildersKt.withContext(i1, artistPlaylistDetailFragment$onFetchStart$1$1$20, this) == a0) {
                                            return a0;
                                        }
                                        break;
                                    }
                                    case 3: {
                                        i i2 = (i)this.L$4;
                                        Job job4 = (Job)this.L$3;
                                        Job job5 = (Job)this.L$2;
                                        kotlin.jvm.internal.H h3 = (kotlin.jvm.internal.H)this.L$1;
                                        d5.n.D(object0);
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                ArtistPlaylistDetailFragment.this.setFetchStart(false);
                                return H.a;
                            }
                        };
                        this.label = 1;
                        return SupervisorKt.supervisorScope(artistPlaylistDetailFragment$onFetchStart$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 2, null);
        return true;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        super.onRestoreInstanceState(bundle0);
        String s = bundle0.getString("argItemId", "");
        q.f(s, "getString(...)");
        this.setPlaylistSeq(s);
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argItemId", this.getPlaylistSeq());
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        Q4.a a0 = this.getHeaderBindingBase();
        q.e(a0, "null cannot be cast to non-null type com.iloen.melon.databinding.PlaylistDetailHeaderBinding");
        this.setPlaylistDetailHeaderBinding(((E2)a0));
        m0 m00 = this.getBinding();
        this.bottomDivider = m00.d;
        m00.d.setVisibility(8);
        I i0 = new I(1);
        i0.c = new g(this, 0);
        TitleBar titleBar0 = this.getTitleBar();
        o o0 = this.getTitlebarDetailCommon();
        o0.g(i0);
        titleBar0.a(o0);
    }

    private static final void onViewCreated$lambda$2(ArtistPlaylistDetailFragment artistPlaylistDetailFragment0, View view0) {
        artistPlaylistDetailFragment0.showContextPopupPlaylistDetail();
        artistPlaylistDetailFragment0.moreClickLog();
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void openProfile() {
        ArrayList arrayList0 = null;
        RESPONSE artistPlylstMainInfoRes$RESPONSE0 = this.playlistInfoRes == null ? null : this.playlistInfoRes.response;
        if(artistPlylstMainInfoRes$RESPONSE0 != null) {
            arrayList0 = artistPlylstMainInfoRes$RESPONSE0.artistList;
        }
        this.showArtistInfoPage(arrayList0);
    }

    private final ArtistPlylstMainInfoRes requestPlaylistInfo(String s) {
        Params artistPlylstMainInfoReq$Params0 = new Params();
        artistPlylstMainInfoReq$Params0.plylstSeq = s;
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        return (ArtistPlylstMainInfoRes)RequestBuilder.newInstance(new ArtistPlylstMainInfoReq(this.getContext(), artistPlylstMainInfoReq$Params0)).tag("ArtistPlaylistDetailFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
    }

    private final ArtistPlylstSongListRes requestSongList(String s) {
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        com.iloen.melon.net.v4x.request.ArtistPlylstSongListReq.Params artistPlylstSongListReq$Params0 = new com.iloen.melon.net.v4x.request.ArtistPlylstSongListReq.Params();
        artistPlylstSongListReq$Params0.startIndex = 1;
        artistPlylstSongListReq$Params0.pageSize = 100;
        artistPlylstSongListReq$Params0.plylstSeq = s;
        return (ArtistPlylstSongListRes)RequestBuilder.newInstance(new ArtistPlylstSongListReq(this.getContext(), u.v(((e0)va.o.a()).j()), artistPlylstSongListReq$Params0)).tag("ArtistPlaylistDetailFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void showContextPopupPlaylistDetail() {
        if(this.isAdded() && this.isPossiblePopupShow()) {
            this.setSelectAllWithToolbar(false);
            ArtistPlylstMainInfoRes artistPlylstMainInfoRes0 = this.playlistInfoRes;
            if(artistPlylstMainInfoRes0 != null) {
                RESPONSE artistPlylstMainInfoRes$RESPONSE0 = artistPlylstMainInfoRes0.response;
                if(artistPlylstMainInfoRes$RESPONSE0 != null) {
                    com.melon.ui.popup.b.o(this.getChildFragmentManager(), new zd.f(artistPlylstMainInfoRes$RESPONSE0), new com.iloen.melon.fragments.detail.f(this, 0), 12);
                }
            }
        }
    }

    private static final H showContextPopupPlaylistDetail$lambda$4$lambda$3(ArtistPlaylistDetailFragment artistPlaylistDetailFragment0, k2 k20) {
        q.g(k20, "moreListPopupOnEvent");
        H h0 = H.a;
        if(k20 instanceof x1) {
            artistPlaylistDetailFragment0.openProfile();
            return h0;
        }
        if(k20 instanceof F1) {
            if(artistPlaylistDetailFragment0.getSongCount() < 1) {
                ToastManager.show(0x7F13036E);  // string:download_available_empty "다운로드 가능한 곡이 없습니다."
                return h0;
            }
            artistPlaylistDetailFragment0.contextMenuCheckSongList(M.g);
            return h0;
        }
        if(k20 instanceof V1) {
            if(artistPlaylistDetailFragment0.getSongCount() < 1) {
                ToastManager.show(0x7F130023);  // string:add_available_empty "담기 가능한 곡이 없습니다."
                return h0;
            }
            artistPlaylistDetailFragment0.contextMenuCheckSongList(M.i);
        }
        return h0;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void updateCommentListView(@NotNull LoadPgnRes loadPgnRes0, @NotNull ListCmtRes listCmtRes0) {
        q.g(loadPgnRes0, "loadPgnRes");
        q.g(listCmtRes0, "listCmtRes");
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment.PlaylistDetailAdapter");
        CmtResViewModel cmtResViewModel0 = this.getCmtResViewModel(loadPgnRes0, listCmtRes0);
        ArrayList arrayList0 = cmtResViewModel0.result.cmtlist;
        q.f(arrayList0, "cmtlist");
        if(!arrayList0.isEmpty()) {
            ((PlaylistDetailAdapter)j00).add(AdapterInViewHolder.Row.create(9, cmtResViewModel0));
            ((PlaylistDetailAdapter)j00).notifyItemChanged(((PlaylistDetailAdapter)j00).getItemCount() - 1);
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateHeaderView() {
        BuildersKt__Builders_commonKt.launch$default(this, SupervisorKt.SupervisorJob$default(null, 1, null), null, new n(null) {
            int label;

            {
                ArtistPlaylistDetailFragment.this = artistPlaylistDetailFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.updateHeaderView.1(ArtistPlaylistDetailFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.updateHeaderView.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        i i0 = Dispatchers.getMain().plus(ArtistPlaylistDetailFragment.this.mainExceptionHandler);
                        com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.updateHeaderView.1.1 artistPlaylistDetailFragment$updateHeaderView$1$10 = new n(null) {
                            int label;

                            {
                                ArtistPlaylistDetailFragment.this = artistPlaylistDetailFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.updateHeaderView.1.1(ArtistPlaylistDetailFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.detail.ArtistPlaylistDetailFragment.updateHeaderView.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        ArtistPlylstMainInfoRes artistPlylstMainInfoRes0 = ArtistPlaylistDetailFragment.this.fetchDetailCacheData();
                                        ArtistPlaylistDetailFragment.this.playlistInfoRes = artistPlylstMainInfoRes0;
                                        this.label = 1;
                                        return ArtistPlaylistDetailFragment.this.drawHeaderView(ArtistPlaylistDetailFragment.this.playlistInfoRes, this) == a0 ? a0 : H.a;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                        return H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        };
                        this.label = 1;
                        return BuildersKt.withContext(i0, artistPlaylistDetailFragment$updateHeaderView$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 2, null);
    }
}

