package com.ws.StructuralDesignPatterns.AdapterPattern;

/**
 * 适配器类：适配媒体播放器接口和Mp3播放器类
 */
public class MP3PlayerAdapter implements MediaPlayer {

    private MP3Player mp3Player;

    public MP3PlayerAdapter(MP3Player mp3Player) {
        this.mp3Player = mp3Player;
    }

    @Override
    public void play(String audioType, String fileName) {
        //equalsIgnoreCase()该方法比较两个字符串是否相等，而不考虑他们的大小写
        if (audioType.equalsIgnoreCase("MP3")) {
            mp3Player.playMP3(fileName);
        }
    }
}
