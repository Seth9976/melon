package co.ab180.airbridge.internal.e0;

import Tf.a;
import Tf.o;
import h7.u0;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u0012\n\u0002\u0010\u000E\n\u0002\b\u0004\u001A\u0013\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001A\u0017\u0010\u0002\u001A\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"", "", "a", "([B)Ljava/lang/String;", "(Ljava/lang/String;)Ljava/lang/String;", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class i {
    @Nullable
    public static final String a(@Nullable String s) {
        if(s != null) {
            byte[] arr_b = s.getBytes(a.a);
            return arr_b == null ? null : i.a(arr_b);
        }
        return null;
    }

    @NotNull
    public static final String a(@NotNull byte[] arr_b) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000E\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(B)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.e0.i.a extends r implements k {
            public static final co.ab180.airbridge.internal.e0.i.a a;

            static {
                co.ab180.airbridge.internal.e0.i.a.a = new co.ab180.airbridge.internal.e0.i.a();
            }

            public co.ab180.airbridge.internal.e0.i.a() {
                super(1);
            }

            @NotNull
            public final CharSequence a(byte b) {
                u0.l(16);
                return o.L0(2, Integer.toString(b & 0xFF, 16));
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.a(((Number)object0).byteValue());
            }
        }

        return n.q0(arr_b, "", co.ab180.airbridge.internal.e0.i.a.a, 30);
    }
}

