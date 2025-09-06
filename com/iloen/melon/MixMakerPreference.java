package com.iloen.melon;

import com.google.protobuf.A1;
import com.google.protobuf.O1;
import com.google.protobuf.b;
import com.google.protobuf.c;
import com.google.protobuf.g1;
import com.google.protobuf.m2;
import com.google.protobuf.o;
import com.google.protobuf.t;
import com.google.protobuf.u1;
import com.google.protobuf.z1;
import com.google.protobuf.z2;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import k8.L;

public final class MixMakerPreference extends A1 implements m2 {
    private static final MixMakerPreference DEFAULT_INSTANCE = null;
    public static final int MIXTITLE_FIELD_NUMBER = 1;
    private static volatile z2 PARSER;
    private O1 mixTitle_;

    static {
        MixMakerPreference mixMakerPreference0 = new MixMakerPreference();
        MixMakerPreference.DEFAULT_INSTANCE = mixMakerPreference0;
        A1.registerDefaultInstance(MixMakerPreference.class, mixMakerPreference0);
    }

    private MixMakerPreference() {
        this.mixTitle_ = A1.emptyProtobufList();
    }

    private void addAllMixTitle(Iterable iterable0) {
        this.ensureMixTitleIsMutable();
        b.addAll(iterable0, this.mixTitle_);
    }

    private void addMixTitle(String s) {
        s.getClass();
        this.ensureMixTitleIsMutable();
        this.mixTitle_.add(s);
    }

    private void addMixTitleBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.ensureMixTitleIsMutable();
        this.mixTitle_.add(o0.p());
    }

    private void clearMixTitle() {
        this.mixTitle_ = A1.emptyProtobufList();
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(MixMakerPreference.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"mixTitle_"});
            }
            case 3: {
                return new MixMakerPreference();
            }
            case 4: {
                return new L(MixMakerPreference.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return MixMakerPreference.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = MixMakerPreference.PARSER;
                if(z20 == null) {
                    Class class0 = MixMakerPreference.class;
                    synchronized(class0) {
                        z2 z21 = MixMakerPreference.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            MixMakerPreference.PARSER = z21;
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

    private void ensureMixTitleIsMutable() {
        O1 o10 = this.mixTitle_;
        if(!((c)o10).a) {
            this.mixTitle_ = A1.mutableCopy(o10);
        }
    }

    public static MixMakerPreference getDefaultInstance() {
        return MixMakerPreference.DEFAULT_INSTANCE;
    }

    public String getMixTitle(int v) {
        return (String)this.mixTitle_.get(v);
    }

    public o getMixTitleBytes(int v) {
        return o.e(((String)this.mixTitle_.get(v)));
    }

    public int getMixTitleCount() {
        return this.mixTitle_.size();
    }

    public List getMixTitleList() {
        return this.mixTitle_;
    }

    public static L newBuilder() {
        return (L)MixMakerPreference.DEFAULT_INSTANCE.createBuilder();
    }

    public static L newBuilder(MixMakerPreference mixMakerPreference0) {
        return (L)MixMakerPreference.DEFAULT_INSTANCE.createBuilder(mixMakerPreference0);
    }

    public static MixMakerPreference parseDelimitedFrom(InputStream inputStream0) {
        return (MixMakerPreference)A1.parseDelimitedFrom(MixMakerPreference.DEFAULT_INSTANCE, inputStream0);
    }

    public static MixMakerPreference parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (MixMakerPreference)A1.parseDelimitedFrom(MixMakerPreference.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static MixMakerPreference parseFrom(o o0) {
        return (MixMakerPreference)A1.parseFrom(MixMakerPreference.DEFAULT_INSTANCE, o0);
    }

    public static MixMakerPreference parseFrom(o o0, g1 g10) {
        return (MixMakerPreference)A1.parseFrom(MixMakerPreference.DEFAULT_INSTANCE, o0, g10);
    }

    public static MixMakerPreference parseFrom(t t0) {
        return (MixMakerPreference)A1.parseFrom(MixMakerPreference.DEFAULT_INSTANCE, t0);
    }

    public static MixMakerPreference parseFrom(t t0, g1 g10) {
        return (MixMakerPreference)A1.parseFrom(MixMakerPreference.DEFAULT_INSTANCE, t0, g10);
    }

    public static MixMakerPreference parseFrom(InputStream inputStream0) {
        return (MixMakerPreference)A1.parseFrom(MixMakerPreference.DEFAULT_INSTANCE, inputStream0);
    }

    public static MixMakerPreference parseFrom(InputStream inputStream0, g1 g10) {
        return (MixMakerPreference)A1.parseFrom(MixMakerPreference.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static MixMakerPreference parseFrom(ByteBuffer byteBuffer0) {
        return (MixMakerPreference)A1.parseFrom(MixMakerPreference.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static MixMakerPreference parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (MixMakerPreference)A1.parseFrom(MixMakerPreference.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static MixMakerPreference parseFrom(byte[] arr_b) {
        return (MixMakerPreference)A1.parseFrom(MixMakerPreference.DEFAULT_INSTANCE, arr_b);
    }

    public static MixMakerPreference parseFrom(byte[] arr_b, g1 g10) {
        return (MixMakerPreference)A1.parseFrom(MixMakerPreference.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return MixMakerPreference.DEFAULT_INSTANCE.getParserForType();
    }

    private void setMixTitle(int v, String s) {
        s.getClass();
        this.ensureMixTitleIsMutable();
        this.mixTitle_.set(v, s);
    }
}

