package androidx.room;

import G4.a;
import c2.Y;
import e1.x;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class c {
    public abstract void bind(G4.c arg1, Object arg2);

    public abstract String createQuery();

    public final int handle(@NotNull a a0, @Nullable Object object0) {
        q.g(a0, "connection");
        if(object0 == null) {
            return 0;
        }
        G4.c c0 = a0.l0(this.createQuery());
        try {
            this.bind(c0, object0);
            c0.j0();
        }
        catch(Throwable throwable0) {
            x.y(c0, throwable0);
            throw throwable0;
        }
        x.y(c0, null);
        return Q1.c.F(a0);
    }

    public final int handleMultiple(@NotNull a a0, @Nullable Iterable iterable0) {
        q.g(a0, "connection");
        int v = 0;
        if(iterable0 == null) {
            return 0;
        }
        G4.c c0 = a0.l0(this.createQuery());
        try {
            for(Object object0: iterable0) {
                if(object0 != null) {
                    this.bind(c0, object0);
                    c0.j0();
                    c0.reset();
                    v += Q1.c.F(a0);
                }
            }
        }
        catch(Throwable throwable0) {
            x.y(c0, throwable0);
            throw throwable0;
        }
        x.y(c0, null);
        return v;
    }

    public final int handleMultiple(@NotNull a a0, @Nullable Object[] arr_object) {
        q.g(a0, "connection");
        int v = 0;
        if(arr_object == null) {
            return 0;
        }
        G4.c c0 = a0.l0(this.createQuery());
        try {
            Y y0 = q.j(arr_object);
            while(y0.hasNext()) {
                Object object0 = y0.next();
                if(object0 != null) {
                    this.bind(c0, object0);
                    c0.j0();
                    c0.reset();
                    v += Q1.c.F(a0);
                }
            }
        }
        catch(Throwable throwable0) {
            x.y(c0, throwable0);
            throw throwable0;
        }
        x.y(c0, null);
        return v;
    }
}

