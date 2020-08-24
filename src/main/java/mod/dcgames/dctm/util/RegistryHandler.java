package mod.dcgames.dctm.util;

import mod.dcgames.dctm.DCTM;
import mod.dcgames.dctm.armor.DCTMArmorMaterial;
import mod.dcgames.dctm.armor.Mystic.MysticBoots;
import mod.dcgames.dctm.armor.Mystic.MysticHat;
import mod.dcgames.dctm.armor.Mystic.MysticLeggings;
import mod.dcgames.dctm.armor.Mystic.MysticRobes;
import mod.dcgames.dctm.blocks.BlockItemBase;
import mod.dcgames.dctm.blocks.TestBlock;
import mod.dcgames.dctm.blocks.machines.Quarry;
import mod.dcgames.dctm.blocks.machines.T1Generator;
import mod.dcgames.dctm.blocks.machines.QuarryTile;
import mod.dcgames.dctm.blocks.machines.T1GeneratorTile;
import mod.dcgames.dctm.items.ItemBase;
import mod.dcgames.dctm.items.magic.charms.DeathCharm;
import mod.dcgames.dctm.items.magic.charms.HealthCharm;
import mod.dcgames.dctm.items.magic.charms.ThornsCharm;
import mod.dcgames.dctm.tools.DiamondSwaxle;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, DCTM.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, DCTM.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS, DCTM.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILEENTITY = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, DCTM.MOD_ID);


    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILEENTITY.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items
    public static final RegistryObject<Item> T1BATTERY = ITEMS.register("t1_battery", ItemBase::new);

    //Armor
    public static final RegistryObject<ArmorItem> MYSTICHAT = ITEMS.register("mystic_hat", () -> new MysticHat(DCTMArmorMaterial.Mystic, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<ArmorItem> MYSTICROBES = ITEMS.register("mystic_robes", () -> new MysticRobes(DCTMArmorMaterial.Mystic, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<ArmorItem> MYSTICLEGGINGS = ITEMS.register("mystic_leggings", () -> new MysticLeggings(DCTMArmorMaterial.Mystic, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<ArmorItem> MYSTICBOOTS = ITEMS.register("mystic_boots", () -> new MysticBoots(DCTMArmorMaterial.Mystic, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));

    //Charms
    public static final RegistryObject<HealthCharm> HEALTH_CHARM = ITEMS.register("health_charm", HealthCharm::new);
    public static final RegistryObject<DeathCharm> DEATH_CHARM = ITEMS.register("death_charm", DeathCharm::new);
    public static final RegistryObject<ThornsCharm> THORNS_CHARM = ITEMS.register("thorns_charm", ThornsCharm::new);


    //Tools
    public static final RegistryObject<Item> DIAMOND_SWAXLE = ITEMS.register("diamond_swaxle", () -> new DiamondSwaxle());






    //Basic Blocks
    public static final RegistryObject<Block> T1GENERATOR_BLOCK = BLOCKS.register("t1_generator", T1Generator::new);
    public static final RegistryObject<Block> QUARRY_BLOCK = BLOCKS.register("quarry", Quarry::new);
//    public static final RegistryObject<Block> TESTBLOCK = BLOCKS.register("testblock", () -> new TestBlock());


    //Tile Entitys
    public static final RegistryObject<TileEntityType<QuarryTile>> QUARRY_TILE = TILEENTITY.register("quarry",() -> TileEntityType.Builder.create(QuarryTile::new, RegistryHandler.QUARRY_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<T1GeneratorTile>> T1GENERATOR_TILE = TILEENTITY.register("t1_generator",() -> TileEntityType.Builder.create(T1GeneratorTile::new, RegistryHandler.T1GENERATOR_BLOCK.get()).build(null));


    //Block Items
    public static final RegistryObject<Item> T1GENERATOR_BLOCK_ITEM = ITEMS.register("t1_generator", () -> new BlockItemBase(T1GENERATOR_BLOCK.get()));
    public static final RegistryObject<Item> QUARRY_BLOCK_ITEM = ITEMS.register("quarry", () -> new BlockItemBase(QUARRY_BLOCK.get()));

}