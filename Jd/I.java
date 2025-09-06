package jd;

import com.iloen.melon.net.v6x.response.EventPopupUiModel;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class i implements K4 {
    public final EventPopupUiModel a;

    public i(EventPopupUiModel eventPopupUiModel0) {
        q.g(eventPopupUiModel0, "uiModel");
        super();
        this.a = eventPopupUiModel0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof i ? q.b(this.a, ((i)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Success(uiModel=" + this.a + ")";
    }
}

