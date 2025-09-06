package I6;

import java.io.Serializable;

public final class m0 extends n0 implements Serializable {
    public static final m0 a;
    private static final long serialVersionUID;

    static {
        m0.a = new m0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // I6.n0
    public final n0 a() {
        return w0.a;
    }

    @Override
    public final int compare(Object object0, Object object1) {
        ((Comparable)object0).getClass();
        ((Comparable)object1).getClass();
        return ((Comparable)object0).compareTo(((Comparable)object1));
    }

    private Object readResolve() {
        return m0.a;
    }

    @Override
    public final String toString() {
        return "Ordering.natural()";
    }
}

