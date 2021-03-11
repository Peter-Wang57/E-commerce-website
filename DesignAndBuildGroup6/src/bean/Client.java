package bean;

public class Client {
    private String clientID;
    private String password;
    private String sex;
    private String phoneNum;
    private Integer age;
    private String name;

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID='" + clientID + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Client(String clientID, String password, String sex, String phoneNum, Integer age, String name) {
        this.clientID = clientID;
        this.password = password;
        this.sex = sex;
        this.phoneNum = phoneNum;
        this.age = age;
        this.name = name;
    }
    public Client() {

    }
}
