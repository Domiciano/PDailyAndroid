package co.edu.icesi.pdailyandroid.localdatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import co.edu.icesi.pdailyandroid.model.viewmodel.NotificationFollowUp;

public class DataHandler extends SQLiteOpenHelper {

    private static final String NAME = "PDaily";
    private static final int VERSION = 1;
    private static final String FOOD_TABLE = "food";
    private static final String LEVO_TABLE = "levo";

    private static DataHandler instance = null;

    public static DataHandler getInstance(Context context) {
        if (instance == null) {
            instance = new DataHandler(context);
        }
        return instance;
    }

    private DataHandler(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createNotificationTable(db, FOOD_TABLE);
        createNotificationTable(db, LEVO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dropNotificationTable(db, FOOD_TABLE);
        dropNotificationTable(db, LEVO_TABLE);
    }

    private void createNotificationTable(SQLiteDatabase db, String name) {
        String command = String.format("CREATE TABLE %s(id TEXT PRIMARY KEY, name TEXT, date TEXT)", name);
        db.execSQL(command);
    }

    private void dropNotificationTable(SQLiteDatabase db, String name) {
        String command = String.format("DROP TABLE IF EXISTS %s", name);
        db.execSQL(command);
    }

    private void insertNotification(String table, String id, String name, String date) {
        SQLiteDatabase db = getWritableDatabase();
        String format = "INSERT INTO %s (id, name, date) VALUES ('%s', '%s', '%s')";
        db.execSQL(String.format(format, table, id, name, date));
        db.close();
    }

    private void updateNotification(String table, String id, String name, String date) {
        SQLiteDatabase db = getWritableDatabase();
        String format = "UPDATE %s SET name = '%s', date = '%s' WHERE id = '%s'";
        db.execSQL(String.format(format, table, id, name, date));
        db.close();
    }

    private boolean notificationExists(String table, String id) {
        SQLiteDatabase db = getWritableDatabase();
        String format = "SELECT * FROM %s WHERE id = '%s'";
        Cursor cursor = db.rawQuery(String.format(format, table, id), null);
        boolean exists = cursor.getCount() >= 1;
        db.close();
        cursor.close();
        return exists;
    }

    private void deleteNotification(String table, String id) {
        SQLiteDatabase db = getWritableDatabase();
        String format = "DELETE FROM %s WHERE id='%s'";
        db.execSQL(String.format(format, table, id));
        db.close();
    }

    public ArrayList<NotificationFollowUp> getAllNotifications(String table) {
        ArrayList<NotificationFollowUp> out = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + table, null);
        if (cursor.moveToFirst()) {
            do {
                out.add(new NotificationFollowUp(
                        cursor.getString(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("date"))
                ));
            } while (cursor.moveToNext());
        }
        db.close();
        cursor.close();
        return out;
    }

    //---CRUD FOOD NOTIFICATIONS---//

    public void insertFoodNotification(NotificationFollowUp notification) {
        insertNotification(FOOD_TABLE, notification.getId(), notification.getName(), notification.getDate());
    }

    public void insertOrUpdateFoodNotification(NotificationFollowUp notification) {
        if (notificationExists(FOOD_TABLE, notification.getId())) {
            updateNotification(FOOD_TABLE, notification.getId(), notification.getName(), notification.getDate());
        } else {
            insertNotification(FOOD_TABLE, notification.getId(), notification.getName(), notification.getDate());
        }
    }

    public ArrayList<NotificationFollowUp> getAllFoodNotifications() {
        return getAllNotifications(FOOD_TABLE);
    }

    //---CRUD LEVO NOTIFICATIONS---//

    public void insertOrUpdateLevoNotification(NotificationFollowUp notification) {
        if (notificationExists(LEVO_TABLE, notification.getId())) {
            updateNotification(LEVO_TABLE, notification.getId(), notification.getName(), notification.getDate());
        } else {
            insertNotification(LEVO_TABLE, notification.getId(), notification.getName(), notification.getDate());
        }
    }

    public ArrayList<NotificationFollowUp> getAllLevoNotifications() {
        return getAllNotifications(LEVO_TABLE);
    }
}
