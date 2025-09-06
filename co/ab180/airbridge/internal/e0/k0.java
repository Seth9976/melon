package co.ab180.airbridge.internal.e0;

import android.content.Context;
import co.ab180.airbridge.AirbridgeOption;
import co.ab180.airbridge.R.array;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import je.p;
import je.q;
import je.u;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0003\u001A#\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/content/Context;", "context", "Lco/ab180/airbridge/AirbridgeOption;", "option", "", "", "a", "(Landroid/content/Context;Lco/ab180/airbridge/AirbridgeOption;)Ljava/util/List;", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class k0 {
    @NotNull
    public static final List a(@NotNull Context context0, @NotNull AirbridgeOption airbridgeOption0) {
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        linkedHashSet0.addAll(airbridgeOption0.getCustomDomains());
        u.V(linkedHashSet0, context0.getResources().getStringArray(array.co_ab180_airbridge_custom_domains));
        List list0 = p.P0(linkedHashSet0);
        List list1 = new ArrayList(q.Q(10, list0));
        for(Object object0: list0) {
            if(((String)object0) == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            ((ArrayList)list1).add(((String)object0).toLowerCase());
        }
        return list1;
    }
}

