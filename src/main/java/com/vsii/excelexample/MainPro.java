package com.vsii.excelexample;

import java.util.List;

public class MainPro {

    public static void main(String[] args) {
        try {

            //String excelFilePath = "D:/JAVA/DataSamples/books_1.xls";
            String excelFilePath = "D:/JAVA/DataSamples/books_2.xlsx";

            List<Book> listBooks = new ReadFromExcelFile().readBooksFromExcelFile(excelFilePath);
            BookDAO bookDAO = new BookDAO();
            bookDAO.insertListBooks(listBooks);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
