package kotlinx.serialization;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\b\u0016\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001D\b\u0016\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/serialization/SerializationException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "", "message", "<init>", "(Ljava/lang/String;)V", "", "cause", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public class SerializationException extends IllegalArgumentException {
    public SerializationException(@Nullable String s) {
        super(s);
    }

    public SerializationException(@Nullable String s, @Nullable Throwable throwable0) {
        super(s, throwable0);
    }
}

