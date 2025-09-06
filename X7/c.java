package X7;

public abstract class c extends Exception {
    public static final boolean a;
    public static final StackTraceElement[] b;

    static {
        c.a = System.getProperty("surefire.test.class.path") != null;
        c.b = new StackTraceElement[0];
    }

    @Override
    public final Throwable fillInStackTrace() {
        synchronized(this) {
        }
        return null;
    }
}

