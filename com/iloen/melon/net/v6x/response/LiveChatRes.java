package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;

public class LiveChatRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        public static class CHATSDKINFO implements Serializable {
            public static class CHAT implements Serializable {
                @b("ID")
                public String id;

                public CHAT() {
                    this.id = null;
                }

                @Override
                public String toString() {
                    return ToStringUtil.toStringFields(this);
                }
            }

            public static class Message implements Serializable {
                public static class WELCOME implements Serializable {
                    @b("IMGURL")
                    public String imgUrl;
                    @b("ISARTIST")
                    public boolean isArtist;
                    @b("NAME")
                    public String name;
                    @b("TEXT")
                    public String text;

                    public WELCOME() {
                        this.imgUrl = null;
                        this.name = null;
                        this.text = null;
                        this.isArtist = false;
                    }

                    @Override
                    public String toString() {
                        return ToStringUtil.toStringFields(this);
                    }
                }

                @b("BANOFF")
                public String banOff;
                @b("BANON")
                public String banOn;
                @b("FORBIDDENWORD")
                public String forbiddenWord;
                @b("FREEZEOFF")
                public String freezeOff;
                @b("FREEZEON")
                public String freezeOn;
                @b("NOTICE")
                public String notice;
                @b("SPAM")
                public String spam;
                @b("WELCOME")
                public WELCOME welcome;

                public Message() {
                    this.notice = null;
                    this.welcome = null;
                    this.freezeOn = null;
                    this.freezeOff = null;
                    this.banOn = null;
                    this.banOff = null;
                    this.forbiddenWord = null;
                    this.spam = null;
                }

                @Override
                public String toString() {
                    return ToStringUtil.toStringFields(this);
                }
            }

            public static class USER implements Serializable {
                @b("DEGREE")
                public String degree;
                @b("ID")
                public String id;
                @b("IMGURL")
                public String imgUrl;
                @b("ISARTIST")
                public boolean isArtist;
                @b("MEMBERKEY")
                public String memberkey;
                @b("NAME")
                public String name;

                public USER() {
                    this.id = null;
                    this.imgUrl = null;
                    this.memberkey = null;
                    this.name = null;
                    this.isArtist = false;
                    this.degree = null;
                }

                @Override
                public String toString() {
                    return ToStringUtil.toStringFields(this);
                }
            }

            @b("AUTHTOKEN")
            public String authToken;
            @b("CHAT")
            public CHAT chat;
            @b("ISBAN")
            public Boolean isBan;
            @b("ISCHATAUTHORITY")
            public Boolean isChatAuthority;
            @b("ISFREEZE")
            public Boolean isFreeze;
            @b("MESSAGE")
            public Message message;
            @b("USER")
            public USER user;

            public CHATSDKINFO() {
                this.chat = null;
                this.user = null;
                this.message = null;
                this.isChatAuthority = Boolean.FALSE;
                this.isBan = Boolean.FALSE;
                this.isFreeze = Boolean.FALSE;
                this.authToken = null;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("CHATSDKINFO")
        public CHATSDKINFO chatSdkInfo;
        @b("USECHATSDKINFO")
        public boolean useChatSdkInfo;

        public Response() {
            this.useChatSdkInfo = false;
            this.chatSdkInfo = null;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;

    public LiveChatRes() {
        this.response = null;
    }
}

