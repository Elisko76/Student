package m.s;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="idusers")
    private int idusers;

    @Column(name="login", length=50)
    private String login;

    @Column(name="password", length=50)
    private String password;

    public int getidusers() {
        return idusers;
    }
    public void setidusers(int idusers) {
        this.idusers = idusers;
    }

    public String getlogin() {
        return login;
    }
    public void setlogin(String login) {
        this.login = login;
    }

    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }
}


