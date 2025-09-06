package com.kakao.emoticon.util;

import android.media.AudioManager;
import android.media.MediaPlayer;
import com.kakao.digitalitem.image.lib.PlayMethod;
import com.kakao.emoticon.KakaoEmoticon;
import java.io.File;

public enum DigitalItemSoundPlay implements PlayMethod {
    static class SoundUtil {
        private static SoundUtil instance;
        private static MediaPlayer singleMediaPlayer;

        public static void access$000(SoundUtil digitalItemSoundPlay$SoundUtil0) {
            digitalItemSoundPlay$SoundUtil0.tryStopSound();
        }

        public static void access$100(SoundUtil digitalItemSoundPlay$SoundUtil0) {
            digitalItemSoundPlay$SoundUtil0.tryPauseSound();
        }

        public static SoundUtil getInstance() {
            if(SoundUtil.instance == null) {
                synchronized(SoundUtil.class) {
                    SoundUtil.instance = new SoundUtil();
                    return SoundUtil.instance;
                }
            }
            return SoundUtil.instance;
        }

        private static MediaPlayer getSingleMediaPlayer() {
            if(SoundUtil.singleMediaPlayer == null) {
                Class class0 = SoundUtil.class;
                synchronized(class0) {
                    if(SoundUtil.singleMediaPlayer == null) {
                        SoundUtil.singleMediaPlayer = new MediaPlayer();
                    }
                }
            }
            return SoundUtil.singleMediaPlayer;
        }

        private static boolean lambda$tryPlaySound$0(MediaPlayer mediaPlayer0, int v, int v1) {
            mediaPlayer0.reset();
            return true;
        }

        public void playShortSound(String s) {
            if(!StringUtils.isBlank(s)) {
                File file0 = new File(s);
                if(file0.exists()) {
                    this.tryPlaySound(file0);
                }
            }
        }

        private void tryPauseSound() {
            MediaPlayer mediaPlayer0 = SoundUtil.getSingleMediaPlayer();
            mediaPlayer0.stop();
            mediaPlayer0.pause();
        }

        private void tryPlaySound(File file0) {
            if(((AudioManager)KakaoEmoticon.getApplication().getSystemService("audio")).getRingerMode() == 2) {
                MediaPlayer mediaPlayer0 = SoundUtil.getSingleMediaPlayer();
                try {
                    if(mediaPlayer0.isPlaying()) {
                        mediaPlayer0.stop();
                        mediaPlayer0.reset();
                    }
                    mediaPlayer0.setDataSource(file0.getAbsolutePath());
                    mediaPlayer0.setOnPreparedListener(new a());  // 初始化器: Ljava/lang/Object;-><init>()V
                    mediaPlayer0.setOnCompletionListener(new b());  // 初始化器: Ljava/lang/Object;-><init>()V
                    mediaPlayer0.setOnErrorListener(new c());  // 初始化器: Ljava/lang/Object;-><init>()V
                    mediaPlayer0.prepare();
                    return;
                }
                catch(Exception exception0) {
                }
                exception0.printStackTrace();
            }
        }

        private void tryStopSound() {
            MediaPlayer mediaPlayer0 = SoundUtil.getSingleMediaPlayer();
            mediaPlayer0.stop();
            mediaPlayer0.reset();
        }
    }

    INSTANCE;

    @Override  // com.kakao.digitalitem.image.lib.PlayMethod
    public boolean canPlay() {
        return true;
    }

    public void pauseEmoticonSound() {
        SoundUtil.access$100(SoundUtil.getInstance());
    }

    @Override  // com.kakao.digitalitem.image.lib.PlayMethod
    public void play(String s) {
        if(StringUtils.isBlank(s)) {
            return;
        }
        this.playEmoticonSound(s);
    }

    public void playEmoticonSound(String s) {
        SoundUtil.getInstance().playShortSound(s);
    }

    @Override  // com.kakao.digitalitem.image.lib.PlayMethod
    public void stop() {
        this.stopEmoticonSound();
    }

    public void stopEmoticonSound() {
        SoundUtil.access$000(SoundUtil.getInstance());
    }
}

