package br.com.dio.persistence.entity;

import br.com.dio.persistence.ModuleDAO;
import lombok.Data;

import java.util.List;

@Data
public class ModuleEntity extends ModuleDAO{
    private long id;
    private String name;
    private List<EmployeeEntity> employees;
}
