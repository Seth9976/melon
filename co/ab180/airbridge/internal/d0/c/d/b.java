package co.ab180.airbridge.internal.d0.c.d;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri.Builder;
import android.net.Uri;
import jeb.synthetic.TWR;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\u000F\u001A\u00020\f\u0012\u0006\u0010\u000B\u001A\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0005\u001A\u00020\u0007¢\u0006\u0004\b\u0005\u0010\bR\u0016\u0010\u000B\u001A\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000F\u001A\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000E¨\u0006\u0013"}, d2 = {"Lco/ab180/airbridge/internal/d0/c/d/b;", "", "", "authority", "Landroid/net/Uri;", "a", "(Ljava/lang/String;)Landroid/net/Uri;", "Lco/ab180/airbridge/internal/d0/c/d/d;", "()Lco/ab180/airbridge/internal/d0/c/d/d;", "e", "Ljava/lang/String;", "facebookAppId", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "c", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class b {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001A\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001A\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"co/ab180/airbridge/internal/d0/c/d/b$a", "", "", "FACEBOOK_INSTALL_REFERRER_PROVIDER", "Ljava/lang/String;", "INSTAGRAM_INSTALL_REFERRER_PROVIDER", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {
        private a() {
        }

        public a(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final String a = "com.facebook.katana.provider.InstallReferrerProvider";
    @NotNull
    public static final String b = "com.instagram.contentprovider.InstallReferrerProvider";
    @NotNull
    public static final a c;
    private final Context d;
    private final String e;

    static {
        b.c = new a(null);
    }

    public b(@NotNull Context context0, @NotNull String s) {
        this.d = context0;
        this.e = s;
    }

    private final Uri a(String s) {
        return new Uri.Builder().scheme("content").authority(s).appendPath(this.e).build();
    }

    @NotNull
    public final d a() {
        d d0;
        Uri uri0;
        Cursor cursor0;
        try {
            try {
                cursor0 = null;
                String[] arr_s = {"install_referrer", "actual_timestamp", "is_ct"};
                if(this.d.getPackageManager().resolveContentProvider("com.facebook.katana.provider.InstallReferrerProvider", 0) == null) {
                    if(this.d.getPackageManager().resolveContentProvider("com.instagram.contentprovider.InstallReferrerProvider", 0) == null) {
                        throw new co.ab180.airbridge.internal.d0.c.d.a(c.a);
                    }
                    uri0 = this.a("com.instagram.contentprovider.InstallReferrerProvider");
                }
                else {
                    uri0 = this.a("com.facebook.katana.provider.InstallReferrerProvider");
                }
                cursor0 = this.d.getContentResolver().query(uri0, arr_s, null, null, null);
                if(cursor0 == null || !cursor0.moveToFirst()) {
                    throw new co.ab180.airbridge.internal.d0.c.d.a(c.b);
                }
                int v = cursor0.getColumnIndex(arr_s[0]);
                int v1 = cursor0.getColumnIndex(arr_s[1]);
                int v2 = cursor0.getColumnIndex(arr_s[2]);
                if(v == -1 || v1 == -1 || v2 == -1) {
                    throw new co.ab180.airbridge.internal.d0.c.d.a(c.c);
                }
                d0 = new d(cursor0.getString(v), cursor0.getLong(v1), cursor0.getInt(v2));
                goto label_24;
            }
            catch(co.ab180.airbridge.internal.d0.c.d.a a0) {
            }
            catch(Exception unused_ex) {
                throw new co.ab180.airbridge.internal.d0.c.d.a(c.d);
            }
            throw a0;
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
    label_24:
        cursor0.close();
        return d0;
    }
}

