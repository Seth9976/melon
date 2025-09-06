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
import k8.J;

public final class MelonTiaraUserInfo extends A1 implements m2 {
    private static final MelonTiaraUserInfo DEFAULT_INSTANCE = null;
    private static volatile z2 PARSER = null;
    public static final int PAYMENTTYPE_FIELD_NUMBER = 3;
    public static final int PRODUCTNAME_FIELD_NUMBER = 4;
    public static final int PRODUCTPRICE_FIELD_NUMBER = 5;
    public static final int RESTRICTAD_FIELD_NUMBER = 6;
    public static final int THIRDADAGREE_FIELD_NUMBER = 1;
    public static final int THIRDPROVIDEAGREE_FIELD_NUMBER = 2;
    private String paymentType_;
    private String productName_;
    private String productPrice_;
    private String restrictAd_;
    private boolean thirdAdAgree_;
    private boolean thirdProvideAgree_;

    static {
        MelonTiaraUserInfo melonTiaraUserInfo0 = new MelonTiaraUserInfo();
        MelonTiaraUserInfo.DEFAULT_INSTANCE = melonTiaraUserInfo0;
        A1.registerDefaultInstance(MelonTiaraUserInfo.class, melonTiaraUserInfo0);
    }

    private MelonTiaraUserInfo() {
        this.paymentType_ = "";
        this.productName_ = "";
        this.productPrice_ = "";
        this.restrictAd_ = "";
    }

    private void clearPaymentType() {
        this.paymentType_ = "";
    }

    private void clearProductName() {
        this.productName_ = "";
    }

    private void clearProductPrice() {
        this.productPrice_ = "";
    }

    private void clearRestrictAd() {
        this.restrictAd_ = "";
    }

    private void clearThirdAdAgree() {
        this.thirdAdAgree_ = false;
    }

    private void clearThirdProvideAgree() {
        this.thirdProvideAgree_ = false;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        z2 z21;
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(MelonTiaraUserInfo.DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0007\u0002\u0007\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ", new Object[]{"thirdAdAgree_", "thirdProvideAgree_", "paymentType_", "productName_", "productPrice_", "restrictAd_"});
            }
            case 3: {
                return new MelonTiaraUserInfo();
            }
            case 4: {
                return new J(MelonTiaraUserInfo.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return MelonTiaraUserInfo.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = MelonTiaraUserInfo.PARSER;
                if(z20 == null) {
                    synchronized(MelonTiaraUserInfo.class) {
                        z21 = MelonTiaraUserInfo.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            MelonTiaraUserInfo.PARSER = z21;
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

    public static MelonTiaraUserInfo getDefaultInstance() {
        return MelonTiaraUserInfo.DEFAULT_INSTANCE;
    }

    public String getPaymentType() [...] // 潜在的解密器

    public o getPaymentTypeBytes() {
        return o.e(this.paymentType_);
    }

    public String getProductName() [...] // 潜在的解密器

    public o getProductNameBytes() {
        return o.e(this.productName_);
    }

    public String getProductPrice() [...] // 潜在的解密器

    public o getProductPriceBytes() {
        return o.e(this.productPrice_);
    }

    public String getRestrictAd() [...] // 潜在的解密器

    public o getRestrictAdBytes() {
        return o.e(this.restrictAd_);
    }

    public boolean getThirdAdAgree() {
        return this.thirdAdAgree_;
    }

    public boolean getThirdProvideAgree() {
        return this.thirdProvideAgree_;
    }

    public static J newBuilder() {
        return (J)MelonTiaraUserInfo.DEFAULT_INSTANCE.createBuilder();
    }

    public static J newBuilder(MelonTiaraUserInfo melonTiaraUserInfo0) {
        return (J)MelonTiaraUserInfo.DEFAULT_INSTANCE.createBuilder(melonTiaraUserInfo0);
    }

    public static MelonTiaraUserInfo parseDelimitedFrom(InputStream inputStream0) {
        return (MelonTiaraUserInfo)A1.parseDelimitedFrom(MelonTiaraUserInfo.DEFAULT_INSTANCE, inputStream0);
    }

    public static MelonTiaraUserInfo parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (MelonTiaraUserInfo)A1.parseDelimitedFrom(MelonTiaraUserInfo.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static MelonTiaraUserInfo parseFrom(o o0) {
        return (MelonTiaraUserInfo)A1.parseFrom(MelonTiaraUserInfo.DEFAULT_INSTANCE, o0);
    }

    public static MelonTiaraUserInfo parseFrom(o o0, g1 g10) {
        return (MelonTiaraUserInfo)A1.parseFrom(MelonTiaraUserInfo.DEFAULT_INSTANCE, o0, g10);
    }

    public static MelonTiaraUserInfo parseFrom(t t0) {
        return (MelonTiaraUserInfo)A1.parseFrom(MelonTiaraUserInfo.DEFAULT_INSTANCE, t0);
    }

    public static MelonTiaraUserInfo parseFrom(t t0, g1 g10) {
        return (MelonTiaraUserInfo)A1.parseFrom(MelonTiaraUserInfo.DEFAULT_INSTANCE, t0, g10);
    }

    public static MelonTiaraUserInfo parseFrom(InputStream inputStream0) {
        return (MelonTiaraUserInfo)A1.parseFrom(MelonTiaraUserInfo.DEFAULT_INSTANCE, inputStream0);
    }

    public static MelonTiaraUserInfo parseFrom(InputStream inputStream0, g1 g10) {
        return (MelonTiaraUserInfo)A1.parseFrom(MelonTiaraUserInfo.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static MelonTiaraUserInfo parseFrom(ByteBuffer byteBuffer0) {
        return (MelonTiaraUserInfo)A1.parseFrom(MelonTiaraUserInfo.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static MelonTiaraUserInfo parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (MelonTiaraUserInfo)A1.parseFrom(MelonTiaraUserInfo.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static MelonTiaraUserInfo parseFrom(byte[] arr_b) {
        return (MelonTiaraUserInfo)A1.parseFrom(MelonTiaraUserInfo.DEFAULT_INSTANCE, arr_b);
    }

    public static MelonTiaraUserInfo parseFrom(byte[] arr_b, g1 g10) {
        return (MelonTiaraUserInfo)A1.parseFrom(MelonTiaraUserInfo.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return MelonTiaraUserInfo.DEFAULT_INSTANCE.getParserForType();
    }

    private void setPaymentType(String s) {
        s.getClass();
        this.paymentType_ = s;
    }

    private void setPaymentTypeBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.paymentType_ = o0.p();
    }

    private void setProductName(String s) {
        s.getClass();
        this.productName_ = s;
    }

    private void setProductNameBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.productName_ = o0.p();
    }

    private void setProductPrice(String s) {
        s.getClass();
        this.productPrice_ = s;
    }

    private void setProductPriceBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.productPrice_ = o0.p();
    }

    private void setRestrictAd(String s) {
        s.getClass();
        this.restrictAd_ = s;
    }

    private void setRestrictAdBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.restrictAd_ = o0.p();
    }

    private void setThirdAdAgree(boolean z) {
        this.thirdAdAgree_ = z;
    }

    private void setThirdProvideAgree(boolean z) {
        this.thirdProvideAgree_ = z;
    }
}

