package v;

import androidx.car.app.model.CarIcon;
import androidx.core.graphics.drawable.IconCompat;

public final class b {
    public final int[] a;
    public static final b b;

    static {
        b.b = new b(new int[]{1, 2});
    }

    public b(int[] arr_v) {
        this.a = arr_v;
    }

    public final void a(CarIcon carIcon0) {
        if(carIcon0 != null && carIcon0.getType() == 1) {
            IconCompat iconCompat0 = carIcon0.getIcon();
            if(iconCompat0 == null) {
                throw new IllegalStateException("Custom icon does not have a backing IconCompat");
            }
            int v = iconCompat0.g();
            int[] arr_v = this.a;
            for(int v1 = 0; v1 < arr_v.length; ++v1) {
                if(v == arr_v[v1]) {
                    if(v == 4 && !"content".equalsIgnoreCase(iconCompat0.h().getScheme())) {
                        throw new IllegalArgumentException("Unsupported URI scheme for: " + iconCompat0);
                    }
                    return;
                }
            }
            throw new IllegalArgumentException("Custom icon type is not allowed: " + v);
        }
    }
}

