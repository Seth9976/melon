package co.ab180.airbridge.internal.parser;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import je.n;
import je.p;
import je.q;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\n\u001A\u00020\t*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u001B\u0010\r\u001A\u0004\u0018\u00010\u00012\b\u0010\f\u001A\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000EJ%\u0010\u0010\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000F2\u0006\u0010\b\u001A\u00020\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\'\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00122\u000E\u0010\u0013\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0002¢\u0006\u0004\b\n\u0010\u0014J-\u0010\n\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000F2\u000E\u0010\u0013\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000FH\u0002¢\u0006\u0004\b\n\u0010\u0015J\u0017\u0010\u0017\u001A\u00020\u00162\u0006\u0010\f\u001A\u00020\u0001H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001A\u00020\u00162\u0006\u0010\f\u001A\u00020\u0001H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\n\u001A\u00020\u00162\u0006\u0010\f\u001A\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\u0018J\u0017\u0010\n\u001A\u00020\u00162\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u001AJ#\u0010\u001B\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000F2\u0006\u0010\b\u001A\u00020\u0001¢\u0006\u0004\b\u001B\u0010\u0011¨\u0006\u001C"}, d2 = {"Lco/ab180/airbridge/internal/parser/b;", "", "<init>", "()V", "", "", "Ljava/lang/reflect/Field;", "field", "obj", "Lie/H;", "a", "(Ljava/util/Map;Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "value", "e", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "d", "(Ljava/lang/Object;)Ljava/util/Map;", "", "data", "(Ljava/util/List;)Ljava/util/List;", "(Ljava/util/Map;)Ljava/util/Map;", "", "b", "(Ljava/lang/Object;)Z", "c", "(Ljava/lang/reflect/Field;)Z", "f", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class b {
    @NotNull
    public static final b a;

    static {
        b.a = new b();
    }

    private final List a(List list0) {
        List list1 = new ArrayList(q.Q(10, list0));
        for(Object object0: list0) {
            ((ArrayList)list1).add(b.a.e(object0));
        }
        return list1;
    }

    private final Map a(Map map0) {
        Map map1 = new LinkedHashMap();
        for(Object object0: map0.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            Object object1 = map$Entry0.getKey();
            if(!(object1 == null ? false : b.a.c(object1))) {
                map$Entry0 = null;
            }
            if(map$Entry0 != null) {
                String s = String.valueOf(map$Entry0.getKey());
                Object object2 = map$Entry0.getValue();
                map1.put(s, b.a.e(object2));
            }
        }
        return map1;
    }

    private final void a(Map map0, Field field0, Object object0) {
        Object object1;
        String s;
        if(!this.a(field0)) {
            try {
                s = null;
                d d0 = (d)field0.getAnnotation(d.class);
                if(d0 != null) {
                    s = d0.value();
                }
            }
            catch(Throwable unused_ex) {
                co.ab180.airbridge.internal.b.e.b("Could not find @SerializedName annotation", new Object[0]);
            }
            if(s == null) {
                s = field0.getName();
            }
            if(s != null) {
                try {
                    object1 = field0.get(object0);
                }
                catch(IllegalAccessException unused_ex) {
                    field0.setAccessible(true);
                    Object object2 = field0.get(object0);
                    field0.setAccessible(false);
                    object1 = object2;
                }
                catch(Throwable unused_ex) {
                    return;
                }
                map0.put(s, this.e(object1));
            }
        }
    }

    // 去混淆评级： 低(40)
    private final boolean a(Object object0) {
        return object0 instanceof Object[] || object0 instanceof Set || object0 instanceof List || object0 instanceof Map;
    }

    private final boolean a(Field field0) {
        return Modifier.isStatic(field0.getModifiers());
    }

    // 去混淆评级： 中等(80)
    private final boolean b(Object object0) {
        return object0 instanceof Number || object0 instanceof Byte || object0 instanceof Short || object0 instanceof Integer || object0 instanceof Long || object0 instanceof Float || object0 instanceof Double || object0 instanceof Boolean;
    }

    // 去混淆评级： 低(20)
    private final boolean c(Object object0) {
        return object0 instanceof Character || object0 instanceof CharSequence;
    }

    private final Map d(Object object0) {
        Map map0 = new LinkedHashMap();
        try {
            Field[] arr_field = object0.getClass().getDeclaredFields();
            for(int v = 0; v < arr_field.length; ++v) {
                b.a.a(map0, arr_field[v], object0);
            }
        }
        catch(Throwable unused_ex) {
        }
        return map0;
    }

    private final Object e(Object object0) {
        if(object0 == null) {
            return null;
        }
        if(!this.b(object0)) {
            if(this.c(object0)) {
                return object0.toString();
            }
            Class class0 = object0.getClass();
            if(!class0.isPrimitive()) {
                if(class0.isEnum()) {
                    return object0.toString();
                }
                if(object0 instanceof Object[]) {
                    return this.a(n.z0(((Object[])object0)));
                }
                if(object0 instanceof Set) {
                    return this.a(p.P0(((Iterable)object0)));
                }
                if(object0 instanceof List) {
                    return this.a(((List)object0));
                }
                return object0 instanceof Map ? this.a(((Map)object0)) : this.d(object0);
            }
        }
        return object0;
    }

    @NotNull
    public final Map f(@NotNull Object object0) {
        if(object0 instanceof Map) {
            return this.a(((Map)object0));
        }
        if(this.b(object0) || this.c(object0) || this.a(object0)) {
            throw new IllegalAccessException();
        }
        Class class0 = object0.getClass();
        if(class0.isPrimitive() || class0.isEnum()) {
            throw new IllegalAccessException();
        }
        return this.d(object0);
    }
}

