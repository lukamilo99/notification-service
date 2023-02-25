package raf.rs.notificationservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {

    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private Integer numberOfRentDays;
}
