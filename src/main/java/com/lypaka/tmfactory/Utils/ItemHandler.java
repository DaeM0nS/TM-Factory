package com.lypaka.tmfactory.Utils;

import com.lypaka.tmfactory.Config.ConfigManager;
import com.pixelmongenerations.api.def.MoveContainer;
import com.pixelmongenerations.common.battle.attacks.Attack;
import com.pixelmongenerations.common.entity.pixelmon.EntityPixelmon;
import com.pixelmongenerations.core.Pixelmon;
import com.pixelmongenerations.core.data.pokemon.PokemonRegistry;
import com.pixelmongenerations.core.network.EnumUpdateType;
import com.pixelmongenerations.core.network.packetHandlers.OpenReplaceMoveScreen;
import com.pixelmongenerations.core.storage.PixelmonStorage;
import com.pixelmongenerations.core.storage.PlayerStorage;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ninja.leaping.configurate.ConfigurationNode;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.InteractEntityEvent;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemHandler {

    ResultSet rs;
    private static EntityPixelmon pokemonFromEvent;
    private static Player playerFromEvent;
    private static String moveFromEvent;
    private static ConfigurationNode config;

    @Listener
    public void onUse (InteractEntityEvent.Secondary.MainHand event, @Root Player player) throws SQLException {
        if (event.getTargetEntity() instanceof EntityPixelmon) {
            EntityPixelmon pokemon = (EntityPixelmon) event.getTargetEntity();
            if (pokemon.hasOwner()) {
                if (pokemon.getOwnerId().toString().equals(player.getUniqueId().toString())) {
                    if (player.getItemInHand(HandTypes.MAIN_HAND).get().get(Keys.DISPLAY_NAME).toString().contains("HM")) {
                        event.setCancelled(true);
                        String[] moveSplit = player.getItemInHand(HandTypes.MAIN_HAND).get().get(Keys.DISPLAY_NAME).toString().split(": ");
                        Attack attack = new Attack(Attack.getAttackBase(moveSplit[1].replace("}]", "")).get().attackIndex, moveSplit[1], rs);
                        if (!pokemon.getMoveset().toString().contains(attack.baseAttack.getUnlocalizedName()) && canLearnMove(pokemon, attack.baseAttack.getUnlocalizedName())) {
                            if (pokemon.getMoveset().size() < 4) {
                                pokemon.getMoveset().add(attack);
                                pokemon.update(EnumUpdateType.Moveset);
                                player.getItemInHand(HandTypes.MAIN_HAND).get().setQuantity(player.getItemInHand(HandTypes.MAIN_HAND).get().getQuantity() - 1);
                                player.sendMessage(Text.of("Your Pokemon learned " + attack.baseAttack.getUnlocalizedName() + "!"));
                            } else {
                                Pixelmon.NETWORK.sendTo(new OpenReplaceMoveScreen(player.getUniqueId(), pokemon.getPokemonId(), attack.baseAttack.attackIndex, 0, pokemon.getLvl().getLevel()), (EntityPlayerMP) player);
                                setPokemon(pokemon);
                                setPlayer(player);
                                setMove(attack.baseAttack.getUnlocalizedName());
                            }
                        } else {
                            player.sendMessage(Text.of("The Pokemon refuses to learn this move!"));
                        }

                    // Pixelmon actually has items named "TM" and "TR" so checking for those is a little more difficult
                    } else if (isCustomTM(player.getItemInHand(HandTypes.MAIN_HAND).get())) {
                        event.setCancelled(true);
                        String[] moveSplit = player.getItemInHand(HandTypes.MAIN_HAND).get().get(Keys.DISPLAY_NAME).toString().split(": ");
                        Attack attack = new Attack(Attack.getAttackBase(moveSplit[1].replace("}]", "")).get().attackIndex, moveSplit[1], rs);
                        if (!pokemon.getMoveset().toString().contains(attack.baseAttack.getUnlocalizedName()) && canLearnMove(pokemon, attack.baseAttack.getUnlocalizedName())) {
                            if (pokemon.getMoveset().size() < 4) {
                                pokemon.getMoveset().add(attack);
                                pokemon.update(EnumUpdateType.Moveset);
                                player.getItemInHand(HandTypes.MAIN_HAND).get().setQuantity(player.getItemInHand(HandTypes.MAIN_HAND).get().getQuantity() - 1);
                                player.sendMessage(Text.of("Your Pokemon learned " + attack.baseAttack.getUnlocalizedName() + "!"));
                            } else {
                                Pixelmon.NETWORK.sendTo(new OpenReplaceMoveScreen(player.getUniqueId(), pokemon.getPokemonId(), attack.baseAttack.attackIndex, 0, pokemon.getLvl().getLevel()), (EntityPlayerMP) player);
                                setPokemon(pokemon);
                                setPlayer(player);
                                setMove(attack.baseAttack.getUnlocalizedName());
                            }
                        } else {
                            player.sendMessage(Text.of("The Pokemon refuses to learn this move!"));
                        }
                    } else if (isCustomTR(player.getItemInHand(HandTypes.MAIN_HAND).get())) {
                        event.setCancelled(true);
                        String[] moveSplit = player.getItemInHand(HandTypes.MAIN_HAND).get().get(Keys.DISPLAY_NAME).toString().split(": ");
                        Attack attack = new Attack(Attack.getAttackBase(moveSplit[1].replace("}]", "")).get().attackIndex, moveSplit[1], rs);
                        if (!pokemon.getMoveset().toString().contains(attack.baseAttack.getUnlocalizedName()) && canLearnMove(pokemon, attack.baseAttack.getUnlocalizedName())) {
                            if (pokemon.getMoveset().size() < 4) {
                                pokemon.getMoveset().add(attack);
                                pokemon.update(EnumUpdateType.Moveset);
                                player.getItemInHand(HandTypes.MAIN_HAND).get().setQuantity(player.getItemInHand(HandTypes.MAIN_HAND).get().getQuantity() - 1);
                                player.sendMessage(Text.of("Your Pokemon learned " + attack.baseAttack.getUnlocalizedName() + "!"));
                            } else {
                                Pixelmon.NETWORK.sendTo(new OpenReplaceMoveScreen(player.getUniqueId(), pokemon.getPokemonId(), attack.baseAttack.attackIndex, 0, pokemon.getLvl().getLevel()), (EntityPlayerMP) player);
                                setPokemon(pokemon);
                                setPlayer(player);
                                setMove(attack.baseAttack.getUnlocalizedName());
                            }
                        } else {
                            player.sendMessage(Text.of("The Pokemon refuses to learn this move!"));
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onGUIClose (PlayerContainerEvent.Close event) {
        Player player = (Player) event.getEntityPlayer();

        try {
            if (getPlayer().getName().equals(player.getName())) {
                if (event.getContainer().toString().contains("net.minecraft.inventory.ContainerPlayer")) {
                    PlayerStorage party = PixelmonStorage.pokeBallManager.getPlayerStorage((EntityPlayerMP) event.getEntityPlayer()).get();
                    for (int i = 0; i <= party.count(); i++) {
                        if (party.getPokemon(party.getIDFromPosition(i), (World) player.getWorld()) != null) {
                            if (party.getPokemon(party.getIDFromPosition(i), (World) player.getWorld()) == getPokemon()) {
                                EntityPixelmon playerPoke = party.getPokemon(party.getIDFromPosition(i), (World) player.getWorld());
                                if (playerPoke.getMoveset().hasAttack(getMove())) {
                                    player.getItemInHand(HandTypes.MAIN_HAND).get().setQuantity(player.getItemInHand(HandTypes.MAIN_HAND).get().getQuantity() - 1);
                                }
                            }
                        }
                    }
                }
            }
        } catch (NullPointerException er) {
            // This is just here so the plugin doesn't shit itself when closing other GUIs from other things and stuff
        }
    }


    private boolean canLearnMove (EntityPixelmon pokemon, String move) {
        MoveContainer moves = PokemonRegistry.getBaseFor(pokemon.getPokemonName()).moves;
        return moves.tutorMoves.toString().contains(move) || moves.tmTRMoves.toString().contains(move) || moves.levelMoves.toString().contains(move) || moves.evolutionMoves.toString().contains(move) || moves.eggMoves.toString().contains(move);
    }


    private boolean isCustomTM (ItemStack is) {
        config = ConfigManager.getConfigFile(0);
        String[] name = is.get(Keys.DISPLAY_NAME).toString().split(": ");

        return config.getNode("TMs").getString().contains(name[1].replace("}]", ""));
    }

    private boolean isCustomTR (ItemStack is) {
        config = ConfigManager.getConfigFile(1);
        String[] name = is.get(Keys.DISPLAY_NAME).toString().split(": ");

        return config.getNode("TRs").getString().contains(name[1].replace("}]", ""));
    }

    private static void setPokemon (EntityPixelmon poke) {
        ItemHandler.pokemonFromEvent = poke;
    }

    private static EntityPixelmon getPokemon() {
        return ItemHandler.pokemonFromEvent;
    }

    private static void setPlayer (Player player) {
        ItemHandler.playerFromEvent = player;
    }

    private static Player getPlayer() {
        return ItemHandler.playerFromEvent;
    }

    private static void setMove (String move) {
        ItemHandler.moveFromEvent = move;
    }

    private static String getMove() {
        return ItemHandler.moveFromEvent;
    }
}
