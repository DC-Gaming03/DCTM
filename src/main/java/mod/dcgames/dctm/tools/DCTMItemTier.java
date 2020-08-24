package mod.dcgames.dctm.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum DCTMItemTier implements IItemTier {

    //Tier        Harvest Level, Durability, Attack Damage, enchantability, Repair Material
    diamondswaxle(3, 6244, 8.0f, 7.0f, 10, () -> {
        return Ingredient.fromItems(Items.DIAMOND);
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    DCTMItemTier(int harvestLevel, int maxUses, float efficency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficency = efficency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}
