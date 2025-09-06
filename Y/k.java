package Y;

import Q0.g0;
import Q0.h0;
import a1.M;
import a1.T;
import a1.d;
import a1.e;
import a1.g;
import android.content.ClipData.Item;
import android.content.ClipData;
import android.os.Parcel;
import android.text.Annotation;
import android.text.Spanned;
import android.util.Base64;
import androidx.compose.ui.platform.AndroidClipboard;
import e.k;
import e1.t;
import e1.u;
import e1.y;
import f1.x;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import l1.l;
import ne.a;
import oe.i;
import r1.o;
import we.n;
import y0.P;
import y0.s;

public final class K extends i implements n {
    public int r;
    public final Q w;

    public K(Q q0, Continuation continuation0) {
        this.w = q0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new K(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((K)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    // This method was un-flattened
    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        long v12;
        int v10;
        int v9;
        g g0;
        g0 g00;
        a a0 = a.a;
        H h0 = H.a;
        Q q0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                h0 h00 = q0.h;
                if(h00 != null) {
                    this.r = 1;
                    ClipData clipData0 = ((AndroidClipboard)h00).a.a.getPrimaryClip();
                    g00 = clipData0 == null ? null : new g0(clipData0);
                    if(g00 == a0) {
                        return a0;
                    }
                    goto label_15;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                g00 = object0;
            label_15:
                if(g00 != null) {
                    ClipData.Item clipData$Item0 = g00.a.getItemAt(0);
                    if(clipData$Item0 == null) {
                        g0 = null;
                    }
                    else {
                        CharSequence charSequence0 = clipData$Item0.getText();
                        if(charSequence0 == null) {
                            g0 = null;
                        }
                        else if(!(charSequence0 instanceof Spanned)) {
                            g0 = new g(charSequence0.toString());
                        }
                        else {
                            Annotation[] arr_annotation = (Annotation[])((Spanned)charSequence0).getSpans(0, charSequence0.length(), Annotation.class);
                            ArrayList arrayList0 = new ArrayList();
                            int v = je.n.l0(arr_annotation);
                            if(v >= 0) {
                                int v1 = 0;
                                while(true) {
                                    Annotation annotation0 = arr_annotation[v1];
                                    if(q.b(annotation0.getKey(), "androidx.compose.text.SpanStyle")) {
                                        int v2 = ((Spanned)charSequence0).getSpanStart(annotation0);
                                        int v3 = ((Spanned)charSequence0).getSpanEnd(annotation0);
                                        String s = annotation0.getValue();
                                        Parcel parcel0 = Parcel.obtain();
                                        byte[] arr_b = Base64.decode(s, 0);
                                        parcel0.unmarshall(arr_b, 0, arr_b.length);
                                        parcel0.setDataPosition(0);
                                        long v4 = s.g;
                                        long v5 = v4;
                                        long v6 = o.c;
                                        long v7 = v6;
                                        y y0 = null;
                                        e1.s s1 = null;
                                        t t0 = null;
                                        String s2 = null;
                                        l1.a a1 = null;
                                        l1.q q1 = null;
                                        l l0 = null;
                                        P p0 = null;
                                    alab1:
                                        while(true) {
                                            if(parcel0.dataAvail() > 1) {
                                                int v8 = parcel0.readByte();
                                                if(v8 != 1) {
                                                    v9 = v2;
                                                    switch(v8) {
                                                        case 3: {
                                                            if(parcel0.dataAvail() >= 4) {
                                                                v2 = v9;
                                                                y0 = new y(parcel0.readInt());
                                                                break;
                                                            }
                                                            else {
                                                                break alab1;
                                                            }
                                                            goto label_62;
                                                        }
                                                        case 4: {
                                                        label_62:
                                                            if(parcel0.dataAvail() >= 1) {
                                                                v2 = v9;
                                                                s1 = new e1.s((parcel0.readByte() == 1 ? 1 : 0));
                                                                break;
                                                            }
                                                            else {
                                                                break alab1;
                                                            }
                                                            goto label_66;
                                                        }
                                                        case 5: {
                                                        label_66:
                                                            if(parcel0.dataAvail() >= 1) {
                                                                switch(parcel0.readByte()) {
                                                                    case 1: {
                                                                        v10 = 0xFFFF;
                                                                        break;
                                                                    }
                                                                    case 2: {
                                                                        v10 = 1;
                                                                        break;
                                                                    }
                                                                    case 3: {
                                                                        v10 = 2;
                                                                        break;
                                                                    }
                                                                    default: {
                                                                        v10 = 0;
                                                                    }
                                                                }
                                                                v2 = v9;
                                                                t0 = new t(v10);
                                                                break;
                                                            }
                                                            else {
                                                                break alab1;
                                                            }
                                                            s2 = parcel0.readString();
                                                            v2 = v9;
                                                            break;
                                                        }
                                                        case 6: {
                                                            s2 = parcel0.readString();
                                                            v2 = v9;
                                                            break;
                                                        }
                                                        case 7: {
                                                            if(parcel0.dataAvail() >= 5) {
                                                                int v11 = parcel0.readByte();
                                                                if(v11 == 1) {
                                                                    v12 = u.M(0x100000000L, parcel0.readFloat());
                                                                }
                                                                else {
                                                                    v12 = v11 == 2 ? u.M(0x200000000L, parcel0.readFloat()) : o.c;
                                                                }
                                                                v7 = v12;
                                                                v2 = v9;
                                                                break;
                                                            }
                                                            else {
                                                                break alab1;
                                                            }
                                                            goto label_90;
                                                        }
                                                        case 8: {
                                                        label_90:
                                                            if(parcel0.dataAvail() >= 4) {
                                                                v2 = v9;
                                                                a1 = new l1.a(parcel0.readFloat());
                                                                break;
                                                            }
                                                            else {
                                                                break alab1;
                                                            }
                                                            goto label_94;
                                                        }
                                                        case 9: {
                                                        label_94:
                                                            if(parcel0.dataAvail() >= 8) {
                                                                v2 = v9;
                                                                q1 = new l1.q(parcel0.readFloat(), parcel0.readFloat());
                                                                break;
                                                            }
                                                            else {
                                                                break alab1;
                                                            }
                                                            goto label_98;
                                                        }
                                                        case 10: {
                                                        label_98:
                                                            if(parcel0.dataAvail() >= 8) {
                                                                v5 = parcel0.readLong();
                                                                v2 = v9;
                                                                break;
                                                            }
                                                            else {
                                                                break alab1;
                                                            }
                                                            goto label_102;
                                                        }
                                                        case 11: {
                                                        label_102:
                                                            if(parcel0.dataAvail() >= 4) {
                                                                int v13 = parcel0.readInt();
                                                                boolean z = (v13 & 2) != 0;
                                                                boolean z1 = (v13 & 1) != 0;
                                                                l l1 = l.d;
                                                                l l2 = l.c;
                                                                if(z && z1) {
                                                                    List list0 = k.A(new l[]{l1, l2});
                                                                    Integer integer0 = 0;
                                                                    int v14 = list0.size();
                                                                    for(int v15 = 0; v15 < v14; ++v15) {
                                                                        integer0 = (int)(integer0.intValue() | ((l)list0.get(v15)).a);
                                                                    }
                                                                    l0 = new l(integer0.intValue());
                                                                }
                                                                else if(z) {
                                                                    l0 = l1;
                                                                }
                                                                else if(z1) {
                                                                    l0 = l2;
                                                                }
                                                                else {
                                                                    l0 = l.b;
                                                                }
                                                            }
                                                            else {
                                                                break alab1;
                                                            }
                                                            v2 = v9;
                                                            break;
                                                        }
                                                        case 12: {
                                                            if(parcel0.dataAvail() >= 20) {
                                                                v2 = v9;
                                                                p0 = new P(parcel0.readLong(), ((long)Float.floatToRawIntBits(parcel0.readFloat())) << 0x20 | ((long)Float.floatToRawIntBits(parcel0.readFloat())) & 0xFFFFFFFFL, parcel0.readFloat());
                                                            }
                                                            else {
                                                                break alab1;
                                                            }
                                                            break;
                                                        }
                                                        default: {
                                                            v2 = v9;
                                                            break;
                                                        }
                                                    }
                                                    continue;
                                                }
                                                else if(parcel0.dataAvail() >= 8) {
                                                    v4 = parcel0.readLong();
                                                    continue;
                                                }
                                            }
                                            v9 = v2;
                                            break;
                                        }
                                        arrayList0.add(new e(new M(v4, v6, y0, s1, t0, null, s2, v7, a1, q1, null, v5, l0, p0, 0xC000), v9, v3));
                                    }
                                    if(v1 == v) {
                                        break;
                                    }
                                    ++v1;
                                }
                            }
                            g0 = new g((arrayList0.isEmpty() ? null : arrayList0), charSequence0.toString());
                        }
                    }
                    if(g0 != null) {
                        d d0 = new d(e2.a.J(q0.m(), q0.m().a.b.length()));
                        d0.b(g0);
                        g g1 = d0.h();
                        g g2 = e2.a.I(q0.m(), q0.m().a.b.length());
                        d d1 = new d(g1);
                        d1.b(g2);
                        g g3 = d1.h();
                        int v16 = T.e(q0.m().b);
                        int v17 = g0.b.length();
                        x x0 = Q.e(a1.t.b(v17 + v16, v17 + v16), g3);
                        q0.c.invoke(x0);
                        q0.q(U.T.a);
                        q0.a.e = true;
                    }
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }
}

