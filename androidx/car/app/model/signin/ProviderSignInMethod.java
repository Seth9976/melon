package androidx.car.app.model.signin;

import androidx.car.app.model.Action;
import androidx.car.app.model.B;
import java.util.Objects;
import w.c;

public final class ProviderSignInMethod implements c {
    private final Action mAction;

    private ProviderSignInMethod() {
        this.mAction = null;
    }

    public ProviderSignInMethod(Action action0) {
        Objects.requireNonNull(action0);
        if(action0.getType() != 1) {
            throw new IllegalArgumentException("The action must not be a standard action");
        }
        B b0 = action0.getOnClickDelegate();
        Objects.requireNonNull(b0);
        if(!b0.isParkedOnly()) {
            throw new IllegalArgumentException("The action must use a ParkedOnlyOnClickListener");
        }
        this.mAction = action0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ProviderSignInMethod ? Objects.equals(this.mAction, ((ProviderSignInMethod)object0).mAction) : false;
    }

    public Action getAction() {
        Objects.requireNonNull(this.mAction);
        return this.mAction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mAction});
    }

    @Override
    public String toString() {
        return "[action:" + this.mAction + "]";
    }
}

