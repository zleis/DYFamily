package nwpu.manager.beans;

import java.util.Date;

/**
 * Created by  on .
 *
 * @version ${version}
 * @autor ZLei
 * @date 2017/9/16
 * @todo 用户类
 */
public class User {
    /**
     * 私有属性
     */
    private String uid; // 学号
    private String pass; // 密码
    private String name; // 姓名
    private int sex; // 性别
    private Date birth; // 生日
    private String phone; // 手机
    private String mail; // 邮箱
    private int grade; // 年级
    private String classNum; // 班级
    private String bid; // 所属党支部
    private Date registerTime; // 注册时间
    private String special; // 特长
    private String cogition; // 党的认识
    private int isComp; // 是否完善

    /**
     * function
     * @author ZLei
     * @date 2017/9/16
     * @param
     * @return
     * @todo
     */
    public User() {

    }

    /**
     * @return uid : java.lang.String
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid : java.lang.String
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return pass : java.lang.String
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass : java.lang.String
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return name : java.lang.String
     */
    public String getName() {
        return name;
    }

    /**
     * @param name : java.lang.String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return sex : int
     */
    public int getSex() {
        return sex;
    }

    /**
     * @param sex : int
     */
    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * @return birth : java.util.Date
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * @param birth : java.util.Date
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * @return phone : java.lang.String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone : java.lang.String
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return mail : java.lang.String
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail : java.lang.String
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return grade : int
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param grade : int
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * @return classNum : java.lang.String
     */
    public String getClassNum() {
        return classNum;
    }

    /**
     * @param classNum : java.lang.String
     */
    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    /**
     * @return bid : java.lang.String
     */
    public String getBid() {
        return bid;
    }

    /**
     * @param bid : java.lang.String
     */
    public void setBid(String bid) {
        this.bid = bid;
    }

    /**
     * @return registerTime : java.util.Date
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * @param registerTime : java.util.Date
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * @return special : java.lang.String
     */
    public String getSpecial() {
        return special;
    }

    /**
     * @param special : java.lang.String
     */
    public void setSpecial(String special) {
        this.special = special;
    }

    /**
     * @return cogition : java.lang.String
     */
    public String getCogition() {
        return cogition;
    }

    /**
     * @param cogition : java.lang.String
     */
    public void setCogition(String cogition) {
        this.cogition = cogition;
    }

    /**
     * @return isComp : int
     */
    public int getIsComp() {
        return isComp;
    }

    /**
     * @param isComp : int
     */
    public void setIsComp(int isComp) {
        this.isComp = isComp;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birth=" + birth +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", grade=" + grade +
                ", classNum='" + classNum + '\'' +
                ", bid='" + bid + '\'' +
                ", registerTime=" + registerTime +
                ", special='" + special + '\'' +
                ", cogition='" + cogition + '\'' +
                ", isComp=" + isComp +
                '}';
    }
}
