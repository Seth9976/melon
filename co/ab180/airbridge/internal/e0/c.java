package co.ab180.airbridge.internal.e0;

import co.ab180.airbridge.common.AirbridgeTrackingBlocklist;
import java.util.ArrayList;
import java.util.List;
import je.q;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\u001A\u001F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "Lco/ab180/airbridge/common/AirbridgeTrackingBlocklist;", "", "a", "(Ljava/util/List;)Ljava/util/List;", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class c {
    @NotNull
    public static final List a(@NotNull List list0) {
        List list1 = new ArrayList(q.Q(10, list0));
        for(Object object0: list0) {
            ((ArrayList)list1).add(((AirbridgeTrackingBlocklist)object0).getValue());
        }
        return list1;
    }
}

