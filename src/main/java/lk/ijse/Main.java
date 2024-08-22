package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.embed.FullName;
import lk.ijse.entity.Student;
import lk.ijse.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
//student
        FullName fullName = new FullName("Thathshila","Ashanganie");
        Student student = new Student();
        student.setId(1);
        student.setName(fullName);
        student.setAddress("Matara");
        //open transaction
       Transaction transaction =  session.beginTransaction();
                session.save(student);
              //  session.update(student);
        //delete
        session.delete(student);
        //get
        Student student1 =session.get(Student.class, 1);
        System.out.println(student1);

        transaction.commit();

        //teacher
        Session session2 = FactoryConfiguration.getInstance().getSession();
        Transaction transaction2 =  session.beginTransaction();
        FullName Name = new FullName("Hansanie","Chasunika");
        Teacher teacher = new Teacher();
        teacher.setId(2);
        teacher.setName(Name);
        teacher.setAddress("Matara");

        session2.save(teacher);
        session2.update(teacher);
        session2.delete(teacher);

        //another table
        transaction.commit();
                session.close();
    }
}
