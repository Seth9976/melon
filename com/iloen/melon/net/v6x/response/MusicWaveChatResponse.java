package com.iloen.melon.net.v6x.response;

import A7.d;
import S7.b;
import com.melon.net.res.common.ResponseBase;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveChatResponse;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/MusicWaveChatResponse$Response;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/MusicWaveChatResponse$Response;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/MusicWaveChatResponse$Response;)V", "Response", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveChatResponse extends ResponseV6Res {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\u0004\b\f\u0010\rJ\u000B\u0010\"\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010#\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010$\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010%\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\t\u0010&\u001A\u00020\bH\u00C6\u0003J\u000B\u0010\'\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010(\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010)\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003Jg\u0010*\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001A\u00020\b2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003H\u00C6\u0001J\u0013\u0010+\u001A\u00020\b2\b\u0010,\u001A\u0004\u0018\u00010-H\u00D6\u0003J\t\u0010.\u001A\u00020/H\u00D6\u0001J\t\u00100\u001A\u00020\u0003H\u00D6\u0001R \u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u000F\"\u0004\b\u0013\u0010\u0011R \u0010\u0005\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u000F\"\u0004\b\u0015\u0010\u0011R \u0010\u0006\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u000F\"\u0004\b\u0017\u0010\u0011R\u001E\u0010\u0007\u001A\u00020\b8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR \u0010\t\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u000F\"\u0004\b\u001D\u0010\u0011R \u0010\n\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u000F\"\u0004\b\u001F\u0010\u0011R \u0010\u000B\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u000F\"\u0004\b!\u0010\u0011\u00A8\u00061"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveChatResponse$Response;", "Lcom/melon/net/res/common/ResponseBase;", "cmtSeq", "", "comment", "messageType", "userName", "tempActFlag", "", "memberKey", "userImageUrl", "regDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCmtSeq", "()Ljava/lang/String;", "setCmtSeq", "(Ljava/lang/String;)V", "getComment", "setComment", "getMessageType", "setMessageType", "getUserName", "setUserName", "getTempActFlag", "()Z", "setTempActFlag", "(Z)V", "getMemberKey", "setMemberKey", "getUserImageUrl", "setUserImageUrl", "getRegDate", "setRegDate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response extends ResponseBase {
        public static final int $stable = 8;
        @b("CMTSEQ")
        @Nullable
        private String cmtSeq;
        @b("COMMENT")
        @Nullable
        private String comment;
        @b("MEMBERKEY")
        @Nullable
        private String memberKey;
        @b("MESSAGETYPE")
        @Nullable
        private String messageType;
        @b("REGDATE")
        @Nullable
        private String regDate;
        @b("TEMPACTFLAG")
        private boolean tempActFlag;
        @b("IMAGEURL")
        @Nullable
        private String userImageUrl;
        @b("NAME")
        @Nullable
        private String userName;

        public Response() {
            this(null, null, null, null, false, null, null, null, 0xFF, null);
        }

        public Response(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, boolean z, @Nullable String s4, @Nullable String s5, @Nullable String s6) {
            this.cmtSeq = s;
            this.comment = s1;
            this.messageType = s2;
            this.userName = s3;
            this.tempActFlag = z;
            this.memberKey = s4;
            this.userImageUrl = s5;
            this.regDate = s6;
        }

        public Response(String s, String s1, String s2, String s3, boolean z, String s4, String s5, String s6, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = null;
            }
            if((v & 2) != 0) {
                s1 = null;
            }
            if((v & 4) != 0) {
                s2 = null;
            }
            if((v & 8) != 0) {
                s3 = null;
            }
            if((v & 16) != 0) {
                z = false;
            }
            if((v & 0x20) != 0) {
                s4 = null;
            }
            if((v & 0x40) != 0) {
                s5 = null;
            }
            this(s, s1, s2, s3, z, s4, s5, ((v & 0x80) == 0 ? s6 : null));
        }

        @Nullable
        public final String component1() {
            return this.cmtSeq;
        }

        @Nullable
        public final String component2() {
            return this.comment;
        }

        @Nullable
        public final String component3() {
            return this.messageType;
        }

        @Nullable
        public final String component4() {
            return this.userName;
        }

        public final boolean component5() {
            return this.tempActFlag;
        }

        @Nullable
        public final String component6() {
            return this.memberKey;
        }

        @Nullable
        public final String component7() {
            return this.userImageUrl;
        }

        @Nullable
        public final String component8() {
            return this.regDate;
        }

        @NotNull
        public final Response copy(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, boolean z, @Nullable String s4, @Nullable String s5, @Nullable String s6) {
            return new Response(s, s1, s2, s3, z, s4, s5, s6);
        }

        public static Response copy$default(Response musicWaveChatResponse$Response0, String s, String s1, String s2, String s3, boolean z, String s4, String s5, String s6, int v, Object object0) {
            if((v & 1) != 0) {
                s = musicWaveChatResponse$Response0.cmtSeq;
            }
            if((v & 2) != 0) {
                s1 = musicWaveChatResponse$Response0.comment;
            }
            if((v & 4) != 0) {
                s2 = musicWaveChatResponse$Response0.messageType;
            }
            if((v & 8) != 0) {
                s3 = musicWaveChatResponse$Response0.userName;
            }
            if((v & 16) != 0) {
                z = musicWaveChatResponse$Response0.tempActFlag;
            }
            if((v & 0x20) != 0) {
                s4 = musicWaveChatResponse$Response0.memberKey;
            }
            if((v & 0x40) != 0) {
                s5 = musicWaveChatResponse$Response0.userImageUrl;
            }
            if((v & 0x80) != 0) {
                s6 = musicWaveChatResponse$Response0.regDate;
            }
            return musicWaveChatResponse$Response0.copy(s, s1, s2, s3, z, s4, s5, s6);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Response)) {
                return false;
            }
            if(!q.b(this.cmtSeq, ((Response)object0).cmtSeq)) {
                return false;
            }
            if(!q.b(this.comment, ((Response)object0).comment)) {
                return false;
            }
            if(!q.b(this.messageType, ((Response)object0).messageType)) {
                return false;
            }
            if(!q.b(this.userName, ((Response)object0).userName)) {
                return false;
            }
            if(this.tempActFlag != ((Response)object0).tempActFlag) {
                return false;
            }
            if(!q.b(this.memberKey, ((Response)object0).memberKey)) {
                return false;
            }
            return q.b(this.userImageUrl, ((Response)object0).userImageUrl) ? q.b(this.regDate, ((Response)object0).regDate) : false;
        }

        @Nullable
        public final String getCmtSeq() {
            return this.cmtSeq;
        }

        @Nullable
        public final String getComment() {
            return this.comment;
        }

        @Nullable
        public final String getMemberKey() {
            return this.memberKey;
        }

        @Nullable
        public final String getMessageType() {
            return this.messageType;
        }

        @Nullable
        public final String getRegDate() {
            return this.regDate;
        }

        public final boolean getTempActFlag() {
            return this.tempActFlag;
        }

        @Nullable
        public final String getUserImageUrl() {
            return this.userImageUrl;
        }

        @Nullable
        public final String getUserName() {
            return this.userName;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = d.e(((((this.cmtSeq == null ? 0 : this.cmtSeq.hashCode()) * 0x1F + (this.comment == null ? 0 : this.comment.hashCode())) * 0x1F + (this.messageType == null ? 0 : this.messageType.hashCode())) * 0x1F + (this.userName == null ? 0 : this.userName.hashCode())) * 0x1F, 0x1F, this.tempActFlag);
            int v2 = this.memberKey == null ? 0 : this.memberKey.hashCode();
            int v3 = this.userImageUrl == null ? 0 : this.userImageUrl.hashCode();
            String s = this.regDate;
            if(s != null) {
                v = s.hashCode();
            }
            return ((v1 + v2) * 0x1F + v3) * 0x1F + v;
        }

        public final void setCmtSeq(@Nullable String s) {
            this.cmtSeq = s;
        }

        public final void setComment(@Nullable String s) {
            this.comment = s;
        }

        public final void setMemberKey(@Nullable String s) {
            this.memberKey = s;
        }

        public final void setMessageType(@Nullable String s) {
            this.messageType = s;
        }

        public final void setRegDate(@Nullable String s) {
            this.regDate = s;
        }

        public final void setTempActFlag(boolean z) {
            this.tempActFlag = z;
        }

        public final void setUserImageUrl(@Nullable String s) {
            this.userImageUrl = s;
        }

        public final void setUserName(@Nullable String s) {
            this.userName = s;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        @NotNull
        public String toString() {
            String s = this.messageType;
            String s1 = this.userName;
            boolean z = this.tempActFlag;
            String s2 = this.memberKey;
            String s3 = this.userImageUrl;
            String s4 = this.regDate;
            StringBuilder stringBuilder0 = d.o("Response(cmtSeq=", this.cmtSeq, ", comment=", this.comment, ", messageType=");
            d.u(stringBuilder0, s, ", userName=", s1, ", tempActFlag=");
            Y.y(stringBuilder0, z, ", memberKey=", s2, ", userImageUrl=");
            return d.n(stringBuilder0, s3, ", regDate=", s4, ")");
        }
    }

    public static final int $stable = 8;
    @b("response")
    @Nullable
    private Response response;

    @Nullable
    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable Response musicWaveChatResponse$Response0) {
        this.response = musicWaveChatResponse$Response0;
    }
}

