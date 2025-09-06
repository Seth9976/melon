package androidx.room;

import G4.a;
import G4.c;
import c2.Y;
import e.k;
import e1.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import je.p;
import je.w;
import ke.b;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class d {
    public abstract void bind(c arg1, Object arg2);

    public abstract String createQuery();

    public final void insert(@NotNull a a0, @Nullable Iterable iterable0) {
        q.g(a0, "connection");
        if(iterable0 == null) {
            return;
        }
        c c0 = a0.l0(this.createQuery());
        try {
            for(Object object0: iterable0) {
                if(object0 != null) {
                    this.bind(c0, object0);
                    c0.j0();
                    c0.reset();
                }
            }
        }
        catch(Throwable throwable0) {
            x.y(c0, throwable0);
            throw throwable0;
        }
        x.y(c0, null);
    }

    public final void insert(@NotNull a a0, @Nullable Object object0) {
        q.g(a0, "connection");
        if(object0 == null) {
            return;
        }
        c c0 = a0.l0(this.createQuery());
        try {
            this.bind(c0, object0);
            c0.j0();
        }
        catch(Throwable throwable0) {
            x.y(c0, throwable0);
            throw throwable0;
        }
        x.y(c0, null);
    }

    public final void insert(@NotNull a a0, @Nullable Object[] arr_object) {
        q.g(a0, "connection");
        if(arr_object == null) {
            return;
        }
        c c0 = a0.l0(this.createQuery());
        try {
            Y y0 = q.j(arr_object);
            while(y0.hasNext()) {
                Object object0 = y0.next();
                if(object0 != null) {
                    this.bind(c0, object0);
                    c0.j0();
                    c0.reset();
                }
            }
        }
        catch(Throwable throwable0) {
            x.y(c0, throwable0);
            throw throwable0;
        }
        x.y(c0, null);
    }

    public final long insertAndReturnId(@NotNull a a0, @Nullable Object object0) {
        q.g(a0, "connection");
        if(object0 == null) {
            return -1L;
        }
        c c0 = a0.l0(this.createQuery());
        try {
            this.bind(c0, object0);
            c0.j0();
        }
        catch(Throwable throwable0) {
            x.y(c0, throwable0);
            throw throwable0;
        }
        x.y(c0, null);
        return Q1.c.A(a0);
    }

    @NotNull
    public final long[] insertAndReturnIdsArray(@NotNull a a0, @Nullable Collection collection0) {
        long v2;
        long[] arr_v;
        q.g(a0, "connection");
        int v = 0;
        if(collection0 == null) {
            return new long[0];
        }
        c c0 = a0.l0(this.createQuery());
        try {
            int v1 = collection0.size();
            arr_v = new long[v1];
            while(true) {
                if(v >= v1) {
                    goto label_24;
                }
                Object object0 = p.h0(v, collection0);
                if(object0 == null) {
                    v2 = -1L;
                }
                else {
                    this.bind(c0, object0);
                    c0.j0();
                    c0.reset();
                    v2 = Q1.c.A(a0);
                }
                arr_v[v] = v2;
                ++v;
            }
        }
        catch(Throwable throwable0) {
        }
        try {
            throw throwable0;
        }
        catch(Throwable throwable1) {
            x.y(c0, throwable0);
            throw throwable1;
        }
    label_24:
        x.y(c0, null);
        return arr_v;
    }

    @NotNull
    public final long[] insertAndReturnIdsArray(@NotNull a a0, @Nullable Object[] arr_object) {
        long v1;
        long[] arr_v;
        q.g(a0, "connection");
        int v = 0;
        if(arr_object == null) {
            return new long[0];
        }
        c c0 = a0.l0(this.createQuery());
        try {
            arr_v = new long[arr_object.length];
            while(true) {
                if(v >= arr_object.length) {
                    goto label_23;
                }
                Object object0 = arr_object[v];
                if(object0 == null) {
                    v1 = -1L;
                }
                else {
                    this.bind(c0, object0);
                    c0.j0();
                    c0.reset();
                    v1 = Q1.c.A(a0);
                }
                arr_v[v] = v1;
                ++v;
            }
        }
        catch(Throwable throwable0) {
        }
        try {
            throw throwable0;
        }
        catch(Throwable throwable1) {
            x.y(c0, throwable0);
            throw throwable1;
        }
    label_23:
        x.y(c0, null);
        return arr_v;
    }

    @NotNull
    public final Long[] insertAndReturnIdsArrayBox(@NotNull a a0, @Nullable Collection collection0) {
        long v2;
        Long[] arr_long;
        q.g(a0, "connection");
        int v = 0;
        if(collection0 == null) {
            return new Long[0];
        }
        c c0 = a0.l0(this.createQuery());
        try {
            int v1 = collection0.size();
            arr_long = new Long[v1];
            while(true) {
                if(v >= v1) {
                    goto label_24;
                }
                Object object0 = p.h0(v, collection0);
                if(object0 == null) {
                    v2 = -1L;
                }
                else {
                    this.bind(c0, object0);
                    c0.j0();
                    c0.reset();
                    v2 = Q1.c.A(a0);
                }
                arr_long[v] = v2;
                ++v;
            }
        }
        catch(Throwable throwable0) {
        }
        try {
            throw throwable0;
        }
        catch(Throwable throwable1) {
            x.y(c0, throwable0);
            throw throwable1;
        }
    label_24:
        x.y(c0, null);
        return arr_long;
    }

    @NotNull
    public final Long[] insertAndReturnIdsArrayBox(@NotNull a a0, @Nullable Object[] arr_object) {
        long v1;
        Long[] arr_long;
        q.g(a0, "connection");
        int v = 0;
        if(arr_object == null) {
            return new Long[0];
        }
        c c0 = a0.l0(this.createQuery());
        try {
            arr_long = new Long[arr_object.length];
            while(true) {
                if(v >= arr_object.length) {
                    goto label_23;
                }
                Object object0 = arr_object[v];
                if(object0 == null) {
                    v1 = -1L;
                }
                else {
                    this.bind(c0, object0);
                    c0.j0();
                    c0.reset();
                    v1 = Q1.c.A(a0);
                }
                arr_long[v] = v1;
                ++v;
            }
        }
        catch(Throwable throwable0) {
        }
        try {
            throw throwable0;
        }
        catch(Throwable throwable1) {
            x.y(c0, throwable0);
            throw throwable1;
        }
    label_23:
        x.y(c0, null);
        return arr_long;
    }

    @NotNull
    public final List insertAndReturnIdsList(@NotNull a a0, @Nullable Collection collection0) {
        q.g(a0, "connection");
        if(collection0 == null) {
            return w.a;
        }
        b b0 = k.l();
        c c0 = a0.l0(this.createQuery());
        try {
            Iterator iterator0 = collection0.iterator();
            while(true) {
                if(!iterator0.hasNext()) {
                    goto label_21;
                }
                Object object0 = iterator0.next();
                if(object0 == null) {
                    b0.add(-1L);
                }
                else {
                    this.bind(c0, object0);
                    c0.j0();
                    c0.reset();
                    b0.add(Q1.c.A(a0));
                }
            }
        }
        catch(Throwable throwable0) {
        }
        try {
            throw throwable0;
        }
        catch(Throwable throwable1) {
            x.y(c0, throwable0);
            throw throwable1;
        }
    label_21:
        x.y(c0, null);
        return k.h(b0);
    }

    @NotNull
    public final List insertAndReturnIdsList(@NotNull a a0, @Nullable Object[] arr_object) {
        int v;
        q.g(a0, "connection");
        if(arr_object == null) {
            return w.a;
        }
        b b0 = k.l();
        c c0 = a0.l0(this.createQuery());
        try {
            v = 0;
            while(true) {
            label_6:
                if(v >= arr_object.length) {
                    goto label_23;
                }
                Object object0 = arr_object[v];
                if(object0 == null) {
                    b0.add(-1L);
                }
                else {
                    this.bind(c0, object0);
                    c0.j0();
                    c0.reset();
                    b0.add(Q1.c.A(a0));
                }
                ++v;
            }
        }
        catch(Throwable throwable0) {
        }
        try {
            throw throwable0;
        }
        catch(Throwable throwable1) {
            x.y(c0, throwable0);
            throw throwable1;
        }
        ++v;
        goto label_6;
    label_23:
        x.y(c0, null);
        return k.h(b0);
    }
}

