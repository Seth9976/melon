package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Map;

public final class r {
    public final Map a;
    public static volatile r b;
    public static final r c;

    static {
        r.c = new r();
    }

    public r() {
        this.a = Collections.EMPTY_MAP;
    }

    public static r a() {
        r r0 = r.b;
        if(r0 == null) {
            synchronized(r.class) {
                r r1 = r.b;
                if(r1 == null) {
                    r r2 = null;
                    Class class1 = q.a;
                    if(class1 != null) {
                        try {
                            r2 = (r)class1.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        }
                        catch(Exception unused_ex) {
                        }
                    }
                    r1 = r2 == null ? r.c : r2;
                    r.b = r1;
                }
                return r1;
            }
        }
        return r0;
    }
}

