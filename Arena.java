public class Arena {
    public void fight(Player player1, Player player2) {
        while (player1.isAlive() && player2.isAlive()) {
            if (player1.getHealth() < player2.getHealth()) {
                attack(player1, player2);
            } else {
                attack(player2, player1);
            }
        }

        if (player1.isAlive()) {
            System.out.println("Player 1 wins with health: " + player1.getHealth());
        } else {
            System.out.println("Player 2 wins with health: " + player2.getHealth());
        }
    }

    private void attack(Player attacker, Player defender) {
        int attackDamage = attacker.rollAttackDice();
        int defendDamage = defender.rollDefendDice();
        int damageDealt = Math.max(0, attackDamage - defendDamage);
        defender.takeDamage(damageDealt);
        System.out.println("Attacker dealt " + damageDealt + " damage, defender health: " + defender.getHealth());
    }
}

