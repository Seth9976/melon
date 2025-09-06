package com.facebook.appevents;

import com.facebook.CallbackManager.ActivityResultParameters;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.internal.FeatureManager.Callback;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener;
import com.google.android.exoplayer2.ext.flac.FlacExtractor;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.flv.FlvExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.trackselection.BufferSizeAdaptationBuilder.DynamicFormatFilter;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.EventDispatcher.Event;
import com.google.android.exoplayer2.util.Predicate;
import e.a;

public final class b implements Callback, ExtractorsFactory, FramePredicate, DynamicFormatFilter, Event, Predicate, a {
    public final int a;

    public b(int v) {
        this.a = v;
        super();
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public Extractor[] createExtractors() {
        switch(this.a) {
            case 12: {
                return FlacExtractor.a();
            }
            case 13: {
                return com.google.android.exoplayer2.extractor.flac.FlacExtractor.a();
            }
            case 14: {
                return FlvExtractor.a();
            }
            case 15: {
                return MatroskaExtractor.a();
            }
            case 16: {
                return Mp3Extractor.a();
            }
            case 18: {
                return FragmentedMp4Extractor.a();
            }
            case 19: {
                return Mp4Extractor.a();
            }
            case 20: {
                return OggExtractor.a();
            }
            case 21: {
                return Ac3Extractor.a();
            }
            case 22: {
                return Ac4Extractor.a();
            }
            case 23: {
                return AdtsExtractor.a();
            }
            case 24: {
                return PsExtractor.a();
            }
            case 25: {
                return TsExtractor.a();
            }
            default: {
                return WavExtractor.a();
            }
        }
    }

    @Override  // com.google.android.exoplayer2.metadata.id3.Id3Decoder$FramePredicate
    public boolean evaluate(int v, int v1, int v2, int v3, int v4) {
        return this.a == 17 ? Mp3Extractor.b(v, v1, v2, v3, v4) : Id3Decoder.a(v, v1, v2, v3, v4);
    }

    @Override  // com.google.android.exoplayer2.util.Predicate
    public boolean evaluate(Object object0) {
        return HttpDataSource.a(((String)object0));
    }

    @Override  // com.google.android.exoplayer2.trackselection.BufferSizeAdaptationBuilder$DynamicFormatFilter
    public boolean isFormatAllowed(Format format0, int v, boolean z) {
        return DynamicFormatFilter.a(format0, v, z);
    }

    @Override  // e.a
    public void onActivityResult(Object object0) {
        ActivityResultParameters callbackManager$ActivityResultParameters0 = (ActivityResultParameters)object0;
    }

    @Override  // com.facebook.internal.FeatureManager$Callback
    public void onCompleted(boolean z) {
        switch(this.a) {
            case 0: {
                com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$13(z);
                return;
            }
            case 1: {
                com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$14(z);
                return;
            }
            case 2: {
                com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$15(z);
                return;
            }
            case 3: {
                com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$1(z);
                return;
            }
            case 4: {
                com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$2(z);
                return;
            }
            case 5: {
                com.facebook.appevents.AppEventsManager.start.1.onSuccess$lambda$3(z);
                return;
            }
            default: {
                ActivityLifecycleTracker.c(z);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.util.EventDispatcher$Event
    public void sendTo(Object object0) {
        switch(this.a) {
            case 8: {
                ((DefaultDrmSessionEventListener)object0).onDrmSessionReleased();
                return;
            }
            case 9: {
                ((DefaultDrmSessionEventListener)object0).onDrmSessionAcquired();
                return;
            }
            case 10: {
                ((DefaultDrmSessionEventListener)object0).onDrmKeysRestored();
                return;
            }
            default: {
                ((DefaultDrmSessionEventListener)object0).onDrmKeysLoaded();
            }
        }
    }
}

