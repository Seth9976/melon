package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class NotificationLoginRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        public static final class Promotion implements Serializable {
            public static final class Alert implements Serializable {
                @b("actionType")
                public String actionType;
                @b("buttons")
                public ArrayList buttons;
                @b("message")
                public String message;
                private static final long serialVersionUID = 0x1D32FEF5F601DE9EL;

                public Alert() {
                    this.buttons = null;
                }
            }

            public static final class BANON implements Serializable {
                @b("id")
                public String id;
                @b("message")
                public String message;
                @b("query")
                public String query;
                private static final long serialVersionUID = 0x55206EAC29334B43L;

            }

            public static final class Buttons implements Serializable {
                @b("buttonType")
                public String buttonType;
                @b("label")
                public String label;
                @b("linkUri")
                public String linkUri;
                private static final long serialVersionUID = 7739941334063405011L;

            }

            public static final class Sheet implements Serializable {
                private static final long serialVersionUID = 0x1D9D93DD91992C0FL;
                @b("webViewUri")
                public String webViewUri;

                public Sheet() {
                    this.webViewUri = "";
                }
            }

            @b("alert")
            public Alert alert;
            @b("banOn")
            public BANON banOn;
            private static final long serialVersionUID = 0x6F57FD6CC95824FEL;
            @b("sheet")
            public Sheet sheet;
            @b("tiaraLogData")
            public TiaraLogData tiaraLogData;

            public Promotion() {
                this.banOn = null;
            }
        }

        public static final class REMOVEBANS implements Serializable {
            @b("id")
            public String id;
            private static final long serialVersionUID = 0x708602C8B939CBC2L;

        }

        public static final class TiaraLogData implements Serializable {
            @b("loginPopupId")
            public String loginPopupId;
            @b("loginPopupTitle")
            public String loginPopupTitle;
            private static final long serialVersionUID = 0xFB94FAB3F78E2B3L;

        }

        @b("messageId")
        public String messageId;
        @b("promotion")
        public Promotion promotion;
        @b("removeBans")
        public ArrayList removeBans;
        private static final long serialVersionUID = 0x1F633EC3EEE7F1BL;

        public Response() {
            this.promotion = null;
            this.removeBans = null;
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = -5962630613706234070L;

    public NotificationLoginRes() {
        this.response = null;
    }
}

