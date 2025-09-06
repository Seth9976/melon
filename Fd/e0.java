package Fd;

import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.StateFlow;

public final class e0 {
    public final String a;
    public final StateFlow b;
    public final boolean c;

    public e0(String s, StateFlow stateFlow0, boolean z) {
        q.g(s, "keyword");
        q.g(stateFlow0, "isShow");
        super();
        this.a = s;
        this.b = stateFlow0;
        this.c = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e0)) {
            return false;
        }
        if(!q.b(this.a, ((e0)object0).a)) {
            return false;
        }
        return q.b(this.b, ((e0)object0).b) ? this.c == ((e0)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SearchWebViewState(keyword=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", isShow=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isHotKeywordClick=");
        return o.s(stringBuilder0, this.c, ")");
    }
}

