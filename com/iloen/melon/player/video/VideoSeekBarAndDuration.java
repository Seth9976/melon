package com.iloen.melon.player.video;

import De.I;
import J8.L3;
import P1.c;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.SeekBarForNewVideoPlayer;
import com.iloen.melon.custom.X0;
import com.iloen.melon.playback.StateView;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.melon.ui.playback.VideoControllerHelper;
import i.n.i.b.a.s.e.M3;
import k8.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pd.v;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 52\u00020\u0001:\u000256B\u001D\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000F¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\fH\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001A\u001A\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001A\u00020\u001B8\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001FR\u0017\u0010&\u001A\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001A\u0004\b$\u0010%R\u0017\u0010,\u001A\u00020\'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+R$\u00104\u001A\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b.\u0010/\u001A\u0004\b0\u00101\"\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/iloen/melon/player/video/VideoSeekBarAndDuration;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroidx/lifecycle/D;", "viewLifecycleOwner", "Lcom/iloen/melon/player/video/VideoViewModel;", "videoViewModel", "Lie/H;", "initSeekbar", "(Landroidx/lifecycle/D;Lcom/iloen/melon/player/video/VideoViewModel;)V", "Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$SeekBarType;", "newType", "setType", "(Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$SeekBarType;)V", "onDetachedFromWindow", "()V", "LJ8/L3;", "c", "LJ8/L3;", "getBinding", "()LJ8/L3;", "binding", "Lcom/iloen/melon/custom/SeekBarForNewVideoPlayer;", "d", "Lcom/iloen/melon/custom/SeekBarForNewVideoPlayer;", "getVideoSeekBar", "()Lcom/iloen/melon/custom/SeekBarForNewVideoPlayer;", "videoSeekBar", "Lcom/iloen/melon/custom/MelonTextView;", "e", "Lcom/iloen/melon/custom/MelonTextView;", "getTvSeekThumbDuration", "()Lcom/iloen/melon/custom/MelonTextView;", "tvSeekThumbDuration", "Landroid/widget/ProgressBar;", "f", "Landroid/widget/ProgressBar;", "getDraggingProgress", "()Landroid/widget/ProgressBar;", "draggingProgress", "Lkotlinx/coroutines/Job;", "g", "Lkotlinx/coroutines/Job;", "getBorderSeekBarDelayShowingJob", "()Lkotlinx/coroutines/Job;", "setBorderSeekBarDelayShowingJob", "(Lkotlinx/coroutines/Job;)V", "borderSeekBarDelayShowingJob", "Companion", "SeekBarType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoSeekBarAndDuration extends RelativeLayout {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$SeekBarType;", "", "Live", "Preview", "Vod", "Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$SeekBarType$Live;", "Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$SeekBarType$Preview;", "Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$SeekBarType$Vod;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static abstract class SeekBarType {
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0012\u001A\u00020\u00022\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$SeekBarType$Live;", "Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$SeekBarType;", "", "useTimeMachine", "<init>", "(Z)V", "component1", "()Z", "copy", "(Z)Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$SeekBarType$Live;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "getUseTimeMachine", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Live extends SeekBarType {
            public static final int $stable;
            public final boolean a;

            public Live(boolean z) {
                super(null);
                this.a = z;
            }

            public final boolean component1() {
                return this.a;
            }

            @NotNull
            public final Live copy(boolean z) {
                return new Live(z);
            }

            public static Live copy$default(Live videoSeekBarAndDuration$SeekBarType$Live0, boolean z, int v, Object object0) {
                if((v & 1) != 0) {
                    z = videoSeekBarAndDuration$SeekBarType$Live0.a;
                }
                return videoSeekBarAndDuration$SeekBarType$Live0.copy(z);
            }

            @Override
            public boolean equals(@Nullable Object object0) {
                if(this == object0) {
                    return true;
                }
                return object0 instanceof Live ? this.a == ((Live)object0).a : false;
            }

            public final boolean getUseTimeMachine() {
                return this.a;
            }

            @Override
            public int hashCode() {
                return Boolean.hashCode(this.a);
            }

            @Override
            @NotNull
            public String toString() {
                return "Live(useTimeMachine=" + this.a + ")";
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$SeekBarType$Preview;", "Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$SeekBarType;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Preview extends SeekBarType {
            public static final int $stable;
            @NotNull
            public static final Preview INSTANCE;

            static {
                Preview.INSTANCE = new Preview(null);  // 初始化器: Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$SeekBarType;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$SeekBarType$Vod;", "Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$SeekBarType;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Vod extends SeekBarType {
            public static final int $stable;
            @NotNull
            public static final Vod INSTANCE;

            static {
                Vod.INSTANCE = new Vod(null);  // 初始化器: Lcom/iloen/melon/player/video/VideoSeekBarAndDuration$SeekBarType;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
            }
        }

        public static final int $stable;

        public SeekBarType(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public SeekBarType a;
    public final boolean b;
    public final L3 c;
    public final SeekBarForNewVideoPlayer d;
    public final MelonTextView e;
    public final ProgressBar f;
    public Job g;
    public final com.iloen.melon.player.video.VideoSeekBarAndDuration.trackingListener.1 h;

    static {
        VideoSeekBarAndDuration.Companion = new Companion(null);
        VideoSeekBarAndDuration.$stable = 8;
    }

    public VideoSeekBarAndDuration(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 2, null);
    }

    public VideoSeekBarAndDuration(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        super(context0, attributeSet0);
        View view0 = LayoutInflater.from(context0).inflate(0x7F0D08EC, this, false);  // layout:video_new_seekbar
        this.addView(view0);
        int v = 0x7F0A03F8;  // id:dragging_progress
        View view1 = I.C(view0, 0x7F0A03F8);  // id:dragging_progress
        if(((ProgressBar)view1) != null) {
            v = 0x7F0A03F9;  // id:dragging_progress_background
            View view2 = I.C(view0, 0x7F0A03F9);  // id:dragging_progress_background
            if(view2 != null && ((RelativeLayout)I.C(view0, 0x7F0A0984)) != null) {  // id:progress_container
                v = 0x7F0A0A54;  // id:seekbar_progress
                View view3 = I.C(view0, 0x7F0A0A54);  // id:seekbar_progress
                if(((SeekBarForNewVideoPlayer)view3) != null) {
                    v = 0x7F0A0D08;  // id:tv_seek_thumb_duration
                    View view4 = I.C(view0, 0x7F0A0D08);  // id:tv_seek_thumb_duration
                    if(((MelonTextView)view4) != null) {
                        this.c = new L3(((RelativeLayout)view0), ((ProgressBar)view1), view2, ((SeekBarForNewVideoPlayer)view3), ((MelonTextView)view4));
                        this.d = (SeekBarForNewVideoPlayer)view3;
                        this.e = (MelonTextView)view4;
                        this.f = (ProgressBar)view1;
                        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.N);
                        q.f(typedArray0, "obtainStyledAttributes(...)");
                        boolean z = typedArray0.getBoolean(0, false);
                        this.b = z;
                        ((SeekBarForNewVideoPlayer)view3).f = z;
                        if(((SeekBarForNewVideoPlayer)view3).i) {
                            ((SeekBarForNewVideoPlayer)view3).a();
                        }
                        if(z) {
                            ((SeekBarForNewVideoPlayer)view3).setThumbOffset(0);
                        }
                        ((SeekBarForNewVideoPlayer)view3).setProgressDrawable(c.getDrawable(((SeekBarForNewVideoPlayer)view3).getContext(), (z ? 0x7F080944 : 0x7F080943)));  // drawable:video_progress_new_border
                        view2.setBackgroundResource((z ? 0x7F08090C : 0x7F08090D));  // drawable:shape_rectangle_white160e
                        ((ProgressBar)view1).setProgressDrawable(c.getDrawable(context0, (z ? 0x7F080942 : 0x7F080941)));  // drawable:video_progress_dragging_border
                        this.setClipChildren(false);
                        typedArray0.recycle();
                        this.h = new X0() {
                            public final VideoSeekBarAndDuration a;

                            {
                                this.a = videoSeekBarAndDuration0;
                            }

                            @Override  // com.iloen.melon.custom.X0
                            public void onStartTracking(SeekBar seekBar0, boolean z) {
                                if(z) {
                                    VideoSeekBarAndDuration videoSeekBarAndDuration0 = this.a;
                                    int v = videoSeekBarAndDuration0.getVideoSeekBar().getWidth();
                                    int v1 = videoSeekBarAndDuration0.getVideoSeekBar().getPaddingLeft();
                                    int v2 = videoSeekBarAndDuration0.getVideoSeekBar().getPaddingRight();
                                    float f = ((float)videoSeekBarAndDuration0.getVideoSeekBar().getProgress()) / ((float)videoSeekBarAndDuration0.getVideoSeekBar().getMax()) * ((float)(v - v1 - v2));
                                    float f1 = videoSeekBarAndDuration0.getVideoSeekBar().getX() + f + ((float)videoSeekBarAndDuration0.getVideoSeekBar().getPaddingLeft());
                                    int v3 = videoSeekBarAndDuration0.getBinding().c.getWidth();
                                    int v4 = (int)(f1 - ((float)(v3 / 2)));
                                    int v5 = (int)(f1 + ((float)(v3 / 2)));
                                    int v6 = ViewUtilsKt.dpToPx(20);
                                    int v7 = videoSeekBarAndDuration0.getVideoSeekBar().getLeft();
                                    int v8 = videoSeekBarAndDuration0.getVideoSeekBar().getPaddingLeft() + v7 + v6;
                                    int v9 = videoSeekBarAndDuration0.getVideoSeekBar().getRight() - videoSeekBarAndDuration0.getVideoSeekBar().getPaddingRight() - v6;
                                    if(v4 < v8) {
                                        v4 = v8;
                                    }
                                    else if(v5 > v9) {
                                        v4 -= v5 - v9;
                                    }
                                    videoSeekBarAndDuration0.getBinding().c.setVisibility(0);
                                    videoSeekBarAndDuration0.getBinding().c.setX(((float)v4));
                                    videoSeekBarAndDuration0.getVideoSeekBar().setInUserAction(true);
                                }
                            }

                            @Override  // com.iloen.melon.custom.X0
                            public void onStopTracking(SeekBar seekBar0) {
                                this.a.getDraggingProgress().setVisibility(8);
                                this.a.getBinding().c.setVisibility(8);
                                this.a.getVideoSeekBar().setInUserAction(false);
                            }

                            @Override  // com.iloen.melon.custom.X0
                            public void onThumbDragging(Integer integer0) {
                                VideoSeekBarAndDuration videoSeekBarAndDuration0 = this.a;
                                videoSeekBarAndDuration0.getDraggingProgress().setVisibility(0);
                                if(integer0 != null) {
                                    videoSeekBarAndDuration0.getDraggingProgress().setProgress(((int)integer0));
                                    return;
                                }
                                videoSeekBarAndDuration0.getDraggingProgress().setVisibility(8);
                            }
                        };
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    public VideoSeekBarAndDuration(Context context0, AttributeSet attributeSet0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0);
    }

    @NotNull
    public final L3 getBinding() {
        return this.c;
    }

    @Nullable
    public final Job getBorderSeekBarDelayShowingJob() {
        return this.g;
    }

    @NotNull
    public final ProgressBar getDraggingProgress() {
        return this.f;
    }

    @NotNull
    public final MelonTextView getTvSeekThumbDuration() {
        return this.e;
    }

    @NotNull
    public final SeekBarForNewVideoPlayer getVideoSeekBar() {
        return this.d;
    }

    public final void initSeekbar(@NotNull D d0, @NotNull VideoViewModel videoViewModel0) {
        q.g(d0, "viewLifecycleOwner");
        q.g(videoViewModel0, "videoViewModel");
        SeekBarForNewVideoPlayer seekBarForNewVideoPlayer0 = this.d;
        if(this.b) {
            Context context0 = this.getContext();
            q.f(context0, "getContext(...)");
            VideoControllerHelper videoControllerHelper0 = new VideoControllerHelper(context0);
            StateView stateView0 = StateView.getView(this.e);
            q.f(stateView0, "getView(...)");
            videoControllerHelper0.a(12, stateView0);
            StateView stateView1 = StateView.getView(seekBarForNewVideoPlayer0);
            q.f(stateView1, "getView(...)");
            videoControllerHelper0.a(13, stateView1);
            d0.getLifecycle().a(new v(videoControllerHelper0));
            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.1(d0, videoViewModel0, this, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.2(d0, videoViewModel0, this, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.3(d0, videoViewModel0, this, null), 3, null);
            VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.4 videoSeekBarAndDuration$setVideoViewModelForBorderSeekBar$40 = new VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.4(videoViewModel0);
            seekBarForNewVideoPlayer0.getClass();
            seekBarForNewVideoPlayer0.c.add(videoSeekBarAndDuration$setVideoViewModelForBorderSeekBar$40);
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new VideoSeekBarAndDuration.setVideoViewModelForCommonSeekbar.1(d0, videoViewModel0, this, null), 3, null);
        VideoSeekBarAndDuration.setVideoViewModelForCommonSeekbar.2 videoSeekBarAndDuration$setVideoViewModelForCommonSeekbar$20 = new VideoSeekBarAndDuration.setVideoViewModelForCommonSeekbar.2(videoViewModel0);
        seekBarForNewVideoPlayer0.getClass();
        seekBarForNewVideoPlayer0.c.add(videoSeekBarAndDuration$setVideoViewModelForCommonSeekbar$20);
    }

    @Override  // android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Job job0 = this.g;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
    }

    public final void setBorderSeekBarDelayShowingJob(@Nullable Job job0) {
        this.g = job0;
    }

    public final void setType(@NotNull SeekBarType videoSeekBarAndDuration$SeekBarType0) {
        q.g(videoSeekBarAndDuration$SeekBarType0, "newType");
        if(q.b(this.a, videoSeekBarAndDuration$SeekBarType0)) {
            return;
        }
        this.a = videoSeekBarAndDuration$SeekBarType0;
        com.iloen.melon.player.video.VideoSeekBarAndDuration.trackingListener.1 videoSeekBarAndDuration$trackingListener$10 = this.h;
        SeekBarForNewVideoPlayer seekBarForNewVideoPlayer0 = this.d;
        if(videoSeekBarAndDuration$SeekBarType0 instanceof Live) {
            if(((Live)videoSeekBarAndDuration$SeekBarType0).getUseTimeMachine()) {
                seekBarForNewVideoPlayer0.setEnableTracking(true);
                seekBarForNewVideoPlayer0.setOnTrackingListener(videoSeekBarAndDuration$trackingListener$10);
            }
            else {
                seekBarForNewVideoPlayer0.setEnableTracking(false);
                seekBarForNewVideoPlayer0.setOnTrackingListener(null);
            }
            seekBarForNewVideoPlayer0.setProgress(seekBarForNewVideoPlayer0.getMax());
            return;
        }
        if(videoSeekBarAndDuration$SeekBarType0 instanceof Preview) {
            seekBarForNewVideoPlayer0.setEnableTracking(true);
            seekBarForNewVideoPlayer0.setOnTrackingListener(videoSeekBarAndDuration$trackingListener$10);
            return;
        }
        if(!(videoSeekBarAndDuration$SeekBarType0 instanceof Vod)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        seekBarForNewVideoPlayer0.setEnableTracking(true);
        seekBarForNewVideoPlayer0.setOnTrackingListener(videoSeekBarAndDuration$trackingListener$10);
    }
}

