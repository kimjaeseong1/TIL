package com.example.coin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
@MapperScan(value= {"com.example.coin.mapper"})
public class CoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinApplication.class, args);
	}
	public String[] solution(String[] players, String[] callings) {
		String[] answer = new String[players.length];
		HashMap<String, Integer> mappedByPlayer = new HashMap<>();
		HashMap<Integer, String> mappedByRank = new HashMap<>();

		for (int i = 0; i < players.length; i++) {
			mappedByPlayer.put(players[i], i);
			mappedByRank.put(i, players[i]);
		}

		for (int i = 0; i < callings.length; i++) {

			int currentRank = mappedByPlayer.get(callings[i]);
			String player = mappedByRank.get(currentRank);

			String frontPlayer = mappedByRank.get(currentRank - 1);

			mappedByPlayer.put(player, currentRank - 1);
			mappedByPlayer.put(frontPlayer, currentRank);

			mappedByRank.put(currentRank - 1, player);
			mappedByRank.put(currentRank, frontPlayer);
		}

		for (int i = 0; i < players.length; i++) {
			answer[i] = mappedByRank.get(i);
		}
		return answer;
	}

}
