package com.iloen.melon;

import com.google.protobuf.A1;
import com.google.protobuf.g1;
import com.google.protobuf.g2;
import com.google.protobuf.m2;
import com.google.protobuf.o;
import com.google.protobuf.t;
import com.google.protobuf.u1;
import com.google.protobuf.z1;
import com.google.protobuf.z2;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import k8.r1;
import k8.s1;

public final class OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference extends A1 implements m2 {
    private static final OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference DEFAULT_INSTANCE = null;
    private static volatile z2 PARSER = null;
    public static final int PLAYLISTCHECKDATE_FIELD_NUMBER = 1;
    private g2 playlistCheckDate_;

    static {
        OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference offlineCacheCheckDatePref$OfflineCacheCheckDatePreference0 = new OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference();
        OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE = offlineCacheCheckDatePref$OfflineCacheCheckDatePreference0;
        A1.registerDefaultInstance(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.class, offlineCacheCheckDatePref$OfflineCacheCheckDatePreference0);
    }

    private OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference() {
        this.playlistCheckDate_ = g2.b;
    }

    public boolean containsPlaylistCheckDate(String s) {
        s.getClass();
        return this.internalGetPlaylistCheckDate().containsKey(s);
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"playlistCheckDate_", s1.a});
            }
            case 3: {
                return new OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference();
            }
            case 4: {
                return new r1(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.PARSER;
                if(z20 == null) {
                    Class class0 = OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.class;
                    synchronized(class0) {
                        z2 z21 = OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.PARSER = z21;
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

    public static OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference getDefaultInstance() {
        return OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE;
    }

    private Map getMutablePlaylistCheckDateMap() {
        return this.internalGetMutablePlaylistCheckDate();
    }

    @Deprecated
    public Map getPlaylistCheckDate() {
        return this.getPlaylistCheckDateMap();
    }

    public int getPlaylistCheckDateCount() {
        return this.internalGetPlaylistCheckDate().size();
    }

    public Map getPlaylistCheckDateMap() {
        return Collections.unmodifiableMap(this.internalGetPlaylistCheckDate());
    }

    public String getPlaylistCheckDateOrDefault(String s, String s1) {
        s.getClass();
        g2 g20 = this.internalGetPlaylistCheckDate();
        return g20.containsKey(s) ? ((String)g20.get(s)) : s1;
    }

    public String getPlaylistCheckDateOrThrow(String s) {
        s.getClass();
        g2 g20 = this.internalGetPlaylistCheckDate();
        if(!g20.containsKey(s)) {
            throw new IllegalArgumentException();
        }
        return (String)g20.get(s);
    }

    private g2 internalGetMutablePlaylistCheckDate() {
        g2 g20 = this.playlistCheckDate_;
        if(!g20.a) {
            this.playlistCheckDate_ = g20.c();
        }
        return this.playlistCheckDate_;
    }

    private g2 internalGetPlaylistCheckDate() {
        return this.playlistCheckDate_;
    }

    public static r1 newBuilder() {
        return (r1)OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE.createBuilder();
    }

    public static r1 newBuilder(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference offlineCacheCheckDatePref$OfflineCacheCheckDatePreference0) {
        return (r1)OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE.createBuilder(offlineCacheCheckDatePref$OfflineCacheCheckDatePreference0);
    }

    public static OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference parseDelimitedFrom(InputStream inputStream0) {
        return (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)A1.parseDelimitedFrom(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE, inputStream0);
    }

    public static OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)A1.parseDelimitedFrom(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference parseFrom(o o0) {
        return (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)A1.parseFrom(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE, o0);
    }

    public static OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference parseFrom(o o0, g1 g10) {
        return (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)A1.parseFrom(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE, o0, g10);
    }

    public static OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference parseFrom(t t0) {
        return (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)A1.parseFrom(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE, t0);
    }

    public static OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference parseFrom(t t0, g1 g10) {
        return (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)A1.parseFrom(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE, t0, g10);
    }

    public static OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference parseFrom(InputStream inputStream0) {
        return (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)A1.parseFrom(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE, inputStream0);
    }

    public static OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference parseFrom(InputStream inputStream0, g1 g10) {
        return (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)A1.parseFrom(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference parseFrom(ByteBuffer byteBuffer0) {
        return (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)A1.parseFrom(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)A1.parseFrom(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference parseFrom(byte[] arr_b) {
        return (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)A1.parseFrom(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE, arr_b);
    }

    public static OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference parseFrom(byte[] arr_b, g1 g10) {
        return (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)A1.parseFrom(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference.DEFAULT_INSTANCE.getParserForType();
    }
}

