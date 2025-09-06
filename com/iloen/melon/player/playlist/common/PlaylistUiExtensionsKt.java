package com.iloen.melon.player.playlist.common;

import O.F;
import O.v;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001A-\u0010\u0006\u001A\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u001B\u0010\u000B\u001A\u0004\u0018\u00010\u0002*\u00020\b2\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"T", "", "", "fromIdx", "toIdx", "Lie/H;", "move", "(Ljava/util/List;II)V", "LO/F;", "", "key", "getPositionFromKey", "(LO/F;Ljava/lang/Object;)Ljava/lang/Integer;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistUiExtensionsKt {
    @Nullable
    public static final Integer getPositionFromKey(@NotNull F f0, @NotNull Object object0) {
        q.g(f0, "<this>");
        q.g(object0, "key");
        for(Object object1: ((Iterable)f0.h().k)) {
            if(((v)object1).j.equals(object0)) {
                return ((v)object1) == null ? null : ((v)object1).a;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public static final void move(@NotNull List list0, int v, int v1) {
        q.g(list0, "<this>");
        if(v != v1) {
            if(v1 > v) {
                while(v < v1) {
                    Object object0 = list0.get(v + 1);
                    list0.set(v + 1, list0.get(v));
                    list0.set(v, object0);
                    ++v;
                }
                return;
            }
            if(v1 + 1 <= v) {
                while(true) {
                    Object object1 = list0.get(v - 1);
                    list0.set(v - 1, list0.get(v));
                    list0.set(v, object1);
                    if(v == v1 + 1) {
                        break;
                    }
                    --v;
                }
            }
        }
    }
}

