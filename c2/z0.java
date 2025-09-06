package c2;

import B0.s;

public abstract class z0 {
    public static int a(int v) {
        int v1 = 0;
        for(int v2 = 1; v2 <= 0x200; v2 <<= 1) {
            if((v & v2) != 0) {
                switch(v2) {
                    case 1: {
                        v1 |= h0.b();
                        break;
                    }
                    case 2: {
                        v1 |= h0.s();
                        break;
                    }
                    case 4: {
                        v1 |= h0.v();
                        break;
                    }
                    case 8: {
                        v1 |= s.B();
                        break;
                    }
                    case 16: {
                        v1 |= h0.x();
                        break;
                    }
                    case 0x20: {
                        v1 |= h0.z();
                        break;
                    }
                    case 0x40: {
                        v1 |= h0.B();
                        break;
                    }
                    case 0x80: {
                        v1 |= h0.D();
                    }
                }
            }
        }
        return v1;
    }
}

