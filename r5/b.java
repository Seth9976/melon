package R5;

import U4.x;
import Z5.a;
import android.content.Context;

public final class b extends c {
    public final Context a;
    public final a b;
    public final a c;
    public final String d;

    public b(Context context0, a a0, a a1, String s) {
        if(context0 == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.a = context0;
        if(a0 == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.b = a0;
        if(a1 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.c = a1;
        if(s == null) {
            throw new NullPointerException("Null backendName");
        }
        this.d = s;
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this ? true : object0 instanceof c && this.a.equals(((b)(((c)object0))).a) && this.b.equals(((b)(((c)object0))).b) && this.c.equals(((b)(((c)object0))).c) && this.d.equals(((b)(((c)object0))).d);
    }

    @Override
    public final int hashCode() {
        return (((this.a.hashCode() ^ 1000003) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode()) * 1000003 ^ this.d.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("CreationContext{applicationContext=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", wallClock=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", monotonicClock=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", backendName=");
        return x.m(stringBuilder0, this.d, "}");
    }
}

