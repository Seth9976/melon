package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DoubleValue extends A1 implements m2 {
    private static final DoubleValue DEFAULT_INSTANCE = null;
    private static volatile z2 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private double value_;

    static {
        DoubleValue doubleValue0 = new DoubleValue();
        DoubleValue.DEFAULT_INSTANCE = doubleValue0;
        A1.registerDefaultInstance(DoubleValue.class, doubleValue0);
    }

    public static void access$200(DoubleValue doubleValue0) {
        doubleValue0.clearValue();
    }

    private void clearValue() {
        this.value_ = 0.0;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(DoubleValue.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0000", new Object[]{"value_"});
            }
            case 3: {
                return new DoubleValue();
            }
            case 4: {
                return new X0(DoubleValue.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DoubleValue.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DoubleValue.PARSER;
                if(z20 == null) {
                    Class class0 = DoubleValue.class;
                    synchronized(class0) {
                        z2 z21 = DoubleValue.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DoubleValue.PARSER = z21;
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

    public static DoubleValue getDefaultInstance() {
        return DoubleValue.DEFAULT_INSTANCE;
    }

    public double getValue() {
        return this.value_;
    }

    public static X0 newBuilder() {
        return (X0)DoubleValue.DEFAULT_INSTANCE.createBuilder();
    }

    public static X0 newBuilder(DoubleValue doubleValue0) {
        return (X0)DoubleValue.DEFAULT_INSTANCE.createBuilder(doubleValue0);
    }

    public static DoubleValue of(double f) {
        X0 x00 = DoubleValue.newBuilder();
        x00.d();
        ((DoubleValue)x00.b).setValue(f);
        return (DoubleValue)x00.a();
    }

    public static DoubleValue parseDelimitedFrom(InputStream inputStream0) {
        return (DoubleValue)A1.parseDelimitedFrom(DoubleValue.DEFAULT_INSTANCE, inputStream0);
    }

    public static DoubleValue parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DoubleValue)A1.parseDelimitedFrom(DoubleValue.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DoubleValue parseFrom(o o0) {
        return (DoubleValue)A1.parseFrom(DoubleValue.DEFAULT_INSTANCE, o0);
    }

    public static DoubleValue parseFrom(o o0, g1 g10) {
        return (DoubleValue)A1.parseFrom(DoubleValue.DEFAULT_INSTANCE, o0, g10);
    }

    public static DoubleValue parseFrom(t t0) {
        return (DoubleValue)A1.parseFrom(DoubleValue.DEFAULT_INSTANCE, t0);
    }

    public static DoubleValue parseFrom(t t0, g1 g10) {
        return (DoubleValue)A1.parseFrom(DoubleValue.DEFAULT_INSTANCE, t0, g10);
    }

    public static DoubleValue parseFrom(InputStream inputStream0) {
        return (DoubleValue)A1.parseFrom(DoubleValue.DEFAULT_INSTANCE, inputStream0);
    }

    public static DoubleValue parseFrom(InputStream inputStream0, g1 g10) {
        return (DoubleValue)A1.parseFrom(DoubleValue.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DoubleValue parseFrom(ByteBuffer byteBuffer0) {
        return (DoubleValue)A1.parseFrom(DoubleValue.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DoubleValue parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DoubleValue)A1.parseFrom(DoubleValue.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DoubleValue parseFrom(byte[] arr_b) {
        return (DoubleValue)A1.parseFrom(DoubleValue.DEFAULT_INSTANCE, arr_b);
    }

    public static DoubleValue parseFrom(byte[] arr_b, g1 g10) {
        return (DoubleValue)A1.parseFrom(DoubleValue.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DoubleValue.DEFAULT_INSTANCE.getParserForType();
    }

    private void setValue(double f) {
        this.value_ = f;
    }
}

