package co.ab180.airbridge.internal.network.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0080\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000BB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lco/ab180/airbridge/internal/network/model/c;", "", "", "id", "<init>", "(Ljava/lang/String;II)V", "o", "I", "b", "()I", "n", "a", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public enum c {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001C\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001C\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"co/ab180/airbridge/internal/network/model/c$a", "", "", "id", "Lco/ab180/airbridge/internal/network/model/c;", "a", "(I)Lco/ab180/airbridge/internal/network/model/c;", "", "values", "[Lco/ab180/airbridge/internal/network/model/EventType;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {
        private a() {
        }

        public a(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final c a(int v) {
            c[] arr_c = c.m;
            for(int v1 = 0; v1 < arr_c.length; ++v1) {
                c c0 = arr_c[v1];
                if(c0.b() == v) {
                    return c0;
                }
            }
            return c.k;
        }
    }

    ORGANIC_INSTALL(9161),
    ORGANIC_OPEN(9160),
    ORGANIC_REOPEN(0x23CF),
    FOREGROUND(9165),
    FOREGROUND_WITH_SESSION_EXPIRED(9166),
    DEEPLINK_INSTALL(9163),
    DEEPLINK_OPEN(9162),
    DEEPLINK_REOPEN(0x23D0),
    INTERNAL_PLACEMENT_DEEPLINK_MOVE(9164),
    REGISTER_PUSH_TOKEN(8603),
    UNDEFINED(9360);

    private static final c[] m;
    @NotNull
    public static final a n;
    private final int o;

    static {
        c.n = new a(null);
        c.m = (c[])c.l.clone();
    }

    private c(int v1) {
        this.o = v1;
    }

    public final int b() {
        return this.o;
    }
}

