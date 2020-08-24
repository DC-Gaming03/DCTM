package mod.dcgames.dctm.armor.Mystic;

import mod.dcgames.dctm.DCTM;
import mod.dcgames.dctm.armor.DCTMArmorMaterial;
import mod.dcgames.dctm.util.KeyboardUtil;
import mod.dcgames.dctm.util.RegistryHandler;
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
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = DCTM.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class MysticHat extends ArmorItem {
    public MysticHat(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(DCTMArmorMaterial.Mystic, slot, builder);
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (KeyboardUtil.isHoldingShift()) {
            tooltip.add(new StringTextComponent("\u00A76" + "Mystical enchantments improve the users vision while in the dark" + "\u00A76"));
        } else {
            tooltip.add(new StringTextComponent("\u00A78" + "Hold " + "\u00A7l" + "Shift " + "\u00A7l" + "\u00A78" + "For More Information" + "\u00A78"));
        }
    }


    int tick = 0;

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        BlockPos playerpos = player.getPosition();
        if (player.inventory.armorItemInSlot(3).getItem() == RegistryHandler.MYSTICHAT.get()) {

            //Auto Repair
            if (player.experienceTotal >= 1) {
                if (stack.getDamage() > 1) {
                    stack.damageItem(-2, player, null);
                    player.giveExperiencePoints( -1);
                }

            }


            if (player.dimension.getId() != -1) {
                if (world.getLight(playerpos) <= 4) {
                    player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 1 * 5));
                    if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(0) != null) {
                        if (player.inventory.armorItemInSlot(0).getItem() == RegistryHandler.MYSTICBOOTS.get() && player.inventory.armorItemInSlot(1).getItem() == RegistryHandler.MYSTICLEGGINGS.get() && player.inventory.armorItemInSlot(2).getItem() == RegistryHandler.MYSTICROBES.get() && player.inventory.armorItemInSlot(3).getItem() == RegistryHandler.MYSTICHAT.get()) {
                        }
                    }
                }
            }
        }
    }
}
