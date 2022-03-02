package ATM1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transfer implements IFileInfor{
    String transferStk, note;
    int money;
    Date createdAt;

    public Transfer() {
    }

    public String getTransferStk() {
        return transferStk;
    }

    public void setTransferStk(String transferStk) {
        this.transferStk = transferStk;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public void display() {
        System.out.println(toString());
    }
    
    public void input(int maxMoney) {
        System.out.println("Nhập thông tin người nhận:");
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Nhập STK người nhận: ");
        transferStk = scan.nextLine();
        
        for(;;) {
            System.out.println("Nhập số tiền: ");
            money = Integer.parseInt(scan.nextLine());
            
            if(money <= maxMoney) {
                break;
            }
            System.err.println("Số tiền vượt quá số tiền trong TK");
        }
        
        System.out.println("Nhập nội dung ghi chú: ");
        note = scan.nextLine();
        
        createdAt = new Date();
    }

    @Override
    public String toString() {
        return "Transfer {" + "transferStk = " + transferStk + ", note = " + note + ", money = " + money + ", createdAt = " + getCreatedAtString() + '}';
    }
    
    public String getCreatedAtString() {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        String str = format.format(createdAt);
        
        return str;
    }
    

    @Override
    public String getFileInfor() {
        return transferStk+","+money+","+note+","+getCreatedAtString();
    }

    @Override
    public void putFileInfor(String data) {
        try {
            String[] param = data.split(",");
            transferStk = param[0];
            
            money = Integer.parseInt(param[1]);
            
            note = param[2];
            
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
            createdAt = format.parse(param[3]);
        } catch (ParseException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
