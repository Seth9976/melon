package h7;

public final class e0 {
    public g0 a;
    public String b;
    public String c;
    public long d;
    public byte e;

    public final f0 a() {
        if(this.e == 1) {
            g0 g00 = this.a;
            if(g00 != null) {
                String s = this.b;
                if(s != null) {
                    String s1 = this.c;
                    if(s1 != null) {
                        return new f0(g00, s, s1, this.d);
                    }
                }
            }
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        if(this.a == null) {
            stringBuilder0.append(" rolloutVariant");
        }
        if(this.b == null) {
            stringBuilder0.append(" parameterKey");
        }
        if(this.c == null) {
            stringBuilder0.append(" parameterValue");
        }
        if((1 & this.e) == 0) {
            stringBuilder0.append(" templateVersion");
        }
        throw new IllegalStateException("Missing required properties:" + stringBuilder0);
    }
}

