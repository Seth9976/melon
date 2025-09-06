package V0;

import android.content.res.Resources.Theme;
import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class b {
    public final Resources.Theme a;
    public final int b;

    public b(Resources.Theme resources$Theme0, int v) {
        this.a = resources$Theme0;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof b)) {
            return false;
        }
        return q.b(this.a, ((b)object0).a) ? this.b == ((b)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Key(theme=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", id=");
        return o.q(stringBuilder0, this.b, ')');
    }
}

