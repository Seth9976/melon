package androidx.window.embedding;

import android.content.Context;
import java.util.Set;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u0007¢\u0006\u0004\b\u000E\u0010\rJ\u001B\u0010\u0010\u001A\u00020\u000B2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001A\u00020\u000B¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroidx/window/embedding/RuleController;", "", "Landroidx/window/embedding/EmbeddingBackend;", "embeddingBackend", "<init>", "(Landroidx/window/embedding/EmbeddingBackend;)V", "", "Landroidx/window/embedding/EmbeddingRule;", "getRules", "()Ljava/util/Set;", "rule", "Lie/H;", "addRule", "(Landroidx/window/embedding/EmbeddingRule;)V", "removeRule", "rules", "setRules", "(Ljava/util/Set;)V", "clearRules", "()V", "Landroidx/window/embedding/EmbeddingBackend;", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class RuleController {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0007J \u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001A\u00020\u00062\b\b\u0001\u0010\n\u001A\u00020\u000BH\u0007¨\u0006\f"}, d2 = {"Landroidx/window/embedding/RuleController$Companion;", "", "()V", "getInstance", "Landroidx/window/embedding/RuleController;", "context", "Landroid/content/Context;", "parseRules", "", "Landroidx/window/embedding/EmbeddingRule;", "staticRuleResourceId", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final RuleController getInstance(@NotNull Context context0) {
            q.g(context0, "context");
            Context context1 = context0.getApplicationContext();
            q.d(context1);
            return new RuleController(EmbeddingBackend.Companion.getInstance(context1));
        }

        @NotNull
        public final Set parseRules(@NotNull Context context0, int v) {
            q.g(context0, "context");
            Context context1 = context0.getApplicationContext();
            q.f(context1, "getApplicationContext(...)");
            Set set0 = RuleParser.INSTANCE.parseRules$window_release(context1, v);
            return set0 == null ? y.a : set0;
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final EmbeddingBackend embeddingBackend;

    static {
        RuleController.Companion = new Companion(null);
    }

    public RuleController(@NotNull EmbeddingBackend embeddingBackend0) {
        q.g(embeddingBackend0, "embeddingBackend");
        super();
        this.embeddingBackend = embeddingBackend0;
    }

    public final void addRule(@NotNull EmbeddingRule embeddingRule0) {
        q.g(embeddingRule0, "rule");
        this.embeddingBackend.addRule(embeddingRule0);
    }

    public final void clearRules() {
        this.embeddingBackend.setRules(y.a);
    }

    @NotNull
    public static final RuleController getInstance(@NotNull Context context0) {
        return RuleController.Companion.getInstance(context0);
    }

    @NotNull
    public final Set getRules() {
        return this.embeddingBackend.getRules();
    }

    @NotNull
    public static final Set parseRules(@NotNull Context context0, int v) {
        return RuleController.Companion.parseRules(context0, v);
    }

    public final void removeRule(@NotNull EmbeddingRule embeddingRule0) {
        q.g(embeddingRule0, "rule");
        this.embeddingBackend.removeRule(embeddingRule0);
    }

    public final void setRules(@NotNull Set set0) {
        q.g(set0, "rules");
        this.embeddingBackend.setRules(set0);
    }
}

