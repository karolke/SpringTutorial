package pl.kobietydokodu.cats;
import pl.kobietydokodu.cats.domain.Cat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Karolke on 24.06.2016.
 */

class Interface {

    public static void main(String[] args) {
        System.out.println("Witaj w programie!");
        CatDAO catDAO = new CatDAO();
        Interface.showMenu(catDAO);
    }

    static Scanner sc = new Scanner(System.in);

    static String getUserInput() {
        return sc.nextLine().trim();
    }

    static void setNames(Cat cat) {
        System.out.print("podaj imie kota: ");
        cat.setName(getUserInput());
        System.out.print("podaj imie wlasciciela kota: ");
        cat.setOwnerName(getUserInput());
    }

    static void setDate(Cat cat) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        String regex = "^[0-9]{4}-[01][0-9]-[0-3][0-9]$";
        String input;
        System.out.println("podaj date urodzenia w formacie RRRR-MM-DD: ");
        input = getUserInput();
        boolean war = Pattern.matches(regex,input);
        while (!war) {
            System.out.println("Nieprawidlowy format, wpisz jeszcze raz: ");
            input = getUserInput();
            war = Pattern.matches(regex,input);
        }
        try {
            cat.setBirthDate(sdf.parse(input));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    static void setWeight(Cat cat) {
        Double weight = null;
        String regexp = "^\\d*\\.?\\d*\\d$";
        String input;
        System.out.println("Podaj wage kota: ");
        input = getUserInput();
        boolean war = Pattern.matches(regexp,input);
        while(!war){
            System.out.println("Nieprawidlowy format, wpisz jeszcze raz: ");
            input = getUserInput();
            war = Pattern.matches(regexp, input);
        }
        cat.setWeight(Double.parseDouble(input));
    }

    static void showMenu(CatDAO catDAO){
        char input;
        do{
            System.out.println(" Wybierz: \n(1) aby dodać kota \n" +
                    "(2) wyswietl baze kotow\n(x) zamyka program");
            input = getUserInput().charAt(0);
            switch (input){
                case '1':
                    Cat cat = new Cat();
                    setNames(cat);
                    setDate(cat);
                    setWeight(cat);
                    catDAO.add(cat);
                    showMenu(catDAO);
                    break;
                case '2':
                    int id=0;
                    for (Cat el: catDAO.cats){
                        System.out.println("Kot: "+el.getName()+" ID: "+id);
                        id++;

                    }
                    System.out.println("Wybierz nr kota do wypisania: ");
                    String inputString = getUserInput();
                    String regex = "[0-9]+";
                    while(!Pattern.matches(regex, inputString)){
                        System.out.println("Podaj cyfre: ");
                        inputString = getUserInput();

                    }
                    int number = Integer.parseInt(inputString);
                    if(number > catDAO.cats.size() || number < 0){
                        System.out.println("W bazie nie ma kota o tym numerze!");
                        break;
                    }
                    catDAO.cats.get(number).introduce();
                    showMenu(catDAO);
                    break;
                case 'x':
                    System.out.println("Zamykam program!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nie znam takiej opcji, sprobuj jeszcze raz");
                    showMenu(catDAO);
                    break;

            }
        }while(input!='x');
    }


}
