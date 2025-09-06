package androidx.datastore.preferences.protobuf;

public abstract class t {
    public static final s a;
    public static final s b;

    static {
        t.a = new s();  // 初始化器: Ljava/lang/Object;-><init>()V
        s s0 = null;
        try {
            s0 = (s)Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        }
        catch(Exception unused_ex) {
        }
        t.b = s0;
    }
}

