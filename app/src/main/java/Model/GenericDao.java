package Model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import java.util.List;

public interface GenericDao <T>{

@Insert
 void insert(T element);

@Insert
 void insertAll(List<T> elements);

@Update
 int update(T elements);

@Delete
 int delete(T element);

}
