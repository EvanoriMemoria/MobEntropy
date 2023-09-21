/*
 * Copyright (c) 2021 juancarloscp52
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package me.juancarloscp52.entropy.mixin;

import me.juancarloscp52.entropy.Variables;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Shadow
    public World world;

    @Shadow
    public abstract double getX();

    @Shadow
    public abstract double getY();

    @Shadow
    public abstract double getZ();

    @Inject(method = "dropStack(Lnet/minecraft/item/ItemStack;F)Lnet/minecraft/entity/ItemEntity;", at = @At("HEAD"), cancellable = true)
    private void randomDrops(ItemStack stack, float yOffset, CallbackInfoReturnable<ItemEntity> cir) {
        if (Variables.noDrops) {
            cir.setReturnValue(null);
            cir.cancel();
        }
        if (Variables.randomDrops || Variables.luckyDrops) {
            if (stack.isEmpty()) {
                cir.setReturnValue(null);
                cir.cancel();
            } else if (this.world.isClient) {
                cir.setReturnValue(null);
                cir.cancel();
            } else {
                ItemEntity itemEntity = new ItemEntity(this.world, this.getX(), this.getY() + (double) yOffset, this.getZ(), computeItemStack(stack));
                itemEntity.setToDefaultPickupDelay();
                this.world.spawnEntity(itemEntity);
                cir.setReturnValue(itemEntity);
                cir.cancel();
            }
            cir.cancel();
        }
    }

    private ItemStack computeItemStack(ItemStack itemStack) {
        if (Variables.luckyDrops) {
            itemStack.setCount(itemStack.getCount() * 5);
            return itemStack;
        } else if (Variables.randomDrops) {
            return new ItemStack(getRandomItem(), itemStack.getCount());
        }
        return null;
    }

    private Item getRandomItem() {
        Item item = Registry.ITEM.getRandom(Random.create()).get().value();
        if (item.toString().equals("debug_stick") || item.toString().contains("spawn_egg") || item.toString().contains("command_block") || item.toString().contains("structure_void") || item.toString().contains("barrier")) {
            item = getRandomItem();
        }
        return item;
    }

}
