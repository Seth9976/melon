package androidx.core.widget;

public final class a {
    public int a;
    public int b;
    public float c;
    public float d;
    public long e;
    public long f;
    public long g;
    public float h;
    public int i;

    public final float a(long v) {
        long v1 = this.e;
        if(Long.compare(v, v1) < 0) {
            return 0.0f;
        }
        return Long.compare(this.g, 0L) < 0 || v < this.g ? e.b(((float)(v - v1)) / ((float)this.a), 0.0f, 1.0f) * 0.5f : e.b(((float)(v - this.g)) / ((float)this.i), 0.0f, 1.0f) * this.h + (1.0f - this.h);
    }
}

