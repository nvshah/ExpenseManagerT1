package Database.model;

public class Tracker {
    public static final String TABLE_NAME = "ExpenseRecord";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_PURPOSE = "purpose";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_METHOD = "method";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_IORE = "IorE";                //new add


    private int id;
    private int amount ;
    private String purpose;
    private String date;
    private String description;
    private String method;
    private String timestamp;
    private String IorE;                // new add


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_AMOUNT + " INTEGER,"
                    + COLUMN_PURPOSE + " TEXT,"
                    + COLUMN_DATE + " TEXT,"
                    + COLUMN_DESCRIPTION + " TEXT,"
                    + COLUMN_METHOD + " TEXT,"
                    + COLUMN_IORE + " TEXT,"            //new add
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";
    public Tracker() {
    }

    public Tracker(int id, int amount, String purpose, String date, String description, String method, String IorE, String timestamp) {
        this.id = id;
        this.purpose = purpose;
        this.date = date;
        this.purpose = purpose;
        this.description = description;
        this.method = method;
        this.IorE = IorE;                   //new add
        this.timestamp = timestamp;
    }

    public int gId() {
        return id;
    }
    public int gAmount() {
        return amount;
    }
    public String gPurpose() {
        return purpose;
    }
    public String gDate() {
        return date;
    }
    public String gDescription() {
        return description;
    }
    public String gMethod() {
        return method;
    }
    public String gIorE() {
        return IorE;
    }                       //new add
    public String gTimestamp() {
        return timestamp;
    }

    public void sId(int id) {
        this.id = id;
    }
    public void sAmount(int amount) {
        this.amount = amount;
    }
    public void sPurpose(String purpose) {
        this.purpose = purpose;
    }
    public void sDate(String date) {
        this.date = date;
    }
    public void sDescription(String description) {
        this.description = description;
    }
    public void sMethod(String method) {
        this.method = method;
    }
    public void sIorE(String IorE) {
        this.IorE = IorE;
    }                       //new add
    public void sTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


}
