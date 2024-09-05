package mahiro76.mahiro.registry;


import mahiro76.mahiro.Mahiro;
import mahiro76.mahiro.registry.block.BiggerBoxBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;


public class MahiroBlocks {
    //在下方添加物品
    public static final Block BIGGERBOX= register("shulker_box", createShulkerBoxBlock(null, MapColor.PURPLE));
    public static final Block WHITE_BIGGERBOX= register("white_shulker_box", createShulkerBoxBlock(DyeColor.WHITE, MapColor.WHITE));
    public static final Block ORANGE_BIGGERBOX = register("orange_shulker_box", createShulkerBoxBlock(DyeColor.ORANGE, MapColor.ORANGE));
    public static final Block MAGENTA_BIGGERBOX = register("magenta_shulker_box", createShulkerBoxBlock(DyeColor.MAGENTA, MapColor.MAGENTA));
    public static final Block LIGHT_BLUE_BIGGERBOX = register("light_blue_shulker_box", createShulkerBoxBlock(DyeColor.LIGHT_BLUE, MapColor.LIGHT_BLUE));
    public static final Block YELLOW_BIGGERBOX = register("yellow_shulker_box", createShulkerBoxBlock(DyeColor.YELLOW, MapColor.YELLOW));
    public static final Block LIME_BIGGERBOX  = register("lime_shulker_box", createShulkerBoxBlock(DyeColor.LIME, MapColor.LIME));
    public static final Block PINK_BIGGERBOX = register("pink_shulker_box", createShulkerBoxBlock(DyeColor.PINK, MapColor.PINK));
    public static final Block GRAY_BIGGERBOX = register("gray_shulker_box", createShulkerBoxBlock(DyeColor.GRAY, MapColor.GRAY));
    public static final Block LIGHT_GRAY_BIGGERBOX = register("light_gray_shulker_box", createShulkerBoxBlock(DyeColor.LIGHT_GRAY, MapColor.LIGHT_GRAY));
    public static final Block CYAN_BIGGERBOX = register("cyan_shulker_box", createShulkerBoxBlock(DyeColor.CYAN, MapColor.CYAN));
    public static final Block PURPLE_BIGGERBOX = register("purple_shulker_box", createShulkerBoxBlock(DyeColor.PURPLE, MapColor.TERRACOTTA_PURPLE));
    public static final Block BLUE_BIGGERBOX = register("blue_shulker_box", createShulkerBoxBlock(DyeColor.BLUE, MapColor.BLUE));
    public static final Block BROWN_BIGGERBOX = register("brown_shulker_box", createShulkerBoxBlock(DyeColor.BROWN, MapColor.BROWN));
    public static final Block GREEN_BIGGERBOX = register("green_shulker_box", createShulkerBoxBlock(DyeColor.GREEN, MapColor.GREEN));
    public static final Block RED_BIGGERBOX = register("red_shulker_box", createShulkerBoxBlock(DyeColor.RED, MapColor.RED));
    public static final Block BLACK_BIGGERBOX = register("black_shulker_box", createShulkerBoxBlock(DyeColor.BLACK, MapColor.BLACK));


    private static final AbstractBlock.ContextPredicate BIGGERBOX_SUFFOCATES_PREDICATE = (state, world, pos) -> world.getBlockEntity(pos) instanceof ShulkerBoxBlockEntity shulkerBoxBlockEntity
            ? shulkerBoxBlockEntity.suffocates()
            : true;

    private static Block createShulkerBoxBlock(@Nullable DyeColor color, MapColor mapColor) {
        return new ShulkerBoxBlock(
                color,
                AbstractBlock.Settings.create()
                        .mapColor(mapColor)
                        .solid()
                        .strength(2.0F)
                        .dynamicBounds()
                        .nonOpaque()
                        .suffocates(BIGGERBOX_SUFFOCATES_PREDICATE)
                        .blockVision(BIGGERBOX_SUFFOCATES_PREDICATE)
                        .pistonBehavior(PistonBehavior.DESTROY)
        );
    }

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
