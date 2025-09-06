package com.iloen.melon;

import com.google.protobuf.A1;
import com.google.protobuf.g1;
import com.google.protobuf.g2;
import com.google.protobuf.m2;
import com.google.protobuf.o;
import com.google.protobuf.t;
import com.google.protobuf.z1;
import com.google.protobuf.z2;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import k8.u1;
import k8.v1;

public final class SpMemberSettingPreferences extends A1 implements m2 {
    private static final SpMemberSettingPreferences DEFAULT_INSTANCE = null;
    private static volatile z2 PARSER = null;
    public static final int SPMEMBERSETTINGS_FIELD_NUMBER = 1;
    private g2 spMemberSettings_;

    static {
        SpMemberSettingPreferences spMemberSettingPreferences0 = new SpMemberSettingPreferences();
        SpMemberSettingPreferences.DEFAULT_INSTANCE = spMemberSettingPreferences0;
        A1.registerDefaultInstance(SpMemberSettingPreferences.class, spMemberSettingPreferences0);
    }

    private SpMemberSettingPreferences() {
        this.spMemberSettings_ = g2.b;
    }

    public boolean containsSpMemberSettings(String s) {
        s.getClass();
        return this.internalGetSpMemberSettings().containsKey(s);
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(SpMemberSettingPreferences.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"spMemberSettings_", v1.a});
            }
            case 3: {
                return new SpMemberSettingPreferences();
            }
            case 4: {
                return new u1(SpMemberSettingPreferences.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return SpMemberSettingPreferences.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = SpMemberSettingPreferences.PARSER;
                if(z20 == null) {
                    Class class0 = SpMemberSettingPreferences.class;
                    synchronized(class0) {
                        z2 z21 = SpMemberSettingPreferences.PARSER;
                        if(z21 == null) {
                            z21 = new com.google.protobuf.u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            SpMemberSettingPreferences.PARSER = z21;
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

    public static SpMemberSettingPreferences getDefaultInstance() {
        return SpMemberSettingPreferences.DEFAULT_INSTANCE;
    }

    private Map getMutableSpMemberSettingsMap() {
        return this.internalGetMutableSpMemberSettings();
    }

    @Deprecated
    public Map getSpMemberSettings() {
        return this.getSpMemberSettingsMap();
    }

    public int getSpMemberSettingsCount() {
        return this.internalGetSpMemberSettings().size();
    }

    public Map getSpMemberSettingsMap() {
        return Collections.unmodifiableMap(this.internalGetSpMemberSettings());
    }

    public boolean getSpMemberSettingsOrDefault(String s, boolean z) {
        s.getClass();
        g2 g20 = this.internalGetSpMemberSettings();
        return g20.containsKey(s) ? ((Boolean)g20.get(s)).booleanValue() : z;
    }

    public boolean getSpMemberSettingsOrThrow(String s) {
        s.getClass();
        g2 g20 = this.internalGetSpMemberSettings();
        if(!g20.containsKey(s)) {
            throw new IllegalArgumentException();
        }
        return ((Boolean)g20.get(s)).booleanValue();
    }

    private g2 internalGetMutableSpMemberSettings() {
        g2 g20 = this.spMemberSettings_;
        if(!g20.a) {
            this.spMemberSettings_ = g20.c();
        }
        return this.spMemberSettings_;
    }

    private g2 internalGetSpMemberSettings() {
        return this.spMemberSettings_;
    }

    public static u1 newBuilder() {
        return (u1)SpMemberSettingPreferences.DEFAULT_INSTANCE.createBuilder();
    }

    public static u1 newBuilder(SpMemberSettingPreferences spMemberSettingPreferences0) {
        return (u1)SpMemberSettingPreferences.DEFAULT_INSTANCE.createBuilder(spMemberSettingPreferences0);
    }

    public static SpMemberSettingPreferences parseDelimitedFrom(InputStream inputStream0) {
        return (SpMemberSettingPreferences)A1.parseDelimitedFrom(SpMemberSettingPreferences.DEFAULT_INSTANCE, inputStream0);
    }

    public static SpMemberSettingPreferences parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (SpMemberSettingPreferences)A1.parseDelimitedFrom(SpMemberSettingPreferences.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static SpMemberSettingPreferences parseFrom(o o0) {
        return (SpMemberSettingPreferences)A1.parseFrom(SpMemberSettingPreferences.DEFAULT_INSTANCE, o0);
    }

    public static SpMemberSettingPreferences parseFrom(o o0, g1 g10) {
        return (SpMemberSettingPreferences)A1.parseFrom(SpMemberSettingPreferences.DEFAULT_INSTANCE, o0, g10);
    }

    public static SpMemberSettingPreferences parseFrom(t t0) {
        return (SpMemberSettingPreferences)A1.parseFrom(SpMemberSettingPreferences.DEFAULT_INSTANCE, t0);
    }

    public static SpMemberSettingPreferences parseFrom(t t0, g1 g10) {
        return (SpMemberSettingPreferences)A1.parseFrom(SpMemberSettingPreferences.DEFAULT_INSTANCE, t0, g10);
    }

    public static SpMemberSettingPreferences parseFrom(InputStream inputStream0) {
        return (SpMemberSettingPreferences)A1.parseFrom(SpMemberSettingPreferences.DEFAULT_INSTANCE, inputStream0);
    }

    public static SpMemberSettingPreferences parseFrom(InputStream inputStream0, g1 g10) {
        return (SpMemberSettingPreferences)A1.parseFrom(SpMemberSettingPreferences.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static SpMemberSettingPreferences parseFrom(ByteBuffer byteBuffer0) {
        return (SpMemberSettingPreferences)A1.parseFrom(SpMemberSettingPreferences.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static SpMemberSettingPreferences parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (SpMemberSettingPreferences)A1.parseFrom(SpMemberSettingPreferences.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static SpMemberSettingPreferences parseFrom(byte[] arr_b) {
        return (SpMemberSettingPreferences)A1.parseFrom(SpMemberSettingPreferences.DEFAULT_INSTANCE, arr_b);
    }

    public static SpMemberSettingPreferences parseFrom(byte[] arr_b, g1 g10) {
        return (SpMemberSettingPreferences)A1.parseFrom(SpMemberSettingPreferences.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return SpMemberSettingPreferences.DEFAULT_INSTANCE.getParserForType();
    }
}

