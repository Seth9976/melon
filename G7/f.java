package g7;

import com.google.firebase.crashlytics.internal.persistence.FileStore;
import e1.F;

public final class f implements k {
    public final Object a;
    public Object b;
    public static final F c;

    static {
        f.c = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public f(FileStore fileStore0) {
        this.a = fileStore0;
        this.b = f.c;
    }

    public f(byte[] arr_b, int[] arr_v) {
        this.a = arr_b;
        this.b = arr_v;
    }

    @Override  // g7.k
    public void a(j j0, int v) {
        int[] arr_v = (int[])this.b;
        try(j0) {
            j0.read(((byte[])this.a), arr_v[0], v);
            arr_v[0] += v;
        }
    }
}

