package pet.project.mydebt.utils;

import pet.project.mydebt.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserUtils {

    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=_-]).+$");
    private static final Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final Pattern phonePattern = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");


    public static List<String> validateFields(User user) {
        List<String> errors = new ArrayList<>();
        if (user.getLastName() == null) {
            errors.add("Фамилия не может быть пустым");
        }
        if (user.getMiddleName() == null) {
            errors.add("Отчество не может быть пустым");
        }
        if (user.getFirstName() == null) {
            errors.add("Имя не может быть пустым");
        }
        if (user.getUsername() == null) {
            errors.add("Имя пользователя не может быть пустым");
        }
        if (user.getPassword() == null) {
            errors.add("Пароль не может быть пустым");
        }
        else errors.addAll(validatePassword(user.getPassword()));
        if (user.getEmail() == null) {
            errors.add("Email не может быть пустым");
        }
        else errors.addAll(validateEmail(user.getEmail()));
        if (user.getPhone() != null) {
            errors.addAll(validatePhoneNumber(user.getPhone()));
        }
        return errors;
    }

    public static List<String> validatePassword(String password) {
        List<String> errors = new ArrayList<>();
        if (password.length() < 10) {
            errors.add("Минимальная длина пароля 10 символов");
        }
        else if (!passwordPattern.matcher(password).matches()) {
            errors.add("Пароль должен содержать строчную и заглавную букву, цифру, а также спецсимвол (@#$%^&+=_-)");
        }
        return errors;
    }

    public static List<String> validateEmail(String email) {
        List<String> errors = new ArrayList<>();
        if (!emailPattern.matcher(email).matches()) {
            errors.add("Неправильный email");
        }
        return errors;
    }

    public static List<String> validatePhoneNumber(String number) {
        List<String> errors = new ArrayList<>();
        if (!phonePattern.matcher(number).matches()) {
            errors.add("Неправильный номер телефона");
        }
        return errors;
    }

}
