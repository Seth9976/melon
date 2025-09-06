package G1;

public class h extends g {
    public int m;

    public h(p p0) {
        super(p0);
        if(p0 instanceof l) {
            this.e = 2;
            return;
        }
        this.e = 3;
    }

    @Override  // G1.g
    public final void d(int v) {
        if(!this.j) {
            this.j = true;
            this.g = v;
            for(Object object0: this.k) {
                ((e)object0).a(((e)object0));
            }
        }
    }
}

