package Notes;

public class Notes {
    private static String title;               //заголовок заметки
    private static String content;             //описание заметки
    private static String date;        //дата и время создания заметки
    private static String place;             //место

    public Notes() {
    }

    public Notes(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static String getDate() {
        return date;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    public static String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}