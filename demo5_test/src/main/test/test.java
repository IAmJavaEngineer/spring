import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.mapper.RoleMapper;
import com.spring.mapper.UserMapper;
import com.spring.mapper.User_RoleMapper;
import com.spring.pojo.*;
import com.spring.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private User_RoleMapper user_roleMapper;
    @Test
    public void testCRUD() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserMapper userMapper = context.getBean(UserMapper.class);
//        User user = new User(null, "庄十", "168@qq.com", "123", "1222222");
//        userMapper.insert(user);
//        user_roleMapper.insert(user.getId(), new Long[]{1L, 2L});

//        List<Role> roleByUserId = roleMapper.findRoleByUserId(1L);
//        for (Role role : roleByUserId) {
//            System.out.println(role);
//        }
//        User_RoleExample user_roleExample = new User_RoleExample();
//        user_roleExample.createCriteria().andUseridEqualTo(1L);
//        List<User_RoleKey> user_roleKeys = user_roleMapper.selectByExample(user_roleExample);
//        for (User_RoleKey user_roleKey : user_roleKeys) {
//            System.out.println(user_roleKey);
//            Long roleid = user_roleKey.getRoleid();
//            Role role = roleMapper.selectByPrimaryKey(roleid);
//            System.out.println(role);
//        }
        String id = "1";
        Long userId = Long.valueOf(id);
        System.out.println(userId);
    }
    @Test
    public void testPagehelper() {

        //显示第pageNum页数据，每次显示pageSize条,显示的第一条数据是第index条的数据,因为index是从0开始，所以第一条数据对应的eid=index+1
        //select eid, emp_name, age, sex, email, did from t_emp LIMIT index,pageSize
        SqlSession session = SqlSessionUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Page<Object> page = PageHelper.startPage(1, 10);
//        List<User> list = mapper.selectByExample(null);
//        List<User> list = SqlSessionUtils.getSession().getMapper(UserMapper.class).selectByExample(null);
//        for (User emp : list) {
//            System.out.println(emp);
//        }
//        PageInfo<User> pageInfo = new PageInfo<>(list, 5);
//        for (User emp : list) {
//            System.out.println(emp);
//        }
//
//        System.out.println(page);
//        System.out.println(pageInfo);
//        System.out.println(userMapper.countByExample(null));
        List<Role> roleList = SqlSessionUtils.getSession().getMapper(RoleMapper.class).selectByExample(null);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList, 5);
        for (Role role : roleList) {
            System.out.println(role);
        }
    }
}
