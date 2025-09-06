package com.iloen.melon.player.video;

import android.content.res.ColorStateList;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import com.iloen.melon.custom.SeekBarForNewVideoPlayer;
import com.iloen.melon.utils.color.ColorUtils;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.video.VideoSeekBarAndDuration$setVideoViewModelForBorderSeekBar$3", f = "VideoSeekBarAndDuration.kt", l = {0x94}, m = "invokeSuspend")
final class VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.3 extends i implements n {
    public final VideoViewModel B;
    public final VideoSeekBarAndDuration D;
    public int r;
    public final D w;

    public VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.3(D d0, VideoViewModel videoViewModel0, VideoSeekBarAndDuration videoSeekBarAndDuration0, Continuation continuation0) {
        this.w = d0;
        this.B = videoViewModel0;
        this.D = videoSeekBarAndDuration0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.3(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                com.iloen.melon.player.video.VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.3.1 videoSeekBarAndDuration$setVideoViewModelForBorderSeekBar$3$10 = new n(this.D, null) {
                    public final VideoSeekBarAndDuration B;
                    public int r;
                    public final VideoViewModel w;

                    {
                        this.w = videoViewModel0;
                        this.B = videoSeekBarAndDuration0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.video.VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.3.1(this.w, this.B, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                com.iloen.melon.player.video.VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.3.1.1 videoSeekBarAndDuration$setVideoViewModelForBorderSeekBar$3$1$10 = new FlowCollector() {
                                    public final VideoSeekBarAndDuration a;

                                    {
                                        this.a = videoSeekBarAndDuration0;
                                    }

                                    @Override  // kotlinx.coroutines.flow.FlowCollector
                                    public Object emit(Object object0, Continuation continuation0) {
                                        return this.emit(((Boolean)object0).booleanValue(), continuation0);
                                    }

                                    public final Object emit(boolean z, Continuation continuation0) {
                                        VideoSeekBarAndDuration videoSeekBarAndDuration0 = this.a;
                                        if(z) {
                                            videoSeekBarAndDuration0.getVideoSeekBar().a();
                                            return H.a;
                                        }
                                        SeekBarForNewVideoPlayer seekBarForNewVideoPlayer0 = videoSeekBarAndDuration0.getVideoSeekBar();
                                        seekBarForNewVideoPlayer0.i = false;
                                        seekBarForNewVideoPlayer0.setThumbTintList(ColorStateList.valueOf(ColorUtils.getColor(seekBarForNewVideoPlayer0.getContext(), 0x7F06048A)));  // color:transparent
                                        return H.a;
                                    }
                                };
                                this.r = 1;
                                if(this.w.getBorderSeekbarThumbVisible().collect(videoSeekBarAndDuration$setVideoViewModelForBorderSeekBar$3$1$10, this) == a0) {
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
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                };
                this.r = 1;
                return f0.j(this.w, s.d, videoSeekBarAndDuration$setVideoViewModelForBorderSeekBar$3$10, this) == a0 ? a0 : H.a;
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
}

