package com.melon.ui;

import Cb.j;
import Vc.A;
import com.iloen.melon.playback.playlist.add.AddFailType.SectionRepeatInterrupt;
import com.iloen.melon.playback.playlist.add.AddResult.Failure;
import com.iloen.melon.playback.playlist.add.AddResult;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import qb.h;
import qb.i;
import qb.l;
import qb.m;
import qb.n;
import qb.o;
import qb.p;
import qb.q;
import qb.r;
import qb.s;
import qb.t;
import qb.u;
import we.k;

public final class a3 implements FlowCollector {
    public final k a;
    public final b3 b;
    public final CoroutineScope c;

    public a3(k k0, b3 b30, CoroutineScope coroutineScope0) {
        this.a = k0;
        this.b = b30;
        this.c = coroutineScope0;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        u u0 = (u)object0;
        H h0 = H.a;
        if(u0 instanceof q) {
            Object object1 = BuildersKt.withContext(Dispatchers.getMain(), new W2(u0, null), continuation0);
            if(object1 == a.a) {
                return object1;
            }
        }
        else {
            b3 b30 = this.b;
            k k0 = this.a;
            if(u0 instanceof s) {
                k0.invoke(new r4(b30.c.a(0x7F1300D0), b30.c.a(0x7F1300C4), null, null, null, null, 0x7C));  // string:alert_dlg_title_info "안내"
                return h0;
            }
            if(u0 instanceof p) {
                j.b(((p)u0).a, false, 3);
                return h0;
            }
            if(!(u0 instanceof qb.j)) {
                if(u0 instanceof qb.k) {
                    String s = ((qb.k)u0).a.getMessage();
                    if(s != null) {
                        k0.invoke(new t4(s));
                        return h0;
                    }
                }
                else if(u0 instanceof l) {
                    AddResult addResult0 = ((l)u0).a;
                    if(addResult0 instanceof Failure && kotlin.jvm.internal.q.b(((Failure)addResult0).getType(), SectionRepeatInterrupt.INSTANCE)) {
                        k0.invoke(new r4(b30.c.a(0x7F1300D0), b30.c.a(0x7F13090E), null, new A(this.c, b30, u0, k0, 2), null, null, 108));  // string:alert_dlg_title_info "안내"
                        return h0;
                    }
                }
                else {
                    if(kotlin.jvm.internal.q.b(u0, t.a)) {
                        k0.invoke(new q4(28, b30.c.a(0x7F1300D0), b30.c.a(0x7F1303C6), null, null));  // string:alert_dlg_title_info "안내"
                        return h0;
                    }
                    if(u0 instanceof n) {
                        Object object2 = BuildersKt.withContext(Dispatchers.getMain(), new Y2(u0, null), continuation0);
                        if(object2 == a.a) {
                            return object2;
                        }
                    }
                    else {
                        if(u0 instanceof h) {
                            k0.invoke(new t4(b30.c.a(0x7F13019A)));  // string:cannot_find_album_info "앨범 정보가 없습니다."
                            return h0;
                        }
                        if(u0 instanceof i) {
                            k0.invoke(new t4(b30.c.a(0x7F13019B)));  // string:cannot_find_artist_info "아티스트 정보가 없습니다."
                            return h0;
                        }
                        if(!(u0 instanceof o)) {
                            goto label_42;
                        }
                        Object object3 = BuildersKt.withContext(Dispatchers.getMain(), new Z2(u0, null), continuation0);
                        if(object3 == a.a) {
                            return object3;
                        label_42:
                            if(u0 instanceof r) {
                                k0.invoke(new l2(((r)u0).a, ((r)u0).b));
                                return h0;
                            }
                            if(!kotlin.jvm.internal.q.b(u0, m.a)) {
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                            k0.invoke(new t4(b30.c.a(0x7F130729)));  // string:music_wave_delete_my_channel_toast "채널이 삭제 되었습니다."
                            k0.invoke(p4.a);
                            return h0;
                        }
                    }
                }
            }
        }
        return h0;
    }
}

