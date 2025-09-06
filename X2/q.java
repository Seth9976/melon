package X2;

import android.os.Build.VERSION;
import android.text.TextUtils;

public final class q {
    public s a;

    public q(String s, int v, int v1) {
        if(s == null) {
            throw new NullPointerException("package shouldn\'t be null");
        }
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        if(Build.VERSION.SDK_INT >= 28) {
            r r0 = new r(s, v, v1);  // 初始化器: LX2/s;-><init>(Ljava/lang/String;II)V
            B0.q.n(v, v1, s);
            this.a = r0;
            return;
        }
        this.a = new s(s, v, v1);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof q ? this.a.equals(((q)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
}

