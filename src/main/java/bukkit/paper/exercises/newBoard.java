package bukkit.paper.exercises;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

public class newBoard {

private Player player;

    public newBoard (Player player) {
        this.player = player;
    }

    public void createBoard() {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        org.bukkit.scoreboard.Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("Exercises-1", "dummy",
                ChatColor.BLUE + "" + ChatColor.BOLD + "Gingerbread Server");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score0 = obj.getScore(ChatColor.RESET.toString());
        score0.setScore(9);
        Score score1 = obj.getScore(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Players");
        score1.setScore(8);
        Score score2 = obj.getScore(String.valueOf(Bukkit.getOnlinePlayers().size()));
        score2.setScore(7);
        Score score3 = obj.getScore(ChatColor.RESET.toString());
        score3.setScore(6);
        Score score4 = obj.getScore(ChatColor.GREEN + "" + ChatColor.BOLD + "Kills");
        score4.setScore(5);
        Score score5 = obj.getScore(String.valueOf(player.getStatistic(Statistic.PLAYER_KILLS)));
        score5.setScore(4);
        Score score6 = obj.getScore(ChatColor.RESET.toString());
        score6.setScore(3);
        Score score7 = obj.getScore(ChatColor.RED + "" + ChatColor.BOLD + "Deaths");
        score7.setScore(2);
        Score score8 = obj.getScore(String.valueOf(player.getStatistic(Statistic.DEATHS)));
        score8.setScore(1);

        player.setScoreboard(board);



    }
}
