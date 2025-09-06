package l4;

import android.text.TextUtils;
import com.gaa.sdk.auth.e;
import java.util.Objects;

public final class j0 {
    public final String a;
    public final int b;

    public j0(e e0) {
        this.a = e0.b;
        this.b = e0.a;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof j0 && this.a.equals(((j0)object0).a) && this.b == ((j0)object0).b && TextUtils.equals(null, null);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.b, 0, 0, 0});
    }
}

