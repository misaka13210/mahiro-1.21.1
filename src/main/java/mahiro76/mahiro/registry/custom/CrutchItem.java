package mahiro76.mahiro.registry.custom;

import mahiro76.mahiro.Mahiro;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class CrutchItem extends Item {

    public CrutchItem(Settings settings) {
        super(settings.component(DataComponentTypes.ATTRIBUTE_MODIFIERS, knockbackAttribute()));
    }

    // 添加击退属性，这里必须为静态方法，因为它在完成父类构造前被调用
    private static AttributeModifiersComponent knockbackAttribute() {
        // 这里的标识符是干什么用的？
        Identifier id = Identifier.of(Mahiro.MOD_ID, "crutch_knockback");
        // 拐杖物品的击退属性修改器，1是击退属性的值
        EntityAttributeModifier modifier = new EntityAttributeModifier(id, 5, EntityAttributeModifier.Operation.ADD_VALUE);
        // 物品的所有添加的属性，在这里，只添加了击退一种属性
        List<AttributeModifiersComponent.Entry> entries = List.of(new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, modifier, AttributeModifierSlot.MAINHAND));
        return new AttributeModifiersComponent(entries, true);
    }
    
    //覆写方法，添加物品提示文本
    @Override
    public void appendTooltip(ItemStack itemStack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.mahiro.crutch.tips"));
    }
}
