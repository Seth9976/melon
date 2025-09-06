package com.google.gson.internal.bind;

import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;

class EnumTypeAdapter.1 implements F {
    @Override  // com.google.gson.F
    public final E a(n n0, TypeToken typeToken0) {
        Class class0 = typeToken0.getRawType();
        if(Enum.class.isAssignableFrom(class0) && class0 != Enum.class) {
            if(!class0.isEnum()) {
                class0 = class0.getSuperclass();
            }
            return new e(class0);
        }
        return null;
    }
}

