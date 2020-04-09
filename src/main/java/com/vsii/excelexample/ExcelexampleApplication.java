package com.vsii.excelexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ExcelexampleApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ExcelexampleApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(MailSenderService mailSenderService){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                try {

                    //String excelFilePath = "D:/JAVA/DataSamples/books_1.xls";
                    String excelFilePath = "D:/JAVA/DataSamples/books_2.xlsx";

                    List<Book> listBooks = new ReadFromExcelFile().readBooksFromExcelFile(excelFilePath);
                    BookDAO bookDAO = new BookDAO();
                    bookDAO.insertListBooks(listBooks);
                    mailSenderService.sendSimpleEmail();

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        };
    }

}
