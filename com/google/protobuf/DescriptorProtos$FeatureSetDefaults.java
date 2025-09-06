package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.FeatureSetDefaults extends A1 implements m2 {
    public static final class FeatureSetEditionDefault extends A1 implements g0 {
        private static final FeatureSetEditionDefault DEFAULT_INSTANCE = null;
        public static final int EDITION_FIELD_NUMBER = 3;
        public static final int FIXED_FEATURES_FIELD_NUMBER = 5;
        public static final int OVERRIDABLE_FEATURES_FIELD_NUMBER = 4;
        private static volatile z2 PARSER;
        private int bitField0_;
        private int edition_;
        private DescriptorProtos.FeatureSet fixedFeatures_;
        private byte memoizedIsInitialized;
        private DescriptorProtos.FeatureSet overridableFeatures_;

        static {
            FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0 = new FeatureSetEditionDefault();
            FeatureSetEditionDefault.DEFAULT_INSTANCE = descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0;
            A1.registerDefaultInstance(FeatureSetEditionDefault.class, descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0);
        }

        private FeatureSetEditionDefault() {
            this.memoizedIsInitialized = 2;
        }

        public static void access$55100(FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0, F f0) {
            descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0.setEdition(f0);
        }

        public static void access$55200(FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0) {
            descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0.clearEdition();
        }

        public static void access$55300(FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
            descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0.setOverridableFeatures(descriptorProtos$FeatureSet0);
        }

        public static void access$55400(FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
            descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0.mergeOverridableFeatures(descriptorProtos$FeatureSet0);
        }

        public static void access$55500(FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0) {
            descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0.clearOverridableFeatures();
        }

        public static void access$55600(FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
            descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0.setFixedFeatures(descriptorProtos$FeatureSet0);
        }

        public static void access$55700(FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
            descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0.mergeFixedFeatures(descriptorProtos$FeatureSet0);
        }

        public static void access$55800(FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0) {
            descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0.clearFixedFeatures();
        }

        private void clearEdition() {
            this.bitField0_ &= -2;
            this.edition_ = 0;
        }

        private void clearFixedFeatures() {
            this.fixedFeatures_ = null;
            this.bitField0_ &= -5;
        }

        private void clearOverridableFeatures() {
            this.overridableFeatures_ = null;
            this.bitField0_ &= -3;
        }

        @Override  // com.google.protobuf.A1
        public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
            switch(z10.ordinal()) {
                case 0: {
                    return this.memoizedIsInitialized;
                }
                case 1: {
                    this.memoizedIsInitialized = (byte)(object0 == null ? 0 : 1);
                    return null;
                }
                case 2: {
                    return A1.newMessageInfo(FeatureSetEditionDefault.DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0003\u0005\u0003\u0000\u0000\u0002\u0003᠌\u0000\u0004ᐉ\u0001\u0005ᐉ\u0002", new Object[]{"bitField0_", "edition_", E.b, "overridableFeatures_", "fixedFeatures_"});
                }
                case 3: {
                    return new FeatureSetEditionDefault();
                }
                case 4: {
                    return new f0(FeatureSetEditionDefault.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
                }
                case 5: {
                    return FeatureSetEditionDefault.DEFAULT_INSTANCE;
                }
                case 6: {
                    z2 z20 = FeatureSetEditionDefault.PARSER;
                    if(z20 == null) {
                        Class class0 = FeatureSetEditionDefault.class;
                        synchronized(class0) {
                            z2 z21 = FeatureSetEditionDefault.PARSER;
                            if(z21 == null) {
                                z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                                FeatureSetEditionDefault.PARSER = z21;
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

        public static FeatureSetEditionDefault getDefaultInstance() {
            return FeatureSetEditionDefault.DEFAULT_INSTANCE;
        }

        public F getEdition() {
            F f0 = F.b(this.edition_);
            return f0 == null ? F.b : f0;
        }

        public DescriptorProtos.FeatureSet getFixedFeatures() {
            return this.fixedFeatures_ == null ? DescriptorProtos.FeatureSet.getDefaultInstance() : this.fixedFeatures_;
        }

        public DescriptorProtos.FeatureSet getOverridableFeatures() {
            return this.overridableFeatures_ == null ? DescriptorProtos.FeatureSet.getDefaultInstance() : this.overridableFeatures_;
        }

        public boolean hasEdition() {
            return (this.bitField0_ & 1) != 0;
        }

        public boolean hasFixedFeatures() {
            return (this.bitField0_ & 4) != 0;
        }

        public boolean hasOverridableFeatures() {
            return (this.bitField0_ & 2) != 0;
        }

        private void mergeFixedFeatures(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
            descriptorProtos$FeatureSet0.getClass();
            if(this.fixedFeatures_ == null || this.fixedFeatures_ == DescriptorProtos.FeatureSet.getDefaultInstance()) {
                this.fixedFeatures_ = descriptorProtos$FeatureSet0;
            }
            else {
                T t0 = DescriptorProtos.FeatureSet.newBuilder(this.fixedFeatures_);
                t0.f(descriptorProtos$FeatureSet0);
                this.fixedFeatures_ = (DescriptorProtos.FeatureSet)t0.i();
            }
            this.bitField0_ |= 4;
        }

        private void mergeOverridableFeatures(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
            descriptorProtos$FeatureSet0.getClass();
            if(this.overridableFeatures_ == null || this.overridableFeatures_ == DescriptorProtos.FeatureSet.getDefaultInstance()) {
                this.overridableFeatures_ = descriptorProtos$FeatureSet0;
            }
            else {
                T t0 = DescriptorProtos.FeatureSet.newBuilder(this.overridableFeatures_);
                t0.f(descriptorProtos$FeatureSet0);
                this.overridableFeatures_ = (DescriptorProtos.FeatureSet)t0.i();
            }
            this.bitField0_ |= 2;
        }

        public static f0 newBuilder() {
            return (f0)FeatureSetEditionDefault.DEFAULT_INSTANCE.createBuilder();
        }

        public static f0 newBuilder(FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0) {
            return (f0)FeatureSetEditionDefault.DEFAULT_INSTANCE.createBuilder(descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0);
        }

        public static FeatureSetEditionDefault parseDelimitedFrom(InputStream inputStream0) {
            return (FeatureSetEditionDefault)A1.parseDelimitedFrom(FeatureSetEditionDefault.DEFAULT_INSTANCE, inputStream0);
        }

        public static FeatureSetEditionDefault parseDelimitedFrom(InputStream inputStream0, g1 g10) {
            return (FeatureSetEditionDefault)A1.parseDelimitedFrom(FeatureSetEditionDefault.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static FeatureSetEditionDefault parseFrom(o o0) {
            return (FeatureSetEditionDefault)A1.parseFrom(FeatureSetEditionDefault.DEFAULT_INSTANCE, o0);
        }

        public static FeatureSetEditionDefault parseFrom(o o0, g1 g10) {
            return (FeatureSetEditionDefault)A1.parseFrom(FeatureSetEditionDefault.DEFAULT_INSTANCE, o0, g10);
        }

        public static FeatureSetEditionDefault parseFrom(t t0) {
            return (FeatureSetEditionDefault)A1.parseFrom(FeatureSetEditionDefault.DEFAULT_INSTANCE, t0);
        }

        public static FeatureSetEditionDefault parseFrom(t t0, g1 g10) {
            return (FeatureSetEditionDefault)A1.parseFrom(FeatureSetEditionDefault.DEFAULT_INSTANCE, t0, g10);
        }

        public static FeatureSetEditionDefault parseFrom(InputStream inputStream0) {
            return (FeatureSetEditionDefault)A1.parseFrom(FeatureSetEditionDefault.DEFAULT_INSTANCE, inputStream0);
        }

        public static FeatureSetEditionDefault parseFrom(InputStream inputStream0, g1 g10) {
            return (FeatureSetEditionDefault)A1.parseFrom(FeatureSetEditionDefault.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static FeatureSetEditionDefault parseFrom(ByteBuffer byteBuffer0) {
            return (FeatureSetEditionDefault)A1.parseFrom(FeatureSetEditionDefault.DEFAULT_INSTANCE, byteBuffer0);
        }

        public static FeatureSetEditionDefault parseFrom(ByteBuffer byteBuffer0, g1 g10) {
            return (FeatureSetEditionDefault)A1.parseFrom(FeatureSetEditionDefault.DEFAULT_INSTANCE, byteBuffer0, g10);
        }

        public static FeatureSetEditionDefault parseFrom(byte[] arr_b) {
            return (FeatureSetEditionDefault)A1.parseFrom(FeatureSetEditionDefault.DEFAULT_INSTANCE, arr_b);
        }

        public static FeatureSetEditionDefault parseFrom(byte[] arr_b, g1 g10) {
            return (FeatureSetEditionDefault)A1.parseFrom(FeatureSetEditionDefault.DEFAULT_INSTANCE, arr_b, g10);
        }

        public static z2 parser() {
            return FeatureSetEditionDefault.DEFAULT_INSTANCE.getParserForType();
        }

        private void setEdition(F f0) {
            this.edition_ = f0.a;
            this.bitField0_ |= 1;
        }

        private void setFixedFeatures(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
            descriptorProtos$FeatureSet0.getClass();
            this.fixedFeatures_ = descriptorProtos$FeatureSet0;
            this.bitField0_ |= 4;
        }

        private void setOverridableFeatures(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
            descriptorProtos$FeatureSet0.getClass();
            this.overridableFeatures_ = descriptorProtos$FeatureSet0;
            this.bitField0_ |= 2;
        }
    }

    public static final int DEFAULTS_FIELD_NUMBER = 1;
    private static final DescriptorProtos.FeatureSetDefaults DEFAULT_INSTANCE = null;
    public static final int MAXIMUM_EDITION_FIELD_NUMBER = 5;
    public static final int MINIMUM_EDITION_FIELD_NUMBER = 4;
    private static volatile z2 PARSER;
    private int bitField0_;
    private O1 defaults_;
    private int maximumEdition_;
    private byte memoizedIsInitialized;
    private int minimumEdition_;

    static {
        DescriptorProtos.FeatureSetDefaults descriptorProtos$FeatureSetDefaults0 = new DescriptorProtos.FeatureSetDefaults();
        DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE = descriptorProtos$FeatureSetDefaults0;
        A1.registerDefaultInstance(DescriptorProtos.FeatureSetDefaults.class, descriptorProtos$FeatureSetDefaults0);
    }

    private DescriptorProtos.FeatureSetDefaults() {
        this.memoizedIsInitialized = 2;
        this.defaults_ = A1.emptyProtobufList();
    }

    public static void access$56100(DescriptorProtos.FeatureSetDefaults descriptorProtos$FeatureSetDefaults0, int v, FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0) {
        descriptorProtos$FeatureSetDefaults0.setDefaults(v, descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0);
    }

    public static void access$56200(DescriptorProtos.FeatureSetDefaults descriptorProtos$FeatureSetDefaults0, FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0) {
        descriptorProtos$FeatureSetDefaults0.addDefaults(descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0);
    }

    public static void access$56300(DescriptorProtos.FeatureSetDefaults descriptorProtos$FeatureSetDefaults0, int v, FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0) {
        descriptorProtos$FeatureSetDefaults0.addDefaults(v, descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0);
    }

    public static void access$56400(DescriptorProtos.FeatureSetDefaults descriptorProtos$FeatureSetDefaults0, Iterable iterable0) {
        descriptorProtos$FeatureSetDefaults0.addAllDefaults(iterable0);
    }

    public static void access$56500(DescriptorProtos.FeatureSetDefaults descriptorProtos$FeatureSetDefaults0) {
        descriptorProtos$FeatureSetDefaults0.clearDefaults();
    }

    public static void access$56600(DescriptorProtos.FeatureSetDefaults descriptorProtos$FeatureSetDefaults0, int v) {
        descriptorProtos$FeatureSetDefaults0.removeDefaults(v);
    }

    public static void access$56700(DescriptorProtos.FeatureSetDefaults descriptorProtos$FeatureSetDefaults0, F f0) {
        descriptorProtos$FeatureSetDefaults0.setMinimumEdition(f0);
    }

    public static void access$56800(DescriptorProtos.FeatureSetDefaults descriptorProtos$FeatureSetDefaults0) {
        descriptorProtos$FeatureSetDefaults0.clearMinimumEdition();
    }

    public static void access$56900(DescriptorProtos.FeatureSetDefaults descriptorProtos$FeatureSetDefaults0, F f0) {
        descriptorProtos$FeatureSetDefaults0.setMaximumEdition(f0);
    }

    public static void access$57000(DescriptorProtos.FeatureSetDefaults descriptorProtos$FeatureSetDefaults0) {
        descriptorProtos$FeatureSetDefaults0.clearMaximumEdition();
    }

    private void addAllDefaults(Iterable iterable0) {
        this.ensureDefaultsIsMutable();
        b.addAll(iterable0, this.defaults_);
    }

    private void addDefaults(int v, FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0) {
        descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0.getClass();
        this.ensureDefaultsIsMutable();
        this.defaults_.add(v, descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0);
    }

    private void addDefaults(FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0) {
        descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0.getClass();
        this.ensureDefaultsIsMutable();
        this.defaults_.add(descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0);
    }

    private void clearDefaults() {
        this.defaults_ = A1.emptyProtobufList();
    }

    private void clearMaximumEdition() {
        this.bitField0_ &= -3;
        this.maximumEdition_ = 0;
    }

    private void clearMinimumEdition() {
        this.bitField0_ &= -2;
        this.minimumEdition_ = 0;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        z2 z21;
        switch(z10.ordinal()) {
            case 0: {
                return this.memoizedIsInitialized;
            }
            case 1: {
                this.memoizedIsInitialized = (byte)(object0 == null ? 0 : 1);
                return null;
            }
            case 2: {
                return A1.newMessageInfo(DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0005\u0003\u0000\u0001\u0001\u0001Л\u0004᠌\u0000\u0005᠌\u0001", new Object[]{"bitField0_", "defaults_", FeatureSetEditionDefault.class, "minimumEdition_", E.b, "maximumEdition_", E.b});
            }
            case 3: {
                return new DescriptorProtos.FeatureSetDefaults();
            }
            case 4: {
                return new e0(DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.FeatureSetDefaults.PARSER;
                if(z20 == null) {
                    synchronized(DescriptorProtos.FeatureSetDefaults.class) {
                        z21 = DescriptorProtos.FeatureSetDefaults.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.FeatureSetDefaults.PARSER = z21;
                        }
                    }
                    return z21;
                }
                return z20;
            }
            default: {
                throw null;
            }
        }
    }

    private void ensureDefaultsIsMutable() {
        O1 o10 = this.defaults_;
        if(!((c)o10).a) {
            this.defaults_ = A1.mutableCopy(o10);
        }
    }

    public static DescriptorProtos.FeatureSetDefaults getDefaultInstance() {
        return DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE;
    }

    public FeatureSetEditionDefault getDefaults(int v) {
        return (FeatureSetEditionDefault)this.defaults_.get(v);
    }

    public int getDefaultsCount() {
        return this.defaults_.size();
    }

    public List getDefaultsList() {
        return this.defaults_;
    }

    public g0 getDefaultsOrBuilder(int v) {
        return (g0)this.defaults_.get(v);
    }

    public List getDefaultsOrBuilderList() {
        return this.defaults_;
    }

    public F getMaximumEdition() {
        F f0 = F.b(this.maximumEdition_);
        return f0 == null ? F.b : f0;
    }

    public F getMinimumEdition() {
        F f0 = F.b(this.minimumEdition_);
        return f0 == null ? F.b : f0;
    }

    public boolean hasMaximumEdition() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMinimumEdition() {
        return (this.bitField0_ & 1) != 0;
    }

    public static e0 newBuilder() {
        return (e0)DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE.createBuilder();
    }

    public static e0 newBuilder(DescriptorProtos.FeatureSetDefaults descriptorProtos$FeatureSetDefaults0) {
        return (e0)DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE.createBuilder(descriptorProtos$FeatureSetDefaults0);
    }

    public static DescriptorProtos.FeatureSetDefaults parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.FeatureSetDefaults)A1.parseDelimitedFrom(DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.FeatureSetDefaults parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.FeatureSetDefaults)A1.parseDelimitedFrom(DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.FeatureSetDefaults parseFrom(o o0) {
        return (DescriptorProtos.FeatureSetDefaults)A1.parseFrom(DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.FeatureSetDefaults parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.FeatureSetDefaults)A1.parseFrom(DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.FeatureSetDefaults parseFrom(t t0) {
        return (DescriptorProtos.FeatureSetDefaults)A1.parseFrom(DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.FeatureSetDefaults parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.FeatureSetDefaults)A1.parseFrom(DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.FeatureSetDefaults parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.FeatureSetDefaults)A1.parseFrom(DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.FeatureSetDefaults parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.FeatureSetDefaults)A1.parseFrom(DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.FeatureSetDefaults parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.FeatureSetDefaults)A1.parseFrom(DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.FeatureSetDefaults parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.FeatureSetDefaults)A1.parseFrom(DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.FeatureSetDefaults parseFrom(byte[] arr_b) {
        return (DescriptorProtos.FeatureSetDefaults)A1.parseFrom(DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.FeatureSetDefaults parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.FeatureSetDefaults)A1.parseFrom(DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.FeatureSetDefaults.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeDefaults(int v) {
        this.ensureDefaultsIsMutable();
        this.defaults_.remove(v);
    }

    private void setDefaults(int v, FeatureSetEditionDefault descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0) {
        descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0.getClass();
        this.ensureDefaultsIsMutable();
        this.defaults_.set(v, descriptorProtos$FeatureSetDefaults$FeatureSetEditionDefault0);
    }

    private void setMaximumEdition(F f0) {
        this.maximumEdition_ = f0.a;
        this.bitField0_ |= 2;
    }

    private void setMinimumEdition(F f0) {
        this.minimumEdition_ = f0.a;
        this.bitField0_ |= 1;
    }
}

