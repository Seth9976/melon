package Mc;

import Ac.K;
import Ac.L;
import Cb.i;
import Cc.V3;
import Cc.W3;
import F.s;
import Jd.b;
import Jd.c;
import Jd.d;
import Jd.e;
import Jd.f;
import Nb.h0;
import Nc.A0;
import Nc.J;
import Nc.Z0;
import Nc.d0;
import Nc.m;
import Nc.v1;
import O.j;
import O.w;
import Oc.A;
import Oc.D;
import Oc.G;
import Oc.N;
import Oc.Q;
import Oc.U;
import Oc.r;
import Oc.t;
import Oc.x;
import Oc.y;
import Oc.z;
import Qc.h;
import Rc.O;
import U8.u;
import U8.v;
import Vb.o0;
import Vc.B;
import androidx.lifecycle.f0;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType3Res.RESPONSE.ALBUMLIST;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType3Res.RESPONSE;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType5Res.RESPONSE.GNRDETAILCONTENTS.AGEARTISTLIST;
import com.iloen.melon.net.v5x.response.GenreDetailRes.RESPONSE.GNRDETAILCONTENTS.LICENSE3TYPE;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.K4;
import com.melon.ui.a1;
import com.melon.ui.b1;
import com.melon.ui.c1;
import com.melon.ui.d1;
import com.melon.utils.lifecycle.AppVisibilityManagerImpl;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import je.p;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import oc.o;
import we.k;

public final class q implements k {
    public final int a;
    public final Object b;

    public q(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        e e0 = e.c;
        c c0 = c.c;
        b b0 = b.c;
        f f0 = f.c;
        d d0 = d.c;
        int v = 0;
        H h0 = H.a;
        Object object1 = this.b;
        switch(this.a) {
            case 0: {
                kotlin.jvm.internal.q.g(((w)object0), "$this$MelonLazyColumn");
                K k0 = new K(((r)object1).b, 17);
                m0.b b1 = new m0.b(0xBEF78951, new Mc.r(((r)object1).b, 0), true);
                ((j)(((w)object0))).u(((r)object1).b.size(), null, k0, b1);
                return h0;
            }
            case 1: {
                kotlin.jvm.internal.q.g(((w)object0), "$this$MelonLazyColumn");
                s s0 = new s(6, ((G)object1).b);
                m0.b b2 = new m0.b(0xBEF78951, new Id.d(2, ((G)object1).b), true);
                ((j)(((w)object0))).u(((G)object1).b.size(), null, s0, b2);
                return h0;
            }
            case 2: {
                kotlin.jvm.internal.q.g(((w)object0), "$this$MelonLazyColumn");
                K k1 = new K(((Oc.H)object1).b, 18);
                m0.b b3 = new m0.b(0xBEF78951, new Mc.r(((Oc.H)object1).b, 1), true);
                ((j)(((w)object0))).u(((Oc.H)object1).b.size(), null, k1, b3);
                return h0;
            }
            case 3: {
                kotlin.jvm.internal.q.g(((w)object0), "$this$MelonLazyColumn");
                s s1 = new s(7, ((Q)object1).a);
                m0.b b4 = new m0.b(0xBEF78951, new Id.d(3, ((Q)object1).a), true);
                ((j)(((w)object0))).u(((Q)object1).a.size(), null, s1, b4);
                return h0;
            }
            case 4: {
                kotlin.jvm.internal.q.g(((Throwable)object0), "e");
                LogU.error$default(((h0)object1).h, "Exception", ((Throwable)object0), false, 4, null);
                String s2 = ((Throwable)object0).getMessage();
                if(s2 == null) {
                    s2 = "Unknown Exception";
                }
                ToastManager.debug(("Exception in MelonLibrarySessionCallback: " + s2));
                return h0;
            }
            case 5: {
                kotlin.jvm.internal.q.g(((w)object0), "$this$MelonLazyRow");
                K k2 = new K(((J)object1).b, 19);
                m0.b b5 = new m0.b(0xBEF78951, new L(12, ((J)object1).b, ((J)object1)), true);
                ((j)(((w)object0))).u(((J)object1).b.size(), null, k2, b5);
                return h0;
            }
            case 6: {
                kotlin.jvm.internal.q.g(((w)object0), "$this$MelonLazyRow");
                s s3 = new s(9, ((d0)object1).b);
                m0.b b6 = new m0.b(0xBEF78951, new Id.d(4, ((d0)object1).b), true);
                ((j)(((w)object0))).u(((d0)object1).b.size(), null, s3, b6);
                return h0;
            }
            case 7: {
                kotlin.jvm.internal.q.g(((w)object0), "$this$MelonLazyRow");
                s s4 = new s(10, ((Z0)object1).b);
                m0.b b7 = new m0.b(0xBEF78951, new Id.d(5, ((Z0)object1).b), true);
                ((j)(((w)object0))).u(((Z0)object1).b.size(), null, s4, b7);
                return h0;
            }
            case 8: {
                Throwable throwable0 = (Throwable)object0;
                ((O9.e)object1).g = false;
                return h0;
            }
            case 9: {
                kotlin.jvm.internal.q.g(((Ob.c)object0), "it");
                return (Ob.c)object1;
            }
            case 10: {
                kotlin.jvm.internal.q.g(((Ob.c)object0), "it");
                kotlin.jvm.internal.q.g(((Ob.c)object0).a, "path");
                return new Ob.c(((Ob.c)object0).a, ((Ob.d)object1).a, ((Ob.c)object0).c, ((Ob.c)object0).d);
            }
            case 11: {
                kotlin.jvm.internal.q.g(((A0)object0), "it");
                MelonLinkExecutor.open(MelonLinkInfo.b(((LICENSE3TYPE)object1)));
                return h0;
            }
            case 12: {
                kotlin.jvm.internal.q.g(((W3)object0), "toolBarUserEvent");
                if(!(((W3)object0) instanceof V3)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                switch(((V3)(((W3)object0))).b) {
                    case 0: {
                        break;
                    }
                    case 1: {
                        e0 = c0;
                        break;
                    }
                    case 2: {
                        e0 = b0;
                        break;
                    }
                    case 14: {
                        e0 = f0;
                        break;
                    }
                    case 0x1F: {
                        e0 = d0;
                        break;
                    }
                    default: {
                        e0 = null;
                    }
                }
                if(e0 != null) {
                    r r0 = ((x)object1).f();
                    if(r0 != null) {
                        ArrayList arrayList0 = new ArrayList();
                        for(Object object2: r0.b) {
                            if(((v1)object2).i) {
                                arrayList0.add(object2);
                            }
                        }
                        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                        for(Object object3: arrayList0) {
                            String s5 = ((x)object1).getMenuId();
                            ((v1)object3).h.setMenuid(s5);
                            arrayList1.add(((v1)object3).h);
                        }
                        BuildersKt__Builders_commonKt.launch$default(f0.h(((x)object1)), null, null, new t(e0, ((x)object1), arrayList1, null), 3, null);
                    }
                }
                return h0;
            }
            case 13: {
                kotlin.jvm.internal.q.g(((d1)object0), "fetchResult");
                if(((d1)object0) instanceof com.melon.ui.Z0) {
                    Object object4 = ((D)object1).getUiState().getValue();
                    A a0 = object4 instanceof A ? ((A)object4) : null;
                    return a0 == null ? new z(((com.melon.ui.Z0)(((d1)object0))).a) : a0;
                }
                if(((d1)object0) instanceof b1) {
                    return new y(Q1.c.q(((b1)(((d1)object0))).a));
                }
                if(((d1)object0) instanceof c1) {
                    RESPONSE genreDetailGuiType3Res$RESPONSE0 = (RESPONSE)((c1)(((d1)object0))).a;
                    ((D)object1).getClass();
                    ArrayList arrayList2 = genreDetailGuiType3Res$RESPONSE0.albumList;
                    kotlin.jvm.internal.q.f(arrayList2, "albumList");
                    ArrayList arrayList3 = new ArrayList(je.q.Q(10, arrayList2));
                    for(Object object5: arrayList2) {
                        if(v >= 0) {
                            kotlin.jvm.internal.q.d(((ALBUMLIST)object5));
                            arrayList3.add(Q1.c.W(((ALBUMLIST)object5), new Mc.y(13, ((ALBUMLIST)object5), ((D)object1))));
                            ++v;
                            continue;
                        }
                        e.k.O();
                        throw null;
                    }
                    ((D)object1).a.d(arrayList3, genreDetailGuiType3Res$RESPONSE0.hasMore);
                    Object object6 = ((D)object1).getUiState().getValue();
                    A a1 = object6 instanceof A ? ((A)object6) : null;
                    return a1 == null ? new A(arrayList3) : new A(p.A0(a1.a, arrayList3));
                }
                if(!(((d1)object0) instanceof a1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return null;
            }
            case 14: {
                kotlin.jvm.internal.q.g(((W3)object0), "toolBarUserEvent");
                if(!(((W3)object0) instanceof V3)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                switch(((V3)(((W3)object0))).b) {
                    case 0: {
                        break;
                    }
                    case 1: {
                        e0 = c0;
                        break;
                    }
                    case 2: {
                        e0 = b0;
                        break;
                    }
                    case 14: {
                        e0 = f0;
                        break;
                    }
                    case 0x1F: {
                        e0 = d0;
                        break;
                    }
                    default: {
                        e0 = null;
                    }
                }
                if(e0 != null) {
                    Oc.H h1 = ((N)object1).f();
                    if(h1 != null) {
                        ArrayList arrayList4 = new ArrayList();
                        for(Object object7: h1.b) {
                            if(((v1)object7).i) {
                                arrayList4.add(object7);
                            }
                        }
                        ArrayList arrayList5 = new ArrayList(je.q.Q(10, arrayList4));
                        for(Object object8: arrayList4) {
                            String s6 = ((N)object1).getMenuId();
                            ((v1)object8).h.setMenuid(s6);
                            arrayList5.add(((v1)object8).h);
                        }
                        BuildersKt__Builders_commonKt.launch$default(f0.h(((N)object1)), null, null, new Oc.J(e0, ((N)object1), arrayList5, null), 3, null);
                    }
                }
                return h0;
            }
            case 15: {
                return U.e(((U)object1), ((d1)object0));
            }
            case 16: {
                kotlin.jvm.internal.q.g(((m)object0), "userEvent");
                if(!(((m)object0) instanceof m)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                String s7 = ((AGEARTISTLIST)object1).gnrArtistSeq;
                kotlin.jvm.internal.q.f(s7, "gnrArtistSeq");
                if(s7.length() > 0) {
                    Navigator.INSTANCE.openGenreArtistDetail(((AGEARTISTLIST)object1).gnrArtistSeq);
                    return h0;
                }
                String s8 = ((AGEARTISTLIST)object1).getArtistId();
                if(s8 != null && s8.length() != 0) {
                    Navigator.openArtistInfo(((AGEARTISTLIST)object1).getArtistId());
                }
                return h0;
            }
            case 17: {
                kotlin.jvm.internal.q.g(((K4)object0), "it");
                return new h(((Qc.w)object1).d);
            }
            case 18: {
                kotlin.jvm.internal.q.g(((K4)object0), "it");
                return (O)object1;
            }
            case 19: {
                return ((Tf.k)object1).a(((int)(((Integer)object0))));
            }
            case 20: {
                ((Boolean)object0).getClass();
                ((U8.h)object1).invoke();
                return h0;
            }
            case 21: {
                kotlin.jvm.internal.q.g(((K4)object0), "it");
                U8.r r1 = ((K4)object0) instanceof U8.r ? ((U8.r)(((K4)object0))) : null;
                U8.r r2 = r1 == null ? null : U8.r.a(r1, false, 0, false, 0, ((float[])object1), null, 0x37F);
                kotlin.jvm.internal.q.e(r2, "null cannot be cast to non-null type com.melon.ui.UiState");
                return r2;
            }
            case 22: {
                kotlin.jvm.internal.q.g(((W3)object0), "event");
                LogU.Companion.d("ToolBarUiState", ((W3)object0).toString());
                if(((W3)object0) instanceof V3) {
                    switch(((V3)(((W3)object0))).b) {
                        case 8: {
                            ((U8.w)object1).sendUiEvent(u.a);
                            return h0;
                        }
                        case 24: {
                            ((U8.w)object1).sendUiEvent(new v());  // 初始化器: Ljava/lang/Object;-><init>()V
                            return h0;
                        }
                        case 25: {
                            ((U8.w)object1).sendUiEvent(U8.t.a);
                            return h0;
                        }
                        default: {
                            return h0;
                        }
                    }
                }
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            case 23: {
                K4 k40 = (K4)object0;
                Uc.w w0 = ((Uc.Q)object1).j;
                String s9 = ((Uc.Q)object1).h.b();
                if(s9 == null) {
                    s9 = "";
                }
                w0.getClass();
                Wc.h h2 = w0.d;
                if(h2 != null) {
                    h2.e = 0;
                    return new Uc.t(new Uc.r(e.k.z(new Vc.r(s9, new B(h2, 4)))));
                }
                kotlin.jvm.internal.q.m("loginSlotController");
                throw null;
            }
            case 24: {
                K4 k41 = (K4)object0;
                return new Uc.t(((Uc.r)object1));
            }
            case 25: {
                kotlin.jvm.internal.q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("handleMelonNotificationException()");
                i.a(((StringBuilder)object0), "command: " + i.o(((Yb.f)object1).a));
                i.a(((StringBuilder)object0), "modification: " + i.o(((Yb.f)object1).b));
                return h0;
            }
            case 26: {
                kotlin.jvm.internal.q.g(((String)object0), "message");
                if(((AppVisibilityManagerImpl)((o0)object1).F.a).e) {
                    ToastManager.show(((String)object0));
                    gc.y.K0(((o0)object1), false, 0, null, "handleDrmLoadException() " + ((String)object0), 7);
                    return h0;
                }
                ((o0)object1).q1();
                return h0;
            }
            case 27: {
                ((StringBuilder)object0).append("handleSeekToMediaItem() handleSeekTo result: " + i.o(((oc.f0)object1)));
                return h0;
            }
            case 28: {
                ((StringBuilder)object0).append("handleSeekToNextMediaItem() handleNext result: " + i.o(((oc.h)object1)));
                return h0;
            }
            default: {
                ((StringBuilder)object0).append("handleSeekToPreviousMediaItem() handlePrevious result: " + i.o(((o)object1)));
                return h0;
            }
        }
    }
}

