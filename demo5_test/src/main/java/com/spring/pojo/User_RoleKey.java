package com.spring.pojo;

public class User_RoleKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role.userId
     *
     * @mbggenerated Wed Apr 06 11:17:14 CST 2022
     */
    private Long userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role.roleId
     *
     * @mbggenerated Wed Apr 06 11:17:14 CST 2022
     */
    private Long roleid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role.userId
     *
     * @return the value of sys_user_role.userId
     *
     * @mbggenerated Wed Apr 06 11:17:14 CST 2022
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role.userId
     *
     * @param userid the value for sys_user_role.userId
     *
     * @mbggenerated Wed Apr 06 11:17:14 CST 2022
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role.roleId
     *
     * @return the value of sys_user_role.roleId
     *
     * @mbggenerated Wed Apr 06 11:17:14 CST 2022
     */
    public Long getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role.roleId
     *
     * @param roleid the value for sys_user_role.roleId
     *
     * @mbggenerated Wed Apr 06 11:17:14 CST 2022
     */
    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public User_RoleKey(Long userid, Long roleid) {
        this.userid = userid;
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "User_RoleKey{" +
                "userid=" + userid +
                ", roleid=" + roleid +
                '}';
    }
}
