package com.melon.ui;

import A7.d;
import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class c3 implements V0 {
    public final String a;
    public final int b;
    public final boolean c;
    public final Throwable d;

    public c3(int v, String s, Throwable throwable0, boolean z) {
        q.g(s, "message");
        super();
        this.a = s;
        this.b = v;
        this.c = z;
        this.d = throwable0;
    }

    public c3(String s, int v, boolean z, Exception exception0, int v1) {
        if((v1 & 1) != 0) {
            s = "";
        }
        if((v1 & 2) != 0) {
            v = 0x7F080430;  // drawable:ic_error_wifi
        }
        if((v1 & 4) != 0) {
            z = false;
        }
        if((v1 & 8) != 0) {
            exception0 = null;
        }
        this(v, s, exception0, z);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c3)) {
            return false;
        }
        if(!q.b(this.a, ((c3)object0).a)) {
            return false;
        }
        if(this.b != ((c3)object0).b) {
            return false;
        }
        return this.c == ((c3)object0).c ? q.b(this.d, ((c3)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        int v = d.e(d.b(this.b, this.a.hashCode() * 0x1F, 0x1F), 0x1F, this.c);
        return this.d == null ? v : v + this.d.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = o.u(this.b, "NetworkBtnErrorUiState(message=", this.a, ", icon=", ", isForceDarkMode=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", exception=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

