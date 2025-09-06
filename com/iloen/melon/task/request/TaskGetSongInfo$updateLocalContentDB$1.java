package com.iloen.melon.task.request;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.task.request.TaskGetSongInfo", f = "TaskGetSongInfo.kt", l = {0x84}, m = "updateLocalContentDB")
final class TaskGetSongInfo.updateLocalContentDB.1 extends c {
    public Object B;
    public final TaskGetSongInfo D;
    public int E;
    public Iterator r;
    public int w;

    public TaskGetSongInfo.updateLocalContentDB.1(TaskGetSongInfo taskGetSongInfo0, Continuation continuation0) {
        this.D = taskGetSongInfo0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return TaskGetSongInfo.access$updateLocalContentDB(this.D, null, this);
    }
}

