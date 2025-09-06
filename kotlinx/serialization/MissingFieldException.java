package kotlinx.serialization;

import A7.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u001F\b\u0016\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001A\u00020\u0003¢\u0006\u0004\b\b\u0010\u000BR\u001D\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lkotlinx/serialization/MissingFieldException;", "Lkotlinx/serialization/SerializationException;", "", "", "missingFields", "message", "", "cause", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Throwable;)V", "serialName", "(Ljava/util/List;Ljava/lang/String;)V", "Ljava/util/List;", "getMissingFields", "()Ljava/util/List;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class MissingFieldException extends SerializationException {
    @NotNull
    private final List missingFields;

    public MissingFieldException(@NotNull List list0, @NotNull String s) {
        q.g(list0, "missingFields");
        q.g(s, "serialName");
        this(list0, (list0.size() == 1 ? d.n(new StringBuilder("Field \'"), ((String)list0.get(0)), "\' is required for type with serial name \'", s, "\', but it was missing") : "Fields " + list0 + " are required for type with serial name \'" + s + "\', but they were missing"), null);
    }

    public MissingFieldException(@NotNull List list0, @Nullable String s, @Nullable Throwable throwable0) {
        q.g(list0, "missingFields");
        super(s, throwable0);
        this.missingFields = list0;
    }

    @NotNull
    public final List getMissingFields() {
        return this.missingFields;
    }
}

