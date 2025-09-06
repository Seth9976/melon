package co.ab180.airbridge.internal.signature;

import Tf.a;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010\u000E\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\u001A\u001B\u0010\u0003\u001A\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u0013\u0010\u0006\u001A\u00020\u0005*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u001B\u0010\u0003\u001A\u00020\u0005*\u00020\b2\u0006\u0010\u0002\u001A\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\t\u001A\u0017\u0010\u0003\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\f¨\u0006\r"}, d2 = {"", "", "capacity", "a", "(Ljava/lang/String;I)Ljava/lang/String;", "", "b", "(Ljava/lang/String;)[B", "", "(JI)[B", "s", "", "(Ljava/lang/String;)Z", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class d {
    @NotNull
    public static final String a(@NotNull String s, int v) {
        while(s.length() < v) {
            s = "0" + s;
        }
        return s;
    }

    public static final boolean a(@NotNull String s) {
        if(s.length() == 0x40) {
            for(int v = 0; v < s.length(); ++v) {
                if(!Character.isLetterOrDigit(s.charAt(v))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @NotNull
    public static final byte[] a(long v, int v1) {
        return ByteBuffer.allocate(v1).putLong(0, v).array();
    }

    @NotNull
    public static final byte[] b(@NotNull String s) {
        return s.getBytes(a.a);
    }
}

