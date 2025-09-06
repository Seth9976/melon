package com.google.gson;

import J0.h;
import W7.b;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.X;
import com.google.gson.internal.bind.d;
import com.google.gson.internal.bind.f;
import com.google.gson.internal.bind.l;
import com.google.gson.internal.bind.m;
import com.google.gson.internal.bind.v;
import com.google.gson.internal.sql.c;
import com.google.gson.reflect.TypeToken;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class n {
    public final ThreadLocal a;
    public final ConcurrentHashMap b;
    public final h c;
    public final JsonAdapterAnnotationTypeAdapterFactory d;
    public final List e;
    public final Map f;
    public final boolean g;
    public final i h;
    public final List i;
    public final List j;
    public final List k;
    public final int l;
    public static final i m;
    public static final a n;
    public static final com.google.gson.C.y o;
    public static final com.google.gson.C.z p;

    static {
        n.m = i.d;
        n.n = com.google.gson.h.a;
        n.o = C.a;
        n.p = C.b;
    }

    public n() {
        this(Excluder.c, n.n, Collections.EMPTY_MAP, true, n.m, 0, true, 1, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, n.o, n.p, Collections.EMPTY_LIST);
    }

    public n(Excluder excluder0, com.google.gson.h h0, Map map0, boolean z, i i0, int v, boolean z1, int v1, List list0, List list1, List list2, C c0, C c1, List list3) {
        this.a = new ThreadLocal();
        this.b = new ConcurrentHashMap();
        this.f = map0;
        h h1 = new h(map0, z1, list3);
        this.c = h1;
        this.g = z;
        this.h = i0;
        this.l = v;
        this.i = list0;
        this.j = list1;
        this.k = list3;
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(X.A);
        arrayList0.add(m.d(c0));
        arrayList0.add(excluder0);
        arrayList0.addAll(list2);
        arrayList0.add(X.p);
        arrayList0.add(X.g);
        arrayList0.add(X.d);
        arrayList0.add(X.e);
        arrayList0.add(X.f);
        v v2 = v1 == 1 ? X.k : new k();
        arrayList0.add(X.c(Long.TYPE, Long.class, v2));
        j j0 = new j(0);
        arrayList0.add(X.c(Double.TYPE, Double.class, j0));
        j j1 = new j(1);
        arrayList0.add(X.c(Float.TYPE, Float.class, j1));
        arrayList0.add((c1 == C.b ? l.b : l.d(c1)));
        arrayList0.add(X.h);
        arrayList0.add(X.i);
        D d0 = new com.google.gson.l(v2, 0).a();
        arrayList0.add(X.b(AtomicLong.class, d0));
        D d1 = new com.google.gson.l(v2, 1).a();
        arrayList0.add(X.b(AtomicLongArray.class, d1));
        arrayList0.add(X.j);
        arrayList0.add(X.l);
        arrayList0.add(X.q);
        arrayList0.add(X.r);
        arrayList0.add(X.b(BigDecimal.class, X.m));
        arrayList0.add(X.b(BigInteger.class, X.n));
        arrayList0.add(X.b(T7.j.class, X.o));
        arrayList0.add(X.s);
        arrayList0.add(X.t);
        arrayList0.add(X.v);
        arrayList0.add(X.w);
        arrayList0.add(X.y);
        arrayList0.add(X.u);
        arrayList0.add(X.b);
        arrayList0.add(d.c);
        arrayList0.add(X.x);
        if(c.a) {
            arrayList0.add(c.e);
            arrayList0.add(c.d);
            arrayList0.add(c.f);
        }
        arrayList0.add(com.google.gson.internal.bind.a.c);
        arrayList0.add(X.a);
        arrayList0.add(new CollectionTypeAdapterFactory(h1));
        arrayList0.add(new MapTypeAdapterFactory(h1));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory0 = new JsonAdapterAnnotationTypeAdapterFactory(h1);
        this.d = jsonAdapterAnnotationTypeAdapterFactory0;
        arrayList0.add(jsonAdapterAnnotationTypeAdapterFactory0);
        arrayList0.add(X.B);
        arrayList0.add(new ReflectiveTypeAdapterFactory(h1, h0, excluder0, jsonAdapterAnnotationTypeAdapterFactory0, list3));
        this.e = Collections.unmodifiableList(arrayList0);
    }

    public static void a(double f) {
        if(Double.isNaN(f) || Double.isInfinite(f)) {
            throw new IllegalArgumentException(f + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final Object b(W7.a a0, TypeToken typeToken0) {
        Object object0;
        int v = a0.o;
        boolean z = true;
        int v1 = this.l;
        if(v1 != 0) {
            a0.c0(v1);
        }
        else if(v == 2) {
            a0.o = 1;
        }
        try {
            a0.Z();
            z = false;
            E e0 = this.g(typeToken0);
            object0 = e0.b(a0);
            if(object0 != null && !T7.h.m(typeToken0.getRawType()).isInstance(object0)) {
                throw new ClassCastException("Type adapter \'" + e0 + "\' returned wrong type; requested " + typeToken0.getRawType() + " but got instance of " + object0.getClass() + "\nVerify that the adapter was registered for the correct type.");
            }
            return object0;
        }
        catch(EOFException eOFException0) {
            if(!z) {
                throw new x(eOFException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
            }
            return null;
        }
        catch(IllegalStateException illegalStateException0) {
            throw new x(illegalStateException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
        }
        catch(IOException iOException0) {
            throw new x(iOException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
        }
        catch(AssertionError assertionError0) {
            throw new AssertionError("AssertionError (GSON 2.13.1): " + assertionError0.getMessage(), assertionError0);
        }
        finally {
            a0.c0(v);
        }
    }

    public final Object c(q q0, Class class0) {
        TypeToken typeToken0 = TypeToken.get(class0);
        com.google.gson.internal.bind.h h0 = new com.google.gson.internal.bind.h(com.google.gson.internal.bind.h.E);  // 初始化器: LW7/a;-><init>(Ljava/io/Reader;)V
        h0.r = new Object[0x20];
        h0.w = 0;
        h0.B = new String[0x20];
        h0.D = new int[0x20];
        h0.u0(q0);
        return this.b(h0, typeToken0);
    }

    public final Object d(String s, TypeToken typeToken0) {
        if(s == null) {
            return null;
        }
        W7.a a0 = new W7.a(new StringReader(s));
        a0.c0((this.l == 0 ? 2 : this.l));
        Object object0 = this.b(a0, typeToken0);
        if(object0 == null) {
            return object0;
        }
        else {
            try {
                if(a0.Z() != 10) {
                    throw new x("JSON document was not fully consumed.");  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
                }
                return object0;
            }
            catch(W7.c c0) {
            }
            catch(IOException iOException0) {
                throw new r(iOException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
            }
        }
        throw new x(c0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
    }

    public final Object e(String s, Class class0) {
        return this.d(s, TypeToken.get(class0));
    }

    public final Object f(String s, Type type0) {
        return this.d(s, TypeToken.get(type0));
    }

    public final E g(TypeToken typeToken0) {
        E e2;
        boolean z;
        Objects.requireNonNull(typeToken0, "type must not be null");
        ConcurrentHashMap concurrentHashMap0 = this.b;
        E e0 = (E)concurrentHashMap0.get(typeToken0);
        if(e0 != null) {
            return e0;
        }
        ThreadLocal threadLocal0 = this.a;
        Map map0 = (Map)threadLocal0.get();
        if(map0 == null) {
            map0 = new HashMap();
            threadLocal0.set(map0);
            z = true;
        }
        else {
            E e1 = (E)map0.get(typeToken0);
            if(e1 != null) {
                return e1;
            }
            z = false;
        }
        try {
            com.google.gson.m m0 = new com.google.gson.m();
            map0.put(typeToken0, m0);
            e2 = null;
            for(Object object0: this.e) {
                e2 = ((F)object0).a(this, typeToken0);
                if(e2 != null) {
                    if(m0.a != null) {
                        throw new AssertionError("Delegate is already set");
                    }
                    m0.a = e2;
                    map0.put(typeToken0, e2);
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        finally {
            if(z) {
                threadLocal0.remove();
            }
        }
        if(e2 == null) {
            throw new IllegalArgumentException("GSON (2.13.1) cannot handle " + typeToken0);
        }
        if(z) {
            concurrentHashMap0.putAll(map0);
        }
        return e2;
    }

    public final E h(F f0, TypeToken typeToken0) {
        Objects.requireNonNull(f0, "skipPast must not be null");
        Objects.requireNonNull(typeToken0, "type must not be null");
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory0 = this.d;
        jsonAdapterAnnotationTypeAdapterFactory0.getClass();
        ConcurrentHashMap concurrentHashMap0 = jsonAdapterAnnotationTypeAdapterFactory0.b;
        if(f0 == JsonAdapterAnnotationTypeAdapterFactory.c) {
            f0 = jsonAdapterAnnotationTypeAdapterFactory0;
        }
        else {
            Class class0 = typeToken0.getRawType();
            F f1 = (F)concurrentHashMap0.get(class0);
            if(f1 == null) {
                S7.a a0 = (S7.a)class0.getAnnotation(S7.a.class);
                if(a0 != null) {
                    Class class1 = a0.value();
                    if(F.class.isAssignableFrom(class1)) {
                        TypeToken typeToken1 = TypeToken.get(class1);
                        F f2 = (F)jsonAdapterAnnotationTypeAdapterFactory0.a.i(typeToken1, true).f();
                        F f3 = (F)concurrentHashMap0.putIfAbsent(class0, f2);
                        if(f3 != null) {
                            f2 = f3;
                        }
                        if(f2 == f0) {
                            f0 = jsonAdapterAnnotationTypeAdapterFactory0;
                        }
                    }
                }
            }
            else if(f1 == f0) {
                f0 = jsonAdapterAnnotationTypeAdapterFactory0;
            }
        }
        boolean z = false;
        for(Object object0: this.e) {
            F f4 = (F)object0;
            if(z) {
                E e0 = f4.a(this, typeToken0);
                if(e0 != null) {
                    return e0;
                }
                if(false) {
                    break;
                }
            }
            else {
                if(f4 != f0) {
                    continue;
                }
                z = true;
            }
        }
        if(z) {
            throw new IllegalArgumentException("GSON cannot serialize or deserialize " + typeToken0);
        }
        return this.g(typeToken0);
    }

    public final b i(Writer writer0) {
        b b0 = new b(writer0);
        b0.E(this.h);
        b0.i = this.g;
        b0.F((this.l == 0 ? 2 : this.l));
        b0.k = false;
        return b0;
    }

    public final String j(q q0) {
        StringWriter stringWriter0 = new StringWriter();
        try {
            this.m(this.i(stringWriter0), q0);
            return stringWriter0.toString();
        }
        catch(IOException iOException0) {
            throw new r(iOException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
        }
    }

    public final String k(Object object0) {
        return object0 == null ? this.j(s.a) : this.l(object0, object0.getClass());
    }

    public final String l(Object object0, Class class0) {
        StringWriter stringWriter0 = new StringWriter();
        try {
            this.n(object0, class0, this.i(stringWriter0));
            return stringWriter0.toString();
        }
        catch(IOException iOException0) {
            throw new r(iOException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
        }
    }

    public final void m(b b0, q q0) {
        int v = b0.h;
        boolean z = b0.i;
        boolean z1 = b0.k;
        b0.i = this.g;
        b0.k = false;
        int v1 = this.l;
        if(v1 != 0) {
            b0.F(v1);
        }
        else if(v == 2) {
            b0.h = 1;
        }
        try {
            X.z.getClass();
            f.e(b0, q0);
        }
        catch(IOException iOException0) {
            throw new r(iOException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
        }
        catch(AssertionError assertionError0) {
            throw new AssertionError("AssertionError (GSON 2.13.1): " + assertionError0.getMessage(), assertionError0);
        }
        finally {
            b0.F(v);
            b0.i = z;
            b0.k = z1;
        }
    }

    public final void n(Object object0, Class class0, b b0) {
        boolean z1;
        boolean z;
        E e0 = this.g(TypeToken.get(class0));
        int v = b0.h;
        int v1 = this.l;
        if(v1 != 0) {
            b0.F(v1);
        }
        else if(v == 2) {
            b0.h = 1;
        }
        try {
            z = b0.i;
            z1 = b0.k;
            b0.i = this.g;
            b0.k = false;
            e0.c(b0, object0);
        }
        catch(IOException iOException0) {
            throw new r(iOException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
        }
        catch(AssertionError assertionError0) {
            throw new AssertionError("AssertionError (GSON 2.13.1): " + assertionError0.getMessage(), assertionError0);
        }
        finally {
            b0.F(v);
            b0.i = z;
            b0.k = z1;
        }
    }

    @Override
    public final String toString() {
        return "{serializeNulls:false,factories:" + this.e + ",instanceCreators:" + this.c + "}";
    }
}

