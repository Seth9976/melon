package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class UInt32Value extends A1 implements m2 {
    private static final UInt32Value DEFAULT_INSTANCE = null;
    private static volatile z2 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;

    static {
        UInt32Value uInt32Value0 = new UInt32Value();
        UInt32Value.DEFAULT_INSTANCE = uInt32Value0;
        A1.registerDefaultInstance(UInt32Value.class, uInt32Value0);
    }

    public static void access$200(UInt32Value uInt32Value0) {
        uInt32Value0.clearValue();
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
                return A1.newMessageInfo(UInt32Value.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000B", new Object[]{"value_"});
            }
            case 3: {
                return new UInt32Value();
            }
            case 4: {
                return new P2(UInt32Value.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return UInt32Value.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = UInt32Value.PARSER;
                if(z20 == null) {
                    Class class0 = UInt32Value.class;
                    synchronized(class0) {
                        z2 z21 = UInt32Value.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            UInt32Value.PARSER = z21;
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

    public static UInt32Value getDefaultInstance() {
        return UInt32Value.DEFAULT_INSTANCE;
    }

    public int getValue() {
        return this.value_;
    }

    public static P2 newBuilder() {
        return (P2)UInt32Value.DEFAULT_INSTANCE.createBuilder();
    }

    public static P2 newBuilder(UInt32Value uInt32Value0) {
        return (P2)UInt32Value.DEFAULT_INSTANCE.createBuilder(uInt32Value0);
    }

    public static UInt32Value of(int v) {
        P2 p20 = UInt32Value.newBuilder();
        p20.d();
        ((UInt32Value)p20.b).setValue(v);
        return (UInt32Value)p20.a();
    }

    public static UInt32Value parseDelimitedFrom(InputStream inputStream0) {
        return (UInt32Value)A1.parseDelimitedFrom(UInt32Value.DEFAULT_INSTANCE, inputStream0);
    }

    public static UInt32Value parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (UInt32Value)A1.parseDelimitedFrom(UInt32Value.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static UInt32Value parseFrom(o o0) {
        return (UInt32Value)A1.parseFrom(UInt32Value.DEFAULT_INSTANCE, o0);
    }

    public static UInt32Value parseFrom(o o0, g1 g10) {
        return (UInt32Value)A1.parseFrom(UInt32Value.DEFAULT_INSTANCE, o0, g10);
    }

    public static UInt32Value parseFrom(t t0) {
        return (UInt32Value)A1.parseFrom(UInt32Value.DEFAULT_INSTANCE, t0);
    }

    public static UInt32Value parseFrom(t t0, g1 g10) {
        return (UInt32Value)A1.parseFrom(UInt32Value.DEFAULT_INSTANCE, t0, g10);
    }

    public static UInt32Value parseFrom(InputStream inputStream0) {
        return (UInt32Value)A1.parseFrom(UInt32Value.DEFAULT_INSTANCE, inputStream0);
    }

    public static UInt32Value parseFrom(InputStream inputStream0, g1 g10) {
        return (UInt32Value)A1.parseFrom(UInt32Value.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static UInt32Value parseFrom(ByteBuffer byteBuffer0) {
        return (UInt32Value)A1.parseFrom(UInt32Value.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static UInt32Value parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (UInt32Value)A1.parseFrom(UInt32Value.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static UInt32Value parseFrom(byte[] arr_b) {
        return (UInt32Value)A1.parseFrom(UInt32Value.DEFAULT_INSTANCE, arr_b);
    }

    public static UInt32Value parseFrom(byte[] arr_b, g1 g10) {
        return (UInt32Value)A1.parseFrom(UInt32Value.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return UInt32Value.DEFAULT_INSTANCE.getParserForType();
    }

    private void setValue(int v) {
        this.value_ = v;
    }
}

