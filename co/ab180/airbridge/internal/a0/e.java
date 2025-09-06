package co.ab180.airbridge.internal.a0;

import co.ab180.airbridge.common.Event;
import co.ab180.airbridge.internal.b0.m.b;
import co.ab180.airbridge.internal.b0.m.c;
import co.ab180.airbridge.internal.c0.a;
import co.ab180.airbridge.internal.e0.f0;
import co.ab180.airbridge.internal.network.body.EventChunk;
import co.ab180.airbridge.internal.network.body.EventPiece;
import co.ab180.airbridge.internal.network.body.EventPieceHeader;
import co.ab180.airbridge.internal.network.body.ReportChunk;
import co.ab180.airbridge.internal.network.body.ReportPiece;
import co.ab180.airbridge.internal.network.model.GalaxyStoreReferrerDetails;
import co.ab180.airbridge.internal.network.model.GoalData;
import co.ab180.airbridge.internal.network.model.GoogleReferrerDetails;
import co.ab180.airbridge.internal.network.model.HuaweiStoreReferrerDetails;
import co.ab180.airbridge.internal.network.model.LocationInfo;
import co.ab180.airbridge.internal.network.model.MetaInstallReferrerData;
import co.ab180.airbridge.internal.network.model.ScreenInfo;
import co.ab180.airbridge.internal.network.model.UserInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001D\u0010\u0004\u001A\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001A\u0013\u0010\u0004\u001A\u00020\u0007*\u00020\u0006H\u0000¢\u0006\u0004\b\u0004\u0010\b\u001A\u0013\u0010\u0004\u001A\u00020\n*\u00020\tH\u0000¢\u0006\u0004\b\u0004\u0010\u000B\u001A\u0013\u0010\u0004\u001A\u00020\r*\u00020\fH\u0000¢\u0006\u0004\b\u0004\u0010\u000E\u001A\u0019\u0010\u0004\u001A\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00100\u000FH\u0000¢\u0006\u0004\b\u0004\u0010\u0012\u001A\u0019\u0010\u0015\u001A\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00130\u000FH\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001A\u0013\u0010\u0004\u001A\u00020\u0018*\u00020\u0017H\u0000¢\u0006\u0004\b\u0004\u0010\u0019\u001A\u0013\u0010\u0004\u001A\u00020\u001B*\u00020\u001AH\u0000¢\u0006\u0004\b\u0004\u0010\u001C\u001A\u0013\u0010\u0004\u001A\u00020\u001E*\u00020\u001DH\u0000¢\u0006\u0004\b\u0004\u0010\u001F\u001A\u0013\u0010\u0004\u001A\u00020!*\u00020 H\u0000¢\u0006\u0004\b\u0004\u0010\"¨\u0006#"}, d2 = {"Lco/ab180/airbridge/internal/c0/f/a;", "", "hash", "Lco/ab180/airbridge/internal/network/model/UserInfo;", "a", "(Lco/ab180/airbridge/internal/c0/f/a;Z)Lco/ab180/airbridge/internal/network/model/UserInfo;", "Lco/ab180/airbridge/internal/b0/b$c;", "Lco/ab180/airbridge/internal/network/model/ScreenInfo;", "(Lco/ab180/airbridge/internal/b0/b$c;)Lco/ab180/airbridge/internal/network/model/ScreenInfo;", "Lco/ab180/airbridge/internal/b0/b$b;", "Lco/ab180/airbridge/internal/network/model/LocationInfo;", "(Lco/ab180/airbridge/internal/b0/b$b;)Lco/ab180/airbridge/internal/network/model/LocationInfo;", "Lco/ab180/airbridge/common/Event;", "Lco/ab180/airbridge/internal/network/model/GoalData;", "(Lco/ab180/airbridge/common/Event;)Lco/ab180/airbridge/internal/network/model/GoalData;", "", "Lco/ab180/airbridge/internal/c0/a;", "Lco/ab180/airbridge/internal/network/body/EventChunk;", "(Ljava/util/List;)Lco/ab180/airbridge/internal/network/body/EventChunk;", "Lco/ab180/airbridge/internal/c0/b;", "Lco/ab180/airbridge/internal/network/body/ReportChunk;", "b", "(Ljava/util/List;)Lco/ab180/airbridge/internal/network/body/ReportChunk;", "Lco/ab180/airbridge/internal/b0/m/b;", "Lco/ab180/airbridge/internal/network/model/GoogleReferrerDetails;", "(Lco/ab180/airbridge/internal/b0/m/b;)Lco/ab180/airbridge/internal/network/model/GoogleReferrerDetails;", "Lco/ab180/airbridge/internal/b0/m/c;", "Lco/ab180/airbridge/internal/network/model/HuaweiStoreReferrerDetails;", "(Lco/ab180/airbridge/internal/b0/m/c;)Lco/ab180/airbridge/internal/network/model/HuaweiStoreReferrerDetails;", "Lco/ab180/airbridge/internal/b0/m/a;", "Lco/ab180/airbridge/internal/network/model/GalaxyStoreReferrerDetails;", "(Lco/ab180/airbridge/internal/b0/m/a;)Lco/ab180/airbridge/internal/network/model/GalaxyStoreReferrerDetails;", "Lco/ab180/airbridge/internal/b0/m/e;", "Lco/ab180/airbridge/internal/network/model/MetaInstallReferrerData;", "(Lco/ab180/airbridge/internal/b0/m/e;)Lco/ab180/airbridge/internal/network/model/MetaInstallReferrerData;", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class e {
    @NotNull
    public static final EventChunk a(@NotNull List list0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            a a0 = (a)object0;
            String s = a0.l();
            String s1 = "";
            if(s == null) {
                s = "";
            }
            String s2 = a0.l();
            String s3 = String.valueOf((s2 == null || s2.length() == 0 ? 0L : a0.h()));
            String s4 = a0.l();
            if(s4 != null && s4.length() != 0) {
                String s5 = a0.k();
                if(s5 != null) {
                    s1 = s5;
                }
            }
            arrayList0.add(new EventPiece(new EventPieceHeader(s, s3, s1), a0.g(), a0.i()));
        }
        return new EventChunk(arrayList0);
    }

    @NotNull
    public static final GalaxyStoreReferrerDetails a(@NotNull co.ab180.airbridge.internal.b0.m.a a0) {
        return new GalaxyStoreReferrerDetails(a0.e(), a0.f(), a0.d());
    }

    @NotNull
    public static final GoalData a(@NotNull Event event0) {
        return new GoalData(event0.getCategory(), event0.getSemanticAttributes(), event0.getCustomAttributes());
    }

    @NotNull
    public static final GoogleReferrerDetails a(@NotNull b b0) {
        return new GoogleReferrerDetails(b0.l(), b0.m(), b0.n(), b0.i(), b0.j(), b0.h(), b0.k());
    }

    @NotNull
    public static final HuaweiStoreReferrerDetails a(@NotNull c c0) {
        return new HuaweiStoreReferrerDetails(c0.e(), c0.f(), c0.d());
    }

    @NotNull
    public static final LocationInfo a(@NotNull co.ab180.airbridge.internal.b0.b.b b$b0) {
        return new LocationInfo(b$b0.f(), b$b0.g(), b$b0.e(), b$b0.h());
    }

    @NotNull
    public static final MetaInstallReferrerData a(@NotNull co.ab180.airbridge.internal.b0.m.e e0) {
        return new MetaInstallReferrerData(e0.g(), e0.e(), e0.h(), e0.f());
    }

    @NotNull
    public static final ScreenInfo a(@NotNull co.ab180.airbridge.internal.b0.b.c b$c0) {
        return new ScreenInfo(b$c0.h(), b$c0.f(), b$c0.e());
    }

    @Nullable
    public static final UserInfo a(@NotNull co.ab180.airbridge.internal.c0.f.a a0, boolean z) {
        String s8;
        String s5;
        Map map0 = a0.c();
        Map map1 = a0.t();
        String s = a0.j();
        if(s == null || s.length() == 0) {
            String s1 = a0.u();
            if(s1 == null || s1.length() == 0) {
                String s2 = a0.o();
                if((s2 == null || s2.length() == 0) && map0.isEmpty() && map1.isEmpty()) {
                    return null;
                }
            }
        }
        String s3 = a0.u();
        if(s3 == null || s3.length() == 0) {
            s5 = null;
        }
        else {
            String s4 = a0.u();
            if(!z) {
                s5 = s4;
            }
            else if(s4 != null) {
                s5 = f0.a(s4, null, 1, null);
            }
            else {
                s5 = null;
            }
        }
        String s6 = a0.o();
        if(s6 == null || s6.length() == 0) {
            s8 = null;
        }
        else {
            String s7 = a0.o();
            if(!z) {
                s8 = s7;
            }
            else if(s7 != null) {
                s8 = f0.a(s7, null, 1, null);
            }
            else {
                s8 = null;
            }
        }
        if(z) {
            co.ab180.airbridge.internal.b.e.e("User information is hashed: email={" + s5 + "} phone={" + s8 + '}', new Object[0]);
        }
        String s9 = a0.j();
        Map map2 = map0.isEmpty() ? null : map0;
        return map1.isEmpty() ? new UserInfo(s9, s5, s8, map2, null, Boolean.valueOf(z)) : new UserInfo(s9, s5, s8, map2, map1, Boolean.valueOf(z));
    }

    @NotNull
    public static final ReportChunk b(@NotNull List list0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            arrayList0.add(new ReportPiece(((co.ab180.airbridge.internal.c0.b)object0).d().getLogInfo().getLevel(), ((co.ab180.airbridge.internal.c0.b)object0).d()));
        }
        return new ReportChunk(arrayList0);
    }
}

