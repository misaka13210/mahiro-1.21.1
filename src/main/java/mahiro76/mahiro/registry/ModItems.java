package mahiro76.mahiro.registry;

import mahiro76.mahiro.mahiro;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    //添加拐杖
    public static final Item CRUTCH =registerItem("crutch",
            new Item(new Item.Settings()));

    //添加固化剂
    public static final Item HARDENER = registerItem("hardener",
            new Item(new Item.Settings()));

    //添加物品辅助方法
    public static Item registerItem(String name, Item item, RegistryKey<ItemGroup>...itemGroups){
        Item registeredItem = Registry.register(Registries.ITEM,Identifier.of(mahiro.MOD_ID,name),item);
        for (RegistryKey<ItemGroup> itemGroup:itemGroups){
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries->entries.add(registeredItem));
        }
        return registeredItem;
    }
    //添加启动初始化方法类
    public static void registerModItems(){
        mahiro.LOGGER.debug("Registering mod item for"+ mahiro.MOD_ID);
    }
}

