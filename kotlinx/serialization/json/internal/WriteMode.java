package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\f\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000B"}, d2 = {"Lkotlinx/serialization/json/internal/WriteMode;", "", "begin", "", "end", "<init>", "(Ljava/lang/String;ICC)V", "OBJ", "LIST", "MAP", "POLY_OBJ", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public enum WriteMode {
    OBJ('{', '}'),
    LIST('[', ']'),
    MAP('{', '}'),
    POLY_OBJ('[', ']');

    private static final a $ENTRIES;
    private static final WriteMode[] $VALUES;
    public final char begin;
    public final char end;

    private static final WriteMode[] $values() [...] // Inlined contents

    static {
        WriteMode.$VALUES = arr_writeMode;
        q.g(arr_writeMode, "entries");
        WriteMode.$ENTRIES = new b(arr_writeMode);
    }

    private WriteMode(char c, char c1) {
        this.begin = c;
        this.end = c1;
    }

    @NotNull
    public static a getEntries() {
        return WriteMode.$ENTRIES;
    }
}

