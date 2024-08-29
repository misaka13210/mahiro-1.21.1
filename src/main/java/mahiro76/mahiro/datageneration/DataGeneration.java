package mahiro76.mahiro.datageneration;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import static java.security.Security.addProvider;

public class DataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        //进度生成器
        generator.createPack().addProvider(MahiroAdvancementsProvider::new);

        //配方生成器
        FabricDataGenerator.Pack pack1 = generator.createPack();
        pack1.addProvider(MahiroRecipeGenerator::new);
    }
}
