package co.ab180.airbridge.internal.u;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001E\u0010\t\u001A\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u0001H\u0084\b¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0006\u001A\u00020\u00052\u0012\u0010\f\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000B\"\u00020\u0001H\u0004¢\u0006\u0004\b\u0006\u0010\rJ\u000F\u0010\u0006\u001A\u00020\u0005H\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u000E\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u000E\u0010\u0003J\u000F\u0010\u000F\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u000F\u0010\u0003R0\u0010\u0014\u001A\u001E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010j\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001`\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013¨\u0006\u0015"}, d2 = {"Lco/ab180/airbridge/internal/u/a;", "", "<init>", "()V", "module", "Lie/H;", "a", "(Ljava/lang/Object;)V", "T", "d", "()Ljava/lang/Object;", "", "modules", "([Ljava/lang/Object;)V", "c", "b", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "apiMap", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public class a {
    private final HashMap a;

    public a() {
        this.a = new HashMap();
    }

    private final void a(Object object0) {
        String s = object0.getClass().getSimpleName();
        if(this.a.containsKey(s)) {
            throw new IllegalArgumentException();
        }
        String s1 = object0.getClass().getSimpleName();
        this.a.put(s1, object0);
        Class[] arr_class = object0.getClass().getInterfaces();
        for(int v = 0; v < arr_class.length; ++v) {
            Class class0 = arr_class[v];
            if(this.a.containsKey(class0.getSimpleName())) {
                throw new IllegalArgumentException();
            }
            this.a.put(class0.getSimpleName(), object0);
        }
    }

    public final void a() {
        this.a.clear();
    }

    public final void a(@NotNull Object[] arr_object) {
        this.a();
        for(int v = 0; v < arr_object.length; ++v) {
            this.a(arr_object[v]);
        }
    }

    public void b() {
    }

    public void c() {
    }

    public final Object d() {
        q.k();
        throw null;
    }
}

