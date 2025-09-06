package l1;

import A7.d;

public final class i {
    public final float a;
    public final int b;
    public static final i c;

    static {
        i.c = new i(f.c, 17);
    }

    public i(float f, int v) {
        this.a = f;
        this.b = v;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof i && Float.compare(this.a, ((i)object0).a) == 0 && this.b == ((i)object0).b;
    }

    @Override
    public final int hashCode() {
        return d.b(this.b, Float.hashCode(this.a) * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder("LineHeightStyle(alignment=");
        stringBuilder0.append(f.b(this.a));
        stringBuilder0.append(", trim=");
        int v = this.b;
        if(v == 1) {
            s = "LineHeightStyle.Trim.FirstLineTop";
        }
        else {
            switch(v) {
                case 0: {
                    s = "LineHeightStyle.Trim.None";
                    break;
                }
                case 16: {
                    s = "LineHeightStyle.Trim.LastLineBottom";
                    break;
                }
                case 17: {
                    s = "LineHeightStyle.Trim.Both";
                    break;
                }
                default: {
                    s = "Invalid";
                }
            }
        }
        stringBuilder0.append(s);
        stringBuilder0.append(",mode=Mode(value=0))");
        return stringBuilder0.toString();
    }
}

