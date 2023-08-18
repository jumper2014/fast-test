package com.example.framework.cases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserGetCase extends YamlCase {
    private String testDesc;
    private UserGetRequest request;
    private UserGetResponse response;
}
