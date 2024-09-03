package mahiro76.mahiro.registry;

import mahiro76.mahiro.Mahiro;
import mahiro76.mahiro.registry.item.CrutchItem;
import mahiro76.mahiro.registry.item.HardenerItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MahiroItems {
    //添加拐杖
    public static final CrutchItem CRUTCH = registerItem("crutch", new CrutchItem(new Item.Settings()));

    //添加固化剂
    public static final HardenerItem HARDENER = registerItem("hardener", new HardenerItem(new Item.Settings()));



    //添加物品辅助方法
    public static <T extends Item> T registerItem(String name, T item) {
        return Registry.register(Registries.ITEM, Identifier.of(Mahiro.MOD_ID, name), item);
    }

    //启动初始化方法
    public static void registerMahiroItems() {
        Mahiro.LOGGER.debug("Registering mod item for" + Mahiro.MOD_ID);
    }
}

