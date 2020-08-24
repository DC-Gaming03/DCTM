package mod.dcgames.dctm.items.magic.charms;

import mod.dcgames.dctm.DCTM;
import mod.dcgames.dctm.util.KeyboardUtil;
import mod.dcgames.dctm.util.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;


@Mod.EventBusSubscriber(modid = DCTM.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)

public class DeathCharm extends Item {
    public DeathCharm( ) {
        super(new Properties()
        .group(DCTM.DCTMITEMS)
                .maxStackSize(1)
        );

    }


    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(KeyboardUtil.isHoldingShift()) {
            tooltip.add(new StringTextComponent("\u00A76" + "When the user dies the charm will restore the user consuming the charm in the process" + "\u00A76"));
        } else {
            tooltip.add(new StringTextComponent("\u00A78" + "Hold " + "\u00A7l" + "Shift " + "\u00A7l" + "\u00A78" + "For More Information" + "\u00A78"));
        }
    }

    @SubscribeEvent
    public static void ondeath(LivingDeathEvent event) {
        LivingEntity entity = event.getEntityLiving();
        World world = entity.getEntityWorld();
        if (event.isCancelable()) {
            if (!world.isRemote) {
                if (entity instanceof PlayerEntity) {
                    if (((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(RegistryHandler.DEATH_CHARM.get()))) {
                        entity.setHealth(20F);
                        event.setCanceled(true);
                        entity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 30*20));
                        entity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 30*20, 1));
                        entity.addPotionEffect(new EffectInstance(Effects.REGENERATION, 30*20, 1));

                    }
                }
            }
        }
    }


}


