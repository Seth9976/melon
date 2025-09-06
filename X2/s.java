package X2;

import android.text.TextUtils;
import java.util.Objects;

public class s {
    public final String a;
    public final int b;
    public final int c;

    public s(String s, int v, int v1) {
        this.a = s;
        this.b = v;
        this.c = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof s)) {
            return false;
        }
        return this.b < 0 || ((s)object0).b < 0 ? TextUtils.equals(this.a, ((s)object0).a) && this.c == ((s)object0).c : TextUtils.equals(this.a, ((s)object0).a) && this.b == ((s)object0).b && this.c == ((s)object0).c;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.c});
    }
}

