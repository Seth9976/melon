package Vc;

import kotlin.jvm.internal.q;

public final class s implements u {
    public final r a;

    public s(r r0) {
        q.g(r0, "uiState");
        super();
        this.a = r0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof s ? q.b(this.a, ((s)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnLoginButtonClick(uiState=" + this.a + ")";
    }
}

