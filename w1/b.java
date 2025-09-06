package w1;

public final class b extends Throwable {
    public final int a;

    public b(String s, int v) {
        this.a = v;
        super(s);
    }

    @Override
    public final Throwable fillInStackTrace() {
        synchronized(this) {
            if(this.a != 0) {
                return this;
            }
        }
        return this;
    }
}

