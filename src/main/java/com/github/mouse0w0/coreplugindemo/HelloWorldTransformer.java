package com.github.mouse0w0.coreplugindemo;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.*;
import spigotlauncher.api.plugin.Transformer;

import java.util.List;

import static org.objectweb.asm.Opcodes.*;

public class HelloWorldTransformer implements Transformer {
    @Override
    public byte[] transform(String s, byte[] bytes) {
        if(s.equals("org.bukkit.craftbukkit.Main")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for(MethodNode mn : (List<MethodNode>)cn.methods) {
                if(mn.name.equals("main")) {
                    mn.instructions.insert(new MethodInsnNode(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false));
                    mn.instructions.insert(new LdcInsnNode("Hello World!"));
                    mn.instructions.insert(new FieldInsnNode(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
                    break;
                }
            }
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            cn.accept(cw);
            return cw.toByteArray();
        }
        return bytes;
    }
}
