package kotlinx.coroutines.internal;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/internal/Symbol;", "", "", "symbol", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class Symbol {
    @NotNull
    public final String symbol;

    public Symbol(@NotNull String s) {
        this.symbol = s;
    }

    @Override
    @NotNull
    public String toString() {
        return o.r(new StringBuilder("<"), this.symbol, '>');
    }
}

