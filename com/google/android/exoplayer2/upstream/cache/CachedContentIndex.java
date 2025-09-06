package com.google.android.exoplayer2.upstream.cache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.ReusableBufferedOutputStream;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class CachedContentIndex {
    static final class DatabaseStorage implements Storage {
        private static final String[] COLUMNS = null;
        private static final String COLUMN_ID = "id";
        private static final int COLUMN_INDEX_ID = 0;
        private static final int COLUMN_INDEX_KEY = 1;
        private static final int COLUMN_INDEX_METADATA = 2;
        private static final String COLUMN_KEY = "key";
        private static final String COLUMN_METADATA = "metadata";
        private static final String TABLE_PREFIX = "ExoPlayerCacheIndex";
        private static final String TABLE_SCHEMA = "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)";
        private static final int TABLE_VERSION = 1;
        private static final String WHERE_ID_EQUALS = "id = ?";
        private final DatabaseProvider databaseProvider;
        private String hexUid;
        private final SparseArray pendingUpdates;
        private String tableName;

        static {
            DatabaseStorage.COLUMNS = new String[]{"id", "key", "metadata"};
        }

        public DatabaseStorage(DatabaseProvider databaseProvider0) {
            this.databaseProvider = databaseProvider0;
            this.pendingUpdates = new SparseArray();
        }

        private void addOrUpdateRow(SQLiteDatabase sQLiteDatabase0, CachedContent cachedContent0) {
            ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
            CachedContentIndex.writeContentMetadata(cachedContent0.getMetadata(), new DataOutputStream(byteArrayOutputStream0));
            byte[] arr_b = byteArrayOutputStream0.toByteArray();
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("id", cachedContent0.id);
            contentValues0.put("key", cachedContent0.key);
            contentValues0.put("metadata", arr_b);
            sQLiteDatabase0.replaceOrThrow(this.tableName, null, contentValues0);
        }

        public static void delete(DatabaseProvider databaseProvider0, long v) {
            DatabaseStorage.delete(databaseProvider0, Long.toHexString(v));
        }

        private static void delete(DatabaseProvider databaseProvider0, String s) {
            try {
                String s1 = DatabaseStorage.getTableName(s);
                SQLiteDatabase sQLiteDatabase0 = databaseProvider0.getWritableDatabase();
                sQLiteDatabase0.beginTransactionNonExclusive();
                try {
                    VersionTable.removeVersion(sQLiteDatabase0, 1, s);
                    DatabaseStorage.dropTable(sQLiteDatabase0, s1);
                    sQLiteDatabase0.setTransactionSuccessful();
                }
                finally {
                    sQLiteDatabase0.endTransaction();
                }
            }
            catch(SQLException sQLException0) {
                throw new DatabaseIOException(sQLException0);
            }
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public void delete() {
            DatabaseStorage.delete(this.databaseProvider, this.hexUid);
        }

        private void deleteRow(SQLiteDatabase sQLiteDatabase0, int v) {
            sQLiteDatabase0.delete(this.tableName, "id = ?", new String[]{Integer.toString(v)});
        }

        private static void dropTable(SQLiteDatabase sQLiteDatabase0, String s) {
            String s1 = String.valueOf(s);
            sQLiteDatabase0.execSQL((s1.length() == 0 ? new String("DROP TABLE IF EXISTS ") : "DROP TABLE IF EXISTS " + s1));
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public boolean exists() {
            return VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 1, this.hexUid) != -1;
        }

        private Cursor getCursor() {
            return this.databaseProvider.getReadableDatabase().query(this.tableName, DatabaseStorage.COLUMNS, null, null, null, null, null);
        }

        private static String getTableName(String s) {
            String s1 = String.valueOf(s);
            return s1.length() == 0 ? new String("ExoPlayerCacheIndex") : "ExoPlayerCacheIndex" + s1;
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public void initialize(long v) {
            String s = Long.toHexString(v);
            this.hexUid = s;
            this.tableName = DatabaseStorage.getTableName(s);
        }

        private void initializeTable(SQLiteDatabase sQLiteDatabase0) {
            VersionTable.setVersion(sQLiteDatabase0, 1, this.hexUid, 1);
            DatabaseStorage.dropTable(sQLiteDatabase0, this.tableName);
            sQLiteDatabase0.execSQL("CREATE TABLE " + this.tableName + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public void load(HashMap hashMap0, SparseArray sparseArray0) {
            Assertions.checkState(this.pendingUpdates.size() == 0);
            try {
                if(VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 1, this.hexUid) != 1) {
                    SQLiteDatabase sQLiteDatabase0 = this.databaseProvider.getWritableDatabase();
                    sQLiteDatabase0.beginTransactionNonExclusive();
                    try {
                        this.initializeTable(sQLiteDatabase0);
                        sQLiteDatabase0.setTransactionSuccessful();
                    }
                    finally {
                        sQLiteDatabase0.endTransaction();
                    }
                }
                try(Cursor cursor0 = this.getCursor()) {
                    while(true) {
                        if(!cursor0.moveToNext()) {
                            break;
                        }
                        CachedContent cachedContent0 = new CachedContent(cursor0.getInt(0), cursor0.getString(1), CachedContentIndex.readContentMetadata(new DataInputStream(new ByteArrayInputStream(cursor0.getBlob(2)))));
                        hashMap0.put(cachedContent0.key, cachedContent0);
                        sparseArray0.put(cachedContent0.id, cachedContent0.key);
                    }
                }
                return;
            }
            catch(SQLiteException sQLiteException0) {
            }
            hashMap0.clear();
            sparseArray0.clear();
            throw new DatabaseIOException(sQLiteException0);
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public void onRemove(CachedContent cachedContent0, boolean z) {
            if(z) {
                this.pendingUpdates.delete(cachedContent0.id);
                return;
            }
            this.pendingUpdates.put(cachedContent0.id, null);
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public void onUpdate(CachedContent cachedContent0) {
            this.pendingUpdates.put(cachedContent0.id, cachedContent0);
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public void storeFully(HashMap hashMap0) {
            try {
                SQLiteDatabase sQLiteDatabase0 = this.databaseProvider.getWritableDatabase();
                sQLiteDatabase0.beginTransactionNonExclusive();
                try {
                    this.initializeTable(sQLiteDatabase0);
                    for(Object object0: hashMap0.values()) {
                        this.addOrUpdateRow(sQLiteDatabase0, ((CachedContent)object0));
                    }
                    sQLiteDatabase0.setTransactionSuccessful();
                    this.pendingUpdates.clear();
                }
                finally {
                    sQLiteDatabase0.endTransaction();
                }
                return;
            }
            catch(SQLException sQLException0) {
            }
            throw new DatabaseIOException(sQLException0);
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public void storeIncremental(HashMap hashMap0) {
            if(this.pendingUpdates.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase sQLiteDatabase0 = this.databaseProvider.getWritableDatabase();
                sQLiteDatabase0.beginTransactionNonExclusive();
                try {
                    for(int v = 0; v < this.pendingUpdates.size(); ++v) {
                        CachedContent cachedContent0 = (CachedContent)this.pendingUpdates.valueAt(v);
                        if(cachedContent0 == null) {
                            this.deleteRow(sQLiteDatabase0, this.pendingUpdates.keyAt(v));
                        }
                        else {
                            this.addOrUpdateRow(sQLiteDatabase0, cachedContent0);
                        }
                    }
                    sQLiteDatabase0.setTransactionSuccessful();
                    this.pendingUpdates.clear();
                }
                finally {
                    sQLiteDatabase0.endTransaction();
                }
                return;
            }
            catch(SQLException sQLException0) {
            }
            throw new DatabaseIOException(sQLException0);
        }
    }

    static class LegacyStorage implements Storage {
        private static final int FLAG_ENCRYPTED_INDEX = 1;
        private static final int VERSION = 2;
        private static final int VERSION_METADATA_INTRODUCED = 2;
        private final AtomicFile atomicFile;
        private ReusableBufferedOutputStream bufferedOutputStream;
        private boolean changed;
        private final Cipher cipher;
        private final boolean encrypt;
        private final Random random;
        private final SecretKeySpec secretKeySpec;

        public LegacyStorage(File file0, byte[] arr_b, boolean z) {
            SecretKeySpec secretKeySpec0;
            Cipher cipher0;
            Random random0 = null;
            if(arr_b == null) {
                Assertions.checkArgument(!z);
                cipher0 = null;
                secretKeySpec0 = null;
            }
            else {
                Assertions.checkArgument(arr_b.length == 16);
                try {
                    cipher0 = CachedContentIndex.getCipher();
                    secretKeySpec0 = new SecretKeySpec(arr_b, "AES");
                }
                catch(NoSuchAlgorithmException | NoSuchPaddingException noSuchAlgorithmException0) {
                    throw new IllegalStateException(noSuchAlgorithmException0);
                }
            }
            this.encrypt = z;
            this.cipher = cipher0;
            this.secretKeySpec = secretKeySpec0;
            if(z) {
                random0 = new Random();
            }
            this.random = random0;
            this.atomicFile = new AtomicFile(file0);
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public void delete() {
            this.atomicFile.delete();
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public boolean exists() {
            return this.atomicFile.exists();
        }

        private int hashCachedContent(CachedContent cachedContent0, int v) {
            int v1 = cachedContent0.key.hashCode() + cachedContent0.id * 0x1F;
            if(v < 2) {
                long v2 = ContentMetadata.getContentLength(cachedContent0.getMetadata());
                return v1 * 0x1F + ((int)(v2 ^ v2 >>> 0x20));
            }
            return cachedContent0.getMetadata().hashCode() + v1 * 0x1F;
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public void initialize(long v) {
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public void load(HashMap hashMap0, SparseArray sparseArray0) {
            Assertions.checkState(!this.changed);
            if(!this.readFile(hashMap0, sparseArray0)) {
                hashMap0.clear();
                sparseArray0.clear();
                this.atomicFile.delete();
            }
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public void onRemove(CachedContent cachedContent0, boolean z) {
            this.changed = true;
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public void onUpdate(CachedContent cachedContent0) {
            this.changed = true;
        }

        private CachedContent readCachedContent(int v, DataInputStream dataInputStream0) {
            int v1 = dataInputStream0.readInt();
            String s = dataInputStream0.readUTF();
            if(v < 2) {
                long v2 = dataInputStream0.readLong();
                ContentMetadataMutations contentMetadataMutations0 = new ContentMetadataMutations();
                ContentMetadataMutations.setContentLength(contentMetadataMutations0, v2);
                return new CachedContent(v1, s, DefaultContentMetadata.EMPTY.copyWithMutationsApplied(contentMetadataMutations0));
            }
            return new CachedContent(v1, s, CachedContentIndex.readContentMetadata(dataInputStream0));
        }

        private boolean readFile(HashMap hashMap0, SparseArray sparseArray0) {
            int v;
            DataInputStream dataInputStream1;
            BufferedInputStream bufferedInputStream0;
            DataInputStream dataInputStream0;
            if(!this.atomicFile.exists()) {
                return true;
            }
            try {
                dataInputStream0 = null;
                bufferedInputStream0 = new BufferedInputStream(this.atomicFile.openRead());
                dataInputStream1 = new DataInputStream(bufferedInputStream0);
                goto label_8;
            }
            catch(IOException unused_ex) {
                goto label_42;
            }
            catch(Throwable throwable0) {
            }
            goto label_45;
            try {
            label_8:
                v = dataInputStream1.readInt();
                if(v >= 0 && v <= 2) {
                    if((dataInputStream1.readInt() & 1) != 0) {
                        goto label_14;
                    }
                    else if(this.encrypt) {
                        this.changed = true;
                    }
                    goto label_25;
                }
                goto label_56;
            }
            catch(IOException unused_ex) {
                dataInputStream0 = dataInputStream1;
                goto label_42;
            }
            catch(Throwable throwable0) {
                dataInputStream0 = dataInputStream1;
                goto label_45;
            }
        label_14:
            if(this.cipher == null) {
                Util.closeQuietly(dataInputStream1);
                return false;
            }
            try {
                byte[] arr_b = new byte[16];
                dataInputStream1.readFully(arr_b);
                IvParameterSpec ivParameterSpec0 = new IvParameterSpec(arr_b);
                try {
                    this.cipher.init(2, this.secretKeySpec, ivParameterSpec0);
                }
                catch(InvalidKeyException | InvalidAlgorithmParameterException invalidKeyException0) {
                    throw new IllegalStateException(invalidKeyException0);
                }
                dataInputStream1 = new DataInputStream(new CipherInputStream(bufferedInputStream0, this.cipher));
            label_25:
                int v1 = dataInputStream1.readInt();
                int v3 = 0;
                for(int v2 = 0; v2 < v1; ++v2) {
                    CachedContent cachedContent0 = this.readCachedContent(v, dataInputStream1);
                    hashMap0.put(cachedContent0.key, cachedContent0);
                    sparseArray0.put(cachedContent0.id, cachedContent0.key);
                    v3 += this.hashCachedContent(cachedContent0, v);
                }
                int v4 = dataInputStream1.readInt();
                if(dataInputStream1.read() == -1) {
                    goto label_48;
                }
                else {
                    goto label_50;
                }
                goto label_51;
            }
            catch(IOException unused_ex) {
                dataInputStream0 = dataInputStream1;
            }
            catch(Throwable throwable0) {
                dataInputStream0 = dataInputStream1;
                goto label_45;
            }
        label_42:
            if(dataInputStream0 != null) {
                Util.closeQuietly(dataInputStream0);
            }
            return false;
        label_45:
            if(dataInputStream0 != null) {
                Util.closeQuietly(dataInputStream0);
            }
            throw throwable0;
        label_48:
            boolean z = true;
            goto label_51;
        label_50:
            z = false;
        label_51:
            if(v4 == v3 && z) {
                Util.closeQuietly(dataInputStream1);
                return true;
            }
            Util.closeQuietly(dataInputStream1);
            return false;
        label_56:
            Util.closeQuietly(dataInputStream1);
            return false;
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public void storeFully(HashMap hashMap0) {
            this.writeFile(hashMap0);
            this.changed = false;
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CachedContentIndex$Storage
        public void storeIncremental(HashMap hashMap0) {
            if(!this.changed) {
                return;
            }
            this.storeFully(hashMap0);
        }

        private void writeCachedContent(CachedContent cachedContent0, DataOutputStream dataOutputStream0) {
            dataOutputStream0.writeInt(cachedContent0.id);
            dataOutputStream0.writeUTF(cachedContent0.key);
            CachedContentIndex.writeContentMetadata(cachedContent0.getMetadata(), dataOutputStream0);
        }

        private void writeFile(HashMap hashMap0) {
            DataOutputStream dataOutputStream0;
            Closeable closeable0 = null;
            try {
                OutputStream outputStream0 = this.atomicFile.startWrite();
                ReusableBufferedOutputStream reusableBufferedOutputStream0 = this.bufferedOutputStream;
                if(reusableBufferedOutputStream0 == null) {
                    this.bufferedOutputStream = new ReusableBufferedOutputStream(outputStream0);
                }
                else {
                    reusableBufferedOutputStream0.reset(outputStream0);
                }
                dataOutputStream0 = new DataOutputStream(this.bufferedOutputStream);
                goto label_11;
            }
            catch(Throwable throwable0) {
            }
            Util.closeQuietly(closeable0);
            throw throwable0;
            try {
            label_11:
                dataOutputStream0.writeInt(2);
                dataOutputStream0.writeInt(((int)this.encrypt));
                if(this.encrypt) {
                    byte[] arr_b = new byte[16];
                    this.random.nextBytes(arr_b);
                    dataOutputStream0.write(arr_b);
                    IvParameterSpec ivParameterSpec0 = new IvParameterSpec(arr_b);
                    try {
                        this.cipher.init(1, this.secretKeySpec, ivParameterSpec0);
                    }
                    catch(InvalidKeyException | InvalidAlgorithmParameterException invalidKeyException0) {
                        throw new IllegalStateException(invalidKeyException0);
                    }
                    dataOutputStream0.flush();
                    dataOutputStream0 = new DataOutputStream(new CipherOutputStream(this.bufferedOutputStream, this.cipher));
                }
                dataOutputStream0.writeInt(hashMap0.size());
                int v = 0;
                for(Object object0: hashMap0.values()) {
                    this.writeCachedContent(((CachedContent)object0), dataOutputStream0);
                    v += this.hashCachedContent(((CachedContent)object0), 2);
                }
                dataOutputStream0.writeInt(v);
                this.atomicFile.endWrite(dataOutputStream0);
            }
            catch(Throwable throwable0) {
                closeable0 = dataOutputStream0;
                Util.closeQuietly(closeable0);
                throw throwable0;
            }
            Util.closeQuietly(null);
        }
    }

    interface Storage {
        void delete();

        boolean exists();

        void initialize(long arg1);

        void load(HashMap arg1, SparseArray arg2);

        void onRemove(CachedContent arg1, boolean arg2);

        void onUpdate(CachedContent arg1);

        void storeFully(HashMap arg1);

        void storeIncremental(HashMap arg1);
    }

    static final String FILE_NAME_ATOMIC = "cached_content_index.exi";
    private static final int INCREMENTAL_METADATA_READ_LENGTH = 0xA00000;
    private final SparseArray idToKey;
    private final HashMap keyToContent;
    private final SparseBooleanArray newIds;
    private Storage previousStorage;
    private final SparseBooleanArray removedIds;
    private Storage storage;

    public CachedContentIndex(DatabaseProvider databaseProvider0) {
        this(databaseProvider0, null, null, false, false);
    }

    public CachedContentIndex(DatabaseProvider databaseProvider0, File file0, byte[] arr_b, boolean z, boolean z1) {
        Assertions.checkState(databaseProvider0 != null || file0 != null);
        this.keyToContent = new HashMap();
        this.idToKey = new SparseArray();
        this.removedIds = new SparseBooleanArray();
        this.newIds = new SparseBooleanArray();
        LegacyStorage cachedContentIndex$LegacyStorage0 = null;
        DatabaseStorage cachedContentIndex$DatabaseStorage0 = databaseProvider0 == null ? null : new DatabaseStorage(databaseProvider0);
        if(file0 != null) {
            cachedContentIndex$LegacyStorage0 = new LegacyStorage(new File(file0, "cached_content_index.exi"), arr_b, z);
        }
        if(cachedContentIndex$DatabaseStorage0 != null && (cachedContentIndex$LegacyStorage0 == null || !z1)) {
            this.storage = cachedContentIndex$DatabaseStorage0;
            this.previousStorage = cachedContentIndex$LegacyStorage0;
            return;
        }
        this.storage = cachedContentIndex$LegacyStorage0;
        this.previousStorage = cachedContentIndex$DatabaseStorage0;
    }

    private CachedContent addNew(String s) {
        int v = CachedContentIndex.getNewId(this.idToKey);
        CachedContent cachedContent0 = new CachedContent(v, s);
        this.keyToContent.put(s, cachedContent0);
        this.idToKey.put(v, s);
        this.newIds.put(v, true);
        this.storage.onUpdate(cachedContent0);
        return cachedContent0;
    }

    public void applyContentMetadataMutations(String s, ContentMetadataMutations contentMetadataMutations0) {
        CachedContent cachedContent0 = this.getOrAdd(s);
        if(cachedContent0.applyMetadataMutations(contentMetadataMutations0)) {
            this.storage.onUpdate(cachedContent0);
        }
    }

    public int assignIdForKey(String s) {
        return this.getOrAdd(s).id;
    }

    public static void delete(DatabaseProvider databaseProvider0, long v) {
        DatabaseStorage.delete(databaseProvider0, v);
    }

    public CachedContent get(String s) {
        return (CachedContent)this.keyToContent.get(s);
    }

    public Collection getAll() {
        return this.keyToContent.values();
    }

    @SuppressLint({"GetInstance"})
    private static Cipher getCipher() {
        if(Util.SDK_INT == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            }
            catch(Throwable unused_ex) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public ContentMetadata getContentMetadata(String s) {
        CachedContent cachedContent0 = this.get(s);
        return cachedContent0 == null ? DefaultContentMetadata.EMPTY : cachedContent0.getMetadata();
    }

    public String getKeyForId(int v) {
        return (String)this.idToKey.get(v);
    }

    public Set getKeys() {
        return this.keyToContent.keySet();
    }

    public static int getNewId(SparseArray sparseArray0) {
        int v = sparseArray0.size();
        int v1 = 0;
        int v2 = v == 0 ? 0 : sparseArray0.keyAt(v - 1) + 1;
        if(v2 < 0) {
            while(v1 < v && v1 == sparseArray0.keyAt(v1)) {
                ++v1;
            }
            return v1;
        }
        return v2;
    }

    public CachedContent getOrAdd(String s) {
        CachedContent cachedContent0 = (CachedContent)this.keyToContent.get(s);
        return cachedContent0 == null ? this.addNew(s) : cachedContent0;
    }

    public void initialize(long v) {
        this.storage.initialize(v);
        Storage cachedContentIndex$Storage0 = this.previousStorage;
        if(cachedContentIndex$Storage0 != null) {
            cachedContentIndex$Storage0.initialize(v);
        }
        if(this.storage.exists() || (this.previousStorage == null || !this.previousStorage.exists())) {
            this.storage.load(this.keyToContent, this.idToKey);
        }
        else {
            this.previousStorage.load(this.keyToContent, this.idToKey);
            this.storage.storeFully(this.keyToContent);
        }
        Storage cachedContentIndex$Storage1 = this.previousStorage;
        if(cachedContentIndex$Storage1 != null) {
            cachedContentIndex$Storage1.delete();
            this.previousStorage = null;
        }
    }

    public static boolean isIndexFile(String s) {
        return s.startsWith("cached_content_index.exi");
    }

    public void maybeRemove(String s) {
        CachedContent cachedContent0 = (CachedContent)this.keyToContent.get(s);
        if(cachedContent0 != null && cachedContent0.isEmpty() && !cachedContent0.isLocked()) {
            this.keyToContent.remove(s);
            int v = cachedContent0.id;
            boolean z = this.newIds.get(v);
            this.storage.onRemove(cachedContent0, z);
            if(z) {
                this.idToKey.remove(v);
                this.newIds.delete(v);
                return;
            }
            this.idToKey.put(v, null);
            this.removedIds.put(v, true);
        }
    }

    private static DefaultContentMetadata readContentMetadata(DataInputStream dataInputStream0) {
        int v = dataInputStream0.readInt();
        HashMap hashMap0 = new HashMap();
        for(int v1 = 0; v1 < v; ++v1) {
            String s = dataInputStream0.readUTF();
            int v2 = dataInputStream0.readInt();
            if(v2 < 0) {
                throw new IOException("Invalid value size: " + v2);
            }
            int v3 = Math.min(v2, 0xA00000);
            byte[] arr_b = Util.EMPTY_BYTE_ARRAY;
            for(int v4 = 0; v4 != v2; v4 = v5) {
                int v5 = v4 + v3;
                arr_b = Arrays.copyOf(arr_b, v5);
                dataInputStream0.readFully(arr_b, v4, v3);
                v3 = Math.min(v2 - v5, 0xA00000);
            }
            hashMap0.put(s, arr_b);
        }
        return new DefaultContentMetadata(hashMap0);
    }

    public void removeEmpty() {
        int v = this.keyToContent.size();
        String[] arr_s = new String[v];
        this.keyToContent.keySet().toArray(arr_s);
        for(int v1 = 0; v1 < v; ++v1) {
            this.maybeRemove(arr_s[v1]);
        }
    }

    public void store() {
        this.storage.storeIncremental(this.keyToContent);
        int v = this.removedIds.size();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = this.removedIds.keyAt(v1);
            this.idToKey.remove(v2);
        }
        this.removedIds.clear();
        this.newIds.clear();
    }

    private static void writeContentMetadata(DefaultContentMetadata defaultContentMetadata0, DataOutputStream dataOutputStream0) {
        Set set0 = defaultContentMetadata0.entrySet();
        dataOutputStream0.writeInt(set0.size());
        for(Object object0: set0) {
            dataOutputStream0.writeUTF(((String)((Map.Entry)object0).getKey()));
            byte[] arr_b = (byte[])((Map.Entry)object0).getValue();
            dataOutputStream0.writeInt(arr_b.length);
            dataOutputStream0.write(arr_b);
        }
    }
}

