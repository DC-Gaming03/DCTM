package mod.dcgames.dctm.armor.Mystic;

import mod.dcgames.dctm.DCTM;
import mod.dcgames.dctm.util.KeyboardUtil;
import mod.dcgames.dctm.util.RegistryHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = DCTM.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class MysticRobes extends ArmorItem {
    public MysticRobes(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
    }


    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (KeyboardUtil.isHoldingShift()) {
            tooltip.add(new StringTextComponent("\u00A76" + "Mystical enchantments allow the user to fly for a short time" + "\u00A76"));
        } else {
            tooltip.add(new StringTextComponent("\u00A78" + "Hold " + "\u00A7l" + "Shift " + "\u00A7l" + "\u00A78" + "For More Information" + "\u00A78"));
        }
    }


    int canMysticfly = 0;

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        BlockPos playerpos = player.getPosition();
        if (player.inventory.armorItemInSlot(2).getItem() == RegistryHandler.MYSTICROBES.get()) {

            //Auto Repair
            if (player.experienceTotal >= 1) {
                if (stack.getDamage() > 1) {
                    stack.damageItem(-2, player, null);
                    player.giveExperiencePoints( -1);
                }

            }

            if (player.onGround == true) {
                canMysticfly = 0;
            }
//            if (KeyboardUtil.isHoldingSpace()) {
            if (KeyboardUtil.isJumping() == true) {
//                if (player.isAirBorne == true) {
                    if (canMysticfly <= 100) {
                        player.setMotion(player.getMotion().x, 0.25, player.getMotion().z);
                        canMysticfly++;
                    }
//                }
            }
            if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(0) != null) {
                if (player.inventory.armorItemInSlot(0).getItem() == RegistryHandler.MYSTICBOOTS.get() && player.inventory.armorItemInSlot(1).getItem() == RegistryHandler.MYSTICLEGGINGS.get() && player.inventory.armorItemInSlot(2).getItem() == RegistryHandler.MYSTICROBES.get() && player.inventory.armorItemInSlot(3).getItem() == RegistryHandler.MYSTICHAT.get()) {

                }
            }
        }
    }
}
