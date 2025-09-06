package kotlinx.serialization.json.internal;

import je.m;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\u0006H\u0004¢\u0006\u0004\b\u000B\u0010\fR\u001A\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00060\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u0016\u0010\u0010\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlinx/serialization/json/internal/CharArrayPoolBase;", "", "<init>", "()V", "", "size", "", "take", "(I)[C", "array", "Lie/H;", "releaseImpl", "([C)V", "Lje/m;", "arrays", "Lje/m;", "charsTotal", "I", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class CharArrayPoolBase {
    @NotNull
    private final m arrays;
    private int charsTotal;

    public CharArrayPoolBase() {
        this.arrays = new m();
    }

    public final void releaseImpl(@NotNull char[] arr_c) {
        q.g(arr_c, "array");
        synchronized(this) {
            if(this.charsTotal + arr_c.length < 0x200000) {
                this.charsTotal += arr_c.length;
                this.arrays.addLast(arr_c);
            }
        }
    }

    @NotNull
    public final char[] take(int v) {
        char[] arr_c;
        synchronized(this) {
            arr_c = null;
            Object object0 = this.arrays.isEmpty() ? null : this.arrays.removeLast();
            if(((char[])object0) != null) {
                this.charsTotal -= ((char[])object0).length;
                arr_c = (char[])object0;
            }
        }
        return arr_c == null ? new char[v] : arr_c;
    }
}

