package E9;

import com.iloen.melon.utils.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;

public final class p {
    public final HashMap a;
    public static final ArrayList b;

    static {
        p.b = new ArrayList();
    }

    public p() {
        this.a = new HashMap();
    }

    public static void a() {
        ArrayList arrayList0 = p.b;
        if(arrayList0.size() == 0) {
            Field[] arr_field = p.class.getDeclaredFields();
            for(int v = 0; v < arr_field.length; ++v) {
                Field field0 = arr_field[v];
                if(field0.isAnnotationPresent(o.class) && Modifier.isStatic(field0.getModifiers()) && field0.getType() == String.class) {
                    arrayList0.add(((String)field0.get("")));
                }
            }
        }
    }

    public static void b(int v, Object object0, String s) {
        if(object0 == null) {
            throw new IllegalStateException("value for key " + s + " is null");
        }
        switch(v) {
            case 0: {
                return;
            }
            case 1: {
                if(object0 instanceof Boolean) {
                    return;
                }
                break;
            }
            case 2: {
                if(object0 instanceof Byte) {
                    return;
                }
                break;
            }
            case 3: {
                if(object0 instanceof Character) {
                    return;
                }
                break;
            }
            case 4: {
                if(object0 instanceof Short) {
                    return;
                }
                break;
            }
            case 5: {
                if(object0 instanceof Integer) {
                    return;
                }
                break;
            }
            case 6: {
                if(object0 instanceof Long) {
                    return;
                }
                break;
            }
            case 7: {
                if(object0 instanceof Double) {
                    return;
                }
                break;
            }
            case 8: {
                if(object0 instanceof String) {
                    return;
                }
                break;
            }
            case 9: {
                if(object0 instanceof byte[]) {
                    return;
                }
                break;
            }
            default: {
                StringBuilder stringBuilder0 = a.n("invalid type for ", s, " ");
                stringBuilder0.append(object0.getClass());
                throw new IllegalArgumentException(stringBuilder0.toString());
            }
        }
        throw new IllegalStateException("value for key " + s + " is not match");
    }

    public final boolean c(String s) {
        Object object0 = this.a.get(s);
        p.b(1, object0, s);
        return ((Boolean)object0).booleanValue();
    }

    public final int d(String s) {
        Object object0 = this.a.get(s);
        p.b(5, object0, s);
        return (int)(((Integer)object0));
    }

    public final String e(String s) {
        Object object0 = this.a.get(s);
        p.b(8, object0, s);
        return (String)object0;
    }

    public final void f(String s, String s1) {
        this.a.put(s, s1);
    }
}

