package mahiro76.mahiro.registry.custom;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Crutch extends Item {

    public Crutch(Settings settings) {
        super(settings);
    }

    public boolean postHit(ItemStack stack, PlayerEntity target, PlayerEntity attacker) {
        target.addVelocity(0.0D, 0.5D, 0.0D); // 添加击退效果
        return super.postHit(stack, target, attacker);
    }
}


