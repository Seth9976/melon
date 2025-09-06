package Fc;

import android.net.Uri;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class m implements K4 {
    public final Uri a;

    public m(Uri uri0) {
        this.a = uri0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof m ? q.b(this.a, ((m)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Success(currentImageUri=" + this.a + ")";
    }
}

