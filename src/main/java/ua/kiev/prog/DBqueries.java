package ua.kiev.prog;

import java.sql.*;

public class DBqueries {

    public static void searchApp(Connection conn, int rooms, int area, int price) throws SQLException {
        System.out.println("По таким криетриям найдены такие квартиры:");
        String sql = "SELECT * FROM app WHERE rooms=" + rooms + " AND area >=" + area + " AND price <=" + price + ";";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        printRes(rs);

    }

    public static void searchPrice(Connection conn, int price) throws SQLException {
        System.out.println("По таким криетриям найдены такие квартиры:");
        String sql = "SELECT * FROM app WHERE price <=" + price + ";";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        printRes(rs);

    }

    public static void searchRooms(Connection conn, int rooms) throws SQLException {
        System.out.println("По таким криетриям найдены такие квартиры:");
        String sql = "SELECT * FROM app WHERE rooms =" + rooms + ";";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        printRes(rs);

    }

    public static void searchAddr(Connection conn, String str) throws SQLException {
        System.out.println("По таким криетриям найдены такие квартиры:");
        String sql = "SELECT * FROM app WHERE district LIKE '%" + str + "%' OR adress LIKE '%" + str + "%';";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        printRes(rs);

    }

    public static void printTable(Connection conn) throws SQLException {
        System.out.println("В базе найдены такие квартиры...");
        String sql = "select * from app;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        printRes(rs);
    }

    public static void addAppart(Connection con, String district, String address, float area, int rooms, float price) throws SQLException {
        String sql = "INSERT test.app (district, adress, area, rooms, price) VALUES (?,?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, district);
        ps.setString(2, address);
        ps.setFloat(3, area);
        ps.setInt(4, rooms);
        ps.setFloat(5, price);
        ps.execute();
        System.out.println("Квартира добавлена в базу успешно!");
    }

    public static void printRes(ResultSet rs) throws SQLException {
        while (rs.next()) {
            String district = rs.getString("district");
            String adress = rs.getString("adress");
            float area = rs.getFloat("area");
            int rooms = rs.getInt("rooms");
            float price = rs.getFloat("price");

            //Display values
            System.out.print("Район: " + district);
            System.out.print(", Адрес: " + adress);
            System.out.printf(", Площадь:  %4.2f", area);
            System.out.print(", Комнат: " + rooms);
            System.out.printf(", Цена:  %6.2f  %n", price);
        }
        rs.close();
    }
}
