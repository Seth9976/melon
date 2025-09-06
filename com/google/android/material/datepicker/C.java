package com.google.android.material.datepicker;

import java.util.ArrayList;

public final class c implements f {
    @Override  // com.google.android.material.datepicker.f
    public final boolean a(ArrayList arrayList0, long v) {
        for(Object object0: arrayList0) {
            if(((DateValidator)object0) != null && ((DateValidator)object0).i(v)) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    @Override  // com.google.android.material.datepicker.f
    public final int getId() {
        return 1;
    }
}

