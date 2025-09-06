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
import k8.d;

public final class CommonPlytSettingPreferences extends A1 implements m2 {
    private static final CommonPlytSettingPreferences DEFAULT_INSTANCE = null;
    public static final int ISSHUFFLE_FIELD_NUMBER = 2;
    private static volatile z2 PARSER = null;
    public static final int REPEATMODE_FIELD_NUMBER = 1;
    private boolean isShuffle_;
    private int repeatMode_;

    static {
        CommonPlytSettingPreferences commonPlytSettingPreferences0 = new CommonPlytSettingPreferences();
        CommonPlytSettingPreferences.DEFAULT_INSTANCE = commonPlytSettingPreferences0;
        A1.registerDefaultInstance(CommonPlytSettingPreferences.class, commonPlytSettingPreferences0);
    }

    private void clearIsShuffle() {
        this.isShuffle_ = false;
    }

    private void clearRepeatMode() {
        this.repeatMode_ = 0;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(CommonPlytSettingPreferences.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0007", new Object[]{"repeatMode_", "isShuffle_"});
            }
            case 3: {
                return new CommonPlytSettingPreferences();
            }
            case 4: {
                return new d(CommonPlytSettingPreferences.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return CommonPlytSettingPreferences.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = CommonPlytSettingPreferences.PARSER;
                if(z20 == null) {
                    Class class0 = CommonPlytSettingPreferences.class;
                    synchronized(class0) {
                        z2 z21 = CommonPlytSettingPreferences.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            CommonPlytSettingPreferences.PARSER = z21;
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

    public static CommonPlytSettingPreferences getDefaultInstance() {
        return CommonPlytSettingPreferences.DEFAULT_INSTANCE;
    }

    public boolean getIsShuffle() {
        return this.isShuffle_;
    }

    public int getRepeatMode() {
        return this.repeatMode_;
    }

    public static d newBuilder() {
        return (d)CommonPlytSettingPreferences.DEFAULT_INSTANCE.createBuilder();
    }

    public static d newBuilder(CommonPlytSettingPreferences commonPlytSettingPreferences0) {
        return (d)CommonPlytSettingPreferences.DEFAULT_INSTANCE.createBuilder(commonPlytSettingPreferences0);
    }

    public static CommonPlytSettingPreferences parseDelimitedFrom(InputStream inputStream0) {
        return (CommonPlytSettingPreferences)A1.parseDelimitedFrom(CommonPlytSettingPreferences.DEFAULT_INSTANCE, inputStream0);
    }

    public static CommonPlytSettingPreferences parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (CommonPlytSettingPreferences)A1.parseDelimitedFrom(CommonPlytSettingPreferences.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static CommonPlytSettingPreferences parseFrom(o o0) {
        return (CommonPlytSettingPreferences)A1.parseFrom(CommonPlytSettingPreferences.DEFAULT_INSTANCE, o0);
    }

    public static CommonPlytSettingPreferences parseFrom(o o0, g1 g10) {
        return (CommonPlytSettingPreferences)A1.parseFrom(CommonPlytSettingPreferences.DEFAULT_INSTANCE, o0, g10);
    }

    public static CommonPlytSettingPreferences parseFrom(t t0) {
        return (CommonPlytSettingPreferences)A1.parseFrom(CommonPlytSettingPreferences.DEFAULT_INSTANCE, t0);
    }

    public static CommonPlytSettingPreferences parseFrom(t t0, g1 g10) {
        return (CommonPlytSettingPreferences)A1.parseFrom(CommonPlytSettingPreferences.DEFAULT_INSTANCE, t0, g10);
    }

    public static CommonPlytSettingPreferences parseFrom(InputStream inputStream0) {
        return (CommonPlytSettingPreferences)A1.parseFrom(CommonPlytSettingPreferences.DEFAULT_INSTANCE, inputStream0);
    }

    public static CommonPlytSettingPreferences parseFrom(InputStream inputStream0, g1 g10) {
        return (CommonPlytSettingPreferences)A1.parseFrom(CommonPlytSettingPreferences.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static CommonPlytSettingPreferences parseFrom(ByteBuffer byteBuffer0) {
        return (CommonPlytSettingPreferences)A1.parseFrom(CommonPlytSettingPreferences.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static CommonPlytSettingPreferences parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (CommonPlytSettingPreferences)A1.parseFrom(CommonPlytSettingPreferences.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static CommonPlytSettingPreferences parseFrom(byte[] arr_b) {
        return (CommonPlytSettingPreferences)A1.parseFrom(CommonPlytSettingPreferences.DEFAULT_INSTANCE, arr_b);
    }

    public static CommonPlytSettingPreferences parseFrom(byte[] arr_b, g1 g10) {
        return (CommonPlytSettingPreferences)A1.parseFrom(CommonPlytSettingPreferences.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return CommonPlytSettingPreferences.DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsShuffle(boolean z) {
        this.isShuffle_ = z;
    }

    private void setRepeatMode(int v) {
        this.repeatMode_ = v;
    }
}

