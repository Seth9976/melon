package com.google.android.gms.cast.framework;

import android.content.Context;
import java.util.List;

public interface OptionsProvider {
    List getAdditionalSessionProviders(Context arg1);

    CastOptions getCastOptions(Context arg1);
}

