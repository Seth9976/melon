package U4;

import E9.w;

public final class z extends w {
    public final Throwable g;

    public z(Throwable throwable0) {
        this.g = throwable0;
    }

    @Override
    public final String toString() {
        return "FAILURE (" + this.g.getMessage() + ")";
    }
}

