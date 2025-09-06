package y8;

import U4.x;
import android.content.res.AssetManager;
import c3.b;
import c3.c;
import c3.d;
import com.gaudiolab.sol.android.Parameters;
import com.gaudiolab.sol.android.SolMusicOne.Format;
import com.gaudiolab.sol.android.SolMusicOne.LoudnessType;
import com.gaudiolab.sol.android.SolMusicOne.SamplesPerBlock;
import com.gaudiolab.sol.android.SolMusicOne.SpatialUpmixGenre;
import com.gaudiolab.sol.android.SolMusicOne;
import com.iloen.melon.utils.log.LogU;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import k8.Y;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;
import p8.e;
import sd.j;

public final class m implements d {
    public final SolMusicOne b;
    public final g c;
    public final AssetManager d;
    public final e e;
    public final j f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public final AtomicBoolean l;
    public short[] m;
    public short[] n;
    public ShortBuffer o;
    public ShortBuffer p;
    public ShortBuffer q;
    public ByteBuffer r;
    public ByteBuffer s;
    public int t;

    public m(SolMusicOne solMusicOne0, g g0, AssetManager assetManager0, e e0, j j0) {
        q.g(g0, "model");
        super();
        this.b = solMusicOne0;
        this.c = g0;
        this.d = assetManager0;
        this.e = e0;
        this.f = j0;
        q.f(d.a, "EMPTY_BUFFER");
        this.r = d.a;
        this.s = d.a;
        ShortBuffer shortBuffer0 = d.a.asShortBuffer();
        q.f(shortBuffer0, "asShortBuffer(...)");
        this.q = shortBuffer0;
        this.h = 0;
        this.l = new AtomicBoolean(false);
        g0.a = new HashSet(solMusicOne0.getCaps());
        HashSet hashSet0 = new HashSet(g0.a);
        String s = SolMusicOne.getVersion();
        LogU.Companion.d("[GaudioSolMusicOne] ", "capabilities: " + hashSet0 + ", SDK version: " + s);
    }

    @Override  // c3.d
    public final b a(b b0) {
        LogU.Companion.d("[GaudioSolMusicOne] ", "configure: " + b0);
        if(b0.c != 2) {
            throw new c(b0);
        }
        this.j = 16;
        AtomicBoolean atomicBoolean0 = this.l;
        if(atomicBoolean0.get()) {
            this.d();
        }
        g g0 = this.c;
        g0.b.numInputChannels = b0.b;
        g0.b.numOutputChannels = b0.b;
        g0.b.sampleRate = b0.a;
        g0.b.samplesPerBlock = SamplesPerBlock.k512.raw;
        g0.b.format = Format.kS16leI;
        int v = SamplesPerBlock.k512.raw * b0.b;
        this.g = v;
        this.i = this.j / 8;
        int v1 = v * (this.j / 8) * 10;
        if(!atomicBoolean0.get()) {
            this.b(v1);
            if(atomicBoolean0.compareAndSet(false, true)) {
                Parameters parameters0 = g0.c;
                if(parameters0.metadata == null) {
                    byte[] arr_b = null;
                    AssetManager assetManager0 = this.d;
                    if(assetManager0 != null) {
                        try {
                            InputStream inputStream0 = assetManager0.open("default.sol");
                            q.f(inputStream0, "open(...)");
                            arr_b = J6.b.b(inputStream0);
                        }
                        catch(FileNotFoundException fileNotFoundException0) {
                            fileNotFoundException0.printStackTrace();
                        }
                        catch(IOException iOException0) {
                            iOException0.printStackTrace();
                        }
                    }
                    parameters0.metadata = arr_b;
                    parameters0.metadataLength = arr_b == null ? 0 : arr_b.length;
                }
                this.e.invoke();
                int v2 = this.b.setup(g0.b, parameters0);
                this.t = v2;
                LogU.Companion.d("[GaudioSolMusicOne] ", "setupCore: " + v2);
                m.c(parameters0);
                this.f.invoke(this.t);
                this.b.setParameter("loudnorm.enableLoudnessMeasure", ((Number)g0.h.getValue()).intValue());
                g0.d.compareAndSet(true, false);
            }
        }
        return b0;
    }

    public final void b(int v) {
        int v1 = this.g;
        this.m = new short[v1];
        this.n = new short[v1];
        ShortBuffer shortBuffer0 = ShortBuffer.allocate(v);
        q.f(shortBuffer0, "allocate(...)");
        this.o = shortBuffer0;
        ByteBuffer byteBuffer0 = ByteBuffer.allocateDirect(v * this.i).order(ByteOrder.nativeOrder());
        q.f(byteBuffer0, "order(...)");
        this.s = byteBuffer0;
        ShortBuffer shortBuffer1 = byteBuffer0.asShortBuffer();
        q.f(shortBuffer1, "asShortBuffer(...)");
        this.q = shortBuffer1;
        this.s.flip();
        this.q.flip();
    }

    public static void c(Parameters parameters0) {
        boolean z = parameters0.isEnable;
        Set set0 = parameters0.preferenceFeatures;
        LoudnessType solMusicOne$LoudnessType0 = parameters0.loudnessType;
        float f = parameters0.targetLoudness;
        SpatialUpmixGenre solMusicOne$SpatialUpmixGenre0 = parameters0.upmixGenre;
        int v = parameters0.metadataLength;
        int v1 = parameters0.equalizerBandCount;
        String s = Arrays.toString(parameters0.equalizerBandGainDb);
        q.f(s, "toString(...)");
        StringBuilder stringBuilder0 = new StringBuilder("Parameters {enable: ");
        stringBuilder0.append(z);
        stringBuilder0.append(" , features: ");
        stringBuilder0.append(set0);
        stringBuilder0.append(", Loudness type: ");
        stringBuilder0.append(solMusicOne$LoudnessType0);
        stringBuilder0.append(" , targetLoudness: ");
        stringBuilder0.append(f);
        stringBuilder0.append(" , upmix: ");
        stringBuilder0.append(solMusicOne$SpatialUpmixGenre0);
        stringBuilder0.append(" , metadataLength: ");
        x.x(stringBuilder0, v, ", eq band Count: ", v1, " , eq band: ");
        stringBuilder0.append(s);
        stringBuilder0.append(" }");
        LogU.Companion.d("[GaudioSolMusicOne] ", stringBuilder0.toString());
    }

    public final void d() {
        if(this.l.compareAndSet(true, false)) {
            Y.t("resetCore: ", this.b.reset(), LogU.Companion, "[GaudioSolMusicOne] ");
        }
    }

    @Override  // c3.d
    public final void flush() {
        AtomicBoolean atomicBoolean0 = this.l;
        if(atomicBoolean0.get()) {
            this.k = false;
            ShortBuffer shortBuffer0 = this.o;
            if(shortBuffer0 == null) {
                q.m("inputShortBuffer");
                throw null;
            }
            shortBuffer0.clear();
            q.f(d.a, "EMPTY_BUFFER");
            this.r = d.a;
            this.h = 0;
            if(atomicBoolean0.get()) {
                Y.t("flushCore: ", this.b.flush(), LogU.Companion, "[GaudioSolMusicOne] ");
            }
        }
    }

    @Override  // c3.d
    public final ByteBuffer getOutput() {
        return this.r;
    }

    @Override  // c3.d
    public final boolean isActive() {
        return true;
    }

    @Override  // c3.d
    public final boolean isEnded() {
        return this.k;
    }

    @Override  // c3.d
    public final void queueEndOfStream() {
        this.k = true;
    }

    @Override  // c3.d
    public final void queueInput(ByteBuffer byteBuffer0) {
        Throwable throwable1;
        if(this.t != 0) {
            this.r = byteBuffer0;
            return;
        }
        if(byteBuffer0.hasRemaining()) {
            int v = byteBuffer0.remaining();
            ShortBuffer shortBuffer0 = this.o;
            Throwable throwable0 = null;
            if(shortBuffer0 != null) {
                if(shortBuffer0.capacity() < v) {
                    ShortBuffer shortBuffer1 = this.o;
                    if(shortBuffer1 != null) {
                        shortBuffer1.flip();
                        ShortBuffer shortBuffer2 = this.o;
                        if(shortBuffer2 != null) {
                            ShortBuffer shortBuffer3 = ShortBuffer.allocate(shortBuffer2.limit());
                            q.f(shortBuffer3, "allocate(...)");
                            this.p = shortBuffer3;
                            ShortBuffer shortBuffer4 = this.o;
                            if(shortBuffer4 != null) {
                                shortBuffer3.put(shortBuffer4);
                                ShortBuffer shortBuffer5 = this.p;
                                if(shortBuffer5 != null) {
                                    shortBuffer5.position(0);
                                    this.b(this.h * this.i + v);
                                    ShortBuffer shortBuffer6 = this.o;
                                    if(shortBuffer6 != null) {
                                        ShortBuffer shortBuffer7 = this.p;
                                        if(shortBuffer7 != null) {
                                            shortBuffer6.put(shortBuffer7);
                                            ShortBuffer shortBuffer8 = this.p;
                                            if(shortBuffer8 != null) {
                                                shortBuffer8.clear();
                                                goto label_47;
                                            }
                                            q.m("tempShortBuffer");
                                            throw null;
                                        }
                                        q.m("tempShortBuffer");
                                        throw null;
                                    }
                                    q.m("inputShortBuffer");
                                    throw null;
                                }
                                q.m("tempShortBuffer");
                                throw null;
                            }
                            q.m("inputShortBuffer");
                            throw null;
                        }
                        q.m("inputShortBuffer");
                        throw null;
                    }
                    q.m("inputShortBuffer");
                    throw null;
                }
            label_47:
                this.s.clear();
                this.q.clear();
                ShortBuffer shortBuffer9 = this.o;
                if(shortBuffer9 != null) {
                    shortBuffer9.put(byteBuffer0.asShortBuffer());
                    ShortBuffer shortBuffer10 = this.o;
                    if(shortBuffer10 != null) {
                        shortBuffer10.flip();
                        int v1 = v / this.i + this.h;
                        this.h = v1;
                        int v2 = v1 / this.g;
                        int v3 = 0;
                        while(v3 < v2) {
                            ShortBuffer shortBuffer11 = this.o;
                            if(shortBuffer11 != null) {
                                short[] arr_v = this.m;
                                if(arr_v != null) {
                                    shortBuffer11.get(arr_v, 0, this.g);
                                    if(this.l.get()) {
                                        g g0 = this.c;
                                        MutableStateFlow mutableStateFlow0 = g0.h;
                                        Parameters parameters0 = g0.c;
                                        boolean z = g0.d.get();
                                        SolMusicOne solMusicOne0 = this.b;
                                        if(z) {
                                            this.e.invoke();
                                            int v4 = solMusicOne0.update(parameters0);
                                            throwable1 = throwable0;
                                            LogU.Companion.d("[GaudioSolMusicOne] ", "process update: " + v4);
                                            m.c(parameters0);
                                            this.f.invoke(v4);
                                            solMusicOne0.setParameter("loudnorm.enableLoudnessMeasure", ((Number)mutableStateFlow0.getValue()).intValue());
                                            g0.d.compareAndSet(true, false);
                                        }
                                        else {
                                            throwable1 = throwable0;
                                        }
                                        short[] arr_v1 = this.m;
                                        if(arr_v1 == null) {
                                            q.m("inputNativeShortArray");
                                            throw throwable1;
                                        }
                                        short[] arr_v2 = this.n;
                                        if(arr_v2 == null) {
                                            q.m("outputProcessedShortArray");
                                            throw throwable1;
                                        }
                                        solMusicOne0.process(arr_v1, arr_v2, g0.b.samplesPerBlock);
                                        ShortBuffer shortBuffer12 = this.q;
                                        short[] arr_v3 = this.n;
                                        if(arr_v3 == null) {
                                            q.m("outputProcessedShortArray");
                                            throw throwable1;
                                        }
                                        shortBuffer12.put(arr_v3);
                                        this.s.position(this.q.position() * this.i);
                                        if(((Number)mutableStateFlow0.getValue()).intValue() != 0) {
                                            float f = solMusicOne0.getFloatParameter("loudnorm.inputIntegratedLoudness");
                                            float f1 = solMusicOne0.getFloatParameter("loudnorm.outputIntegratedLoudness");
                                            float f2 = solMusicOne0.getFloatParameter("loudnorm.calculatedGainDb");
                                            g0.i.setValue(f);
                                            g0.j.setValue(f1);
                                            g0.k.setValue(f2);
                                            this.h -= this.g;
                                            ++v3;
                                            throwable0 = throwable1;
                                            continue;
                                        }
                                    }
                                    else {
                                        throwable1 = throwable0;
                                    }
                                    this.h -= this.g;
                                    ++v3;
                                    throwable0 = throwable1;
                                    continue;
                                }
                                q.m("inputNativeShortArray");
                                throw throwable0;
                            }
                            q.m("inputShortBuffer");
                            throw throwable0;
                        }
                        ShortBuffer shortBuffer13 = this.o;
                        if(shortBuffer13 != null) {
                            shortBuffer13.compact();
                            this.s.flip();
                            this.q.flip();
                            this.r = this.s;
                            byteBuffer0.position(byteBuffer0.position() + v);
                            return;
                        }
                        q.m("inputShortBuffer");
                        throw throwable0;
                    }
                    q.m("inputShortBuffer");
                    throw null;
                }
                q.m("inputShortBuffer");
                throw null;
            }
            q.m("inputShortBuffer");
            throw null;
        }
    }

    @Override  // c3.d
    public final void reset() {
        LogU.Companion.d("[GaudioSolMusicOne] ", "reset");
        this.k = false;
        this.c.b.sampleRate = -1;
        this.c.b.numInputChannels = -1;
        this.c.c.metadata = null;
        this.c.c.metadataLength = 0;
        q.f(d.a, "EMPTY_BUFFER");
        this.s = d.a;
        if(this.l.get()) {
            this.d();
        }
    }
}

