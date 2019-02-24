package net.me.june.dev.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class BaseDTO implements Serializable {

    private Long seq;

    private String searchCondition;

    private String searchKeyword;

}
