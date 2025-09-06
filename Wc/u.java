package wc;

import Gf.m;
import Jc.X;
import Jc.e0;
import Ud.e;
import android.text.Editable;
import android.text.Selection;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.target.SnsPostListener;
import com.iloen.melon.utils.system.ToastManager;
import e.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.q;
import r1.c;
import v2.t;
import x2.b;
import y0.E;
import y0.H;
import y0.M;
import y0.Q;
import y0.s;
import y8.g;
import z3.p;

public final class u implements e, SnsPostListener, Q, p {
    public final int a;

    public u(int v) {
        this.a = v;
        super();
    }

    public u(m m0) {
        this.a = 7;
        super();
        new ConcurrentHashMap(3, 1.0f, 2);
    }

    @Override  // z3.p
    public void a() {
    }

    public g b() {
        g g0 = g.o;
        if(g0 == null) {
            synchronized(this) {
                g g1 = g.o;
                if(g1 == null) {
                    g1 = new g();
                    g.o = g1;
                }
                return g1;
            }
        }
        return g0;
    }

    @Override  // z3.p
    public void c() {
    }

    public static boolean d(b b0, Editable editable0, int v, int v1, boolean z) {
        boolean z2;
        int v7;
        boolean z1;
        if(editable0 != null && v >= 0 && v1 >= 0) {
            int v2 = Selection.getSelectionStart(editable0);
            int v3 = Selection.getSelectionEnd(editable0);
            if(v2 != -1 && v3 != -1 && v2 == v3) {
                if(z) {
                    int v4 = Math.max(v, 0);
                    if(v2 >= 0 && editable0.length() >= v2 && v4 >= 0) {
                        while(true) {
                            z1 = false;
                        label_8:
                            if(v4 == 0) {
                                goto label_26;
                            }
                            --v2;
                            if(v2 < 0) {
                                if(z1) {
                                    goto label_25;
                                }
                                v2 = 0;
                                goto label_26;
                            }
                            int v5 = editable0.charAt(v2);
                            if(!z1) {
                                break;
                            }
                            if(!Character.isHighSurrogate(((char)v5))) {
                                goto label_25;
                            }
                            --v4;
                        }
                        if(!Character.isSurrogate(((char)v5))) {
                            --v4;
                            goto label_8;
                        }
                        else if(!Character.isHighSurrogate(((char)v5))) {
                            z1 = true;
                            goto label_8;
                        }
                    }
                label_25:
                    v2 = -1;
                label_26:
                    int v6 = Math.max(v1, 0);
                    v7 = editable0.length();
                    if(v3 >= 0 && v7 >= v3 && v6 >= 0) {
                        while(true) {
                            z2 = false;
                        label_30:
                            if(v6 == 0) {
                                v7 = v3;
                                goto label_51;
                            }
                            if(v3 >= v7) {
                                if(!z2) {
                                    goto label_51;
                                }
                                goto label_50;
                            }
                            int v8 = editable0.charAt(v3);
                            if(!z2) {
                                break;
                            }
                            if(!Character.isLowSurrogate(((char)v8))) {
                                goto label_50;
                            }
                            --v6;
                            ++v3;
                        }
                        if(!Character.isSurrogate(((char)v8))) {
                            --v6;
                            ++v3;
                            goto label_30;
                        }
                        else if(!Character.isLowSurrogate(((char)v8))) {
                            ++v3;
                            z2 = true;
                            goto label_30;
                        }
                    }
                label_50:
                    v7 = -1;
                label_51:
                    if(v2 == -1 || v7 == -1) {
                        return false;
                    }
                }
                else {
                    v2 = Math.max(v2 - v, 0);
                    v7 = Math.min(v3 + v1, editable0.length());
                }
                t[] arr_t = (t[])editable0.getSpans(v2, v7, t.class);
                if(arr_t != null && arr_t.length > 0) {
                    for(int v9 = 0; v9 < arr_t.length; ++v9) {
                        t t0 = arr_t[v9];
                        v2 = Math.min(editable0.getSpanStart(t0), v2);
                        v7 = Math.max(editable0.getSpanEnd(t0), v7);
                    }
                    int v10 = Math.min(v7, editable0.length());
                    b0.beginBatchEdit();
                    editable0.delete(Math.max(v2, 0), v10);
                    b0.endBatchEdit();
                    return true;
                }
            }
        }
        return false;
    }

    public static E e(List list0, float f, float f1, int v) {
        float f2 = (v & 2) == 0 ? f : 0.0f;
        return (v & 4) == 0 ? new E(list0, null, ((long)Float.floatToRawIntBits(f2)) << 0x20, ((long)Float.floatToRawIntBits(f1)) << 0x20) : new E(list0, null, ((long)Float.floatToRawIntBits(f2)) << 0x20, 0x7F80000000000000L);
    }

    public static E f(List list0, float f, float f1, int v) {
        float f2 = (v & 2) == 0 ? f : 0.0f;
        return (v & 4) == 0 ? new E(list0, null, ((long)Float.floatToRawIntBits(f2)) & 0xFFFFFFFFL, ((long)Float.floatToRawIntBits(f1)) & 0xFFFFFFFFL) : new E(list0, null, ((long)Float.floatToRawIntBits(f2)) & 0xFFFFFFFFL, 0x7F800000L);
    }

    public static E g(ie.m[] arr_m) {
        ie.m[] arr_m1 = (ie.m[])Arrays.copyOf(arr_m, arr_m.length);
        ArrayList arrayList0 = new ArrayList(arr_m1.length);
        for(int v1 = 0; v1 < arr_m1.length; ++v1) {
            arrayList0.add(new s(((s)arr_m1[v1].b).a));
        }
        ArrayList arrayList1 = new ArrayList(arr_m1.length);
        for(int v = 0; v < arr_m1.length; ++v) {
            arrayList1.add(((Number)arr_m1[v].a).floatValue());
        }
        return new E(arrayList0, arrayList1, 0L, 0x7F800000L);
    }

    @Override  // y0.Q
    public M i(long v, r1.m m0, c c0) {
        return new H(k.d(0L, v));
    }

    @Override  // Ud.e
    public Object onChange(Object object0, boolean z) {
        q.g(((e0)object0), "state");
        return ((e0)object0) instanceof X && ((X)(((e0)object0))).b ? X.a(((X)(((e0)object0))), z, false, 0xBFFFFF) : ((e0)object0);
    }

    @Override  // com.iloen.melon.sns.target.SnsPostListener
    public void onError(String s, Sharable sharable0, Object object0) {
        ToastManager.show(0x7F13106B);  // string:toast_message_facebook_send_fail "페이스북 공유에 실패하였습니다."
    }

    @Override  // com.iloen.melon.sns.target.SnsPostListener
    public void onSuccess(String s, Sharable sharable0) {
    }

    @Override
    public String toString() {
        return this.a == 3 ? "RectangleShape" : super.toString();
    }
}

