package com.example.khan.musicapp;

/**
 * Created by Khan on 1/2/2017.
 */
public class Word {

    private String mDefaultTranslatioin;
    private String mMiwokTranslation;
    private int mImageID = hasImageResource;
    private static final int hasImageResource = -1;
    private int mAudioFile;
    public Word(String defaultTranslation, String miwokTranslation, int audioFile){
        mDefaultTranslatioin = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioFile = audioFile;
    }
    public Word(String defaultTranslation, String miwokTranslation,int imageID,int audioFile){
        mDefaultTranslatioin = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageID = imageID;
        mAudioFile = audioFile;
     }
    public String getDefaultTranslation(){
        return mDefaultTranslatioin;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public int getImageID(){       return mImageID;    }
    public boolean hasImage(){      return mImageID != hasImageResource;    }
    public int getAudioFile(){        return mAudioFile;    }
}


