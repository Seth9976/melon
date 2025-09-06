package androidx.datastore.preferences.protobuf;

import e0.b;
import java.util.concurrent.ConcurrentHashMap;

public final class b0 {
    public final M a;
    public final ConcurrentHashMap b;
    public static final b0 c;

    static {
        b0.c = new b0();
    }

    public b0() {
        this.b = new ConcurrentHashMap();
        this.a = new M();
    }

    public final e0 a(Class class0) {
        e0 e01;
        D.a(class0, "messageType");
        ConcurrentHashMap concurrentHashMap0 = this.b;
        e0 e00 = (e0)concurrentHashMap0.get(class0);
        if(e00 == null) {
            M m0 = this.a;
            m0.getClass();
            Class class1 = A.class;
            if(!class1.isAssignableFrom(class0) && (f0.a != null && !f0.a.isAssignableFrom(class0))) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
            d0 d00 = ((L)m0.a).a(class0);
            a a0 = d00.a;
            if((d00.d & 2) == 2) {
                if(class1.isAssignableFrom(class0)) {
                    e01 = new W(f0.c, t.a, a0);
                    goto label_45;
                }
                m0 m00 = f0.b;
                s s0 = t.b;
                if(s0 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                e01 = new W(m00, s0, a0);
                goto label_45;
            }
            if(class1.isAssignableFrom(class0)) {
                s s1 = null;
                X x0 = Y.b;
                I i0 = J.b;
                m0 m01 = f0.c;
                if(b.b(d00.a()) != 1) {
                    s1 = t.a;
                }
                Q q0 = S.b;
                if(d00 instanceof d0) {
                    e01 = V.w(d00, x0, i0, m01, s1, q0);
                    goto label_45;
                }
                d00.getClass();
                throw new ClassCastException();
            }
            s s2 = null;
            X x1 = Y.a;
            I i1 = J.a;
            m0 m02 = f0.b;
            if(b.b(d00.a()) != 1) {
                s2 = t.b;
                if(s2 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
            }
            Q q1 = S.a;
            if(d00 instanceof d0) {
                e01 = V.w(d00, x1, i1, m02, s2, q1);
            label_45:
                e0 e02 = (e0)concurrentHashMap0.putIfAbsent(class0, e01);
                return e02 == null ? e01 : e02;
            }
            d00.getClass();
            throw new ClassCastException();
        }
        return e00;
    }
}

