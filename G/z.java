package G;

public final class Z {
    public float a;
    public double b;
    public float c;

    public final long a(float f, float f1, long v) {
        float f2 = f - this.a;
        float f3 = this.c;
        double f4 = ((double)f3) * ((double)f3);
        double f5 = this.b;
        double f6 = ((double)(-f3)) * f5;
        if(Float.compare(f3, 1.0f) > 0) {
            double f7 = Math.sqrt(f4 - 1.0) * f5;
            double f8 = f6 + f7;
            double f9 = f6 - f7;
            double f10 = (f9 * ((double)f2) - ((double)f1)) / (f9 - f8);
            double f11 = ((double)f2) - f10;
            double f12 = f9 * (((double)v) / 1000.0);
            double f13 = ((double)v) / 1000.0 * f8;
            return ((long)Float.floatToRawIntBits(((float)(Math.exp(f13) * (f10 * f8) + Math.exp(f12) * (f11 * f9))))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(((float)(Math.exp(f13) * f10 + Math.exp(f12) * f11 + ((double)this.a))))) << 0x20;
        }
        if(f3 == 1.0f) {
            double f14 = f5 * ((double)f2) + ((double)f1);
            double f15 = -f5 * (((double)v) / 1000.0);
            double f16 = ((double)v) / 1000.0 * f14 + ((double)f2);
            return ((long)Float.floatToRawIntBits(((float)(Math.exp(f15) * f14 + Math.exp(f15) * f16 * -this.b)))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(((float)(Math.exp(f15) * f16 + ((double)this.a))))) << 0x20;
        }
        double f17 = Math.sqrt(1.0 - f4) * f5;
        double f18 = (-f6 * ((double)f2) + ((double)f1)) * (1.0 / f17);
        double f19 = f17 * (((double)v) / 1000.0);
        double f20 = ((double)v) / 1000.0 * f6;
        double f21 = (Math.sin(f19) * f18 + Math.cos(f19) * ((double)f2)) * Math.exp(f20);
        return ((long)Float.floatToRawIntBits(((float)((Math.cos(f19) * (f17 * f18) + Math.sin(f19) * (-f17 * ((double)f2))) * Math.exp(f20) + f6 * f21)))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(((float)(f21 + ((double)this.a))))) << 0x20;
    }
}

