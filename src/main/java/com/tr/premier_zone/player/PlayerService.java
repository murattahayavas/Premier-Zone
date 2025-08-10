package com.tr.premier_zone.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {

    private final PlayerRepository playerRepository;


    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;

    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersFromTeam(String teamName) {
        return playerRepository.findAll().stream().filter(player -> teamName.equals(player.getTeam())).collect(Collectors.toList());

    }

    public List<Player> getPlayersByName(String name){
    return playerRepository.findAll().stream().filter(player -> player.getPlayerName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());}

    public List<Player> getPlayersByPosition(String position){
        return playerRepository.findAll().stream().filter(player -> player.getPosition().toLowerCase().contains(position.toLowerCase())).collect(Collectors.toList());
    }

    public List<Player> getPlayersByNationality(String nationality){
        return playerRepository.findAll().stream().filter(player -> player.getNationality().toLowerCase().contains(nationality.toLowerCase())).collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeamandPosition(String team, String position){
        return playerRepository.findAll().stream().filter(player -> team.equals(player.getTeam()) && position.equals(player.getPosition())).collect(Collectors.toList());
    }

    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }


    public Player updatePlayer(Player updatedplayer) {
        Optional<Player> existingPlayer= playerRepository.findByName(updatedplayer.getPlayerName());

        if (existingPlayer.isPresent()) {
            Player playertoupdate = existingPlayer.get();
            playertoupdate.setPlayerName(updatedplayer.getPlayerName());
            playertoupdate.setTeam(updatedplayer.getTeam());
            playertoupdate.setPosition(updatedplayer.getPosition());
            playertoupdate.setNationality(updatedplayer.getNationality());
            playerRepository.save(playertoupdate);
            return playertoupdate;
        }
        return null;
    }
    @Transactional
    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }

}
