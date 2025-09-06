package com.melon.data.service;

import A7.d;
import U4.x;
import androidx.annotation.Keep;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.system.AppUtils;
import e1.u;
import java.util.List;
import k8.Y;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import va.o;

@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000BJ\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\u000F\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003JA\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\u000E\b\u0002\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001J\t\u0010\u001E\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\rR\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u001F"}, d2 = {"Lcom/melon/data/service/AlarmListRequest;", "", "cpId", "", "cpKey", "appVersion", "memberKey", "alarmList", "", "Lcom/iloen/melon/alarm/MusicAlarmStaticForm;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCpId", "()Ljava/lang/String;", "getCpKey", "getAppVersion", "getMemberKey", "getAlarmList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AlarmListRequest {
    public static final int $stable = 8;
    @NotNull
    private final List alarmList;
    @NotNull
    private final String appVersion;
    @NotNull
    private final String cpId;
    @NotNull
    private final String cpKey;
    @NotNull
    private final String memberKey;

    public AlarmListRequest(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull List list0) {
        q.g(s, "cpId");
        q.g(s1, "cpKey");
        q.g(s2, "appVersion");
        q.g(s3, "memberKey");
        q.g(list0, "alarmList");
        super();
        this.cpId = s;
        this.cpKey = s1;
        this.appVersion = s2;
        this.memberKey = s3;
        this.alarmList = list0;
    }

    public AlarmListRequest(String s, String s1, String s2, String s3, List list0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = Z.l(MelonAppBase.Companion);
        }
        if((v & 2) != 0) {
            MelonAppBase.Companion.getClass();
            s1 = t.a().getMelonCpKey();
        }
        if((v & 4) != 0) {
            MelonAppBase.Companion.getClass();
            s2 = AppUtils.getVersionName(t.a().getContext());
        }
        if((v & 8) != 0) {
            s3 = u.v(((e0)o.a()).j());
        }
        this(s, s1, s2, s3, list0);
    }

    @NotNull
    public final String component1() {
        return this.cpId;
    }

    @NotNull
    public final String component2() {
        return this.cpKey;
    }

    @NotNull
    public final String component3() {
        return this.appVersion;
    }

    @NotNull
    public final String component4() {
        return this.memberKey;
    }

    @NotNull
    public final List component5() {
        return this.alarmList;
    }

    @NotNull
    public final AlarmListRequest copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull List list0) {
        q.g(s, "cpId");
        q.g(s1, "cpKey");
        q.g(s2, "appVersion");
        q.g(s3, "memberKey");
        q.g(list0, "alarmList");
        return new AlarmListRequest(s, s1, s2, s3, list0);
    }

    public static AlarmListRequest copy$default(AlarmListRequest alarmListRequest0, String s, String s1, String s2, String s3, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            s = alarmListRequest0.cpId;
        }
        if((v & 2) != 0) {
            s1 = alarmListRequest0.cpKey;
        }
        if((v & 4) != 0) {
            s2 = alarmListRequest0.appVersion;
        }
        if((v & 8) != 0) {
            s3 = alarmListRequest0.memberKey;
        }
        if((v & 16) != 0) {
            list0 = alarmListRequest0.alarmList;
        }
        return alarmListRequest0.copy(s, s1, s2, s3, list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof AlarmListRequest)) {
            return false;
        }
        if(!q.b(this.cpId, ((AlarmListRequest)object0).cpId)) {
            return false;
        }
        if(!q.b(this.cpKey, ((AlarmListRequest)object0).cpKey)) {
            return false;
        }
        if(!q.b(this.appVersion, ((AlarmListRequest)object0).appVersion)) {
            return false;
        }
        return q.b(this.memberKey, ((AlarmListRequest)object0).memberKey) ? q.b(this.alarmList, ((AlarmListRequest)object0).alarmList) : false;
    }

    @NotNull
    public final List getAlarmList() {
        return this.alarmList;
    }

    @NotNull
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    public final String getCpId() {
        return this.cpId;
    }

    @NotNull
    public final String getCpKey() {
        return this.cpKey;
    }

    @NotNull
    public final String getMemberKey() {
        return this.memberKey;
    }

    @Override
    public int hashCode() {
        return this.alarmList.hashCode() + x.b(x.b(x.b(this.cpId.hashCode() * 0x1F, 0x1F, this.cpKey), 0x1F, this.appVersion), 0x1F, this.memberKey);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = d.o("AlarmListRequest(cpId=", this.cpId, ", cpKey=", this.cpKey, ", appVersion=");
        d.u(stringBuilder0, this.appVersion, ", memberKey=", this.memberKey, ", alarmList=");
        return Y.m(stringBuilder0, this.alarmList, ")");
    }
}

