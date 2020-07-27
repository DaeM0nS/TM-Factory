package com.lypaka.tmfactory.Utils;

import com.lypaka.tmfactory.Config.ConfigManager;
import com.pixelmonmod.pixelmon.battles.attacks.Attack;
import com.pixelmonmod.pixelmon.enums.EnumType;
import com.pixelmonmod.pixelmon.items.ItemTM;

/*import com.pixelmongenerations.common.battle.attacks.Attack;
import com.pixelmongenerations.common.item.ItemTM;
import com.pixelmongenerations.core.enums.EnumType;*/
import ninja.leaping.configurate.ConfigurationNode;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.common.item.inventory.util.ItemStackUtil;


public class ItemCreator {
    private static ConfigurationNode config;
    private static String itemName;

    public static void giveHM (Player player, String attack) {
        config = ConfigManager.getConfigFile(2);
        String move = attack.replace("[", "").replace("]", "");
        if (getConfigString(config.getNode("HMs")).contains(move)) {
            EnumType type = new Attack(move).getType();;
            int number = config.getNode("HMs", move, "Number").getInt();
            ItemStack disc;
            if (number < 10) {
                itemName = "HM0" + number + ": " + move;
            } else {
                itemName = "HM" + number + ": " + move;
            }
            switch (type) {
                case Bug: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm7"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Normal: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm1"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Psychic: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm17"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Ground: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm15"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Grass: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm10"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Flying: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm6"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Electric: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm55"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Fire: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm3"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Ice: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm4"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Ghost: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm65"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Poison: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm73"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Dragon: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm99"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Fairy: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm87"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Dark: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm58"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Steel: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm30"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Rock: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm22"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Fighting: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm63"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Water: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm36"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
			case Mystery:{
                net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm58"));
                disc = ItemStack.builder()
                        .from(ItemStackUtil.fromNative(is))
                        .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                        .build();
                player.getInventory().offer(disc);
                break;
            }
            }
        }
    }

    public static void giveTM (Player player, String attack) {
        config = ConfigManager.getConfigFile(0);
        String move = attack.replace("[", "").replace("]", "");
        if (getConfigString(config.getNode("TMs")).contains(move)) {
            EnumType type = new Attack(move).getType();
            int number = config.getNode("TMs", move, "Number").getInt();
            ItemStack disc;
            if (number < 10) {
                itemName = "TM0" + number + ": " + move;
            } else {
                itemName = "TM" + number + ": " + move;
            }
            switch (type) {
                case Bug: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm7"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Normal: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm1"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Psychic: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm17"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Ground: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm15"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Grass: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm10"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Flying: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm6"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Electric: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm55"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Fire: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm3"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Ice: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm4"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Ghost: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm65"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Poison: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm73"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Dragon: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm99"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Fairy: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm87"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Dark: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm58"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Steel: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm30"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Rock: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm22"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Fighting: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm63"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Water: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm36"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
    			case Mystery:{
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm58"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
            }
        }
    }

    public static void giveTR (Player player, String attack) {
        config = ConfigManager.getConfigFile(1);
        String move = attack.replace("[", "").replace("]", "");
        //if (config.getNode("TRs").getString().contains(move)) {
        if (getConfigString(config.getNode("TRs")).contains(move)) {
            EnumType type = new Attack(move).getType();
            int number = config.getNode("TRs", move, "Number").getInt();
            if (number < 10) {
                itemName = "TR0" + number + ": " + move;
            } else {
                itemName = "TR" + number + ": " + move;
            }
            ItemStack disc;
            switch (type) {
                case Bug: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr61"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Normal: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr13"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Psychic: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr34"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Ground: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr23"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Grass: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr65"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Flying: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr66"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Electric: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr9"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Fire: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr55"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Ice: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr6"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Ghost: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr33"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Poison: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr54"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Dragon: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr62"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Fairy: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr90"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Dark: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr37"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Steel: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr79"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Rock: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr63"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Fighting: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr7"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
                case Water: {
                    net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tr4"));
                    disc = ItemStack.builder()
                            .from(ItemStackUtil.fromNative(is))
                            .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                            .build();
                    player.getInventory().offer(disc);
                    break;
                }
			case Mystery:{
                net.minecraft.item.ItemStack is = new net.minecraft.item.ItemStack(ItemTM.getByNameOrId("pixelmon:tm58"));
                disc = ItemStack.builder()
                        .from(ItemStackUtil.fromNative(is))
                        .add(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, itemName))
                        .build();
                player.getInventory().offer(disc);
                break;
            }
            }
        }
    }

    private static String getConfigString (ConfigurationNode node) {
        return node.getString();
    }

}
