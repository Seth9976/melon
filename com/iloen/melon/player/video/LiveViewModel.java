package com.iloen.melon.player.video;

import Cb.h;
import Cc.P;
import androidx.lifecycle.K;
import androidx.lifecycle.L;
import androidx.lifecycle.f0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.video.cheer.CheerAnimationCnt;
import com.iloen.melon.player.video.cheer.CheerUnit;
import com.iloen.melon.player.video.cheer.LivePollingManager;
import com.iloen.melon.utils.billing.SingleLiveEvent;
import com.iloen.melon.utils.log.LogU;
import d3.g;
import ie.H;
import ie.r;
import javax.inject.Inject;
import k8.t;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ne.a;
import ob.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001C\b\u0007\u0018\u0000 ^2\u00020\u0001:\u0001^B!\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\r\u0010\u000EJ\r\u0010\u000F\u001A\u00020\f\u00A2\u0006\u0004\b\u000F\u0010\u0010J\r\u0010\u0011\u001A\u00020\f\u00A2\u0006\u0004\b\u0011\u0010\u0010J\u0015\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\n\u00A2\u0006\u0004\b\u0013\u0010\u000EJ\r\u0010\u0014\u001A\u00020\f\u00A2\u0006\u0004\b\u0014\u0010\u0010J\u0015\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\n\u00A2\u0006\u0004\b\u0016\u0010\u000ER\u001D\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\n0\u00178\u0006\u00A2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u001BR\u001D\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\n0\u00178\u0006\u00A2\u0006\f\n\u0004\b\u001C\u0010\u0019\u001A\u0004\b\u001D\u0010\u001BR\u001D\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\n0\u00178\u0006\u00A2\u0006\f\n\u0004\b\u001E\u0010\u0019\u001A\u0004\b\u001F\u0010\u001BR\"\u0010\'\u001A\u00020 8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001A\u00020 8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b(\u0010\"\u001A\u0004\b)\u0010$\"\u0004\b*\u0010&R\u001D\u00102\u001A\b\u0012\u0004\u0012\u00020-0,8\u0006\u00A2\u0006\f\n\u0004\b.\u0010/\u001A\u0004\b0\u00101R\u0017\u00108\u001A\u0002038\u0006\u00A2\u0006\f\n\u0004\b4\u00105\u001A\u0004\b6\u00107R\u001D\u0010;\u001A\b\u0012\u0004\u0012\u00020\n0\u00178\u0006\u00A2\u0006\f\n\u0004\b9\u0010\u0019\u001A\u0004\b:\u0010\u001BR\u001D\u0010?\u001A\b\u0012\u0004\u0012\u00020<0\u00178\u0006\u00A2\u0006\f\n\u0004\b=\u0010\u0019\u001A\u0004\b>\u0010\u001BR\u001D\u0010B\u001A\b\u0012\u0004\u0012\u00020<0,8\u0006\u00A2\u0006\f\n\u0004\b@\u0010/\u001A\u0004\bA\u00101R\u001D\u0010F\u001A\b\u0012\u0004\u0012\u00020C0\u00178\u0006\u00A2\u0006\f\n\u0004\bD\u0010\u0019\u001A\u0004\bE\u0010\u001BR\u001D\u0010I\u001A\b\u0012\u0004\u0012\u00020\n0,8\u0006\u00A2\u0006\f\n\u0004\bG\u0010/\u001A\u0004\bH\u00101R\u001D\u0010L\u001A\b\u0012\u0004\u0012\u00020\n0\u00178\u0006\u00A2\u0006\f\n\u0004\bJ\u0010\u0019\u001A\u0004\bK\u0010\u001BR\u001D\u0010O\u001A\b\u0012\u0004\u0012\u00020\n0\u00178\u0006\u00A2\u0006\f\n\u0004\bM\u0010\u0019\u001A\u0004\bN\u0010\u001BR\u001D\u0010R\u001A\b\u0012\u0004\u0012\u00020 0\u00178\u0006\u00A2\u0006\f\n\u0004\bP\u0010\u0019\u001A\u0004\bQ\u0010\u001BR$\u0010Y\u001A\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bS\u0010T\u001A\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001D\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\n0\u00178\u0006\u00A2\u0006\f\n\u0004\bZ\u0010\u0019\u001A\u0004\b\u0015\u0010\u001BR\u001D\u0010]\u001A\b\u0012\u0004\u0012\u00020\n0\u00178\u0006\u00A2\u0006\f\n\u0004\b[\u0010\u0019\u001A\u0004\b\\\u0010\u001B\u00A8\u0006_"}, d2 = {"Lcom/iloen/melon/player/video/LiveViewModel;", "Lcom/iloen/melon/player/video/VideoViewModel;", "Lcom/iloen/melon/player/video/VideoPipPvLogManager;", "videoPipPvLogManager", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "<init>", "(Lcom/iloen/melon/player/video/VideoPipPvLogManager;Lkc/s2;Lob/z;)V", "", "hasLiveChat", "Lie/H;", "updateHasLiveChat", "(Z)V", "openAndShowFullChat", "()V", "closeFullChat", "isShow", "updateIsShowingSongListBottomSheet", "clickCheerBtn", "isMultiWindow", "updateMultiWindow", "Lkotlinx/coroutines/flow/StateFlow;", "g0", "Lkotlinx/coroutines/flow/StateFlow;", "isFullChatCreate", "()Lkotlinx/coroutines/flow/StateFlow;", "i0", "isFullChatEnable", "j0", "isFullChatShow", "", "k0", "I", "getLiveBottomSheetMaxHeightForSeparated", "()I", "setLiveBottomSheetMaxHeightForSeparated", "(I)V", "liveBottomSheetMaxHeightForSeparated", "l0", "getLiveBottomSheetMaxWidthForSeparated", "setLiveBottomSheetMaxWidthForSeparated", "liveBottomSheetMaxWidthForSeparated", "Landroidx/lifecycle/K;", "Lcom/iloen/melon/net/v6x/response/LiveDetailRes;", "n0", "Landroidx/lifecycle/K;", "getLiveRes", "()Landroidx/lifecycle/K;", "liveRes", "Lcom/iloen/melon/player/video/LivePreviewSubscribeManager;", "o0", "Lcom/iloen/melon/player/video/LivePreviewSubscribeManager;", "getLivePreviewSubscribeManager", "()Lcom/iloen/melon/player/video/LivePreviewSubscribeManager;", "livePreviewSubscribeManager", "p0", "getSongListVisibilityOutSideController", "songListVisibilityOutSideController", "", "r0", "getViewCnt", "viewCnt", "u0", "getLikeCnt", "likeCnt", "Lcom/iloen/melon/player/video/cheer/CheerAnimationCnt;", "w0", "getCntAnimation", "cntAnimation", "y0", "getHeartAnimationEvent", "heartAnimationEvent", "A0", "getPollingAble", "pollingAble", "B0", "getFullScreenCheerIconVisibility", "fullScreenCheerIconVisibility", "C0", "getChatCheerIconVisibility", "chatCheerIconVisibility", "D0", "Lcom/iloen/melon/player/video/cheer/CheerAnimationCnt;", "getIgnoreCheerUnit", "()Lcom/iloen/melon/player/video/cheer/CheerAnimationCnt;", "setIgnoreCheerUnit", "(Lcom/iloen/melon/player/video/cheer/CheerAnimationCnt;)V", "ignoreCheerUnit", "G0", "H0", "getVisibilityRotateGuideView", "visibilityRotateGuideView", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LiveViewModel extends VideoViewModel {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/video/LiveViewModel$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    public final MutableStateFlow A0;
    public final StateFlow B0;
    public final StateFlow C0;
    @NotNull
    public static final Companion Companion;
    public CheerAnimationCnt D0;
    public final r E0;
    public final MutableStateFlow F0;
    public final MutableStateFlow G0;
    public final StateFlow H0;
    public final MutableStateFlow e0;
    public final MutableStateFlow f0;
    public final StateFlow g0;
    public final MutableStateFlow h0;
    public final MutableStateFlow i0;
    public final StateFlow j0;
    public int k0;
    public int l0;
    public final L m0;
    public final L n0;
    public final LivePreviewSubscribeManager o0;
    public final StateFlow p0;
    public final MutableStateFlow q0;
    public final MutableStateFlow r0;
    public long s0;
    public final L t0;
    public final L u0;
    public final MutableStateFlow v0;
    public final MutableStateFlow w0;
    public final SingleLiveEvent x0;
    public final SingleLiveEvent y0;
    public final MutableStateFlow z0;

    static {
        LiveViewModel.Companion = new Companion(null);
        LiveViewModel.$stable = 8;
    }

    @Inject
    public LiveViewModel(@NotNull VideoPipPvLogManager videoPipPvLogManager0, @NotNull s2 s20, @NotNull z z0) {
        q.g(videoPipPvLogManager0, "videoPipPvLogManager");
        q.g(s20, "playlistManager");
        q.g(z0, "playerUseCase");
        super(videoPipPvLogManager0, s20, z0);
        new LogU("LiveViewModel");
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.e0 = mutableStateFlow0;
        MutableStateFlow mutableStateFlow1 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.f0 = mutableStateFlow1;
        StateFlow stateFlow0 = h.d(this.getVideoStatus(), this.getOneDepthContentType(), mutableStateFlow0, f0.h(this), new P(18));
        this.g0 = stateFlow0;
        MutableStateFlow mutableStateFlow2 = StateFlowKt.MutableStateFlow(Boolean.TRUE);
        this.h0 = mutableStateFlow2;
        this.i0 = mutableStateFlow2;
        StateFlow stateFlow1 = h.e(stateFlow0, mutableStateFlow2, this.getControllerAllVisible(), mutableStateFlow1, this.isPip(), f0.h(this), new b(0));
        this.j0 = stateFlow1;
        L l0 = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.m0 = l0;
        this.n0 = l0;
        this.o0 = new LivePreviewSubscribeManager(f0.h(this), null, 2, null);
        this.p0 = h.e(this.getVideoStatus(), this.getControllerAllVisible(), this.isPip(), mutableStateFlow1, stateFlow1, f0.h(this), new b(1));
        MutableStateFlow mutableStateFlow3 = StateFlowKt.MutableStateFlow("");
        this.q0 = mutableStateFlow3;
        this.r0 = mutableStateFlow3;
        L l1 = new L("");  // 初始化器: Landroidx/lifecycle/K;-><init>(Ljava/lang/Object;)V
        this.t0 = l1;
        this.u0 = l1;
        MutableStateFlow mutableStateFlow4 = StateFlowKt.MutableStateFlow(new CheerAnimationCnt("", CheerUnit.K_1));
        this.v0 = mutableStateFlow4;
        this.w0 = mutableStateFlow4;
        SingleLiveEvent singleLiveEvent0 = new SingleLiveEvent();
        this.x0 = singleLiveEvent0;
        this.y0 = singleLiveEvent0;
        MutableStateFlow mutableStateFlow5 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.z0 = mutableStateFlow5;
        this.A0 = mutableStateFlow5;
        StateFlow stateFlow2 = h.e(mutableStateFlow5, this.getVideoStatus(), this.getControllerAllVisible(), this.isPip(), mutableStateFlow1, f0.h(this), new b(2));
        this.B0 = stateFlow2;
        this.C0 = h.d(stateFlow2, mutableStateFlow5, this.isOrientationPortrait(), f0.h(this), new P(19));
        this.E0 = g.Q(new c(this, 0));
        MutableStateFlow mutableStateFlow6 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.F0 = mutableStateFlow6;
        this.G0 = mutableStateFlow6;
        this.H0 = h.a(h.d(this.isOrientationPortrait(), this.isVideoPortraitRatio(), this.getVideoStatus(), f0.h(this), new P(20)), mutableStateFlow6, this.getOneDepthContentType(), f0.h(this), kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, null), new P(21));
        this.updateControllerAllVisible(Boolean.TRUE);
        MelonAppBase.Companion.getClass();
        this.updatePipState(t.a().isAppPip());
        this.updateCurrentVideoStatus(VideoStatus.Expand, "LiveViewModel - init");
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public int r;
            public final LiveViewModel w;

            {
                this.w = liveViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.LiveViewModel.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.LiveViewModel.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.player.video.LiveViewModel.1.1 liveViewModel$1$10 = new n(null) {
                            public final LiveViewModel B;
                            public int r;
                            public Object w;

                            {
                                this.B = liveViewModel0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.LiveViewModel.1.1(this.B, continuation0);
                                continuation1.w = object0;
                                return continuation1;
                            }

                            public final Object invoke(Playable playable0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.LiveViewModel.1.1)this.create(playable0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Playable)object0), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                Playable playable0 = (Playable)this.w;
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        LiveViewModel liveViewModel0 = this.B;
                                        if(playable0 != null && playable0.isLiveContent()) {
                                            q.f("", "getLiveSeq(...)");
                                            LiveViewModel.access$updateLiveRes(liveViewModel0, "");
                                        }
                                        if(playable0 != null && playable0.isLivePreView()) {
                                            this.w = null;
                                            this.r = 1;
                                            if(liveViewModel0.getLivePreviewSubscribeManager().changeLiveSeqAndFetchSubscribe("", this) == a0) {
                                                return a0;
                                            }
                                        }
                                        return H.a;
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
                        this.r = 1;
                        return FlowKt.collectLatest(this.w.getCurrentVideoPlayable(), liveViewModel$1$10, this) == a0 ? a0 : H.a;
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
        }, 3, null);
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public int r;
            public final LiveViewModel w;

            {
                this.w = liveViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.LiveViewModel.2(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.LiveViewModel.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.player.video.LiveViewModel.2.1 liveViewModel$2$10 = new n(null) {
                            public final LiveViewModel r;

                            {
                                this.r = liveViewModel0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.LiveViewModel.2.1(this.r, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                            }

                            public final Object invoke(boolean z, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.LiveViewModel.2.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                d5.n.D(object0);
                                LiveViewModel.access$get_isFullChatEnable$p(this.r).setValue(Boolean.TRUE);
                                return H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(this.w.isFullChatCreate(), liveViewModel$2$10, this) == a0 ? a0 : H.a;
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
        }, 3, null);
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public int r;
            public final LiveViewModel w;

            {
                this.w = liveViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.LiveViewModel.3(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.LiveViewModel.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.player.video.LiveViewModel.3.1 liveViewModel$3$10 = new n(null) {
                            public Object r;
                            public final LiveViewModel w;

                            {
                                this.w = liveViewModel0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.LiveViewModel.3.1(this.w, continuation0);
                                continuation1.r = object0;
                                return continuation1;
                            }

                            public final Object invoke(VideoOneDepthContentType videoOneDepthContentType0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.LiveViewModel.3.1)this.create(videoOneDepthContentType0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((VideoOneDepthContentType)object0), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                VideoOneDepthContentType videoOneDepthContentType0 = (VideoOneDepthContentType)this.r;
                                d5.n.D(object0);
                                if(videoOneDepthContentType0 != VideoOneDepthContentType.CHAT) {
                                    LiveViewModel.access$getPollingManager(this.w).stopPolling("content change");
                                }
                                return H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(this.w.getOneDepthContentType(), liveViewModel$3$10, this) == a0 ? a0 : H.a;
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
        }, 3, null);
    }

    public static final long access$getLikeCntNum$p(LiveViewModel liveViewModel0) {
        return liveViewModel0.s0;
    }

    public static final LivePollingManager access$getPollingManager(LiveViewModel liveViewModel0) {
        return (LivePollingManager)liveViewModel0.E0.getValue();
    }

    public static final MutableStateFlow access$get_isFullChatEnable$p(LiveViewModel liveViewModel0) {
        return liveViewModel0.h0;
    }

    public static final L access$get_liveRes$p(LiveViewModel liveViewModel0) {
        return liveViewModel0.m0;
    }

    public static final MutableStateFlow access$get_pollingAble$p(LiveViewModel liveViewModel0) {
        return liveViewModel0.z0;
    }

    public static final MutableStateFlow access$get_viewCnt$p(LiveViewModel liveViewModel0) {
        return liveViewModel0.q0;
    }

    public static final void access$setLikeCntNum(LiveViewModel liveViewModel0, long v) {
        liveViewModel0.d(v);
    }

    public static final void access$updateLiveRes(LiveViewModel liveViewModel0, String s) {
        liveViewModel0.getClass();
        BuildersKt__Builders_commonKt.launch$default(f0.h(liveViewModel0), null, null, new LiveViewModel.updateLiveRes.1(liveViewModel0, s, null), 3, null);
    }

    public final void clickCheerBtn() {
        this.x0.setValue(Boolean.TRUE);
        ((LivePollingManager)this.E0.getValue()).clickCheerBtn();
        this.d(this.s0 + 1L);
    }

    public final void closeFullChat() {
        this.h0.setValue(Boolean.FALSE);
    }

    public final void d(long v) {
        this.t0.setValue(String.valueOf(v));
        CheerAnimationCnt cheerAnimationCnt0 = CheerAnimationCnt.Companion.convertCheerAnimationCnt(v);
        this.v0.setValue(cheerAnimationCnt0);
        Object object0 = this.v0.getValue();
        LogU.Companion.d("LiveViewModel", "likeCntNum setter(), _cntAnimation = " + object0);
        this.s0 = v;
    }

    @NotNull
    public final StateFlow getChatCheerIconVisibility() {
        return this.C0;
    }

    @NotNull
    public final StateFlow getCntAnimation() {
        return this.w0;
    }

    @NotNull
    public final StateFlow getFullScreenCheerIconVisibility() {
        return this.B0;
    }

    @NotNull
    public final K getHeartAnimationEvent() {
        return this.y0;
    }

    @Nullable
    public final CheerAnimationCnt getIgnoreCheerUnit() {
        return this.D0;
    }

    @NotNull
    public final K getLikeCnt() {
        return this.u0;
    }

    public final int getLiveBottomSheetMaxHeightForSeparated() {
        return this.k0;
    }

    public final int getLiveBottomSheetMaxWidthForSeparated() {
        return this.l0;
    }

    @NotNull
    public final LivePreviewSubscribeManager getLivePreviewSubscribeManager() {
        return this.o0;
    }

    @NotNull
    public final K getLiveRes() {
        return this.n0;
    }

    @NotNull
    public final StateFlow getPollingAble() {
        return this.A0;
    }

    @NotNull
    public final StateFlow getSongListVisibilityOutSideController() {
        return this.p0;
    }

    @NotNull
    public final StateFlow getViewCnt() {
        return this.r0;
    }

    @NotNull
    public final StateFlow getVisibilityRotateGuideView() {
        return this.H0;
    }

    @NotNull
    public final StateFlow isFullChatCreate() {
        return this.g0;
    }

    @NotNull
    public final StateFlow isFullChatEnable() {
        return this.i0;
    }

    @NotNull
    public final StateFlow isFullChatShow() {
        return this.j0;
    }

    @NotNull
    public final StateFlow isMultiWindow() {
        return this.G0;
    }

    public final void openAndShowFullChat() {
        this.h0.setValue(Boolean.TRUE);
        this.updateControllerAllVisible(Boolean.FALSE);
    }

    public final void setIgnoreCheerUnit(@Nullable CheerAnimationCnt cheerAnimationCnt0) {
        this.D0 = cheerAnimationCnt0;
    }

    public final void setLiveBottomSheetMaxHeightForSeparated(int v) {
        this.k0 = v;
    }

    public final void setLiveBottomSheetMaxWidthForSeparated(int v) {
        this.l0 = v;
    }

    public final void updateHasLiveChat(boolean z) {
        this.e0.setValue(Boolean.valueOf(z));
    }

    public final void updateIsShowingSongListBottomSheet(boolean z) {
        this.f0.setValue(Boolean.valueOf(z));
    }

    public final void updateMultiWindow(boolean z) {
        this.F0.setValue(Boolean.valueOf(z));
    }
}

