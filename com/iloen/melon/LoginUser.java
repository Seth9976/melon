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
import k8.s;

public final class LoginUser extends A1 implements m2 {
    public static final int ADULTFLAGTYPE_FIELD_NUMBER = 6;
    public static final int APPUSERID_FIELD_NUMBER = 12;
    public static final int ARTISTID_FIELD_NUMBER = 8;
    public static final int AUTOLOGININTERVALTIMEFORDEVELOPER_FIELD_NUMBER = 23;
    public static final int AUTOLOGINSUCCESSTIME_FIELD_NUMBER = 22;
    public static final int BNRSGMT_FIELD_NUMBER = 17;
    private static final LoginUser DEFAULT_INSTANCE = null;
    public static final int DISPLAYUSERID_FIELD_NUMBER = 21;
    public static final int HASFLACSTPROD_FIELD_NUMBER = 18;
    public static final int HIFIPRODTYPE_FIELD_NUMBER = 19;
    public static final int ISDJ_FIELD_NUMBER = 14;
    public static final int ISSETADULTAUTH_FIELD_NUMBER = 10;
    public static final int LOGINTYPE_FIELD_NUMBER = 3;
    public static final int MACOK_FIELD_NUMBER = 7;
    public static final int MEMBERIMAGEURL_FIELD_NUMBER = 15;
    public static final int MEMBERKEY_FIELD_NUMBER = 4;
    public static final int MEMBERNICKNAME_FIELD_NUMBER = 16;
    public static final int MEMBERTYPE_FIELD_NUMBER = 5;
    public static final int MIN_FIELD_NUMBER = 13;
    private static volatile z2 PARSER = null;
    public static final int PRODUCTINFO_FIELD_NUMBER = 20;
    public static final int SESSIONID_FIELD_NUMBER = 9;
    public static final int TMPCALL_FIELD_NUMBER = 11;
    public static final int TOKEN_FIELD_NUMBER = 2;
    public static final int USERID_FIELD_NUMBER = 1;
    private String adultFlagType_;
    private String appUserId_;
    private String artistId_;
    private int autoLoginIntervalTimeForDeveloper_;
    private long autoLoginSuccessTime_;
    private String bnrSgmt_;
    private String displayUserId_;
    private boolean hasFlacStProd_;
    private String hifiProdType_;
    private boolean isDj_;
    private boolean isSetAdultAuth_;
    private String loginType_;
    private boolean macOk_;
    private String memberImageUrl_;
    private String memberKey_;
    private String memberNickName_;
    private int memberType_;
    private String min_;
    private String productInfo_;
    private String sessionId_;
    private String tmpCall_;
    private String token_;
    private String userId_;

    static {
        LoginUser loginUser0 = new LoginUser();
        LoginUser.DEFAULT_INSTANCE = loginUser0;
        A1.registerDefaultInstance(LoginUser.class, loginUser0);
    }

    private LoginUser() {
        this.userId_ = "";
        this.token_ = "";
        this.loginType_ = "";
        this.memberKey_ = "";
        this.adultFlagType_ = "";
        this.artistId_ = "";
        this.sessionId_ = "";
        this.tmpCall_ = "";
        this.appUserId_ = "";
        this.min_ = "";
        this.memberImageUrl_ = "";
        this.memberNickName_ = "";
        this.bnrSgmt_ = "";
        this.hifiProdType_ = "";
        this.productInfo_ = "";
        this.displayUserId_ = "";
    }

    private void clearAdultFlagType() {
        this.adultFlagType_ = "";
    }

    private void clearAppUserId() {
        this.appUserId_ = "";
    }

    private void clearArtistId() {
        this.artistId_ = "";
    }

    private void clearAutoLoginIntervalTimeForDeveloper() {
        this.autoLoginIntervalTimeForDeveloper_ = 0;
    }

    private void clearAutoLoginSuccessTime() {
        this.autoLoginSuccessTime_ = 0L;
    }

    private void clearBnrSgmt() {
        this.bnrSgmt_ = "";
    }

    private void clearDisplayUserId() {
        this.displayUserId_ = "";
    }

    private void clearHasFlacStProd() {
        this.hasFlacStProd_ = false;
    }

    private void clearHifiProdType() {
        this.hifiProdType_ = "";
    }

    private void clearIsDj() {
        this.isDj_ = false;
    }

    private void clearIsSetAdultAuth() {
        this.isSetAdultAuth_ = false;
    }

    private void clearLoginType() {
        this.loginType_ = "";
    }

    private void clearMacOk() {
        this.macOk_ = false;
    }

    private void clearMemberImageUrl() {
        this.memberImageUrl_ = "";
    }

    private void clearMemberKey() {
        this.memberKey_ = "";
    }

    private void clearMemberNickName() {
        this.memberNickName_ = "";
    }

    private void clearMemberType() {
        this.memberType_ = 0;
    }

    private void clearMin() {
        this.min_ = "";
    }

    private void clearProductInfo() {
        this.productInfo_ = "";
    }

    private void clearSessionId() {
        this.sessionId_ = "";
    }

    private void clearTmpCall() {
        this.tmpCall_ = "";
    }

    private void clearToken() {
        this.token_ = "";
    }

    private void clearUserId() {
        this.userId_ = "";
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(LoginUser.DEFAULT_INSTANCE, "\u0000\u0017\u0000\u0000\u0001\u0017\u0017\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u0004\u0006Ȉ\u0007\u0007\bȈ\tȈ\n\u0007\u000BȈ\fȈ\rȈ\u000E\u0007\u000FȈ\u0010Ȉ\u0011Ȉ\u0012\u0007\u0013Ȉ\u0014Ȉ\u0015Ȉ\u0016\u0002\u0017\u0004", new Object[]{"userId_", "token_", "loginType_", "memberKey_", "memberType_", "adultFlagType_", "macOk_", "artistId_", "sessionId_", "isSetAdultAuth_", "tmpCall_", "appUserId_", "min_", "isDj_", "memberImageUrl_", "memberNickName_", "bnrSgmt_", "hasFlacStProd_", "hifiProdType_", "productInfo_", "displayUserId_", "autoLoginSuccessTime_", "autoLoginIntervalTimeForDeveloper_"});
            }
            case 3: {
                return new LoginUser();
            }
            case 4: {
                return new s(LoginUser.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return LoginUser.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = LoginUser.PARSER;
                if(z20 == null) {
                    Class class0 = LoginUser.class;
                    synchronized(class0) {
                        z2 z21 = LoginUser.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            LoginUser.PARSER = z21;
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

    public String getAdultFlagType() [...] // 潜在的解密器

    public o getAdultFlagTypeBytes() {
        return o.e(this.adultFlagType_);
    }

    public String getAppUserId() [...] // 潜在的解密器

    public o getAppUserIdBytes() {
        return o.e(this.appUserId_);
    }

    public String getArtistId() [...] // 潜在的解密器

    public o getArtistIdBytes() {
        return o.e(this.artistId_);
    }

    public int getAutoLoginIntervalTimeForDeveloper() {
        return this.autoLoginIntervalTimeForDeveloper_;
    }

    public long getAutoLoginSuccessTime() {
        return this.autoLoginSuccessTime_;
    }

    public String getBnrSgmt() [...] // 潜在的解密器

    public o getBnrSgmtBytes() {
        return o.e(this.bnrSgmt_);
    }

    public static LoginUser getDefaultInstance() {
        return LoginUser.DEFAULT_INSTANCE;
    }

    public String getDisplayUserId() [...] // 潜在的解密器

    public o getDisplayUserIdBytes() {
        return o.e(this.displayUserId_);
    }

    public boolean getHasFlacStProd() {
        return this.hasFlacStProd_;
    }

    public String getHifiProdType() [...] // 潜在的解密器

    public o getHifiProdTypeBytes() {
        return o.e(this.hifiProdType_);
    }

    public boolean getIsDj() {
        return this.isDj_;
    }

    public boolean getIsSetAdultAuth() {
        return this.isSetAdultAuth_;
    }

    public String getLoginType() [...] // 潜在的解密器

    public o getLoginTypeBytes() {
        return o.e(this.loginType_);
    }

    public boolean getMacOk() {
        return this.macOk_;
    }

    public String getMemberImageUrl() [...] // 潜在的解密器

    public o getMemberImageUrlBytes() {
        return o.e(this.memberImageUrl_);
    }

    public String getMemberKey() [...] // 潜在的解密器

    public o getMemberKeyBytes() {
        return o.e(this.memberKey_);
    }

    public String getMemberNickName() [...] // 潜在的解密器

    public o getMemberNickNameBytes() {
        return o.e(this.memberNickName_);
    }

    public int getMemberType() {
        return this.memberType_;
    }

    public String getMin() [...] // 潜在的解密器

    public o getMinBytes() {
        return o.e(this.min_);
    }

    public String getProductInfo() [...] // 潜在的解密器

    public o getProductInfoBytes() {
        return o.e(this.productInfo_);
    }

    public String getSessionId() [...] // 潜在的解密器

    public o getSessionIdBytes() {
        return o.e(this.sessionId_);
    }

    public String getTmpCall() [...] // 潜在的解密器

    public o getTmpCallBytes() {
        return o.e(this.tmpCall_);
    }

    public String getToken() [...] // 潜在的解密器

    public o getTokenBytes() {
        return o.e(this.token_);
    }

    public String getUserId() [...] // 潜在的解密器

    public o getUserIdBytes() {
        return o.e(this.userId_);
    }

    public static void i(LoginUser loginUser0) {
        loginUser0.setAutoLoginIntervalTimeForDeveloper(360);
    }

    public static s newBuilder() {
        return (s)LoginUser.DEFAULT_INSTANCE.createBuilder();
    }

    public static s newBuilder(LoginUser loginUser0) {
        return (s)LoginUser.DEFAULT_INSTANCE.createBuilder(loginUser0);
    }

    public static LoginUser parseDelimitedFrom(InputStream inputStream0) {
        return (LoginUser)A1.parseDelimitedFrom(LoginUser.DEFAULT_INSTANCE, inputStream0);
    }

    public static LoginUser parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (LoginUser)A1.parseDelimitedFrom(LoginUser.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static LoginUser parseFrom(o o0) {
        return (LoginUser)A1.parseFrom(LoginUser.DEFAULT_INSTANCE, o0);
    }

    public static LoginUser parseFrom(o o0, g1 g10) {
        return (LoginUser)A1.parseFrom(LoginUser.DEFAULT_INSTANCE, o0, g10);
    }

    public static LoginUser parseFrom(t t0) {
        return (LoginUser)A1.parseFrom(LoginUser.DEFAULT_INSTANCE, t0);
    }

    public static LoginUser parseFrom(t t0, g1 g10) {
        return (LoginUser)A1.parseFrom(LoginUser.DEFAULT_INSTANCE, t0, g10);
    }

    public static LoginUser parseFrom(InputStream inputStream0) {
        return (LoginUser)A1.parseFrom(LoginUser.DEFAULT_INSTANCE, inputStream0);
    }

    public static LoginUser parseFrom(InputStream inputStream0, g1 g10) {
        return (LoginUser)A1.parseFrom(LoginUser.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static LoginUser parseFrom(ByteBuffer byteBuffer0) {
        return (LoginUser)A1.parseFrom(LoginUser.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static LoginUser parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (LoginUser)A1.parseFrom(LoginUser.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static LoginUser parseFrom(byte[] arr_b) {
        return (LoginUser)A1.parseFrom(LoginUser.DEFAULT_INSTANCE, arr_b);
    }

    public static LoginUser parseFrom(byte[] arr_b, g1 g10) {
        return (LoginUser)A1.parseFrom(LoginUser.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return LoginUser.DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdultFlagType(String s) {
        s.getClass();
        this.adultFlagType_ = s;
    }

    private void setAdultFlagTypeBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.adultFlagType_ = o0.p();
    }

    private void setAppUserId(String s) {
        s.getClass();
        this.appUserId_ = s;
    }

    private void setAppUserIdBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.appUserId_ = o0.p();
    }

    private void setArtistId(String s) {
        s.getClass();
        this.artistId_ = s;
    }

    private void setArtistIdBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.artistId_ = o0.p();
    }

    private void setAutoLoginIntervalTimeForDeveloper(int v) {
        this.autoLoginIntervalTimeForDeveloper_ = v;
    }

    private void setAutoLoginSuccessTime(long v) {
        this.autoLoginSuccessTime_ = v;
    }

    private void setBnrSgmt(String s) {
        s.getClass();
        this.bnrSgmt_ = s;
    }

    private void setBnrSgmtBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.bnrSgmt_ = o0.p();
    }

    private void setDisplayUserId(String s) {
        s.getClass();
        this.displayUserId_ = s;
    }

    private void setDisplayUserIdBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.displayUserId_ = o0.p();
    }

    private void setHasFlacStProd(boolean z) {
        this.hasFlacStProd_ = z;
    }

    private void setHifiProdType(String s) {
        s.getClass();
        this.hifiProdType_ = s;
    }

    private void setHifiProdTypeBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.hifiProdType_ = o0.p();
    }

    private void setIsDj(boolean z) {
        this.isDj_ = z;
    }

    private void setIsSetAdultAuth(boolean z) {
        this.isSetAdultAuth_ = z;
    }

    private void setLoginType(String s) {
        s.getClass();
        this.loginType_ = s;
    }

    private void setLoginTypeBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.loginType_ = o0.p();
    }

    private void setMacOk(boolean z) {
        this.macOk_ = z;
    }

    private void setMemberImageUrl(String s) {
        s.getClass();
        this.memberImageUrl_ = s;
    }

    private void setMemberImageUrlBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.memberImageUrl_ = o0.p();
    }

    private void setMemberKey(String s) {
        s.getClass();
        this.memberKey_ = s;
    }

    private void setMemberKeyBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.memberKey_ = o0.p();
    }

    private void setMemberNickName(String s) {
        s.getClass();
        this.memberNickName_ = s;
    }

    private void setMemberNickNameBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.memberNickName_ = o0.p();
    }

    private void setMemberType(int v) {
        this.memberType_ = v;
    }

    private void setMin(String s) {
        s.getClass();
        this.min_ = s;
    }

    private void setMinBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.min_ = o0.p();
    }

    private void setProductInfo(String s) {
        s.getClass();
        this.productInfo_ = s;
    }

    private void setProductInfoBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.productInfo_ = o0.p();
    }

    private void setSessionId(String s) {
        s.getClass();
        this.sessionId_ = s;
    }

    private void setSessionIdBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.sessionId_ = o0.p();
    }

    private void setTmpCall(String s) {
        s.getClass();
        this.tmpCall_ = s;
    }

    private void setTmpCallBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.tmpCall_ = o0.p();
    }

    private void setToken(String s) {
        s.getClass();
        this.token_ = s;
    }

    private void setTokenBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.token_ = o0.p();
    }

    private void setUserId(String s) {
        s.getClass();
        this.userId_ = s;
    }

    private void setUserIdBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.userId_ = o0.p();
    }
}

