package co.ab180.airbridge.internal.parser;

import android.annotation.SuppressLint;
import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.parser.e.y;
import java.io.Closeable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\t\u001A\u0004\u0018\u00010\b\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ$\u0010\t\u001A\u00028\u0000\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u00042\u0006\u0010\f\u001A\u00020\u000BH\u0086\b¢\u0006\u0004\b\t\u0010\rJ\u001F\u0010\u000F\u001A\u00020\u000B\"\b\b\u0000\u0010\u0005*\u00020\u00042\u0006\u0010\u000E\u001A\u00028\u0000¢\u0006\u0004\b\u000F\u0010\u0010J.\u0010\t\u001A\u00028\u0000\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u00042\u0006\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\u0014\u001A\u00020\u0013H\u0086\b¢\u0006\u0004\b\t\u0010\u0015J(\u0010\u0016\u001A\u0004\u0018\u00010\u000B\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u00042\b\u0010\u000E\u001A\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0010J$\u0010\t\u001A\u00020\u0011\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u00042\u0006\u0010\u000E\u001A\u00028\u0000H\u0087\b¢\u0006\u0004\b\t\u0010\u0017J\u000F\u0010\u0019\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u0003R \u0010\u001C\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001B¨\u0006\u001D"}, d2 = {"Lco/ab180/airbridge/internal/parser/c;", "Ljava/io/Closeable;", "<init>", "()V", "", "T", "Ljava/lang/Class;", "clazz", "Lco/ab180/airbridge/internal/parser/a;", "a", "(Ljava/lang/Class;)Lco/ab180/airbridge/internal/parser/a;", "Lorg/json/JSONObject;", "jsonObject", "(Lorg/json/JSONObject;)Ljava/lang/Object;", "src", "b", "(Ljava/lang/Object;)Lorg/json/JSONObject;", "", "json", "", "supportNullable", "(Ljava/lang/String;Z)Ljava/lang/Object;", "c", "(Ljava/lang/Object;)Ljava/lang/String;", "Lie/H;", "close", "", "Ljava/util/Map;", "classParseContextMap", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class c implements Closeable {
    private static final Map a;
    @NotNull
    public static final c b;

    static {
        c.b = new c();
        c.a = new LinkedHashMap();
    }

    private final a a(Class class0) {
        a a1;
        Map map0 = c.a;
        a a0 = (a)map0.get(class0.getName());
        if(a0 == null) {
            try {
                a1 = new a(class0);
            }
            catch(Exception exception0) {
                System.out.println("findClassParseInfo exception : " + exception0 + ". clazzName: " + class0.getName());
                return a0;
            }
            try {
                map0.put(class0.getName(), a1);
                return a1;
            }
            catch(Exception exception0) {
                a0 = a1;
            }
            System.out.println("findClassParseInfo exception : " + exception0 + ". clazzName: " + class0.getName());
        }
        return a0;
    }

    public static Object a(c c0, String s, boolean z, int v, Object object0) {
        q.k();
        throw null;
    }

    public final Object a(String s, boolean z) {
        q.g(s, "json");
        q.k();
        throw null;
    }

    public final Object a(JSONObject jSONObject0) {
        q.g(jSONObject0, "jsonObject");
        q.k();
        throw null;
    }

    @SuppressLint({"Recycle"})
    public final String a(Object object0) {
        q.g(object0, "src");
        q.k();
        throw null;
    }

    @NotNull
    public final JSONObject b(@NotNull Object object0) {
        a a0 = this.a(object0.getClass());
        if(a0 != null) {
            y y0 = a0.b();
            if(y0 != null) {
                JSONObject jSONObject0 = y0.a(object0);
                return jSONObject0 == null ? b0.a(b.a.f(object0)) : jSONObject0;
            }
        }
        return b0.a(b.a.f(object0));
    }

    public final JSONObject c(Object object0) {
        return object0 == null ? null : this.b(object0);
    }

    @Override
    public void close() {
        c.a.clear();
    }
}

