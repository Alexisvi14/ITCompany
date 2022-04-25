package com.solvd.reflections;

import com.solvd.enums.Speciality;
import com.solvd.staff.Developer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionImp {

    private static final Logger LOGGER = LogManager.getLogger(ReflectionImp.class);

    public static void main(String[] args) {

        // Class c1 = Developer.class.getName();
        LOGGER.info("The super class of the " + Developer.class.getName() + " class is: " + Developer.class.getSuperclass());
        //Method[] m = c1.getMethods();

        Class c1 = new Developer("Alexis", ";", 1, Speciality.DB).getClass();
        Method[] m = c1.getMethods();
        Field[] m2 = c1.getFields();

        LOGGER.info("There are " + m.length + " methods in this class");

        for (int i = 0; i < m.length; i++) {
            LOGGER.info(m[i]);
        }

        LOGGER.info("There are " + m2.length + " fields in this class");
        for (int i = 0; i < m2.length; i++) {
            LOGGER.info(m2[i]);
        }
    }
}
