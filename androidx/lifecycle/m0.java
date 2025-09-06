package androidx.lifecycle;

import T2.d;
import java.io.Closeable;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class m0 {
    @Nullable
    private final d impl;

    public m0() {
        this.impl = new d();
    }

    @ie.d
    public void addCloseable(Closeable closeable0) {
        q.g(closeable0, "closeable");
        d d0 = this.impl;
        if(d0 != null) {
            d0.a(closeable0);
        }
    }

    public void addCloseable(@NotNull AutoCloseable autoCloseable0) {
        q.g(autoCloseable0, "closeable");
        d d0 = this.impl;
        if(d0 != null) {
            d0.a(autoCloseable0);
        }
    }

    public final void addCloseable(@NotNull String s, @NotNull AutoCloseable autoCloseable0) {
        AutoCloseable autoCloseable1;
        q.g(s, "key");
        q.g(autoCloseable0, "closeable");
        d d0 = this.impl;
        if(d0 != null) {
            if(d0.d) {
                d.b(autoCloseable0);
                return;
            }
            synchronized(d0.a) {
                autoCloseable1 = (AutoCloseable)d0.b.put(s, autoCloseable0);
            }
            d.b(autoCloseable1);
        }
    }

    public final void clear$lifecycle_viewmodel_release() {
        d d0 = this.impl;
        if(d0 != null && !d0.d) {
            d0.d = true;
            synchronized(d0.a) {
                for(Object object0: d0.b.values()) {
                    d.b(((AutoCloseable)object0));
                }
                for(Object object1: d0.c) {
                    d.b(((AutoCloseable)object1));
                }
                d0.c.clear();
            }
        }
        this.onCleared();
    }

    @Nullable
    public final AutoCloseable getCloseable(@NotNull String s) {
        q.g(s, "key");
        d d0 = this.impl;
        if(d0 != null) {
            synchronized(d0.a) {
                return (AutoCloseable)d0.b.get(s);
            }
        }
        return null;
    }

    public void onCleared() {
    }
}

