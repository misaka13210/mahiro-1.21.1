package mahiro76.mahiro.datageneration;

import mahiro76.mahiro.registry.MahiroItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

/**
 * 配方生成器
 *
 * @see <a href="https://fabricmc.net/wiki/zh_cn:tutorial:datagen_recipe">配方生成</a>
 */
public class MahiroRecipeGenerator extends FabricRecipeProvider {
    public MahiroRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    /**
     * 生成合成配方
     *
     * @see VanillaRecipeProvider
     * @see RecipeProvider
     */
    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, MahiroItems.CRUTCH)
                .pattern("S  ")
                .pattern("S  ")
                .pattern("   ")
                .input('S', Items.STICK)
                .criterion(hasItem(Items.STICK), RecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }

    private static String hasItem(Item item) {
        return "has_" + Registries.ITEM.getId(item);
    }
}
