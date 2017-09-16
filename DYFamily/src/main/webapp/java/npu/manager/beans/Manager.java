package npu.manager.beans;

/**
 * Created by  on .
 *
 * @version ${version}
 * @autor ZLei
 * @date 2017/9/16
 * @todo 管理员
 */
public class Manager {

    private String mid; // 管理员ID
    private String pass; // 管理员密码
    private int power; // 管理员

    public Manager() {
    }

    /**
     * @return mid : java.lang.String
     */
    public String getMid() {
        return mid;
    }

    /**
     * @param mid : java.lang.String
     */
    public void setMid(String mid) {
        this.mid = mid;
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
     * @return power : java.lang.String
     */
    public int getPower() {
        return power;
    }

    /**
     * @param power : java.lang.String
     */
    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mid='" + mid + '\'' +
                ", pass='" + pass + '\'' +
                ", power='" + power + '\'' +
                '}';
    }


}
