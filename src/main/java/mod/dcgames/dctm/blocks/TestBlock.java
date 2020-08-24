package mod.dcgames.dctm.blocks;

import mod.dcgames.dctm.DCTM;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DCTM.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)

public class TestBlock extends Block {
    public TestBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(2.5f, 6.0f)
                .sound(SoundType.METAL)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
        );
    }


    @SubscribeEvent
    public static void blockBroken(BlockEvent.BreakEvent event) {
        PlayerEntity player = event.getPlayer();
        World world = (World) event.getWorld();
        BlockState blockState = event.getState();
        if (event.getState() == blockState) {
            player.setHealth(10F);
        }

    }
}
