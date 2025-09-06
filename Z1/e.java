package Z1;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

public final class e implements Callable {
    public final int a;
    public final String b;
    public final Context c;
    public final int d;
    public final Object e;

    public e(String s, Context context0, Object object0, int v, int v1) {
        this.a = v1;
        this.b = s;
        this.c = context0;
        this.e = object0;
        this.d = v;
        super();
    }

    @Override
    public final Object call() {
        if(this.a != 0) {
            try {
                return h.b(this.b, this.c, ((List)this.e), this.d);
            }
            catch(Throwable unused_ex) {
                return new g(-3);
            }
        }
        ArrayList arrayList0 = new ArrayList(1);
        Object object0 = new Object[]{((d)this.e)}[0];
        Objects.requireNonNull(object0);
        arrayList0.add(object0);
        List list0 = Collections.unmodifiableList(arrayList0);
        return h.b(this.b, this.c, list0, this.d);
    }
}

