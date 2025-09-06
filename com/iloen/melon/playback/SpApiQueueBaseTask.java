package com.iloen.melon.playback;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\'\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\f\u0012\u0004\u0012\u00020\t0\bj\u0002`\nH¦@¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001A\u0004\b\u0013\u0010\u000E¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/playback/SpApiQueueBaseTask;", "", "", "priority", "", "taskDesc", "<init>", "(ILjava/lang/String;)V", "Lkotlin/Function0;", "Lie/H;", "Lcom/iloen/melon/playback/EndAction;", "execute", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "()Ljava/lang/String;", "I", "getPriority", "()I", "Ljava/lang/String;", "getTaskDesc", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class SpApiQueueBaseTask {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/playback/SpApiQueueBaseTask$Companion;", "", "<init>", "()V", "PRIORITY_HIGH", "", "PRIORITY_DEFAULT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final int PRIORITY_DEFAULT = 1;
    public static final int PRIORITY_HIGH;
    private final int priority;
    @NotNull
    private final String taskDesc;

    static {
        SpApiQueueBaseTask.Companion = new Companion(null);
    }

    public SpApiQueueBaseTask(int v, @NotNull String s) {
        q.g(s, "taskDesc");
        super();
        this.priority = v;
        this.taskDesc = s;
    }

    @Nullable
    public abstract Object execute(@NotNull Continuation arg1);

    public final int getPriority() {
        return this.priority;
    }

    @NotNull
    public final String getTaskDesc() {
        return this.taskDesc;
    }

    @Override
    @NotNull
    public String toString() {
        return this.taskDesc;
    }
}

