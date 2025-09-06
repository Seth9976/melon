import kotlin.jvm.internal.q;

public final class f implements i {
    public final e a;

    public f(e e0) {
        q.g(e0, "flexibleListItemUiState");
        super();
        this.a = e0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f ? q.b(this.a, ((f)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnItemClick(flexibleListItemUiState=" + this.a + ")";
    }
}

