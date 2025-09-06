package com.kakaoent.leonchat.data.messages;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001A\u0004\b\b\u0010\u0006R\'\u0010\f\u001A\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0010\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001A\u0004\b\u0011\u0010\u0006R\u0017\u0010\u0012\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001A\u0004\b\u0013\u0010\u0006R\u0017\u0010\u0014\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001A\u0004\b\u0015\u0010\u0006R\u0017\u0010\u0017\u001A\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001AR\u0017\u0010\u001C\u001A\u00020\u001B8\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001FR\u0017\u0010 \u001A\u00020\u001B8\u0006¢\u0006\f\n\u0004\b \u0010\u001D\u001A\u0004\b!\u0010\u001FR\u0017\u0010\"\u001A\u00020\u001B8\u0006¢\u0006\f\n\u0004\b\"\u0010\u001D\u001A\u0004\b#\u0010\u001FR\u0017\u0010$\u001A\u00020\u001B8\u0006¢\u0006\f\n\u0004\b$\u0010\u001D\u001A\u0004\b%\u0010\u001FR\u0017\u0010&\u001A\u00020\u001B8\u0006¢\u0006\f\n\u0004\b&\u0010\u001D\u001A\u0004\b\'\u0010\u001FR\u0017\u0010(\u001A\u00020\u001B8\u0006¢\u0006\f\n\u0004\b(\u0010\u001D\u001A\u0004\b)\u0010\u001FR\u0017\u0010*\u001A\u00020\u001B8\u0006¢\u0006\f\n\u0004\b*\u0010\u001D\u001A\u0004\b+\u0010\u001FR\'\u0010,\u001A\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\u000B8\u0006¢\u0006\f\n\u0004\b,\u0010\r\u001A\u0004\b-\u0010\u000FR\u0017\u0010.\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b.\u0010\u0004\u001A\u0004\b/\u0010\u0006¨\u00060"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/ChatMeta;", "", "", "startDt", "Ljava/lang/String;", "getStartDt", "()Ljava/lang/String;", "endDt", "getEndDt", "Ljava/util/ArrayList;", "Lcom/kakaoent/leonchat/data/messages/WelcomeGuide;", "Lkotlin/collections/ArrayList;", "welcomeGuide", "Ljava/util/ArrayList;", "getWelcomeGuide", "()Ljava/util/ArrayList;", "systemGuide", "getSystemGuide", "usageGuide", "getUsageGuide", "abuseGuide", "getAbuseGuide", "Lcom/kakaoent/leonchat/data/messages/SpamGuide;", "spamGuide", "Lcom/kakaoent/leonchat/data/messages/SpamGuide;", "getSpamGuide", "()Lcom/kakaoent/leonchat/data/messages/SpamGuide;", "", "maxUser", "I", "getMaxUser", "()I", "maxUserCountPerRoom", "getMaxUserCountPerRoom", "minUserCountPerRoom", "getMinUserCountPerRoom", "maxFixedChatCount", "getMaxFixedChatCount", "noticeFixedDuration", "getNoticeFixedDuration", "artistChatFixedDuration", "getArtistChatFixedDuration", "userChatFixedDuration", "getUserChatFixedDuration", "policyBannedWords", "getPolicyBannedWords", "type", "getType", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ChatMeta {
    @NotNull
    private final String abuseGuide;
    private final int artistChatFixedDuration;
    @NotNull
    private final String endDt;
    private final int maxFixedChatCount;
    private final int maxUser;
    private final int maxUserCountPerRoom;
    private final int minUserCountPerRoom;
    private final int noticeFixedDuration;
    @NotNull
    private final ArrayList policyBannedWords;
    @NotNull
    private final SpamGuide spamGuide;
    @NotNull
    private final String startDt;
    @NotNull
    private final String systemGuide;
    @NotNull
    private final String type;
    @NotNull
    private final String usageGuide;
    private final int userChatFixedDuration;
    @NotNull
    private final ArrayList welcomeGuide;

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ChatMeta)) {
            return false;
        }
        if(!q.b(this.startDt, ((ChatMeta)object0).startDt)) {
            return false;
        }
        if(!q.b(this.endDt, ((ChatMeta)object0).endDt)) {
            return false;
        }
        if(!q.b(this.welcomeGuide, ((ChatMeta)object0).welcomeGuide)) {
            return false;
        }
        if(!q.b(this.systemGuide, ((ChatMeta)object0).systemGuide)) {
            return false;
        }
        if(!q.b(this.usageGuide, ((ChatMeta)object0).usageGuide)) {
            return false;
        }
        if(!q.b(this.abuseGuide, ((ChatMeta)object0).abuseGuide)) {
            return false;
        }
        if(!q.b(this.spamGuide, ((ChatMeta)object0).spamGuide)) {
            return false;
        }
        if(this.maxUser != ((ChatMeta)object0).maxUser) {
            return false;
        }
        if(this.maxUserCountPerRoom != ((ChatMeta)object0).maxUserCountPerRoom) {
            return false;
        }
        if(this.minUserCountPerRoom != ((ChatMeta)object0).minUserCountPerRoom) {
            return false;
        }
        if(this.maxFixedChatCount != ((ChatMeta)object0).maxFixedChatCount) {
            return false;
        }
        if(this.noticeFixedDuration != ((ChatMeta)object0).noticeFixedDuration) {
            return false;
        }
        if(this.artistChatFixedDuration != ((ChatMeta)object0).artistChatFixedDuration) {
            return false;
        }
        if(this.userChatFixedDuration != ((ChatMeta)object0).userChatFixedDuration) {
            return false;
        }
        return q.b(this.policyBannedWords, ((ChatMeta)object0).policyBannedWords) ? q.b(this.type, ((ChatMeta)object0).type) : false;
    }

    @Override
    public final int hashCode() {
        return this.type.hashCode() + (this.policyBannedWords.hashCode() + d.b(this.userChatFixedDuration, d.b(this.artistChatFixedDuration, d.b(this.noticeFixedDuration, d.b(this.maxFixedChatCount, d.b(this.minUserCountPerRoom, d.b(this.maxUserCountPerRoom, d.b(this.maxUser, (this.spamGuide.hashCode() + x.b(x.b(x.b((this.welcomeGuide.hashCode() + x.b(this.startDt.hashCode() * 0x1F, 0x1F, this.endDt)) * 0x1F, 0x1F, this.systemGuide), 0x1F, this.usageGuide), 0x1F, this.abuseGuide)) * 0x1F, 0x1F), 0x1F), 0x1F), 0x1F), 0x1F), 0x1F), 0x1F)) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ChatMeta(startDt=");
        stringBuilder0.append(this.startDt);
        stringBuilder0.append(", endDt=");
        stringBuilder0.append(this.endDt);
        stringBuilder0.append(", welcomeGuide=");
        stringBuilder0.append(this.welcomeGuide);
        stringBuilder0.append(", systemGuide=");
        stringBuilder0.append(this.systemGuide);
        stringBuilder0.append(", usageGuide=");
        stringBuilder0.append(this.usageGuide);
        stringBuilder0.append(", abuseGuide=");
        stringBuilder0.append(this.abuseGuide);
        stringBuilder0.append(", spamGuide=");
        stringBuilder0.append(this.spamGuide);
        stringBuilder0.append(", maxUser=");
        stringBuilder0.append(this.maxUser);
        stringBuilder0.append(", maxUserCountPerRoom=");
        stringBuilder0.append(this.maxUserCountPerRoom);
        stringBuilder0.append(", minUserCountPerRoom=");
        stringBuilder0.append(this.minUserCountPerRoom);
        stringBuilder0.append(", maxFixedChatCount=");
        stringBuilder0.append(this.maxFixedChatCount);
        stringBuilder0.append(", noticeFixedDuration=");
        stringBuilder0.append(this.noticeFixedDuration);
        stringBuilder0.append(", artistChatFixedDuration=");
        stringBuilder0.append(this.artistChatFixedDuration);
        stringBuilder0.append(", userChatFixedDuration=");
        stringBuilder0.append(this.userChatFixedDuration);
        stringBuilder0.append(", policyBannedWords=");
        stringBuilder0.append(this.policyBannedWords);
        stringBuilder0.append(", type=");
        return o.r(stringBuilder0, this.type, ')');
    }
}

