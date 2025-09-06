package androidx.window.embedding;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001A\u00020\u000BH\u0016R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Landroidx/window/embedding/EmbeddingRule;", "", "tag", "", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public abstract class EmbeddingRule {
    @Nullable
    private final String tag;

    public EmbeddingRule(@Nullable String s) {
        this.tag = s;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof EmbeddingRule ? q.b(this.tag, ((EmbeddingRule)object0).tag) : false;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    @Override
    public int hashCode() {
        return this.tag == null ? 0 : this.tag.hashCode();
    }
}

