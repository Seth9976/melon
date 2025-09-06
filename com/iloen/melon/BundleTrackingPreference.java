package com.iloen.melon;

import com.google.protobuf.A1;
import com.google.protobuf.g1;
import com.google.protobuf.m2;
import com.google.protobuf.o;
import com.google.protobuf.t;
import com.google.protobuf.u1;
import com.google.protobuf.z1;
import com.google.protobuf.z2;
import java.io.InputStream;
import java.nio.ByteBuffer;
import k8.c;

public final class BundleTrackingPreference extends A1 implements m2 {
    public static final int BUNDLELIMITSIZE_FIELD_NUMBER = 1;
    private static final BundleTrackingPreference DEFAULT_INSTANCE;
    private static volatile z2 PARSER;
    private int bundleLimitSize_;

    static {
        BundleTrackingPreference bundleTrackingPreference0 = new BundleTrackingPreference();
        BundleTrackingPreference.DEFAULT_INSTANCE = bundleTrackingPreference0;
        A1.registerDefaultInstance(BundleTrackingPreference.class, bundleTrackingPreference0);
    }

    private void clearBundleLimitSize() {
        this.bundleLimitSize_ = 0;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(BundleTrackingPreference.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"bundleLimitSize_"});
            }
            case 3: {
                return new BundleTrackingPreference();
            }
            case 4: {
                return new c(BundleTrackingPreference.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return BundleTrackingPreference.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = BundleTrackingPreference.PARSER;
                if(z20 == null) {
                    Class class0 = BundleTrackingPreference.class;
                    synchronized(class0) {
                        z2 z21 = BundleTrackingPreference.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            BundleTrackingPreference.PARSER = z21;
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

    public static void f(BundleTrackingPreference bundleTrackingPreference0) {
        bundleTrackingPreference0.setBundleLimitSize(0x100000);
    }

    public int getBundleLimitSize() {
        return this.bundleLimitSize_;
    }

    public static BundleTrackingPreference getDefaultInstance() {
        return BundleTrackingPreference.DEFAULT_INSTANCE;
    }

    public static c newBuilder() {
        return (c)BundleTrackingPreference.DEFAULT_INSTANCE.createBuilder();
    }

    public static c newBuilder(BundleTrackingPreference bundleTrackingPreference0) {
        return (c)BundleTrackingPreference.DEFAULT_INSTANCE.createBuilder(bundleTrackingPreference0);
    }

    public static BundleTrackingPreference parseDelimitedFrom(InputStream inputStream0) {
        return (BundleTrackingPreference)A1.parseDelimitedFrom(BundleTrackingPreference.DEFAULT_INSTANCE, inputStream0);
    }

    public static BundleTrackingPreference parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (BundleTrackingPreference)A1.parseDelimitedFrom(BundleTrackingPreference.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static BundleTrackingPreference parseFrom(o o0) {
        return (BundleTrackingPreference)A1.parseFrom(BundleTrackingPreference.DEFAULT_INSTANCE, o0);
    }

    public static BundleTrackingPreference parseFrom(o o0, g1 g10) {
        return (BundleTrackingPreference)A1.parseFrom(BundleTrackingPreference.DEFAULT_INSTANCE, o0, g10);
    }

    public static BundleTrackingPreference parseFrom(t t0) {
        return (BundleTrackingPreference)A1.parseFrom(BundleTrackingPreference.DEFAULT_INSTANCE, t0);
    }

    public static BundleTrackingPreference parseFrom(t t0, g1 g10) {
        return (BundleTrackingPreference)A1.parseFrom(BundleTrackingPreference.DEFAULT_INSTANCE, t0, g10);
    }

    public static BundleTrackingPreference parseFrom(InputStream inputStream0) {
        return (BundleTrackingPreference)A1.parseFrom(BundleTrackingPreference.DEFAULT_INSTANCE, inputStream0);
    }

    public static BundleTrackingPreference parseFrom(InputStream inputStream0, g1 g10) {
        return (BundleTrackingPreference)A1.parseFrom(BundleTrackingPreference.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static BundleTrackingPreference parseFrom(ByteBuffer byteBuffer0) {
        return (BundleTrackingPreference)A1.parseFrom(BundleTrackingPreference.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static BundleTrackingPreference parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (BundleTrackingPreference)A1.parseFrom(BundleTrackingPreference.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static BundleTrackingPreference parseFrom(byte[] arr_b) {
        return (BundleTrackingPreference)A1.parseFrom(BundleTrackingPreference.DEFAULT_INSTANCE, arr_b);
    }

    public static BundleTrackingPreference parseFrom(byte[] arr_b, g1 g10) {
        return (BundleTrackingPreference)A1.parseFrom(BundleTrackingPreference.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return BundleTrackingPreference.DEFAULT_INSTANCE.getParserForType();
    }

    private void setBundleLimitSize(int v) {
        this.bundleLimitSize_ = v;
    }
}

