package v9;

import U4.x;

public final class a {
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(" type[");
        stringBuilder0.append(this.a);
        stringBuilder0.append("] value[");
        stringBuilder0.append(this.b);
        stringBuilder0.append("] videoTitle[");
        stringBuilder0.append(this.c);
        stringBuilder0.append("] videoThumbUrl[");
        stringBuilder0.append(this.d);
        stringBuilder0.append("] videoWidth[");
        stringBuilder0.append(this.e);
        stringBuilder0.append("] videoHeight[");
        return x.g(this.f, "]", stringBuilder0);
    }
}

