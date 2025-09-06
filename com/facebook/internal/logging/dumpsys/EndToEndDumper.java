package com.facebook.internal.logging.dumpsys;

import java.io.PrintWriter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000 \u000B2\u00020\u0001:\u0001\u000BJ-\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH&¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/EndToEndDumper;", "", "maybeDump", "", "prefix", "", "writer", "Ljava/io/PrintWriter;", "args", "", "(Ljava/lang/String;Ljava/io/PrintWriter;[Ljava/lang/String;)Z", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface EndToEndDumper {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001C\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/facebook/internal/logging/dumpsys/EndToEndDumper$Companion;", "", "()V", "instance", "Lcom/facebook/internal/logging/dumpsys/EndToEndDumper;", "getInstance", "()Lcom/facebook/internal/logging/dumpsys/EndToEndDumper;", "setInstance", "(Lcom/facebook/internal/logging/dumpsys/EndToEndDumper;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;
        @Nullable
        private static EndToEndDumper instance;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        @Nullable
        public final EndToEndDumper getInstance() {
            return Companion.instance;
        }

        public final void setInstance(@Nullable EndToEndDumper endToEndDumper0) {
            Companion.instance = endToEndDumper0;
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        EndToEndDumper.Companion = Companion.$$INSTANCE;
    }

    boolean maybeDump(@NotNull String arg1, @NotNull PrintWriter arg2, @Nullable String[] arg3);
}

