package org.xyc.UI;

import org.xyc.dao.StudentDao;
import org.xyc.domain.Student;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println("添加学生：（a）  删除学生：（b）  查找学生：（c））");
            System.out.print("请输入操作类型：");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String type=br.readLine();
            if("a".equals(type)){
                System.out.print("请输入学生姓名：");
                String name=br.readLine();
                System.out.print("请输入学生身份证号码：");
                String idcard=br.readLine();
                System.out.print("请输入学生准考证号：");
                String examid=br.readLine();
                System.out.print("请输入学生地域：");
                String location=br.readLine();
                System.out.print("请输入学生成绩：");
                String grade=br.readLine();

                StudentDao dao=new StudentDao();
                Student s=new Student();
                s.setGrade(Double.parseDouble(grade));
                s.setLocation(location);
                s.setName(name);
                s.setIdcard(idcard);
                s.setExamid(examid);

                dao.add(s);
                System.out.println("已成功添加学生"+name);

            }else if ("b".equals(type)){
                System.out.print("请输入要删除的学生姓名：");
                String name=br.readLine();
                StudentDao dao=new StudentDao();
                dao.delete(name);
                System.out.println("删除成功。");

            }else if("c".equals(type)){
                System.out.print("请输入准考证号码：");
                String examid=br.readLine();
                StudentDao dao=new StudentDao();
                Student s=dao.find(examid);

                System.out.println("考生姓名："+s.getName());
                System.out.println("身份证号："+s.getIdcard());
                System.out.println("准考证号："+s.getExamid());
                System.out.println("考生地域："+s.getLocation());
                System.out.println("考试成绩："+s.getGrade());

            }else{
                System.out.println("请输入正确的操作选项！");
            }

        } catch (Exception e) {
            System.out.println("对不起，我出错了！");
            e.printStackTrace();
        }


    }


}


