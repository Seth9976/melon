package com.google.gson.internal.bind;

import J0.h;
import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class MapTypeAdapterFactory implements F {
    public final h a;

    public MapTypeAdapterFactory(h h0) {
        this.a = h0;
    }

    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        Type[] arr_type;
        Type type0 = typeToken0.getType();
        Class class0 = typeToken0.getRawType();
        Class class1 = Map.class;
        if(!class1.isAssignableFrom(class0)) {
            return null;
        }
        if(Properties.class.isAssignableFrom(class0)) {
            arr_type = new Type[]{String.class, String.class};
        }
        else {
            if(type0 instanceof WildcardType) {
                type0 = ((WildcardType)type0).getUpperBounds()[0];
            }
            T7.h.b(class1.isAssignableFrom(class0));
            Type type1 = T7.h.k(type0, class0, T7.h.g(type0, class0, class1), new HashMap());
            arr_type = type1 instanceof ParameterizedType ? ((ParameterizedType)type1).getActualTypeArguments() : new Type[]{Object.class, Object.class};
        }
        Type type2 = arr_type[0];
        Type type3 = arr_type[1];
        return type2 == Boolean.TYPE || type2 == Boolean.class ? new k(this, new k(n0, X.c, type2), new k(n0, n0.g(TypeToken.get(type3)), type3), this.a.i(typeToken0, false)) : new k(this, new k(n0, n0.g(TypeToken.get(type2)), type2), new k(n0, n0.g(TypeToken.get(type3)), type3), this.a.i(typeToken0, false));
    }
}

