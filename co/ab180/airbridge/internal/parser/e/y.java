package co.ab180.airbridge.internal.parser.e;

import co.ab180.airbridge.internal.e0.o;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001A\u00020\b2\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\t\u001A\u00020\u000BH\u0004¢\u0006\u0004\b\t\u0010\fJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u0006H\u0004¢\u0006\u0004\b\t\u0010\u000EJ\u0017\u0010\t\u001A\u00028\u00002\u0006\u0010\u000F\u001A\u00020\u000BH&¢\u0006\u0004\b\t\u0010\u0010J\u0017\u0010\t\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00028\u0000H&¢\u0006\u0004\b\t\u0010\u0012R$\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\t\u0010\u0013¨\u0006\u0014"}, d2 = {"Lco/ab180/airbridge/internal/parser/e/y;", "T", "", "<init>", "()V", "", "", "classParseInfo", "Lie/H;", "a", "(Ljava/util/Map;)V", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "filedName", "(Ljava/lang/String;)Ljava/lang/String;", "jsonObject", "(Lorg/json/JSONObject;)Ljava/lang/Object;", "src", "(Ljava/lang/Object;)Lorg/json/JSONObject;", "Ljava/util/Map;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public abstract class y {
    private Map a;

    public abstract Object a(@NotNull JSONObject arg1);

    @NotNull
    public final String a(@NotNull String s) [...] // 潜在的解密器

    @NotNull
    public final JSONObject a() {
        return new o();
    }

    @NotNull
    public abstract JSONObject a(Object arg1);

    public final void a(@NotNull Map map0) {
        this.a = map0;
    }
}

