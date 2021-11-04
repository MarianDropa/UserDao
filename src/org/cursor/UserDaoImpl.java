package org.cursor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class UserDaoImpl {

    static List<User> userdb = read("resources/userdbFile.csv");



    public static List<User> read(String filename) {
        List<User> userdb = new ArrayList<>();
        Path pathToFile = Paths.get(filename);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                User user = createUser(attributes);
                userdb.add(user);
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return userdb;
    }


    public static void addUser(User user) {
        user = new User(user.getUsername(), user.getPassword(), user.isLocked());
        userdb.add(user);
        save(userdb);
    }


    public static void save(List<User> userdb) {
        File userdbFile = new File("resources/userdbFile.csv");

        if (!userdbFile.exists()) {
            try {
                File directory = new File(userdbFile.getParent());
                if (!directory.exists()) {
                    directory.mkdir();
                }
                userdbFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Error occurred while creating directory or file");
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("resources/userdbFile.csv"), StandardCharsets.UTF_8))) {
            for (User user : userdb) {
                String CSV_SEPARATOR = ",";
                String oneLine = (user.getUserId() < 0 ? "" : user.getUserId()) +
                        CSV_SEPARATOR +
                        (user.getUsername().trim().length() == 0 ? "" : user.getUsername()) +
                        CSV_SEPARATOR +
                        (user.getPassword().trim().length() == 0 ? "" : user.getPassword()) +
                        CSV_SEPARATOR +
                        (user.isLocked());
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            System.out.println("Error occurred while saving user");
        }
    }


    public static User createUser(String[] metadata) {
       //Integer userId = Integer.parseInt(metadata[0]);
        String username = metadata[1];
        String password = metadata[2];
        boolean isLocked = Boolean.parseBoolean(metadata[3]);
        // String firsname = metadata[4];

        return new User(username, password, isLocked);
    }


    public static void lockUser(Integer userId, boolean isLocked) {
        for (User user : userdb) {
            if (user.getUserId().equals(userId)) {
                user.setLocked(isLocked);
                save(userdb);
            }
        }
    }


    public static User getByName(String username) {
        for (User user : userdb) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }


    public static User getById(Integer userId) {
        for (User user : userdb) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }


    public static List<User> getAll() {
        return (userdb);
    }
}
