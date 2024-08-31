package mahiro76.mahiro.registry;

import mahiro76.mahiro.Mahiro;
import mahiro76.mahiro.registry.item.CrutchItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MahiroItems {
    //添加拐杖
    public static final CrutchItem CRUTCH = registerItem("crutch", new CrutchItem(new Item.Settings()));

    //添加固化剂
    public static final Item HARDENER = registerItem("hardener", new Item(new Item.Settings()));

    /**
     * 若对于MIXIN不理解，可利用此方式使物品可以燃烧（fabric Api），注意，必须写在模组主类中。
    public void onInitialize() {
        //在下方添加可在熔炉中燃烧的物品
        FuelRegistry.INSTANCE.add(MahiroItems.CRUTCH, 300);
    }
     **/

    //添加物品辅助方法
    public static <T extends Item> T registerItem(String name, T item) {
        return Registry.register(Registries.ITEM, Identifier.of(Mahiro.MOD_ID, name), item);
    }

    //添加启动初始化方法类
    public static void registerMahiroItems() {
        Mahiro.LOGGER.debug("Registering mod item for" + Mahiro.MOD_ID);
    }
}

