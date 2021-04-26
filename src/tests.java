import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class tests {
	player test_player;
	enemy test_enemy;
	
	@BeforeEach
	void setUp() throws Exception {
		test_player = new player();
		test_enemy = new enemy();
	}
	
	@Test
	void player_attack() {
		
	}

}
