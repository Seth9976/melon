package Ge;

import Af.p;
import De.w;
import Me.e;
import Re.c;
import Re.f;
import Tf.o;
import df.d;
import i.n.i.b.a.s.e.M3;
import ie.j;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import qf.b;
import we.a;

public final class t implements a {
    public final int a;
    public final B b;

    public t(B b0, int v) {
        this.a = v;
        this.b = b0;
        super();
    }

    public t(B b0, y y0) {
        this.a = 7;
        super();
        this.b = b0;
    }

    @Override  // we.a
    public final Object invoke() {
        Object object0 = null;
        B b0 = this.b;
        switch(this.a) {
            case 0: {
                return new y(b0);
            }
            case 1: {
                return b0.p(b0.z().g().E(), D.a);
            }
            case 2: {
                p p0 = b0.z().t0();
                q.f(p0, "getStaticScope(...)");
                return b0.p(p0, D.a);
            }
            case 3: {
                return b0.p(b0.z().g().E(), D.b);
            }
            case 4: {
                p p1 = b0.z().t0();
                q.f(p1, "getStaticScope(...)");
                return b0.p(p1, D.b);
            }
            case 5: {
                b b1 = b0.y();
                Class class0 = b0.b;
                u0 u00 = ((y)((j)b0.c).getValue()).a;
                w w0 = C.b[0];
                Object object2 = u00.invoke();
                q.f(object2, "getValue(...)");
                e e0 = !b1.c || !class0.isAnnotationPresent(Metadata.class) ? Me.w.d(((f)object2).a.b, b1) : ((f)object2).a.b(b1);
                if(e0 == null) {
                    if(class0.isSynthetic()) {
                        return B.x(b1, ((f)object2));
                    }
                    c c0 = a.a.q(class0);
                    if(c0 != null) {
                        object0 = (kf.a)c0.b.d;
                    }
                    switch((object0 == null ? -1 : z.a[((Enum)object0).ordinal()])) {
                        case 1: 
                        case 2: 
                        case 3: 
                        case 4: {
                            return B.x(b1, ((f)object2));
                        }
                        case 5: {
                            throw new s0("Unknown class: " + class0 + " (kind = " + object0 + ')');
                        }
                        case -1: 
                        case 6: {
                            throw new s0("Unresolved class: " + class0 + " (kind = " + object0 + ')');
                        }
                        default: {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                    }
                }
                return e0;
            }
            case 6: {
                Annotation[] arr_annotation = b0.b.getAnnotations();
                q.f(arr_annotation, "getAnnotations(...)");
                ArrayList arrayList1 = new ArrayList();
                for(int v = 0; v < arr_annotation.length; ++v) {
                    Annotation annotation0 = arr_annotation[v];
                    String s = d.v(d.s(annotation0)).getName();
                    if(!B.d.contains(s)) {
                        arrayList1.add(annotation0);
                    }
                }
                return A0.m(arrayList1);
            }
            case 7: {
                Class class1 = b0.b;
                if(!class1.isAnonymousClass()) {
                    b b2 = b0.y();
                    if(b2.c) {
                        String s1 = class1.getSimpleName();
                        Method method0 = class1.getEnclosingMethod();
                        if(method0 != null) {
                            return o.X0(s1, method0.getName() + '$');
                        }
                        Constructor constructor0 = class1.getEnclosingConstructor();
                        return constructor0 == null ? o.W0('$', s1, s1) : o.X0(s1, constructor0.getName() + '$');
                    }
                    object0 = b2.f().b();
                    q.f(object0, "asString(...)");
                }
                return object0;
            }
            case 8: {
                if(!b0.b.isAnonymousClass()) {
                    b b3 = b0.y();
                    if(!b3.c) {
                        return b3.a().a.a;
                    }
                }
                return null;
            }
            default: {
                Iterable iterable0 = b0.i();
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
                for(Object object1: iterable0) {
                    arrayList0.add(new H(b0, ((Me.j)object1)));
                }
                return arrayList0;
            }
        }
    }
}

