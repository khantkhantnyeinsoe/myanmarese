package data;

/**
 * Created by khant on 4/13/17.
 */

public class Category {
    String categoryName;
    int colorResource;
    private int mImageResourceId= NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Category(String categoryName, int colorResource) {
        this.categoryName = categoryName;
        this.colorResource = colorResource;
    }
    public Category(int mImageResourceId,String categoryName, int colorResource) {
        this.categoryName = categoryName;
        this.colorResource = colorResource;
        this.mImageResourceId = mImageResourceId;
    }
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }
    public static int getNoImageProvided() {
        return NO_IMAGE_PROVIDED;
    }
    public String getCategoryName() {
        return categoryName;
    }

    public int getColorResource() {
        return colorResource;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setColorResource(int colorResource) {
        this.colorResource = colorResource;
    }
    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }
}
