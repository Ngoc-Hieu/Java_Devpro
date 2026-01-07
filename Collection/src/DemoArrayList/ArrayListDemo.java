package DemoArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Devpro");
        list.add("Hello");
        list.add(0,"XinChao");
        System.out.println(list.toString());
        System.out.println(list.indexOf("XinChao"));
        System.out.println(list.contains("Devpro"));

        for(int i=0 ; i<list.size() ; i++){
            System.out.println(list.get(i).trim());
        }
        //sapxep
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                return o1.compareTo(o2);
            }
        });
        System.out.println(list.toString());
    }
}
