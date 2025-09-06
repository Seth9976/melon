package com.iloen.melon.custom;

import Ma.m;
import U4.F;
import Ub.q;
import Ub.s;
import Ub.t;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.n;
import b9.a;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPlayback.SeekComplete;
import com.iloen.melon.eventbus.EventPlayback;
import com.iloen.melon.player.video.VideoViewModel;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import d3.g;
import k8.Y;
import k8.o;
import kotlin.Metadata;
import ob.z;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressLint({"ClickableViewAccessibility"})
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002!5B\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0015\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001A\u00020\u00168\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\"\u0010 \u001A\u00020\u00168\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001D\u0010\u0018\u001A\u0004\b\u001E\u0010\u001A\"\u0004\b\u001F\u0010\u001CR$\u0010(\u001A\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\"\u0010#\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R$\u00100\u001A\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b*\u0010+\u001A\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0014\u00104\u001A\u0002018BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/iloen/melon/custom/VideoOverlayView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "Lcom/iloen/melon/eventbus/EventPlayback;", "event", "Lie/H;", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventPlayback;)V", "Lcom/iloen/melon/custom/SeekBarForNewVideoPlayer;", "M", "Lcom/iloen/melon/custom/SeekBarForNewVideoPlayer;", "getSeekBarForVideoPlayer", "()Lcom/iloen/melon/custom/SeekBarForNewVideoPlayer;", "setSeekBarForVideoPlayer", "(Lcom/iloen/melon/custom/SeekBarForNewVideoPlayer;)V", "seekBarForVideoPlayer", "", "V", "Z", "isAnimating", "()Z", "setAnimating", "(Z)V", "W", "getCanSeeking", "setCanSeeking", "canSeeking", "Lcom/iloen/melon/custom/H1;", "b0", "Lcom/iloen/melon/custom/H1;", "getPerformListener", "()Lcom/iloen/melon/custom/H1;", "setPerformListener", "(Lcom/iloen/melon/custom/H1;)V", "performListener", "Lcom/iloen/melon/player/video/VideoViewModel;", "c0", "Lcom/iloen/melon/player/video/VideoViewModel;", "getViewModel", "()Lcom/iloen/melon/player/video/VideoViewModel;", "setViewModel", "(Lcom/iloen/melon/player/video/VideoViewModel;)V", "viewModel", "", "getHorizontalMiddle", "()I", "horizontalMiddle", "com/iloen/melon/custom/G1", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoOverlayView extends ConstraintLayout {
    public final ConstraintLayout B;
    public final VideoOverlaySecondsView D;
    public final VideoOverlayDoubleTapView E;
    public final GestureDetector G;
    public final G1 I;
    public SeekBarForNewVideoPlayer M;
    public long N;
    public long S;
    public boolean T;
    public boolean V;
    public boolean W;
    public H1 b0;
    public VideoViewModel c0;
    public final ObjectAnimator d0;
    public final ObjectAnimator e0;
    public final z o;
    public final q r;
    public final s w;

    public VideoOverlayView(@NotNull Context context0) {
        kotlin.jvm.internal.q.g(context0, "context");
        this(context0, null);
    }

    public VideoOverlayView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        kotlin.jvm.internal.q.g(context0, "context");
        super(context0, attributeSet0);
        this.o = ((o)(((Ma.o)Y.e(context0, Ma.o.class)))).k();
        this.r = F.x(context0);
        this.w = (s)((o)(((m)Y.e(context0, m.class)))).z.get();
        this.N = -1L;
        this.S = -2L;
        LayoutInflater.from(context0).inflate(0x7F0D08ED, this, true);  // layout:video_overlay_layout
        View view0 = this.findViewById(0x7F0A0A0A);  // id:root_constraint_layout
        kotlin.jvm.internal.q.f(view0, "findViewById(...)");
        this.B = (ConstraintLayout)view0;
        ((ConstraintLayout)view0).setVisibility(4);
        View view1 = this.findViewById(0x7F0A0A4D);  // id:seconds_view
        kotlin.jvm.internal.q.f(view1, "findViewById(...)");
        this.D = (VideoOverlaySecondsView)view1;
        ((VideoOverlaySecondsView)view1).setForward(true);
        View view2 = this.findViewById(0x7F0A02BC);  // id:circle_clip_tap_view
        kotlin.jvm.internal.q.f(view2, "findViewById(...)");
        this.E = (VideoOverlayDoubleTapView)view2;
        Property property0 = ViewGroup.ALPHA;
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(((ConstraintLayout)view0), property0, new float[]{1.0f, 0.0f});
        objectAnimator0.setDuration(300L);
        objectAnimator0.addListener(new F1(this, 0));
        this.e0 = objectAnimator0;
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(((ConstraintLayout)view0), property0, new float[]{0.0f, 1.0f});
        objectAnimator1.setDuration(800L);
        objectAnimator1.addListener(new F1(this, 1));
        this.d0 = objectAnimator1;
        this.c(true);
        ((VideoOverlayDoubleTapView)view2).setPerformAtEnd(new a(this, 17));
        this.I = new G1(this);
        this.G = new GestureDetector(context0, new G1(this));
        EventBusHelper.register(this);
        ((ConstraintLayout)view0).setVisibility(4);
    }

    public final void c(boolean z) {
        n n0 = new n();
        ConstraintLayout constraintLayout0 = this.B;
        n0.f(constraintLayout0);
        VideoOverlaySecondsView videoOverlaySecondsView0 = this.D;
        if(z) {
            n0.e(videoOverlaySecondsView0.getId(), 6);
            n0.h(videoOverlaySecondsView0.getId(), 7, 0, 7);
        }
        else {
            n0.e(videoOverlaySecondsView0.getId(), 7);
            n0.h(videoOverlaySecondsView0.getId(), 6, 0, 6);
        }
        n0.b(constraintLayout0);
    }

    public final void d() {
        this.I.c = false;
        this.I.a.removeCallbacks(this.I.b);
        this.T = false;
        this.N = -1L;
        this.S = -2L;
    }

    public final void e(float f, float f1) {
        ie.m m0;
        Boolean boolean0 = null;
        if(((t)this.w).f()) {
            ToastManager.showShort("기기 연결 중에는\n더블탭 구간 이동이 불가합니다.");
        }
        else {
            if((this.c0 == null ? false : this.c0.isMiniPlayerMode()) || !this.W) {
                m0 = new ie.m(Boolean.TRUE, "isGestureMode is false");
            }
            else {
                m0 = g.N(this.r.a()) ? new ie.m(Boolean.TRUE, "isPlaybackCompleted is true") : new ie.m(Boolean.FALSE, "");
            }
            String s = (String)m0.b;
            if(((Boolean)m0.a).booleanValue()) {
                Y.w("shouldForward() invalidState:", s, LogU.Companion, "VideoOverlayView");
            }
            else {
                SeekBarForNewVideoPlayer seekBarForNewVideoPlayer0 = this.M;
                if(seekBarForNewVideoPlayer0 != null) {
                    if(seekBarForNewVideoPlayer0.getProgress() - 500 > 0 && f < ((float)this.getHorizontalMiddle())) {
                        boolean0 = Boolean.FALSE;
                    }
                    else if(seekBarForNewVideoPlayer0.getProgress() + 500 <= seekBarForNewVideoPlayer0.getMax() && f > ((float)this.getHorizontalMiddle())) {
                        boolean0 = Boolean.TRUE;
                    }
                }
            }
        }
        int v = this.B.getVisibility();
        VideoOverlaySecondsView videoOverlaySecondsView0 = this.D;
        if(v != 4) {
        label_29:
            if(!this.e0.isRunning()) {
                boolean z = kotlin.jvm.internal.q.b(boolean0, Boolean.FALSE);
                VideoOverlayDoubleTapView videoOverlayDoubleTapView0 = this.E;
                if(z) {
                    if(videoOverlaySecondsView0.I) {
                        this.c(false);
                        videoOverlaySecondsView0.setForward(false);
                        videoOverlaySecondsView0.setSeconds(0);
                    }
                    videoOverlayDoubleTapView0.a(new E1(this, f, f1, 0));
                    SeekBarForNewVideoPlayer seekBarForNewVideoPlayer1 = this.M;
                    if(seekBarForNewVideoPlayer1 != null) {
                        int v1 = seekBarForNewVideoPlayer1.getProgress();
                        videoOverlaySecondsView0.setSeconds(videoOverlaySecondsView0.getSeconds() + 10);
                        this.f(((long)Math.max(0, v1 - 10000)));
                    }
                }
                else if(kotlin.jvm.internal.q.b(boolean0, Boolean.TRUE)) {
                    if(!videoOverlaySecondsView0.I) {
                        this.c(true);
                        videoOverlaySecondsView0.setForward(true);
                        videoOverlaySecondsView0.setSeconds(0);
                    }
                    videoOverlayDoubleTapView0.a(new E1(this, f, f1, 1));
                    SeekBarForNewVideoPlayer seekBarForNewVideoPlayer2 = this.M;
                    if(seekBarForNewVideoPlayer2 != null) {
                        int v2 = seekBarForNewVideoPlayer2.getMax();
                        int v3 = seekBarForNewVideoPlayer2.getProgress();
                        videoOverlaySecondsView0.setSeconds(videoOverlaySecondsView0.getSeconds() + 10);
                        this.f(((long)Math.min(v2, v3 + 10000)));
                    }
                }
            }
        }
        else if(boolean0 != null) {
            this.d0.start();
            videoOverlaySecondsView0.c();
            videoOverlaySecondsView0.o = true;
            videoOverlaySecondsView0.M.start();
            videoOverlaySecondsView0.S.start();
            videoOverlaySecondsView0.V.start();
            goto label_29;
        }
    }

    public final void f(Long long0) {
        long v = this.N;
        long v1 = this.S;
        boolean z = this.T;
        StringBuilder stringBuilder0 = new StringBuilder("seekToPosition() newPosition:");
        stringBuilder0.append(long0);
        stringBuilder0.append(", lastSeekRequestPosition:");
        stringBuilder0.append(v);
        com.iloen.melon.utils.a.s(v1, ", prevSeekRequestPosition:", ", isSeeking:", stringBuilder0);
        stringBuilder0.append(z);
        LogU.Companion.d("VideoOverlayView", stringBuilder0.toString());
        SeekBarForNewVideoPlayer seekBarForNewVideoPlayer0 = this.M;
        if(seekBarForNewVideoPlayer0 != null) {
            seekBarForNewVideoPlayer0.setProgress(((int)(((long)long0))));
        }
        this.I.c = true;
        this.I.a.removeCallbacks(this.I.b);
        this.I.a.postDelayed(this.I.b, this.I.d);
        if(!this.T) {
            this.N = -1L;
            if(this.S == ((long)long0) && ((long)long0) != 0L) {
                return;
            }
            this.T = true;
            this.S = (long)long0;
            this.o.z(((long)long0));
            return;
        }
        this.N = (long)long0;
    }

    public final boolean getCanSeeking() {
        return this.W;
    }

    private final int getHorizontalMiddle() {
        return this.getWidth() / 2;
    }

    @Nullable
    public final H1 getPerformListener() {
        return this.b0;
    }

    @Nullable
    public final SeekBarForNewVideoPlayer getSeekBarForVideoPlayer() {
        return this.M;
    }

    @Nullable
    public final VideoViewModel getViewModel() {
        return this.c0;
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        EventBusHelper.unregister(this);
        super.onDetachedFromWindow();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventPlayback eventPlayback0) {
        kotlin.jvm.internal.q.g(eventPlayback0, "event");
        if(eventPlayback0 instanceof SeekComplete) {
            LogU.Companion.d("VideoOverlayView", "onEventMainThread() lastSeekRequestPosition:" + this.N);
            this.T = false;
            if(this.V || this.N != -1L) {
                long v = this.N;
                if(v != -1L) {
                    this.f(v);
                }
            }
            else {
                this.d();
                H1 h10 = this.b0;
                if(h10 != null) {
                    h10.onLastSeekComplete();
                }
            }
        }
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        kotlin.jvm.internal.q.g(motionEvent0, "event");
        return this.G.onTouchEvent(motionEvent0);
    }

    public final void setAnimating(boolean z) {
        this.V = z;
    }

    public final void setCanSeeking(boolean z) {
        this.W = z;
    }

    public final void setPerformListener(@Nullable H1 h10) {
        this.b0 = h10;
    }

    public final void setSeekBarForVideoPlayer(@Nullable SeekBarForNewVideoPlayer seekBarForNewVideoPlayer0) {
        this.M = seekBarForNewVideoPlayer0;
    }

    public final void setViewModel(@Nullable VideoViewModel videoViewModel0) {
        this.c0 = videoViewModel0;
    }
}

