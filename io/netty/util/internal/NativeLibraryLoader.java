package io.netty.util.internal;

import com.iloen.melon.utils.a;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AccessController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

public final class NativeLibraryLoader {
    static final class NoexecVolumeDetector {
        // 去混淆评级： 低(40)
        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        private static boolean canExecuteExecutable(File file0) {
            return true;
        }
    }

    static final boolean $assertionsDisabled = false;
    private static final boolean DELETE_NATIVE_LIB_AFTER_LOADING = false;
    private static final boolean DETECT_NATIVE_LIBRARY_DUPLICATES = false;
    private static final String NATIVE_RESOURCE_HOME = "META-INF/native/";
    private static final boolean TRY_TO_PATCH_SHADED_ID;
    private static final byte[] UNIQUE_ID_BYTES;
    private static final File WORKDIR;
    private static final InternalLogger logger;

    static {
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(NativeLibraryLoader.class);
        NativeLibraryLoader.logger = internalLogger0;
        NativeLibraryLoader.UNIQUE_ID_BYTES = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes(CharsetUtil.US_ASCII);
        String s = SystemPropertyUtil.get("io.netty.native.workdir");
        if(s == null) {
            File file1 = PlatformDependent.tmpdir();
            NativeLibraryLoader.WORKDIR = file1;
            internalLogger0.debug("-Dio.netty.native.workdir: " + file1 + " (io.netty.tmpdir)");
        }
        else {
            File file0 = new File(s);
            file0.mkdirs();
            try {
                file0 = file0.getAbsoluteFile();
            }
            catch(Exception unused_ex) {
            }
            NativeLibraryLoader.WORKDIR = file0;
            NativeLibraryLoader.logger.debug("-Dio.netty.native.workdir: " + file0);
        }
        boolean z = SystemPropertyUtil.getBoolean("io.netty.native.deleteLibAfterLoading", true);
        NativeLibraryLoader.DELETE_NATIVE_LIB_AFTER_LOADING = z;
        NativeLibraryLoader.logger.debug("-Dio.netty.native.deleteLibAfterLoading: {}", Boolean.valueOf(z));
        boolean z1 = SystemPropertyUtil.getBoolean("io.netty.native.tryPatchShadedId", true);
        NativeLibraryLoader.TRY_TO_PATCH_SHADED_ID = z1;
        NativeLibraryLoader.logger.debug("-Dio.netty.native.tryPatchShadedId: {}", Boolean.valueOf(z1));
        boolean z2 = SystemPropertyUtil.getBoolean("io.netty.native.detectNativeLibraryDuplicates", true);
        NativeLibraryLoader.DETECT_NATIVE_LIBRARY_DUPLICATES = z2;
        NativeLibraryLoader.logger.debug("-Dio.netty.native.detectNativeLibraryDuplicates: {}", Boolean.valueOf(z2));
    }

    // 去混淆评级： 高(220)
    private static String calculateMangledPackagePrefix() [...] // 潜在的解密器

    private static byte[] classToByteArray(Class class0) {
        InputStream inputStream0;
        String s = class0.getName();
        int v = s.lastIndexOf(46);
        if(v > 0) {
            s = s.substring(v + 1);
        }
        URL uRL0 = class0.getResource(s + ".class");
        if(uRL0 != null) {
            byte[] arr_b = new byte[0x400];
            ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream(0x1000);
            try {
                inputStream0 = uRL0.openStream();
                int v2;
                while((v2 = inputStream0.read(arr_b)) != -1) {
                    byteArrayOutputStream0.write(arr_b, 0, v2);
                }
                return byteArrayOutputStream0.toByteArray();
            }
            catch(IOException iOException0) {
                throw new ClassNotFoundException(class0.getName(), iOException0);
            }
            finally {
                NativeLibraryLoader.closeQuietly(inputStream0);
                NativeLibraryLoader.closeQuietly(byteArrayOutputStream0);
            }
        }
        throw new ClassNotFoundException(class0.getName());
    }

    private static void closeQuietly(Closeable closeable0) {
        if(closeable0 != null) {
            try {
                closeable0.close();
            }
            catch(IOException unused_ex) {
            }
        }
    }

    private static byte[] digest(MessageDigest messageDigest0, URL uRL0) {
        byte[] arr_b1;
        InputStream inputStream0;
        Closeable closeable0 = null;
        try {
            inputStream0 = null;
            inputStream0 = uRL0.openStream();
            goto label_6;
        }
        catch(IOException iOException0) {
            goto label_17;
        }
        catch(Throwable throwable0) {
        }
        NativeLibraryLoader.closeQuietly(closeable0);
        throw throwable0;
        try {
            try {
            label_6:
                byte[] arr_b = new byte[0x2000];
                int v;
                while((v = inputStream0.read(arr_b)) != -1) {
                    messageDigest0.update(arr_b, 0, v);
                }
                arr_b1 = messageDigest0.digest();
                goto label_22;
            }
            catch(IOException iOException0) {
            }
        label_17:
            NativeLibraryLoader.logger.debug("Can\'t read resource.", iOException0);
        }
        catch(Throwable throwable0) {
            closeable0 = inputStream0;
            NativeLibraryLoader.closeQuietly(closeable0);
            throw throwable0;
        }
        NativeLibraryLoader.closeQuietly(inputStream0);
        return null;
    label_22:
        NativeLibraryLoader.closeQuietly(inputStream0);
        return arr_b1;
    }

    private static byte[] generateUniqueId(int v) {
        byte[] arr_b = new byte[v];
        for(int v1 = 0; v1 < v; ++v1) {
            arr_b[v1] = NativeLibraryLoader.UNIQUE_ID_BYTES[PlatformDependent.threadLocalRandom().nextInt(NativeLibraryLoader.UNIQUE_ID_BYTES.length)];
        }
        return arr_b;
    }

    private static URL getResource(String s, ClassLoader classLoader0) {
        Enumeration enumeration0;
        try {
            enumeration0 = classLoader0 == null ? ClassLoader.getSystemResources(s) : classLoader0.getResources(s);
        }
        catch(IOException iOException0) {
            throw new RuntimeException("An error occurred while getting the resources for " + s, iOException0);
        }
        ArrayList arrayList0 = Collections.list(enumeration0);
        int v1 = arrayList0.size();
        switch(v1) {
            case 0: {
                return null;
            }
            case 1: {
                return (URL)arrayList0.get(0);
            }
            default: {
                if(NativeLibraryLoader.DETECT_NATIVE_LIBRARY_DUPLICATES) {
                    try {
                        MessageDigest messageDigest0 = MessageDigest.getInstance("SHA-256");
                        URL uRL0 = (URL)arrayList0.get(0);
                        byte[] arr_b = NativeLibraryLoader.digest(messageDigest0, uRL0);
                        if(arr_b != null) {
                            for(int v = 1; true; ++v) {
                                if(v >= v1) {
                                    return uRL0;
                                }
                                byte[] arr_b1 = NativeLibraryLoader.digest(messageDigest0, ((URL)arrayList0.get(v)));
                                if(arr_b1 == null || !Arrays.equals(arr_b, arr_b1)) {
                                    break;
                                }
                            }
                        }
                    }
                    catch(NoSuchAlgorithmException noSuchAlgorithmException0) {
                        NativeLibraryLoader.logger.debug("Don\'t support SHA-256, can\'t check if resources have same content.", noSuchAlgorithmException0);
                    }
                    throw new IllegalStateException("Multiple resources found for \'" + s + "\' with different content: " + arrayList0);
                }
                NativeLibraryLoader.logger.warn("Multiple resources found for \'" + s + "\' with different content: " + arrayList0 + ". Please fix your dependency graph.");
                return (URL)arrayList0.get(0);
            }
        }
    }

    public static void load(String s, ClassLoader classLoader0) {
        InputStream inputStream0;
        Closeable closeable1;
        File file0;
        ArrayList arrayList0 = new ArrayList();
        try {
            NativeLibraryLoader.loadLibrary(classLoader0, "" + s, false);
        }
        catch(Throwable throwable0) {
            arrayList0.add(throwable0);
            String s1 = System.mapLibraryName(("" + s));
            URL uRL0 = NativeLibraryLoader.getResource(("META-INF/native/" + s1), classLoader0);
            Closeable closeable0 = null;
            try {
                if(uRL0 == null) {
                    FileNotFoundException fileNotFoundException0 = new FileNotFoundException("META-INF/native/" + s1);
                    ThrowableUtil.addSuppressedAndClear(fileNotFoundException0, arrayList0);
                    throw fileNotFoundException0;
                }
                int v = s1.lastIndexOf(46);
                file0 = PlatformDependent.createTempFile(s1.substring(0, v), s1.substring(v), NativeLibraryLoader.WORKDIR);
            }
            catch(UnsatisfiedLinkError unsatisfiedLinkError0) {
                inputStream0 = null;
                closeable1 = null;
                goto label_66;
            }
            catch(Exception exception0) {
                file0 = null;
                closeable1 = null;
                goto label_79;
            }
            catch(Throwable throwable1) {
                file0 = null;
                closeable1 = null;
                goto label_84;
            }
            try {
                inputStream0 = null;
                inputStream0 = uRL0.openStream();
            }
            catch(UnsatisfiedLinkError unsatisfiedLinkError0) {
                closeable1 = null;
                goto label_65;
            }
            catch(Exception exception0) {
                closeable1 = null;
                goto label_79;
            }
            catch(Throwable throwable1) {
                closeable1 = null;
                goto label_84;
            }
            try {
                closeable1 = new FileOutputStream(file0);
            }
            catch(UnsatisfiedLinkError unsatisfiedLinkError0) {
                closeable1 = null;
                goto label_65;
            }
            catch(Exception exception0) {
                closeable1 = null;
                closeable0 = inputStream0;
                goto label_79;
            }
            catch(Throwable throwable1) {
                goto label_56;
            }
            try {
                byte[] arr_b = new byte[0x2000];
                int v1;
                while((v1 = inputStream0.read(arr_b)) > 0) {
                    ((OutputStream)closeable1).write(arr_b, 0, v1);
                }
                ((OutputStream)closeable1).flush();
                NativeLibraryLoader.closeQuietly(closeable1);
            }
            catch(UnsatisfiedLinkError unsatisfiedLinkError0) {
                goto label_65;
            }
            catch(Exception exception0) {
                closeable0 = inputStream0;
                goto label_79;
            }
            catch(Throwable throwable1) {
                closeable0 = inputStream0;
                goto label_84;
            }
            try {
                NativeLibraryLoader.loadLibrary(classLoader0, file0.getPath(), true);
                goto label_89;
            }
            catch(UnsatisfiedLinkError unsatisfiedLinkError0) {
                closeable1 = null;
                goto label_65;
            }
            catch(Exception exception0) {
                closeable1 = null;
                closeable0 = inputStream0;
                goto label_79;
            }
            catch(Throwable throwable1) {
            label_56:
                closeable1 = null;
                while(true) {
                    try {
                        closeable0 = inputStream0;
                        goto label_84;
                    label_65:
                        closeable0 = file0;
                        break;
                    }
                    catch(UnsatisfiedLinkError unsatisfiedLinkError0) {
                        goto label_65;
                    }
                    catch(Exception exception0) {
                        closeable0 = inputStream0;
                        goto label_79;
                    }
                    catch(Throwable throwable1) {
                    }
                }
            }
        label_66:
            if(closeable0 == null) {
                goto label_74;
            }
            else {
                try {
                    if(((File)closeable0).isFile() && ((File)closeable0).canRead() && !NoexecVolumeDetector.canExecuteExecutable(((File)closeable0))) {
                        String s2 = ((File)closeable0).getPath();
                        NativeLibraryLoader.logger.info("{} exists but cannot be executed even when execute permissions set; check volume for \"noexec\" flag; use -D{}=[path] to set native working directory separately.", s2, "io.netty.native.workdir");
                        goto label_74;
                    }
                }
                catch(Throwable throwable2) {
                    try {
                        arrayList0.add(throwable2);
                        NativeLibraryLoader.logger.debug("Error checking if {} is on a file store mounted with noexec", closeable0, throwable2);
                    label_74:
                        ThrowableUtil.addSuppressedAndClear(unsatisfiedLinkError0, arrayList0);
                        throw unsatisfiedLinkError0;
                    }
                    catch(Throwable throwable1) {
                    }
                }
            }
            file0 = closeable0;
            closeable0 = inputStream0;
            goto label_84;
            try {
            label_79:
                UnsatisfiedLinkError unsatisfiedLinkError1 = new UnsatisfiedLinkError("could not load a native library: " + ("" + s));
                unsatisfiedLinkError1.initCause(exception0);
                ThrowableUtil.addSuppressedAndClear(unsatisfiedLinkError1, arrayList0);
                throw unsatisfiedLinkError1;
            }
            catch(Throwable throwable1) {
            }
        label_84:
            NativeLibraryLoader.closeQuietly(closeable0);
            NativeLibraryLoader.closeQuietly(closeable1);
            if(file0 != null && (!NativeLibraryLoader.DELETE_NATIVE_LIB_AFTER_LOADING || !file0.delete())) {
                file0.deleteOnExit();
            }
            throw throwable1;
        label_89:
            NativeLibraryLoader.closeQuietly(inputStream0);
            NativeLibraryLoader.closeQuietly(null);
            if(!NativeLibraryLoader.DELETE_NATIVE_LIB_AFTER_LOADING || !file0.delete()) {
                file0.deleteOnExit();
            }
        }
    }

    public static void loadFirstAvailable(ClassLoader classLoader0, String[] arr_s) {
        ArrayList arrayList0 = new ArrayList();
        int v = 0;
        while(v < arr_s.length) {
            String s = arr_s[v];
            try {
                NativeLibraryLoader.load(s, classLoader0);
                NativeLibraryLoader.logger.debug("Loaded library with name \'{}\'", s);
                return;
            }
            catch(Throwable throwable0) {
                arrayList0.add(throwable0);
                ++v;
            }
        }
        IllegalArgumentException illegalArgumentException0 = new IllegalArgumentException("Failed to load any of the given libraries: " + Arrays.toString(arr_s));
        ThrowableUtil.addSuppressedAndClear(illegalArgumentException0, arrayList0);
        throw illegalArgumentException0;
    }

    private static void loadLibrary(ClassLoader classLoader0, String s, boolean z) {
        UnsatisfiedLinkError unsatisfiedLinkError1 = null;
        try {
            NativeLibraryLoader.loadLibraryByHelper(NativeLibraryLoader.tryToLoadClass(classLoader0, NativeLibraryUtil.class), s, z);
            NativeLibraryLoader.logger.debug("Successfully loaded the library {}", s);
        }
        catch(UnsatisfiedLinkError | Exception unsatisfiedLinkError0) {
            try {
                unsatisfiedLinkError1 = unsatisfiedLinkError0;
                NativeLibraryUtil.loadLibrary(s, z);
                NativeLibraryLoader.logger.debug("Successfully loaded the library {}", s);
                return;
            }
            catch(NoSuchMethodError noSuchMethodError0) {
                goto label_13;
            }
            catch(UnsatisfiedLinkError unsatisfiedLinkError2) {
            }
            ThrowableUtil.addSuppressed(unsatisfiedLinkError2, unsatisfiedLinkError1);
            throw unsatisfiedLinkError2;
        }
        catch(NoSuchMethodError noSuchMethodError0) {
        label_13:
            if(unsatisfiedLinkError1 != null) {
                ThrowableUtil.addSuppressed(noSuchMethodError0, unsatisfiedLinkError1);
            }
            NativeLibraryLoader.rethrowWithMoreDetailsIfPossible(s, noSuchMethodError0);
        }
    }

    private static void loadLibraryByHelper(Class class0, String s, boolean z) {
        Object object0 = AccessController.doPrivileged(new PrivilegedAction() {
            @Override
            public Object run() {
                try {
                    Method method0 = class0.getMethod("loadLibrary", String.class, Boolean.TYPE);
                    method0.setAccessible(true);
                    return method0.invoke(null, s, Boolean.valueOf(z));
                }
                catch(Exception object0) {
                    return object0;
                }
            }
        });
        if(object0 instanceof Throwable) {
            Throwable throwable0 = ((Throwable)object0).getCause();
            if(throwable0 instanceof UnsatisfiedLinkError) {
                throw (UnsatisfiedLinkError)throwable0;
            }
            UnsatisfiedLinkError unsatisfiedLinkError0 = new UnsatisfiedLinkError(((Throwable)object0).getMessage());
            unsatisfiedLinkError0.initCause(((Throwable)object0));
            throw unsatisfiedLinkError0;
        }
    }

    @SuppressJava6Requirement(reason = "Guarded by version check")
    private static void rethrowWithMoreDetailsIfPossible(String s, NoSuchMethodError noSuchMethodError0) {
        if(PlatformDependent.javaVersion() < 7) {
            throw noSuchMethodError0;
        }
        throw new LinkageError("Possible multiple incompatible native libraries on the classpath for \'" + s + "\'?", noSuchMethodError0);
    }

    // 去混淆评级： 中等(50)
    private static boolean shouldShadedLibraryIdBePatched(String s) [...] // 潜在的解密器

    private static boolean tryExec(String s) {
        try {
            int v = Runtime.getRuntime().exec(s).waitFor();
            if(v != 0) {
                NativeLibraryLoader.logger.debug("Execution of \'{}\' failed: {}", s, v);
                return false;
            }
            NativeLibraryLoader.logger.debug("Execution of \'{}\' succeed: {}", s, 0);
            return true;
        }
        catch(InterruptedException unused_ex) {
        }
        catch(IOException iOException0) {
            NativeLibraryLoader.logger.info("Execution of \'{}\' failed.", s, iOException0);
            return false;
        }
        catch(SecurityException securityException0) {
            NativeLibraryLoader.logger.error("Execution of \'{}\' failed.", s, securityException0);
            return false;
        }
        Thread.currentThread().interrupt();
        return false;
    }

    public static void tryPatchShadedLibraryIdAndSign(File file0, String s) {
        if(!new File("/Library/Developer/CommandLineTools").exists()) {
            NativeLibraryLoader.logger.debug("Can\'t patch shaded library id as CommandLineTools are not installed. Consider installing CommandLineTools with \'xcode-select --install\'");
            return;
        }
        StringBuilder stringBuilder0 = a.n("install_name_tool -id ", new String(NativeLibraryLoader.generateUniqueId(s.length()), CharsetUtil.UTF_8), " ");
        stringBuilder0.append(file0.getAbsolutePath());
        if(!NativeLibraryLoader.tryExec(stringBuilder0.toString())) {
            return;
        }
        NativeLibraryLoader.tryExec(("codesign -s - " + file0.getAbsolutePath()));
    }

    private static Class tryToLoadClass(ClassLoader classLoader0, Class class0) {
        try {
            return Class.forName(class0.getName(), false, classLoader0);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            if(classLoader0 != null) {
                try {
                    return (Class)AccessController.doPrivileged(new PrivilegedAction() {
                        public Class run() {
                            try {
                                ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE).setAccessible(true);
                                return classLoader0.defineClass(class0.getName(), NativeLibraryLoader.classToByteArray(class0), 0, NativeLibraryLoader.classToByteArray(class0).length);
                            }
                            catch(Exception exception0) {
                                throw new IllegalStateException("Define class failed!", exception0);
                            }
                        }

                        @Override
                        public Object run() {
                            return this.run();
                        }
                    });
                }
                catch(ClassNotFoundException classNotFoundException1) {
                    ThrowableUtil.addSuppressed(classNotFoundException1, classNotFoundException0);
                    throw classNotFoundException1;
                }
                catch(RuntimeException runtimeException0) {
                    ThrowableUtil.addSuppressed(runtimeException0, classNotFoundException0);
                    throw runtimeException0;
                }
                catch(Error error0) {
                    ThrowableUtil.addSuppressed(error0, classNotFoundException0);
                    throw error0;
                }
            }
            throw classNotFoundException0;
        }
    }
}

