package mod.dcgames.dctm.items.magic.charms;

import mod.dcgames.dctm.DCTM;
import mod.dcgames.dctm.util.KeyboardUtil;
import mod.dcgames.dctm.util.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = DCTM.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)

public class ThornsCharm extends Item {
    public ThornsCharm( ) {
        super(new Properties()
        .group(DCTM.DCTMITEMS)
                .maxStackSize(1)
                .maxDamage(600)
        );

    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(KeyboardUtil.isHoldingShift()) {
            tooltip.add(new StringTextComponent("\u00A76" + "Damage taken will be redirected to the attacker" + "\u00A76"));
        } else {
            tooltip.add(new StringTextComponent("\u00A78" + "Hold " + "\u00A7l" + "Shift " + "\u00A7l" + "\u00A78" + "For More Information" + "\u00A78"));
        }
    }

    @SubscribeEvent
    public static void thorns(LivingAttackEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            Entity attacker = event.getSource().getTrueSource();
            PlayerEntity player = (PlayerEntity) event.getEntity();
            Float damage = event.getAmount();
            if ((player.inventory.hasItemStack(new ItemStack(RegistryHandler.THORNS_CHARM.get())))) {
                if (attacker != null) {
                    attacker.attackEntityFrom(DamageSource.causeThornsDamage(player), damage/2);
                    event.setCanceled(true);
                }
            }
        }
    }
}


