package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0005\u001A\u0017\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u001F\u0010\n\u001A\u00020\t*\u00060\u0005j\u0002`\u00062\u0006\u0010\b\u001A\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000B\u001A\u0015\u0010\r\u001A\u0004\u0018\u00010\f*\u00020\u0007H\u0000¢\u0006\u0004\b\r\u0010\u000E\"(\u0010\u0010\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000F8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0012\u0010\u0013\"\u001A\u0010\u0017\u001A\u00020\u00168\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"", "i", "", "toHexChar", "(I)C", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "value", "Lie/H;", "printQuoted", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "", "ESCAPE_STRINGS", "[Ljava/lang/String;", "getESCAPE_STRINGS", "()[Ljava/lang/String;", "getESCAPE_STRINGS$annotations", "()V", "", "ESCAPE_MARKERS", "[B", "getESCAPE_MARKERS", "()[B", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class StringOpsKt {
    @NotNull
    private static final byte[] ESCAPE_MARKERS;
    @NotNull
    private static final String[] ESCAPE_STRINGS;

    static {
        String[] arr_s = new String[93];
        for(int v1 = 0; v1 < 0x20; ++v1) {
            arr_s[v1] = "\\u" + StringOpsKt.toHexChar(v1 >> 12) + StringOpsKt.toHexChar(v1 >> 8) + StringOpsKt.toHexChar(v1 >> 4) + StringOpsKt.toHexChar(v1);
        }
        arr_s[34] = "\\\"";
        arr_s[92] = "\\\\";
        arr_s[9] = "\\t";
        arr_s[8] = "\\b";
        arr_s[10] = "\\n";
        arr_s[13] = "\\r";
        arr_s[12] = "\\f";
        StringOpsKt.ESCAPE_STRINGS = arr_s;
        byte[] arr_b = new byte[93];
        for(int v = 0; v < 0x20; ++v) {
            arr_b[v] = 1;
        }
        arr_b[34] = 34;
        arr_b[92] = 92;
        arr_b[9] = 0x74;
        arr_b[8] = 98;
        arr_b[10] = 110;
        arr_b[13] = 0x72;
        arr_b[12] = 102;
        StringOpsKt.ESCAPE_MARKERS = arr_b;
    }

    @NotNull
    public static final byte[] getESCAPE_MARKERS() [...] // 潜在的解密器

    @NotNull
    public static final String[] getESCAPE_STRINGS() {
        return StringOpsKt.ESCAPE_STRINGS;
    }

    public static final void printQuoted(@NotNull StringBuilder stringBuilder0, @NotNull String s) {
        q.g(stringBuilder0, "<this>");
        q.g(s, "value");
        stringBuilder0.append('\"');
        int v = s.length();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            int v3 = s.charAt(v1);
            String[] arr_s = StringOpsKt.ESCAPE_STRINGS;
            if(v3 < arr_s.length && arr_s[v3] != null) {
                stringBuilder0.append(s, v2, v1);
                stringBuilder0.append(arr_s[v3]);
                v2 = v1 + 1;
            }
        }
        if(v2 == 0) {
            stringBuilder0.append(s);
        }
        else {
            stringBuilder0.append(s, v2, s.length());
        }
        stringBuilder0.append('\"');
    }

    @Nullable
    public static final Boolean toBooleanStrictOrNull(@NotNull String s) {
        q.g(s, "<this>");
        if(s.equalsIgnoreCase("true")) {
            return true;
        }
        return s.equalsIgnoreCase("false") ? false : null;
    }

    private static final char toHexChar(int v) {
        return (v & 15) >= 10 ? ((char)((v & 15) + 87)) : ((char)((v & 15) + 0x30));
    }
}

