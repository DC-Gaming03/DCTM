package mod.dcgames.dctm.tools;

import com.google.common.collect.Multimap;
import mod.dcgames.dctm.DCTM;
import mod.dcgames.dctm.util.KeyboardUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.List;
import java.util.Set;

public class DiamondSwaxle extends Item {
    public DiamondSwaxle() {
        super(new Item.Properties().group(ItemGroup.COMBAT)
                .maxDamage(6244).addToolType(ToolType.AXE, 3)
                .addToolType(ToolType.PICKAXE, 3)
                .addToolType(ToolType.SHOVEL, 3));
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(KeyboardUtil.isHoldingShift()) {
            tooltip.add(new StringTextComponent("\u00A76" + "The Swaxle" + "\u00A7o" + "*TM*" + "\u00A7o" + "\u00A76" + "is an all in one tool designed to assist the user in every day tasks" + "\u00A76"));
        } else {
            tooltip.add(new StringTextComponent("\u00A78" + "Hold " + "\u00A7l" + "Shift " + "\u00A7l" + "\u00A78" + "For More Information" + "\u00A78"));
        }
    }



    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
        if (equipmentSlot == EquipmentSlotType.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
                    new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", 7, AttributeModifier.Operation.ADDITION));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
                    new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", -1.0f, AttributeModifier.Operation.ADDITION));
        }
        return multimap;
    }

    @Override
    public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
        return 8f;
    }

    public boolean isEnchantable(ItemStack stack) {
        return stack.getCount() == 1;
    }

    @Override
    public int getItemEnchantability() {
        return 10;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldin, BlockState state, BlockPos pos, LivingEntity livingEntity) {
        stack.damageItem(1, livingEntity, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
        return true;
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem(1, attacker, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
        return true;
    }

}
