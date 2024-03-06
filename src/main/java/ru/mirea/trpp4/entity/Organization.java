package ru.mirea.trpp4.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** Сущность сотрудника. */
@Getter
@Setter
@ToString
public class Organization {

    /** Идентификатор. */
    @JsonProperty("id")
    @CsvBindByName(column = "id")
    private Long id;
    /** Наименование организации. */
    @JsonProperty("name")
    @CsvBindByName(column = "name")
    private String name;
    /** email. */
    @JsonProperty("email")
    @CsvBindByName(column = "email")
    private String email;
    /** Адрес. */
    @JsonProperty("address")
    @CsvBindByName(column = "address")
    private String address;
    /** Контактный телефон. */
    @JsonProperty("phone")
    @CsvBindByName(column = "phone")
    private String phone;
}
