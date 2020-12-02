import com.lagou.dao.IUserMapper;
import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void mybatisQueryTest() {
        try {
            InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
            User user = userMapper.selectOne(1);
            List<User> userList = userMapper.selectAll();
//            userList = userMapper.findByIds(new int[]{1,2,3});
            sqlSession.close();
            System.out.println(user);
            System.out.println(userList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mybatisInsertTest() {
        try {
            InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            User user = new User();
            user.setUsername("username5");
            IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
            userMapper.insert(user);
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mybatisUpdateTest() {
        try {
            InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            User user = new User();
            user.setId(1);
            user.setUsername("username4");
            sqlSession.update("com.lagou.dao.UserMapper.update",user);
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
