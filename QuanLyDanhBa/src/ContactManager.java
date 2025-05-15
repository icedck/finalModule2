import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager implements ReadWriteFile<Contact>{
    private List<Contact> contacts = new ArrayList<>();
    private static final String CONTACTS_FILE = "data/contacts.csv";
    private static File file = new File(CONTACTS_FILE);
    private static Scanner scanner = new Scanner(System.in);

    public ContactManager() {
    }

    public  void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("==Danh ba trong==");
            return;
        }
        System.out.println("==Danh ba==");
        int count = 0;
        for (Contact c : contacts) {
            System.out.println(c.toString());
            count++;
            if (count == 5) {
                System.out.println("Nhan enter de xem tiep");
                scanner.nextLine();
                count = 0;
            }
        }
        System.out.println("==Het danh sach==");
    }

    public void addContact() {
        String phone, group, name, gender, address, birthday, email;
        while (true) {
            System.out.println("Nhap so dien thoai (10 chu so): ");
            phone = scanner.nextLine();
            if (phone.isEmpty()){
                System.out.println("So dien thoai khong duoc de trong");
            }else if (!phone.matches("^\\d{10}$")){
                System.out.println("So dien thoai phai du 10 cu so");
            }else {
                break;
            }
        }
        while (true) {
            System.out.println("Nhap nhom: ");
            group = scanner.nextLine();
            if (group.isEmpty()){
                System.out.println("Nhom khong duoc de trong");
            }else {
                break;
            }
        }
        while (true) {
            System.out.println("Nhap ho ten: ");
            name = scanner.nextLine();
            if (name.isEmpty()){
                System.out.println("Nhom khong duoc de trong");
            }else {
                break;
            }
        }
        while (true) {
            System.out.println("Nhap gioi tinh: ");
            gender = scanner.nextLine();
            if (gender.isEmpty()){
                System.out.println("Gioi tinh khong duoc de trong");
            }else if (!gender.equals("Nam") && !gender.equals("Nu")){
                System.out.println("Gioi tinh phai dung dinh dang (Nam/Nu)");
            }else {
                break;
            }
        }
        while (true) {
            System.out.println("Nhap dia chi: ");
            address = scanner.nextLine();
            if (address.isEmpty()){
                System.out.println("Dia chi khong duoc de trong");
            }else {
                break;
            }
        }
        while (true) {
            System.out.println("Nhap ngay sinh: ");
            birthday = scanner.nextLine();
            if (birthday.isEmpty()){
                System.out.println("Ngay sinh khong duoc de trong");
            }else if (!birthday.matches("^\\d{2}/\\d{2}/\\d{4}$")){
                System.out.println("Ngay sinh phai dung dinh dang (dd/mm/yyyy)");
            }else {
                break;
            }
        }
        while (true) {
            System.out.println("Nhap email: ");
            email = scanner.nextLine();
            if (email.isEmpty()){
                System.out.println("Email khong duoc de trong");
            }else if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")){
                System.out.println("Email phai dung dinh dang (vd: ten@gmail.com)");
            }else {
                break;
            }
        }
        Contact contact = new Contact(phone, group, name, gender, address, birthday, email);
        contacts.add(contact);
        System.out.println("Them danh ba thanh cong");
    }

    public String inputRequired(String label){
        while (true){
            System.out.println(label+": ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()){
                System.out.println(label+" không được để trống");
            }
            else {
                return input;
            }
        }
    }

    public void editContact() {
        while (true){
            String  group, name, gender, address, birthday, email;
            System.out.println("Nhap so dien thoai can sua: ");
            String phone = scanner.nextLine().trim();
            if (phone.isEmpty()){
                System.out.println("Huy cap nhat quay ve menu");
                break;
            }
            Contact contactUpDate = null;
            for (Contact c : contacts) {
                if (c.getPhone().equals(phone)){
                    contactUpDate = c;
                }
            }
            if (contactUpDate == null) {
                System.out.println("Khong tim thay danh ba");
                continue;
            }
            group = inputRequired("Nhom");
            name = inputRequired("Ho ten");
            while(true){
                System.out.println("Nhap gioi tinh: ");
                gender = scanner.nextLine();
                if(gender.isEmpty()){
                    System.out.println("Gioi tinh khong duoc de trong");
                } else if (!gender.equals("Nam")&&!gender.equals("Nu")) {
                    System.out.println("Gioi tinh phai dung dinh dang (Nam/Nu)");
                }else {
                    break;
                }
            }

            address=inputRequired("Địa chỉ");
            while (true) {
                System.out.println("Nhap ngay sinh: ");
                birthday = scanner.nextLine();
                if (birthday.isEmpty()){
                    System.out.println("Ngay sinh khong duoc de trong");
                }else if (!birthday.matches("^\\d{2}/\\d{2}/\\d{4}$")){
                    System.out.println("Ngay sinh phai dung dinh dang (dd/mm/yyyy)");
                }else {
                    break;
                }
            }
            while (true) {
                System.out.println("Nhap email: ");
                email = scanner.nextLine();
                if (email.isEmpty()){
                    System.out.println("Email khong duoc de trong");
                }else if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")){
                    System.out.println("Email phai dung dinh dang (vd: ten@gmail.com)");
                }else {
                    break;
                }
            }
            contactUpDate.setGroup(group);
            contactUpDate.setName(name);
            contactUpDate.setGender(gender);
            contactUpDate.setAddress(address);
            contactUpDate.setBirthday(birthday);
            contactUpDate.setEmail(email);
            return;
        }
    }

    public void deleteContact(){
        while(true){
            System.out.println("Nhap so dien thoai can xoa");
            String phone =scanner.nextLine().trim();

            if(phone.isEmpty()){
                System.out.println("Huy quay ve menu");
                break;
            }
            Contact contactToDelete=null;
            for (Contact c: contacts){
                if(c.getPhone().equals(phone)){
                    contactToDelete=c;
                    break;
                }
            }
            if(contactToDelete==null){
                System.out.println("Khong tim thay danh ba can xoa");
                continue;
            }
            System.out.println("Tim thay "+ contactToDelete);
            System.out.println("ban co chac muon xoa (Y/N)");
            String confirm = scanner.nextLine().trim();
            if ("Y".equals(confirm)){
                contacts.remove(contactToDelete);
                System.out.println("Xoa thanh cong!");
            }else {
                System.out.println("Khong xoa! Quay ve menu!");
            }
            return;
        }
    }

    public void searchContact(){
        System.out.println("Nhap tu khoa can tim (SDT hoac ten):");
        String keyword = scanner.nextLine().trim();


        List<Contact> results = new ArrayList<>();
        for (Contact c:contacts){
            if(c.getPhone().contains(keyword)||c.getName().contains(keyword)){
                results.add(c);
            }
        }
        if (results==null){
            System.out.println("Khong tim thay danh ba");
        }else {
            System.out.println("Danh sach tim kiem");
            for (Contact c:results){
                System.out.println(c);
            }
        }
    }

    @Override
    public void writeToFIle() {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contacts);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Da luu vao file");
    }

    @Override
    public List<Contact> readFromFIle() {
        contacts.clear();
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            contacts= (List<Contact>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println("Da doc file");
        return contacts;
    }
}
