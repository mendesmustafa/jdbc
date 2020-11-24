package com.mendes.utility;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by mendesmustafa on 24.11.2020.
 */

public class Util {

    public static void processSQLException(SQLException e) {
        e.printStackTrace();
        System.out.println("SQLException message: " + e.getMessage());
        System.out.println("SQL state: " + e.getSQLState());
        System.out.println("Error code: " + e.getErrorCode());
    }

    public static void processIOException(IOException e) {
        e.printStackTrace();
        System.out.println("IOException message: " + e.getMessage());
    }

    public static void writeInfoMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Bilgi ekranı", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void writeWarnMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Uyarı ekranı", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void writeErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Hata ekranı", JOptionPane.INFORMATION_MESSAGE);
    }
}