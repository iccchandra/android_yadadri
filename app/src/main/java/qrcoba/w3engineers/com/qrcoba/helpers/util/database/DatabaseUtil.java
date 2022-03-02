package qrcoba.w3engineers.com.qrcoba.helpers.util.database;

import android.content.Context;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import qrcoba.w3engineers.com.qrcoba.helpers.model.Code;
import qrcoba.w3engineers.com.qrcoba.helpers.model.CodeDao;

import qrcoba.w3engineers.com.qrcoba.helpers.model.CodeGeneratedDao;

public class DatabaseUtil {
    /**
     * Fields
     */
    private static DatabaseUtil sInstance;
    private CodeDao mCodeDao;
    private CodeGeneratedDao mCodeGeneratedDao;

    private DatabaseUtil() {
        setCodeDao(QrCobaDatabase.on().codeDao());
    }

    /**
     * This method builds an instance
     */
    public static void init(Context context) {
        QrCobaDatabase.init(context);

        if (sInstance == null) {
            sInstance = new DatabaseUtil();
        }
    }

    public static DatabaseUtil on() {
        if (sInstance == null) {
            sInstance = new DatabaseUtil();
        }

        return sInstance;
    }

    private CodeDao getCodeDao() {
        return mCodeDao;
    }

    public CodeGeneratedDao getmCodeGeneratedDao() {
        return mCodeGeneratedDao;
    }

    private void setCodeDao(CodeDao codeDao) {
        mCodeDao = codeDao;
    }

    public Completable insertCode(Code code) {
        return getCodeDao().insert(code);
    }


    public Flowable<List<Code>> getAllCodes() {
        return getCodeDao().getAllFlowableCodes();
    }
    public Flowable<List<Code>> getAllGeneratedCodes() {
        return getCodeDao().getAllGeneratedCodes();
    }
    public int deleteEntity(Code code) {
        return getCodeDao().delete(code);
    }
}
