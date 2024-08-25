package mahiro76.mahiro.registry;

import mahiro76.mahiro.Mahiro;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MahiroItemGroup {
    public static ItemGroup FIGHTTINGITEM = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Mahiro.MOD_ID, "mahiroitemgroup"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.mahiro.crutch"))
                    .icon(() -> new ItemStack(MahiroItems.CRUTCH))
                    .entries((displayContext, entries) -> entries.add(MahiroItems.CRUTCH)).build());

    public static void registerModItemGroup() {
        Mahiro.LOGGER.debug("registerModItemGroup" + Mahiro.MOD_ID);
    }
}
