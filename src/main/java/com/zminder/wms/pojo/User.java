package com.zminder.wms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private Integer age;
    private Character gender;
    private String phone;
    private Integer roleId;
    private Character isValid;
}
