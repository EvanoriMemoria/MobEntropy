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

package me.juancarloscp52.entropy.events;

import me.juancarloscp52.entropy.Entropy;
import me.juancarloscp52.entropy.events.db.*;

import java.util.*;
import java.util.function.Supplier;


public class EventRegistry {
    private static int last_index = 0;
    private static final Random random = new Random();
    //Store constructors for all Entropy Events.
    public static HashMap<String, Supplier<Event>> entropyEvents;

    public static void register() {

        entropyEvents = new HashMap<>();
        entropyEvents.put("ChickenRainEvent", ChickenRainEvent::new);
        entropyEvents.put("HerobrineEvent", HerobrineEvent::new);
        entropyEvents.put("IntenseThunderStormEvent", IntenseThunderStormEvent::new);
        entropyEvents.put("LowGravityEvent", LowGravityEvent::new);
        entropyEvents.put("SlipperyEvent", SlipperyEvent::new);
        entropyEvents.put("PhantomEvent", PhantomEvent::new);
        entropyEvents.put("RandomCreeperEvent", RandomCreeperEvent::new);
        entropyEvents.put("SlimeEvent", SlimeEvent::new);
        entropyEvents.put("HorseEvent", HorseEvent::new);
        entropyEvents.put("VexAttackEvent", VexAttackEvent::new);
        entropyEvents.put("FlipMobsEvent", FlipMobsEvent::new);
        entropyEvents.put("BeeEvent", BeeEvent::new);
        entropyEvents.put("SilverfishEvent", SilverfishEvent::new);
        entropyEvents.put("BlazeEvent", BlazeEvent::new);
        entropyEvents.put("EndermiteEvent", EndermiteEvent::new);
        entropyEvents.put("SlimePyramidEvent", SlimePyramidEvent::new);
    }

    public static Event getRandomDifferentEvent(List<Event> events){

        ArrayList<String> eventKeys = new ArrayList<>(entropyEvents.keySet());
        eventKeys.removeAll(Entropy.getInstance().settings.disabledEvents);

        Set<String> ignoreCurrentEvents = new HashSet<>();
        events.forEach(event -> ignoreCurrentEvents.add(event.getClass().getSimpleName()));
        eventKeys.removeAll(ignoreCurrentEvents);

        Set<String> ignoreTypes = new HashSet<>();
        events.forEach(event -> {
            if(event.getTickCount()>0 && !event.hasEnded() && !event.type().equalsIgnoreCase("none"))
                ignoreTypes.add(event.type().toLowerCase());
        });
        Set<String> ignoreEventsByType = new HashSet<>();
        eventKeys.forEach(eventName -> {
            if(ignoreTypes.contains(entropyEvents.get(eventName).get().type().toLowerCase())){
                ignoreEventsByType.add(eventName);
            }
        });
        eventKeys.removeAll(ignoreEventsByType);

        if(eventKeys.size() == 0) return null;

        int index = random.nextInt(eventKeys.size());
        String newEventName = eventKeys.get(index);
        return entropyEvents.get(newEventName).get();
    }

    public static Event get(String eventName) {
        Supplier<Event> newEvent = entropyEvents.get(eventName);
        if (newEvent != null)
            return newEvent.get();
        else
            return null;
    }

    public static Event getNextEventOrdered(){
        Supplier<Event> newEvent = entropyEvents.get(entropyEvents.keySet().stream().sorted().toList().get(last_index));
        last_index = (last_index + 1) % entropyEvents.size();
        if (newEvent != null)
            return newEvent.get();
        else
            return null;
    }

    public static String getEventId(Event event) {
        String[] name = event.getClass().getName().split("\\.");
        return name[name.length - 1];
    }

    public static String getTranslationKey(Event event) {
        return "entropy.events." + getEventId(event);
    }

    public static String getTranslationKey(String eventID) {
        return "entropy.events." + eventID;
    }
}
