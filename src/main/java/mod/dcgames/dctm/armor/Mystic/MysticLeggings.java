package mod.dcgames.dctm.armor.Mystic;

import mod.dcgames.dctm.util.KeyboardUtil;
import mod.dcgames.dctm.util.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class MysticLeggings extends ArmorItem {
    public MysticLeggings(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (KeyboardUtil.isHoldingShift()) {
            tooltip.add(new StringTextComponent("\u00A76" + "Mystical enchantments give the user enhanced mobility while running" + "\u00A76"));
        } else {
            tooltip.add(new StringTextComponent("\u00A78" + "Hold " + "\u00A7l" + "Shift " + "\u00A7l" + "\u00A78" + "For More Information" + "\u00A78"));
        }
    }



    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        BlockPos playerpos = player.getPosition();
        if (player.inventory.armorItemInSlot(1).getItem() == RegistryHandler.MYSTICLEGGINGS.get()) {

            //Auto Repair
            if (player.experienceTotal >= 1) {
                if (stack.getDamage() > 1) {
                    stack.damageItem(-2, player, null);
                    player.giveExperiencePoints( -1);
                }

            }



            if (player.isSprinting() == true) {
                player.addPotionEffect(new EffectInstance(Effects.SPEED, 1 * 10, 0, false, false));
//                player.addPotionEffect(new EffectInstance(Effects.SPEED, 1 * 10));
                player.stepHeight = 1.25F;
            }
            else if (player.isSprinting() == false){
                player.stepHeight = .6F;
            }
                    if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(0) != null) {
                        if (player.inventory.armorItemInSlot(0).getItem() == RegistryHandler.MYSTICBOOTS.get() && player.inventory.armorItemInSlot(1).getItem() == RegistryHandler.MYSTICLEGGINGS.get() && player.inventory.armorItemInSlot(2).getItem() == RegistryHandler.MYSTICROBES.get() && player.inventory.armorItemInSlot(3).getItem() == RegistryHandler.MYSTICHAT.get()) {
                    }
            }
        }
    }

}
