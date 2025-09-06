package com.kakaoent.leonchat.data.messages;

import U4.x;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006R\u001A\u0010\u0007\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001A\u0004\b\b\u0010\u0006R\u001A\u0010\t\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001A\u0004\b\n\u0010\u0006R0\u0010\r\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/LeonUserInfo;", "Lcom/kakaoent/leonchat/data/messages/FromUser;", "", "userId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "name", "c", "grade", "b", "", "", "extraData", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LeonUserInfo extends FromUser {
    @Nullable
    private Map extraData;
    @NotNull
    private final String grade;
    @NotNull
    private final String name;
    @NotNull
    private final String userId;

    public LeonUserInfo(String s, String s1, String s2, Map map0) {
        q.g(s, "userId");
        q.g(s1, "name");
        super();
        this.userId = s;
        this.name = s1;
        this.grade = s2;
        this.extraData = map0;
    }

    public final Map a() {
        return this.extraData;
    }

    public final String b() {
        return this.grade;
    }

    public final String c() {
        return this.name;
    }

    public final String d() {
        return this.userId;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof LeonUserInfo)) {
            return false;
        }
        if(!q.b(this.userId, ((LeonUserInfo)object0).userId)) {
            return false;
        }
        if(!q.b(this.name, ((LeonUserInfo)object0).name)) {
            return false;
        }
        return q.b(this.grade, ((LeonUserInfo)object0).grade) ? q.b(this.extraData, ((LeonUserInfo)object0).extraData) : false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(x.b(this.userId.hashCode() * 0x1F, 0x1F, this.name), 0x1F, this.grade);
        return this.extraData == null ? v : v + this.extraData.hashCode();
    }

    @Override
    public final String toString() {
        return "LeonUserInfo(userId=" + this.userId + ", name=" + this.name + ", grade=" + this.grade + ", extraData=" + this.extraData + ')';
    }
}

