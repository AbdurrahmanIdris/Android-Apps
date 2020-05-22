package eg.edu.edraak.sqlitedemoapp;

public class Note {
    public static final String TABLE_NAME="notes";
    public static final String COLUMN_NAME = "note";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String note;
    private String timestamp;

    //create SQL: Create Table
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"+")";
    public Note(){

    }//end Note
    public Note(int id, String note, String timestamp){
        this.id = id;
        this.note = note;
        this.timestamp = timestamp;
    }//end Note

    public void setId(int id) {
        this.id = id;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public String getTimestamp() {
        return timestamp;
    }
}//end class
