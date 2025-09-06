package com.kakao.tiara.data;

import com.kakao.tiara.TiaraSettings;

class Common {
    private String access_timestamp;
    private String ad_track_id;
    private String clog_seq;
    private String deployment;
    private String kakao_app_key;
    private String location_id_permit_level;
    private String location_information_agreement;
    private String page;
    private String section;
    private String session_timeout;
    private String svcdomain;
    private String t_ch;
    private String t_msg_id;
    private String t_obj;
    private String t_src;
    private String third_ad_agree;
    private String third_provide_agree;

    public static Common from(TiaraSettings tiaraSettings0, String s, String s1, String s2, Boolean boolean0, TrafficSource trafficSource0) {
        Common common0 = new Common();
        common0.page = s;
        common0.section = s1;
        common0.session_timeout = String.valueOf(tiaraSettings0.getSessionTimeout());
        common0.svcdomain = tiaraSettings0.getSvcDomain();
        common0.deployment = tiaraSettings0.getDeployment();
        common0.ad_track_id = s2;
        common0.access_timestamp = "1757129645571";
        common0.kakao_app_key = tiaraSettings0.getKakaoAppKey();
        common0.clog_seq = tiaraSettings0.getAndIncreaseSeqNum();
        String s3 = "0";
        if(boolean0 != null) {
            common0.location_information_agreement = boolean0.booleanValue() ? "1" : "0";
        }
        if(tiaraSettings0.getThirdProvideAgree() != null) {
            common0.third_provide_agree = tiaraSettings0.getThirdProvideAgree().booleanValue() ? "1" : "0";
        }
        if(tiaraSettings0.getThirdAdAgree() != null) {
            if(tiaraSettings0.getThirdAdAgree().booleanValue()) {
                s3 = "1";
            }
            common0.third_ad_agree = s3;
        }
        if(trafficSource0 != null) {
            common0.t_src = trafficSource0.source;
            common0.t_ch = trafficSource0.channel;
            common0.t_obj = trafficSource0.object;
            common0.t_msg_id = trafficSource0.messageId;
        }
        return common0;
    }
}

