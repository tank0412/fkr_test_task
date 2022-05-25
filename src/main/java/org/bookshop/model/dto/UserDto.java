package org.bookshop.model.dto;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserDto {
    public UserDto(Long id, String login, Integer discount) {
        this.id = id;
        this.login = login;
        this.discount = discount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;

    private Integer discount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

}
