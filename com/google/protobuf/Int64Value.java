package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Int64Value extends A1 implements m2 {
    private static final Int64Value DEFAULT_INSTANCE = null;
    private static volatile z2 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private long value_;

    static {
        Int64Value int64Value0 = new Int64Value();
        Int64Value.DEFAULT_INSTANCE = int64Value0;
        A1.registerDefaultInstance(Int64Value.class, int64Value0);
    }

    public static void access$200(Int64Value int64Value0) {
        int64Value0.clearValue();
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
                return A1.newMessageInfo(Int64Value.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"value_"});
            }
            case 3: {
                return new Int64Value();
            }
            case 4: {
                return new C1(Int64Value.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return Int64Value.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = Int64Value.PARSER;
                if(z20 == null) {
                    Class class0 = Int64Value.class;
                    synchronized(class0) {
                        z2 z21 = Int64Value.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            Int64Value.PARSER = z21;
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

    public static Int64Value getDefaultInstance() {
        return Int64Value.DEFAULT_INSTANCE;
    }

    public long getValue() {
        return this.value_;
    }

    public static C1 newBuilder() {
        return (C1)Int64Value.DEFAULT_INSTANCE.createBuilder();
    }

    public static C1 newBuilder(Int64Value int64Value0) {
        return (C1)Int64Value.DEFAULT_INSTANCE.createBuilder(int64Value0);
    }

    public static Int64Value of(long v) {
        C1 c10 = Int64Value.newBuilder();
        c10.d();
        ((Int64Value)c10.b).setValue(v);
        return (Int64Value)c10.a();
    }

    public static Int64Value parseDelimitedFrom(InputStream inputStream0) {
        return (Int64Value)A1.parseDelimitedFrom(Int64Value.DEFAULT_INSTANCE, inputStream0);
    }

    public static Int64Value parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (Int64Value)A1.parseDelimitedFrom(Int64Value.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Int64Value parseFrom(o o0) {
        return (Int64Value)A1.parseFrom(Int64Value.DEFAULT_INSTANCE, o0);
    }

    public static Int64Value parseFrom(o o0, g1 g10) {
        return (Int64Value)A1.parseFrom(Int64Value.DEFAULT_INSTANCE, o0, g10);
    }

    public static Int64Value parseFrom(t t0) {
        return (Int64Value)A1.parseFrom(Int64Value.DEFAULT_INSTANCE, t0);
    }

    public static Int64Value parseFrom(t t0, g1 g10) {
        return (Int64Value)A1.parseFrom(Int64Value.DEFAULT_INSTANCE, t0, g10);
    }

    public static Int64Value parseFrom(InputStream inputStream0) {
        return (Int64Value)A1.parseFrom(Int64Value.DEFAULT_INSTANCE, inputStream0);
    }

    public static Int64Value parseFrom(InputStream inputStream0, g1 g10) {
        return (Int64Value)A1.parseFrom(Int64Value.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Int64Value parseFrom(ByteBuffer byteBuffer0) {
        return (Int64Value)A1.parseFrom(Int64Value.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static Int64Value parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (Int64Value)A1.parseFrom(Int64Value.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static Int64Value parseFrom(byte[] arr_b) {
        return (Int64Value)A1.parseFrom(Int64Value.DEFAULT_INSTANCE, arr_b);
    }

    public static Int64Value parseFrom(byte[] arr_b, g1 g10) {
        return (Int64Value)A1.parseFrom(Int64Value.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return Int64Value.DEFAULT_INSTANCE.getParserForType();
    }

    private void setValue(long v) {
        this.value_ = v;
    }
}

