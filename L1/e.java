package l1;

public final class e {
    public final int a;
    public static final int b = 0x10301;

    public e(int v) {
        this.a = v;
    }

    public static String a(int v) {
        String s2;
        String s1;
        StringBuilder stringBuilder0 = new StringBuilder("LineBreak(strategy=");
        String s = "Invalid";
        if((v & 0xFF) == 1) {
            s1 = "Strategy.Simple";
        }
        else if((v & 0xFF) == 2) {
            s1 = "Strategy.HighQuality";
        }
        else if((v & 0xFF) == 3) {
            s1 = "Strategy.Balanced";
        }
        else {
            s1 = (v & 0xFF) == 0 ? "Strategy.Unspecified" : "Invalid";
        }
        stringBuilder0.append(s1);
        stringBuilder0.append(", strictness=");
        switch(v >> 8 & 0xFF) {
            case 0: {
                s2 = "Strictness.Unspecified";
                break;
            }
            case 1: {
                s2 = "Strictness.None";
                break;
            }
            case 2: {
                s2 = "Strictness.Loose";
                break;
            }
            case 3: {
                s2 = "Strictness.Normal";
                break;
            }
            case 4: {
                s2 = "Strictness.Strict";
                break;
            }
            default: {
                s2 = "Invalid";
            }
        }
        stringBuilder0.append(s2);
        stringBuilder0.append(", wordBreak=");
        int v1 = v >> 16 & 0xFF;
        if(v1 == 1) {
            s = "WordBreak.None";
        }
        else if(v1 == 2) {
            s = "WordBreak.Phrase";
        }
        else if(v1 == 0) {
            s = "WordBreak.Unspecified";
        }
        stringBuilder0.append(s);
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof e && this.a == ((e)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return e.a(this.a);
    }
}

