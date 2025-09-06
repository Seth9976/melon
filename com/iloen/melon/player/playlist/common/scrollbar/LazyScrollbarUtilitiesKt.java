package com.iloen.melon.player.playlist.common.scrollbar;

import I.X0;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u001A¡\u0001\u0010\r\u001A\u00020\f\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002*\u00028\u00002\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00010\u00032\u001A\b\u0004\u0010\u0007\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u00052\u001A\b\u0004\u0010\b\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u00052\u001C\b\u0004\u0010\t\u001A\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00052\u0014\b\u0004\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\nH\u0080\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000E\u001A/\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u0006H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"LI/X0;", "LazyState", "LazyStateItem", "", "visibleItems", "Lkotlin/Function2;", "", "itemSize", "offset", "nextItemOnMainAxis", "Lkotlin/Function1;", "itemIndex", "", "interpolateFirstItemIndex", "(LI/X0;Ljava/util/List;Lwe/n;Lwe/n;Lwe/n;Lwe/k;)F", "itemStartOffset", "viewportStartOffset", "viewportEndOffset", "itemVisibilityPercentage", "(IIII)F", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class LazyScrollbarUtilitiesKt {
    public static final float interpolateFirstItemIndex(@NotNull X0 x00, @NotNull List list0, @NotNull n n0, @NotNull n n1, @NotNull n n2, @NotNull k k0) {
        q.g(x00, "<this>");
        q.g(list0, "visibleItems");
        q.g(n0, "itemSize");
        q.g(n1, "offset");
        q.g(n2, "nextItemOnMainAxis");
        q.g(k0, "itemIndex");
        if(list0.isEmpty()) {
            return 0.0f;
        }
        Object object0 = p.k0(list0);
        int v = ((Number)k0.invoke(object0)).intValue();
        if(v < 0) {
            return NaNf;
        }
        int v1 = ((Number)n0.invoke(x00, object0)).intValue();
        if(v1 == 0) {
            return NaNf;
        }
        float f = Math.abs(((Number)n1.invoke(x00, object0)).intValue()) / ((float)v1);
        Object object1 = n2.invoke(x00, object0);
        return object1 == null ? ((float)v) + f : ((float)(((Number)k0.invoke(object1)).intValue() - v)) * f + ((float)v);
    }

    public static final float itemVisibilityPercentage(int v, int v1, int v2, int v3) {
        if(v == 0) {
            return 0.0f;
        }
        int v4 = v1 + v;
        int v5 = 0;
        int v6 = v1 <= v2 ? Math.abs(Math.abs(v2) - Math.abs(v1)) : 0;
        if(v4 >= v3) {
            v5 = Math.abs(Math.abs(v4) - Math.abs(v3));
        }
        return (((float)v) - ((float)v6) - ((float)v5)) / ((float)v);
    }
}

