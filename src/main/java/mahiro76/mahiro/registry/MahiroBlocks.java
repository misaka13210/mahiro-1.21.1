package mahiro76.mahiro.registry;


import mahiro76.mahiro.Mahiro;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class MahiroBlocks {
    //在下方添加物品

    private static final AbstractBlock.ContextPredicate BIGGERBOX_SUFFOCATES_PREDICATE = (state, world, pos) -> world.getBlockEntity(pos) instanceof ShulkerBoxBlockEntity shulkerBoxBlockEntity
            ? shulkerBoxBlockEntity.suffocates()
            : true;


    //方块物品注册方法（在注册方块的同时注册方块物品）
    public static void registerBlockItems(String id,Block block){
        Item item = Registry.register(Registries.ITEM, Identifier.of(Mahiro.MOD_ID, id), new BlockItem(block, new Item.Settings()));
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

    }

    //方块注册方法
    private static <T extends Block> T register(String id, T block) {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Mahiro.MOD_ID, id), block);
    }

    //添加启动初始化方法
    public static void registerMahiroBlocks() {
        Mahiro.LOGGER.debug("Registering mod BLock for" + Mahiro.MOD_ID);
    }

}
