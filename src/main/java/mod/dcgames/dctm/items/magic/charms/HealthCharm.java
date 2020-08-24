package mod.dcgames.dctm.items.magic.charms;

import mod.dcgames.dctm.DCTM;
import mod.dcgames.dctm.util.RegistryHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DCTM.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)

public class HealthCharm extends Item {
    public HealthCharm( ) {
        super(new Item.Properties()
        .group(DCTM.DCTMITEMS)
                .maxStackSize(1)
        );
//        setRegistryName("health_charm");

    }

    @SubscribeEvent
    public static void invtick(TickEvent.PlayerTickEvent event) {
        if (event.player.inventory.hasItemStack(new ItemStack(RegistryHandler.HEALTH_CHARM.get()))) {
            if (event.player.getActivePotionEffect(Effects.HEALTH_BOOST) == null){
                event.player.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 5 * 20, 1));
            }
            else {
//                event.player.potio
            }
            }
        }
}


