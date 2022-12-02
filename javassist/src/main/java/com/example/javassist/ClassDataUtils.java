package com.example.javassist;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;

/**
 * @author AlexisYin
 */
public class ClassDataUtils {
    //测试在运行时修改字节码数据，Hilt使用时机不一样（编译后打包前）
    public static void modifyClass() {
        try {
            ClassPool pool = ClassPool.getDefault();
            CtClass ctClass = pool.get("com.example.javassist.Student");
            CtClass ptClass = pool.get("com.example.javassist.Person");
            ctClass.setSuperclass(ptClass);
            ctClass.addField(CtField.make("private String name;", ctClass));
            ctClass.addMethod(CtMethod.make("public void setName(String name){this.name = name;}", ctClass));
            ctClass.addMethod(CtMethod.make("public String getName(){return name;}", ctClass));

            Class studentClass = ctClass.toClass();
            Method setNameMethod = studentClass.getMethod("setName", String.class);
            Method getNameMethod = studentClass.getMethod("getName");
            Method getPersonNameMethod = studentClass.getMethod("getPersonName");

            Student student = (Student) studentClass.newInstance();
            setNameMethod.invoke(student, "自定义的名称");
            String name = (String) getNameMethod.invoke(student);
            System.out.println("name=" + name);

            String personName = (String) getPersonNameMethod.invoke(student);
            System.out.println("personName=" + personName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}