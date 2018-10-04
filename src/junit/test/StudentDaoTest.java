package junit.test;

import org.junit.Test;
import org.xyc.dao.StudentDao;
import org.xyc.domain.Student;
import org.xyc.exception.StudentNotExistException;

public class StudentDaoTest {

    @Test
    public void testAdd() {
        StudentDao dao = new StudentDao();
        Student s = new Student();
        s.setExamid("345666");
        s.setIdcard("53453");
        s.setName("王五1");
        s.setLocation("重庆");
        s.setGrade(99.9);
        dao.add(s);
    }

    @Test
    public void testFind() {
        StudentDao dao=new StudentDao();
        Student s=dao.find("2220491");
        if (s == null) {
            System.out.println("没有找到该考生，请重新输入。 ");
        } else {
            String examid=s.getExamid();
            System.out.println(s.getGrade()+"");
            System.out.println(s.getIdcard());
            System.out.println(s.getName());
            System.out.println(s.getLocation());
        }


    }

    @Test
    public void testDelete() throws StudentNotExistException {
        StudentDao dao=new StudentDao();
        dao.delete("郭富城");
        System.out.println("成功删除。");
    }
}
