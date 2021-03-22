package com.ssist;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class TestTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        ClassPool pool = ClassPool.getDefault();
        try {
            Class<?> rzClazz = Class.forName("org.apache.catalina.connector.Request");
            pool.insertClassPath(new ClassClassPath(rzClazz));
            CtClass ctc = pool.get(className.replace("/","."));
            CtMethod targetMethod = ctc.getDeclaredMethod("list");
            targetMethod.insertBefore("LOG.info(\"-Fuck Before\");System.out.println(\"Fuck stdin before ....\");");
            targetMethod.insertAfter("LOG.info(\"-Fuck After\");System.out.println(\"Fuck stdin after ....\");");
            return ctc.toBytecode();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
