package com.google.gson.internal.bind;

import T7.h;
import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

class ArrayTypeAdapter.1 implements F {
    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        Type type1;
        Type type0 = typeToken0.getType();
        if(!(type0 instanceof GenericArrayType) && (!(type0 instanceof Class) || !((Class)type0).isArray())) {
            return null;
        }
        if(type0 instanceof GenericArrayType) {
            type1 = ((GenericArrayType)type0).getGenericComponentType();
            return new a(n0, n0.g(TypeToken.get(type1)), h.h(type1));
        }
        type1 = ((Class)type0).getComponentType();
        return new a(n0, n0.g(TypeToken.get(type1)), h.h(type1));
    }
}

