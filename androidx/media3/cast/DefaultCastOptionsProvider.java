package androidx.media3.cast;

import android.content.Context;
import com.google.android.gms.cast.framework.CastOptions.Builder;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.OptionsProvider;
import java.util.Collections;
import java.util.List;

public final class DefaultCastOptionsProvider implements OptionsProvider {
    @Override  // com.google.android.gms.cast.framework.OptionsProvider
    public List getAdditionalSessionProviders(Context context0) {
        return Collections.EMPTY_LIST;
    }

    @Override  // com.google.android.gms.cast.framework.OptionsProvider
    public CastOptions getCastOptions(Context context0) {
        return new Builder().setResumeSavedSession(false).setEnableReconnectionService(false).setReceiverApplicationId("A12D4273").setStopReceiverApplicationWhenEndingSession(true).build();
    }
}

