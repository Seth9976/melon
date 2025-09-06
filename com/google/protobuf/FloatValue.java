package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class FloatValue extends A1 implements m2 {
    private static final FloatValue DEFAULT_INSTANCE = null;
    private static volatile z2 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private float value_;

    static {
        FloatValue floatValue0 = new FloatValue();
        FloatValue.DEFAULT_INSTANCE = floatValue0;
        A1.registerDefaultInstance(FloatValue.class, floatValue0);
    }

    public static void access$200(FloatValue floatValue0) {
        floatValue0.clearValue();
    }

    private void clearValue() {
        this.value_ = 0.0f;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(FloatValue.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001", new Object[]{"value_"});
            }
            case 3: {
                return new FloatValue();
            }
            case 4: {
                return new r1(FloatValue.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return FloatValue.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = FloatValue.PARSER;
                if(z20 == null) {
                    Class class0 = FloatValue.class;
                    synchronized(class0) {
                        z2 z21 = FloatValue.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            FloatValue.PARSER = z21;
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

    public static FloatValue getDefaultInstance() {
        return FloatValue.DEFAULT_INSTANCE;
    }

    public float getValue() {
        return this.value_;
    }

    public static r1 newBuilder() {
        return (r1)FloatValue.DEFAULT_INSTANCE.createBuilder();
    }

    public static r1 newBuilder(FloatValue floatValue0) {
        return (r1)FloatValue.DEFAULT_INSTANCE.createBuilder(floatValue0);
    }

    public static FloatValue of(float f) {
        r1 r10 = FloatValue.newBuilder();
        r10.d();
        ((FloatValue)r10.b).setValue(f);
        return (FloatValue)r10.a();
    }

    public static FloatValue parseDelimitedFrom(InputStream inputStream0) {
        return (FloatValue)A1.parseDelimitedFrom(FloatValue.DEFAULT_INSTANCE, inputStream0);
    }

    public static FloatValue parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (FloatValue)A1.parseDelimitedFrom(FloatValue.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static FloatValue parseFrom(o o0) {
        return (FloatValue)A1.parseFrom(FloatValue.DEFAULT_INSTANCE, o0);
    }

    public static FloatValue parseFrom(o o0, g1 g10) {
        return (FloatValue)A1.parseFrom(FloatValue.DEFAULT_INSTANCE, o0, g10);
    }

    public static FloatValue parseFrom(t t0) {
        return (FloatValue)A1.parseFrom(FloatValue.DEFAULT_INSTANCE, t0);
    }

    public static FloatValue parseFrom(t t0, g1 g10) {
        return (FloatValue)A1.parseFrom(FloatValue.DEFAULT_INSTANCE, t0, g10);
    }

    public static FloatValue parseFrom(InputStream inputStream0) {
        return (FloatValue)A1.parseFrom(FloatValue.DEFAULT_INSTANCE, inputStream0);
    }

    public static FloatValue parseFrom(InputStream inputStream0, g1 g10) {
        return (FloatValue)A1.parseFrom(FloatValue.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static FloatValue parseFrom(ByteBuffer byteBuffer0) {
        return (FloatValue)A1.parseFrom(FloatValue.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static FloatValue parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (FloatValue)A1.parseFrom(FloatValue.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static FloatValue parseFrom(byte[] arr_b) {
        return (FloatValue)A1.parseFrom(FloatValue.DEFAULT_INSTANCE, arr_b);
    }

    public static FloatValue parseFrom(byte[] arr_b, g1 g10) {
        return (FloatValue)A1.parseFrom(FloatValue.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return FloatValue.DEFAULT_INSTANCE.getParserForType();
    }

    private void setValue(float f) {
        this.value_ = f;
    }
}

