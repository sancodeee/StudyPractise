package com.ws.StructuralDesignPatterns.AdapterPattern;

/**
 * 被适配对象类--MP3播放器
 */
public class MP3Player {

    public void playMP3(String fileName){
        System.out.println("播放MP3类型的文件：" + fileName);
    }

}
