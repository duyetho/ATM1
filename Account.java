package ATM1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account implements IFileInfor{
    String fullname, stk, phoneNumber, address;
    int money;
    int phi = 2000;
    int rut;
    List<Receiver> receiverList = new ArrayList<>();
    List<Transfer> transferList = new ArrayList<>();

    public Account() {
    }

    public Account(String fullname, String stk, String phoneNumber, String address, int money,int Phi,int Rut) {
        this.fullname = fullname;
        this.stk = stk;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.money = money;
        this.phi=Phi;
        this.rut=Rut;
    }
    public int getPhi(){
        return phi;
    }
    public void setPhi(int phi){
        this.phi=phi;
    }
    public int getRut(){
        return rut;
    }
    public void setRut(int rut){
        this.rut=rut;
    }
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Receiver> getReceiverList() {
        return receiverList;
    }

    public List<Transfer> getTransferList() {
        return transferList;
    }
    
    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhập Họ & Tên: ");
        fullname = scan.nextLine();
        
        System.out.println("Nhập STK: ");
        stk = scan.nextLine();
        
        System.out.println("Nhập SĐT: ");
        phoneNumber = scan.nextLine();
        
        System.out.println("Nhập địa chỉ: ");
        address = scan.nextLine();
        
        money = 0;
    }
    
    public void addReceiver() {
        Receiver receiver = new Receiver();
        receiver.input();
        
        receiverList.add(receiver);
        
        //cộng tiền vào tài khoản 
        money += receiver.getMoney();
    }
    public void transfer() {
        Transfer transfer = new Transfer();
        transfer.input(money);
        
        transferList.add(transfer);
        
        //trừ tiền trong tài khoản 
        money -= transfer.getMoney();
    }
    
    public void displayReceiverHistory() {
        System.out.println("Lịch sử nhận tiền: ");
        for(Receiver receiver: receiverList){
            receiver.display();
        };
    }
    
    public void displayTransferHistory() {
        System.out.println("Lịch sử chuyển tiền: ");
        for (Transfer transfer: transferList) {
            transfer.display();
        };
    }
    //Rút tiền 
    public void rutTien() {
        System.out.print("Nhập số tiền bạn cần rút: ");
        Scanner sc= new Scanner(System.in);
        rut = sc.nextInt();
        //nếu số tiền rút bé hơn hoặc bằng số tiền còn trong tài khoản + phí thì hợp lệ
        if (rut <= (money - phi)) {
            money = (int) (money - (rut + phi));
            System.out.println("Bạn vừa rút " + rut + "Đ từ tài khoản. Phí là 2000 VND.");
        } else {//ngược lại nếu số tiền rút lớn hơn số tiền có trong tài khoản thì không hợp lệ
            System.out.println("Số tiền muốn rút không hợp lệ!");
            
        }
        
    }

    @Override
    public String toString() {
        return "Account{" + "fullname= " + fullname + ", stk= " + stk + ", phoneNumber= " + phoneNumber + ", address= " + address + ", money= " + money + '}';
    }
    
    public void display() {
        System.out.println(toString());

//        displayReceiverHistory();        
//        displayTransferHistory();
    }

    @Override
    public String getFileInfor() {
        
        return null;
    }

    @Override
    public void putFileInfor(String data) {
        
    }
    
}
