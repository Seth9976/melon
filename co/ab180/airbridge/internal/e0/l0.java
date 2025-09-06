package co.ab180.airbridge.internal.e0;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u000E\n\u0002\u0010\u000B\n\u0002\b\u0004\u001A\u0013\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001A\u0013\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"", "", "a", "(Ljava/lang/String;)Z", "b", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class l0 {
    public static final boolean a(@NotNull String s) {
        Pattern pattern0 = Pattern.compile("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}");
        q.f(pattern0, "compile(...)");
        q.g(s, "input");
        return pattern0.matcher(s).matches();
    }

    public static final boolean b(@NotNull String s) {
        Pattern pattern0 = Pattern.compile("^[a-zA-Z0-9]{64}$");
        q.f(pattern0, "compile(...)");
        q.g(s, "input");
        return pattern0.matcher(s).matches();
    }
}

