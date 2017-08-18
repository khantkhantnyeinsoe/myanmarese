package data;

/**
 * Created by khant on 4/13/17.
 */

public class Word {
    private String mDefaultTranslation;

    private String mMyanmarTranslation;

    private int mImageResourceId= NO_IMAGE_PROVIDED;

    private int mAudioResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;

    private int colorResource;

    public Word(){

    }
    public Word(String mDefaultTranslation, String mMyanmarTranslation, int mAudioResourceId, int colorResource) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMyanmarTranslation = mMyanmarTranslation;
        this.mAudioResourceId = mAudioResourceId;
        this.colorResource = colorResource;
    }
    public Word(String mDefaultTranslation, String mMyanmarTranslation, int mImageResourceId, int mAudioResourceId, int colorResource) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMyanmarTranslation = mMyanmarTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceId = mAudioResourceId;
        this.colorResource = colorResource;
    }
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMyanmarTranslation() {
        return mMyanmarTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

    public static int getNoImageProvided() {
        return NO_IMAGE_PROVIDED;
    }

    public int getColorResource() {
        return colorResource;
    }

    public void setmDefaultTranslation(String mDefaultTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
    }

    public void setmMyanmarTranslation(String mMyanmarTranslation) {
        this.mMyanmarTranslation = mMyanmarTranslation;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }

    public void setmAudioResourceId(int mAudioResourceId) {
        this.mAudioResourceId = mAudioResourceId;
    }

    public void setColorResource(int colorResource) {
        this.colorResource = colorResource;
    }
}
