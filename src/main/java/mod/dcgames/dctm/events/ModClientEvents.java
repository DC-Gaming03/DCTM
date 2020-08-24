package mod.dcgames.dctm.events;

import mod.dcgames.dctm.DCTM;
import mod.dcgames.dctm.util.RegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DCTM.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)

public class ModClientEvents {



    /*
    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {
        if (event.player.inventory.hasItemStack(new ItemStack(RegistryHandler.HEALTH_CHARM.get()))) {

        }
    }

    @SubscribeEvent
    public void deathCharmDeath() {

    }


    @SubscribeEvent
    public static void damageCharmTakesDamage(LivingDamageEvent event) {
        LivingEntity entity = event.getEntityLiving();
        float dmg = event.getAmount();
        DamageSource attacker = event.getSource();
        DCTM.LOGGER.info("Damage Taken");
        if (attacker == DamageSource.causePlayerDamage()) {
        }
    }


    @SubscribeEvent
    public static void attackevent(AttackEntityEvent event) {
        if (event.getEntityLiving().getHeldItemMainhand().getItem() == RegistryHandler.T1BATTERY.get()) {
            if (event.getTarget().isAlive()) {
                PlayerEntity player = event.getPlayer();
                LivingEntity target = (LivingEntity) event.getTarget();
                target.addPotionEffect(new EffectInstance(Effects.POISON, 10*20));
                target.setGlowing(true);

                if (!event.getPlayer().getEntityWorld().isRemote) {
                    String msg = TextFormatting.GREEN + "They are not feeling well";
                    player.sendMessage(new StringTextComponent(msg));

                }
            }
        }
    }
    */


}
