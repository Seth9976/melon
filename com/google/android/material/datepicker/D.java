package com.google.android.material.datepicker;

import java.util.ArrayList;

public final class d implements f {
    @Override  // com.google.android.material.datepicker.f
    public final boolean a(ArrayList arrayList0, long v) {
        for(Object object0: arrayList0) {
            if(((DateValidator)object0) != null && !((DateValidator)object0).i(v)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    @Override  // com.google.android.material.datepicker.f
    public final int getId() {
        return 2;
    }
}

