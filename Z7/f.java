package z7;

import A7.b;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class f implements i {
    public final j a;
    public final TaskCompletionSource b;

    public f(j j0, TaskCompletionSource taskCompletionSource0) {
        this.a = j0;
        this.b = taskCompletionSource0;
    }

    @Override  // z7.i
    public final boolean a(Exception exception0) {
        this.b.trySetException(exception0);
        return true;
    }

    @Override  // z7.i
    public final boolean b(b b0) {
        if(b0.b == 4 && !this.a.a(b0)) {
            String s = b0.c;
            if(s == null) {
                throw new NullPointerException("Null token");
            }
            a a0 = new a(s, b0.e, b0.f);
            this.b.setResult(a0);
            return true;
        }
        return false;
    }
}

