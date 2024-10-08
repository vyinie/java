package res;

public class User {

    public User(String name, int age, double balance) {
        this.name = name;
        this.age = (short) age;
        this.balance = balance;
    }

    private String name;
    private short age;
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
