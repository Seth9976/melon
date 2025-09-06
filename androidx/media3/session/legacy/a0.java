package androidx.media3.session.legacy;

import android.text.TextUtils;
import java.util.Objects;

public class a0 {
    public final String a;
    public final int b;
    public final int c;

    public a0(String s, int v, int v1) {
        this.a = s;
        this.b = v;
        this.c = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a0)) {
            return false;
        }
        return this.b < 0 || ((a0)object0).b < 0 ? TextUtils.equals(this.a, ((a0)object0).a) && this.c == ((a0)object0).c : TextUtils.equals(this.a, ((a0)object0).a) && this.b == ((a0)object0).b && this.c == ((a0)object0).c;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.c});
    }
}

