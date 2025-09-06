package h7;

import android.os.Build.VERSION;
import androidx.appcompat.app.o;

public final class o0 {
    public final boolean a;

    public o0(boolean z) {
        String s = Build.VERSION.RELEASE;
        String s1 = Build.VERSION.CODENAME;
        super();
        if(s == null) {
            throw new NullPointerException("Null osRelease");
        }
        if(s1 == null) {
            throw new NullPointerException("Null osCodeName");
        }
        this.a = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != this) {
            if(object0 instanceof o0) {
                String s = Build.VERSION.RELEASE;
                ((o0)object0).getClass();
                return s.equals(s) && Build.VERSION.CODENAME.equals(Build.VERSION.CODENAME) && this.a == ((o0)object0).a;
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int v = Build.VERSION.RELEASE.hashCode();
        int v1 = Build.VERSION.CODENAME.hashCode();
        return this.a ? ((v ^ 1000003) * 1000003 ^ v1) * 1000003 ^ 0x4CF : ((v ^ 1000003) * 1000003 ^ v1) * 1000003 ^ 0x4D5;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("OsData{osRelease=");
        stringBuilder0.append(Build.VERSION.RELEASE);
        stringBuilder0.append(", osCodeName=");
        stringBuilder0.append(Build.VERSION.CODENAME);
        stringBuilder0.append(", isRooted=");
        return o.s(stringBuilder0, this.a, "}");
    }
}

