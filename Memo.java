import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memo {
    private  int index;
    private String name;
     private String password;
    String text;
    String date;
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");
    String formatedNow = now.format(formatter);

    public Memo( String name,String password, String text,int index) {
        this.name = name;
        this.password = password;
        this.text = text;
        this.date = this.formatedNow;
        this.index = index;
    }


    public String getPassword() {
        return password;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void one_minus_Index(){this.index = this.index-1;}

    @Override
    public String toString() {
        return  "글번호 : " + index +
                "\n작성자 이름 : " + name +
                "\n작성일 : " + date +
                "\ntext : " + text
                ;
    }
}
