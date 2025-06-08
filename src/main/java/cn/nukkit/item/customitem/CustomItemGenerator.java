package cn.nukkit.item.customitem;

import cn.nukkit.plugin.Plugin;
import lombok.Getter;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.HashMap;

public class CustomItemGenerator {

    public static HashMap<Class<?>, ItemCustomSpecification> specifications = new HashMap<>();

    @Getter
    private static final CustomItemClassLoader loader = new CustomItemClassLoader();

    public static <E extends ItemCustomSpecification, T extends CustomItem<E>> Class<? extends T> generateCustomItem(Plugin plugin, Class<T> item, E specification) {
        loader.addClassLoader(plugin.getPluginClassLoader());
        try {
            String className = "cn.nukkit.item.customitem." + item.getSimpleName() + "Generated$" + specification.getId().replace(".", "_").replace(":", "_");
            String classPath = className.replace('.', '/');

            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
            MethodVisitor mv;

            cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER, classPath, null, item.getName().replace('.', '/'), null);

            mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitLdcInsn(specification.getId());
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, item.getName().replace('.', '/'), "<init>", "(Ljava/lang/String;)V", false);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(2, 1);
            mv.visitEnd();

            Class<? extends T> clazz = (Class<? extends T>) loader.defineClass(classPath.replace("/", "."), cw.toByteArray());
            specifications.put(clazz, specification);
            return clazz;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}