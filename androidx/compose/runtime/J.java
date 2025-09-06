package androidx.compose.runtime;

public final class j extends IllegalStateException {
    public final String a;

    public j(String s) {
        this.a = s;
    }

    @Override
    public final String getMessage() {
        return this.a;
    }
}

