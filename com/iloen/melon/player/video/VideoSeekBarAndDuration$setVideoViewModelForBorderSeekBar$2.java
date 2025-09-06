package com.iloen.melon.player.video;

import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.video.VideoSeekBarAndDuration$setVideoViewModelForBorderSeekBar$2", f = "VideoSeekBarAndDuration.kt", l = {0x81}, m = "invokeSuspend")
final class VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.2 extends i implements n {
    public final VideoViewModel B;
    public final VideoSeekBarAndDuration D;
    public int r;
    public final D w;

    public VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.2(D d0, VideoViewModel videoViewModel0, VideoSeekBarAndDuration videoSeekBarAndDuration0, Continuation continuation0) {
        this.w = d0;
        this.B = videoViewModel0;
        this.D = videoSeekBarAndDuration0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.2(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                com.iloen.melon.player.video.VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.2.1 videoSeekBarAndDuration$setVideoViewModelForBorderSeekBar$2$10 = new n(this.D, null) {
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
                        return new com.iloen.melon.player.video.VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.2.1(this.w, this.B, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                com.iloen.melon.player.video.VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.2.1.1 videoSeekBarAndDuration$setVideoViewModelForBorderSeekBar$2$1$10 = new FlowCollector() {
                                    public final VideoSeekBarAndDuration a;
                                    public final VideoViewModel b;

                                    {
                                        VideoSeekBarAndDuration videoSeekBarAndDuration0 = this.w;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                        this.a = videoSeekBarAndDuration0;
                                        this.b = videoViewModel0;
                                    }

                                    @Override  // kotlinx.coroutines.flow.FlowCollector
                                    public Object emit(Object object0, Continuation continuation0) {
                                        return this.emit(((Boolean)object0).booleanValue(), continuation0);
                                    }

                                    public final Object emit(boolean z, Continuation continuation0) {
                                        VideoSeekBarAndDuration videoSeekBarAndDuration0 = this.a;
                                        Job job0 = videoSeekBarAndDuration0.getBorderSeekBarDelayShowingJob();
                                        if(job0 != null) {
                                            DefaultImpls.cancel$default(job0, null, 1, null);
                                        }
                                        if(z) {
                                            videoSeekBarAndDuration0.setBorderSeekBarDelayShowingJob(BuildersKt__Builders_commonKt.launch$default(f0.h(this.b), Dispatchers.getMain(), null, new n(null) {
                                                public int r;
                                                public final VideoSeekBarAndDuration w;

                                                {
                                                    this.w = videoSeekBarAndDuration0;
                                                    super(2, continuation0);
                                                }

                                                @Override  // oe.a
                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                    return new com.iloen.melon.player.video.VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.2.1.1.1(this.w, continuation0);
                                                }

                                                @Override  // we.n
                                                public Object invoke(Object object0, Object object1) {
                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                }

                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                    return ((com.iloen.melon.player.video.VideoSeekBarAndDuration.setVideoViewModelForBorderSeekBar.2.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                }

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    a a0 = a.a;
                                                    switch(this.r) {
                                                        case 0: {
                                                            d5.n.D(object0);
                                                            this.r = 1;
                                                            if(DelayKt.delay(200L, this) == a0) {
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
                                                    this.w.setVisibility(0);
                                                    return H.a;
                                                }
                                            }, 2, null));
                                            return H.a;
                                        }
                                        videoSeekBarAndDuration0.setVisibility(8);
                                        return H.a;
                                    }
                                };
                                this.r = 1;
                                if(this.w.getBorderSeekbarVisible().collect(videoSeekBarAndDuration$setVideoViewModelForBorderSeekBar$2$1$10, this) == a0) {
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
                return f0.j(this.w, s.d, videoSeekBarAndDuration$setVideoViewModelForBorderSeekBar$2$10, this) == a0 ? a0 : H.a;
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

