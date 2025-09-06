package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u000BH&¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u000F\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u000BH&¢\u0006\u0004\b\u000F\u0010\u000E¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/json/internal/InternalJsonWriter;", "", "", "value", "Lie/H;", "writeLong", "(J)V", "", "char", "writeChar", "(C)V", "", "text", "write", "(Ljava/lang/String;)V", "writeQuoted", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public interface InternalJsonWriter {
    void write(@NotNull String arg1);

    void writeChar(char arg1);

    void writeLong(long arg1);

    void writeQuoted(@NotNull String arg1);
}

