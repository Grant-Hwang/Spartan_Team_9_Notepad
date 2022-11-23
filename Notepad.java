import java.util.Scanner;

public class Notepad {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        int choice;
        boolean flag = false;
        MemoList memolist = new MemoList();

        System.out.println("=====================");
        System.out.println("ㅐ***9조대***메모장***ㅐ");
        System.out.println("=====================");

        while (true) {
            System.out.println("\n1. 입력 2. 목록 보기 3. 수정 4. 삭제 5. 종료");
            System.out.println("숫자를 입력해주세요.");

            choice = sc.nextInt();
            sc.nextLine(); // 없으면 아래 sc.nextLine() 입력이 이상하게 된다.

            switch (choice) {
                case 1:
                    memolist.memoAdd();
                    break;
                case 2:
                    memolist.getList();
                    break;
                case 3:
                    memolist.memoEdit();;
                    break;
                case 4:
                    memolist.memoDel();
                    break;
                case 5:
                    System.out.println("사용 종료");
                    flag = true;
                    break;
                default:
                    System.out.println("\n================================");
                    System.out.println("****1~5 사이 숫자를 입력해주세요****");
                    System.out.println("================================\n");
                    break;
            }
            if (flag == true) break;
        }
    }
}