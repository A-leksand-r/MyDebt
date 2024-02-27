package pet.project.mydebt.entities;

import lombok.Getter;

@Getter
public enum LoanStatus {
    ACTIVE("Активный"),
    CLOSED("Закрыт"),
    REQUESTED("Запрошено");
    private final String title;

    LoanStatus(String title) {
        this.title = title;
    }
}
