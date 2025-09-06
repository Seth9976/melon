package z7;

import A7.b;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class g implements i {
    public final TaskCompletionSource a;

    public g(TaskCompletionSource taskCompletionSource0) {
        this.a = taskCompletionSource0;
    }

    @Override  // z7.i
    public final boolean a(Exception exception0) {
        return false;
    }

    @Override  // z7.i
    public final boolean b(b b0) {
        if(b0.b == 3 || b0.b == 4 || b0.b == 5) {
            this.a.trySetResult(b0.a);
            return true;
        }
        return false;
    }
}

