package eg.edu.edraak.sqlitedemoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notes_db";

    public DatabaseHelper(Context context) {
        super(context);
    }//end constructor

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Note.CREATE_TABLE);
    }//end onCreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Note.TABLE_NAME);
        onCreate(db);
    }//end onUpgrade

    //add new note:
    public long insertNote(String note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Note.COLUMN_NAME, note);
        long id = db.insert(Note.TABLE_NAME, null, values);
        db.close();
        return id;
    };//end insertNote

    //get note:
    public Note getNote(long id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Note.TABLE_NAME,
                new String[] {Note.COLUMN_ID, Note.COLUMN_NAME, Note.COLUMN_TIMESTAMP},
                Note.COLUMN_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }//end if
        Note note = new Note(cursor.getInt(cursor.getColumnIndex(Note.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Note.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(Note.COLUMN_TIMESTAMP)));
        cursor.close();
        return note;
    }//end getNote()

    //get all notes:
    public List<Note> getAllNotes(){
        List<Note> notes = new ArrayList<>();
        //select all query
        String selectQuery = "SELECT * FROM " + Note.TABLE_NAME + " ORDER BY " + Note.COLUMN_TIMESTAMP
                + " DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        //looping to get all notes
        if (cursor.moveToFirst()){
            do {
                Note note = new Note();
                note.setId(cursor.getInt(cursor.getColumnIndex(Note.COLUMN_ID)));
                note.setNote(cursor.getString(cursor.getColumnIndex(Note.COLUMN_NAME)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(Note.COLUMN_TIMESTAMP)));
                notes.add(note);
            } while (cursor.moveToNext()); // end do while
        }//end if
        db.close();
        return notes;
    }//end getAllNotes

    //update note:
    public int updateNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Note.COLUMN_NAME, note.getNote());
        //update database value
        return db.update(Note.TABLE_NAME, values, Note.COLUMN_ID+ " =?", new String[]{String.valueOf(note.getId())});
    };//end updateNote

    //delete note
    public void deleteNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Note.TABLE_NAME, Note.COLUMN_ID+ " =?", new String[]{String.valueOf(note.getId())});
        db.close();
    }//end deleteNote

}//end class
