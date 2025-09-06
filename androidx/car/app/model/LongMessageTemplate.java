package androidx.car.app.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class LongMessageTemplate implements Y {
    private final List mActionList;
    private final ActionStrip mActionStrip;
    private final Action mHeaderAction;
    private final CarText mMessage;
    private final CarText mTitle;

    private LongMessageTemplate() {
        this.mTitle = null;
        this.mMessage = null;
        this.mActionStrip = null;
        this.mHeaderAction = null;
        this.mActionList = Collections.EMPTY_LIST;
    }

    public LongMessageTemplate(w w0) {
        throw null;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof LongMessageTemplate ? Objects.equals(this.mTitle, ((LongMessageTemplate)object0).mTitle) && Objects.equals(this.mMessage, ((LongMessageTemplate)object0).mMessage) && Objects.equals(this.mHeaderAction, ((LongMessageTemplate)object0).mHeaderAction) && Objects.equals(this.mActionList, ((LongMessageTemplate)object0).mActionList) && Objects.equals(this.mActionStrip, ((LongMessageTemplate)object0).mActionStrip) : false;
    }

    public ActionStrip getActionStrip() {
        return this.mActionStrip;
    }

    public List getActions() {
        return this.mActionList == null ? Collections.EMPTY_LIST : this.mActionList;
    }

    public Action getHeaderAction() {
        return this.mHeaderAction;
    }

    public CarText getMessage() {
        Objects.requireNonNull(this.mMessage);
        return this.mMessage;
    }

    public CarText getTitle() {
        return this.mTitle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mTitle, this.mMessage, this.mHeaderAction, this.mActionList, this.mActionStrip});
    }

    @Override
    public String toString() {
        return "LongMessageTemplate";
    }
}

