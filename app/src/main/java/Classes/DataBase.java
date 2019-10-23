package Classes;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import Controller.UserCrud;
import Model.GenericDao;

@Database(entities = {User.class}, version = 1, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class DataBase<T> extends RoomDatabase {

    public abstract UserCrud userDao();

}
