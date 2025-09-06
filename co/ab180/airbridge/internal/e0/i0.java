package co.ab180.airbridge.internal.e0;

import android.net.Uri.Builder;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\u001A\u001B\u0010\u0003\u001A\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001A%\u0010\u0003\u001A\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0006\u001A\u0013\u0010\u0003\u001A\u00020\u0007*\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"Landroid/net/Uri;", "", "key", "a", "(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;", "newValue", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;", "", "(Landroid/net/Uri;)Z", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class i0 {
    @NotNull
    public static final Uri a(@NotNull Uri uri0, @NotNull String s) {
        Uri.Builder uri$Builder0 = uri0.buildUpon().clearQuery();
        for(Object object0: uri0.getQueryParameterNames()) {
            String s1 = (String)object0;
            if(!q.b(s1, s)) {
                uri$Builder0.appendQueryParameter(s1, uri0.getQueryParameter(s1));
            }
        }
        return uri$Builder0.build();
    }

    @NotNull
    public static final Uri a(@NotNull Uri uri0, @NotNull String s, @Nullable String s1) {
        Uri.Builder uri$Builder0 = uri0.buildUpon().clearQuery();
        for(Object object0: uri0.getQueryParameterNames()) {
            String s2 = (String)object0;
            if(!q.b(s2, s)) {
                uri$Builder0.appendQueryParameter(s2, uri0.getQueryParameter(s2));
            }
        }
        uri$Builder0.appendQueryParameter(s, s1);
        return uri$Builder0.build();
    }

    public static final boolean a(@NotNull Uri uri0) {
        String s = uri0.getScheme();
        if(s != null && s.length() != 0) {
            String s1 = uri0.getHost();
            if(s1 != null && s1.length() != 0) {
                String s2 = uri0.getScheme();
                String s3 = null;
                if(!q.b((s2 == null ? null : s2.toLowerCase()), "http")) {
                    String s4 = uri0.getScheme();
                    if(s4 != null) {
                        s3 = s4.toLowerCase();
                    }
                    return q.b(s3, "https");
                }
                return true;
            }
        }
        return false;
    }
}

