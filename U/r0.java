package U;

import android.os.Build.VERSION;
import kotlin.jvm.internal.q;
import pe.b;

public enum r0 {
    Cut(0x1040003),
    Copy(0x1040001),
    Paste(0x104000B),
    SelectAll(0x104000D),
    Autofill((Build.VERSION.SDK_INT > 26 ? 0x104001A : 0x7F13017A));  // string:autofill "Autofill"

    public final int a;
    public static final r0[] g;

    static {
        r0.g = arr_r0;
        q.g(arr_r0, "entries");
        new b(arr_r0);
    }

    public r0(int v1) {
        this.a = v1;
    }
}

