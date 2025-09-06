package x8;

import com.iloen.melon.task.TaskState;
import kotlin.jvm.internal.q;

public final class g {
    public final b a;
    public final TaskState b;

    public g(b b0, TaskState taskState0) {
        q.g(b0, "task");
        q.g(taskState0, "status");
        super();
        this.a = b0;
        this.b = taskState0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g)) {
            return false;
        }
        return q.b(this.a, ((g)object0).a) ? q.b(this.b, ((g)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "EventCoroutineAsyncTask(task=" + this.a + ", status=" + this.b + ")";
    }
}

