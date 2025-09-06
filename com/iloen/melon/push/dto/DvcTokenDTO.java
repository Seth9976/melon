package com.iloen.melon.push.dto;

import A7.d;
import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000B\n\u0002\b1\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0002\u0012\b\b\u0002\u0010\b\u001A\u00020\u0002\u0012\b\b\u0002\u0010\t\u001A\u00020\u0002\u0012\b\b\u0002\u0010\n\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0002\u0012\b\b\u0002\u0010\f\u001A\u00020\u0002\u0012\b\b\u0002\u0010\r\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0010\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0015J\u0010\u0010\u0018\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0015J\u0010\u0010\u0019\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u0015J\u0010\u0010\u001A\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u0015J\u0010\u0010\u001B\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u0015J\u0010\u0010\u001C\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u0015J\u0010\u0010\u001D\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u0015J\u0010\u0010\u001E\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u0015J\u0010\u0010\u001F\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010\u0015J\u0010\u0010 \u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b \u0010\u0015J\u0010\u0010!\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\u0015J\u0010\u0010\"\u001A\u00020\u0010H\u00C6\u0003\u00A2\u0006\u0004\b\"\u0010#J\u009C\u0001\u0010$\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00022\b\b\u0002\u0010\u0007\u001A\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\u00022\b\b\u0002\u0010\n\u001A\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\u00022\b\b\u0002\u0010\f\u001A\u00020\u00022\b\b\u0002\u0010\r\u001A\u00020\u00022\b\b\u0002\u0010\u000E\u001A\u00020\u00022\b\b\u0002\u0010\u000F\u001A\u00020\u00022\b\b\u0002\u0010\u0011\u001A\u00020\u0010H\u00C6\u0001\u00A2\u0006\u0004\b$\u0010%J\u0010\u0010&\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b&\u0010\u0015J\u0010\u0010\'\u001A\u00020\u0010H\u00D6\u0001\u00A2\u0006\u0004\b\'\u0010#J\u001A\u0010*\u001A\u00020)2\b\u0010(\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b*\u0010+R\"\u0010\u0003\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b,\u0010-\u001A\u0004\b.\u0010\u0015\"\u0004\b/\u00100R\"\u0010\u0004\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b1\u0010-\u001A\u0004\b2\u0010\u0015\"\u0004\b3\u00100R\"\u0010\u0005\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b4\u0010-\u001A\u0004\b5\u0010\u0015\"\u0004\b6\u00100R\"\u0010\u0006\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b7\u0010-\u001A\u0004\b8\u0010\u0015\"\u0004\b9\u00100R\"\u0010\u0007\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b:\u0010-\u001A\u0004\b;\u0010\u0015\"\u0004\b<\u00100R\"\u0010\b\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b=\u0010-\u001A\u0004\b>\u0010\u0015\"\u0004\b?\u00100R\"\u0010\t\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b@\u0010-\u001A\u0004\bA\u0010\u0015\"\u0004\bB\u00100R\"\u0010\n\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bC\u0010-\u001A\u0004\bD\u0010\u0015\"\u0004\bE\u00100R\"\u0010\u000B\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bF\u0010-\u001A\u0004\bG\u0010\u0015\"\u0004\bH\u00100R\"\u0010\f\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bI\u0010-\u001A\u0004\bJ\u0010\u0015\"\u0004\bK\u00100R\"\u0010\r\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bL\u0010-\u001A\u0004\bM\u0010\u0015\"\u0004\bN\u00100R\"\u0010\u000E\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bO\u0010-\u001A\u0004\bP\u0010\u0015\"\u0004\bQ\u00100R\"\u0010\u000F\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bR\u0010-\u001A\u0004\bS\u0010\u0015\"\u0004\bT\u00100R\"\u0010\u0011\u001A\u00020\u00108\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bU\u0010V\u001A\u0004\bW\u0010#\"\u0004\bX\u0010Y\u00A8\u0006Z"}, d2 = {"Lcom/iloen/melon/push/dto/DvcTokenDTO;", "", "", "deviceToken", "memberId", "deviceId", "pushChannel", "appVer", "deviceOsVer", "deviceModelName", "notifyYN", "mannerYN", "mannerStart", "mannerEnd", "mktRecvAgreeYn", "pushType", "", "callFrom", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "()I", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/iloen/melon/push/dto/DvcTokenDTO;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getDeviceToken", "setDeviceToken", "(Ljava/lang/String;)V", "b", "getMemberId", "setMemberId", "c", "getDeviceId", "setDeviceId", "d", "getPushChannel", "setPushChannel", "e", "getAppVer", "setAppVer", "f", "getDeviceOsVer", "setDeviceOsVer", "g", "getDeviceModelName", "setDeviceModelName", "h", "getNotifyYN", "setNotifyYN", "i", "getMannerYN", "setMannerYN", "j", "getMannerStart", "setMannerStart", "k", "getMannerEnd", "setMannerEnd", "l", "getMktRecvAgreeYn", "setMktRecvAgreeYn", "m", "getPushType", "setPushType", "n", "I", "getCallFrom", "setCallFrom", "(I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DvcTokenDTO {
    public static final int $stable = 8;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public int n;

    public DvcTokenDTO() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0x3FFF, null);
    }

    public DvcTokenDTO(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, @NotNull String s8, @NotNull String s9, @NotNull String s10, @NotNull String s11, @NotNull String s12, int v) {
        q.g(s, "deviceToken");
        q.g(s1, "memberId");
        q.g(s2, "deviceId");
        q.g(s3, "pushChannel");
        q.g(s4, "appVer");
        q.g(s5, "deviceOsVer");
        q.g(s6, "deviceModelName");
        q.g(s7, "notifyYN");
        q.g(s8, "mannerYN");
        q.g(s9, "mannerStart");
        q.g(s10, "mannerEnd");
        q.g(s11, "mktRecvAgreeYn");
        q.g(s12, "pushType");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = s6;
        this.h = s7;
        this.i = s8;
        this.j = s9;
        this.k = s10;
        this.l = s11;
        this.m = s12;
        this.n = v;
    }

    public DvcTokenDTO(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        this(((v1 & 1) == 0 ? s : ""), ((v1 & 2) == 0 ? s1 : ""), ((v1 & 4) == 0 ? s2 : ""), ((v1 & 8) == 0 ? s3 : ""), ((v1 & 16) == 0 ? s4 : ""), ((v1 & 0x20) == 0 ? s5 : ""), ((v1 & 0x40) == 0 ? s6 : ""), ((v1 & 0x80) == 0 ? s7 : ""), ((v1 & 0x100) == 0 ? s8 : ""), ((v1 & 0x200) == 0 ? s9 : ""), ((v1 & 0x400) == 0 ? s10 : ""), ((v1 & 0x800) == 0 ? s11 : ""), ((v1 & 0x1000) == 0 ? s12 : ""), ((v1 & 0x2000) == 0 ? v : -1));
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component10() {
        return this.j;
    }

    @NotNull
    public final String component11() {
        return this.k;
    }

    @NotNull
    public final String component12() {
        return this.l;
    }

    @NotNull
    public final String component13() {
        return this.m;
    }

    public final int component14() {
        return this.n;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final String component7() {
        return this.g;
    }

    @NotNull
    public final String component8() {
        return this.h;
    }

    @NotNull
    public final String component9() {
        return this.i;
    }

    @NotNull
    public final DvcTokenDTO copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, @NotNull String s8, @NotNull String s9, @NotNull String s10, @NotNull String s11, @NotNull String s12, int v) {
        q.g(s, "deviceToken");
        q.g(s1, "memberId");
        q.g(s2, "deviceId");
        q.g(s3, "pushChannel");
        q.g(s4, "appVer");
        q.g(s5, "deviceOsVer");
        q.g(s6, "deviceModelName");
        q.g(s7, "notifyYN");
        q.g(s8, "mannerYN");
        q.g(s9, "mannerStart");
        q.g(s10, "mannerEnd");
        q.g(s11, "mktRecvAgreeYn");
        q.g(s12, "pushType");
        return new DvcTokenDTO(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, v);
    }

    public static DvcTokenDTO copy$default(DvcTokenDTO dvcTokenDTO0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, int v, int v1, Object object0) {
        String s13 = (v1 & 1) == 0 ? s : dvcTokenDTO0.a;
        String s14 = (v1 & 2) == 0 ? s1 : dvcTokenDTO0.b;
        String s15 = (v1 & 4) == 0 ? s2 : dvcTokenDTO0.c;
        String s16 = (v1 & 8) == 0 ? s3 : dvcTokenDTO0.d;
        String s17 = (v1 & 16) == 0 ? s4 : dvcTokenDTO0.e;
        String s18 = (v1 & 0x20) == 0 ? s5 : dvcTokenDTO0.f;
        String s19 = (v1 & 0x40) == 0 ? s6 : dvcTokenDTO0.g;
        String s20 = (v1 & 0x80) == 0 ? s7 : dvcTokenDTO0.h;
        String s21 = (v1 & 0x100) == 0 ? s8 : dvcTokenDTO0.i;
        String s22 = (v1 & 0x200) == 0 ? s9 : dvcTokenDTO0.j;
        String s23 = (v1 & 0x400) == 0 ? s10 : dvcTokenDTO0.k;
        String s24 = (v1 & 0x800) == 0 ? s11 : dvcTokenDTO0.l;
        String s25 = (v1 & 0x1000) == 0 ? s12 : dvcTokenDTO0.m;
        return (v1 & 0x2000) == 0 ? dvcTokenDTO0.copy(s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, v) : dvcTokenDTO0.copy(s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, dvcTokenDTO0.n);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof DvcTokenDTO)) {
            return false;
        }
        if(!q.b(this.a, ((DvcTokenDTO)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((DvcTokenDTO)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((DvcTokenDTO)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((DvcTokenDTO)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((DvcTokenDTO)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((DvcTokenDTO)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((DvcTokenDTO)object0).g)) {
            return false;
        }
        if(!q.b(this.h, ((DvcTokenDTO)object0).h)) {
            return false;
        }
        if(!q.b(this.i, ((DvcTokenDTO)object0).i)) {
            return false;
        }
        if(!q.b(this.j, ((DvcTokenDTO)object0).j)) {
            return false;
        }
        if(!q.b(this.k, ((DvcTokenDTO)object0).k)) {
            return false;
        }
        if(!q.b(this.l, ((DvcTokenDTO)object0).l)) {
            return false;
        }
        return q.b(this.m, ((DvcTokenDTO)object0).m) ? this.n == ((DvcTokenDTO)object0).n : false;
    }

    @NotNull
    public final String getAppVer() [...] // 潜在的解密器

    public final int getCallFrom() {
        return this.n;
    }

    @NotNull
    public final String getDeviceId() {
        return this.c;
    }

    @NotNull
    public final String getDeviceModelName() {
        return this.g;
    }

    @NotNull
    public final String getDeviceOsVer() [...] // 潜在的解密器

    @NotNull
    public final String getDeviceToken() [...] // 潜在的解密器

    @NotNull
    public final String getMannerEnd() [...] // 潜在的解密器

    @NotNull
    public final String getMannerStart() [...] // 潜在的解密器

    @NotNull
    public final String getMannerYN() [...] // 潜在的解密器

    @NotNull
    public final String getMemberId() [...] // 潜在的解密器

    @NotNull
    public final String getMktRecvAgreeYn() [...] // 潜在的解密器

    @NotNull
    public final String getNotifyYN() [...] // 潜在的解密器

    @NotNull
    public final String getPushChannel() {
        return this.d;
    }

    @NotNull
    public final String getPushType() [...] // 潜在的解密器

    @Override
    public int hashCode() {
        return this.n + x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F, this.i), 0x1F, this.j), 0x1F, this.k), 0x1F, this.l), 0x1F, this.m);
    }

    public final void setAppVer(@NotNull String s) {
        q.g(s, "<set-?>");
        this.e = s;
    }

    public final void setCallFrom(int v) {
        this.n = v;
    }

    public final void setDeviceId(@NotNull String s) {
        q.g(s, "<set-?>");
        this.c = s;
    }

    public final void setDeviceModelName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.g = s;
    }

    public final void setDeviceOsVer(@NotNull String s) {
        q.g(s, "<set-?>");
        this.f = s;
    }

    public final void setDeviceToken(@NotNull String s) {
        q.g(s, "<set-?>");
        this.a = s;
    }

    public final void setMannerEnd(@NotNull String s) {
        q.g(s, "<set-?>");
        this.k = s;
    }

    public final void setMannerStart(@NotNull String s) {
        q.g(s, "<set-?>");
        this.j = s;
    }

    public final void setMannerYN(@NotNull String s) {
        q.g(s, "<set-?>");
        this.i = s;
    }

    public final void setMemberId(@NotNull String s) {
        q.g(s, "<set-?>");
        this.b = s;
    }

    public final void setMktRecvAgreeYn(@NotNull String s) {
        q.g(s, "<set-?>");
        this.l = s;
    }

    public final void setNotifyYN(@NotNull String s) {
        q.g(s, "<set-?>");
        this.h = s;
    }

    public final void setPushChannel(@NotNull String s) {
        q.g(s, "<set-?>");
        this.d = s;
    }

    public final void setPushType(@NotNull String s) {
        q.g(s, "<set-?>");
        this.m = s;
    }

    @Override
    @NotNull
    public String toString() {
        String s = this.c;
        String s1 = this.d;
        String s2 = this.e;
        String s3 = this.f;
        String s4 = this.g;
        String s5 = this.h;
        String s6 = this.i;
        String s7 = this.j;
        String s8 = this.k;
        String s9 = this.l;
        String s10 = this.m;
        int v = this.n;
        StringBuilder stringBuilder0 = d.o("DvcTokenDTO(deviceToken=", this.a, ", memberId=", this.b, ", deviceId=");
        d.u(stringBuilder0, s, ", pushChannel=", s1, ", appVer=");
        d.u(stringBuilder0, s2, ", deviceOsVer=", s3, ", deviceModelName=");
        d.u(stringBuilder0, s4, ", notifyYN=", s5, ", mannerYN=");
        d.u(stringBuilder0, s6, ", mannerStart=", s7, ", mannerEnd=");
        d.u(stringBuilder0, s8, ", mktRecvAgreeYn=", s9, ", pushType=");
        stringBuilder0.append(s10);
        stringBuilder0.append(", callFrom=");
        stringBuilder0.append(v);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

