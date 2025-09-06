package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class LoginLoginRes extends ResponseV4Res {
    public static class ErrorMessage {
        public static final ErrorMessage EA0001;
        public static final ErrorMessage EA0002;
        public static final ErrorMessage EA0003;
        public static final ErrorMessage EL0001;
        public static final ErrorMessage EL3163;
        public static final ErrorMessage ERL002;
        public static final ErrorMessage ERL003;
        public static final ErrorMessage ERL006;
        public static final ErrorMessage ERL069;
        public static final ErrorMessage ERL108;
        public static final ErrorMessage ERL114;
        private static final ErrorMessage[] ERROR_MSGS;
        public String code;
        public String msg;

        static {
            ErrorMessage loginLoginRes$ErrorMessage0 = new ErrorMessage("EA0001", "Invalid required paramter");
            ErrorMessage.EA0001 = loginLoginRes$ErrorMessage0;
            ErrorMessage loginLoginRes$ErrorMessage1 = new ErrorMessage("EA0002", "Invalid CPID or CPKEY");
            ErrorMessage.EA0002 = loginLoginRes$ErrorMessage1;
            ErrorMessage loginLoginRes$ErrorMessage2 = new ErrorMessage("EA0003", "Invalid MDN");
            ErrorMessage.EA0003 = loginLoginRes$ErrorMessage2;
            ErrorMessage loginLoginRes$ErrorMessage3 = new ErrorMessage("EL0001", "Login error (icas, server fault..");
            ErrorMessage.EL0001 = loginLoginRes$ErrorMessage3;
            ErrorMessage loginLoginRes$ErrorMessage4 = new ErrorMessage("EL3163", "unknown error");
            ErrorMessage.EL3163 = loginLoginRes$ErrorMessage4;
            ErrorMessage loginLoginRes$ErrorMessage5 = new ErrorMessage("ERL002", "Password error");
            ErrorMessage.ERL002 = loginLoginRes$ErrorMessage5;
            ErrorMessage loginLoginRes$ErrorMessage6 = new ErrorMessage("ERL003", "Password error exceed");
            ErrorMessage.ERL003 = loginLoginRes$ErrorMessage6;
            ErrorMessage loginLoginRes$ErrorMessage7 = new ErrorMessage("ERL006", "Invalid Id");
            ErrorMessage.ERL006 = loginLoginRes$ErrorMessage7;
            ErrorMessage loginLoginRes$ErrorMessage8 = new ErrorMessage("ERL069", "Invalid token");
            ErrorMessage.ERL069 = loginLoginRes$ErrorMessage8;
            ErrorMessage loginLoginRes$ErrorMessage9 = new ErrorMessage("ERL108", "Kakao join");
            ErrorMessage.ERL108 = loginLoginRes$ErrorMessage9;
            ErrorMessage loginLoginRes$ErrorMessage10 = new ErrorMessage("ERL114", "Close Kakao session and sign up");
            ErrorMessage.ERL114 = loginLoginRes$ErrorMessage10;
            ErrorMessage.ERROR_MSGS = new ErrorMessage[]{loginLoginRes$ErrorMessage0, loginLoginRes$ErrorMessage1, loginLoginRes$ErrorMessage2, loginLoginRes$ErrorMessage3, loginLoginRes$ErrorMessage4, loginLoginRes$ErrorMessage5, loginLoginRes$ErrorMessage6, loginLoginRes$ErrorMessage7, loginLoginRes$ErrorMessage8, loginLoginRes$ErrorMessage9, loginLoginRes$ErrorMessage10};
        }

        private ErrorMessage(String s, String s1) {
            this.code = s;
            this.msg = s1;
        }

        public static String getMessage(String s) {
            ErrorMessage[] arr_loginLoginRes$ErrorMessage = ErrorMessage.ERROR_MSGS;
            for(int v = 0; v < arr_loginLoginRes$ErrorMessage.length; ++v) {
                ErrorMessage loginLoginRes$ErrorMessage0 = arr_loginLoginRes$ErrorMessage[v];
                if(loginLoginRes$ErrorMessage0.code.equalsIgnoreCase(s)) {
                    return loginLoginRes$ErrorMessage0.msg;
                }
            }
            return null;
        }

        public static boolean hasError(String s) {
            ErrorMessage[] arr_loginLoginRes$ErrorMessage = ErrorMessage.ERROR_MSGS;
            for(int v = 0; v < arr_loginLoginRes$ErrorMessage.length; ++v) {
                if(arr_loginLoginRes$ErrorMessage[v].code.equalsIgnoreCase(s)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class Response extends ResponseBase {
        @b("ADULTFLG")
        public String adultFlag;
        @b("APPUSERID")
        public String appUserId;
        @b("ARTISTID")
        public String artistId;
        @b("DISPLAYLOGINID")
        public String displayLoginId;
        @b("DISPLAYMEMBERID")
        public String displayMemberId;
        @b("ISSETADULTAUTHNUM")
        public String isSetAdultAuthNum;
        @b("JOINTYPE")
        public String joinType;
        @b("JOINURL")
        public String joinUrl;
        @b("LANGDCFYN")
        public String langDcfYn;
        @b("LOGINTYPE")
        public String loginType;
        @b("MACOK")
        public String macOk;
        @b("MEMBERID")
        public String memberId;
        @b("MEMBERKEY")
        public int memberKey;
        @b("MEMBERNAME")
        public String memberName;
        @b("MEMBERNICKNAME")
        public String memberNickname;
        @b("MEMBERTYPE")
        public int memberType;
        @b("MIN")
        public String min;
        @b("MYINFONOTIMSG")
        public String myInfoNotiMsg;
        @b("REALNAME")
        public String realName;
        @b("SESSIONID")
        public String sessionId;
        @b("SONGDCFYN")
        public String songDcfYn;
        @b("TMPCALL")
        public String tmpCall;
        @b("TOKEN")
        public String token;

        public Response() {
            this.token = "";
            this.loginType = "";
            this.sessionId = "";
            this.macOk = "";
            this.min = "";
            this.songDcfYn = "";
            this.langDcfYn = "";
            this.adultFlag = "";
            this.artistId = "";
            this.realName = "";
            this.memberNickname = "";
            this.memberName = "";
            this.isSetAdultAuthNum = "";
            this.memberId = "";
            this.displayMemberId = "";
            this.displayLoginId = "";
            this.joinUrl = "";
            this.joinType = "";
            this.myInfoNotiMsg = "";
            this.tmpCall = "";
            this.appUserId = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("errorCode")
    public String errorCode;
    @b("errorMesg")
    public String errorMsg;
    @b("response")
    public Response response;
    @b("resultCode")
    public String resultCode;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

