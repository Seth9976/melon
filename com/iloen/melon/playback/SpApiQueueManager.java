package com.iloen.melon.playback;

import je.m;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001A\u0004\u0018\u00010\n2\u0006\u0010\u000B\u001A\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\nH&¢\u0006\u0004\b\u000E\u0010\u000FJ\u0019\u0010\u0010\u001A\u0004\u0018\u00010\n2\u0006\u0010\u000B\u001A\u00020\nH&¢\u0006\u0004\b\u0010\u0010\rJ\u000F\u0010\u0011\u001A\u00020\nH&¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\n0\u00138\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001B\u001A\u00020\u00188F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u001D\u001A\u00020\u001C8F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001E¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/playback/SpApiQueueManager;", "", "<init>", "()V", "Lie/H;", "start", "", "from", "clear", "(Ljava/lang/String;)V", "Lcom/iloen/melon/playback/SpApiQueueBaseTask;", "task", "dequeueAndClear", "(Lcom/iloen/melon/playback/SpApiQueueBaseTask;)Lcom/iloen/melon/playback/SpApiQueueBaseTask;", "enqueue", "(Lcom/iloen/melon/playback/SpApiQueueBaseTask;)V", "dequeue", "peek", "()Lcom/iloen/melon/playback/SpApiQueueBaseTask;", "Lje/m;", "requestList", "Lje/m;", "getRequestList", "()Lje/m;", "", "getRemainedCount", "()I", "remainedCount", "", "isEmpty", "()Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class SpApiQueueManager {
    public static final int $stable = 8;
    @NotNull
    private final m requestList;

    public SpApiQueueManager() {
        this.requestList = new m();
    }

    public abstract void clear(@NotNull String arg1);

    @Nullable
    public abstract SpApiQueueBaseTask dequeue(@NotNull SpApiQueueBaseTask arg1);

    @Nullable
    public abstract SpApiQueueBaseTask dequeueAndClear(@NotNull SpApiQueueBaseTask arg1);

    public abstract void enqueue(@NotNull SpApiQueueBaseTask arg1);

    public final int getRemainedCount() {
        return this.requestList.b();
    }

    @NotNull
    public final m getRequestList() {
        return this.requestList;
    }

    public final boolean isEmpty() {
        return this.requestList.b() == 0;
    }

    @NotNull
    public abstract SpApiQueueBaseTask peek();

    public abstract void start();
}

