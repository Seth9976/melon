package androidx.media3.session;

import U4.x;
import android.os.Bundle;
import androidx.media3.session.legacy.b0;
import java.util.Arrays;
import java.util.Objects;

public final class w0 {
    public final b0 a;
    public final int b;
    public final int c;
    public final v0 d;
    public final Bundle e;

    public w0(b0 b00, int v, int v1, boolean z, v0 v00, Bundle bundle0) {
        this.a = b00;
        this.b = v;
        this.c = v1;
        this.d = v00;
        this.e = bundle0;
    }

    public final String a() {
        return this.a.a.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(!(object0 instanceof w0)) {
            return false;
        }
        if(this == object0) {
            return true;
        }
        return this.d != null || ((w0)object0).d != null ? Objects.equals(this.d, ((w0)object0).d) : this.a.equals(((w0)object0).a);
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.d, this.a});
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ControllerInfo {pkg=");
        stringBuilder0.append(this.a.a.a);
        stringBuilder0.append(", uid=");
        return x.g(this.a.a.c, "}", stringBuilder0);
    }
}

