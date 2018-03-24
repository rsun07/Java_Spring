package pers.xiaoming.java_framework;

import org.junit.Assert;
import org.junit.Test;
import pers.xiaoming.java_framework.command.CURDStudentBasic;
import pers.xiaoming.java_framework.entity.Student;
import pers.xiaoming.java_framework.session_factory.Server;

public class HibernateLifeCycleTest {
    @Test
    @SuppressWarnings("UnnecessaryLocalVariable")
    public void testSave() {
        CURDStudentBasic dbOperator = new CURDStudentBasic();

        Student student = Student.builder().name("Mike").age(26).score(78.0).build();

        Student studentBeforeCreate = student;

        Assert.assertNull(student.getId());

        int id = dbOperator.create(Server.getSession(), student);

        Student studentAfterCreate = student;

        // after save() or persist()
        // hibernate life cycle will go from "transient" to "persistent"
        // it will be assigned to the instance
        Assert.assertNotNull(student.getId());
        Assert.assertSame(studentBeforeCreate, studentAfterCreate);
        Assert.assertEquals((Integer) id, student.getId());
    }
}
