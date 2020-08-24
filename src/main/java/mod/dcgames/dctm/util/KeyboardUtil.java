package mod.dcgames.dctm.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

public class KeyboardUtil {
    private static final long MC_Window = Minecraft.getInstance().getMainWindow().getHandle();


    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingShift() {
        return InputMappings.isKeyDown(MC_Window, GLFW.GLFW_KEY_LEFT_SHIFT);
    }

    @OnlyIn(Dist.CLIENT)
    public static boolean isSneaking() {
        return Minecraft.getInstance().gameSettings.keyBindSneak.isKeyDown();
    }

    @OnlyIn(Dist.CLIENT)
    public static boolean isJumping() {
        return Minecraft.getInstance().gameSettings.keyBindJump.isKeyDown();

    }

    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingSprint() {
        return Minecraft.getInstance().gameSettings.keyBindSprint.isKeyDown();
    }


}
