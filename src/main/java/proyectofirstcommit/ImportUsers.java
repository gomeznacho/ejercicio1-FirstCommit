package proyectofirstcommit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImportUsers {
    public static ArrayList<User> createList() {
        ArrayList<User> list = new ArrayList<>();
        int numeroLineas = 0;
        int lineasBien = 0;
        int errores = 0;
        try {
            InputStream in = new FileInputStream("listado.txt");
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()) {
                String first = scanner.nextLine();
                String[] sa = first.split(",");

                String regx = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
                Pattern pattern = Pattern.compile(regx);
                Matcher matcher = pattern.matcher(sa[0]);

                if (sa.length < 3) {
                    numeroLineas++;
                    errores++;
                    System.out.println(System.err + " falta un campo en la línea " + numeroLineas);
                }
                else if (isPresent(sa[0], list)) {
                    numeroLineas++;
                    errores++;
                    System.out.println(System.err + " email duplicado en línea " + numeroLineas);
                } else if (!matcher.matches()) {
                    numeroLineas++;
                    errores++;
                    System.out.println(System.err + " el email está mal formado en la línea " + numeroLineas);

                } else {
                    numeroLineas++;
                    lineasBien++;
                    list.add(createUser(sa[0], sa[1], sa[2]));
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(list.toString());
        System.out.println("número de líneas aceptadas " + lineasBien + ", número de líneas erróneas " + errores);

        return list;
    }

    public static User createUser(String email, String nombre, String username){
        return new User(email, nombre, username);

    }

    public static boolean isPresent(String s, ArrayList<User> l){
        boolean b = false;
        for(User u : l){
            if (u.getEmail().equals(s))
                b = true;
        }
        return b;
    }


}
