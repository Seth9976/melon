package lf;

import rf.n;

public enum d implements n {
    BYTE(0),
    CHAR(1),
    SHORT(2),
    INT(3),
    LONG(4),
    FLOAT(5),
    DOUBLE(6),
    BOOLEAN(7),
    STRING(8),
    CLASS(9),
    ENUM(10),
    ANNOTATION(11),
    ARRAY(12);

    public final int a;

    public d(int v1) {
        this.a = v1;
    }

    @Override  // rf.n
    public final int a() {
        return this.a;
    }

    public static d b(int v) {
        switch(v) {
            case 0: {
                return d.b;
            }
            case 1: {
                return d.c;
            }
            case 2: {
                return d.d;
            }
            case 3: {
                return d.e;
            }
            case 4: {
                return d.f;
            }
            case 5: {
                return d.g;
            }
            case 6: {
                return d.h;
            }
            case 7: {
                return d.i;
            }
            case 8: {
                return d.j;
            }
            case 9: {
                return d.k;
            }
            case 10: {
                return d.l;
            }
            case 11: {
                return d.m;
            }
            case 12: {
                return d.n;
            }
            default: {
                return null;
            }
        }
    }
}

