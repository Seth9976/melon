package n1;

import G.L;
import G.o;
import G.t0;
import N0.S;
import androidx.compose.foundation.w;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import je.p;
import je.u;
import kotlin.jvm.internal.q;
import q1.a;
import q1.c;
import we.k;

public final class e extends i {
    public final int c;

    public e(int v, k k0) {
        this.c = v;
        super(k0);
    }

    @Override  // n1.i
    public final void a(Collection collection0) {
        h h0;
        f f0;
        switch(this.c) {
            case 0: {
                ArrayList arrayList6 = new ArrayList();
                for(Object object6: collection0) {
                    if(!((c)object6).a().isEmpty()) {
                        arrayList6.add(object6);
                    }
                }
                for(Object object7: arrayList6) {
                    for(Object object8: ((c)object7).a()) {
                        w w0 = new w(this, 15);
                        ((S)object8).a.any(w0);
                    }
                }
                return;
            }
            case 1: {
                ArrayList arrayList7 = new ArrayList();
                Iterator iterator9 = collection0.iterator();
                while(true) {
                    a a0 = null;
                    if(!iterator9.hasNext()) {
                        break;
                    }
                    Object object9 = iterator9.next();
                    c c4 = (c)object9;
                    if(c4.c == null || !q.b(c4.b, "animateValueAsState")) {
                        c4 = null;
                    }
                    if(c4 != null && c4 instanceof a) {
                        a0 = (a)c4;
                    }
                    if(a0 != null) {
                        arrayList7.add(a0);
                    }
                }
                ArrayList arrayList8 = new ArrayList();
                for(Object object10: arrayList7) {
                    G.e e0 = e.c(((a)object10));
                    o o0 = e.d(((a)object10));
                    b0 b00 = e.e(((a)object10));
                    if(e0 == null || o0 == null || b00 == null) {
                        f0 = null;
                    }
                    else {
                        if(b00.getValue() == null) {
                            b00.setValue(new r(e0.d()));
                        }
                        Object object11 = b00.getValue();
                        r r0 = object11 instanceof r ? ((r)object11) : null;
                        if(r0 == null) {
                            r0 = new r(e0.d());
                        }
                        f0 = new f(e0, o0, r0);
                    }
                    if(f0 != null) {
                        arrayList8.add(f0);
                    }
                }
                this.b.addAll(arrayList8);
                return;
            }
            case 2: {
                ArrayList arrayList9 = new ArrayList();
                for(Object object12: collection0) {
                    c c5 = e.g(((c)object12));
                    if(c5 != null) {
                        arrayList9.add(c5);
                    }
                }
                ArrayList arrayList10 = new ArrayList();
                Iterator iterator12 = arrayList9.iterator();
                while(true) {
                    Object object13 = null;
                    if(!iterator12.hasNext()) {
                        break;
                    }
                    Object object14 = iterator12.next();
                    for(Object object15: ((Iterable)((c)object14).f)) {
                        if(!(object15 instanceof t0)) {
                            continue;
                        }
                        goto label_134;
                    }
                    object15 = null;
                label_134:
                    if(object15 instanceof t0) {
                        object13 = object15;
                    }
                    if(((t0)object13) != null) {
                        arrayList10.add(((t0)object13));
                    }
                }
                ArrayList arrayList11 = new ArrayList();
                for(Object object16: arrayList9) {
                    List list1 = new ArrayList();
                    ArrayList arrayList12 = e.k.C(new c[]{((c)object16)});
                    while(!arrayList12.isEmpty()) {
                        c c6 = (c)u.Z(arrayList12);
                        if(q.b(c6.b, "remember")) {
                            list1 = e.k.z(c6);
                            break;
                        }
                        arrayList12.addAll(((Collection)c6.g));
                    }
                    c c7 = (c)p.m0(list1);
                    if(c7 != null) {
                        arrayList11.add(c7);
                    }
                }
                ArrayList arrayList13 = new ArrayList();
                for(Object object17: arrayList11) {
                    for(Object object18: ((Iterable)((c)object17).f)) {
                        if(!(object18 instanceof t0)) {
                            continue;
                        }
                        goto label_166;
                    }
                    object18 = null;
                label_166:
                    if(!(object18 instanceof t0)) {
                        object18 = null;
                    }
                    if(((t0)object18) != null) {
                        arrayList13.add(((t0)object18));
                    }
                }
                ArrayList arrayList14 = p.A0(arrayList10, arrayList13);
                this.b.addAll(arrayList14);
                return;
            }
            case 3: {
                ArrayList arrayList15 = new ArrayList();
                for(Object object19: collection0) {
                    c c8 = e.h(((c)object19));
                    if(c8 != null) {
                        arrayList15.add(c8);
                    }
                }
                ArrayList arrayList16 = new ArrayList();
                Iterator iterator18 = arrayList15.iterator();
                while(true) {
                    Object object20 = null;
                    if(!iterator18.hasNext()) {
                        break;
                    }
                    Object object21 = iterator18.next();
                    for(Object object22: ((Iterable)((c)object21).f)) {
                        if(!(object22 instanceof t0)) {
                            continue;
                        }
                        goto label_193;
                    }
                    object22 = null;
                label_193:
                    if(object22 instanceof t0) {
                        object20 = object22;
                    }
                    if(((t0)object20) != null) {
                        arrayList16.add(((t0)object20));
                    }
                }
                ArrayList arrayList17 = new ArrayList();
                for(Object object23: arrayList15) {
                    List list2 = new ArrayList();
                    ArrayList arrayList18 = e.k.C(new c[]{((c)object23)});
                    while(!arrayList18.isEmpty()) {
                        c c9 = (c)u.Z(arrayList18);
                        if(q.b(c9.b, "remember")) {
                            list2 = e.k.z(c9);
                            break;
                        }
                        arrayList18.addAll(((Collection)c9.g));
                    }
                    c c10 = (c)p.m0(list2);
                    if(c10 != null) {
                        arrayList17.add(c10);
                    }
                }
                ArrayList arrayList19 = new ArrayList();
                for(Object object24: arrayList17) {
                    for(Object object25: ((Iterable)((c)object24).f)) {
                        if(!(object25 instanceof t0)) {
                            continue;
                        }
                        goto label_225;
                    }
                    object25 = null;
                label_225:
                    if(!(object25 instanceof t0)) {
                        object25 = null;
                    }
                    if(((t0)object25) != null) {
                        arrayList19.add(((t0)object25));
                    }
                }
                ArrayList arrayList20 = p.A0(arrayList16, arrayList19);
                this.b.addAll(arrayList20);
                return;
            }
            case 4: {
                ArrayList arrayList21 = new ArrayList();
                Iterator iterator23 = collection0.iterator();
                while(true) {
                    a a1 = null;
                    if(!iterator23.hasNext()) {
                        break;
                    }
                    Object object26 = iterator23.next();
                    c c11 = (c)object26;
                    if(c11.c == null || !q.b(c11.b, "rememberInfiniteTransition")) {
                        c11 = null;
                    }
                    if(c11 != null && c11 instanceof a) {
                        a1 = (a)c11;
                    }
                    if(a1 != null) {
                        arrayList21.add(a1);
                    }
                }
                ArrayList arrayList22 = new ArrayList();
                for(Object object27: arrayList21) {
                    Object object28 = ((a)object27).f;
                    ArrayList arrayList23 = new ArrayList();
                    for(Object object29: ((Iterable)((a)object27).g)) {
                        u.U(arrayList23, ((Iterable)((c)object29).f));
                    }
                    for(Object object30: p.A0(((Collection)object28), arrayList23)) {
                        if(!(object30 instanceof L)) {
                            continue;
                        }
                        goto label_263;
                    }
                    object30 = null;
                label_263:
                    if(!(object30 instanceof L)) {
                        object30 = null;
                    }
                    b0 b01 = e.f(((a)object27));
                    if(((L)object30) == null || b01 == null) {
                        h0 = null;
                    }
                    else {
                        if(b01.getValue() == null) {
                            b01.setValue(new r(0L));
                        }
                        Object object31 = b01.getValue();
                        r r1 = object31 instanceof r ? ((r)object31) : null;
                        if(r1 == null) {
                            r1 = new r(0L);
                        }
                        h0 = new h(((L)object30), r1);
                    }
                    if(h0 != null) {
                        arrayList22.add(h0);
                    }
                }
                this.b.addAll(arrayList22);
                return;
            }
            default: {
                ArrayList arrayList0 = new ArrayList();
                Iterator iterator0 = collection0.iterator();
                while(true) {
                    c c0 = null;
                    if(!iterator0.hasNext()) {
                        break;
                    }
                    Object object0 = iterator0.next();
                    c c1 = (c)object0;
                    if(c1.c != null && q.b(c1.b, "updateTransition")) {
                        c0 = c1;
                    }
                    if(c0 != null) {
                        arrayList0.add(c0);
                    }
                }
                ArrayList arrayList1 = new ArrayList();
                for(Object object1: arrayList0) {
                    for(Object object2: ((Iterable)((c)object1).f)) {
                        if(!(object2 instanceof t0)) {
                            continue;
                        }
                        goto label_22;
                    }
                    object2 = null;
                label_22:
                    if(!(object2 instanceof t0)) {
                        object2 = null;
                    }
                    if(((t0)object2) != null) {
                        arrayList1.add(((t0)object2));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for(Object object3: arrayList0) {
                    List list0 = new ArrayList();
                    ArrayList arrayList3 = e.k.C(new c[]{((c)object3)});
                    while(!arrayList3.isEmpty()) {
                        c c2 = (c)u.Z(arrayList3);
                        if(q.b(c2.b, "remember")) {
                            list0 = e.k.z(c2);
                            break;
                        }
                        arrayList3.addAll(((Collection)c2.g));
                    }
                    c c3 = (c)p.m0(list0);
                    if(c3 != null) {
                        arrayList2.add(c3);
                    }
                }
                ArrayList arrayList4 = new ArrayList();
                for(Object object4: arrayList2) {
                    for(Object object5: ((Iterable)((c)object4).f)) {
                        if(!(object5 instanceof t0)) {
                            continue;
                        }
                        goto label_54;
                    }
                    object5 = null;
                label_54:
                    if(!(object5 instanceof t0)) {
                        object5 = null;
                    }
                    if(((t0)object5) != null) {
                        arrayList4.add(((t0)object5));
                    }
                }
                ArrayList arrayList5 = p.A0(arrayList1, arrayList4);
                this.b.addAll(arrayList5);
            }
        }
    }

    @Override  // n1.i
    public final boolean b(c c0) {
        a a0 = null;
        Object object0 = null;
        switch(this.c) {
            case 0: {
                if(!c0.a().isEmpty()) {
                    Iterable iterable0 = c0.a();
                    if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                        for(Object object1: iterable0) {
                            if(((S)object1).a.any(d.f)) {
                                return true;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                }
                return false;
            }
            case 1: {
                if(c0.c == null || !q.b(c0.b, "animateValueAsState")) {
                    c0 = null;
                }
                if(c0 != null && c0 instanceof a) {
                    a0 = (a)c0;
                }
                return a0 != null && e.c(a0) != null && e.d(a0) != null && e.e(a0) != null;
            }
            case 2: {
                return e.g(c0) != null;
            }
            case 3: {
                return e.h(c0) != null;
            }
            case 4: {
                c c1 = c0.c == null || !q.b(c0.b, "rememberInfiniteTransition") ? null : c0;
                if((c1 == null || !(c1 instanceof a) ? null : ((a)c1)) != null) {
                    Object object2 = c0.f;
                    ArrayList arrayList0 = new ArrayList();
                    for(Object object3: ((Iterable)c0.g)) {
                        u.U(arrayList0, ((Iterable)((c)object3).f));
                    }
                    Object object4 = null;
                    for(Object object5: p.A0(((Collection)object2), arrayList0)) {
                        if(object5 instanceof L) {
                            object4 = object5;
                            break;
                        }
                    }
                    if(object4 instanceof L) {
                        object0 = object4;
                    }
                    return ((L)object0) != null && e.f(c0) != null;
                }
                return false;
            }
            default: {
                if(c0.c == null || !q.b(c0.b, "updateTransition")) {
                    c0 = null;
                }
                return c0 != null;
            }
        }
    }

    public static G.e c(a a0) {
        Object object0 = null;
        for(Object object1: ((Iterable)a0.f)) {
            if(object1 instanceof G.e) {
                object0 = object1;
                break;
            }
        }
        if(!(object0 instanceof G.e)) {
            object0 = null;
        }
        List list0 = ((G.e)object0) == null ? je.w.a : e.k.z(((G.e)object0));
        Iterable iterable0 = (Iterable)a0.g;
        ArrayList arrayList0 = new ArrayList();
        for(Object object2: iterable0) {
            for(Object object3: ((Iterable)((c)object2).f)) {
                if(!(object3 instanceof G.e)) {
                    continue;
                }
                goto label_23;
            }
            object3 = null;
        label_23:
            if(!(object3 instanceof G.e)) {
                object3 = null;
            }
            if(((G.e)object3) != null) {
                arrayList0.add(((G.e)object3));
            }
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object4: iterable0) {
            List list1 = new ArrayList();
            ArrayList arrayList2 = e.k.C(new c[]{((c)object4)});
            while(!arrayList2.isEmpty()) {
                c c0 = (c)u.Z(arrayList2);
                if(q.b(c0.b, "remember")) {
                    list1 = e.k.z(c0);
                    break;
                }
                arrayList2.addAll(((Collection)c0.g));
            }
            c c1 = (c)p.m0(list1);
            if(c1 != null) {
                arrayList1.add(c1);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for(Object object5: arrayList1) {
            for(Object object6: ((Iterable)((c)object5).f)) {
                if(!(object6 instanceof G.e)) {
                    continue;
                }
                goto label_55;
            }
            object6 = null;
        label_55:
            if(!(object6 instanceof G.e)) {
                object6 = null;
            }
            if(((G.e)object6) != null) {
                arrayList3.add(((G.e)object6));
            }
        }
        return (G.e)p.m0(p.A0(list0, p.A0(arrayList0, arrayList3)));
    }

    public static o d(a a0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: ((Iterable)a0.g)) {
            if(q.b(((c)object0).b, "rememberUpdatedState")) {
                arrayList0.add(object0);
            }
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object1: arrayList0) {
            u.U(arrayList1, ((Iterable)((c)object1).g));
        }
        ArrayList arrayList2 = p.A0(arrayList0, arrayList1);
        ArrayList arrayList3 = new ArrayList();
        for(Object object2: arrayList2) {
            u.U(arrayList3, ((Iterable)((c)object2).f));
        }
        ArrayList arrayList4 = new ArrayList();
        for(Object object3: arrayList3) {
            if(object3 instanceof b1) {
                arrayList4.add(object3);
            }
        }
        ArrayList arrayList5 = new ArrayList(je.q.Q(10, arrayList4));
        for(Object object4: arrayList4) {
            arrayList5.add(((b1)object4).getValue());
        }
        ArrayList arrayList6 = new ArrayList();
        for(Object object5: arrayList5) {
            if(object5 instanceof o) {
                arrayList6.add(object5);
            }
        }
        return (o)p.m0(arrayList6);
    }

    public static b0 e(a a0) {
        Object object0 = null;
        for(Object object1: ((Iterable)a0.f)) {
            if(object1 instanceof b0) {
                object0 = object1;
                break;
            }
        }
        if(!(object0 instanceof b0)) {
            object0 = null;
        }
        List list0 = ((b0)object0) == null ? je.w.a : e.k.z(((b0)object0));
        Iterable iterable0 = (Iterable)a0.g;
        ArrayList arrayList0 = new ArrayList();
        for(Object object2: iterable0) {
            for(Object object3: ((Iterable)((c)object2).f)) {
                if(!(object3 instanceof b0)) {
                    continue;
                }
                goto label_23;
            }
            object3 = null;
        label_23:
            if(!(object3 instanceof b0)) {
                object3 = null;
            }
            if(((b0)object3) != null) {
                arrayList0.add(((b0)object3));
            }
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object4: iterable0) {
            List list1 = new ArrayList();
            ArrayList arrayList2 = e.k.C(new c[]{((c)object4)});
            while(!arrayList2.isEmpty()) {
                c c0 = (c)u.Z(arrayList2);
                if(q.b(c0.b, "remember")) {
                    list1 = e.k.z(c0);
                    break;
                }
                arrayList2.addAll(((Collection)c0.g));
            }
            c c1 = (c)p.m0(list1);
            if(c1 != null) {
                arrayList1.add(c1);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for(Object object5: arrayList1) {
            for(Object object6: ((Iterable)((c)object5).f)) {
                if(!(object6 instanceof b0)) {
                    continue;
                }
                goto label_55;
            }
            object6 = null;
        label_55:
            if(!(object6 instanceof b0)) {
                object6 = null;
            }
            if(((b0)object6) != null) {
                arrayList3.add(((b0)object6));
            }
        }
        return (b0)p.m0(p.A0(list0, p.A0(arrayList0, arrayList3)));
    }

    public static b0 f(c c0) {
        Object object5;
        Object object0 = c0.f;
        Object object1 = c0.g;
        ArrayList arrayList0 = new ArrayList();
        for(Object object2: ((Iterable)object1)) {
            u.U(arrayList0, ((Iterable)((c)object2).g));
        }
        ArrayList arrayList1 = p.A0(((Collection)object1), arrayList0);
        ArrayList arrayList2 = new ArrayList();
        for(Object object3: arrayList1) {
            u.U(arrayList2, ((Iterable)((c)object3).f));
        }
        Object object4 = null;
        Iterator iterator2 = p.A0(((Collection)object0), arrayList2).iterator();
        while(true) {
            object5 = null;
            if(!iterator2.hasNext()) {
                break;
            }
            Object object6 = iterator2.next();
            if(object6 instanceof b0) {
                object4 = object6;
                break;
            }
        }
        if(object4 instanceof b0) {
            object5 = object4;
        }
        return (b0)object5;
    }

    public static c g(c c0) {
        if(c0.c == null || !q.b(c0.b, "AnimatedContent")) {
            c0 = null;
        }
        if(c0 != null) {
            for(Object object0: ((Iterable)c0.g)) {
                if(q.b(((c)object0).b, "updateTransition")) {
                    return object0;
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    public static c h(c c0) {
        if(c0.c == null || !q.b(c0.b, "AnimatedVisibility")) {
            c0 = null;
        }
        if(c0 != null) {
            for(Object object0: ((Iterable)c0.g)) {
                if(q.b(((c)object0).b, "updateTransition")) {
                    return object0;
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }
}

