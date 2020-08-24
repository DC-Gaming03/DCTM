package mod.dcgames.dctm.items;

import mod.dcgames.dctm.DCTM;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = DCTM.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PersonalForcefield extends Item {
    public PersonalForcefield() {
        super(new Item.Properties().group(DCTM.DCTMITEMS));
    }

    //@SubscribeEvent
    //public static void () {
    //}
}
