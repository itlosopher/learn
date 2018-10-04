package org.xyc.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xyc.domain.Student;
import org.xyc.exception.StudentNotExistException;
import org.xyc.utils.XmlUtils;

public class StudentDao {

    public void add(Student s) {
        try {
            Document document = XmlUtils.getDocument();
            Element student_tag = document.createElement("student");
            student_tag.setAttribute("idcard", s.getIdcard());
            student_tag.setAttribute("examid", s.getExamid());

            Element name = document.createElement("name");
            Element location = document.createElement("location");
            Element grade = document.createElement("grade");
            name.setTextContent(s.getName());
            location.setTextContent(s.getLocation());
            grade.setTextContent(s.getGrade() + "");

            student_tag.appendChild(name);
            student_tag.appendChild(location);
            student_tag.appendChild(grade);

            document.getElementsByTagName("exam").item(0).appendChild(student_tag);

            XmlUtils.write2Xml(document);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Student find(String examid) {
        try {
            Document document=XmlUtils.getDocument();
            NodeList list=document.getElementsByTagName("student");
            for (int i = 0; i < list.getLength(); i++) {
                Element student_tag= (Element) list.item(i);
                if (examid.equals(student_tag.getAttribute("examid"))) {
                    Student s=new Student();
                    s.setExamid(examid);
                    s.setIdcard(student_tag.getAttribute("idcard"));
                    s.setName(student_tag.getElementsByTagName("name").item(0).getTextContent());
                    s.setLocation(student_tag.getElementsByTagName("location").item(0).getTextContent());
                    s.setGrade(Double.parseDouble(student_tag.getElementsByTagName("grade").item(0).getTextContent()));
                    return s;
                }
            }
            return null;
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }

    public void delete(String name) throws StudentNotExistException {
        try {
            Document document = XmlUtils.getDocument();
            NodeList list = document.getElementsByTagName("name");
            for (int i = 0; i < list.getLength(); i++) {
                if (name.equals(list.item(i).getTextContent())) {
                    Element element = (Element) list.item(i).getParentNode();
                    element.getParentNode().removeChild(element);
                    XmlUtils.write2Xml(document);
                    return;
                }
            }
            throw new StudentNotExistException(name + "不存在！");
        } catch (StudentNotExistException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
