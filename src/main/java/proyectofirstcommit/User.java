package proyectofirstcommit;

public class User {
    private String email;
    private String nombreCompleto;
    private String userName;

    public User(String email, String nombreCompleto, String userName) {
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.userName = userName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
