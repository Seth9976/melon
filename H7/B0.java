package h7;

public final class b0 {
    public Double a;
    public int b;
    public boolean c;
    public int d;
    public long e;
    public long f;
    public byte g;

    public final c0 a() {
        if(this.g != 0x1F) {
            StringBuilder stringBuilder0 = new StringBuilder();
            if((this.g & 1) == 0) {
                stringBuilder0.append(" batteryVelocity");
            }
            if((this.g & 2) == 0) {
                stringBuilder0.append(" proximityOn");
            }
            if((this.g & 4) == 0) {
                stringBuilder0.append(" orientation");
            }
            if((this.g & 8) == 0) {
                stringBuilder0.append(" ramUsed");
            }
            if((this.g & 16) == 0) {
                stringBuilder0.append(" diskUsed");
            }
            throw new IllegalStateException("Missing required properties:" + stringBuilder0);
        }
        return new c0(this.a, this.b, this.c, this.d, this.e, this.f);
    }
}

