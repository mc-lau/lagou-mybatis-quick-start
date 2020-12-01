import com.lagou.dao.UserMapper;
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
            User user = new User();
            user.setId(3);
            user = sqlSession.selectOne("com.lagou.dao.UserMapper.selectOne",user);
            sqlSession.close();
            System.out.println(user);
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
            user.setUsername("username4");
            sqlSession.insert("com.lagou.dao.UserMapper.insert",user);
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
