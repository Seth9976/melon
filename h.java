import kotlin.jvm.internal.q;

public final class h implements i {
    public final e a;

    public h(e e0) {
        q.g(e0, "flexibleListItemUiState");
        super();
        this.a = e0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof h ? q.b(this.a, ((h)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnPlayButtonClick(flexibleListItemUiState=" + this.a + ")";
    }
}

