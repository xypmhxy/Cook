package com.ren.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.ren.cook.database.StringConverter;
import java.util.List;

import com.ren.cook.bean.FoodDataResult;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "FOOD_DATA_RESULT".
*/
public class FoodDataResultDao extends AbstractDao<FoodDataResult, Long> {

    public static final String TABLENAME = "FOOD_DATA_RESULT";

    /**
     * Properties of entity FoodDataResult.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Classid = new Property(0, long.class, "classid", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property List = new Property(2, String.class, "list", false, "LIST");
        public final static Property Parentid = new Property(3, String.class, "parentid", false, "PARENTID");
    };

    private final StringConverter listConverter = new StringConverter();

    public FoodDataResultDao(DaoConfig config) {
        super(config);
    }
    
    public FoodDataResultDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"FOOD_DATA_RESULT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: classid
                "\"NAME\" TEXT," + // 1: name
                "\"LIST\" TEXT," + // 2: list
                "\"PARENTID\" TEXT);"); // 3: parentid
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"FOOD_DATA_RESULT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, FoodDataResult entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getClassid());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        List list = entity.getList();
        if (list != null) {
            stmt.bindString(3, listConverter.convertToDatabaseValue(list));
        }
 
        String parentid = entity.getParentid();
        if (parentid != null) {
            stmt.bindString(4, parentid);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, FoodDataResult entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getClassid());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        List list = entity.getList();
        if (list != null) {
            stmt.bindString(3, listConverter.convertToDatabaseValue(list));
        }
 
        String parentid = entity.getParentid();
        if (parentid != null) {
            stmt.bindString(4, parentid);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public FoodDataResult readEntity(Cursor cursor, int offset) {
        FoodDataResult entity = new FoodDataResult( //
            cursor.getLong(offset + 0), // classid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : listConverter.convertToEntityProperty(cursor.getString(offset + 2)), // list
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // parentid
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, FoodDataResult entity, int offset) {
        entity.setClassid(cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setList(cursor.isNull(offset + 2) ? null : listConverter.convertToEntityProperty(cursor.getString(offset + 2)));
        entity.setParentid(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(FoodDataResult entity, long rowId) {
        entity.setClassid(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(FoodDataResult entity) {
        if(entity != null) {
            return entity.getClassid();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}