package kotlinx.coroutines.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001E\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\b\u0088\u0001\u0003\u0092\u0001\u0004\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/internal/InlineList;", "E", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "element", "plus-FjFbRPM", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "plus", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class InlineList {
    @NotNull
    public static Object constructor-impl(@Nullable Object object0) [...] // Inlined contents

    public static Object constructor-impl$default(Object object0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        return (v & 1) == 0 ? object0 : null;
    }

    @NotNull
    public static final Object plus-FjFbRPM(Object object0, Object object1) {
        if(object0 == null) {
            return object1;
        }
        if(object0 instanceof ArrayList) {
            ((ArrayList)object0).add(object1);
            return object0;
        }
        ArrayList arrayList0 = new ArrayList(4);
        arrayList0.add(object0);
        arrayList0.add(object1);
        return arrayList0;
    }
}

