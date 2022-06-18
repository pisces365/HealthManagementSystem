package basicDatas;

public class LogInDatas {
    private String name;
    private String role;
    private String number;
    private String college;
    private String id;
    private String phone;
    private String password;

    public LogInDatas(String name, String role, String number, String college, String id, String phone, String password) {
        this.name = name;
        this.role = role;
        this.number = number;
        this.college = college;
        this.id = id;
        this.phone = phone;
        this.password = password;
    }

    public LogInDatas() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
