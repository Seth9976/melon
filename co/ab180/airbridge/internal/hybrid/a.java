package co.ab180.airbridge.internal.hybrid;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lco/ab180/airbridge/internal/hybrid/a;", "", "", "webToken", "postCommand", "a", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class a {
    @NotNull
    public static final a a;

    static {
        a.a = new a();
    }

    @NotNull
    public final String a(@NotNull String s, @NotNull String s1) {
        return "\n        AirbridgeNative = {};\n        AirbridgeNative.getWebToken = function () {\n            return \"" + s + "\";\n        };\n        AirbridgeNative.getJSONSchemaVersion = function () {\n            return 5;\n        };\n        AirbridgeNative.execute = function (payload) {\n            " + s1 + ";\n        };\n    ";
    }
}

