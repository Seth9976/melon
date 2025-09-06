package w7;

import Y6.g;
import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Set;
import java.util.concurrent.Executor;
import x1.a;
import y7.b;

public final class c implements e, f {
    public final g a;
    public final Context b;
    public final b c;
    public final Set d;
    public final Executor e;

    public c(Context context0, String s, Set set0, b b0, Executor executor0) {
        g g0 = new g(2, context0, s);
        super();
        this.a = g0;
        this.d = set0;
        this.e = executor0;
        this.c = b0;
        this.b = context0;
    }

    public final Task a() {
        if(!a.H(this.b)) {
            return Tasks.forResult("");
        }
        w7.b b0 = new w7.b(this, 0);
        return Tasks.call(this.e, b0);
    }

    public final void b() {
        if(this.d.size() <= 0) {
            Tasks.forResult(null);
            return;
        }
        if(!a.H(this.b)) {
            Tasks.forResult(null);
            return;
        }
        w7.b b0 = new w7.b(this, 1);
        Tasks.call(this.e, b0);
    }
}

