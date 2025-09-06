package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\n\n\u0002\u0010\u0019\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\n\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001A\u00020\t2\u0006\u0010\u0018\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001C\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001E\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u001E\u0010\u001DJ\u000F\u0010\u001F\u001A\u00020\tH\u0016¢\u0006\u0004\b\u001F\u0010\u0003J\u000F\u0010 \u001A\u00020\u0007H\u0016¢\u0006\u0004\b \u0010!R\u0016\u0010#\u001A\u00020\"8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006\'"}, d2 = {"Lkotlinx/serialization/json/internal/JsonToStringWriter;", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "<init>", "()V", "", "firstEscapedChar", "currentSize", "", "string", "Lie/H;", "appendStringSlowPath", "(IILjava/lang/String;)V", "expected", "ensureAdditionalCapacity", "(I)V", "oldSize", "additional", "ensureTotalCapacity", "(II)I", "", "value", "writeLong", "(J)V", "", "char", "writeChar", "(C)V", "text", "write", "(Ljava/lang/String;)V", "writeQuoted", "release", "toString", "()Ljava/lang/String;", "", "array", "[C", "size", "I", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class JsonToStringWriter implements InternalJsonWriter {
    @NotNull
    private char[] array;
    private int size;

    public JsonToStringWriter() {
        this.array = CharArrayPool.INSTANCE.take();
    }

    private final void appendStringSlowPath(int v, int v1, String s) {
        int v6;
        int v2 = s.length();
        while(v < v2) {
            int v3 = this.ensureTotalCapacity(v1, 2);
            int v4 = s.charAt(v);
            if(v4 < 93) {
                int v5 = new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 98, 0x74, 110, 1, 102, 0x72, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 34, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 92}[v4];
                if(v5 == 0) {
                    v6 = v3 + 1;
                    this.array[v3] = (char)v4;
                    goto label_25;
                }
                else {
                    if(v5 == 1) {
                        String s1 = StringOpsKt.getESCAPE_STRINGS()[v4];
                        q.d(s1);
                        int v7 = s1.length() + this.ensureTotalCapacity(v3, s1.length());
                        this.size = v7;
                        v1 = v7;
                    }
                    else {
                        char[] arr_c = this.array;
                        arr_c[v3] = '\\';
                        arr_c[v3 + 1] = (char)v5;
                        v1 = v3 + 2;
                        this.size = v1;
                    }
                    goto label_26;
                }
                goto label_23;
            }
            else {
            label_23:
                v6 = v3 + 1;
                this.array[v3] = (char)v4;
            }
        label_25:
            v1 = v6;
        label_26:
            ++v;
        }
        int v8 = this.ensureTotalCapacity(v1, 1);
        this.array[v8] = '\"';
        this.size = v8 + 1;
    }

    private final void ensureAdditionalCapacity(int v) {
        this.ensureTotalCapacity(this.size, v);
    }

    private final int ensureTotalCapacity(int v, int v1) {
        int v2 = v1 + v;
        char[] arr_c = this.array;
        if(arr_c.length <= v2) {
            if(v2 < v * 2) {
                v2 = v * 2;
            }
            char[] arr_c1 = Arrays.copyOf(arr_c, v2);
            q.f(arr_c1, "copyOf(...)");
            this.array = arr_c1;
        }
        return v;
    }

    public void release() {
        CharArrayPool.INSTANCE.release(this.array);
    }

    @Override
    @NotNull
    public String toString() [...] // 潜在的解密器

    @Override  // kotlinx.serialization.json.internal.InternalJsonWriter
    public void write(@NotNull String s) {
        q.g(s, "text");
        int v = s.length();
        if(v == 0) {
            return;
        }
        this.ensureAdditionalCapacity(v);
        this.size += v;
    }

    @Override  // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeChar(char c) {
        this.ensureAdditionalCapacity(1);
        int v = this.size;
        this.size = v + 1;
        this.array[v] = c;
    }

    @Override  // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeLong(long v) {
        this.write(String.valueOf(v));
    }

    @Override  // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeQuoted(@NotNull String s) {
        q.g(s, "text");
        this.ensureAdditionalCapacity(s.length() + 2);
        char[] arr_c = this.array;
        int v = this.size + 1;
        arr_c[this.size] = '\"';
        int v1 = s.length() + v;
        for(int v2 = v; v2 < v1; ++v2) {
            int v3 = arr_c[v2];
            if(v3 < 93 && new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 98, 0x74, 110, 1, 102, 0x72, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 34, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 92}[v3] != 0) {
                this.appendStringSlowPath(v2 - v, v2, s);
                return;
            }
        }
        arr_c[v1] = '\"';
        this.size = v1 + 1;
    }
}

