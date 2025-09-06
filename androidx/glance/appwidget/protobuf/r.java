package androidx.glance.appwidget.protobuf;

public abstract class r {
    public static final q a;
    public static final q b;

    static {
        r.a = new q();  // 初始化器: Ljava/lang/Object;-><init>()V
        q q0 = null;
        try {
            q0 = (q)Class.forName("androidx.glance.appwidget.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        }
        catch(Exception unused_ex) {
        }
        r.b = q0;
    }
}

