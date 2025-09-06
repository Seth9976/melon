package com.iloen.melon.net.v4x.common;

import H0.b;
import Tf.o;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedList;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/net/v4x/common/ToString;", "", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface ToString {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0001¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/net/v4x/common/ToString$Companion;", "", "<init>", "()V", "toStringFields", "", "obj", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        @NotNull
        public final String toStringFields(@NotNull Object object0) {
            String s1;
            q.g(object0, "obj");
            LinkedList linkedList0 = new LinkedList();
            Class class0 = object0.getClass();
            while(class0 != null) {
                Field[] arr_field = class0.getDeclaredFields();
                q.f(arr_field, "getDeclaredFields(...)");
                ArrayList arrayList0 = new ArrayList();
                for(int v = 0; v < arr_field.length; ++v) {
                    Field field0 = arr_field[v];
                    if(!Modifier.isStatic(field0.getModifiers())) {
                        arrayList0.add(field0);
                    }
                }
                for(Object object1: arrayList0) {
                    Field field1 = (Field)object1;
                    field1.setAccessible(true);
                    Object object2 = field1.get(object0);
                    if(object2 == null) {
                        s1 = null;
                    }
                    else {
                        String s = object2.toString();
                        if(s != null) {
                            s1 = o.e1(s).toString();
                        }
                    }
                    if(class0.getName().equals("Object")) {
                        linkedList0.add("\n[ " + class0.getClass().getSimpleName() + " ]");
                        break;
                    }
                    String s2 = field1.getName();
                    if(s1 == null || o.H0(s1)) {
                        s1 = "\"\"";
                    }
                    linkedList0.add(s2 + " = " + s1);
                }
                class0 = class0.getSuperclass();
                if(class0 != null) {
                    linkedList0.add("\n[ " + class0.getClass().getSimpleName() + " ]");
                }
            }
            return b.j(object0.getClass().getSimpleName(), "=[\n", p.q0(linkedList0, ", \n", null, null, null, 62), "]");
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        ToString.Companion = Companion.$$INSTANCE;
    }
}

