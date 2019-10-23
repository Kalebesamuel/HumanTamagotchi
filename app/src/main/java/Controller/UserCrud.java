package Controller;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import Classes.User;
import Model.GenericDao;

@Dao
public abstract class UserCrud implements GenericDao<User>{

    @Query("SELECT * FROM USER")
    public abstract List<User> getAll();


}
