package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class UInt64Value extends A1 implements m2 {
    private static final UInt64Value DEFAULT_INSTANCE = null;
    private static volatile z2 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private long value_;

    static {
        UInt64Value uInt64Value0 = new UInt64Value();
        UInt64Value.DEFAULT_INSTANCE = uInt64Value0;
        A1.registerDefaultInstance(UInt64Value.class, uInt64Value0);
    }

    public static void access$200(UInt64Value uInt64Value0) {
        uInt64Value0.clearValue();
    }

    private void clearValue() {
        this.value_ = 0L;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(UInt64Value.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0003", new Object[]{"value_"});
            }
            case 3: {
                return new UInt64Value();
            }
            case 4: {
                return new Q2(UInt64Value.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return UInt64Value.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = UInt64Value.PARSER;
                if(z20 == null) {
                    Class class0 = UInt64Value.class;
                    synchronized(class0) {
                        z2 z21 = UInt64Value.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            UInt64Value.PARSER = z21;
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

    public static UInt64Value getDefaultInstance() {
        return UInt64Value.DEFAULT_INSTANCE;
    }

    public long getValue() {
        return this.value_;
    }

    public static Q2 newBuilder() {
        return (Q2)UInt64Value.DEFAULT_INSTANCE.createBuilder();
    }

    public static Q2 newBuilder(UInt64Value uInt64Value0) {
        return (Q2)UInt64Value.DEFAULT_INSTANCE.createBuilder(uInt64Value0);
    }

    public static UInt64Value of(long v) {
        Q2 q20 = UInt64Value.newBuilder();
        q20.d();
        ((UInt64Value)q20.b).setValue(v);
        return (UInt64Value)q20.a();
    }

    public static UInt64Value parseDelimitedFrom(InputStream inputStream0) {
        return (UInt64Value)A1.parseDelimitedFrom(UInt64Value.DEFAULT_INSTANCE, inputStream0);
    }

    public static UInt64Value parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (UInt64Value)A1.parseDelimitedFrom(UInt64Value.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static UInt64Value parseFrom(o o0) {
        return (UInt64Value)A1.parseFrom(UInt64Value.DEFAULT_INSTANCE, o0);
    }

    public static UInt64Value parseFrom(o o0, g1 g10) {
        return (UInt64Value)A1.parseFrom(UInt64Value.DEFAULT_INSTANCE, o0, g10);
    }

    public static UInt64Value parseFrom(t t0) {
        return (UInt64Value)A1.parseFrom(UInt64Value.DEFAULT_INSTANCE, t0);
    }

    public static UInt64Value parseFrom(t t0, g1 g10) {
        return (UInt64Value)A1.parseFrom(UInt64Value.DEFAULT_INSTANCE, t0, g10);
    }

    public static UInt64Value parseFrom(InputStream inputStream0) {
        return (UInt64Value)A1.parseFrom(UInt64Value.DEFAULT_INSTANCE, inputStream0);
    }

    public static UInt64Value parseFrom(InputStream inputStream0, g1 g10) {
        return (UInt64Value)A1.parseFrom(UInt64Value.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static UInt64Value parseFrom(ByteBuffer byteBuffer0) {
        return (UInt64Value)A1.parseFrom(UInt64Value.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static UInt64Value parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (UInt64Value)A1.parseFrom(UInt64Value.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static UInt64Value parseFrom(byte[] arr_b) {
        return (UInt64Value)A1.parseFrom(UInt64Value.DEFAULT_INSTANCE, arr_b);
    }

    public static UInt64Value parseFrom(byte[] arr_b, g1 g10) {
        return (UInt64Value)A1.parseFrom(UInt64Value.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return UInt64Value.DEFAULT_INSTANCE.getParserForType();
    }

    private void setValue(long v) {
        this.value_ = v;
    }
}

