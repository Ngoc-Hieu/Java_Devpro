package vn_devpro_store.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import vn_devpro_store.model.Product;

public class ProductDB {
    private static int autoId = 1;

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        ProductDB.autoId = autoId;
    }


    private static List<Product> products = new ArrayList<>() {
        {
            add(new Product(autoId++, 1, "SP_101", "Chao chong dinh 23cm", new BigDecimal("350000")));
            add(new Product(autoId++, 2, "SP_102", "Noi chien khong dau", new BigDecimal("3500000")));
            add(new Product(autoId++, 3, "SP_103", "Binh giu nhieu 550ml", new BigDecimal("450000")));
            add(new Product(autoId++, 3, "SP_104", "Ao len nam co 3cm", new BigDecimal("1450000")));
        }
    };

    public static List<Product> getProducts() {
        return products;
    }

    public static void setProducts(List<Product> products) {
        ProductDB.products = products;
    }

    public static Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public static int findByCode(String code) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode().trim().equalsIgnoreCase(code.trim())) {
                return i;
            }
        }
        return -1;
    }

    public static Product findByName(String name) {
        for (Product product : products) {
            if (product.getName().trim().equalsIgnoreCase(name.trim())) {
                return product;
            }
        }
        return null;
    }
}
