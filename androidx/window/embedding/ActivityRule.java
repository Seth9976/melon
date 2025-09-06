package androidx.window.embedding;

import androidx.appcompat.app.o;
import java.util.Set;
import je.I;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0017B)\b\u0000\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u000E\u001A\u00020\b2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\u0016\u0010\u0013\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u0006H\u0080\u0002¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001A\u00020\u0003H\u0016R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Landroidx/window/embedding/ActivityRule;", "Landroidx/window/embedding/EmbeddingRule;", "tag", "", "filters", "", "Landroidx/window/embedding/ActivityFilter;", "alwaysExpand", "", "(Ljava/lang/String;Ljava/util/Set;Z)V", "getAlwaysExpand", "()Z", "getFilters", "()Ljava/util/Set;", "equals", "other", "", "hashCode", "", "plus", "filter", "plus$window_release", "toString", "Builder", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ActivityRule extends EmbeddingRule {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\n\u001A\u00020\u000BJ\u000E\u0010\f\u001A\u00020\u00002\u0006\u0010\u0006\u001A\u00020\u0007J\u0010\u0010\r\u001A\u00020\u00002\b\u0010\b\u001A\u0004\u0018\u00010\tR\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Landroidx/window/embedding/ActivityRule$Builder;", "", "filters", "", "Landroidx/window/embedding/ActivityFilter;", "(Ljava/util/Set;)V", "alwaysExpand", "", "tag", "", "build", "Landroidx/window/embedding/ActivityRule;", "setAlwaysExpand", "setTag", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Builder {
        private boolean alwaysExpand;
        @NotNull
        private final Set filters;
        @Nullable
        private String tag;

        public Builder(@NotNull Set set0) {
            q.g(set0, "filters");
            super();
            this.filters = set0;
        }

        @NotNull
        public final ActivityRule build() {
            return new ActivityRule(this.tag, this.filters, this.alwaysExpand);
        }

        @NotNull
        public final Builder setAlwaysExpand(boolean z) {
            this.alwaysExpand = z;
            return this;
        }

        @NotNull
        public final Builder setTag(@Nullable String s) {
            this.tag = s;
            return this;
        }
    }

    private final boolean alwaysExpand;
    @NotNull
    private final Set filters;

    public ActivityRule(@Nullable String s, @NotNull Set set0, boolean z) {
        q.g(set0, "filters");
        super(s);
        this.filters = set0;
        this.alwaysExpand = z;
    }

    public ActivityRule(String s, Set set0, boolean z, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            z = false;
        }
        this(s, set0, z);
    }

    @Override  // androidx.window.embedding.EmbeddingRule
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ActivityRule)) {
            return false;
        }
        if(!super.equals(object0)) {
            return false;
        }
        return q.b(this.filters, ((ActivityRule)object0).filters) ? this.alwaysExpand == ((ActivityRule)object0).alwaysExpand : false;
    }

    public final boolean getAlwaysExpand() {
        return this.alwaysExpand;
    }

    @NotNull
    public final Set getFilters() {
        return this.filters;
    }

    @Override  // androidx.window.embedding.EmbeddingRule
    public int hashCode() {
        return Boolean.hashCode(this.alwaysExpand) + (this.filters.hashCode() + super.hashCode() * 0x1F) * 0x1F;
    }

    @NotNull
    public final ActivityRule plus$window_release(@NotNull ActivityFilter activityFilter0) {
        q.g(activityFilter0, "filter");
        return new ActivityRule(this.getTag(), I.L(this.filters, activityFilter0), this.alwaysExpand);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ActivityRule:{tag={");
        stringBuilder0.append(this.getTag());
        stringBuilder0.append("},filters={");
        stringBuilder0.append(this.filters);
        stringBuilder0.append("}, alwaysExpand={");
        return o.s(stringBuilder0, this.alwaysExpand, "}}");
    }
}

