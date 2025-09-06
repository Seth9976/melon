package kotlinx.coroutines;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import me.a;
import me.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001A\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001A\u0010\u000E\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BHÖ\u0003¢\u0006\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001A\u0004\b\u0011\u0010\u0007¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/CoroutineName;", "Lme/a;", "", "name", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class CoroutineName extends a {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineName$Key;", "Lme/h;", "Lkotlinx/coroutines/CoroutineName;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Key implements h {
        private Key() {
        }

        public Key(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Key Key;
    @NotNull
    private final String name;

    static {
        CoroutineName.Key = new Key(null);
    }

    public CoroutineName(@NotNull String s) {
        super(CoroutineName.Key);
        this.name = s;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof CoroutineName ? q.b(this.name, ((CoroutineName)object0).name) : false;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return o.r(new StringBuilder("CoroutineName("), this.name, ')');
    }
}

