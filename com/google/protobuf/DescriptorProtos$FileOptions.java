package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.FileOptions extends GeneratedMessageLite.ExtendableMessage {
    public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 0x1F;
    public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
    public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
    private static final DescriptorProtos.FileOptions DEFAULT_INSTANCE = null;
    public static final int DEPRECATED_FIELD_NUMBER = 23;
    public static final int FEATURES_FIELD_NUMBER = 50;
    public static final int GO_PACKAGE_FIELD_NUMBER = 11;
    public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
    public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
    public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
    public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
    public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
    public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
    public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
    public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
    private static volatile z2 PARSER = null;
    public static final int PHP_CLASS_PREFIX_FIELD_NUMBER = 40;
    public static final int PHP_METADATA_NAMESPACE_FIELD_NUMBER = 44;
    public static final int PHP_NAMESPACE_FIELD_NUMBER = 41;
    public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
    public static final int RUBY_PACKAGE_FIELD_NUMBER = 45;
    public static final int SWIFT_PREFIX_FIELD_NUMBER = 39;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private int bitField0_;
    private boolean ccEnableArenas_;
    private boolean ccGenericServices_;
    private String csharpNamespace_;
    private boolean deprecated_;
    private DescriptorProtos.FeatureSet features_;
    private String goPackage_;
    private boolean javaGenerateEqualsAndHash_;
    private boolean javaGenericServices_;
    private boolean javaMultipleFiles_;
    private String javaOuterClassname_;
    private String javaPackage_;
    private boolean javaStringCheckUtf8_;
    private byte memoizedIsInitialized;
    private String objcClassPrefix_;
    private int optimizeFor_;
    private String phpClassPrefix_;
    private String phpMetadataNamespace_;
    private String phpNamespace_;
    private boolean pyGenericServices_;
    private String rubyPackage_;
    private String swiftPrefix_;
    private O1 uninterpretedOption_;

    static {
        DescriptorProtos.FileOptions descriptorProtos$FileOptions0 = new DescriptorProtos.FileOptions();
        DescriptorProtos.FileOptions.DEFAULT_INSTANCE = descriptorProtos$FileOptions0;
        A1.registerDefaultInstance(DescriptorProtos.FileOptions.class, descriptorProtos$FileOptions0);
    }

    private DescriptorProtos.FileOptions() {
        this.memoizedIsInitialized = 2;
        this.javaPackage_ = "";
        this.javaOuterClassname_ = "";
        this.optimizeFor_ = 1;
        this.goPackage_ = "";
        this.ccEnableArenas_ = true;
        this.objcClassPrefix_ = "";
        this.csharpNamespace_ = "";
        this.swiftPrefix_ = "";
        this.phpClassPrefix_ = "";
        this.phpNamespace_ = "";
        this.phpMetadataNamespace_ = "";
        this.rubyPackage_ = "";
        this.uninterpretedOption_ = A1.emptyProtobufList();
    }

    public static void access$28800(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, String s) {
        descriptorProtos$FileOptions0.setJavaPackage(s);
    }

    public static void access$28900(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearJavaPackage();
    }

    public static void access$29000(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, o o0) {
        descriptorProtos$FileOptions0.setJavaPackageBytes(o0);
    }

    public static void access$29100(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, String s) {
        descriptorProtos$FileOptions0.setJavaOuterClassname(s);
    }

    public static void access$29200(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearJavaOuterClassname();
    }

    public static void access$29300(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, o o0) {
        descriptorProtos$FileOptions0.setJavaOuterClassnameBytes(o0);
    }

    public static void access$29400(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, boolean z) {
        descriptorProtos$FileOptions0.setJavaMultipleFiles(z);
    }

    public static void access$29500(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearJavaMultipleFiles();
    }

    public static void access$29600(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, boolean z) {
        descriptorProtos$FileOptions0.setJavaGenerateEqualsAndHash(z);
    }

    public static void access$29700(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearJavaGenerateEqualsAndHash();
    }

    public static void access$29800(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, boolean z) {
        descriptorProtos$FileOptions0.setJavaStringCheckUtf8(z);
    }

    public static void access$29900(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearJavaStringCheckUtf8();
    }

    public static void access$30000(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, x0 x00) {
        descriptorProtos$FileOptions0.setOptimizeFor(x00);
    }

    public static void access$30100(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearOptimizeFor();
    }

    public static void access$30200(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, String s) {
        descriptorProtos$FileOptions0.setGoPackage(s);
    }

    public static void access$30300(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearGoPackage();
    }

    public static void access$30400(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, o o0) {
        descriptorProtos$FileOptions0.setGoPackageBytes(o0);
    }

    public static void access$30500(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, boolean z) {
        descriptorProtos$FileOptions0.setCcGenericServices(z);
    }

    public static void access$30600(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearCcGenericServices();
    }

    public static void access$30700(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, boolean z) {
        descriptorProtos$FileOptions0.setJavaGenericServices(z);
    }

    public static void access$30800(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearJavaGenericServices();
    }

    public static void access$30900(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, boolean z) {
        descriptorProtos$FileOptions0.setPyGenericServices(z);
    }

    public static void access$31000(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearPyGenericServices();
    }

    public static void access$31100(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, boolean z) {
        descriptorProtos$FileOptions0.setDeprecated(z);
    }

    public static void access$31200(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearDeprecated();
    }

    public static void access$31300(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, boolean z) {
        descriptorProtos$FileOptions0.setCcEnableArenas(z);
    }

    public static void access$31400(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearCcEnableArenas();
    }

    public static void access$31500(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, String s) {
        descriptorProtos$FileOptions0.setObjcClassPrefix(s);
    }

    public static void access$31600(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearObjcClassPrefix();
    }

    public static void access$31700(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, o o0) {
        descriptorProtos$FileOptions0.setObjcClassPrefixBytes(o0);
    }

    public static void access$31800(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, String s) {
        descriptorProtos$FileOptions0.setCsharpNamespace(s);
    }

    public static void access$31900(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearCsharpNamespace();
    }

    public static void access$32000(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, o o0) {
        descriptorProtos$FileOptions0.setCsharpNamespaceBytes(o0);
    }

    public static void access$32100(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, String s) {
        descriptorProtos$FileOptions0.setSwiftPrefix(s);
    }

    public static void access$32200(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearSwiftPrefix();
    }

    public static void access$32300(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, o o0) {
        descriptorProtos$FileOptions0.setSwiftPrefixBytes(o0);
    }

    public static void access$32400(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, String s) {
        descriptorProtos$FileOptions0.setPhpClassPrefix(s);
    }

    public static void access$32500(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearPhpClassPrefix();
    }

    public static void access$32600(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, o o0) {
        descriptorProtos$FileOptions0.setPhpClassPrefixBytes(o0);
    }

    public static void access$32700(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, String s) {
        descriptorProtos$FileOptions0.setPhpNamespace(s);
    }

    public static void access$32800(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearPhpNamespace();
    }

    public static void access$32900(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, o o0) {
        descriptorProtos$FileOptions0.setPhpNamespaceBytes(o0);
    }

    public static void access$33000(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, String s) {
        descriptorProtos$FileOptions0.setPhpMetadataNamespace(s);
    }

    public static void access$33100(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearPhpMetadataNamespace();
    }

    public static void access$33200(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, o o0) {
        descriptorProtos$FileOptions0.setPhpMetadataNamespaceBytes(o0);
    }

    public static void access$33300(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, String s) {
        descriptorProtos$FileOptions0.setRubyPackage(s);
    }

    public static void access$33400(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearRubyPackage();
    }

    public static void access$33500(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, o o0) {
        descriptorProtos$FileOptions0.setRubyPackageBytes(o0);
    }

    public static void access$33600(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FileOptions0.setFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$33700(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FileOptions0.mergeFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$33800(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearFeatures();
    }

    public static void access$33900(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$FileOptions0.setUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$34000(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$FileOptions0.addUninterpretedOption(descriptorProtos$UninterpretedOption0);
    }

    public static void access$34100(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$FileOptions0.addUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$34200(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, Iterable iterable0) {
        descriptorProtos$FileOptions0.addAllUninterpretedOption(iterable0);
    }

    public static void access$34300(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.clearUninterpretedOption();
    }

    public static void access$34400(DescriptorProtos.FileOptions descriptorProtos$FileOptions0, int v) {
        descriptorProtos$FileOptions0.removeUninterpretedOption(v);
    }

    private void addAllUninterpretedOption(Iterable iterable0) {
        this.ensureUninterpretedOptionIsMutable();
        b.addAll(iterable0, this.uninterpretedOption_);
    }

    private void addUninterpretedOption(int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.getClass();
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(v, descriptorProtos$UninterpretedOption0);
    }

    private void addUninterpretedOption(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.getClass();
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(descriptorProtos$UninterpretedOption0);
    }

    private void clearCcEnableArenas() {
        this.bitField0_ &= 0xFFFFF7FF;
        this.ccEnableArenas_ = true;
    }

    private void clearCcGenericServices() {
        this.bitField0_ &= 0xFFFFFF7F;
        this.ccGenericServices_ = false;
    }

    private void clearCsharpNamespace() {
        this.bitField0_ &= 0xFFFFDFFF;
        this.csharpNamespace_ = DescriptorProtos.FileOptions.getDefaultInstance().getCsharpNamespace();
    }

    private void clearDeprecated() {
        this.bitField0_ &= 0xFFFFFBFF;
        this.deprecated_ = false;
    }

    private void clearFeatures() {
        this.features_ = null;
        this.bitField0_ &= 0xFFF7FFFF;
    }

    private void clearGoPackage() {
        this.bitField0_ &= -65;
        this.goPackage_ = DescriptorProtos.FileOptions.getDefaultInstance().getGoPackage();
    }

    private void clearJavaGenerateEqualsAndHash() {
        this.bitField0_ &= -9;
        this.javaGenerateEqualsAndHash_ = false;
    }

    private void clearJavaGenericServices() {
        this.bitField0_ &= 0xFFFFFEFF;
        this.javaGenericServices_ = false;
    }

    private void clearJavaMultipleFiles() {
        this.bitField0_ &= -5;
        this.javaMultipleFiles_ = false;
    }

    private void clearJavaOuterClassname() {
        this.bitField0_ &= -3;
        this.javaOuterClassname_ = DescriptorProtos.FileOptions.getDefaultInstance().getJavaOuterClassname();
    }

    private void clearJavaPackage() {
        this.bitField0_ &= -2;
        this.javaPackage_ = DescriptorProtos.FileOptions.getDefaultInstance().getJavaPackage();
    }

    private void clearJavaStringCheckUtf8() {
        this.bitField0_ &= -17;
        this.javaStringCheckUtf8_ = false;
    }

    private void clearObjcClassPrefix() {
        this.bitField0_ &= 0xFFFFEFFF;
        this.objcClassPrefix_ = DescriptorProtos.FileOptions.getDefaultInstance().getObjcClassPrefix();
    }

    private void clearOptimizeFor() {
        this.bitField0_ &= -33;
        this.optimizeFor_ = 1;
    }

    private void clearPhpClassPrefix() {
        this.bitField0_ &= 0xFFFF7FFF;
        this.phpClassPrefix_ = DescriptorProtos.FileOptions.getDefaultInstance().getPhpClassPrefix();
    }

    private void clearPhpMetadataNamespace() {
        this.bitField0_ &= 0xFFFDFFFF;
        this.phpMetadataNamespace_ = DescriptorProtos.FileOptions.getDefaultInstance().getPhpMetadataNamespace();
    }

    private void clearPhpNamespace() {
        this.bitField0_ &= 0xFFFEFFFF;
        this.phpNamespace_ = DescriptorProtos.FileOptions.getDefaultInstance().getPhpNamespace();
    }

    private void clearPyGenericServices() {
        this.bitField0_ &= 0xFFFFFDFF;
        this.pyGenericServices_ = false;
    }

    private void clearRubyPackage() {
        this.bitField0_ &= 0xFFFBFFFF;
        this.rubyPackage_ = DescriptorProtos.FileOptions.getDefaultInstance().getRubyPackage();
    }

    private void clearSwiftPrefix() {
        this.bitField0_ &= 0xFFFFBFFF;
        this.swiftPrefix_ = DescriptorProtos.FileOptions.getDefaultInstance().getSwiftPrefix();
    }

    private void clearUninterpretedOption() {
        this.uninterpretedOption_ = A1.emptyProtobufList();
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
                return A1.newMessageInfo(DescriptorProtos.FileOptions.DEFAULT_INSTANCE, "\u0001\u0015\u0000\u0001\u0001ϧ\u0015\u0000\u0001\u0002\u0001ဈ\u0000\bဈ\u0001\t᠌\u0005\nဇ\u0002\u000Bဈ\u0006\u0010ဇ\u0007\u0011ဇ\b\u0012ဇ\t\u0014ဇ\u0003\u0017ဇ\n\u001Bဇ\u0004\u001Fဇ\u000B$ဈ\f%ဈ\r\'ဈ\u000E(ဈ\u000F)ဈ\u0010,ဈ\u0011-ဈ\u00122ᐉ\u0013ϧЛ", new Object[]{"bitField0_", "javaPackage_", "javaOuterClassname_", "optimizeFor_", E.q, "javaMultipleFiles_", "goPackage_", "ccGenericServices_", "javaGenericServices_", "pyGenericServices_", "javaGenerateEqualsAndHash_", "deprecated_", "javaStringCheckUtf8_", "ccEnableArenas_", "objcClassPrefix_", "csharpNamespace_", "swiftPrefix_", "phpClassPrefix_", "phpNamespace_", "phpMetadataNamespace_", "rubyPackage_", "features_", "uninterpretedOption_", DescriptorProtos.UninterpretedOption.class});
            }
            case 3: {
                return new DescriptorProtos.FileOptions();
            }
            case 4: {
                return new w0(DescriptorProtos.FileOptions.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.FileOptions.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.FileOptions.PARSER;
                if(z20 == null) {
                    Class class0 = DescriptorProtos.FileOptions.class;
                    synchronized(class0) {
                        z2 z21 = DescriptorProtos.FileOptions.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.FileOptions.PARSER = z21;
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

    private void ensureUninterpretedOptionIsMutable() {
        O1 o10 = this.uninterpretedOption_;
        if(!((c)o10).a) {
            this.uninterpretedOption_ = A1.mutableCopy(o10);
        }
    }

    public boolean getCcEnableArenas() {
        return this.ccEnableArenas_;
    }

    public boolean getCcGenericServices() {
        return this.ccGenericServices_;
    }

    public String getCsharpNamespace() {
        return this.csharpNamespace_;
    }

    public o getCsharpNamespaceBytes() {
        return o.e(this.csharpNamespace_);
    }

    public static DescriptorProtos.FileOptions getDefaultInstance() {
        return DescriptorProtos.FileOptions.DEFAULT_INSTANCE;
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public DescriptorProtos.FeatureSet getFeatures() {
        return this.features_ == null ? DescriptorProtos.FeatureSet.getDefaultInstance() : this.features_;
    }

    public String getGoPackage() {
        return this.goPackage_;
    }

    public o getGoPackageBytes() {
        return o.e(this.goPackage_);
    }

    @Deprecated
    public boolean getJavaGenerateEqualsAndHash() {
        return this.javaGenerateEqualsAndHash_;
    }

    public boolean getJavaGenericServices() {
        return this.javaGenericServices_;
    }

    public boolean getJavaMultipleFiles() {
        return this.javaMultipleFiles_;
    }

    public String getJavaOuterClassname() {
        return this.javaOuterClassname_;
    }

    public o getJavaOuterClassnameBytes() {
        return o.e(this.javaOuterClassname_);
    }

    public String getJavaPackage() {
        return this.javaPackage_;
    }

    public o getJavaPackageBytes() {
        return o.e(this.javaPackage_);
    }

    public boolean getJavaStringCheckUtf8() {
        return this.javaStringCheckUtf8_;
    }

    public String getObjcClassPrefix() {
        return this.objcClassPrefix_;
    }

    public o getObjcClassPrefixBytes() {
        return o.e(this.objcClassPrefix_);
    }

    public x0 getOptimizeFor() {
        x0 x00 = x0.b(this.optimizeFor_);
        return x00 == null ? x0.b : x00;
    }

    public String getPhpClassPrefix() {
        return this.phpClassPrefix_;
    }

    public o getPhpClassPrefixBytes() {
        return o.e(this.phpClassPrefix_);
    }

    public String getPhpMetadataNamespace() {
        return this.phpMetadataNamespace_;
    }

    public o getPhpMetadataNamespaceBytes() {
        return o.e(this.phpMetadataNamespace_);
    }

    public String getPhpNamespace() {
        return this.phpNamespace_;
    }

    public o getPhpNamespaceBytes() {
        return o.e(this.phpNamespace_);
    }

    public boolean getPyGenericServices() {
        return this.pyGenericServices_;
    }

    public String getRubyPackage() {
        return this.rubyPackage_;
    }

    public o getRubyPackageBytes() {
        return o.e(this.rubyPackage_);
    }

    public String getSwiftPrefix() {
        return this.swiftPrefix_;
    }

    public o getSwiftPrefixBytes() {
        return o.e(this.swiftPrefix_);
    }

    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int v) {
        return (DescriptorProtos.UninterpretedOption)this.uninterpretedOption_.get(v);
    }

    public int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    public List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    public V0 getUninterpretedOptionOrBuilder(int v) {
        return (V0)this.uninterpretedOption_.get(v);
    }

    public List getUninterpretedOptionOrBuilderList() {
        return this.uninterpretedOption_;
    }

    public boolean hasCcEnableArenas() {
        return (this.bitField0_ & 0x800) != 0;
    }

    public boolean hasCcGenericServices() {
        return (this.bitField0_ & 0x80) != 0;
    }

    public boolean hasCsharpNamespace() {
        return (this.bitField0_ & 0x2000) != 0;
    }

    public boolean hasDeprecated() {
        return (this.bitField0_ & 0x400) != 0;
    }

    public boolean hasFeatures() {
        return (this.bitField0_ & 0x80000) != 0;
    }

    public boolean hasGoPackage() {
        return (this.bitField0_ & 0x40) != 0;
    }

    @Deprecated
    public boolean hasJavaGenerateEqualsAndHash() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasJavaGenericServices() {
        return (this.bitField0_ & 0x100) != 0;
    }

    public boolean hasJavaMultipleFiles() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasJavaOuterClassname() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasJavaPackage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasJavaStringCheckUtf8() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasObjcClassPrefix() {
        return (this.bitField0_ & 0x1000) != 0;
    }

    public boolean hasOptimizeFor() {
        return (this.bitField0_ & 0x20) != 0;
    }

    public boolean hasPhpClassPrefix() {
        return (this.bitField0_ & 0x8000) != 0;
    }

    public boolean hasPhpMetadataNamespace() {
        return (this.bitField0_ & 0x20000) != 0;
    }

    public boolean hasPhpNamespace() {
        return (this.bitField0_ & 0x10000) != 0;
    }

    public boolean hasPyGenericServices() {
        return (this.bitField0_ & 0x200) != 0;
    }

    public boolean hasRubyPackage() {
        return (this.bitField0_ & 0x40000) != 0;
    }

    public boolean hasSwiftPrefix() {
        return (this.bitField0_ & 0x4000) != 0;
    }

    private void mergeFeatures(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.getClass();
        if(this.features_ == null || this.features_ == DescriptorProtos.FeatureSet.getDefaultInstance()) {
            this.features_ = descriptorProtos$FeatureSet0;
        }
        else {
            T t0 = DescriptorProtos.FeatureSet.newBuilder(this.features_);
            t0.f(descriptorProtos$FeatureSet0);
            this.features_ = (DescriptorProtos.FeatureSet)t0.i();
        }
        this.bitField0_ |= 0x80000;
    }

    public static w0 newBuilder() {
        return (w0)DescriptorProtos.FileOptions.DEFAULT_INSTANCE.createBuilder();
    }

    public static w0 newBuilder(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        return (w0)DescriptorProtos.FileOptions.DEFAULT_INSTANCE.createBuilder(descriptorProtos$FileOptions0);
    }

    public static DescriptorProtos.FileOptions parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.FileOptions)A1.parseDelimitedFrom(DescriptorProtos.FileOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.FileOptions parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.FileOptions)A1.parseDelimitedFrom(DescriptorProtos.FileOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.FileOptions parseFrom(o o0) {
        return (DescriptorProtos.FileOptions)A1.parseFrom(DescriptorProtos.FileOptions.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.FileOptions parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.FileOptions)A1.parseFrom(DescriptorProtos.FileOptions.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.FileOptions parseFrom(t t0) {
        return (DescriptorProtos.FileOptions)A1.parseFrom(DescriptorProtos.FileOptions.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.FileOptions parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.FileOptions)A1.parseFrom(DescriptorProtos.FileOptions.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.FileOptions parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.FileOptions)A1.parseFrom(DescriptorProtos.FileOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.FileOptions parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.FileOptions)A1.parseFrom(DescriptorProtos.FileOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.FileOptions parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.FileOptions)A1.parseFrom(DescriptorProtos.FileOptions.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.FileOptions parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.FileOptions)A1.parseFrom(DescriptorProtos.FileOptions.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.FileOptions parseFrom(byte[] arr_b) {
        return (DescriptorProtos.FileOptions)A1.parseFrom(DescriptorProtos.FileOptions.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.FileOptions parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.FileOptions)A1.parseFrom(DescriptorProtos.FileOptions.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.FileOptions.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUninterpretedOption(int v) {
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.remove(v);
    }

    private void setCcEnableArenas(boolean z) {
        this.bitField0_ |= 0x800;
        this.ccEnableArenas_ = z;
    }

    private void setCcGenericServices(boolean z) {
        this.bitField0_ |= 0x80;
        this.ccGenericServices_ = z;
    }

    private void setCsharpNamespace(String s) {
        s.getClass();
        this.bitField0_ |= 0x2000;
        this.csharpNamespace_ = s;
    }

    private void setCsharpNamespaceBytes(o o0) {
        this.csharpNamespace_ = o0.p();
        this.bitField0_ |= 0x2000;
    }

    private void setDeprecated(boolean z) {
        this.bitField0_ |= 0x400;
        this.deprecated_ = z;
    }

    private void setFeatures(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.getClass();
        this.features_ = descriptorProtos$FeatureSet0;
        this.bitField0_ |= 0x80000;
    }

    private void setGoPackage(String s) {
        s.getClass();
        this.bitField0_ |= 0x40;
        this.goPackage_ = s;
    }

    private void setGoPackageBytes(o o0) {
        this.goPackage_ = o0.p();
        this.bitField0_ |= 0x40;
    }

    private void setJavaGenerateEqualsAndHash(boolean z) {
        this.bitField0_ |= 8;
        this.javaGenerateEqualsAndHash_ = z;
    }

    private void setJavaGenericServices(boolean z) {
        this.bitField0_ |= 0x100;
        this.javaGenericServices_ = z;
    }

    private void setJavaMultipleFiles(boolean z) {
        this.bitField0_ |= 4;
        this.javaMultipleFiles_ = z;
    }

    private void setJavaOuterClassname(String s) {
        s.getClass();
        this.bitField0_ |= 2;
        this.javaOuterClassname_ = s;
    }

    private void setJavaOuterClassnameBytes(o o0) {
        this.javaOuterClassname_ = o0.p();
        this.bitField0_ |= 2;
    }

    private void setJavaPackage(String s) {
        s.getClass();
        this.bitField0_ |= 1;
        this.javaPackage_ = s;
    }

    private void setJavaPackageBytes(o o0) {
        this.javaPackage_ = o0.p();
        this.bitField0_ |= 1;
    }

    private void setJavaStringCheckUtf8(boolean z) {
        this.bitField0_ |= 16;
        this.javaStringCheckUtf8_ = z;
    }

    private void setObjcClassPrefix(String s) {
        s.getClass();
        this.bitField0_ |= 0x1000;
        this.objcClassPrefix_ = s;
    }

    private void setObjcClassPrefixBytes(o o0) {
        this.objcClassPrefix_ = o0.p();
        this.bitField0_ |= 0x1000;
    }

    private void setOptimizeFor(x0 x00) {
        this.optimizeFor_ = x00.a;
        this.bitField0_ |= 0x20;
    }

    private void setPhpClassPrefix(String s) {
        s.getClass();
        this.bitField0_ |= 0x8000;
        this.phpClassPrefix_ = s;
    }

    private void setPhpClassPrefixBytes(o o0) {
        this.phpClassPrefix_ = o0.p();
        this.bitField0_ |= 0x8000;
    }

    private void setPhpMetadataNamespace(String s) {
        s.getClass();
        this.bitField0_ |= 0x20000;
        this.phpMetadataNamespace_ = s;
    }

    private void setPhpMetadataNamespaceBytes(o o0) {
        this.phpMetadataNamespace_ = o0.p();
        this.bitField0_ |= 0x20000;
    }

    private void setPhpNamespace(String s) {
        s.getClass();
        this.bitField0_ |= 0x10000;
        this.phpNamespace_ = s;
    }

    private void setPhpNamespaceBytes(o o0) {
        this.phpNamespace_ = o0.p();
        this.bitField0_ |= 0x10000;
    }

    private void setPyGenericServices(boolean z) {
        this.bitField0_ |= 0x200;
        this.pyGenericServices_ = z;
    }

    private void setRubyPackage(String s) {
        s.getClass();
        this.bitField0_ |= 0x40000;
        this.rubyPackage_ = s;
    }

    private void setRubyPackageBytes(o o0) {
        this.rubyPackage_ = o0.p();
        this.bitField0_ |= 0x40000;
    }

    private void setSwiftPrefix(String s) {
        s.getClass();
        this.bitField0_ |= 0x4000;
        this.swiftPrefix_ = s;
    }

    private void setSwiftPrefixBytes(o o0) {
        this.swiftPrefix_ = o0.p();
        this.bitField0_ |= 0x4000;
    }

    private void setUninterpretedOption(int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.getClass();
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.set(v, descriptorProtos$UninterpretedOption0);
    }
}

