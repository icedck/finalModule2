package view;

import controller.ContactManager;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        int choice = -1;
        Scanner sc = new Scanner(System.in);

        while (choice != 0) {
            System.out.println("---Chuong trinh quan ly danh ba---");
            System.out.println("1. Xem danh ba");
            System.out.println("2. Them moi");
            System.out.println("3. Cap nhat");
            System.out.println("4. Xoa");
            System.out.println("5. Tim kiem");
            System.out.println("6. Ghi vào file");
            System.out.println("7. Đọc từ file");
            System.out.println("0. Thoát");
            System.out.print("Chon chuc nang: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    contactManager.displayContacts();
                    break;
                case 2:
                    contactManager.addContact();
                    break;
                case 3:
                    contactManager.editContact();
                    break;
                case 4:
                    contactManager.deleteContact();
                    break;
                case 5:
                    contactManager.searchContact();
                    break;
                case 6:
                    contactManager.writeToFIle();
                    break;
                case 7:
                    contactManager.readFromFIle();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. chọn lại");
            }
        }
    }
}