package net.rerenderreality.command;

import net.rerenderreality.main.RRRP2;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.util.command.args.CommandContext;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;

public class HelloWorldCommand implements CommandCallable
{	
	private Logger logger;
	private RRRP2 plugin;
	
	public HelloWorldCommand(RRRP2 plugin)
	{
		this.plugin = plugin;
		logger = plugin.getLogger();
	}
	
	/**
	 * To be executed on command use
	 */
	@Override
	public CommandResult process(CommandSource src, String args) throws CommandException
	{	
		String[] a = args.split(" ");
		
		if (src instanceof Player)
		{
			Player p = (Player) src;
			p.sendMessage(Texts.of("HELLO WORLD"));
			return CommandResult.success();
		}
		return null;
	}
	
	private final Text usage = Texts.builder("Usage: /Hello or /HelloWorld or /Hi").color(TextColors.YELLOW).build();
	private final Text help = Texts.builder("Help: /Hello or /HelloWorld or /Hi").color(TextColors.YELLOW).build();
	private final Text description = Texts.builder("Hello World Test Command").color(TextColors.YELLOW).build();
	private List<String> suggestions = new ArrayList<String>();
	private String permission = "";
	
	@Override
	public Text getUsage(CommandSource sender) { return usage; }
	@Override
	public Optional<Text> getHelp(CommandSource sender) { return Optional.of(help); }
	@Override
	public Optional<Text> getShortDescription(CommandSource sender) { return Optional.of(description); }
	@Override
	public List<String> getSuggestions(CommandSource sender, String args) throws CommandException { return suggestions; }
	@Override
	public boolean testPermission(CommandSource sender) { return permission.equals("") ? true : sender.hasPermission(permission); }
}