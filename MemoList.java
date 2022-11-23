import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoList {
    List<Memo> arr = new ArrayList<>();
    public MemoList() {
    }

    @Override
    public String toString() {
        return this.arr.toString();
    }


    public void memoAdd(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");
        String formatedNow = now.format(formatter);
        Scanner Input = new Scanner(System.in);
        System.out.println("이름을 입력해 주세요 ");
        String named = Input.nextLine();
        System.out.println("비밀번호를 입력해 주세요 ");
        String pwd = Input.nextLine();
        System.out.println("메모를 입력해 주세요 ");
        String txt = Input.nextLine();

        //삭제할때 index가 땡겨지므로 추가할땐 사이즈가 index
        int size = arr.size();
        this.arr.add(new Memo(named,pwd,txt,size));

    }


    public void memoEdit() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");
        String formatedNow = now.format(formatter);

        if (arr.size() == 0) System.out.println("수정 가능한 메모가 없습니다.");
        else {
            System.out.println("수정할 index 번호를 입력해주세요");                                      //해당되는 글 1건을 수정하는 메소드가 있다.
            Scanner indexInput = new Scanner(System.in);
            int index = indexInput.nextInt();

            if (index < this.arr.size() && this.arr.get(index).getIndex() == index) {
                System.out.println("index (" + index + ") 의 비밀번호를 입력하세요");
                Scanner passwordInput = new Scanner(System.in);
                String password = passwordInput.nextLine();

                if (password.equals(this.arr.get(index).getPassword())) {
                    System.out.println("메모내용 : " + this.idxGetText(index));
                    System.out.println("수정할 내용을 입력하세요.");
                    Scanner editMemoInput = new Scanner(System.in);
                    String editedMemo = editMemoInput.nextLine();

                    this.arr.get(index).setText(editedMemo);
                    this.arr.get(index).setDate(formatedNow);
                } else if (password != this.arr.get(index).getPassword()) {
                    System.out.println("비밀번호가 일치하지 않습니다.");
                }
            } else {
                System.out.println("수정할 메모가 존재하지 않습니다.");
            }
        }

    }

    public void memoDel() {

        if (arr.size()==0) System.out.println("삭제 가능한 메모가 없습니다.");
        else {
            System.out.println("삭제할 index 번호를 입력해주세요");                                      //해당되는 글 1건을 삭제하는 메소드가 있다.
            Scanner indexInput = new Scanner(System.in);
            int index = indexInput.nextInt();

            if (index < this.arr.size() && this.arr.get(index).getIndex() == index) {
                System.out.println("index (" + index + ") 의 비밀번호를 입력하세요");
                Scanner passwordInput = new Scanner(System.in);
                String password = passwordInput.nextLine();

                if (password.equals(this.arr.get(index).getPassword())) {
                    System.out.println("삭제한 메모내용 : " + this.idxGetText(index));
                    this.arr.remove(index);
                    memoDel_IndexSort(index);
                } else if (password != this.arr.get(index).getPassword()) {
                    System.out.println("비밀번호가 일치하지 않습니다.");

                }
            }

            else  {
                System.out.println("삭제할 메모가 존재하지 않습니다.");
            }
        }
    }


    public void memoDel_IndexSort(int index){


        for(int i=index;i<arr.size();i++){
            arr.get(i).one_minus_Index();
        }

    }


    public String idxGetText(int index) {            //글의 수정 또는 삭제 시 글 번호를 넘겨 받고 리스트에서 글 번호에 해당하는  글 1건을 얻어와 리턴 시키는 메소드가 있다.
        return this.arr.get(index).text;
    }

    public void getList() {                           //작성 최신 순으로 메모를 출력한다.
        if (arr.size()==0) System.out.println("표시 가능한 메모가 없습니다.");
        else {
            for (int i = arr.size() - 1; i >= 0; i--) {
                System.out.println(arr.get(i) + "\n");
            }
        }
    }
}
