package com.vsii.excelexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class BookDAO {

    private Connection conn;
    private PreparedStatement ps;

    public void insertListBooks(List<Book> listBooks) {
        try {
                            conn = MySQLConnectionUtils.connect();
                // Sét tự động commit false, để chủ động điều khiển
                conn.setAutoCommit(false);

                String sql = "INSERT INTO book(id, name, author, price) VALUES (?, ?, ?, ?)";
                ps = conn.prepareStatement(sql);

                for (Book book : listBooks) {
                    ps.setDouble(1, book.getId());
                    ps.setString(2, book.getName());
                    ps.setString(3, book.getAuthor());
                    ps.setDouble(4, book.getPrice());
                    ps.addBatch();
                }

                ps.executeBatch();

                // Gọi commit() để commit giao dịch với DB
                conn.commit();

                System.out.println("Record is inserted into BOOK table!");

        } catch (Exception e) {

            e.printStackTrace();
            MySQLConnectionUtils.rollbackQuietly(conn);

        } finally {

            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            MySQLConnectionUtils.disconnect(conn);
        }
    }

}