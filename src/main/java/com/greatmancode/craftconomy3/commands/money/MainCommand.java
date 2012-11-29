/*
 * This file is part of Craftconomy3.
 *
 * Copyright (c) 2011-2012, Greatman <http://github.com/greatman/>
 *
 * Craftconomy3 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Craftconomy3 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Craftconomy3.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.greatmancode.craftconomy3.commands.money;

import java.util.Iterator;

import com.greatmancode.craftconomy3.Common;
import com.greatmancode.craftconomy3.account.Account;
import com.greatmancode.craftconomy3.account.Balance;
import com.greatmancode.craftconomy3.commands.interfaces.CraftconomyCommand;

public class MainCommand extends CraftconomyCommand {

	@Override
	public void execute(String sender, String[] args) {
		Common.getInstance().getServerCaller().sendMessage(sender, Common.getInstance().getLanguageManager().getString("money_all_title"));
		Account account = Common.getInstance().getAccountManager().getAccount(sender);
		Iterator<Balance> balanceList = account.getAllWorldBalance(account.getWorldPlayerCurrentlyIn()).iterator();
		while (balanceList.hasNext()) {
			Balance bl = balanceList.next();
			Common.getInstance().getServerCaller().sendMessage(sender, Common.getInstance().format(bl.getWorld(), bl.getCurrency(), bl.getBalance()));
		}
	}

	@Override
	public String help() {
		return Common.getInstance().getLanguageManager().getString("money_main_cmd_help");
	}

	@Override
	public int maxArgs() {
		return 0;
	}

	@Override
	public int minArgs() {
		return 0;
	}

	@Override
	public boolean playerOnly() {
		return true;
	}

	@Override
	public String getPermissionNode() {
		return "craftconomy.money.balance";
	}

}
