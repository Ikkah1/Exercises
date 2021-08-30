package bukkit.paper.exercises;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class CommandSwordGive implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // create sword
            ItemStack goldenSword = new ItemStack(Material.GOLDEN_SWORD, 1);
            // make meta (information holder) for sword
            ItemMeta goldenSwordMeta = goldenSword.getItemMeta();
            // change attack damage
            goldenSwordMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(
                    "generic.AttackDamage", 10, AttributeModifier.Operation.ADD_NUMBER));
            // change name
            goldenSwordMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Butter Knife");
            // add lore
            ArrayList<String> goldenSwordLore = new ArrayList<>();
            goldenSwordLore.add("&a");
            goldenSwordLore.add(ChatColor.YELLOW + "dont use me bitch");
            goldenSwordMeta.setLore(goldenSwordLore);
            // add enchants
            goldenSwordMeta.addEnchant(Enchantment.THORNS, 10, true);
            goldenSwordMeta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
            goldenSwordMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
            // attach meta to sword
            goldenSword.setItemMeta(goldenSwordMeta);
            // give sword to player
            ((Player)sender).getInventory().addItem(goldenSword);
        }
        return true;
    }
}
