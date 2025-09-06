package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Duration extends A1 implements m2 {
    private static final Duration DEFAULT_INSTANCE = null;
    public static final int NANOS_FIELD_NUMBER = 2;
    private static volatile z2 PARSER = null;
    public static final int SECONDS_FIELD_NUMBER = 1;
    private int nanos_;
    private long seconds_;

    static {
        Duration duration0 = new Duration();
        Duration.DEFAULT_INSTANCE = duration0;
        A1.registerDefaultInstance(Duration.class, duration0);
    }

    public static void access$100(Duration duration0, long v) {
        duration0.setSeconds(v);
    }

    public static void access$200(Duration duration0) {
        duration0.clearSeconds();
    }

    public static void access$300(Duration duration0, int v) {
        duration0.setNanos(v);
    }

    public static void access$400(Duration duration0) {
        duration0.clearNanos();
    }

    private void clearNanos() {
        this.nanos_ = 0;
    }

    private void clearSeconds() {
        this.seconds_ = 0L;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(Duration.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"seconds_", "nanos_"});
            }
            case 3: {
                return new Duration();
            }
            case 4: {
                return new Y0(Duration.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return Duration.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = Duration.PARSER;
                if(z20 == null) {
                    Class class0 = Duration.class;
                    synchronized(class0) {
                        z2 z21 = Duration.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            Duration.PARSER = z21;
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

    public static Duration getDefaultInstance() {
        return Duration.DEFAULT_INSTANCE;
    }

    public int getNanos() {
        return this.nanos_;
    }

    public long getSeconds() {
        return this.seconds_;
    }

    public static Y0 newBuilder() {
        return (Y0)Duration.DEFAULT_INSTANCE.createBuilder();
    }

    public static Y0 newBuilder(Duration duration0) {
        return (Y0)Duration.DEFAULT_INSTANCE.createBuilder(duration0);
    }

    public static Duration parseDelimitedFrom(InputStream inputStream0) {
        return (Duration)A1.parseDelimitedFrom(Duration.DEFAULT_INSTANCE, inputStream0);
    }

    public static Duration parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (Duration)A1.parseDelimitedFrom(Duration.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Duration parseFrom(o o0) {
        return (Duration)A1.parseFrom(Duration.DEFAULT_INSTANCE, o0);
    }

    public static Duration parseFrom(o o0, g1 g10) {
        return (Duration)A1.parseFrom(Duration.DEFAULT_INSTANCE, o0, g10);
    }

    public static Duration parseFrom(t t0) {
        return (Duration)A1.parseFrom(Duration.DEFAULT_INSTANCE, t0);
    }

    public static Duration parseFrom(t t0, g1 g10) {
        return (Duration)A1.parseFrom(Duration.DEFAULT_INSTANCE, t0, g10);
    }

    public static Duration parseFrom(InputStream inputStream0) {
        return (Duration)A1.parseFrom(Duration.DEFAULT_INSTANCE, inputStream0);
    }

    public static Duration parseFrom(InputStream inputStream0, g1 g10) {
        return (Duration)A1.parseFrom(Duration.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Duration parseFrom(ByteBuffer byteBuffer0) {
        return (Duration)A1.parseFrom(Duration.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static Duration parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (Duration)A1.parseFrom(Duration.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static Duration parseFrom(byte[] arr_b) {
        return (Duration)A1.parseFrom(Duration.DEFAULT_INSTANCE, arr_b);
    }

    public static Duration parseFrom(byte[] arr_b, g1 g10) {
        return (Duration)A1.parseFrom(Duration.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return Duration.DEFAULT_INSTANCE.getParserForType();
    }

    private void setNanos(int v) {
        this.nanos_ = v;
    }

    private void setSeconds(long v) {
        this.seconds_ = v;
    }
}

