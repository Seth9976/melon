package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Int32Value extends A1 implements m2 {
    private static final Int32Value DEFAULT_INSTANCE = null;
    private static volatile z2 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;

    static {
        Int32Value int32Value0 = new Int32Value();
        Int32Value.DEFAULT_INSTANCE = int32Value0;
        A1.registerDefaultInstance(Int32Value.class, int32Value0);
    }

    public static void access$200(Int32Value int32Value0) {
        int32Value0.clearValue();
    }

    private void clearValue() {
        this.value_ = 0;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(Int32Value.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"value_"});
            }
            case 3: {
                return new Int32Value();
            }
            case 4: {
                return new B1(Int32Value.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return Int32Value.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = Int32Value.PARSER;
                if(z20 == null) {
                    Class class0 = Int32Value.class;
                    synchronized(class0) {
                        z2 z21 = Int32Value.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            Int32Value.PARSER = z21;
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

    public static Int32Value getDefaultInstance() {
        return Int32Value.DEFAULT_INSTANCE;
    }

    public int getValue() {
        return this.value_;
    }

    public static B1 newBuilder() {
        return (B1)Int32Value.DEFAULT_INSTANCE.createBuilder();
    }

    public static B1 newBuilder(Int32Value int32Value0) {
        return (B1)Int32Value.DEFAULT_INSTANCE.createBuilder(int32Value0);
    }

    public static Int32Value of(int v) {
        B1 b10 = Int32Value.newBuilder();
        b10.d();
        ((Int32Value)b10.b).setValue(v);
        return (Int32Value)b10.a();
    }

    public static Int32Value parseDelimitedFrom(InputStream inputStream0) {
        return (Int32Value)A1.parseDelimitedFrom(Int32Value.DEFAULT_INSTANCE, inputStream0);
    }

    public static Int32Value parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (Int32Value)A1.parseDelimitedFrom(Int32Value.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Int32Value parseFrom(o o0) {
        return (Int32Value)A1.parseFrom(Int32Value.DEFAULT_INSTANCE, o0);
    }

    public static Int32Value parseFrom(o o0, g1 g10) {
        return (Int32Value)A1.parseFrom(Int32Value.DEFAULT_INSTANCE, o0, g10);
    }

    public static Int32Value parseFrom(t t0) {
        return (Int32Value)A1.parseFrom(Int32Value.DEFAULT_INSTANCE, t0);
    }

    public static Int32Value parseFrom(t t0, g1 g10) {
        return (Int32Value)A1.parseFrom(Int32Value.DEFAULT_INSTANCE, t0, g10);
    }

    public static Int32Value parseFrom(InputStream inputStream0) {
        return (Int32Value)A1.parseFrom(Int32Value.DEFAULT_INSTANCE, inputStream0);
    }

    public static Int32Value parseFrom(InputStream inputStream0, g1 g10) {
        return (Int32Value)A1.parseFrom(Int32Value.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Int32Value parseFrom(ByteBuffer byteBuffer0) {
        return (Int32Value)A1.parseFrom(Int32Value.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static Int32Value parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (Int32Value)A1.parseFrom(Int32Value.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static Int32Value parseFrom(byte[] arr_b) {
        return (Int32Value)A1.parseFrom(Int32Value.DEFAULT_INSTANCE, arr_b);
    }

    public static Int32Value parseFrom(byte[] arr_b, g1 g10) {
        return (Int32Value)A1.parseFrom(Int32Value.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return Int32Value.DEFAULT_INSTANCE.getParserForType();
    }

    private void setValue(int v) {
        this.value_ = v;
    }
}

