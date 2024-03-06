package ru.mirea.trpp4.controllers;

import com.opencsv.bean.CsvToBeanBuilder;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import ru.mirea.trpp4.entity.Organization;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

/** Контроллер для работы с организациями. */
@Controller("/organization")
public class EmployeeController {

    /** Список организаций. */
    private final List<Organization> organizationList;

    /** Конструктор. */
    public EmployeeController() {
        organizationList = new CsvToBeanBuilder<Organization>(
                new InputStreamReader(this.getClass().getResourceAsStream("/MOCK_DATA.csv"))
                ).withType(Organization.class).build().parse();
    }

    /**
     * Получить список организаций.
     * @return список организаций
     */
    @Get()
    public HttpResponse<List<Organization>> getOrganizations() {
        return HttpResponse.ok(organizationList);
    }

    /**
     * Найти организацию по идентификатору.
     * @param id идентификатор организации
     * @return Организация, если есть, иначе 404 ошибка
     */
    @Get("/{id}")
    public HttpResponse<Organization> findById(Long id) {
        Optional<Organization> result = organizationList.stream().filter(it -> it.getId().equals(id)).findAny();
        if (result.isPresent()) {
            return HttpResponse.ok(result.get());
        } else {
            return HttpResponse.notFound();
        }
    }
}
