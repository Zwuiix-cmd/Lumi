package cn.nukkit.registry;

import cn.nukkit.item.Item;
import cn.nukkit.item.customitem.CustomItem;
import cn.nukkit.item.enchantment.*;
import cn.nukkit.item.enchantment.bow.EnchantmentBowFlame;
import cn.nukkit.item.enchantment.bow.EnchantmentBowInfinity;
import cn.nukkit.item.enchantment.bow.EnchantmentBowKnockback;
import cn.nukkit.item.enchantment.bow.EnchantmentBowPower;
import cn.nukkit.item.enchantment.crossbow.EnchantmentCrossbowMultishot;
import cn.nukkit.item.enchantment.crossbow.EnchantmentCrossbowPiercing;
import cn.nukkit.item.enchantment.crossbow.EnchantmentCrossbowQuickCharge;
import cn.nukkit.item.enchantment.damage.EnchantmentDamageAll;
import cn.nukkit.item.enchantment.damage.EnchantmentDamageArthropods;
import cn.nukkit.item.enchantment.damage.EnchantmentDamageSmite;
import cn.nukkit.item.enchantment.loot.EnchantmentLootDigging;
import cn.nukkit.item.enchantment.loot.EnchantmentLootFishing;
import cn.nukkit.item.enchantment.loot.EnchantmentLootWeapon;
import cn.nukkit.item.enchantment.mace.EnchantmentMaceBreach;
import cn.nukkit.item.enchantment.mace.EnchantmentMaceDensity;
import cn.nukkit.item.enchantment.mace.EnchantmentMaceWindBurst;
import cn.nukkit.item.enchantment.protection.*;
import cn.nukkit.item.enchantment.trident.EnchantmentTridentChanneling;
import cn.nukkit.item.enchantment.trident.EnchantmentTridentImpaling;
import cn.nukkit.item.enchantment.trident.EnchantmentTridentLoyalty;
import cn.nukkit.item.enchantment.trident.EnchantmentTridentRiptide;
import cn.nukkit.utils.DynamicClassLoader;
import cn.nukkit.utils.Identifier;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.objectweb.asm.Opcodes.*;

public class EnchantmentRegistry implements IRegistry<Identifier, Enchantment, Enchantment> {

    private static final Object2ObjectOpenHashMap<Integer, Enchantment> ID_TO_ENCHANTMENT = new Object2ObjectOpenHashMap<>();
    private static final Object2ObjectOpenHashMap<Identifier, Enchantment> IDENTIFIER_TO_ENCHANTMENT = new Object2ObjectOpenHashMap<>();
    private static final AtomicBoolean isLoad = new AtomicBoolean(false);
    private static int CUSTOM_BOOK_NUMBER = 1;

    @Override
    public void init() {
        if (isLoad.getAndSet(true)) return;
        register(new Identifier("minecraft", Enchantment.NAME_PROTECTION_ALL), new EnchantmentProtectionAll());
        register(new Identifier("minecraft", Enchantment.NAME_PROTECTION_FIRE), new EnchantmentProtectionFire());
        register(new Identifier("minecraft", Enchantment.NAME_PROTECTION_FALL), new EnchantmentProtectionFall());
        register(new Identifier("minecraft", Enchantment.NAME_PROTECTION_EXPLOSION), new EnchantmentProtectionExplosion());
        register(new Identifier("minecraft", Enchantment.NAME_PROTECTION_PROJECTILE), new EnchantmentProtectionProjectile());
        register(new Identifier("minecraft", Enchantment.NAME_THORNS), new EnchantmentThorns());
        register(new Identifier("minecraft", Enchantment.NAME_WATER_BREATHING), new EnchantmentWaterBreath());
        register(new Identifier("minecraft", Enchantment.NAME_WATER_WORKER), new EnchantmentWaterWorker());
        register(new Identifier("minecraft", Enchantment.NAME_WATER_WALKER), new EnchantmentWaterWalker());
        register(new Identifier("minecraft", Enchantment.NAME_DAMAGE_ALL), new EnchantmentDamageAll());
        register(new Identifier("minecraft", Enchantment.NAME_DAMAGE_SMITE), new EnchantmentDamageSmite());
        register(new Identifier("minecraft", Enchantment.NAME_DAMAGE_ARTHROPODS), new EnchantmentDamageArthropods());
        register(new Identifier("minecraft", Enchantment.NAME_KNOCKBACK), new EnchantmentKnockback());
        register(new Identifier("minecraft", Enchantment.NAME_FIRE_ASPECT), new EnchantmentFireAspect());
        register(new Identifier("minecraft", Enchantment.NAME_LOOTING), new EnchantmentLootWeapon());
        register(new Identifier("minecraft", Enchantment.NAME_EFFICIENCY), new EnchantmentEfficiency());
        register(new Identifier("minecraft", Enchantment.NAME_SILK_TOUCH), new EnchantmentSilkTouch());
        register(new Identifier("minecraft", Enchantment.NAME_DURABILITY), new EnchantmentDurability());
        register(new Identifier("minecraft", Enchantment.NAME_FORTUNE_DIGGING), new EnchantmentLootDigging());
        register(new Identifier("minecraft", Enchantment.NAME_BOW_POWER), new EnchantmentBowPower());
        register(new Identifier("minecraft", Enchantment.NAME_BOW_KNOCKBACK), new EnchantmentBowKnockback());
        register(new Identifier("minecraft", Enchantment.NAME_BOW_FLAME), new EnchantmentBowFlame());
        register(new Identifier("minecraft", Enchantment.NAME_BOW_INFINITY), new EnchantmentBowInfinity());
        register(new Identifier("minecraft", Enchantment.NAME_FORTUNE_FISHING), new EnchantmentLootFishing());
        register(new Identifier("minecraft", Enchantment.NAME_LURE), new EnchantmentLure());
        register(new Identifier("minecraft", Enchantment.NAME_FROST_WALKER), new EnchantmentFrostWalker());
        register(new Identifier("minecraft", Enchantment.NAME_MENDING), new EnchantmentMending());
        register(new Identifier("minecraft", Enchantment.NAME_BINDING_CURSE), new EnchantmentBindingCurse());
        register(new Identifier("minecraft", Enchantment.NAME_VANISHING_CURSE), new EnchantmentVanishingCurse());
        register(new Identifier("minecraft", Enchantment.NAME_TRIDENT_IMPALING), new EnchantmentTridentImpaling());
        register(new Identifier("minecraft", Enchantment.NAME_TRIDENT_LOYALTY), new EnchantmentTridentLoyalty());
        register(new Identifier("minecraft", Enchantment.NAME_TRIDENT_RIPTIDE), new EnchantmentTridentRiptide());
        register(new Identifier("minecraft", Enchantment.NAME_TRIDENT_CHANNELING), new EnchantmentTridentChanneling());
        register(new Identifier("minecraft", Enchantment.NAME_CROSSBOW_MULTISHOT), new EnchantmentCrossbowMultishot());
        register(new Identifier("minecraft", Enchantment.NAME_CROSSBOW_PIERCING), new EnchantmentCrossbowPiercing());
        register(new Identifier("minecraft", Enchantment.NAME_CROSSBOW_QUICK_CHARGE), new EnchantmentCrossbowQuickCharge());
        register(new Identifier("minecraft", Enchantment.NAME_SOUL_SPEED), new EnchantmentSoulSpeed());
        register(new Identifier("minecraft", Enchantment.NAME_SWIFT_SNEAK), new EnchantmentSwiftSneak());
        register(new Identifier("minecraft", Enchantment.NAME_WIND_BURST), new EnchantmentMaceWindBurst());
        register(new Identifier("minecraft", Enchantment.NAME_DENSITY), new EnchantmentMaceDensity());
        register(new Identifier("minecraft", Enchantment.NAME_BREACH), new EnchantmentMaceBreach());
    }

    @Override
    public void register(Identifier id, Enchantment enchantment) {
        if (enchantment.getId() != Enchantment.CUSTOM_ENCHANTMENT_ID) {
            ID_TO_ENCHANTMENT.put(enchantment.getId(), enchantment);
        }
        IDENTIFIER_TO_ENCHANTMENT.put(id, enchantment);
    }

    public void registerCustom(Enchantment enchantment) {
        registerCustom(enchantment, true);
    }

    public void registerCustom(Enchantment enchantment, boolean registerBook) {
        Objects.requireNonNull(enchantment, "Enchantment cannot be null");
        Objects.requireNonNull(enchantment.getIdentifier(), "Identifier cannot be null");

        if (IDENTIFIER_TO_ENCHANTMENT.containsKey(enchantment.getIdentifier())) {
            throw new RegisterException("Enchantment with identifier already exists");
        }
        if (enchantment.getIdentifier().getNamespace().equals(Identifier.DEFAULT_NAMESPACE)) {
            throw new RegisterException("You cannot use the minecraft namespace:");
        }

        if (registerBook) {
            registerCustomEnchantBook(enchantment);
        }

        register(enchantment.getIdentifier(), enchantment);
    }

    private void registerCustomEnchantBook(Enchantment enchantment) {
        var identifier = enchantment.getIdentifier();
        assert identifier != null;
        for (int i = 1; i <= enchantment.getMaxLevel(); i++) {
            var name = "§e%item.enchanted_book.name\n§7" + enchantment.getName() + " " + Enchantment.getLevelString(i);
            ClassWriter classWriter = new ClassWriter(0);
            MethodVisitor methodVisitor;
            String className = "CustomBookEnchanted" + CUSTOM_BOOK_NUMBER;
            classWriter.visit(V17, ACC_PUBLIC | ACC_SUPER, "cn/nukkit/item/customitem/" + className, null, "cn/nukkit/item/customitem/ItemCustomBookEnchanted", null);
            classWriter.visitSource(className + ".java", null);
            {
                methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
                methodVisitor.visitCode();
                Label label0 = new Label();
                methodVisitor.visitLabel(label0);
                methodVisitor.visitLineNumber(6, label0);
                methodVisitor.visitVarInsn(ALOAD, 0);
                methodVisitor.visitLdcInsn(identifier.toString());
                methodVisitor.visitLdcInsn(name);
                methodVisitor.visitMethodInsn(INVOKESPECIAL, "cn/nukkit/item/customitem/ItemCustomBookEnchanted", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", false);
                Label label1 = new Label();
                methodVisitor.visitLabel(label1);
                methodVisitor.visitLineNumber(7, label1);
                methodVisitor.visitInsn(RETURN);
                Label label2 = new Label();
                methodVisitor.visitLabel(label2);
                methodVisitor.visitLocalVariable("this", "Lcn/nukkit/item/customitem/" + className + ";", null, label0, label2, 0);
                methodVisitor.visitMaxs(3, 1);
                methodVisitor.visitEnd();
            }
            classWriter.visitEnd();
            CUSTOM_BOOK_NUMBER++;
            try {
                @SuppressWarnings("unchecked")
                Class<? extends CustomItem> clazz = (Class<? extends CustomItem>) new DynamicClassLoader().defineClass("cn.nukkit.item.customitem." + className, classWriter.toByteArray());
                Item.registerCustomItem(clazz).assertOK();
            } catch (AssertionError e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Enchantment get(Identifier key) {
        return IDENTIFIER_TO_ENCHANTMENT.get(key);
    }

    public Enchantment get(int id) {
        return ID_TO_ENCHANTMENT.get(id);
    }

    public Map<Integer, Enchantment> getIdToEnchantment() {
        return Collections.unmodifiableMap(ID_TO_ENCHANTMENT);
    }

    public Map<Identifier, Enchantment> getIdentifierToEnchantment() {
        return Collections.unmodifiableMap(IDENTIFIER_TO_ENCHANTMENT);
    }

    @Override
    public void trim() {
        ID_TO_ENCHANTMENT.trim();
        IDENTIFIER_TO_ENCHANTMENT.trim();
    }

    @Override
    public void reload() {
        ID_TO_ENCHANTMENT.clear();
        IDENTIFIER_TO_ENCHANTMENT.clear();
        init();
    }
}
