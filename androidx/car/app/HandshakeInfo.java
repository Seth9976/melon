package androidx.car.app;

import java.util.Objects;

public final class HandshakeInfo {
    private final int mHostCarAppApiLevel;
    private final String mHostPackageName;

    private HandshakeInfo() {
        this.mHostPackageName = null;
        this.mHostCarAppApiLevel = 0;
    }

    public HandshakeInfo(String s, int v) {
        this.mHostPackageName = s;
        this.mHostCarAppApiLevel = v;
    }

    public int getHostCarAppApiLevel() {
        return this.mHostCarAppApiLevel;
    }

    public String getHostPackageName() {
        Objects.requireNonNull(this.mHostPackageName);
        return this.mHostPackageName;
    }
}

