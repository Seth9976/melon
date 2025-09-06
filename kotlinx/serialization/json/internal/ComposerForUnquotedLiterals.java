package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\r¨\u0006\u000E"}, d2 = {"Lkotlinx/serialization/json/internal/ComposerForUnquotedLiterals;", "Lkotlinx/serialization/json/internal/Composer;", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "writer", "", "forceQuoting", "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Z)V", "", "value", "Lie/H;", "printQuoted", "(Ljava/lang/String;)V", "Z", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class ComposerForUnquotedLiterals extends Composer {
    private final boolean forceQuoting;

    public ComposerForUnquotedLiterals(@NotNull InternalJsonWriter internalJsonWriter0, boolean z) {
        q.g(internalJsonWriter0, "writer");
        super(internalJsonWriter0);
        this.forceQuoting = z;
    }

    @Override  // kotlinx.serialization.json.internal.Composer
    public void printQuoted(@NotNull String s) {
        q.g(s, "value");
        if(this.forceQuoting) {
            super.printQuoted(s);
            return;
        }
        this.print(s);
    }
}

