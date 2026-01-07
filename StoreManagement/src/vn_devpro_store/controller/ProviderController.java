package vn_devpro_store.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn_devpro_store.database.ProviderDB;
import vn_devpro_store.model.Provider;

public class ProviderController {
    static Scanner sc = new Scanner(System.in);
    public static void Menu(){
        do {
            System.out.println("\n\t\tQUAN LY DANH SACH NHA CUNG CAP");
            System.out.println("Chon mot chuc nang quan ly");
            System.out.println("\t1.Xem danh sach nha cung cap");
            System.out.println("\t2.Them nha cung cap moi");
            System.out.println("\t3.Sua thong tin nha cung cap");
            System.out.println("\t4.Xoa thong tin nha cung cap");
            System.out.println("\t5.Sap xep danh sach");
            System.out.println("\t0.Quay lai");

            System.out.printf("Lua chon cua ban: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    display();
                    break;
                case 2:
                    create();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    sort();
                    break;
                case 0:
                    
                    return;
                
                default:
                    System.out.println("Lua chon khong hop le, xin chon lai");
                    break;
            }

        } while (true);
    }
    private static void sort() {
        Collections.sort(ProviderDB.getProviders(), new Comparator<Provider>() {
            @Override
            public int compare(Provider o1, Provider o2) {
                // TODO Auto-generated method stub
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }
    private static void remove() {
       System.out.println("\n\t\tXOA THONG TIN NHA CUNG CAP");
        System.out.printf("\tNhap ma nha cung cap: ");
        String code = sc.nextLine();
        int index = ProviderDB.findByCode(code) ;
        if(index == -1){
            System.out.println("\tNha cung cap chua ton tai");
            return;
        }
        ProviderDB.getProviders().remove(index);
        System.out.println("\tXoa nha cung cap thanh cong");
    }
    private static void update() {
        System.out.println("\n\t\tSUA THONG TIN NHA CUNG CAP");
        System.out.printf("\tNhap ma nha cung cap: ");
        String code = sc.nextLine();
        int index = ProviderDB.findByCode(code) ;
        if(index == -1){
            System.out.println("\tNha cung cap chua ton tai");
            return;
        }
        ProviderDB.getProviders().get(index).edit();
   }
    private static void create() {
        System.out.println("\n\t\tTHEM MOI NHA CUNG CAP");
        System.out.printf("\tNhap ten nha cung cap: ");
        String name = sc.nextLine();
        if(name != null && !name.isBlank()){
            //Khoi tao 1 doi tuong provider
            Provider provider = new Provider();
            provider.setId(ProviderDB.getAutoId());
            provider.setCode("NCC_" + (100 + provider.getId()));
            provider.setName(name);
            ProviderDB.getProviders().add(provider);

            ProviderDB.setAutoId(ProviderDB.getAutoId() + 1);
            System.out.println("\tThem moi nha cung cap thanh cong");
        }
        else{
            System.out.println("\tTen nha cung cap khong duoc de trong");
        }
    }
    private static void display() {
        System.out.println("\n\t\tDANH SACH NHA CUNG CAP");
        System.out.printf("%-5s %-12s %-30s%n",
            "ID","Code","Name"
        );
        for(Provider provider : ProviderDB.getProviders()){
            provider.display();
        }
    }
}
