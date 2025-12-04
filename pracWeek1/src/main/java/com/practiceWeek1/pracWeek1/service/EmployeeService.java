package com.practiceWeek1.pracWeek1.service;

import com.practiceWeek1.pracWeek1.dto.EmployeeDTO;
import com.practiceWeek1.pracWeek1.entity.EmployeeEntity;
import com.practiceWeek1.pracWeek1.repositories.EmployeeRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        //ModelMapper mapper = new ModelMapper();
        return mapper.map(employeeEntity,EmployeeDTO.class);
    }

    public List<EmployeeDTO> findAll() {
        List<EmployeeEntity> employeeEntities =  employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> mapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(@Valid EmployeeDTO inputEmp) {
        EmployeeEntity toSaveEntity  = mapper.map(inputEmp,EmployeeEntity.class);
        EmployeeEntity savedEmpEntity = employeeRepository.save(toSaveEntity);
        return mapper.map(savedEmpEntity,EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = mapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity saveEmpEntity = employeeRepository.save(employeeEntity);
        return mapper.map(saveEmpEntity,EmployeeDTO.class);

    }

    public boolean deleteEmployee(Long employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return true;    // deletion success
        }
        return false;       // id not found
    }

    public EmployeeDTO updatePartialEmployee(Long employeeId, Map<String, Object> updates) {
        EmployeeEntity employeeEntity;
        if (employeeRepository.existsById(employeeId)) {
            employeeEntity = employeeRepository.findById(employeeId).get();
            updates.forEach((field, value) -> {
                Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class, field);
                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
            });

        } else {
            return null;
        }
        return mapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
