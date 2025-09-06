package i.n.i.b.a.s.e;

import android.net.Uri;
import com.google.android.exoplayer2.ext.flac.FlacExtractor;
import com.google.android.exoplayer2.ext.flac.FlacLibrary;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class k3 implements Y6 {
    public int a;
    public static final int[] b;
    public static final Constructor c;

    static {
        Constructor constructor0;
        try {
            k3.b = new int[]{5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 14};
            constructor0 = null;
            Boolean boolean0 = Boolean.valueOf(FlacLibrary.isAvailable());
            if(Boolean.TRUE.equals(boolean0)) {
                try {
                    constructor0 = FlacExtractor.class.asSubclass(q4.class).getConstructor(Integer.TYPE);
                }
                catch(ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException unused_ex) {
                }
            }
            k3.c = constructor0;
            return;
        }
        catch(ClassCastException unused_ex) {
            k3.c = constructor0;
            return;
        }
        catch(Exception exception0) {
        }
        throw new RuntimeException("Error instantiating FLAC extension", exception0);
    }

    @Override  // i.n.i.b.a.s.e.Y6
    public final q4[] a() {
        synchronized(this) {
            return this.a(Uri.EMPTY, new HashMap());
        }
    }

    @Override  // i.n.i.b.a.s.e.Y6
    public final q4[] a(Uri uri0, Map map0) {
        synchronized(this) {
            ArrayList arrayList0 = new ArrayList(14);
            List list0 = (List)map0.get("Content-Type");
            int v2 = Ja.e((list0 == null || list0.isEmpty() ? null : ((String)list0.get(0))));
            if(v2 != -1) {
                this.b(v2, arrayList0);
            }
            int v3 = Ja.d(uri0);
            if(v3 != -1 && v3 != v2) {
                this.b(v3, arrayList0);
            }
            int[] arr_v = k3.b;
            for(int v1 = 0; v1 < 14; ++v1) {
                int v4 = arr_v[v1];
                if(v4 != v2 && v4 != v3) {
                    this.b(v4, arrayList0);
                }
            }
            return (q4[])arrayList0.toArray(new q4[arrayList0.size()]);
        }
    }

    public final void b(int v, ArrayList arrayList0) {
        switch(v) {
            case 0: {
                arrayList0.add(new q());
                return;
            }
            case 1: {
                arrayList0.add(new q0());
                return;
            }
            case 2: {
                arrayList0.add(new c2(0));
                return;
            }
            case 3: {
                arrayList0.add(new n0());
                return;
            }
            case 4: {
                Constructor constructor0 = k3.c;
                if(constructor0 != null) {
                    try {
                        arrayList0.add(((q4)constructor0.newInstance(0)));
                        return;
                    }
                    catch(Exception exception0) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", exception0);
                    }
                }
                arrayList0.add(new a2());
                return;
            }
            case 5: {
                arrayList0.add(new l3());
                return;
            }
            case 6: {
                arrayList0.add(new Z9(0));
                return;
            }
            case 7: {
                arrayList0.add(new Od(0));
                return;
            }
            case 8: {
                arrayList0.add(new q3(this.a));
                arrayList0.add(new s4(0));
                return;
            }
            case 9: {
                arrayList0.add(new ha());  // 初始化器: Ljava/lang/Object;-><init>()V
                return;
            }
            case 10: {
                arrayList0.add(new Lc());
                return;
            }
            case 11: {
                arrayList0.add(new r0(1));
                return;
            }
            case 12: {
                arrayList0.add(new t3());
                return;
            }
            case 14: {
                arrayList0.add(new j5());
            }
        }
    }
}

