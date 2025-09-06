package androidx.car.app.model;

import android.annotation.SuppressLint;
import java.util.Objects;

@SuppressLint({"ListenerInterface"})
public final class ParkedOnlyOnClickListener implements C {
    private final C mListener;

    private ParkedOnlyOnClickListener(C c0) {
        this.mListener = c0;
    }

    @SuppressLint({"ExecutorRegistration"})
    public static ParkedOnlyOnClickListener create(C c0) {
        Objects.requireNonNull(c0);
        return new ParkedOnlyOnClickListener(c0);
    }

    @Override  // androidx.car.app.model.C
    public void onClick() {
        this.mListener.onClick();
    }
}

