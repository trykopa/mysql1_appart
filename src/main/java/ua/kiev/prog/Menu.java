package ua.kiev.prog;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static void showMenu() {
        System.out.println("Command Options: ");
        System.out.println("a: Вывод всей базы квартир на экран");
        System.out.println("b: Поиск квартиры по стоимости");
        System.out.println("c: Поиск квартиры по количеству комнат");
        System.out.println("d: Поиск квартиры по адресу или району");
        System.out.println("e: Поиск по цене, площади и количеству комнат");
        System.out.println("f: Добавить квартиру в базу");
        System.out.println("?: Показать это меню повторно");
        System.out.println("q: Quit");
    }

    public static void menuItemB(Connection conn) throws SQLException {
        System.out.println("Введите максимальную стоимость квартиры:");
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        DBqueries.searchPrice(conn, price);
    }

    public static void menuItemC(Connection conn) throws SQLException {
        System.out.println("Введите количество комнат в искомой квартире:");
        Scanner sc = new Scanner(System.in);
        int rooms = sc.nextInt();
        DBqueries.searchRooms(conn, rooms);
    }

    public static void menuItemD(Connection conn) throws SQLException {
        System.out.println("Введите часть адресса или названия района в которых ищете квартиру:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        DBqueries.searchAddr(conn, str);
    }

    public static void menuItemE(Connection conn) throws SQLException {
        System.out.println("Введите максимальную цену, минимальную площадь и количество комнат искомой квартиры:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Максимальная цена?");
        int price = sc.nextInt();
        System.out.println("Минимальная площадь?");
        int area = sc.nextInt();
        System.out.println("Количество комнат?");
        int rooms = sc.nextInt();
        DBqueries.searchApp(conn, rooms, area, price);
    }

    public static void menuItemF(Connection conn) throws SQLException {
        System.out.println("Давайте добавим новую квартиру в базу:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите район в котором расположена квартира");
        String district = sc.nextLine();
        System.out.println("Введите адресс квартиры");
        String address = sc.nextLine();
        System.out.println("Введите количество комнат в квартире");
        int rooms = sc.nextInt();
        System.out.println("Введите площадь квартиры (хх.хх)");
        float area = sc.nextFloat();
        System.out.println("Введите стоимость квартиры (ххххх.хх)");
        float price = sc.nextFloat();
        DBqueries.addAppart(conn, district, address, area, rooms, price);

    }
}
