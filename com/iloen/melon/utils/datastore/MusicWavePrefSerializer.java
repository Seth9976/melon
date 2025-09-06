package com.iloen.melon.utils.datastore;

import com.iloen.melon.MusicWavePreference;
import ie.H;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import l2.b;
import l2.c0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0003H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\bH\u0096@¢\u0006\u0004\b\u000B\u0010\fR\u0014\u0010\u000F\u001A\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/utils/datastore/MusicWavePrefSerializer;", "Ll2/c0;", "Lcom/iloen/melon/MusicWavePreference;", "Ljava/io/InputStream;", "input", "readFrom", "(Ljava/io/InputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "Ljava/io/OutputStream;", "output", "Lie/H;", "writeTo", "(Lcom/iloen/melon/MusicWavePreference;Ljava/io/OutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefaultValue", "()Lcom/iloen/melon/MusicWavePreference;", "defaultValue", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWavePrefSerializer implements c0 {
    public static final int $stable;
    @NotNull
    public static final MusicWavePrefSerializer INSTANCE;

    static {
        MusicWavePrefSerializer.INSTANCE = new MusicWavePrefSerializer();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @NotNull
    public MusicWavePreference getDefaultValue() {
        MusicWavePreference musicWavePreference0 = MusicWavePreference.getDefaultInstance();
        q.f(musicWavePreference0, "getDefaultInstance(...)");
        return musicWavePreference0;
    }

    @Override  // l2.c0
    public Object getDefaultValue() {
        return this.getDefaultValue();
    }

    @Override  // l2.c0
    @Nullable
    public Object readFrom(@NotNull InputStream inputStream0, @NotNull Continuation continuation0) {
        try {
            MusicWavePreference musicWavePreference0 = MusicWavePreference.parseFrom(inputStream0);
            q.f(musicWavePreference0, "parseFrom(...)");
            return musicWavePreference0;
        }
        catch(IOException iOException0) {
            throw new b("Cannot read proto.", iOException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
    }

    @Nullable
    public Object writeTo(@NotNull MusicWavePreference musicWavePreference0, @NotNull OutputStream outputStream0, @NotNull Continuation continuation0) {
        musicWavePreference0.writeTo(outputStream0);
        return H.a;
    }

    @Override  // l2.c0
    public Object writeTo(Object object0, OutputStream outputStream0, Continuation continuation0) {
        return this.writeTo(((MusicWavePreference)object0), outputStream0, continuation0);
    }
}

