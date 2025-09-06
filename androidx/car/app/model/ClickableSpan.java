package androidx.car.app.model;

import android.annotation.SuppressLint;
import java.util.Objects;

public final class ClickableSpan extends CarSpan {
    private final B mOnClickDelegate;

    private ClickableSpan() {
        this.mOnClickDelegate = null;
    }

    private ClickableSpan(C c0) {
        this.mOnClickDelegate = OnClickDelegateImpl.create(c0);
    }

    @SuppressLint({"ExecutorRegistration"})
    public static ClickableSpan create(C c0) {
        Objects.requireNonNull(c0);
        return new ClickableSpan(c0);
    }

    @Override
    public boolean equals(Object object0) {
        boolean z = true;
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ClickableSpan)) {
            return false;
        }
        Boolean boolean0 = Boolean.valueOf(this.mOnClickDelegate == null);
        if(((ClickableSpan)object0).mOnClickDelegate != null) {
            z = false;
        }
        return boolean0.equals(Boolean.valueOf(z));
    }

    public B getOnClickDelegate() {
        Objects.requireNonNull(this.mOnClickDelegate);
        return this.mOnClickDelegate;
    }

    @Override
    public int hashCode() {
        return this.mOnClickDelegate == null ? Objects.hash(new Object[]{Boolean.TRUE}) : Objects.hash(new Object[]{Boolean.FALSE});
    }

    @Override
    public String toString() {
        return "[clickable]";
    }
}

