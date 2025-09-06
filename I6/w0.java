package I6;

import java.io.Serializable;

public final class w0 extends n0 implements Serializable {
    public static final w0 a;
    private static final long serialVersionUID;

    static {
        w0.a = new w0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // I6.n0
    public final n0 a() {
        return m0.a;
    }

    @Override
    public final int compare(Object object0, Object object1) {
        ((Comparable)object0).getClass();
        return ((Comparable)object0) == ((Comparable)object1) ? 0 : ((Comparable)object1).compareTo(((Comparable)object0));
    }

    private Object readResolve() {
        return w0.a;
    }

    @Override
    public final String toString() {
        return "Ordering.natural().reverse()";
    }
}

