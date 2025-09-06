package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Empty extends A1 implements m2 {
    private static final Empty DEFAULT_INSTANCE;
    private static volatile z2 PARSER;

    static {
        Empty empty0 = new Empty();
        Empty.DEFAULT_INSTANCE = empty0;
        A1.registerDefaultInstance(Empty.class, empty0);
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(Empty.DEFAULT_INSTANCE, "\u0000\u0000", null);
            }
            case 3: {
                return new Empty();
            }
            case 4: {
                return new Z0(Empty.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return Empty.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = Empty.PARSER;
                if(z20 == null) {
                    Class class0 = Empty.class;
                    synchronized(class0) {
                        z2 z21 = Empty.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            Empty.PARSER = z21;
                        }
                        return z21;
                    }
                }
                return z20;
            }
            default: {
                throw null;
            }
        }
    }

    public static Empty getDefaultInstance() {
        return Empty.DEFAULT_INSTANCE;
    }

    public static Z0 newBuilder() {
        return (Z0)Empty.DEFAULT_INSTANCE.createBuilder();
    }

    public static Z0 newBuilder(Empty empty0) {
        return (Z0)Empty.DEFAULT_INSTANCE.createBuilder(empty0);
    }

    public static Empty parseDelimitedFrom(InputStream inputStream0) {
        return (Empty)A1.parseDelimitedFrom(Empty.DEFAULT_INSTANCE, inputStream0);
    }

    public static Empty parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (Empty)A1.parseDelimitedFrom(Empty.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Empty parseFrom(o o0) {
        return (Empty)A1.parseFrom(Empty.DEFAULT_INSTANCE, o0);
    }

    public static Empty parseFrom(o o0, g1 g10) {
        return (Empty)A1.parseFrom(Empty.DEFAULT_INSTANCE, o0, g10);
    }

    public static Empty parseFrom(t t0) {
        return (Empty)A1.parseFrom(Empty.DEFAULT_INSTANCE, t0);
    }

    public static Empty parseFrom(t t0, g1 g10) {
        return (Empty)A1.parseFrom(Empty.DEFAULT_INSTANCE, t0, g10);
    }

    public static Empty parseFrom(InputStream inputStream0) {
        return (Empty)A1.parseFrom(Empty.DEFAULT_INSTANCE, inputStream0);
    }

    public static Empty parseFrom(InputStream inputStream0, g1 g10) {
        return (Empty)A1.parseFrom(Empty.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Empty parseFrom(ByteBuffer byteBuffer0) {
        return (Empty)A1.parseFrom(Empty.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static Empty parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (Empty)A1.parseFrom(Empty.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static Empty parseFrom(byte[] arr_b) {
        return (Empty)A1.parseFrom(Empty.DEFAULT_INSTANCE, arr_b);
    }

    public static Empty parseFrom(byte[] arr_b, g1 g10) {
        return (Empty)A1.parseFrom(Empty.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return Empty.DEFAULT_INSTANCE.getParserForType();
    }
}

