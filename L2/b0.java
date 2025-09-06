package l2;

import com.google.firebase.messaging.u;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class b0 extends c {
    public Object B;
    public final u D;
    public int E;
    public u r;
    public Mutex w;

    public b0(u u0, c c0) {
        this.D = u0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.x(this);
    }
}

