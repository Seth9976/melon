package m8;

import Bf.a;

public abstract class e extends a {
    public final int b;

    public e(int v) {
        this.b = v;
        super();
    }

    @Override  // Bf.a
    public final String W0() {
        switch(this.b) {
            case 0: {
                return "cookies";
            }
            case 1: {
                return "giftbox";
            }
            default: {
                return "token";
            }
        }
    }
}

