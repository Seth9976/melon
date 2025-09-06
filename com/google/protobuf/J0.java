package com.google.protobuf;

public enum j0 implements G1 {
    TYPE_DOUBLE(1),
    TYPE_FLOAT(2),
    TYPE_INT64(3),
    TYPE_UINT64(4),
    TYPE_INT32(5),
    TYPE_FIXED64(6),
    TYPE_FIXED32(7),
    TYPE_BOOL(8),
    TYPE_STRING(9),
    TYPE_GROUP(10),
    TYPE_MESSAGE(11),
    TYPE_BYTES(12),
    TYPE_UINT32(13),
    TYPE_ENUM(14),
    TYPE_SFIXED32(15),
    TYPE_SFIXED64(16),
    TYPE_SINT32(17),
    TYPE_SINT64(18);

    public final int a;

    public j0(int v1) {
        this.a = v1;
    }

    @Override  // com.google.protobuf.G1
    public final int a() {
        return this.a;
    }

    public static j0 b(int v) {
        switch(v) {
            case 1: {
                return j0.b;
            }
            case 2: {
                return j0.c;
            }
            case 3: {
                return j0.d;
            }
            case 4: {
                return j0.e;
            }
            case 5: {
                return j0.f;
            }
            case 6: {
                return j0.g;
            }
            case 7: {
                return j0.h;
            }
            case 8: {
                return j0.i;
            }
            case 9: {
                return j0.j;
            }
            case 10: {
                return j0.k;
            }
            case 11: {
                return j0.l;
            }
            case 12: {
                return j0.m;
            }
            case 13: {
                return j0.n;
            }
            case 14: {
                return j0.o;
            }
            case 15: {
                return j0.r;
            }
            case 16: {
                return j0.w;
            }
            case 17: {
                return j0.B;
            }
            case 18: {
                return j0.D;
            }
            default: {
                return null;
            }
        }
    }
}

