package co.ab180.airbridge.internal.network.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000E\n\u0002\b\t\b\u0080\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lco/ab180/airbridge/internal/network/model/d;", "", "", "text", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "j", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "i", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public enum d {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"co/ab180/airbridge/internal/network/model/d$a", "", "", "priority", "Lco/ab180/airbridge/internal/network/model/d;", "a", "(I)Lco/ab180/airbridge/internal/network/model/d;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {
        private a() {
        }

        public a(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final d a(int v) {
            switch(v) {
                case 2: {
                    return d.a;
                }
                case 3: {
                    return d.b;
                }
                case 4: {
                    return d.c;
                }
                case 5: {
                    return d.d;
                }
                case 6: {
                    return d.e;
                }
                case 7: {
                    return d.f;
                }
                default: {
                    return d.g;
                }
            }
        }
    }

    VERBOSE("verbose"),
    DEBUG("debug"),
    INFO("info"),
    WARN("warn"),
    ERROR("error"),
    ASSERT("assert"),
    UNKNOWN("unknown");

    @NotNull
    public static final a i;
    @NotNull
    private final String j;

    static {
        d.i = new a(null);
    }

    private d(String s1) {
        this.j = s1;
    }

    @NotNull
    public final String a() {
        return this.j;
    }
}

