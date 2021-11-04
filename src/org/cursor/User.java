package org.cursor;

import java.util.Objects;

public class User {
    private Integer userId = 0;
    private static Integer userIdNext = 0;
    private String username;
    private String password;
    private boolean isLocked;

    public User(String username, String password, boolean isLocked) {
        this.userId = userIdNext++;
        this.username = username;
        this.password = password;
        this.isLocked = isLocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isLocked == user.isLocked && Objects.equals(userId, user.userId) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, isLocked);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public static Integer getUserIdNext() {
        return userIdNext;
    }

    public static void setUserIdNext(Integer userIdNext) {
        User.userIdNext = userIdNext;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userIdNext=" + userIdNext +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isLocked=" + isLocked +
                '}';
    }
}
