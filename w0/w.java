package w0;

import P0.I;
import java.util.Comparator;
import kotlin.jvm.internal.q;

public final class w implements Comparator {
    public static final w a;

    static {
        w.a = new w();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override
    public final int compare(Object object0, Object object1) {
        if(f.s(((u)object0)) && f.s(((u)object1))) {
            I i0 = P0.f.v(((u)object0));
            I i1 = P0.f.v(((u)object1));
            if(!q.b(i0, i1)) {
                I[] arr_i = new I[16];
                int v1 = 0;
                while(i0 != null) {
                    if(arr_i.length < v1 + 1) {
                        Object[] arr_object = new Object[Math.max(v1 + 1, arr_i.length * 2)];
                        System.arraycopy(arr_i, 0, arr_object, 0, arr_i.length);
                        arr_i = arr_object;
                    }
                    if(v1 != 0) {
                        System.arraycopy(arr_i, 0, arr_i, 1, v1);
                    }
                    arr_i[0] = i0;
                    ++v1;
                    i0 = i0.u();
                }
                I[] arr_i1 = new I[16];
                int v2 = 0;
                while(i1 != null) {
                    if(arr_i1.length < v2 + 1) {
                        Object[] arr_object1 = new Object[Math.max(v2 + 1, arr_i1.length * 2)];
                        System.arraycopy(arr_i1, 0, arr_object1, 0, arr_i1.length);
                        arr_i1 = arr_object1;
                    }
                    if(v2 != 0) {
                        System.arraycopy(arr_i1, 0, arr_i1, 1, v2);
                    }
                    arr_i1[0] = i1;
                    ++v2;
                    i1 = i1.u();
                }
                int v3 = Math.min(v1 - 1, v2 - 1);
                if(v3 >= 0) {
                    for(int v = 0; true; ++v) {
                        if(!q.b(arr_i[v], arr_i1[v])) {
                            return q.h(arr_i[v].v(), arr_i1[v].v());
                        }
                        if(v == v3) {
                            break;
                        }
                    }
                }
                throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.");
            }
            return 0;
        }
        if(f.s(((u)object0))) {
            return -1;
        }
        return f.s(((u)object1)) ? 1 : 0;
    }
}

