package androidx.car.app.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class MessageTemplate implements Y {
    private final List mActionList;
    private final ActionStrip mActionStrip;
    private final CarText mDebugMessage;
    private final Action mHeaderAction;
    private final CarIcon mIcon;
    private final boolean mIsLoading;
    private final CarText mMessage;
    private final CarText mTitle;

    private MessageTemplate() {
        this.mIsLoading = false;
        this.mTitle = null;
        this.mMessage = null;
        this.mDebugMessage = null;
        this.mIcon = null;
        this.mHeaderAction = null;
        this.mActionStrip = null;
        this.mActionList = Collections.EMPTY_LIST;
    }

    public MessageTemplate(x x0) {
        throw null;
    }

    // 去混淆评级： 低(26)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof MessageTemplate ? this.mIsLoading == ((MessageTemplate)object0).mIsLoading && Objects.equals(this.mTitle, ((MessageTemplate)object0).mTitle) && Objects.equals(this.mMessage, ((MessageTemplate)object0).mMessage) && Objects.equals(this.mDebugMessage, ((MessageTemplate)object0).mDebugMessage) && Objects.equals(this.mHeaderAction, ((MessageTemplate)object0).mHeaderAction) && Objects.equals(this.mActionList, ((MessageTemplate)object0).mActionList) && Objects.equals(this.mIcon, ((MessageTemplate)object0).mIcon) && Objects.equals(this.mActionStrip, ((MessageTemplate)object0).mActionStrip) : false;
    }

    public ActionStrip getActionStrip() {
        return this.mActionStrip;
    }

    public List getActions() {
        return this.mActionList == null ? Collections.EMPTY_LIST : this.mActionList;
    }

    public CarText getDebugMessage() {
        return this.mDebugMessage;
    }

    public Action getHeaderAction() {
        return this.mHeaderAction;
    }

    public CarIcon getIcon() {
        return this.mIcon;
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
        return Objects.hash(new Object[]{Boolean.valueOf(this.mIsLoading), this.mTitle, this.mMessage, this.mDebugMessage, this.mHeaderAction, this.mActionList, this.mIcon, this.mActionStrip});
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    @Override
    public String toString() {
        return "MessageTemplate";
    }
}

