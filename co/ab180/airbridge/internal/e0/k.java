package co.ab180.airbridge.internal.e0;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import co.ab180.airbridge.internal.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00042\b\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010\n\u001A\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0006\u0010\u000BR\u0016\u0010\r\u001A\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0016\u0010\u000F\u001A\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000E\u0010\f¨\u0006\u0012"}, d2 = {"Lco/ab180/airbridge/internal/e0/k;", "", "Landroid/content/Context;", "context", "", "", "a", "(Landroid/content/Context;)Ljava/util/Map;", "", "gdprApplies", "tcString", "(Ljava/lang/Integer;Ljava/lang/String;)Ljava/util/Map;", "Ljava/lang/String;", "KEY_IABTCF_gdprApplies", "b", "KEY_IABTCF_TCString", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class k {
    private static final String a = "IABTCF_gdprApplies";
    private static final String b = "IABTCF_TCString";
    @NotNull
    public static final k c;

    static {
        k.c = new k();
    }

    @Nullable
    public final Map a(@NotNull Context context0) {
        try {
            SharedPreferences sharedPreferences0 = PreferenceManager.getDefaultSharedPreferences(context0);
            int v = sharedPreferences0.getInt("IABTCF_gdprApplies", 0x80000000);
            return this.a((v == 0x80000000 ? null : v), sharedPreferences0.getString("IABTCF_TCString", null));
        }
        catch(Exception unused_ex) {
            return null;
        }
    }

    @Nullable
    public final Map a(@Nullable Integer integer0, @Nullable String s) {
        Map map0 = new LinkedHashMap();
        if(integer0 == null) {
            b.e.f("IABTCF_gdprApplies is missing. it will not be collected automatically.", new Object[0]);
        }
        else {
            map0.put("IABTCF_gdprApplies", integer0);
        }
        if(s != null && s.length() != 0) {
            map0.put("IABTCF_TCString", s);
            return map0.isEmpty() ? null : map0;
        }
        b.e.f("IABTCF_TCString is missing. it will not be collected automatically.", new Object[0]);
        return map0.isEmpty() ? null : map0;
    }
}

