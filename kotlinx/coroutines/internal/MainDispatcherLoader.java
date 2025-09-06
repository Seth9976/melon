package kotlinx.coroutines.internal;

import Q0.W0;
import Sf.a;
import Sf.n;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "<init>", "()V", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class MainDispatcherLoader {
    @NotNull
    public static final MainDispatcherLoader INSTANCE;
    @NotNull
    public static final MainCoroutineDispatcher dispatcher;

    static {
        MainDispatcherLoader mainDispatcherLoader0 = new MainDispatcherLoader();
        MainDispatcherLoader.INSTANCE = mainDispatcherLoader0;
        SystemPropsKt.systemProp("kotlinx.coroutines.fast.service.loader", true);
        MainDispatcherLoader.dispatcher = mainDispatcherLoader0.loadMainDispatcher();
    }

    private final MainCoroutineDispatcher loadMainDispatcher() {
        Object object0;
        try {
            Iterator iterator0 = ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator();
            q.g(iterator0, "<this>");
            List list0 = n.p0(new a(new W0(iterator0, 2)));
            Iterator iterator1 = list0.iterator();
            if(iterator1.hasNext()) {
                object0 = iterator1.next();
                if(iterator1.hasNext()) {
                    int v = ((MainDispatcherFactory)object0).getLoadPriority();
                    while(true) {
                        Object object1 = iterator1.next();
                        int v1 = ((MainDispatcherFactory)object1).getLoadPriority();
                        if(v < v1) {
                            object0 = object1;
                            v = v1;
                        }
                        if(!iterator1.hasNext()) {
                            break;
                        }
                    }
                }
            }
            else {
                object0 = null;
            }
            if(((MainDispatcherFactory)object0) != null) {
                MainCoroutineDispatcher mainCoroutineDispatcher0 = MainDispatchersKt.tryCreateDispatcher(((MainDispatcherFactory)object0), list0);
                if(mainCoroutineDispatcher0 != null) {
                    return mainCoroutineDispatcher0;
                }
            }
            MainDispatchersKt.createMissingDispatcher$default(null, null, 3, null);
            return null;
        }
        catch(Throwable throwable0) {
        }
        MainDispatchersKt.createMissingDispatcher$default(throwable0, null, 2, null);
        return null;
    }
}

