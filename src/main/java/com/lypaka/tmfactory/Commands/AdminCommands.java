package com.lypaka.tmfactory.Commands;

import com.lypaka.tmfactory.Config.ConfigManager;
import com.lypaka.tmfactory.TMFactory;
import com.lypaka.tmfactory.Utils.ItemCreator;
import com.pixelmonmod.pixelmon.battles.attacks.Attack;

import ninja.leaping.configurate.ConfigurationNode;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class AdminCommands {

    private static ConfigurationNode config;

    public static void registerCommand() {

        CommandSpec makeTM = CommandSpec.builder()
                .arguments(
                        GenericArguments.integer(Text.of("number")),
                        GenericArguments.remainingJoinedStrings(Text.of("move"))
                )
                .executor((sender, context) -> {

                    config = ConfigManager.getConfigFile(0);

                    String move = context.getOne("move").get().toString();
                    int num = (int) context.getOne("number").get();

                    if (Attack.hasAttack(move)) {
                        if (config.getNode("TMs", move).isVirtual()) {
                            String moveType = new Attack(move).getType().getName();
                            //getAttackBase(move).get().attackType.getName();
                            config.getNode("TMs", move, "Type").setValue(moveType);

                            config.getNode("TMs", move, "Number").setValue(num);
                            ConfigManager.save();
                            sender.sendMessage(Text.of(TextColors.GREEN, "Successfully created a new TM of the move " + move + "!"));
                        } else {
                            sender.sendMessage(Text.of(TextColors.RED, "A move by this name already exists in the config!"));
                        }
                    }



                    return CommandResult.success();

                })
                .build();


        CommandSpec makeTR = CommandSpec.builder()
                .arguments(
                        GenericArguments.integer(Text.of("number")),
                        GenericArguments.remainingJoinedStrings(Text.of("move"))
                )
                .executor((sender, context) -> {

                    config = ConfigManager.getConfigFile(1);

                    String move = context.getOne("move").get().toString();
                    int num = (int) context.getOne("number").get();

                    if (Attack.hasAttack(move)) {
                        if (config.getNode("TRs", move).isVirtual()) {
                            String moveType = new Attack(move).getType().getName();
                            config.getNode("TRs", move, "Type").setValue(moveType);

                            config.getNode("TRs", move, "Number").setValue(num);
                            ConfigManager.save();
                            sender.sendMessage(Text.of(TextColors.GREEN, "Successfully created a new TR of the move " + move + "!"));
                        } else {
                            sender.sendMessage(Text.of(TextColors.RED, "A move by this name already exists in the config!"));
                        }
                    }

                    return CommandResult.success();

                })
                .build();

        CommandSpec makeHM = CommandSpec.builder()
                .arguments(
                        GenericArguments.integer(Text.of("number")),
                        GenericArguments.remainingJoinedStrings(Text.of("move"))
                )
                .executor((sender, context) -> {

                    config = ConfigManager.getConfigFile(2);

                    String move = context.getOne("move").get().toString();
                    int num = (int) context.getOne("number").get();

                    if (Attack.hasAttack(move)) {
                        if (config.getNode("HMs", move).isVirtual()) {
                            String moveType = new Attack(move).getType().getName();
                            config.getNode("HMs", move, "Type").setValue(moveType);

                            config.getNode("HMs", move, "Number").setValue(num);
                            ConfigManager.save();
                            sender.sendMessage(Text.of(TextColors.GREEN, "Successfully created a new HM of the move " + move + "!"));
                        } else {
                            sender.sendMessage(Text.of(TextColors.RED, "A move by this name already exists in the config!"));
                        }
                    }



                    return CommandResult.success();

                })
                .build();

        CommandSpec giveHM = CommandSpec.builder()
                .arguments(
                        GenericArguments.player(Text.of("player")),
                        GenericArguments.remainingJoinedStrings(Text.of("move"))
                )
                .executor((sender, context) -> {

                    Player player = (Player) context.getOne("player").get();
                    String move = context.getAll("move").toString();

                    ItemCreator.giveHM(player, move);

                    return CommandResult.success();
                })
                .build();

        CommandSpec giveTM = CommandSpec.builder()
                .arguments(
                        GenericArguments.player(Text.of("player")),
                        GenericArguments.remainingJoinedStrings(Text.of("move"))
                )
                .executor((sender, context) -> {

                    Player player = (Player) context.getOne("player").get();
                    String move = context.getAll("move").toString();

                    ItemCreator.giveTM(player, move);

                    return CommandResult.success();
                })
                .build();

        CommandSpec giveTR = CommandSpec.builder()
                .arguments(
                        GenericArguments.player(Text.of("player")),
                        GenericArguments.remainingJoinedStrings(Text.of("move"))
                )
                .executor((sender, context) -> {

                    Player player = (Player) context.getOne("player").get();
                    String move = context.getAll("move").toString();

                    ItemCreator.giveTR(player, move);

                    return CommandResult.success();
                })
                .build();


        CommandSpec main = CommandSpec.builder()
                .permission("tmfactory.command.admin")
                .child(giveHM, "givehm")
                .child(giveTM, "givetm")
                .child(giveTR, "givetr")
                .child(makeTM, "maketm")
                .child(makeTR, "maketr")
                .child(makeHM, "makehm")
                .executor((sender, context) -> {

                    Player player = (Player) sender;
                    return CommandResult.success();

                })
                .build();

        Sponge.getCommandManager().register(TMFactory.instance, main, "tmfactory");

    }

}
