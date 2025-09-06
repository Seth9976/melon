package h7;

public final class i0 {
    public int a;
    public String b;
    public String c;
    public boolean d;
    public byte e;

    public final j0 a() {
        if(this.e == 3) {
            String s = this.b;
            if(s != null) {
                String s1 = this.c;
                if(s1 != null) {
                    return new j0(this.a, s, s1, this.d);
                }
            }
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        if((this.e & 1) == 0) {
            stringBuilder0.append(" platform");
        }
        if(this.b == null) {
            stringBuilder0.append(" version");
        }
        if(this.c == null) {
            stringBuilder0.append(" buildVersion");
        }
        if((this.e & 2) == 0) {
            stringBuilder0.append(" jailbroken");
        }
        throw new IllegalStateException("Missing required properties:" + stringBuilder0);
    }
}

