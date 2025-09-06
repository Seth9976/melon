package co.ab180.airbridge.internal.z;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\b\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u001B\u0010\n\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\n\u0010\tJ\u001B\u0010\u000B\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u000B\u0010\tJ%\u0010\n\u001A\u00028\u0000\"\b\b\u0000\u0010\r*\u00020\f2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E¢\u0006\u0004\b\n\u0010\u0010J+\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\r*\u00020\f2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E¢\u0006\u0004\b\b\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0003R$\u0010\u0016\u001A\u0012\u0012\u0004\u0012\u00020\u00050\u0013j\b\u0012\u0004\u0012\u00020\u0005`\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0015¨\u0006\u0017"}, d2 = {"Lco/ab180/airbridge/internal/z/l;", "Ljava/io/Closeable;", "<init>", "()V", "", "Lco/ab180/airbridge/internal/z/j;", "modules", "Lie/H;", "b", "(Ljava/util/List;)V", "a", "c", "", "T", "Ljava/lang/Class;", "clazz", "(Ljava/lang/Class;)Ljava/lang/Object;", "(Ljava/lang/Class;)Ljava/util/List;", "close", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "scope", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class l implements Closeable {
    private final ArrayList a;

    public l() {
        this.a = new ArrayList();
    }

    @NotNull
    public final Object a(@NotNull Class class0) {
        Object object2;
        String s = class0.getName();
        for(Object object0: this.a) {
            Iterator iterator1 = ((j)object0).m().iterator();
        label_5:
            if(!iterator1.hasNext()) {
                continue;
            }
            Object object1 = iterator1.next();
            c c0 = (c)object1;
            if(!c0.a(s)) {
                goto label_5;
            }
            object2 = c0.h();
            if(object2 == null) {
                object2 = null;
            }
            goto label_14;
        }
        object2 = null;
    label_14:
        if(object2 == null) {
            throw new m("Definition not found : " + class0.getName());
        }
        return object2;
    }

    public final void a(@NotNull List list0) {
        this.a.addAll(list0);
    }

    @NotNull
    public final List b(@NotNull Class class0) {
        List list0 = new ArrayList();
        String s = class0.getName();
        for(Object object0: this.a) {
            for(Object object1: ((j)object0).m()) {
                c c0 = (c)object1;
                if(c0.a(s)) {
                    Object object2 = c0.h();
                    if(object2 == null) {
                        object2 = null;
                    }
                    if(object2 != null) {
                        ((ArrayList)list0).add(object2);
                    }
                }
            }
        }
        return list0;
    }

    public final void b(@NotNull List list0) {
        this.a.clear();
        this.a.addAll(list0);
    }

    public final void c(@NotNull List list0) {
        for(Object object0: list0) {
            this.a.remove(((j)object0));
            ((j)object0).close();
        }
    }

    @Override
    public void close() {
        for(Object object0: this.a) {
            ((j)object0).close();
        }
        this.a.clear();
    }
}

