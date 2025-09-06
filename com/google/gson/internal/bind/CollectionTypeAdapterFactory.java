package com.google.gson.internal.bind;

import J0.h;
import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.HashMap;

public final class CollectionTypeAdapterFactory implements F {
    public final h a;

    public CollectionTypeAdapterFactory(h h0) {
        this.a = h0;
    }

    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        Type type0 = typeToken0.getType();
        Class class0 = typeToken0.getRawType();
        Class class1 = Collection.class;
        if(!class1.isAssignableFrom(class0)) {
            return null;
        }
        if(type0 instanceof WildcardType) {
            type0 = ((WildcardType)type0).getUpperBounds()[0];
        }
        T7.h.b(class1.isAssignableFrom(class0));
        Type type1 = T7.h.k(type0, class0, T7.h.g(type0, class0, class1), new HashMap());
        if(type1 instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType)type1).getActualTypeArguments()[0];
            return new O(new k(n0, n0.g(TypeToken.get(type2)), type2), this.a.i(typeToken0, false));
        }
        return new O(new k(n0, n0.g(TypeToken.get(Object.class)), Object.class), this.a.i(typeToken0, false));
    }
}

