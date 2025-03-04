package net.mehvahdjukaar.moonlight.api.item;

import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class WoodBasedItem extends BlockTypeBasedItem<WoodType> {

    private final int burnTime;

    public WoodBasedItem(Properties builder, WoodType woodType) {
        this(builder, woodType, 300);
    }

    public WoodBasedItem(Properties builder, int burnTicks) {
        this(builder, WoodTypeRegistry.OAK_TYPE, burnTicks);
    }

    public WoodBasedItem(Properties builder, WoodType woodType, int burnTicks) {
        super(builder, woodType);
        this.burnTime = woodType.canBurn() ? burnTicks : 0;
    }

    @Override
    public final int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }

}
