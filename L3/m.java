package l3;

public final class m implements Runnable {
    public final int a;
    public final p b;

    public m(p p0, int v) {
        this.a = v;
        this.b = p0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            this.b.X = true;
            this.b.s();
            return;
        }
        this.b.s();
    }
}

