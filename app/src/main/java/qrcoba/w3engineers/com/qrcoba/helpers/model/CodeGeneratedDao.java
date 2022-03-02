package qrcoba.w3engineers.com.qrcoba.helpers.model;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import qrcoba.w3engineers.com.qrcoba.helpers.constant.TableNames;
import qrcoba.w3engineers.com.qrcoba.helpers.util.database.BaseDao;

@Dao

public interface CodeGeneratedDao extends BaseDao<CodeGenerated> {
    @Query("SELECT * FROM " + TableNames.CODES_GENERATED)
    Flowable<List<CodeGenerated>> getAllFlowableCodes();

}
