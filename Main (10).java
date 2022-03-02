package ATM1;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Account account = null;
    
    public static void main(String[] args) {
        login();
        System.out.println("Bước tiếp theo!!!");
        int choose;
        
        do {
            showMenu();
            choose = Integer.parseInt(scan.nextLine());
            
            switch(choose) {
                case 1:
                    account = new Account();
                    account.input();
                    break;
                case 2:
                    if(account != null) {
                        account.addReceiver();
                        
                        account.display();
                    } else {
                        System.err.println("TK không tồn tại");
                    }
                    break;
                case 3:
                    if(account != null) {
                        account.transfer();
                        account.display();
                    } else {
                        System.err.println("TK không tồn tại");
                    }
                    break;
                case 4:
                    if (account!= null){
                        account.rutTien();
                        account.display();
                    }
                case 5:
                    if(account != null) {
                        account.displayReceiverHistory();
                    } else {
                        System.err.println("TK không tồn tại!!");
                    }
                    break;
                case 6:
                    
                    if(account != null) {
                        account.displayTransferHistory();
                    } else {
                        System.err.println("TK không tồn tại!!");
                    }
                    break;
                case 7:
                    System.out.println("Thoát!!!");
                    break;
                default:
                    System.out.println("Nhập sai!!!");
                    break;
            }
        } while(choose != 6);
    }
     
    static void showMenu() {
        System.out.println("****************========****************");
        System.out.println("|   1. Khởi tạo TK:                     |");
        System.out.println("|   2. Nạp tiền:                        |");
        System.out.println("|   3. Chuyển tiền:                     |");
        System.out.println("|   4. Rút tiền:                        |");
        System.out.println("|   5. Xem lịch sử nạp tiền:            |");
        System.out.println("|   6. Xem lịch sử chuyển tiền:--       |");
        System.out.println("|   7. Thoát                            |");
        System.out.println("|                                       |");
        System.out.println("****************=======*****************");
      
    }
    
    static void login() {
        System.out.println("============ WELCOME ============");
        System.out.println("Nhập tên tài khoản : ");
        String username = scan.nextLine();
        
        System.out.println("Nhập mật khẩu: ");
        String password = scan.nextLine();
        
        if(username.equalsIgnoreCase("Ho Thi Duyet") && password.equals("21092002")){
            System.out.println("Đăng nhập thành công!!!");
        } else {
            System.err.println("Đăng nhập thất bại!!!");
            //de quy.
            login();
        }
    }
}
