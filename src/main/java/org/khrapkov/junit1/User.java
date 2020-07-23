package org.khrapkov.junit1;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    private int id;
    private String name;
    private int age;
    private Sex sex;
    private static Map<Integer, User> allUsers = new HashMap<Integer,User>();
    private static int userIdCount = 0;

    enum Sex{
        MALE,
        FEMALE
    }

    public User( String name, int age, Sex sex) {
        this.id = userIdCount;
        this.name = name;
        this.age = age;
        this.sex = sex;

        if(!hasUser()){
           this.id = ++userIdCount;
           allUsers.put(this.id, this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    private boolean hasUser() {
        return allUsers.containsValue(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public static List<User> getAllUsers() {
        return new ArrayList<User>(allUsers.values());
    }

    public static List<User> getAllUsers(Sex sex){
       return allUsers.entrySet().stream()
               .filter( e -> e.getValue().getSex() == sex)
               .map(e -> e.getValue())
               .collect(Collectors.toList());
    }

    public int howManyUsers(){
        return allUsers.size();
    }

    public int howManyMale(){
        return getAllUsers(Sex.MALE).size();
    }

    public int howManyFemale(){
        return getAllUsers(Sex.FEMALE).size();
    }

    public int getSummaryAgeOfUsers(){
        int[] sum = {0};
        allUsers.forEach( (k,v) -> sum[0] += v.getAge());
        return sum[0] ;
    }

    public int getSummaryAgeOfUsers(Sex sex){
        int[] sum = {0};
        getAllUsers(sex).forEach( e -> sum[0] += e.getAge());
        return sum[0];
    }

    public int getAverageAgeOfUsers(){
        return getSummaryAgeOfUsers() / allUsers.size();
    }

    public int getAverageAgeOfUsers(Sex sex){
        return getSummaryAgeOfUsers(sex) / getAllUsers(sex).size();
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(this == obj ) return true;
        if(obj instanceof User){
            User other = (User) obj;
            return this.name.equals(other.getName())
                    && this.age == other.getAge()
                    && this.sex == other.getSex();
        }
        return false;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        if(this.sex == Sex.MALE){
            hash = this.age + this.name.hashCode();
        }else{
            hash =  this.name.hashCode() - this.age;
        }
        return hash;
    }

}
