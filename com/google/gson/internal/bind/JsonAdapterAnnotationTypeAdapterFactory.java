package com.google.gson.internal.bind;

import J0.h;
import S7.a;
import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import com.google.gson.w;
import java.lang.annotation.Annotation;
import java.util.concurrent.ConcurrentHashMap;

public final class JsonAdapterAnnotationTypeAdapterFactory implements F {
    static class DummyTypeAdapterFactory implements F {
        private DummyTypeAdapterFactory() {
        }

        public DummyTypeAdapterFactory(int v) {
        }

        @Override  // com.google.gson.F
        public final E a(n n0, TypeToken typeToken0) {
            throw new AssertionError("Factory should not be used");
        }
    }

    public final h a;
    public final ConcurrentHashMap b;
    public static final F c;
    public static final F d;

    static {
        JsonAdapterAnnotationTypeAdapterFactory.c = new DummyTypeAdapterFactory(0);
        JsonAdapterAnnotationTypeAdapterFactory.d = new DummyTypeAdapterFactory(0);
    }

    public JsonAdapterAnnotationTypeAdapterFactory(h h0) {
        this.a = h0;
        this.b = new ConcurrentHashMap();
    }

    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        Annotation annotation0 = typeToken0.getRawType().getAnnotation(a.class);
        return ((a)annotation0) == null ? null : this.b(this.a, n0, typeToken0, ((a)annotation0), true);
    }

    public final E b(h h0, n n0, TypeToken typeToken0, a a0, boolean z) {
        E e0;
        Object object0 = h0.i(TypeToken.get(a0.value()), true).f();
        boolean z1 = a0.nullSafe();
        if(object0 instanceof E) {
            e0 = (E)object0;
        }
        else if(object0 instanceof F) {
            F f0 = (F)object0;
            if(z) {
                F f1 = (F)this.b.putIfAbsent(typeToken0.getRawType(), f0);
                if(f1 != null) {
                    f0 = f1;
                }
            }
            e0 = f0.a(n0, typeToken0);
        }
        else if(object0 instanceof w) {
            t t0 = new t(((w)object0), n0, typeToken0, (z ? JsonAdapterAnnotationTypeAdapterFactory.c : JsonAdapterAnnotationTypeAdapterFactory.d), z1);
            z1 = false;
            e0 = t0;
        }
        else {
            throw new IllegalArgumentException("Invalid attempt to bind an instance of " + object0.getClass().getName() + " as a @JsonAdapter for " + typeToken0.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        }
        return e0 != null && z1 ? e0.a() : e0;
    }
}

