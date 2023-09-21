/**
 * @author Kanawanagasaki
 */

package me.juancarloscp52.entropy.events.db;

import me.juancarloscp52.entropy.Entropy;
import me.juancarloscp52.entropy.events.AbstractInstantEvent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class InvisiblePlayerEvent extends AbstractInstantEvent {

    @Override
    public void init() {
        for (var serverPlayerEntity : Entropy.getInstance().eventHandler.getActivePlayers()) {
            var effect = new StatusEffectInstance(StatusEffects.INVISIBILITY,
                    Entropy.getInstance().settings.baseEventDuration, 1, true, false);
            serverPlayerEntity.addStatusEffect(effect);
        }
    }

    @Override
    public String type() {
        return "invisibility";
    }

}
