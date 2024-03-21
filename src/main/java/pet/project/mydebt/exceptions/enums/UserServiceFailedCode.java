package pet.project.mydebt.exceptions.enums;

public enum UserServiceFailedCode implements Error {
    NOT_FOUND(404, "Не найдено"),
    VALIDATE_FAILED(400, "Ошибка валидации данных"),
    ALREADY_EXISTS(409, "Пользователь уже существует");

    private final int httpCode;
    private final String message;

    UserServiceFailedCode(int httpCode, String message) {
        this.httpCode = httpCode;
        this.message = message;
    }

    @Override
    public int getHttpCode() {
        return httpCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
