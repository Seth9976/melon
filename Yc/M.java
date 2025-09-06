package yc;

import Ac.m4;
import com.iloen.melon.net.v4x.response.OneHourChartGraphRes.RESPONSE;
import kotlin.jvm.internal.q;

public final class m extends m4 {
    public final RESPONSE a;

    public m(RESPONSE oneHourChartGraphRes$RESPONSE0) {
        this.a = oneHourChartGraphRes$RESPONSE0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof m ? q.b(this.a, ((m)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OneHourGraphUiState(graphData=" + this.a + ")";
    }
}

