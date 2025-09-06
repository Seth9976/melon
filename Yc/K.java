package yc;

import Ac.m4;
import com.iloen.melon.net.v4x.response.FiveMinuteChartGraphRes.RESPONSE;
import kotlin.jvm.internal.q;

public final class k extends m4 {
    public final RESPONSE a;

    public k(RESPONSE fiveMinuteChartGraphRes$RESPONSE0) {
        this.a = fiveMinuteChartGraphRes$RESPONSE0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof k ? q.b(this.a, ((k)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "FiveMinuteGraphUiState(graphData=" + this.a + ")";
    }
}

