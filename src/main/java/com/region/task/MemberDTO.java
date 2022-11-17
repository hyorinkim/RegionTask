package com.region.task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
    String name;
    String mail;
    String organization;

    @Override
    public String toString() {
        return "MemberDTO{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }
}
