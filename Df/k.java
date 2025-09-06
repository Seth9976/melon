package df;

import De.I;
import Hf.W;
import Hf.x;
import Me.S;
import Me.e;
import Ne.f;
import Se.A;
import Se.h;
import Se.i;
import Se.j;
import Se.n;
import Se.w;
import Se.z;
import Sf.g;
import androidx.media3.session.legacy.V;
import bf.b;
import cf.c;
import com.google.firebase.messaging.u;
import h7.u0;
import ie.m;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import we.a;

public final class k implements a {
    public final int a;
    public final u b;
    public final o c;

    public k(u u0, o o0) {
        this.a = 1;
        super();
        this.b = u0;
        this.c = o0;
    }

    public k(o o0, u u0) {
        this.a = 0;
        super();
        this.c = o0;
        this.b = u0;
    }

    @Override  // we.a
    public final Object invoke() {
        b b3;
        ArrayList arrayList7;
        m m0;
        w w2;
        je.w w0;
        if(this.a != 0) {
            return p.T0(((yf.a)((cf.a)this.b.a).x).f(this.c.n, this.b));
        }
        o o0 = this.c;
        n n0 = o0.o;
        u u0 = o0.b;
        e e0 = o0.n;
        Constructor[] arr_constructor = n0.a.getDeclaredConstructors();
        q.f(arr_constructor, "getDeclaredConstructors(...)");
        Collection collection0 = Sf.n.p0(Sf.n.n0(new g(je.n.O(arr_constructor), false, i.b), j.b));
        Collection collection1 = new ArrayList(collection0.size());
        for(Object object0: collection0) {
            Se.q q0 = (Se.q)object0;
            c c0 = u0.Q(u0, q0);
            cf.a a0 = (cf.a)u0.a;
            b b0 = b.K1(e0, c0, false, a0.j.b(q0));
            int v = e0.h().size();
            Object object1 = u0.c;
            u u1 = new u(a0, new A1.k(u0, b0, q0, v), ((ie.j)object1));
            Constructor constructor0 = q0.a;
            Type[] arr_type = constructor0.getGenericParameterTypes();
            q.d(arr_type);
            if(arr_type.length == 0) {
                w0 = je.w.a;
            }
            else {
                Class class0 = constructor0.getDeclaringClass();
                if(class0.getDeclaringClass() != null && !Modifier.isStatic(class0.getModifiers())) {
                    arr_type = (Type[])je.n.a0(arr_type, 1, arr_type.length);
                }
                Annotation[][] arr2_annotation = constructor0.getParameterAnnotations();
                if(arr2_annotation.length < arr_type.length) {
                    throw new IllegalStateException("Illegal generic signature: " + constructor0);
                }
                if(arr2_annotation.length > arr_type.length) {
                    arr2_annotation = (Annotation[][])je.n.a0(arr2_annotation, arr2_annotation.length - arr_type.length, arr2_annotation.length);
                }
                w0 = q0.d(arr_type, arr2_annotation, constructor0.isVarArgs());
            }
            B b1 = C.u(u1, b0, w0);
            List list0 = e0.h();
            q.f(list0, "getDeclaredTypeParameters(...)");
            ArrayList arrayList0 = q0.getTypeParameters();
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
            for(Object object2: arrayList0) {
                S s0 = ((cf.e)u1.b).c(((Se.B)object2));
                q.d(s0);
                arrayList1.add(s0);
            }
            ArrayList arrayList2 = p.A0(list0, arrayList1);
            b0.I1(b1.b, I.W(q0.e()), arrayList2);
            b0.B1(false);
            b0.C1(b1.c);
            b0.D1(e0.g());
            ((cf.a)u1.a).g.getClass();
            ((ArrayList)collection1).add(b0);
        }
        boolean z = n0.g();
        Class class1 = n0.a;
        u u2 = this.b;
        f f0 = Ne.g.a;
        if(z) {
            b b2 = b.K1(e0, f0, true, ((cf.a)u0.a).j.b(n0));
            ArrayList arrayList3 = n0.f();
            ArrayList arrayList4 = new ArrayList(arrayList3.size());
            ef.a a1 = v.L(W.b, false, null, 6);
            int v1 = 0;
            for(Object object3: arrayList3) {
                x x0 = ((V)u0.d).C(((z)object3).f(), a1);
                arrayList4.add(new Pe.S(b2, null, v1, f0, ((z)object3).c(), x0, false, false, false, null, ((cf.a)u0.a).j.b(((z)object3))));
                ++v1;
            }
            b2.C1(false);
            Me.o o1 = e0.getVisibility();
            q.f(o1, "getVisibility(...)");
            if(o1.equals(Ze.o.b)) {
                o1 = Ze.o.c;
                q.f(o1, "PROTECTED_AND_PACKAGE");
            }
            b2.H1(arrayList4, o1);
            b2.B1(false);
            b2.D1(e0.g());
            String s1 = d5.n.q(b2, 2);
            if(!((ArrayList)collection1).isEmpty()) {
                for(Object object4: ((ArrayList)collection1)) {
                    if(!q.b(d5.n.q(((Pe.i)object4), 2), s1)) {
                        continue;
                    }
                    goto label_90;
                }
            }
            ((ArrayList)collection1).add(b2);
            ((cf.a)u2.a).g.getClass();
        }
    label_90:
        ((yf.a)((cf.a)u2.a).x).a(e0, ((ArrayList)collection1), u2);
        hf.c c1 = ((cf.a)u2.a).r;
        if(((ArrayList)collection1).isEmpty()) {
            boolean z1 = class1.isAnnotation();
            if(!class1.isInterface()) {
                n0.getClass();
            }
            if(z1) {
                cf.a a2 = (cf.a)u0.a;
                V v2 = (V)u0.d;
                b b4 = b.K1(e0, f0, true, a2.j.b(n0));
                Collection collection2 = n0.d();
                List list1 = new ArrayList(collection2.size());
                ef.a a3 = v.L(W.b, true, null, 6);
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                for(Object object5: collection2) {
                    if(q.b(((w)object5).c(), Ze.v.b)) {
                        arrayList5.add(object5);
                    }
                    else {
                        arrayList6.add(object5);
                    }
                }
                w w1 = (w)p.m0(arrayList5);
                if(w1 == null) {
                    w2 = null;
                    arrayList7 = arrayList6;
                }
                else {
                    A a4 = w1.f();
                    if(a4 instanceof h) {
                        w2 = w1;
                        m0 = new m(v2.B(((h)a4), a3, true), v2.C(((h)a4).b, a3));
                    }
                    else {
                        w2 = w1;
                        m0 = new m(v2.C(a4, a3), null);
                    }
                    arrayList7 = arrayList6;
                    o0.v(((ArrayList)list1), b4, 0, w2, ((x)m0.a), ((x)m0.b));
                }
                int v3 = 0;
                for(Object object6: arrayList7) {
                    o0.v(((ArrayList)list1), b4, v3 + (w2 == null ? 0 : 1), ((w)object6), v2.C(((w)object6).f(), a3), null);
                    ++v3;
                }
                b4.C1(false);
                Me.o o2 = e0.getVisibility();
                q.f(o2, "getVisibility(...)");
                if(o2.equals(Ze.o.b)) {
                    o2 = Ze.o.c;
                    q.f(o2, "PROTECTED_AND_PACKAGE");
                }
                b4.H1(list1, o2);
                b4.B1(true);
                b4.D1(e0.g());
                ((cf.a)u0.a).g.getClass();
                b3 = b4;
            }
            else {
                b3 = null;
            }
            collection1 = e.k.B(b3);
        }
        return p.P0(c1.e(u2, collection1));
    }
}

