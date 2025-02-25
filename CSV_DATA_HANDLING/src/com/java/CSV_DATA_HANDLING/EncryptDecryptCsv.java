package com.java.CSV_DATA_HANDLING;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.*;
import java.util.Base64;

public class EncryptDecryptCsv {

    private static final String ALGORITHM = "AES";

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128);
        return keyGen.generateKey();
    }

    public static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }

    public static void main(String[] args) {
        List<String[]> employees = Arrays.asList(
            new String[]{"1", "Alice Johnson", "HR", "50000", "alice@example.com"},
            new String[]{"2", "Bob Smith", "Engineering", "75000", "bob@example.com"}
        );

        try {
            SecretKey key = generateKey();
            String keyString = Base64.getEncoder().encodeToString(key.getEncoded());
            System.out.println("Encryption Key: " + keyString);

            // Encrypt and write to CSV
            try (FileWriter writer = new FileWriter("encrypted_employees.csv")) {
                writer.append("ID,Name,Department,Salary,Email\n");
                for (String[] employee : employees) {
                    String encryptedSalary = encrypt(employee[3], key);
                    String encryptedEmail = encrypt(employee[4], key);
                    writer.append(employee[0]).append(",")
                          .append(employee[1]).append(",")
                          .append(employee[2]).append(",")
                          .append(encryptedSalary).append(",")
                          .append(encryptedEmail).append("\n");
                }
            }

            // Decrypt and read from CSV
            byte[] decodedKey = Base64.getDecoder().decode(keyString);
            SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGORITHM);

            try (BufferedReader br = new BufferedReader(new FileReader("encrypted_employees.csv"))) {
                String line = br.readLine(); // Skip the header row
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    String decryptedSalary = decrypt(values[3], originalKey);
                    String decryptedEmail = decrypt(values[4], originalKey);
                    System.out.println("ID: " + values[0] + ", Name: " + values[1] + ", Department: " + values[2] +
                                       ", Salary: " + decryptedSalary + ", Email: " + decryptedEmail);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}