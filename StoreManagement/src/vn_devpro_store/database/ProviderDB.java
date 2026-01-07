package vn_devpro_store.database;

import java.util.ArrayList;
import java.util.List;

import vn_devpro_store.model.Provider;

public class ProviderDB {
    private static int autoId = 1;

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        ProviderDB.autoId = autoId ;
    }
    private static List<Provider> providers = new ArrayList<>(){
        {
            add(new Provider(autoId++, "NCC_101", "Sun House"));
            add(new Provider(autoId++, "NCC_102", "Lock&Lock"));
            add(new Provider(autoId++, "NCC_103", "Owen"));
        }
    };

    public static List<Provider> getProviders() {
        return providers;
    }

    public static void setProviders(List<Provider> providers) {
        ProviderDB.providers = providers;
    }
    public static Provider findById(int id){
        for(Provider provider : providers){
            if(provider.getId() == id){
                return provider;
            }
        }
        return null;
    }
    public static  Provider findByName(String name){
        for(Provider provider : providers){
            if(provider.getName().trim().equalsIgnoreCase(name.trim())){
                return provider;
            }
        }
        return null;
    }
    public static  int findByCode(String code){
        for(int i=0 ; i<providers.size() ; i++){
            if(providers.get(i).getCode().trim().equalsIgnoreCase(code.trim())){
                return i;
            }
        }
        return -1;
    }
}
