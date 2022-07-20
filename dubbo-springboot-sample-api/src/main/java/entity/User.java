package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -3363120264501521428L;
    private long userId;
    private String userName;
    private String responseInfo;
    private String sex;
    private String hahaha;

    public User(long userId, String userName, String responseInfo) {
        this.userId = userId;
        this.userName = userName;
        this.responseInfo = responseInfo;
    }
}
