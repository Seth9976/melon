package androidx.fragment.app;

public final class r implements Runnable {
    public final int a;
    public final Object b;

    public r(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                ((w)this.b).mOnDismissListener.onDismiss(((w)this.b).mDialog);
                return;
            }
            case 1: {
                q q0 = (q)this.b;
                if(!q0.b.isEmpty()) {
                    q0.e();
                }
                return;
            }
            default: {
                ((l0)this.b).z(true);
            }
        }
    }
}

