package com.ws.StructuralDesignPatterns.AdapterPattern;

/**
 * 适配器
 */
public class TestAdapter {

    public static void main(String[] args) {

        MP3Player mp3Player = new MP3Player();
        //通过适配器封装实现类 使该类和目标接口适配
        MediaPlayer mediaPlayer = new MP3PlayerAdapter(mp3Player);

        mediaPlayer.play("MP3", "勇气.mp3");

    }

}
