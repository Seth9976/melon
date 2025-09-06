package cd;

import kotlin.jvm.internal.q;

public final class e implements g {
    public final int a;
    public final b b;

    public e(int v, b b0) {
        q.g(b0, "chartItemUiState");
        super();
        this.a = v;
        this.b = b0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e)) {
            return false;
        }
        return this.a == ((e)object0).a ? q.b(this.b, ((e)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a * 0x1F;
    }

    @Override
    public final String toString() {
        return "OnItemShown(selectedChartPosition=" + this.a + ", chartItemUiState=" + this.b + ")";
    }
}

