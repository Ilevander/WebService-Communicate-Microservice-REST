package com.ilyass.webapp.repository;

import com.ilyass.webapp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class EmployeeProxy {

    @Autowired
    private CustomProperties props;

    public Iterable<Employee> getEmployees() {
        String baseApiUrl = props.getApiUrl();
        String getEmployeesUrl = baseApiUrl + "/employees";

        System.out.println("EmployeeProxy *** getEmployees() getEmployeesUrl " + getEmployeesUrl);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Employee>> response =
                restTemplate.exchange(
                        getEmployeesUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Iterable<Employee>>() {}
                );

        System.out.println("EmployeeProxy *** getEmployees() response.getBody() " + response.getBody());

        log.debug("Get Employees call: {}", response.getStatusCode().toString());

        return response.getBody();
    }
}
