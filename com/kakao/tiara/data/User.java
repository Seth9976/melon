package com.kakao.tiara.data;

import com.kakao.tiara.SessionIds;
import com.kakao.tiara.TiaraSettings;

class User {
    private String access_token;
    private String account_id;
    private String adid;
    private String adid_enabled;
    private String app_install_date;
    private String app_user_id;
    private String daum_user_id;
    private String isuid;
    private String melon_id;
    private String suid;
    private String tsid;
    private String tuid;
    private String uuid;

    public static User from(TiaraSettings tiaraSettings0, SessionIds sessionIds0, Boolean boolean0) {
        User user0 = new User();
        user0.uuid = tiaraSettings0.getUuid();
        user0.adid = tiaraSettings0.getAdid();
        if(tiaraSettings0.getLimitAdTrackingEnabled() != null) {
            user0.adid_enabled = tiaraSettings0.getLimitAdTrackingEnabled().booleanValue() ? "0" : "1";
        }
        if(boolean0 != null && !boolean0.booleanValue()) {
            return user0;
        }
        user0.tuid = tiaraSettings0.getTuid();
        user0.tsid = sessionIds0.getTsid();
        user0.suid = sessionIds0.getSuid();
        user0.isuid = sessionIds0.getIsuid();
        user0.access_token = tiaraSettings0.getAccessToken();
        user0.app_user_id = tiaraSettings0.getAppUserId();
        user0.daum_user_id = tiaraSettings0.getDaumUserId();
        user0.melon_id = tiaraSettings0.getMelonId();
        user0.account_id = tiaraSettings0.getAccountId();
        user0.app_install_date = tiaraSettings0.getAppInstallDate();
        return user0;
    }
}

