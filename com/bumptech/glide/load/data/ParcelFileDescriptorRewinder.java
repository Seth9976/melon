package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.IOException;

public final class ParcelFileDescriptorRewinder implements DataRewinder {
    public static final class Factory implements com.bumptech.glide.load.data.DataRewinder.Factory {
        public DataRewinder build(ParcelFileDescriptor parcelFileDescriptor0) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor0);
        }

        @Override  // com.bumptech.glide.load.data.DataRewinder$Factory
        public DataRewinder build(Object object0) {
            return this.build(((ParcelFileDescriptor)object0));
        }

        @Override  // com.bumptech.glide.load.data.DataRewinder$Factory
        public Class getDataClass() {
            return ParcelFileDescriptor.class;
        }
    }

    static final class InternalRewinder {
        private final ParcelFileDescriptor parcelFileDescriptor;

        public InternalRewinder(ParcelFileDescriptor parcelFileDescriptor0) {
            this.parcelFileDescriptor = parcelFileDescriptor0;
        }

        public ParcelFileDescriptor rewind() {
            try {
                Os.lseek(this.parcelFileDescriptor.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.parcelFileDescriptor;
            }
            catch(ErrnoException errnoException0) {
                throw new IOException(errnoException0);
            }
        }
    }

    private final InternalRewinder rewinder;

    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor0) {
        this.rewinder = new InternalRewinder(parcelFileDescriptor0);
    }

    @Override  // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
    }

    // 去混淆评级： 低(40)
    public static boolean isSupported() [...] // 潜在的解密器

    public ParcelFileDescriptor rewindAndGet() {
        return this.rewinder.rewind();
    }

    @Override  // com.bumptech.glide.load.data.DataRewinder
    public Object rewindAndGet() {
        return this.rewindAndGet();
    }
}

