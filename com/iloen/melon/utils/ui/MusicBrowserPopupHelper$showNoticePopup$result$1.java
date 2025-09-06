package com.iloen.melon.utils.ui;

import Ra.d;
import com.iloen.melon.net.v4x.response.MainNoticePopupRes.Response.NoticePopup;
import com.iloen.melon.utils.log.LogU;
import e1.u;
import ie.H;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.e;
import oe.i;
import va.e0;
import va.o;
import we.n;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.utils.ui.MusicBrowserPopupHelper$showNoticePopup$result$1", f = "MusicBrowserPopupHelper.kt", l = {699}, m = "invokeSuspend")
final class MusicBrowserPopupHelper.showNoticePopup.result.1 extends i implements n {
    public final MusicBrowserPopupHelper B;
    public final NoticePopup D;
    public int r;
    public final List w;

    public MusicBrowserPopupHelper.showNoticePopup.result.1(List list0, MusicBrowserPopupHelper musicBrowserPopupHelper0, NoticePopup mainNoticePopupRes$Response$NoticePopup0, Continuation continuation0) {
        this.w = list0;
        this.B = musicBrowserPopupHelper0;
        this.D = mainNoticePopupRes$Response$NoticePopup0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new MusicBrowserPopupHelper.showNoticePopup.result.1(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((MusicBrowserPopupHelper.showNoticePopup.result.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                String s = u.v(((e0)o.a()).j());
                List list0 = this.w;
                if(list0 != null) {
                    com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showNoticePopup.result.1.1.1 musicBrowserPopupHelper$showNoticePopup$result$1$1$10 = new n(s, list0, null) {
                        public final String B;
                        public final List D;
                        public int r;
                        public final MusicBrowserPopupHelper w;

                        {
                            this.w = musicBrowserPopupHelper0;
                            this.B = s;
                            this.D = list0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showNoticePopup.result.1.1.1(this.w, this.B, this.D, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showNoticePopup.result.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.r) {
                                case 0: {
                                    d5.n.D(object0);
                                    d d0 = MusicBrowserPopupHelper.access$getBannerPopupUseCase(this.w);
                                    this.r = 1;
                                    object0 = d0.a(this.B, "NOTICE", this.D, this);
                                    if(object0 == a0) {
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
                            Y.t("showNoticePopup() deletedCount : ", ((Number)object0).intValue(), LogU.Companion, "MusicBrowserPopupHelper");
                            return H.a;
                        }
                    };
                    this.r = 1;
                    if(BuildersKt.withContext(Dispatchers.getIO(), musicBrowserPopupHelper$showNoticePopup$result$1$1$10, this) == a0) {
                        return a0;
                    }
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
        if(musicBrowserPopupHelper0.l && musicBrowserPopupHelper0.a && !musicBrowserPopupHelper0.b) {
            MusicBrowserPopupHelper.access$dismissNoticePopup(musicBrowserPopupHelper0);
            NoticePopup mainNoticePopupRes$Response$NoticePopup0 = this.D;
            if("-1".equals(mainNoticePopupRes$Response$NoticePopup0.dpType)) {
                MusicBrowserPopupHelper.access$showNoticePopupOnlyCloseButton(musicBrowserPopupHelper0, mainNoticePopupRes$Response$NoticePopup0);
                return true;
            }
            MusicBrowserPopupHelper.access$showNoticePopupWithOption(musicBrowserPopupHelper0, mainNoticePopupRes$Response$NoticePopup0);
            return true;
        }
        return false;
    }
}

