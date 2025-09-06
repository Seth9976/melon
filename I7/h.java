package I7;

import Ac.X3;
import B9.g;
import H7.e;
import H7.f;
import I5.a;
import androidx.lifecycle.L;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import ie.H;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.Executor;
import w1.j;
import w1.k;

public final class h implements Continuation, k {
    public final Object a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;

    public h(Object object0, Object object1, Object object2, Object object3, Object object4) {
        this.a = object0;
        this.b = object1;
        this.c = object2;
        this.d = object3;
        this.e = object4;
        super();
    }

    @Override  // w1.k
    public Object attachCompleter(j j0) {
        a a0 = new a(((U4.k)this.b), ((String)this.c), ((we.a)this.d), ((L)this.e), j0, 1);
        ((Executor)this.a).execute(a0);
        return H.a;
    }

    @Override  // com.google.android.gms.tasks.Continuation
    public Object then(Task task0) {
        I7.j j0 = (I7.j)this.a;
        Task task1 = (Task)this.b;
        Task task2 = (Task)this.c;
        Date date0 = (Date)this.d;
        HashMap hashMap0 = (HashMap)this.e;
        if(!task1.isSuccessful()) {
            return Tasks.forException(new e("Firebase Installations failed to get installation ID for fetch.", task1.getException()));  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
        if(!task2.isSuccessful()) {
            return Tasks.forException(new e("Firebase Installations failed to get installation auth token for fetch.", task2.getException()));  // 初始化器: Li/n/i/b/a/s/e/R7;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
        String s = (String)task1.getResult();
        String s1 = ((z7.a)task2.getResult()).a;
        try {
            i i0 = j0.a(s, s1, date0, hashMap0);
            if(i0.a != 0) {
                return Tasks.forResult(i0);
            }
            H7.a a0 = new H7.a(1, j0.f, i0.b);
            Task task3 = Tasks.call(j0.f.a, a0);
            g g0 = new g(6, j0.f, i0.b);
            Task task4 = task3.onSuccessTask(j0.f.a, g0);
            X3 x30 = new X3(i0, 7);
            return task4.onSuccessTask(j0.c, x30);
        }
        catch(f f0) {
            return Tasks.forException(f0);
        }
    }
}

