package vn_devpro_store.database;

import java.util.ArrayList;
import java.util.List;

import vn_devpro_store.model.Customer;

public class CustomerDB {
    private static int autoId = 1;

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        CustomerDB.autoId = autoId;
    }

    private static List<Customer> customers = new ArrayList<>() {
        {
            add(new Customer(autoId++, "KH_101", "Nguyen Van Loc"));
            add(new Customer(autoId++, "KH_102", "Tran Thi Trinh"));
            add(new Customer(autoId++, "KH_103", "Le Van Cong"));
        }
    };

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(List<Customer> customers) {
        CustomerDB.customers = customers;
    }

    public static Customer findById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public static Customer findByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().trim().equalsIgnoreCase(name.trim())) {
                return customer;
            }
        }
        return null;
    }

    public static int findByCode(String code) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCode().trim().equalsIgnoreCase(code.trim())) {
                return i;
            }
        }
        return -1;
    }
}
