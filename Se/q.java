package Se;

import gf.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

public final class q extends v implements e {
    public final Constructor a;

    public q(Constructor constructor0) {
        kotlin.jvm.internal.q.g(constructor0, "member");
        super();
        this.a = constructor0;
    }

    @Override  // Se.v
    public final Member b() {
        return this.a;
    }

    @Override  // gf.e
    public final ArrayList getTypeParameters() {
        TypeVariable[] arr_typeVariable = this.a.getTypeParameters();
        kotlin.jvm.internal.q.f(arr_typeVariable, "getTypeParameters(...)");
        ArrayList arrayList0 = new ArrayList(arr_typeVariable.length);
        for(int v = 0; v < arr_typeVariable.length; ++v) {
            arrayList0.add(new B(arr_typeVariable[v]));
        }
        return arrayList0;
    }
}

