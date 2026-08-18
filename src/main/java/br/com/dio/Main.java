package br.com.dio;

import br.com.dio.persistence.*;
import br.com.dio.persistence.entity.ContactEntity;
import br.com.dio.persistence.entity.EmployeeEntity;
import br.com.dio.persistence.entity.ModuleEntity;
import net.datafaker.Faker;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Stream;

import static java.time.ZoneOffset.UTC;

public class Main {
    private final static EmployeeParamDAO employeeDAO = new EmployeeParamDAO();
    private final static EmployeeAuditDAO employeeAuditDAO = new EmployeeAuditDAO();
    private final static ContactDAO contactDAO = new ContactDAO();
    private final static ModuleDAO moduleDAO = new ModuleDAO();
    private final static Faker faker = new Faker(Locale.of("pt", "BR"));

    public static void  main (String [] args) {
        String url = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost/bootcamp");
        String user = System.getenv().getOrDefault("DB_USER", "root");
        String password = System.getenv().getOrDefault("DB_PASSWORD", "root");

        var flyway = Flyway.configure()
                .dataSource(url, user, password)
                .load();
        flyway.migrate();

        /*var insert = new EmployeeEntity();
        insert.setName("João");
        insert.setSalary(new BigDecimal("3500"));
        insert.setBirthday(OffsetDateTime.now().minusYears(22));
        System.out.println(insert);
        employeeDAO.insert(insert);
        System.out.println(insert);*/

        //employeeDAO.findAll().forEach(System.out::println);

        //System.out.println(employeeDAO.findById(1));

        /*var update = new EmployeeEntity();
        update.setId(insert.getId());
        update.setName("Taspio");
        update.setSalary(new BigDecimal("3000"));
        update.setBirthday(OffsetDateTime.now().minusYears(24).minusDays(6));
        employeeDAO.update(update);

        employeeDAO.delete(insert.getId());

        employeeAuditDAO.findAll().forEach(System.out::println);*/

        /*var entities = Stream.generate(() -> {
            var employee = new EmployeeEntity();
            employee.setName(faker.name().fullName());
            employee.setSalary(new BigDecimal(faker.number().digits(4)));
            employee.setBirthday(OffsetDateTime.of(LocalDate.now().minusYears(faker.number().numberBetween(30, 22)), LocalTime.MIN, UTC));
            return employee;
        }).limit(4000).toList();

        employeeDAO.insertBach(entities);*/

        /*var employee = new EmployeeEntity();
        employee.setName("joao");
        employee.setSalary(new BigDecimal("2500"));
        employee.setBirthday(OffsetDateTime.now().minusYears(19));
        System.out.println(employee);
        employeeDAO.insert(employee);
        System.out.println(employee);*/

        /*var contact = new ContactEntity();
        contact.setDescription("matheus@gmail.com");
        contact.setType("e-mail");
        contact.setEmployee(employee);
        contactDAO.insert(contact);*/

        //System.out.println(employeeDAO.findById(2));

        /*var employee = new EmployeeEntity();
        employee.setName("matheus");
        employee.setSalary(new BigDecimal("2500"));
        employee.setBirthday(OffsetDateTime.now().minusYears(19));
        System.out.println(employee);
        employeeDAO.insert(employee);
        System.out.println(employee);

        var contact1 = new ContactEntity();
        contact1.setDescription("matheus@gmail.com");
        contact1.setType("e-mail");
        contact1.setEmployee(employee);
        contactDAO.insert(contact1);

        var contact2 = new ContactEntity();
        contact2.setDescription("11 94999-2222");
        contact2.setType("telefone");
        contact2.setEmployee(employee);
        contactDAO.insert(contact2);*/

        //employeeDAO.findAll().forEach(System.out::println);

        /*var entities = Stream.generate(() -> {
            var employee = new EmployeeEntity();
            employee.setName(faker.name().fullName());
            employee.setSalary(new BigDecimal(faker.number().digits(4)));
            employee.setBirthday(OffsetDateTime.of(LocalDate.now().minusYears(faker.number().numberBetween(30, 22)), LocalTime.MIN, UTC));
            employee.setModules(new ArrayList<>());
            var moduleAmount = faker.number().numberBetween(1,4);
            for (int i = 0; i < moduleAmount; i++) {
                var module = new ModuleEntity();
                module.setId(i +1);
                employee.getModules().add(module);
            }
            return employee;
        }).limit(3).toList();
        entities.forEach(employeeDAO::insert);*/

        //moduleDAO.findAll().forEach(System.out::println);

    }
}