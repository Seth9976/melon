package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileLoader implements ModelLoader {
    public static class Factory implements ModelLoaderFactory {
        private final FileOpener opener;

        public Factory(FileOpener fileLoader$FileOpener0) {
            this.opener = fileLoader$FileOpener0;
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory0) {
            return new FileLoader(this.opener);
        }

        @Override  // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }
    }

    public static class FileDescriptorFactory extends Factory {
        public FileDescriptorFactory() {
            super(new com.bumptech.glide.load.model.FileLoader.FileDescriptorFactory.1());

            class com.bumptech.glide.load.model.FileLoader.FileDescriptorFactory.1 implements FileOpener {
                public void close(ParcelFileDescriptor parcelFileDescriptor0) {
                    parcelFileDescriptor0.close();
                }

                @Override  // com.bumptech.glide.load.model.FileLoader$FileOpener
                public void close(Object object0) {
                    this.close(((ParcelFileDescriptor)object0));
                }

                @Override  // com.bumptech.glide.load.model.FileLoader$FileOpener
                public Class getDataClass() {
                    return ParcelFileDescriptor.class;
                }

                public ParcelFileDescriptor open(File file0) {
                    return ParcelFileDescriptor.open(file0, 0x10000000);
                }

                @Override  // com.bumptech.glide.load.model.FileLoader$FileOpener
                public Object open(File file0) {
                    return this.open(file0);
                }
            }

        }
    }

    static final class FileFetcher implements DataFetcher {
        private Object data;
        private final File file;
        private final FileOpener opener;

        public FileFetcher(File file0, FileOpener fileLoader$FileOpener0) {
            this.file = file0;
            this.opener = fileLoader$FileOpener0;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
            Object object0 = this.data;
            if(object0 != null) {
                try {
                    this.opener.close(object0);
                }
                catch(IOException unused_ex) {
                }
            }
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public Class getDataClass() {
            return this.opener.getDataClass();
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override  // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority0, DataCallback dataFetcher$DataCallback0) {
            try {
                Object object0 = this.opener.open(this.file);
                this.data = object0;
                dataFetcher$DataCallback0.onDataReady(object0);
            }
            catch(FileNotFoundException fileNotFoundException0) {
                if(Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", fileNotFoundException0);
                }
                dataFetcher$DataCallback0.onLoadFailed(fileNotFoundException0);
            }
        }
    }

    public interface FileOpener {
        void close(Object arg1);

        Class getDataClass();

        Object open(File arg1);
    }

    public static class StreamFactory extends Factory {
        public StreamFactory() {
            super(new com.bumptech.glide.load.model.FileLoader.StreamFactory.1());

            class com.bumptech.glide.load.model.FileLoader.StreamFactory.1 implements FileOpener {
                public void close(InputStream inputStream0) {
                    inputStream0.close();
                }

                @Override  // com.bumptech.glide.load.model.FileLoader$FileOpener
                public void close(Object object0) {
                    this.close(((InputStream)object0));
                }

                @Override  // com.bumptech.glide.load.model.FileLoader$FileOpener
                public Class getDataClass() {
                    return InputStream.class;
                }

                public InputStream open(File file0) {
                    return new FileInputStream(file0);
                }

                @Override  // com.bumptech.glide.load.model.FileLoader$FileOpener
                public Object open(File file0) {
                    return this.open(file0);
                }
            }

        }
    }

    private static final String TAG = "FileLoader";
    private final FileOpener fileOpener;

    public FileLoader(FileOpener fileLoader$FileOpener0) {
        this.fileOpener = fileLoader$FileOpener0;
    }

    public LoadData buildLoadData(File file0, int v, int v1, Options options0) {
        return new LoadData(new ObjectKey(file0), new FileFetcher(file0, this.fileOpener));
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        return this.buildLoadData(((File)object0), v, v1, options0);
    }

    public boolean handles(File file0) {
        return true;
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object object0) {
        return this.handles(((File)object0));
    }
}

