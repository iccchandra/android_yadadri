package qrcoba.w3engineers.com.qrcoba.helpers.model;

import android.os.Parcel;

import androidx.room.Entity;
import androidx.room.Ignore;

import qrcoba.w3engineers.com.qrcoba.helpers.constant.TableNames;
import qrcoba.w3engineers.com.qrcoba.helpers.util.database.BaseEntity;

@Entity(tableName = TableNames.CODES_GENERATED)
public class CodeGenerated extends BaseEntity {

    /**
     * Constants
     */
    public static final int QR_CODE = 1;
    public static final int BAR_CODE = 2;
    public static final Creator<CodeGenerated> CREATOR = new Creator<CodeGenerated>() {
        @Override
        public CodeGenerated createFromParcel(Parcel source) {
            return new CodeGenerated(source);
        }

        @Override
        public CodeGenerated[] newArray(int size) {
            return new CodeGenerated[size];
        }
    };

    /**
     * Fields
     */
    private String mContent;
    private int mType;
    private String mCodeImagePath;
    private long mTimeStamp;

    public CodeGenerated() {
    }

    @Ignore
    public CodeGenerated(String content, int type) {
        mContent = content;
        mType = type;
    }

    @Ignore
    public CodeGenerated(String content, int type, long timeStamp) {
        mContent = content;
        mType = type;
        mTimeStamp = timeStamp;
    }

    @Ignore
    public CodeGenerated(String content, int type, String codeImagePath, long timeStamp) {
        mContent = content;
        mType = type;
        mCodeImagePath = codeImagePath;
        mTimeStamp = timeStamp;
    }

    @Ignore
    protected CodeGenerated(Parcel in) {
        this.mContent = in.readString();
        this.mType = in.readInt();
        this.mTimeStamp = in.readLong();
        this.mCodeImagePath = in.readString();
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }

    public String getCodeImagePath() {
        return mCodeImagePath;
    }

    public void setCodeImagePath(String codeImagePath) {
        mCodeImagePath = codeImagePath;
    }

    public long getTimeStamp() {
        return mTimeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        mTimeStamp = timeStamp;
    }

    /**
     * Below codes are written in order to make the object parcelable
     */
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mContent);
        dest.writeInt(this.mType);
        dest.writeLong(this.mTimeStamp);
        dest.writeString(this.mCodeImagePath);
    }
}
