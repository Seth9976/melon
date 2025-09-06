package co.ab180.airbridge.internal.e0;

import Tf.v;
import android.net.Uri;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\b\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\nB\u0019\u0012\u0010\b\u0002\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0019\u0010\n\u001A\u0004\u0018\u00010\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000BR!\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\n\u0010\u000F¨\u0006\u0014"}, d2 = {"Lco/ab180/airbridge/internal/e0/j0;", "", "", "url", "", "c", "(Ljava/lang/String;)Z", "b", "e", "d", "a", "(Ljava/lang/String;)Ljava/lang/String;", "", "h", "Ljava/util/List;", "()Ljava/util/List;", "customDomains", "<init>", "(Ljava/util/List;)V", "g", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class j0 {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000BR\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001A\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"co/ab180/airbridge/internal/e0/j0$a", "", "", "LINK_HOST_ABR_GE", "Ljava/lang/String;", "LINK_HOST_AIRBRIDGE_IO", "LINK_HOST_UNIVERSAL_TRACKING_LINK", "QUERY_PARAM_AIRBRIDGE", "QUERY_PARAM_AIRBRIDGE_DEEPLINK", "QUERY_PARAM_AIRBRIDGE_REFERRER", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {
        private a() {
        }

        public a(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final String a = "airbridge.io";
    private static final String b = "deeplink.page";
    private static final String c = "abr.ge";
    private static final String d = "airbridge";
    @NotNull
    public static final String e = "airbridge_referrer";
    private static final String f = "airbridge_deeplink";
    @NotNull
    public static final a g;
    @Nullable
    private final List h;

    static {
        j0.g = new a(null);
    }

    public j0() {
        this(null, 1, null);
    }

    public j0(@Nullable List list0) {
        this.h = list0;
    }

    public j0(List list0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            list0 = null;
        }
        this(list0);
    }

    @Nullable
    public final String a(@Nullable String s) {
        if(s != null && s.length() != 0) {
            Uri uri0 = Uri.parse(s);
            Set set0 = uri0.getQueryParameterNames();
            boolean z = set0.contains("airbridge_referrer");
            return (set0.contains("airbridge_deeplink") & z) == 0 ? s : uri0.getQueryParameter("airbridge_deeplink");
        }
        return s;
    }

    @Nullable
    public final List a() {
        return this.h;
    }

    public final boolean b(@Nullable String s) {
        if(s != null && s.length() != 0) {
            Uri uri0 = Uri.parse(s);
            if(i0.a(uri0)) {
                String s1 = uri0.getHost();
                if(s1 != null && s1.length() != 0) {
                    String s2 = uri0.getHost();
                    return v.i0(s2, "airbridge.io", false) || v.i0(s2, "abr.ge", false);
                }
            }
        }
        return false;
    }

    public final boolean c(@Nullable String s) {
        if(s != null && s.length() != 0) {
            if(!this.b(s) && !this.e(s)) {
                Set set0 = Uri.parse(s).getQueryParameterNames();
                boolean z = set0.contains("airbridge");
                return set0.contains("airbridge_referrer") | z;
            }
            return true;
        }
        return false;
    }

    // 去混淆评级： 低(30)
    public final boolean d(@Nullable String s) {
        return s != null && s.length() != 0 && (this.b(s) || this.e(s));
    }

    public final boolean e(@Nullable String s) {
        if(s != null && s.length() != 0) {
            Uri uri0 = Uri.parse(s);
            if(i0.a(uri0)) {
                String s1 = uri0.getHost();
                if(s1 != null && s1.length() != 0) {
                    String s2 = uri0.getHost();
                    if(v.i0(s2, "deeplink.page", false)) {
                        return true;
                    }
                    List list0 = this.h;
                    if(list0 != null) {
                        for(Object object0: list0) {
                            if(!s2.equals(Uri.parse(((String)object0)).getHost()) && !s2.equals(((String)object0))) {
                                continue;
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

