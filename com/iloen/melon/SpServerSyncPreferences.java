package com.iloen.melon;

import com.google.protobuf.A1;
import com.google.protobuf.b;
import com.google.protobuf.g1;
import com.google.protobuf.m2;
import com.google.protobuf.o;
import com.google.protobuf.t;
import com.google.protobuf.u1;
import com.google.protobuf.z1;
import com.google.protobuf.z2;
import java.io.InputStream;
import java.nio.ByteBuffer;
import k8.w1;

public final class SpServerSyncPreferences extends A1 implements m2 {
    private static final SpServerSyncPreferences DEFAULT_INSTANCE = null;
    public static final int LASTHISTORYREQDATE_FIELD_NUMBER = 9;
    public static final int MEMBERKEY_FIELD_NUMBER = 1;
    public static final int NOTSENTEDITCOUNT_FIELD_NUMBER = 4;
    private static volatile z2 PARSER = null;
    public static final int VERSIONDATE_FIELD_NUMBER = 2;
    public static final int VERSIONTHRESHOLD_FIELD_NUMBER = 3;
    private String lastHistoryReqDate_;
    private String memberKey_;
    private int notSentEditCount_;
    private long versionDate_;
    private int versionThreshold_;

    static {
        SpServerSyncPreferences spServerSyncPreferences0 = new SpServerSyncPreferences();
        SpServerSyncPreferences.DEFAULT_INSTANCE = spServerSyncPreferences0;
        A1.registerDefaultInstance(SpServerSyncPreferences.class, spServerSyncPreferences0);
    }

    private SpServerSyncPreferences() {
        this.memberKey_ = "";
        this.lastHistoryReqDate_ = "";
    }

    private void clearLastHistoryReqDate() {
        this.lastHistoryReqDate_ = "";
    }

    private void clearMemberKey() {
        this.memberKey_ = "";
    }

    private void clearNotSentEditCount() {
        this.notSentEditCount_ = 0;
    }

    private void clearVersionDate() {
        this.versionDate_ = 0L;
    }

    private void clearVersionThreshold() {
        this.versionThreshold_ = 0;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(SpServerSyncPreferences.DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\t\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\u0004\u0004\u0004\tȈ", new Object[]{"memberKey_", "versionDate_", "versionThreshold_", "notSentEditCount_", "lastHistoryReqDate_"});
            }
            case 3: {
                return new SpServerSyncPreferences();
            }
            case 4: {
                return new w1(SpServerSyncPreferences.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return SpServerSyncPreferences.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = SpServerSyncPreferences.PARSER;
                if(z20 == null) {
                    Class class0 = SpServerSyncPreferences.class;
                    synchronized(class0) {
                        z2 z21 = SpServerSyncPreferences.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            SpServerSyncPreferences.PARSER = z21;
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

    public static SpServerSyncPreferences getDefaultInstance() {
        return SpServerSyncPreferences.DEFAULT_INSTANCE;
    }

    public String getLastHistoryReqDate() [...] // 潜在的解密器

    public o getLastHistoryReqDateBytes() {
        return o.e(this.lastHistoryReqDate_);
    }

    public String getMemberKey() [...] // 潜在的解密器

    public o getMemberKeyBytes() {
        return o.e(this.memberKey_);
    }

    public int getNotSentEditCount() {
        return this.notSentEditCount_;
    }

    public long getVersionDate() {
        return this.versionDate_;
    }

    public int getVersionThreshold() {
        return this.versionThreshold_;
    }

    public static w1 newBuilder() {
        return (w1)SpServerSyncPreferences.DEFAULT_INSTANCE.createBuilder();
    }

    public static w1 newBuilder(SpServerSyncPreferences spServerSyncPreferences0) {
        return (w1)SpServerSyncPreferences.DEFAULT_INSTANCE.createBuilder(spServerSyncPreferences0);
    }

    public static SpServerSyncPreferences parseDelimitedFrom(InputStream inputStream0) {
        return (SpServerSyncPreferences)A1.parseDelimitedFrom(SpServerSyncPreferences.DEFAULT_INSTANCE, inputStream0);
    }

    public static SpServerSyncPreferences parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (SpServerSyncPreferences)A1.parseDelimitedFrom(SpServerSyncPreferences.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static SpServerSyncPreferences parseFrom(o o0) {
        return (SpServerSyncPreferences)A1.parseFrom(SpServerSyncPreferences.DEFAULT_INSTANCE, o0);
    }

    public static SpServerSyncPreferences parseFrom(o o0, g1 g10) {
        return (SpServerSyncPreferences)A1.parseFrom(SpServerSyncPreferences.DEFAULT_INSTANCE, o0, g10);
    }

    public static SpServerSyncPreferences parseFrom(t t0) {
        return (SpServerSyncPreferences)A1.parseFrom(SpServerSyncPreferences.DEFAULT_INSTANCE, t0);
    }

    public static SpServerSyncPreferences parseFrom(t t0, g1 g10) {
        return (SpServerSyncPreferences)A1.parseFrom(SpServerSyncPreferences.DEFAULT_INSTANCE, t0, g10);
    }

    public static SpServerSyncPreferences parseFrom(InputStream inputStream0) {
        return (SpServerSyncPreferences)A1.parseFrom(SpServerSyncPreferences.DEFAULT_INSTANCE, inputStream0);
    }

    public static SpServerSyncPreferences parseFrom(InputStream inputStream0, g1 g10) {
        return (SpServerSyncPreferences)A1.parseFrom(SpServerSyncPreferences.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static SpServerSyncPreferences parseFrom(ByteBuffer byteBuffer0) {
        return (SpServerSyncPreferences)A1.parseFrom(SpServerSyncPreferences.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static SpServerSyncPreferences parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (SpServerSyncPreferences)A1.parseFrom(SpServerSyncPreferences.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static SpServerSyncPreferences parseFrom(byte[] arr_b) {
        return (SpServerSyncPreferences)A1.parseFrom(SpServerSyncPreferences.DEFAULT_INSTANCE, arr_b);
    }

    public static SpServerSyncPreferences parseFrom(byte[] arr_b, g1 g10) {
        return (SpServerSyncPreferences)A1.parseFrom(SpServerSyncPreferences.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return SpServerSyncPreferences.DEFAULT_INSTANCE.getParserForType();
    }

    private void setLastHistoryReqDate(String s) {
        s.getClass();
        this.lastHistoryReqDate_ = s;
    }

    private void setLastHistoryReqDateBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.lastHistoryReqDate_ = o0.p();
    }

    private void setMemberKey(String s) {
        s.getClass();
        this.memberKey_ = s;
    }

    private void setMemberKeyBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.memberKey_ = o0.p();
    }

    private void setNotSentEditCount(int v) {
        this.notSentEditCount_ = v;
    }

    private void setVersionDate(long v) {
        this.versionDate_ = v;
    }

    private void setVersionThreshold(int v) {
        this.versionThreshold_ = v;
    }
}

