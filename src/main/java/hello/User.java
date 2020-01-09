package hello;

import javax.persistence.*;

@Entity(name = "users")
@Table(name = "users")
public class User {

    @Id
    @Column(name = "name", nullable = false, insertable = true, updatable = true)
    private String username;

    @Column(name = "coin_count", nullable = false, insertable = true, updatable = true)
    private int coinCount;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }
}