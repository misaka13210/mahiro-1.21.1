package mahiro76.mahiro.Advancements;

import mahiro76.mahiro.registry.MahiroItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;


public class Advancements implements Consumer<Consumer<AdvancementEntry>> {

    @Override
    public void accept(Consumer<AdvancementEntry> consumer) {
        AdvancementEntry rootAdvancement = Advancement.Builder.create()
                .display(
                        MahiroItems.CRUTCH,
                        Text.literal(String.valueOf(Text.translatable("advancement.mahiro.crutch"))),
                        Text.literal(String.valueOf(Text.translatable("advancement.mahiro.crutch.description"))),
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("got crutch", InventoryChangedCriterion.Conditions.items(MahiroItems.CRUTCH))
                .build(consumer,"mahiro"+"/root");

    }
}
