package je;

import java.util.RandomAccess;
import kotlin.jvm.internal.q;

public final class o extends f implements RandomAccess {
    public final int a;
    public final Object b;

    public o(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // je.a
    public final boolean contains(Object object0) {
        if(this.a != 0) {
            if(object0 instanceof Boolean) {
                boolean z = ((Boolean)object0).booleanValue();
                boolean[] arr_z = (boolean[])this.b;
                q.g(arr_z, "<this>");
                int v;
                for(v = 0; true; ++v) {
                    if(v >= arr_z.length) {
                        v = -1;
                        break;
                    }
                    if(z == arr_z[v]) {
                        break;
                    }
                }
                return v >= 0;
            }
            return false;
        }
        return object0 instanceof Integer ? n.P(((int[])this.b), ((Number)object0).intValue()) : false;
    }

    @Override
    public final Object get(int v) {
        return this.a != 0 ? Boolean.valueOf(((boolean[])this.b)[v]) : ((int)((int[])this.b)[v]);
    }

    @Override  // je.a
    public final int getSize() {
        return this.a == 0 ? ((int[])this.b).length : ((boolean[])this.b).length;
    }

    @Override  // je.f
    public final int indexOf(Object object0) {
        if(this.a != 0) {
            if(object0 instanceof Boolean) {
                boolean z = ((Boolean)object0).booleanValue();
                boolean[] arr_z = (boolean[])this.b;
                q.g(arr_z, "<this>");
                for(int v = 0; v < arr_z.length; ++v) {
                    if(z == arr_z[v]) {
                        return v;
                    }
                }
            }
            return -1;
        }
        if(object0 instanceof Integer) {
            int v1 = ((Number)object0).intValue();
            int[] arr_v = (int[])this.b;
            q.g(arr_v, "<this>");
            for(int v2 = 0; v2 < arr_v.length; ++v2) {
                if(v1 == arr_v[v2]) {
                    return v2;
                }
            }
        }
        return -1;
    }

    @Override  // je.a
    public final boolean isEmpty() {
        return this.a == 0 ? ((int[])this.b).length == 0 : ((boolean[])this.b).length == 0;
    }

    @Override  // je.f
    public final int lastIndexOf(Object object0) {
        if(this.a != 0) {
            if(object0 instanceof Boolean) {
                boolean z = ((Boolean)object0).booleanValue();
                boolean[] arr_z = (boolean[])this.b;
                q.g(arr_z, "<this>");
                int v = arr_z.length - 1;
                if(v >= 0) {
                    while(true) {
                        if(z == arr_z[v]) {
                            return v;
                        }
                        if(v - 1 < 0) {
                            break;
                        }
                        --v;
                    }
                }
            }
            return -1;
        }
        if(object0 instanceof Integer) {
            int v1 = ((Number)object0).intValue();
            int[] arr_v = (int[])this.b;
            q.g(arr_v, "<this>");
            int v2 = arr_v.length - 1;
            if(v2 >= 0) {
                while(true) {
                    if(v1 == arr_v[v2]) {
                        return v2;
                    }
                    if(v2 - 1 < 0) {
                        break;
                    }
                    --v2;
                }
            }
        }
        return -1;
    }
}

