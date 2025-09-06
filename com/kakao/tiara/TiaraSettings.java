package com.kakao.tiara;

import android.text.TextUtils;
import java.util.HashMap;

public class TiaraSettings {
    public static class Builder {
        private String accessToken;
        private String accountId;
        private String adid;
        private String appAdTrackId;
        private Boolean appLogEnabled;
        private String appUserId;
        private Integer batchInterval;
        private Integer batchSize;
        private String daumUserId;
        private String deployment;
        private Boolean isLimitAdTrackingEnabled;
        private String kakaoAppKey;
        private String melonId;
        private Boolean thirdAdAgree;
        private Boolean thirdProvideAgree;
        private HashMap userExAccount;
        private HashMap userExAnonymous;

        public static String access$000(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.appAdTrackId;
        }

        public static String access$100(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.deployment;
        }

        public static Boolean access$1000(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.thirdAdAgree;
        }

        public static HashMap access$1100(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.userExAccount;
        }

        public static HashMap access$1200(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.userExAnonymous;
        }

        public static Boolean access$1300(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.appLogEnabled;
        }

        public static Boolean access$1400(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.isLimitAdTrackingEnabled;
        }

        public static Integer access$1500(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.batchInterval;
        }

        public static Integer access$1600(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.batchSize;
        }

        public static String access$200(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.appUserId;
        }

        public static String access$300(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.daumUserId;
        }

        public static String access$400(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.melonId;
        }

        public static String access$500(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.accountId;
        }

        public static String access$600(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.adid;
        }

        public static String access$700(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.accessToken;
        }

        public static String access$800(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.kakaoAppKey;
        }

        public static Boolean access$900(Builder tiaraSettings$Builder0) {
            return tiaraSettings$Builder0.thirdProvideAgree;
        }

        public Builder accessToken(String s) {
            this.accessToken = s;
            return this;
        }

        public Builder accountId(String s) {
            this.accountId = s;
            return this;
        }

        public Builder adid(String s) {
            this.adid = s;
            return this;
        }

        public Builder appAdTrackId(String s) {
            this.appAdTrackId = s;
            return this;
        }

        public Builder appUserId(String s) {
            this.appUserId = s;
            return this;
        }

        public Builder batchInterval(int v) {
            this.batchInterval = v;
            return this;
        }

        public Builder batchSize(int v) {
            this.batchSize = v;
            return this;
        }

        public TiaraSettings build() {
            return new TiaraSettings(this, null);
        }

        public Builder daumUserId(String s) {
            this.daumUserId = s;
            return this;
        }

        public Builder deployment(String s) {
            this.deployment = s;
            return this;
        }

        public Builder disableAppLog() {
            this.appLogEnabled = Boolean.FALSE;
            return this;
        }

        public Builder enableAppLog() {
            this.appLogEnabled = Boolean.TRUE;
            return this;
        }

        public Builder kakaoAppKey(String s) {
            this.kakaoAppKey = s;
            return this;
        }

        public Builder limitAdTrackingEnabled(boolean z) {
            this.isLimitAdTrackingEnabled = Boolean.valueOf(z);
            return this;
        }

        public Builder melonId(String s) {
            this.melonId = s;
            return this;
        }

        public Builder thirdAdAgree(Boolean boolean0) {
            this.thirdAdAgree = boolean0;
            return this;
        }

        public Builder thirdProvideAgree(Boolean boolean0) {
            this.thirdProvideAgree = boolean0;
            return this;
        }

        public Builder userExAccount(HashMap hashMap0) {
            this.userExAccount = hashMap0;
            return this;
        }

        public Builder userExAnonymous(HashMap hashMap0) {
            this.userExAnonymous = hashMap0;
            return this;
        }
    }

    private static final int DEFAULT_BATCH_INTERVAL_SECONDS = 30;
    private static final int DEFAULT_BATCH_SIZE = 5;
    private String accessToken;
    private String accountId;
    private String adid;
    private String appAdTrackId;
    private String appInstallDate;
    private Boolean appLogEnabled;
    private String appUserId;
    private String appVersion;
    private int batchInterval;
    private int batchSize;
    private boolean cookieEnabled;
    private boolean cookieSyncAtInstanceEnabled;
    private String daumUserId;
    private String deployment;
    private Boolean isLimitAdTrackingEnabled;
    private String kakaoAppKey;
    private String melonId;
    private int seqNum;
    private int sessionTimeout;
    private String svcDomain;
    private Boolean thirdAdAgree;
    private Boolean thirdProvideAgree;
    private String tuid;
    private HashMap userExAccount;
    private HashMap userExAnonymous;
    private String uuid;

    private TiaraSettings(Builder tiaraSettings$Builder0) {
        this.sessionTimeout = 300;
        this.seqNum = 1;
        this.cookieEnabled = false;
        this.cookieSyncAtInstanceEnabled = true;
        this.batchInterval = 30;
        this.batchSize = 5;
        this.appAdTrackId = Builder.access$000(tiaraSettings$Builder0);
        this.deployment = Builder.access$100(tiaraSettings$Builder0);
        this.appUserId = Builder.access$200(tiaraSettings$Builder0);
        this.daumUserId = Builder.access$300(tiaraSettings$Builder0);
        this.melonId = Builder.access$400(tiaraSettings$Builder0);
        this.accountId = Builder.access$500(tiaraSettings$Builder0);
        this.adid = Builder.access$600(tiaraSettings$Builder0);
        this.accessToken = Builder.access$700(tiaraSettings$Builder0);
        this.kakaoAppKey = Builder.access$800(tiaraSettings$Builder0);
        this.thirdProvideAgree = Builder.access$900(tiaraSettings$Builder0);
        this.thirdAdAgree = Builder.access$1000(tiaraSettings$Builder0);
        this.userExAccount = Builder.access$1100(tiaraSettings$Builder0);
        this.userExAnonymous = Builder.access$1200(tiaraSettings$Builder0);
        this.appLogEnabled = Builder.access$1300(tiaraSettings$Builder0);
        this.isLimitAdTrackingEnabled = Builder.access$1400(tiaraSettings$Builder0);
        if(Builder.access$1500(tiaraSettings$Builder0) != null) {
            this.batchInterval = (int)Builder.access$1500(tiaraSettings$Builder0);
        }
        if(Builder.access$1600(tiaraSettings$Builder0) != null) {
            this.batchSize = (int)Builder.access$1600(tiaraSettings$Builder0);
        }
    }

    public TiaraSettings(Builder tiaraSettings$Builder0, com.kakao.tiara.TiaraSettings.1 tiaraSettings$10) {
        this(tiaraSettings$Builder0);
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getAdid() {
        return this.adid;
    }

    public String getAndIncreaseSeqNum() {
        int v = this.seqNum;
        this.seqNum = v + 1;
        return String.valueOf(v);
    }

    public String getAppAdTrackId() {
        return this.appAdTrackId;
    }

    public String getAppInstallDate() {
        return this.appInstallDate;
    }

    public String getAppUserId() {
        return this.appUserId;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public int getBatchInterval() {
        return this.batchInterval;
    }

    public long getBatchIntervalMillis() {
        return ((long)this.batchInterval) * 1000L;
    }

    public int getBatchSize() {
        return this.batchSize;
    }

    public String getDaumUserId() {
        return this.daumUserId;
    }

    public String getDeployment() {
        return this.deployment;
    }

    public String getKakaoAppKey() {
        return this.kakaoAppKey;
    }

    public Boolean getLimitAdTrackingEnabled() {
        return this.isLimitAdTrackingEnabled;
    }

    public String getMelonId() {
        return this.melonId;
    }

    public int getSessionTimeout() {
        return this.sessionTimeout;
    }

    public String getSvcDomain() {
        return this.svcDomain;
    }

    public Boolean getThirdAdAgree() {
        return this.thirdAdAgree;
    }

    public Boolean getThirdProvideAgree() {
        return this.thirdProvideAgree;
    }

    public String getTuid() {
        return this.tuid;
    }

    public HashMap getUserExAccount() {
        return this.userExAccount;
    }

    public HashMap getUserExAnonymous() {
        return this.userExAnonymous;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void initialize(GlobalSettings tiaraManager$GlobalSettings0) {
        this.tuid = tiaraManager$GlobalSettings0.getTuid();
        this.uuid = tiaraManager$GlobalSettings0.getUuid();
        this.appInstallDate = tiaraManager$GlobalSettings0.getAppInstallDate();
        this.appVersion = tiaraManager$GlobalSettings0.getAppVersion();
        this.sessionTimeout = tiaraManager$GlobalSettings0.getSessionTimeout();
        this.cookieEnabled = tiaraManager$GlobalSettings0.isCookieEnabled();
        this.cookieSyncAtInstanceEnabled = tiaraManager$GlobalSettings0.isCookieSyncAtInstanceEnabled();
        if(TextUtils.isEmpty(this.deployment)) {
            this.deployment = tiaraManager$GlobalSettings0.getDeployment();
        }
        if(this.appLogEnabled == null) {
            this.appLogEnabled = Boolean.valueOf(!tiaraManager$GlobalSettings0.isAppLogBlocked());
        }
        this.syncAccountIdCookie();
        this.syncAdidCookie();
        this.syncAdTrackingEnabledCookie();
        this.syncTAnoCookie();
    }

    public boolean isAppLogEnabled() {
        return this.appLogEnabled != null && this.appLogEnabled.booleanValue();
    }

    @Deprecated
    public boolean isLimitAdTrackingEnabled() {
        return this.isLimitAdTrackingEnabled != null && this.isLimitAdTrackingEnabled.booleanValue();
    }

    public void resetSeqNum() {
        this.seqNum = 1;
    }

    public void setAccessToken(String s) {
        this.accessToken = s;
    }

    public void setAccountId(String s) {
        this.accountId = s;
        this.syncAccountIdCookie();
    }

    @Deprecated
    public void setAdid(String s) {
        this.adid = s;
        this.syncAdidCookie();
        this.syncTAnoCookie();
    }

    public void setAdid(String s, boolean z) {
        this.adid = s;
        this.isLimitAdTrackingEnabled = Boolean.valueOf(z);
        this.syncAdidCookie();
        this.syncAdTrackingEnabledCookie();
        this.syncTAnoCookie();
    }

    public void setAppUserId(String s) {
        this.appUserId = s;
    }

    public void setDaumUserId(String s) {
        this.daumUserId = s;
    }

    @Deprecated
    public void setLimitAdTrackingEnabled(boolean z) {
        this.isLimitAdTrackingEnabled = Boolean.valueOf(z);
        this.syncAdTrackingEnabledCookie();
        this.syncTAnoCookie();
    }

    public void setMelonId(String s) {
        this.melonId = s;
    }

    public void setSvcDomain(String s) {
        this.svcDomain = s;
    }

    public void setThirdAdAgree(Boolean boolean0) {
        this.thirdAdAgree = boolean0;
    }

    public void setThirdProvideAgree(Boolean boolean0) {
        this.thirdProvideAgree = boolean0;
    }

    public void setUserExAccount(HashMap hashMap0) {
        this.userExAccount = hashMap0;
    }

    public void setUserExAnonymous(HashMap hashMap0) {
        this.userExAnonymous = hashMap0;
    }

    private void syncAccountIdCookie() {
        if(this.cookieEnabled && this.cookieSyncAtInstanceEnabled) {
            if(TextUtils.isEmpty(this.accountId)) {
                TiaraCookieUtils.deleteAccountIdCookie();
                return;
            }
            TiaraCookieUtils.setAccountIdCookie(this.accountId);
        }
    }

    private void syncAdTrackingEnabledCookie() {
        if(this.cookieEnabled && this.cookieSyncAtInstanceEnabled) {
            Boolean boolean0 = this.isLimitAdTrackingEnabled;
            if(boolean0 != null) {
                TiaraCookieUtils.setAdidTrackingEnabledCookie(!boolean0.booleanValue());
            }
        }
    }

    private void syncAdidCookie() {
        if(this.cookieEnabled && this.cookieSyncAtInstanceEnabled && !TextUtils.isEmpty(this.adid)) {
            TiaraCookieUtils.setAdidCookie(this.adid);
        }
    }

    private void syncTAnoCookie() {
        if(this.cookieEnabled && this.cookieSyncAtInstanceEnabled) {
            TiaraCookieUtils.setTAnoCookie(this.uuid, this.adid, (this.isLimitAdTrackingEnabled == null ? null : Boolean.valueOf(!this.isLimitAdTrackingEnabled.booleanValue())));
        }
    }

    class com.kakao.tiara.TiaraSettings.1 {
    }

}

