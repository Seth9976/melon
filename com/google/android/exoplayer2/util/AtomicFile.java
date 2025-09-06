package com.google.android.exoplayer2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class AtomicFile {
    static final class AtomicFileOutputStream extends OutputStream {
        private boolean closed;
        private final FileOutputStream fileOutputStream;

        public AtomicFileOutputStream(File file0) {
            this.closed = false;
            this.fileOutputStream = new FileOutputStream(file0);
        }

        @Override
        public void close() {
            if(this.closed) {
                return;
            }
            this.closed = true;
            this.flush();
            try {
                this.fileOutputStream.getFD().sync();
            }
            catch(IOException iOException0) {
                Log.w("AtomicFile", "Failed to sync file descriptor:", iOException0);
            }
            this.fileOutputStream.close();
        }

        @Override
        public void flush() {
            this.fileOutputStream.flush();
        }

        @Override
        public void write(int v) {
            this.fileOutputStream.write(v);
        }

        @Override
        public void write(byte[] arr_b) {
            this.fileOutputStream.write(arr_b);
        }

        @Override
        public void write(byte[] arr_b, int v, int v1) {
            this.fileOutputStream.write(arr_b, v, v1);
        }
    }

    private static final String TAG = "AtomicFile";
    private final File backupName;
    private final File baseName;

    public AtomicFile(File file0) {
        this.baseName = file0;
        this.backupName = new File(file0.getPath() + ".bak");
    }

    public void delete() {
        this.baseName.delete();
        this.backupName.delete();
    }

    public void endWrite(OutputStream outputStream0) {
        outputStream0.close();
        this.backupName.delete();
    }

    // 去混淆评级： 低(20)
    public boolean exists() {
        return this.baseName.exists() || this.backupName.exists();
    }

    public InputStream openRead() {
        this.restoreBackup();
        return new FileInputStream(this.baseName);
    }

    private void restoreBackup() {
        if(this.backupName.exists()) {
            this.baseName.delete();
            this.backupName.renameTo(this.baseName);
        }
    }

    public OutputStream startWrite() {
        if(this.baseName.exists()) {
            if(this.backupName.exists()) {
                this.baseName.delete();
            }
            else if(!this.baseName.renameTo(this.backupName)) {
                Log.w("AtomicFile", "Couldn\'t rename file " + this.baseName + " to backup file " + this.backupName);
            }
        }
        try {
            return new AtomicFileOutputStream(this.baseName);
        }
        catch(FileNotFoundException fileNotFoundException0) {
            File file0 = this.baseName.getParentFile();
            if(file0 != null && file0.mkdirs()) {
                try {
                    return new AtomicFileOutputStream(this.baseName);
                }
                catch(FileNotFoundException fileNotFoundException1) {
                    throw new IOException("Couldn\'t create " + this.baseName, fileNotFoundException1);
                }
            }
            throw new IOException("Couldn\'t create " + this.baseName, fileNotFoundException0);
        }
    }
}

