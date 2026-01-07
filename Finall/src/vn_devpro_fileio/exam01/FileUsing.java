package vn_devpro_fileio.exam01;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class FileUsing {
    // //Tạo thư mục trong ổ đĩa
    // public static void createDirectory(String dirPath) {
    //     File directory = new File(dirPath);
    //     if (!directory.exists()) {
    //         directory.mkdirs();
    //         System.out.println("Thu muc da duoc tao thanh cong");
    //     } else {
    //         System.out.println("Thu muc da ton tai");
    //     }

    // }
    // //Tạo file trong thư mục
    // public static void createFile(String filePath) {
    //     File file = new File(filePath);
    //     try {
    //         if (file.createNewFile()) {
    //             System.out.println("File da duoc tao thanh cong");
    //         } else {
    //             System.out.println("File da ton tai");
    //         }
    //     } catch (Exception e) {
    //         System.out.println("Loi khi tao file: " + e.getMessage());
    //     }
    // }
    // public static void listFileAndFolder(String dirPath) {
    //     File directory = new File(dirPath);
    //     String [] list = directory.list();
    //     System.out.println("Cac file va thu muc trong " + dirPath + ":");
    //     for(String name : list) {
    //         System.out.println("\t" + name);
    //     }
    // }


    //Ghi ký tự ra fle
    public static void ghiKyTu(String path){
        File file = new File (path);
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(file);
            for(char c = 'A'; c <= 'Z'; c++) {
                fout.write(c);
            }
            System.out.println("Ghi du lieu thanh cong");
        } catch (FileNotFoundException e) {
            System.out.println("Loi khi ghi du lieu: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Loi khac: " + e.getMessage());
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (Exception e) {
                System.out.println("Loi khi dong file: " + e.getMessage());
            }
        }
    }
    //ĐỌc ký tự ra file
    public static void docKyTu(String path){
        File file = new File (path);
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
            int c;
            while ((c = fin.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Loi khi doc du lieu: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Loi khac: " + e.getMessage());
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (Exception e) {
                System.out.println("Loi khi dong file: " + e.getMessage());
            }
        }
    }
    //Ghi dữ liệu nhị phân
    public static void ghiDuLieuNhiPhan(String path) {
        File file = new File(path);
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(file);
            for(int i=0;i<12;i++) {
                fout.write(i);
            }
            System.out.println("\nGhi du lieu thanh cong");
        } catch (FileNotFoundException e) {
            System.out.println("Loi khi ghi du lieu: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Loi khac: " + e.getMessage());
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (Exception e) {
                System.out.println("Loi khi dong file: " + e.getMessage());
            }
        }
    }
    //Doc du lieu nhi phan
    public static void docDuLieuNhiPhan(String path) {
        File file = new File(path);
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
            int b;
            while ((b = fin.read()) != -1) {
                System.out.print(b + " ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Loi khi doc du lieu: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Loi khac: " + e.getMessage());
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (Exception e) {
                System.out.println("Loi khi dong file: " + e.getMessage());
            }
        }
    }
    //Ghi dữ liệu đối tượng
    public static void ghiDuLieuDoiTuong(String path) {
        File file = new File(path);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            Student student = new Student("John Doe", 20);
            oos.writeObject(student);
            System.out.println("\nGhi du lieu thanh cong");
        } catch (FileNotFoundException e) {
            System.out.println("Loi khi ghi du lieu: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Loi khac: " + e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (Exception e) {
                System.out.println("Loi khi dong file: " + e.getMessage());
            }
        }
    }
    //Doc du lieu doi tuong
    public static Student docDuLieuDoiTuong(String path) {
        File file = new File(path);
        ObjectInputStream ois = null;
        Student student = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            student = (Student) ois.readObject();
            System.out.println("Doc du lieu thanh cong");
        } catch (FileNotFoundException e) {
            System.out.println("Loi khi doc du lieu: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Loi khac: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Loi khi phan tich du lieu: " + e.getMessage());
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (Exception e) {
                System.out.println("Loi khi dong file: " + e.getMessage());
            }
        }
        return student;
    }

    public static void main(String[] args) {
       ghiDuLieuDoiTuong("E:/JAVA_DEVPRO/Finall/src/vn_devpro_fileio/exam01/output.dat");
        System.out.println(docDuLieuDoiTuong("E:/JAVA_DEVPRO/Finall/src/vn_devpro_fileio/exam01/output.dat").toString());
        // ghiKyTu("E:/JAVA_DEVPRO/Finall/src/vn_devpro_fileio/exam01/output.txt");
        // docKyTu("E:/JAVA_DEVPRO/Finall/src/vn_devpro_fileio/exam01/output.txt");
        // ghiDuLieuNhiPhan("E:/JAVA_DEVPRO/Finall/src/vn_devpro_fileio/exam01/output.bin");
        // docDuLieuNhiPhan("E:/JAVA_DEVPRO/Finall/src/vn_devpro_fileio/exam01/output.bin");
    }
}
